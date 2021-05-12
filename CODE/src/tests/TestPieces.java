package tests;
;

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
        Piece[] terrain=Piece.nouvellesPieces();
        int n=0; //compteur
        for (int i=0;i<7;i++){
            for(int j=0;j<7;j++){
                Piece piece= terrain[n];
                IG.changerPiecePlateau(i,j,piece.getModelePiece(),piece.getOrientationPiece());
                n++;

            }
        }
        IG.changerPieceHorsPlateau(terrain[49].getModelePiece(),terrain[49].getOrientationPiece());
        IG.miseAJourAffichage();

        for (int y =0;y<4;y++){
            n=0;
            IG.attendreClic();
            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 7; j++) {
                    terrain[n].rotation();
                    IG.changerPiecePlateau(i, j,terrain[n].getModelePiece(),terrain[n].getOrientationPiece());
                    n++;
                }
            }
            terrain[49].rotation();
            IG.changerPieceHorsPlateau(terrain[49].getModelePiece(),terrain[49].getOrientationPiece());
            System.out.println(terrain[49]);

            IG.miseAJourAffichage();

        }
        IG.attendreClic();
        IG.fermerFenetreJeu();



    }
}
