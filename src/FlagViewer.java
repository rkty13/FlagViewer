import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.SwingConstants;

public class FlagViewer extends JFrame {
    
    private static final long serialVersionUID = 1L;
    private JLabel flagName, flagTotal;
    private final JButton aboutButton;
    private final JTextField searchField;
    private JComboBox box;
    
    
    public FlagViewer() {
        super("Flag Viewer");
        searchField = new JTextField(10);
        
        aboutButton = new JButton("About");
        //Code for About Button Here
        
        final JPanel inputPanel = new JPanel();
        
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        
    }
}