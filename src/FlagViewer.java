import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.MediaTracker;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class FlagViewer extends JFrame {
    private int intFlagTotal;
    private static final long serialVersionUID = 1L;
    private static String FlagName;
    private final JButton aboutButton; // , searchDropButton;
    private ArrayList<String> flagList;
    @SuppressWarnings("rawtypes")
    private JComboBox box;
    private HashMap<String, String> linkNametoFile;
    private JLabel flagLabel, flagNameLabel;
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public FlagViewer() {
        super("Flag Viewer");

        File f = new File("resources/flags");
        intFlagTotal = f.list().length - 1;
        flagLabel = new JLabel();
        flagNameLabel = new JLabel();
        linkNametoFile = new HashMap<String, String>();

        flagList = new ArrayList<String>(populateFlagList(f)); 
        
        box = new JComboBox(flagList.toArray());
        box.setEditable(true);
        
        box.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                JComboBox comboBox = (JComboBox) ae.getSource();
                Object select = comboBox.getSelectedItem();
                FlagName = select.toString();
                if(FlagName == null){
                    FlagName = "";
                }
                if(FlagName.equalsIgnoreCase("kenneth rhee special")){
                    displayKR();
                } else {
                    flagNameLabel.setText(searchFlagList(FlagName));
                    ImageIcon flagImage = getImageIcon("resources/flags/" + linkNametoFile.get(FlagName.toLowerCase()));
                    flagLabel.setIcon(flagImage);
                }
            }
        });
         
        aboutButton = new JButton("About");
        aboutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent ae) {
                ImageIcon icon = getImageIcon("resources/HydraIcon.jpg");
                JOptionPane
                        .showMessageDialog(
                                null,
                                "This Flag Viewer application was created by Eric Kong & Robert Kim."
                                        + "\nFun Fact #1: Eric Kong did about 60% of the work, while Bobby did the remaining 39%. Kenneth did 1%.",
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
        inputPanel.setLayout(new GridLayout(3, 1));
        final JPanel centerInputPanel = new JPanel();
        centerInputPanel.setLayout(new BorderLayout());
        JLabel totalFlags = new JLabel("Total Flags: " + Integer.toString(intFlagTotal));
        centerInputPanel.add(totalFlags, BorderLayout.PAGE_START);
        // inputPanel.add(new JLabel(""));
        // searchDropButton.setPreferredSize(new Dimension(40,40));
        centerInputPanel.add(new JLabel("Search:"), BorderLayout.CENTER);
        centerInputPanel.add(box, BorderLayout.PAGE_END);
        // inputPanel.add(searchDropButton);

        inputPanel.add(new JLabel());
        inputPanel.add(centerInputPanel);
        
        final JPanel aboutButtonPanel = new JPanel();
        aboutButtonPanel.add(aboutButton);
        
        final JPanel flagImagePanel = new JPanel();
        flagImagePanel.setLayout(new BorderLayout());
        flagImagePanel.add(flagNameLabel, BorderLayout.NORTH);
        flagImagePanel.add(flagLabel, BorderLayout.CENTER);
        flagImagePanel.setPreferredSize(new Dimension(150,150));

        final Container mainPanel = getContentPane();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(flagImagePanel, BorderLayout.LINE_START);
        mainPanel.add(inputPanel, BorderLayout.CENTER);
        mainPanel.add(aboutButtonPanel, BorderLayout.SOUTH);
        
        
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(325, 235));
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    public ArrayList<String> populateFlagList(File f) {
        ArrayList<String> searchList = new ArrayList<String>();
        searchList.add("");
        File[] flags = f.listFiles();
        if (flags != null) {
            for (File flag : flags) {
                String flagFile = flag.getName();
                String origin = flag.getName();
                if (flagFile.contains(".")) {
                    String[] seperated = flagFile.split("\\.");
                    flagFile = seperated[0];
                }
                if (flagFile.contains("-")) {
                    flagFile = flagFile.replaceAll("-", " ");
                }
                searchList.add(flagFile);
                linkNametoFile.put(flagFile.toLowerCase(), origin);
            }
        }
        return searchList;
    }
    
    public String searchFlagList(String flagName) {
        for (int i = 0; i < flagList.size(); i++) {
            String compare = flagList.get(i);
            if (flagName.equalsIgnoreCase(compare)) {
                return compare;
            }
        }
        return null;
    }
    
    public void displayKR(){
        ImageIcon kr = getImageIcon("resources/Kenneth-Rhee-Special.png");
        JOptionPane.showMessageDialog(null, "","The Ken Rhee Special",JOptionPane.INFORMATION_MESSAGE ,kr);
    }

    public static ImageIcon getImageIcon(final String filename) {
        ImageIcon icon;
        final URL url = FlagViewer.class.getResource(filename);
        if (url != null) {
            icon = new ImageIcon(url);
        } else {
            icon = new ImageIcon(filename);
            
            if ((icon == null) || (icon.getImageLoadStatus() != MediaTracker.COMPLETE)) {
                try {
                    icon = new ImageIcon(new URL(filename));
                } catch (final MalformedURLException murle) {
                    return null;
                }
            }
        }
        return icon;
    }
    
    public static void main(String[] args) {
        new FlagViewer();
    }
}