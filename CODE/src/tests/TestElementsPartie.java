package tests;

import composants.Objet;
import composants.Piece;
import grafix.interfaceGraphique.IG;
import joueurs.Joueur;
import partie.ElementsPartie;

public class TestElementsPartie {
    // main
    public static void main(String[] args){
        // initialisation des parametre et des elements de la partie
        Object[] parametresJeu = IG.saisirParametres();
        int  nbJoueurs= ((Integer)parametresJeu[0]).intValue();
        IG.creerFenetreJeu("- TestElementsPartie",nbJoueurs);
        Joueur[] joueurs = Joueur.nouveauxJoueurs(parametresJeu);
        ElementsPartie elementsPartie=new ElementsPartie(joueurs);
        joueurs = elementsPartie.getJoueurs();
        // creation de la fenetre du jeu
        IG.creerFenetreJeu("TestElementsPartie Powered by IGlib24",joueurs.length);
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
        message[2] = "Cliquez pour continuer ... ";
        message[3] = "";
        IG.afficherMessage(message);
        IG.rendreVisibleFenetreJeu();
        IG.attendreClic();
    }
}
