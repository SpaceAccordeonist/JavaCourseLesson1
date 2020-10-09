package ru.spaceaccordeonist.task10;

import javax.swing.*;
import javax.swing.plaf.basic.BasicOptionPaneUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class GuiFrame {
    public static void main(String[] args) {
        //Components declaration
         JFrame frame = new JFrame("Super Calculator");
         Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 20);

         JButton btnPlus = new JButton("+");
         JButton btnMinus = new JButton("-");
         JButton btnMult = new JButton("*");
         JButton btnDiv = new JButton("/");

         JTextField taFirstOperand = new JTextField();
         JTextField taSecondOperand = new JTextField();
         JLabel lResult = new JLabel();

         ActionListener btnPressedListener = (ActionEvent e) -> {
                 if(validateOperand(taFirstOperand.getText()) && validateOperand(taSecondOperand.getText())) {
                     double firstOperand = Double.parseDouble(taFirstOperand.getText());
                     double secondOperand = Double.parseDouble(taSecondOperand.getText());
                     double result = Double.NaN;
                     switch (e.getActionCommand()) {
                         case "+":
                             result = firstOperand + secondOperand;
                             break;
                         case "-":
                             result = firstOperand - secondOperand;
                             break;
                         case "*":
                             result = firstOperand * secondOperand;
                             break;
                         case "/":
                             if(secondOperand != 0)
                                 result = firstOperand / secondOperand;
                             break;
                         default:
                             lResult.setText("Undefined operation!");
                             break;
                     }
                     if(Double.isNaN(result)){
                         lResult.setText("Disallowed operation!");
                     } else{
                         int digit;
                         String size = "%.0f";
                         for(digit = 4; digit > 0; digit--){
                             if(Math.round(result * Math.pow(10, digit)) % 10 != 0){
                                 size = "%." + digit + "f";
                                 break;
                             }
                         }
                         lResult.setText(String.format(Locale.US, size, result));
                     }
                 }else {
                     lResult.setText("Invalid operand!");
                 }
                };

         //Window initialization
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);

        //Layout setting
        frame.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;

        //Components initialization
        //First operand
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weighty = 5;
        constraints.ipady = 15;
        constraints.gridwidth = 4;
        taFirstOperand.setAlignmentX(JTextArea.CENTER_ALIGNMENT);
        taFirstOperand.setHorizontalAlignment(JLabel.CENTER);
        taFirstOperand.setFont(font);
        frame.add(taFirstOperand, constraints);

        //Second operand
        constraints.gridy = 2;
        taSecondOperand.setAlignmentX(JTextArea.CENTER_ALIGNMENT);
        taSecondOperand.setHorizontalAlignment(JLabel.CENTER);
        taSecondOperand.setFont(font);
        frame.add(taSecondOperand, constraints);

        //Operation buttons
        constraints.gridy = 1;
        constraints.gridx = 0;
        constraints.weightx = 1;
        constraints.gridwidth = 1;
        frame.add(btnPlus, constraints);
        constraints.gridy = 1;
        constraints.gridx = 1;
        frame.add(btnMinus, constraints);
        constraints.gridy = 1;
        constraints.gridx = 2;
        frame.add(btnDiv, constraints);
        constraints.gridy = 1;
        constraints.gridx = 3;
        frame.add(btnMult, constraints);

        //Button's listener setting
        btnPlus.addActionListener(btnPressedListener);
        btnMinus.addActionListener(btnPressedListener);
        btnDiv.addActionListener(btnPressedListener);
        btnMult.addActionListener(btnPressedListener);

        //Result output
        constraints.gridx = 0;
        constraints.gridy = 5;
        constraints.weightx = 1;
        constraints.gridwidth = 4;
        constraints.ipady = 30;
        lResult.setHorizontalAlignment(JLabel.CENTER);
        lResult.setText("result");
        lResult.setFont(font);
        lResult.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        frame.add(lResult, constraints);

        frame.setVisible(true);
        //Initialization done
    }

    public static boolean validateOperand(String operand){
        try {
            Double.valueOf(operand);
        } catch (NumberFormatException e){
            return false;
        }
        return true;
    }
}
