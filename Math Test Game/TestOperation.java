/**********************Q1-Devoir2 ITI1521....*/
/**
 * TestOperation
 */
public class TestOperation {
    
    private static Operation[] questions;  // questions pour le test

    private static int[] reponses;   // r�ponses de l'utilisateur aux questions
    
      
    /**
     * Cr�e le tableau questions de 10 elements
     */
    private static void creezTest() {
        questions = new Operation[10];
        for (int i = 0; i < questions.length; i++) {
            questions[i] = new Operation();
        }
    }

    // créé mes questions une par une avec une loop for


    /**
     * Affiche toutes les questions du test 
     * et obtient les r�ponses de l'utilisateur.
     * Compare la r�ponse de l��l�ve � la bonne r�ponse 
     * (si elles sont diff�rentes, affiche la bonne r�ponse); 
     * les bonnes r�ponses sont compt�es et affich�es � la fin.
     * Les r�ponses sont stock�es dans un tableau, 
     * qui est cr�� dans ce sous-programme.
     *
     * et calcule et affiche une note pour le test. 
     */
    private static void effectuezTest() {
        reponses = new int[10];
        int scoreFinal = 0;

        for (int i = 0; i < questions.length; i++) {
            Operation nouvelleOperation = questions[i];
            String nouvQuestion = (nouvelleOperation.getRand() == 0) ? nouvelleOperation.getQuestion0() : nouvelleOperation.getQuestion1();
            System.out.println("Question " + (i + 1) + ": " + nouvQuestion);
            int reponseUtilisateur = ReadInt.getInt("Votre réponse: ");
            reponses[i] = reponseUtilisateur;

            int bonneReponse = (nouvelleOperation.getRand() == 0) ? nouvelleOperation.getAddition() : nouvelleOperation.getProduct();

            if (reponseUtilisateur == bonneReponse) {
                scoreFinal++;
            } else {
                System.out.println("INCORRECT. La bonne réponse est : " + bonneReponse);
            }
        }
        // Crée un tableau pour stocker les valeurs
        // trouve la reponse et ensuite s'assure que la reponse de l'utilisateur est bonne ou non
        // si oui le score augmente de 1

        // Affiche le score final.
        System.out.println("Vous avez " + scoreFinal + " réponses correctes.");
        int noteFinale = (scoreFinal * 100) / questions.length; // Calcule la note en pourcentage.
        System.out.println("Votre note pour ce test est : " + noteFinale + "%");
    }

    // lorsqu'il n'y a plus de place dans le tableau, on affiche le pourcentage et le nombre de bonnre reponses




    /*
     * Programme principal main
     */ 
    public static void main(String[] args) {
        System.out.println();
        System.out.println("SVP r�pondre aux 10 questions d'operations arithmetiques suivantes :");
        System.out.println();
        creezTest();
        effectuezTest();
   }//end of main()
    

} // end class OperationTest 
