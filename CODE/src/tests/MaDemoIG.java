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
            int numImageJoueur0 = (Integer)parametres[3];
            String nomJoueur0 = (String)parametres[1];
            String categorieJoueur0 = (String)parametres[2];
            IG.changerNomJoueur(0, nomJoueur0 + " (" + categorieJoueur0 + ")");
            IG.changerImageJoueur(0, numImageJoueur0);

            IG.rendreVisibleFenetreJeu();

        }
    }