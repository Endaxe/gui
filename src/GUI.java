import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.*;

public class GUI {
    private JPanel panel1;
    private JTabbedPane tabbedPane;
    private JTextArea textArea1;
    private JButton button1;

    JMenuBar menuBar;

    protected JComponent makeTextPanel(String text){
        JPanel panel = new JPanel(false);
        JLabel filler = new JLabel(text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1, 1));
        panel.add(filler);
        return panel;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("GUI");
        GUI gui = new GUI();
        frame.setContentPane(gui.panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setJMenuBar(gui.menuBar);
        frame.setJTabbedPane(gui.panel1);
        frame.pack();
        frame.setVisible(true);
    }

    public GUI() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                open();
            }
        });




//Where the GUI is created:

        JMenu menu, submenu;
        JMenuItem menuItem;
        JRadioButtonMenuItem rbMenuItem;
        JCheckBoxMenuItem cbMenuItem;

//Create the menu bar.
        menuBar = new JMenuBar();

//Build the first menu.
        menu = new JMenu("Arkiv");
        menu.setMnemonic(KeyEvent.VK_A);
        menu.getAccessibleContext().setAccessibleDescription(
                "The only menu in this program that has menu items");
        menuBar.add(menu);

//a group of JMenuItems
        menuItem = new JMenuItem("Nytt",
                KeyEvent.VK_T);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription(
                "nytt");
        menu.add(menuItem);

        //Setting the mnemonic when constructing a menu item:
        menuItem = new JMenuItem("A text-only menu item",
                KeyEvent.VK_T);

//Setting the mnemonic after creation time:
        menuItem.setMnemonic(KeyEvent.VK_T);

//Setting the accelerator:
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_N, ActionEvent.ALT_MASK));

        //a group of JMenuItems
        menuItem = new JMenuItem("Öppna",
                KeyEvent.VK_T);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription(
                "Öppna");
        menu.add(menuItem);

        //Setting the mnemonic when constructing a menu item:
        menuItem = new JMenuItem("A text-only menu item",
                KeyEvent.VK_T);

//Setting the mnemonic after creation time:
        menuItem.setMnemonic(KeyEvent.VK_T);

//Setting the accelerator:
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_O, ActionEvent.ALT_MASK));

        //a group of JMenuItems
        menuItem = new JMenuItem("Spara",
                KeyEvent.VK_T);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription(
                "Spara");
        menu.add(menuItem);

        //Setting the mnemonic when constructing a menu item:
        menuItem = new JMenuItem("A text-only menu item",
                KeyEvent.VK_T);

//Setting the mnemonic after creation time:
        menuItem.setMnemonic(KeyEvent.VK_T);

//Setting the accelerator:
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_S, ActionEvent.ALT_MASK));


//Build second menu in the menu bar.
        menu = new JMenu("Sök");
        menu.setMnemonic(KeyEvent.VK_N);
        menu.getAccessibleContext().setAccessibleDescription(
                "This menu does nothing");
        menuBar.add(menu);



        JTabbedPane tabbedPane = new JTabbedPane();
        ImageIcon icon = createImageIcon("images/middle.gif");

        JComponent panel1 = makeTextPanel("Panel #1");
        tabbedPane.addTab("Tab 1",icon,panel1,
                "Does nothing");
        tabbedPane.setMnemonicAt(0,KeyEvent.VK_1);

        JComponent panel2 = makeTextPanel("Panel #2");
        tabbedPane.addTab("Tab 2",icon,panel2,
                "Does twice as much nothing");
        tabbedPane.setMnemonicAt(1,KeyEvent.VK_2);

        JComponent panel3 = makeTextPanel("Panel #3");
        tabbedPane.addTab("Tab 3",icon,panel3,
                "Still does nothing");
        tabbedPane.setMnemonicAt(2,KeyEvent.VK_3);

        JComponent panel4 = makeTextPanel(
                "Panel #4 (has a preferred size of 410 x 50).");
        panel4.setPreferredSize(new

                Dimension(410,50));
        tabbedPane.addTab("Tab 4",icon,panel4,
                "Does nothing at all");
        tabbedPane.setMnemonicAt(3,KeyEvent.VK_4);



    }
    public void actionPerformed(ActionEvent e) {
        int i = pane.indexOfTabComponent(ButtonTabComponent.this);
        if (i != -1) {
            pane.remove(i);
        }
    }


    public void save() {
        String filename = "text.txt";
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(filename)))) {
            out.println("hello warld");
            out.flush();
            out.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void open() {
        String filename = "info.txt";
        BufferedReader in = null;
        try {
            in = new BufferedReader((new FileReader(filename)));
        } catch (FileNotFoundException ex) {
            textArea1.setText("");
            return;

        }
        String nextLine = null;
        try {
            nextLine = in.readLine();
            while (nextLine != null) {
                textArea1.append(nextLine + "\n");
                nextLine = in.readLine();
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }





}

