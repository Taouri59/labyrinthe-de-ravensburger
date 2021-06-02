package partie;

import composants.Objet;
import composants.Piece;
import composants.Plateau;
import grafix.interfaceGraphique.IG;
import joueurs.Joueur;
import joueurs.JoueurOrdinateur;

public class Partie {
	static double version=0.0;


	private ElementsPartie elementsPartie; // Les éléments de la partie.

	/**
	 * 
	 * A Faire (Quand Qui Statut)
	 * 
	 * Constructeur permettant de créer et d'initialiser une nouvelle partie.
	 */
	public Partie(){
		// Initialisation de la partie
		parametrerEtInitialiser();

		// On affiche l'ensemble des éléments
		Joueur[] joueurs=elementsPartie.getJoueurs();
		//placement des joueurs
		for (Joueur joueur : joueurs) {
			IG.changerNomJoueur(joueur.getNumJoueur(),joueur.getNomJoueur()+" ("+joueur.getCategorie()+")");
			IG.changerImageJoueur(joueur.getNumJoueur(),joueur.getNumeroImagePersonnage());
			IG.placerJoueurSurPlateau(joueur.getNumJoueur(),joueur.getPosLigne(),joueur.getPosColonne());
		}
		//placement des objets sur le plateau
		for (Objet objet : elementsPartie.getObjets()){
			IG.placerObjetPlateau(objet.getNumObjet(),objet.getPosLignePlateau(),objet.getPosColonnePlateau());
		}
		//placement des pieces du plateau
		for (int i=0; i<7; i++) {
			for (int j=0; j<7; j++) {
				Piece piece = elementsPartie.getPlateau().getPiece(i,j);
				IG.changerPiecePlateau(i,j,piece.getModelePiece(),piece.getOrientationPiece());
			}
		}
		IG.changerPieceHorsPlateau(elementsPartie.getPieceLibre().getModelePiece(),elementsPartie.getPieceLibre().getOrientationPiece());
		//creation et affichage du message : cliquez pour continuer
		String[] message = new String[]{"", "", "", ""};
		message[0] = "";
		message[1] = "";
		message[2] = "Cliquez pour commencer ... ";
		message[3] = "";
		IG.afficherMessage(message);

		IG.rendreVisibleFenetreJeu();
	}

	/**
	 * Méthode permettant de paramètrer et initialiser les éléments de la partie.
	 */
	private void parametrerEtInitialiser(){
		// Saisie des différents paramètres
		Object parametresJeu[];
		parametresJeu=IG.saisirParametres();
		int nombreJoueurs=((Integer)parametresJeu[0]).intValue();
		IG.creerFenetreJeu("- Version "+version, nombreJoueurs);
		// Création des joueurs
		Joueur joueurs[]=Joueur.nouveauxJoueurs(parametresJeu);
		// Création des éléments de la partie
		elementsPartie=new ElementsPartie(joueurs);
	}


	/**
	 * 
	 * A Faire (Quand Qui Statut)
	 * 
	 * Méthode permettant de lancer une partie.
	 */
	public void lancer(){
		IG.attendreClic();
		int numJoueur=0;
		String[] message = new String[]{"", "", "", ""};
		while (true){
			Joueur joueur = elementsPartie.getJoueurs()[numJoueur];
			// Affichage d'un message disant c'est au tour de quelle joueur
			message[1]="Au tour de "+joueur.getNomJoueur();
			if (joueur.getCategorie()=="Humain"){message[2]="Orienter piece libre";}
			else {message[2]="...";}
			IG.afficherMessage(message);
			IG.miseAJourAffichage();
			// Orientation de la piece libre
			int[] tab = joueur.choisirOrientationEntree(elementsPartie);
			elementsPartie.getPieceLibre().setOrientation(tab[0]);
			//insertion piece
			System.out.println("Choix finie");
			elementsPartie.insertionPieceLibre(tab[1]);
			for (int i=0; i<7; i++){
				for (int j=0; j<7; j++){
					Piece piece = elementsPartie.getPlateau().getPiece(i,j);
					IG.changerPiecePlateau(i,j,piece.getModelePiece(),piece.getOrientationPiece());
				}
			}
			Piece pieceLibre = elementsPartie.getPieceLibre();
			IG.changerPieceHorsPlateau(pieceLibre.getModelePiece(),pieceLibre.getOrientationPiece());
			IG.miseAJourAffichage();
			System.out.println("Insertion finie");
		}

		//IG.fermerFenetreJeu();
		//System.exit(0);
	}

	/**
	 * 
	 * Programme principal permettant de lancer le jeu.
	 * 
	 * @param args Les arguments du programmes.
	 */
	public static void main(String[] args) {
		while(true){
			Partie partie=new Partie();
			partie.lancer();
		}
	}

}
