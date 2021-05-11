package tests;

import composants.Piece;
import grafix.interfaceGraphique.IG;

public class TestPieces {

    public static void main(String[] args) {
        //création de la fenêtre de jeu
        Object[] parametres = IG.saisirParametres();
        int nbJoueurs = (Integer)parametres[0];
        IG.creerFenetreJeu("Démo Librairie IG version 1.9", nbJoueurs);
        //initialisation des messages
        String[] message = new String[]{"", "", "", ""};
        message[0] = "";
        message[1] = "";
        message[2] = "Cliquez pour continuer ... ";
        message[3] = "";
        IG.afficherMessage(message);
        IG.rendreVisibleFenetreJeu();
        IG.attendreClic();
        //Insertion des pièces avec la méthode nouvellesPieces
        Piece.nouvellesPieces();
        IG.miseAJourAffichage();
        IG.attendreClic();
    }
}
