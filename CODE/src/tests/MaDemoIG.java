package tests;

import grafix.interfaceGraphique.IG;

public class MaDemoIG {

    public static void main(String[] args) {
        Object[] parametres = IG.saisirParametres();
        int nbJoueurs = (Integer)parametres[0];
        IG.creerFenetreJeu("Démo Librairie IG version 1.9", nbJoueurs);
        for(int i=0; i<7; i++){
            for(int j=0;j<7;j++) {
                IG.changerPiecePlateau(i, j, 2, 0);
            }
        }
        IG.changerPieceHorsPlateau(1, 0);

        //Pour le joueur 1
        int numImageJoueur0 = (Integer)parametres[3];
        String nomJoueur0 = (String)parametres[1];
        String categorieJoueur0 = (String)parametres[2];
        IG.changerNomJoueur(0, nomJoueur0 + " (" + categorieJoueur0 + ")");
        IG.changerImageJoueur(0, numImageJoueur0);

        //Pour le joueur 2
        String nomJoueur1 = (String)parametres[1];
        String categorieJoueur1 = (String)parametres[2];
        int numImageJoueur1 = (Integer)parametres[3];
        IG.changerNomJoueur(1, nomJoueur1 + " (" + categorieJoueur1 + ")");
        IG.changerImageJoueur(1, numImageJoueur1);

        //Positionner les joueurs sur le plateau
        IG.placerJoueurPrecis(0,3,0,1,0);
        IG.placerJoueurPrecis(1,3,6,1,2);

        //Gestion des messages
        String[] message = new String[]{"", "", "", ""};
        message[0] = "";
        message[1] = "Bonjour !";
        message[2] = "Cliquez pour continuer ... ";
        message[3] = "";
        IG.afficherMessage(message);
        IG.rendreVisibleFenetreJeu();
        IG.attendreClic();

        //Rotation des pièces à chaque clics
        int incr=1;
        int avance = 0;
        int recule = 2;
        while(incr <5) {
            IG.miseAJourAffichage();
            IG.attendreClic();
            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 7; j++) {
                    IG.changerPiecePlateau(i, j, 2, incr);
                    IG.changerPieceHorsPlateau(1, incr);
                    //EXEMPLE BILLES
                    //IG.placerBilleSurPlateau(3, 0, 1, 0, 2);
                }
            }
            avance++;
            recule--;
            System.out.println(recule);
            IG.placerJoueurPrecis(0,3,0,1,avance);
            IG.placerJoueurPrecis(1,3,6,1,recule);
            message[0] = "";
            message[1] = "Après le clic " + incr;
            message[2] = "Cliquez pour continuer ... ";
            message[3] = "";
            IG.afficherMessage(message);
            incr++;
        }
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                IG.changerPiecePlateau(i, j, 2, 0);
            }
        }
        IG.changerPieceHorsPlateau(1, 0);
        IG.miseAJourAffichage();

        IG.attendreClic();
        IG.afficherGagnant(numImageJoueur0);
        message[0] = "";
        message[1] = "Cliquez sur une flèche";
        message[2] = "pour quitter !";
        message[3] = "";
        IG.afficherMessage(message);
        IG.miseAJourAffichage();
        int i = IG.attendreChoixEntree();
        IG.selectionnerFleche(i);
        IG.miseAJourAffichage();
        message[0] = "";
        message[1] = "Arrêt du programme";
        message[2] = "dans 2 secondes !";
        message[3] = "";
        IG.afficherMessage(message);
        IG.miseAJourAffichage();
        IG.pause(2000);
        IG.fermerFenetreJeu();
        System.exit(0);

    }
}
