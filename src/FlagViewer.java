import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.SwingConstants;

public class FlagViewer extends JFrame {
    
    private static final long serialVersionUID = 1L;
    private JLabel flagName, flagTotal;
    private final JButton aboutButton;
    private final JTextField searchField;
    private JList<String>flagList;
    private JComboBox box;
    
    
    public FlagViewer() {
        super("Flag Viewer");
        searchField = new JTextField(10);
        
        aboutButton = new JButton("About");
        //Code for About Button Here
        
        //Populate ArrayList of Flags
        JScrollPane scrollPane = new JScrollPane(flagList);
        
        final JPanel inputPanel = new JPanel();
        
        final JPanel aboutButtonPanel = new JPanel();
        
        final Container mainPanel = getContentPane();
        mainPanel.setLayout(new BorderLayout());
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        
    }
}