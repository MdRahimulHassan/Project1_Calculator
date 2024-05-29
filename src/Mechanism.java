import javax.swing.*;
import java.awt.event.*;
public class Mechanism implements ActionListener {
    JTextField textfield;
    JButton[] numberButtons;
    JButton[] functionButtons;
    double num1 = 0, num2 = 0, result = 0;
    char operator;

    public Mechanism(JTextField textfield, JButton[] numberButtons, JButton[] functionButtons) {
        this.textfield = textfield;
        this.numberButtons = numberButtons;
        this.functionButtons = functionButtons;

        for (int i = 0; i < 11; i++) {
            numberButtons[i].addActionListener(this);
        }
        for (int i = 0; i < 9; i++) {
            functionButtons[i].addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == numberButtons[10]) { //Double zero button
            textfield.setText(textfield.getText().concat("00"));
        }
        if (e.getSource() == functionButtons[7]) { //Decimal button
            textfield.setText(textfield.getText().concat("."));
        }
        if (e.getSource() == functionButtons[6]) { //Add button
            num1 = Double.parseDouble(textfield.getText());
            operator = '+';
            textfield.setText("");
        }
        if (e.getSource() == functionButtons[5]) { //Subtract button
            num1 = Double.parseDouble(textfield.getText());
            operator = '-';
            textfield.setText("");
        }
        if (e.getSource() == functionButtons[4]) { // Multiply button
            num1 = Double.parseDouble(textfield.getText());
            operator = '*';
            textfield.setText("");
        }
        if (e.getSource() == functionButtons[3]) { //Divide button
            num1 = Double.parseDouble(textfield.getText());
            operator = '/';
            textfield.setText("");
        }
        if (e.getSource() == functionButtons[2]) { //Percentage button
            num1 = Double.parseDouble(textfield.getText());
            operator = '%';
            textfield.setText("");
        }
        if (e.getSource() == functionButtons[8]) { //Equal button
            num2 = Double.parseDouble(textfield.getText());

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
                case '%':
                    result = num1 % num2;
                    break;
            }
            textfield.setText(String.valueOf(result));
            num1 = result;
        }
        if (e.getSource() == functionButtons[0]) {// Clear button
            textfield.setText("");
        }
        if (e.getSource() == functionButtons[1]) {// Delete button
            String string = textfield.getText();
            if (!string.isEmpty()) {
                textfield.setText(string.substring(0, string.length() - 1));
            }
        }
    }
}
