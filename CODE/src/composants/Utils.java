package composants;

import java.util.Date;
import java.util.Random;

/**
 *
 * Classe contenant quelques fonctions utilitaires.
 *
 */
public class Utils {

    private static Random generateur=new Random((new Date().getTime()));

    /**
     * A Faire (27/04/2021 MC Finie)
     *
     * Méthode permettant de générer aléatoirement un nombre entier.
     *
     * @param max Le nombre entier maximal pouvant être retourné.
     * @return Un nombre entier compris entre 0 et max (inclus).
     */
    public static int genererEntier(int max){
        return generateur.nextInt(max+1);
    }
    /**
     * A Faire (27/04/2021 MC Finie)
     *
     * Méthode permettant de savoir si oui ou non l'entier n donnée en paramétre est dans le tableau d'entier
     * tab donnée en paramètre.
     *
     * @param n L'entier pour lequel on veut savoir si il est dans le tableau tab.
     * @param tab Un tableau d'entier.
     * @return Un boolean qui vaut true si n est dans le tableau et false sinon.
     */
    private static boolean nIsInTab(int[] tab, int n) {
        for (int x : tab) {
            if (x==n) {
                return true;
            }
        }
        return false;
    }
    /**
     * A Faire (27/04/2021 MC Finie)
     *
     * Méthode permettant de générer un tableau d'entiers dont la longueur longTab est donnée en paramétre.
     * Le tableau généré doit contenir chaque entier compris entre 0 et longTab-1. La position de ces entiers
     * dans le tableau doit être aléatoire.
     *
     * @param longTab La longueur du tableau.
     * @return Un tableau contenant les entiers 0,...,longTab-1 placés aléatoirement dans le tableau.
     */
    public static int[] genereTabIntAleatoirement(int longTab){
        int[] tab = new int[longTab];
        int nbElem = 0;
        boolean addZero = true;
        while (nbElem<longTab) {
            int n = genererEntier(longTab-1);
            if (addZero && n==0) {
                nbElem++;
                addZero=false;
            }
            if (!nIsInTab(tab,n)) {
                tab[nbElem] = n;
                nbElem++;
            }
        }
        return tab;
    }
    /**
     * Programme testant la méthode genereTabIntAleatoirement.
     * @param args arguments du programme
     */
    public static void main(String[] args) {
        // Un petit test ...
        int tab[]=genereTabIntAleatoirement(18);
        for (int i=0;i<tab.length;i++)
            System.out.print(tab[i]+" ");

    }

}