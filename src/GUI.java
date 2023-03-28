import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.*;

public class GUI {
    private JPanel panel1;
    private JTabbedPane tabbedPane1;
    private JTextArea textArea1;
    private JButton button1;

    JMenuBar menuBar;

public GUI() {
    button1.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
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
                while (nextLine !=null) {
                    textArea1.append(nextLine + "\n");
                    nextLine = in.readLine();
                }
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }


//Where the GUI is created:

            JMenu menu, submenu;
            JMenuItem menuItem;
            JRadioButtonMenuItem rbMenuItem;
            JCheckBoxMenuItem cbMenuItem;

//Create the menu bar.
            menuBar = new JMenuBar();

//Build the first menu.
            menu = new JMenu("A Menu");
            menu.setMnemonic(KeyEvent.VK_A);
            menu.getAccessibleContext().setAccessibleDescription(
                    "The only menu in this program that has menu items");
            menuBar.add(menu);

//a group of JMenuItems
            menuItem = new JMenuItem("A text-only menu item",
                    KeyEvent.VK_T);
            menuItem.setAccelerator(KeyStroke.getKeyStroke(
                    KeyEvent.VK_1, ActionEvent.ALT_MASK));
            menuItem.getAccessibleContext().setAccessibleDescription(
                    "This doesn't really do anything");
            menu.add(menuItem);

            menuItem = new JMenuItem("Both text and icon",
                    new ImageIcon("images/middle.gif"));
            menuItem.setMnemonic(KeyEvent.VK_B);
            menu.add(menuItem);

            menuItem = new JMenuItem(new ImageIcon("images/middle.gif"));
            menuItem.setMnemonic(KeyEvent.VK_D);
            menu.add(menuItem);

//a group of radio button menu items
            menu.addSeparator();
            ButtonGroup group = new ButtonGroup();
            rbMenuItem = new JRadioButtonMenuItem("A radio button menu item");
            rbMenuItem.setSelected(true);
            rbMenuItem.setMnemonic(KeyEvent.VK_R);
            group.add(rbMenuItem);
            menu.add(rbMenuItem);

            rbMenuItem = new JRadioButtonMenuItem("Another one");
            rbMenuItem.setMnemonic(KeyEvent.VK_O);
            group.add(rbMenuItem);
            menu.add(rbMenuItem);

//a group of check box menu items
            menu.addSeparator();
            cbMenuItem = new JCheckBoxMenuItem("A check box menu item");
            cbMenuItem.setMnemonic(KeyEvent.VK_C);
            menu.add(cbMenuItem);

            cbMenuItem = new JCheckBoxMenuItem("Another one");
            cbMenuItem.setMnemonic(KeyEvent.VK_H);
            menu.add(cbMenuItem);

//a submenu
            menu.addSeparator();
            submenu = new JMenu("A submenu");
            submenu.setMnemonic(KeyEvent.VK_S);

            menuItem = new JMenuItem("An item in the submenu");
            menuItem.setAccelerator(KeyStroke.getKeyStroke(
                    KeyEvent.VK_2, ActionEvent.ALT_MASK));
            submenu.add(menuItem);

            menuItem = new JMenuItem("Another item");
            submenu.add(menuItem);
            menu.add(submenu);

//Build second menu in the menu bar.
            menu = new JMenu("Another Menu");
            menu.setMnemonic(KeyEvent.VK_N);
            menu.getAccessibleContext().setAccessibleDescription(
                    "This menu does nothing");
            menuBar.add(menu);



        }
    });
}

public  void save() {
    String filename = "text.txt";
    try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(filename)))) {
        out.println("hello warld");
        out.flush();
        out.close();
    } catch (IOException e) {
        throw new RuntimeException(e);
    }

}


    public static void main(String[] args) {
        JFrame frame = new JFrame("GUI");
        GUI gui = new GUI();
        frame.setContentPane(new GUI().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setJMenuBar(gui.menuBar);
        frame.pack();
        frame.setVisible(true);
    }
}

