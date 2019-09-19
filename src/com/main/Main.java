package com.main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main {

    static double thetaZero, thetaOne, alpha, costFunction;
    static ArrayList<Coordinates> arrayList;

    public static void main(String[] args) {

        View view = new View();

        view.calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(view.thetaZeroTextField.getText().isEmpty() || view.thetaOneTextField.getText().isEmpty() || view.alphaTextField.getText().isEmpty()) {

                    JOptionPane.showMessageDialog(null, "Please, fill all the text fields");
                }
                else {

                    thetaZero = Double.parseDouble(view.thetaZeroTextField.getText());
                    thetaOne = Double.parseDouble(view.thetaOneTextField.getText());
                    alpha = Double.parseDouble(view.alphaTextField.getText());

                    arrayList = Utilities.readDataFromFile("src/ex1data1.txt");

                    for(int i = 0; i < 2000; i++) {
                        double tempThetaZero = Utilities.calculateThetaZero(thetaZero, thetaOne, alpha, arrayList);
                        double tempThetaOne = Utilities.calculateThetaOne(thetaZero, thetaOne, alpha, arrayList);
                        thetaZero = tempThetaZero;
                        thetaOne = tempThetaOne;
                    }
                    costFunction = Utilities.calculateCostFunction(thetaZero, thetaOne, arrayList);

                    view.thetaZeroResultLabel.setText("Theta Zero: " + thetaZero);
                    view.thetaOneResultLabel.setText("Theta One: " + thetaOne);
                    view.costFunctionResultLabel.setText("Cost Function: " + costFunction);
                }
            }
        });
    }
}