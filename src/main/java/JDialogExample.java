import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class JDialogExample {
    JFrame frame;
    JButton button1, button2, button3;
    JTextField field1, field2, field3;

    // Stuff for our pop ups
    JPanel popupPanel;
    JTextField popupField1, popupField2;

    // JFrame FlowLayout Example
    public JDialogExample() {
        // 1. Create the frame (the window that will pop up)
        frame = new JFrame("Dialog Examples");
        frame.setLayout(new FlowLayout());

        // 2. Choose what happens when you click the exit button
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 3. Create components and put them in the frame

        // The first button, opens up a pop-up window with a simple text message
        button1 = new JButton("Simple Text Message");
        frame.add(button1);
        field1 = new JTextField(10);
        frame.add(field1);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Creates a pop-up window, and returns what the user types
                String s = (String) JOptionPane.showInputDialog(
                        frame,
                        "Hello! What is your name?\n"
                                + "Type below:",
                        "Customized Dialog",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        null,
                        null);
                field1.setText(s);
            }
        });

        // The second popup, which only gives the person certain options
        button2 = new JButton("Text Message with Options");
        frame.add(button2);
        field2 = new JTextField(10);
        frame.add(field2);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] options = {"9", "10", "11", "12"};
                String s = (String) JOptionPane.showInputDialog(
                        frame,
                        "Hello! What is your grade?\n"
                                + "Choose below:",
                        "Customized Dialog",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        options,
                        "9");
                field2.setText(s);
            }
        });

        // The third popup, which uses a customized pop up window!
        button3 = new JButton("Custom Panel Pop-up");
        frame.add(button3);
        field3 = new JTextField(10);
        frame.add(field3);

        // We can make a custom panel, which will show up
        // on our pop up window!
        popupPanel = new JPanel(new GridLayout(0, 2));

        popupField1 = new JTextField(10);
        popupField2 = new JTextField(10);

        popupPanel.add(new JLabel("String 0: "));
        popupPanel.add(popupField1);
        popupPanel.add(new JLabel("String 1: "));
        popupPanel.add(popupField2);

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showConfirmDialog(frame, popupPanel, "Data Entry", JOptionPane.OK_CANCEL_OPTION);
                String str = popupField1.getText() + " " + popupField2.getText();
                field3.setText(str);
            }
        });

        // 4. Size the frame
        frame.pack();

        // 5. Show the frame
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        JDialogExample f = new JDialogExample();
    }
}
