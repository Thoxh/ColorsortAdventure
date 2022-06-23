package game;

import java.awt.*;
import javax.swing.*;

public class Swing extends JFrame {
    public Swing(int score, int total) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(560, 200);  
        setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        LayoutManager layout = new FlowLayout();
        panel.setLayout(layout);
        JButton button = new JButton("Okay");
        setVisible(true);
        button.addActionListener(e -> { 
            JOptionPane.showMessageDialog(this, "Punktestand: " + score + "/" + total);
        });
        panel.add(button);
        getContentPane().add(panel, BorderLayout.CENTER);
    }
}