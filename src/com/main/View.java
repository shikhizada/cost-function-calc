package com.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View {

    static JTextField thetaZeroTextField, thetaOneTextField, alphaTextField;
    static JLabel thetaZeroLabel, thetaOneLabel, alphaLabel, thetaZeroResultLabel, thetaOneResultLabel, costFunctionResultLabel, footerLabel;
    static JPanel inputPanel, resultPanel, footerPanel;
    static JFrame frame;
    static JButton calculateButton, clearButton;

    static void init() {

        frame = new JFrame("Machine Learning Task");

        thetaZeroTextField = new JTextField();
        thetaOneTextField = new JTextField();
        alphaTextField = new JTextField();

        thetaZeroLabel = new JLabel("Theta Zero:");
        thetaOneLabel = new JLabel("Theta One:");
        alphaLabel = new JLabel("Alpha:");
        thetaZeroResultLabel = new JLabel("Theta Zero:");
        thetaOneResultLabel = new JLabel("Theta One:");
        costFunctionResultLabel = new JLabel("Cost Function:");
        footerLabel = new JLabel("Developed by Aladdin Shikhizada", SwingConstants.CENTER);

        inputPanel = new JPanel();
        resultPanel = new JPanel();
        footerPanel = new JPanel();
        clearButton = new JButton("Clear");
        calculateButton = new JButton("Calculate");

        inputPanel.setLayout(new GridLayout(4, 2));
        inputPanel.add(thetaZeroLabel);
        inputPanel.add(thetaZeroTextField);
        inputPanel.add(thetaOneLabel);
        inputPanel.add(thetaOneTextField);
        inputPanel.add(alphaLabel);
        inputPanel.add(alphaTextField);
        inputPanel.add(clearButton);
        inputPanel.add(calculateButton);

        resultPanel.setLayout(new GridLayout(3,1));
        resultPanel.add(thetaZeroResultLabel);
        resultPanel.add(thetaOneResultLabel);
        resultPanel.add(costFunctionResultLabel);

        footerPanel.setLayout(new GridLayout(1, 1));
        footerPanel.add(footerLabel);

        frame.setLayout(new BorderLayout());
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(resultPanel, BorderLayout.CENTER);
        frame.add(footerPanel, BorderLayout.SOUTH);


        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                thetaZeroTextField.setText("");
                thetaOneTextField.setText("");
                alphaTextField.setText("");

                thetaZeroResultLabel.setText("Theta Zero:");
                thetaOneResultLabel.setText("Theta One:");
                costFunctionResultLabel.setText("Cost Function:");
            }
        });
    }

    public View() {

        init();
    }
}
