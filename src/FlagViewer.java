import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
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
    private JLabel FlagName, FlagTotal;
    private final JButton aboutButton, searchDropButton;
    private final JTextField searchField;
    private JList<String>flagList;
    private JComboBox box;
    
    
    public FlagViewer() {
        super("Flag Viewer");
        searchField = new JTextField(10);
        
        aboutButton = new JButton("About");
        aboutButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(final ActionEvent ae){
                
            }
        });
        
        
        searchDropButton = new JButton();
        //Insert Image into button
        try{
            Image img = ImageIO.read(getClass().getResource("resources/arrowButton.jpg"));
            searchDropButton.setIcon(new ImageIcon(img));
        } catch(IOException ioe){
        }
        
        searchDropButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(final ActionEvent ae){
                //Method to list the items in the ComboBox 
            }
        });
        
        
        
        //Populate ArrayList of Flags
        JScrollPane scrollPane = new JScrollPane(flagList);
        
        final JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2,2));
        
        inputPanel.add(new JLabel("Total:"));
        inputPanel.add(FlagTotal);
        
        inputPanel.add(new JLabel("Search:"));
        inputPanel.add(FlagName);
        
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