import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class FlagViewer extends JFrame {
    private int intFlagTotal;
    private static final long serialVersionUID = 1L;
    private static String FlagName;
    private final JButton aboutButton; // , searchDropButton;
    private ArrayList<String> flagList;
    private JComboBox box;

    public FlagViewer() {
        super("Flag Viewer");

        File f = new File("resources/flags");
        intFlagTotal = f.list().length - 1;

        // THIS ISNT RIGHT. WE CAN ONLY POPULATE A COMBOBOX WITH AN ARRAY, NOT
        // JLIST
        flagList = new ArrayList<String>(populateFlagList(f)); // MUST CHANGE

        // ListSelectionListener
        box = new JComboBox();
        box.setEditable(true);
        
        //add array list to comboBox
        
        box.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() { public void keyReleased(KeyEvent e) { 
            if(e.getKeyCode() != 38 && e.getKeyCode != 40 && e.getKeyCode != 10){
                
            }
        });
        
        /*
        box.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                JComboBox comboBox = (JComboBox) ae.getSource();
                Object select = comboBox.getSelectedItem();
                FlagName = select.toString();
                // if select = flag, then display image of flag and its NAME
            }
        });
         */
        aboutButton = new JButton("About");
        aboutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent ae) {
                ImageIcon icon = new ImageIcon("resources/HydraIcon.jpg");
                JOptionPane
                        .showMessageDialog(
                                null,
                                "This Flag Viewer application was created by Eric Kong & Robert Kim."
                                        + "\nFun Fact #1: Eric Kong did about 80% of the work, while Bobby Kim did the remaining 20%",
                                "About", JOptionPane.INFORMATION_MESSAGE, icon);
            }
        });

        /*
        searchDropButton = new JButton();
        try {
            Image img = ImageIO.read(getClass().getResource(
                    "resources/keepTrying.jpg"));
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
        */
        
        final JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 2));

        inputPanel.add(new JLabel("Total Flags:"));
        inputPanel.add(new JLabel(Integer.toString(intFlagTotal)));
        // inputPanel.add(new JLabel(""));
        // searchDropButton.setPreferredSize(new Dimension(40,40));
        inputPanel.add(new JLabel("Search:"));
        inputPanel.add(box);

        // inputPanel.add(searchDropButton);

        final JPanel aboutButtonPanel = new JPanel();
        aboutButtonPanel.add(aboutButton);

        final JPanel flagImagePanel = new JPanel();
        flagImagePanel.add(new JLabel(FlagName));
        // actual Flag Image

        final Container mainPanel = getContentPane();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(inputPanel, BorderLayout.CENTER);
        mainPanel.add(aboutButtonPanel, BorderLayout.AFTER_LAST_LINE);
        mainPanel.add(flagImagePanel, BorderLayout.WEST);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    public ArrayList<String> populateFlagList(File f) {
        ArrayList<String> searchList = new ArrayList<String>();
        File[] flags = f.listFiles();
        if (flags != null) {
            for (File flag : flags) {
                String flagFile = flag.getName();
                if (flagFile.contains(".")) {
                    String[] seperated = flagFile.split("\\.");
                    flagFile = seperated[0];
                }
                if (flagFile.contains("-")) {
                    flagFile = flagFile.replaceAll("-", " ");
                }
                searchList.add(flagFile);
            }
        }
        return searchList;
    }

    public static void main(String[] args) {
        new FlagViewer();
    }
}