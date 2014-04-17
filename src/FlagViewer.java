import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
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
import javax.swing.JTextField;
import javax.swing.JFrame;


public class FlagViewer extends JFrame {
    private int intFlagTotal = 10;
    private static final long serialVersionUID = 1L;
    private JLabel FlagName, TotalFlags;
    private final JButton aboutButton, searchDropButton;
    private final JTextField searchField;
    private JList<String> flagList;
    private JComboBox box;

    public FlagViewer() {
        super("Flag Viewer");
        searchField = new JTextField(10);

        // Give FlagTotal a numerical Value for amount of images in Folder "Flags"
        //Call method getFlagName in order to assign "FlagName" a value
        // Populate ArrayList of Flags
        
        
        
        aboutButton = new JButton("About");
        aboutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent ae) {
                // Method for the About Message to Open
            }
        });

        searchDropButton = new JButton();
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "resources/arrowButton.jpg"));
            searchDropButton.setIcon(new ImageIcon(img)); // Insert Image into
                                                          // button
        } catch (IOException ioe) {
        }

        searchDropButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent ae) {
                // Method to list the items in the ComboBox
            }
        });
        
        JScrollPane scrollPane = new JScrollPane(flagList);

        final JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 2));

        inputPanel.add(new JLabel("Total:"));
        inputPanel.add(new JLabel(Integer.toString(intFlagTotal)));
        //inputPanel.add(new JLabel(Integer.toString(intFlagTotal)));

        inputPanel.add(new JLabel("Search:"));
        inputPanel.add(searchField);
        
        final JPanel listOfFlags = new JPanel();
        listOfFlags.add(scrollPane);
        
        final JPanel aboutButtonPanel = new JPanel();
        aboutButtonPanel.add(aboutButton);

        final JPanel searchButtonPanel = new JPanel();
        searchDropButton.setPreferredSize(new Dimension(40,40));
        searchButtonPanel.add(searchDropButton);


        final Container mainPanel = getContentPane();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(inputPanel, BorderLayout.CENTER);
        mainPanel.add(listOfFlags, BorderLayout.SOUTH);
        mainPanel.add(aboutButtonPanel, BorderLayout.EAST);
        mainPanel.add(searchButtonPanel, BorderLayout.WEST);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

    }
    
    public static void getFlagName(){
        //Assign variable "FlagName" a string value equal to file name
    }

    public static void main(String[] args) {
        new FlagViewer();
    }
}