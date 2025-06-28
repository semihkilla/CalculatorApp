package org.example.gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class CalculatorGUI extends JFrame {
    public CalculatorGUI(){
        setTitle("Taschenrechner");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(320, 420);
        setLayout(new BorderLayout());

        DisplayPanel display = new DisplayPanel();
        ButtonPanel button = new ButtonPanel();

        add(display, BorderLayout.NORTH);
        add(button, BorderLayout.CENTER);

        setLocationRelativeTo(null);
    }
    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> {
            CalculatorGUI gui = new CalculatorGUI();
            gui.setVisible(true);
        });
    }
}
