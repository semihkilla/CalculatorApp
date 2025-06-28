package org.example.gui;

import javax.swing.*;
import java.awt.*;

public class DisplayPanel extends JPanel {
    private final JLabel displayLabel;

    public DisplayPanel(){
        setLayout(new BorderLayout());
        displayLabel = new JLabel("0", SwingConstants.RIGHT);
        displayLabel.setFont(new Font("Arial", Font.BOLD, 28));
        displayLabel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        add(displayLabel, BorderLayout.CENTER);
        setBackground(Color.white);
    }

    public void setDisplayLabel(String text){
        displayLabel.setText(text);
    }

    public String getDisplayText(){
        return displayLabel.getText();
    }

}
