import javax.swing.*;
import java.awt.*;

public class FrameDesign {
    JFrame frame;
    JTextField textfield;
    JButton[] numberButtons = new JButton[11];
    JButton[] functionButtons = new JButton[9];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton, percButton, doubleZeroButton;
    JPanel panel;
    Font myFont = new Font("Times New Roman", Font.BOLD, 23);

    public FrameDesign() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 600);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.BLACK);

        textfield = new JTextField();
        textfield.setBounds(50, 25, 300, 50);
        textfield.setFont(myFont);
        textfield.setEditable(false);
        textfield.setBackground(Color.WHITE);
        textfield.setForeground(Color.BLACK);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("DE");
        clrButton = new JButton("AC");
        percButton = new JButton("%");
        doubleZeroButton = new JButton("00");

        functionButtons[0] = clrButton;
        functionButtons[1] = delButton;
        functionButtons[2] = percButton;
        functionButtons[3] = divButton;
        functionButtons[4] = mulButton;
        functionButtons[5] = subButton;
        functionButtons[6] = addButton;
        functionButtons[7] = decButton;
        functionButtons[8] = equButton;

        for (int i = 0; i < 9; i++) {
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
            functionButtons[i].setBackground(Color.WHITE);
            functionButtons[i].setForeground(Color.BLACK);
        }

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
            numberButtons[i].setBackground(Color.WHITE);
            numberButtons[i].setForeground(Color.BLACK);
        }

        numberButtons[10] = doubleZeroButton;
        doubleZeroButton.setFont(myFont);
        doubleZeroButton.setFocusable(false);
        doubleZeroButton.setBackground(Color.WHITE);
        doubleZeroButton.setForeground(Color.BLACK);

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 400);
        panel.setLayout(new GridLayout(5, 4, 10, 10));
        panel.setBackground(Color.BLACK);

        //First row
        panel.add(clrButton);
        panel.add(delButton);
        panel.add(percButton);
        panel.add(divButton);

        //Second row
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);

        //Third row
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);

        //Fourth row
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);

        //Fifth row
        panel.add(doubleZeroButton);
        panel.add(numberButtons[0]);
        panel.add(decButton);
        panel.add(equButton);

        frame.add(panel);
        frame.add(textfield);
        frame.setVisible(true);
        Mechanism mechanism = new Mechanism(textfield, numberButtons, functionButtons);
    }
}
