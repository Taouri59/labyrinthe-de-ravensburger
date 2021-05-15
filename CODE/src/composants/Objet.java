package composants;

/**
 * 
 * Cette classe permet de représenter chacun des objets du jeu.
 *
 */
public class Objet {

	private int numObjet; // Le numéro de l'objet (un entier entre 0 et 17).
	private int posLignePlateau; // La ligne du plateau sur laquelle est éventuellement posé l'objet (un entier entre -1 et 6, -1:lorsqu'il n'est pas sur le plateau).
	private int posColonnePlateau; // La colonne du plateau sur laquelle est éventuellement posé l'objet (un entier entre -1 et 6, -1:lorsqu'il n'est pas sur le plateau).
	private boolean surPlateau; // Indique si l'objet est sur le plateau ou non (true : sur le plateau, false : hors du plateau).

	/**
	 * 
	 * A Faire (15/05/21 MP Finalisée)
	 * 
	 * Constructeur permettant de construire un objet qui est initialement hors du plateau.
	 * 
	 * @param numObjet Le numéro de l'objet.
	 */

	public Objet(int numObjet) {
		this.numObjet = numObjet;
		this.posLignePlateau = -1;
		this.posColonnePlateau = -1;
		this.surPlateau = false ;
	}

	/**
	 * 
	 * A Faire A Faire (15/05/21 MP a finir )
	 * 
	 * Méthode permettant de générer un tableau contenant les 18 objets du jeu.
	 * Les objets seront postionnées aléatoirement sur le plateau.  Deux objets ne pourront pas être sur une même case (même ligne et même colonne).
	 * 
	 * @return Un tableau de 18 objets initialisés pour une partie du jeu. Chaque objet a une position générée aléatoirement. Les positions sont différentes pour deux objets distincts.
	 *
	 */
	public static Objet[] nouveauxObjets(){
		Objet[] objets = new Objet[18];
		int numLigne=0;
		int numColonne=0;
		int [] ligne=Utils.genereTabIntAleatoirement(6);
		int[] colonne=Utils.genereTabIntAleatoirement(6);
		for (int objet=0;objet<17;objet++){
			objets[objet]= new Objet(objet);
			//objets[objet].posLignePlateau=ligne[objet];
			//objets[objet].posColonnePlateau=colonne[objet];
			objets[objet].positionneObjet(ligne[objet],colonne[objet]);


		}
		return objets;
	}


	/**
	 * 
	 * A Faire (15/05/21 MP Finalisée)
	 * 
	 * Méthode retournant le numéro de l'objet.
	 * 
	 * @return Le numéro de l'objet.
	 */
	public int getNumObjet() {
		return numObjet;
	}

	/**
	 * 
	 * A Faire (15/05/21 MP Finalisée)
	 * 
	 * Méthode retournant le numéro de la ligne sur laquelle se trouve l'objet.
	 * 
	 * @return Le numéro de la ligne sur laquelle se trouve l'objet.
	 */
	public int getPosLignePlateau() {
		return posLignePlateau;
	}

	/**
	 * 
	 * A Faire (15/05/21 MP Finalisée)
	 * 
	 * Méthode retournant le numéro de la colonne sur laquelle se trouve l'objet.
	 * 
	 * @return Le numéro de la colonne sur laquelle se trouve l'objet.
	 */
	public int getPosColonnePlateau() {
		return posColonnePlateau;
	}

	/**
	 * 
	 * A Faire (15/05/21 MP Finalisée)
	 * 
	 * Méthode permettant de positionner l'objet sur une ligne et une colonne données en paramètre.
	 * 
	 * @param lignePlateau Un entier compris entre 0 et 6.
	 * @param colonnePlateau Un entier compris entre 0 et 6.
	 */
	public void positionneObjet(int lignePlateau,int colonnePlateau){
		this.posLignePlateau= lignePlateau;
		this.posColonnePlateau= colonnePlateau;
		if(this.posLignePlateau!=-1 && this.posColonnePlateau!=-1){
			this.surPlateau=true;
		}
	}

	/**
	 * 
	 * A Faire (15/05/21 MP Finalisée)
	 * 
	 * Méthode permettant d'enlever l'objet du plateau.
	 * 
	 */
	public void enleveDuPlateau(){
		  this.posLignePlateau=-1;
		  this.posColonnePlateau=-1;
		  this.surPlateau=false;



	}
	
	/**
	 * 
	 * A Faire (15/05/21 MP Finalisée)
	 * 
	 * Méthode indiquant si l'objet est sur le plateau au non.
	 * 
	 * @return true si l'objet est sur le plateau, false sinon.
	 */
	public boolean surPlateau() {
		return this.surPlateau();


	}

	/**
	 * A Faire (15/05/21 MP Finalisée)
	 * Méthode permettant d'obtenir une représentation d'un objet sous forme de chaîne de caractères.
	 */
	@Override
	public String toString() {
		return "Objet [numObjet=" + numObjet + ", posLignePlateau=" + posLignePlateau + ", posColonnePlateau="
				+ posColonnePlateau + ", surPlateau=" + surPlateau + "]";
	}

	/**
	 * A Faire (15/05/21 MP Finalisée)
	 * Méthode permettant de copier l'objet.
	 * 
	 * @return Une copie de l'objet.
	 */
	public Objet copy(){
		Objet objet = new Objet(numObjet);
		objet.posLignePlateau=posLignePlateau;
		objet.posColonnePlateau=posColonnePlateau;
		objet.surPlateau=surPlateau;
		return objet;
	}

	/**
	 * A Faire (15/05/21 MP Finalisée)
	 * Programme testant quelques méthodes de la classe Objet.
	 * @param args arguments du programme
	 */
	public static void main(String[] args) {
		// Un petit test ...
		System.out.println("*** Génération et affichage des 18 objets ... ***");
		Objet[] objetsJeu = nouveauxObjets();
		for (int i=0;i<objetsJeu.length;i++)
			System.out.println(objetsJeu[i]);
		System.out.println("*** On enlève les 18 objets du plateau ... ***");
		for (int i=0;i<objetsJeu.length;i++)
			 objetsJeu[i].enleveDuPlateau();
		System.out.println("*** On affiche de nouveau les 18 objets ... ***");
		for (int i=0;i<objetsJeu.length;i++)
			System.out.println(objetsJeu[i]);
	}
	
}
