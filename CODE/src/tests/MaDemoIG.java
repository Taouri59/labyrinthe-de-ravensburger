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
        String nomJoueur0 = (String)parametres[1];
        String categorieJoueur0 = (String)parametres[2];
        int numImageJoueur0 = (Integer)parametres[3];
        IG.changerNomJoueur(0, nomJoueur0 + " (" + categorieJoueur0 + ")");
        IG.changerImageJoueur(0, numImageJoueur0);
        //Pour le joueur 2
        String nomJoueur1 = (String)parametres[4];
        String categorieJoueur1 = (String)parametres[5];
        int numImageJoueur1 = (Integer)parametres[6];
        IG.changerNomJoueur(1,nomJoueur1 + " (" + categorieJoueur1 + ")");
        IG.changerImageJoueur(1, numImageJoueur1);
        if (nbJoueurs == 3) {
            //Pour le joueur 3
            String nomJoueur2 = (String) parametres[7];
            String categorieJoueur2 = (String) parametres[8];
            int numImageJoueur2 = (Integer) parametres[9];
            IG.changerNomJoueur(2, nomJoueur2 + " (" + categorieJoueur1 + ")");
            IG.changerImageJoueur(2, numImageJoueur2);
        }

        //Positionner les joueurs sur le plateau
        IG.placerJoueurPrecis(0,3,0,1,0);
        IG.placerJoueurPrecis(1,3,6,1,2);
        //Positionner les objets sur le plateau pour 3 joueurs
        int y = 0;
        int x = 0;
        int temp = 0;
        int numJoueur = 0;
        int objet = 0;
        //3 joueurs
        if (nbJoueurs == 3) {
            for (int obj = 0; obj < 6; obj++) {
                IG.changerObjetJoueur(numJoueur, obj, obj);
                IG.placerObjetPlateau(obj, x, y);
                y++;
                objet = obj;
            }
            numJoueur++;
            for (int obj2 = 0; obj2 < 6; obj2++) {
                objet++;
                IG.changerObjetJoueur(numJoueur, objet, obj2);
                IG.placerObjetPlateau(objet, x, y);
                if (obj2 == 0) {
                    x++;
                    y = 0;
                } else
                    y++;
            }
            numJoueur++;
            for (int obj3 = 0; obj3 < 6; obj3++) {
                objet++;
                IG.changerObjetJoueur(numJoueur, objet, obj3);
                IG.placerObjetPlateau(objet, x, y);
                if (obj3 == 1) {
                    x++;
                    y = 0;
                } else
                    y++;
            }
        }
        //2 joueurs
        else{
            for (int obj = 0; obj < 9; obj++) {
                IG.changerObjetJoueur(numJoueur, obj, obj);
                IG.placerObjetPlateau(obj, x, y);
                    if (y>=6) {
                        x++;
                        y=-1;
                    }
                y++;
                objet = obj;
            }
            numJoueur++;
            objet++; //position après le dernier item
            for (int obj2 = 0; obj2 < 9; obj2++) {
                IG.changerObjetJoueur(numJoueur, objet, obj2);
                IG.placerObjetPlateau(objet, x, y);
                if (objet==13) {
                    x++;
                    y=-1;
                }
                y++;
                objet++;
            }
        }
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
        int avant = 0;
        int apres = 2;
        int col = 0;
        int col1 =6;
        int avance = 0;
        int recule = 2;
        int tmp =0;
        x = 0;
        y =0;
        while(incr <5) {
            IG.miseAJourAffichage();
            IG.attendreClic();
            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 7; j++) {
                    IG.changerPiecePlateau(i, j, 2, incr);
                    IG.changerPieceHorsPlateau(1, incr);
                }
            }
            //Déplacement joueurs
            avance++;
            recule--;
            IG.placerJoueurPrecis(0,3,0,1,avance);
            IG.placerJoueurPrecis(1,3,6,1,recule);
            //Gestion billes
            if (avant <= 3 && apres >= 0) {
                IG.placerBilleSurPlateau(3, col, 1, avant, 0);
                IG.placerBilleSurPlateau(3, col1, 1, apres, 0);
                avant++;
                apres--;
            }
            else{
                avant = 0;
                apres = 2;
                col++;
                col1--;
                IG.placerBilleSurPlateau(3, col, 1, avant, 0);
                IG.placerBilleSurPlateau(3, col1, 1, apres, 0);
            }
            //Gestion objets plateau
            IG.changerObjetJoueurAvecTransparence(0,tmp,tmp);
            IG.enleverObjetPlateau(x,y);
            y++;
            tmp++;
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
