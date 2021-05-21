package tests;

import composants.Piece;
import composants.Plateau;
import grafix.interfaceGraphique.IG;
import joueurs.Joueur;

public class TestJoueur {
    //main
    public static void main(String[] args) {
        //création de la fenêtre de jeu
        Object[] parametresJeu = IG.saisirParametres();
        int nbJoueurs = (Integer)parametresJeu[0];
        IG.creerFenetreJeu("Démo Librairie IG version 1.9", nbJoueurs);
        Plateau plateau=new Plateau();
        Piece pieceHorsPlateau=plateau.placerPiecesAleatoierment();
        Joueur joueurs[]= Joueur.nouveauxJoueurs(parametresJeu);
        //initialisation des messages
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
