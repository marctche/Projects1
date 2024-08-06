/**********************Q2-Devoir2 ITI1521*********/

class Calculator {
    protected double first, second, resultatFS; // two calculator operands

    // J'ai créé ma propre variable appelé resultatFS pour stocker la valeur de la réponse finale
    private String oP;
    Calculator() {}

    void operation(String str) {
        resultatFS = 0;
        oP = str;
    }

    //J'ai du enlever l'initialisation du first et du second parce que lorsque je testais la calculatrice,
    // mes resultats ne se sauvegardaient pas puisqu'a chaque fois ils etais remis a 0

    void add() { operation("+"); }
    void subtract() { operation("-"); }
    void multiply() { operation("*"); }
    void divide() { operation("/"); }
    void factorial() { operation("FACT"); }
    void pow() { operation("POW"); }
    void rootSquare() { operation("SQRT"); }
    void nepLog() { operation("LN"); }

    // J'ai fais comme l'example dans le code du devoir originale mais je n'ai pas eu a les utiliser

    void compute() {
        switch (oP) {
            case "+":
                resultatFS = first + second;
                break;
            case "-":
                resultatFS = first - second;
                break;
            case "*":
                resultatFS = first * second;
                break;
            case "/":
                if (second != 0) {
                    resultatFS = first / second;
                } else {
                    System.out.println("Erreur: Division par zéro");
                }
                break;
            case "FACT":
                if (first == (int) first && first >= 0) {
                    resultatFS = fact((int) first);
                } else {
                    System.out.println("Erreur: La factorielle est définie seulement pour les entiers non négatifs.");
                }
                break;
            case "POW":
                resultatFS = Math.pow(first, second);
                break;
            case "SQRT":
                resultatFS = Math.sqrt(first);
                break;
            case "LN":
                if (first > 0) {
                    resultatFS = Math.log(first);
                } else {
                    System.out.println("Erreur: Logarithme d'un nombre négatif ou nul");
                }
                break;
            default:
                System.out.println("Opération non reconnue");
        }
        //Dans cette partie j'ai essentielement donné cas par cas ce que chaque opérande a à faire
    }

    private double fact(int n) {
        if (n <= 1) return 1;
        else return n * fact(n-1);
    }

    // Il n'y a pas de methode factorielle fans la bibliothèque de math en Java, donc j'ai créé ma propre fonction appélé fact()

    void clear() {
        first = 0;
        second = 0;
        oP = "";
    }

    // initialise les variables first, second et l'operande.

    double display() {
        return resultatFS;
    }

    // affiche le resultat lorsque la méthode est appelé
}






