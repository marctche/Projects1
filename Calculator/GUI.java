/**********************Q2-Devoir2 ITI1521....*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class GUI extends JFrame implements ActionListener {
    Calculator cal;
    JTextField input;

    GUI(Calculator p) {
        super("Calculatrice de Marc et Matthew");
        this.cal = p;



        setSize(250, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        input = new JTextField();
        add(input, BorderLayout.NORTH);

        // Je crée mon entré pour l'utilisateur
        // et aussi la taille de l'interface



        JPanel layoutPourBoutons = new JPanel();
        layoutPourBoutons.setLayout(new GridLayout(4, 4, 1, 1));

        String[] buttons = {
            "1", "2", "3", "+","FACT",
            "4", "5", "6", "-","POW",
            "7", "8", "9","*","SQRT",
            "0", "=", "C", "/","LN",
        };

        //Je créé tous mes boutons

        for (String newButton : buttons) {
            JButton button = new JButton(newButton);
            button.addActionListener(this);
            layoutPourBoutons.add(button);
        }

        // Ce loop me permet de créé l'interface de chaque bouton un par un.

        add(layoutPourBoutons, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent eV) {
        String command = eV.getActionCommand();

        if ("0123456789".contains(command)) {
            input.setText(input.getText() + command);
        } else {
            switch (command) {
                case "+":
                case "-":
                case "*":
                case "/":
                case "POW":
                    cal.first = Double.parseDouble(input.getText());
                    cal.operation(command);
                    input.setText("");
                    break;

                    // Etapes d'execuation pour touts les different cas d'operandes
                case "=":
                    cal.second = Double.parseDouble(input.getText());
                    cal.compute();
                    input.setText(String.valueOf(cal.display()));
                    break;
                    // Cas pour egal
                case "C":
                    cal.clear();
                    input.setText("0");
                    break;

                    // Cas pour tout effacé

                case "FACT":
                case "SQRT":
                case "LN":
                    cal.first = Double.parseDouble(input.getText());
                    cal.operation(command);
                    input.setText("");
                    cal.compute();
                    input.setText(String.valueOf(cal.display()));
                    break;

                    // Cas pour d'autres opérandes

                // Ajouter ici d'autres cas si nécessaire
            }
        }
    }

    public static void main(String args[]) {
        GUI gui = new GUI(new Calculator());
        gui.setVisible(true);
    }
}
