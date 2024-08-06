/**
 *ITI 1521 - Introduction à l’informatique II
 *@author ZHOR SEBBANI, Université d'Ottawa/University of Ottawa
 * 
 */


public class Operation {

    private int x, y;  //nombres aleatoires pour l'operation arithmetique
    private int rand;  //nombre aleatoire = 0 pour l'addition et 1 pour la multiplication

    public Operation() { // constructor
        // Génèrer deux entiers positifs aléatoires entre 0 et 9 (inclusivement) 
        x = (int)(Math.random() * 10); 
        y = (int)(Math.random() * 10);
        rand = (int)(Math.random() * 2); // Génère un entier positif aléatoire entre 0 et 1 (inclusivement) 
    }

    public String getQuestion0() {
        return "Quelle est la valeur de " + x + " + " + y + " ?";
    }

    public String getQuestion1() {
        return "Quelle est la valeur de " + x + " * " + y + " ?";
    }
    public int getAddition() {
        return x + y;
    }
    public int getProduct() {
        return x*y;
    }
     public int getRand() {
        return rand;
    }
}
