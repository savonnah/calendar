import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalendarPage extends JPanel {
    JPanel panel1;
    JButton button1, createButton;
    JLabel label, label1, label2;

    JPanel popupPanel;
    JScrollPane scrollPane;
    JTextField popupField1, popupField2;

    int index;

    public CalendarPage(){
        super();
    }

    // This is the constructor which sets up the JFrame
    // and all other components and containers
    public CalendarPage(int day) {
        super(); // equivalent to: JPanel panel1 = new JPanel();
        JPanel thisPanel = this;
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(100, 100));

        panel1 = new JPanel();
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
        scrollPane = new JScrollPane(panel1);

        this.add(scrollPane, BorderLayout.CENTER);

        label = new JLabel("" + day);
        this.add(label, BorderLayout.NORTH);

        createButton = new JButton("+");
        // this.add(createButton);

        // We can make a custom panel, which will show up
        // on our pop up window!
        popupPanel = new JPanel(new GridLayout(0, 2));

        popupField1 = new JTextField(10);
        popupField2 = new JTextField(10);

        popupPanel.add(new JLabel("Event: "));
        popupPanel.add(popupField1);
        popupPanel.add(new JLabel("Time: "));
        popupPanel.add(popupField2);

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showConfirmDialog(thisPanel, popupPanel, "Data Entry", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
//                ImageIcon x = new ImageIcon("photo.jpg");
//                JOptionPane.showConfirmDialog(thisPanel, popupPanel, "Data Entry", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, x);


                for (int i = 0; i < panel1.getComponentCount(); i++) {
                    JLabel x = (JLabel) panel1.getComponent(i);
                    String text = x.getText();
                    int at = text.indexOf("@");
                    String s1ofat = text.substring(at+2);

                    int a = Integer.parseInt(s1ofat);
                    int b = Integer.parseInt(popupField2.getText());

                    if (a<b){
                        index = i+1;
                    }
                    else if(a>b){
                        index = i;
                        break;
                    }

                }


                label1 = new JLabel("" + popupField1.getText() + " @ " + popupField2.getText());
//                panel1.add(label1);
                panel1.add(label1, index);

                thisPanel.revalidate();
            }
        });

           /* public void actionPerformed(ActionEvent e) {
                //add pop up window stuff
                String event = (String)JOptionPane.showInputDialog(
                        thisPanel,
                        "Title:",
                        "Customized Dialog",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        null,
                        null);

                String time = (String)JOptionPane.showInputDialog(
                        thisPanel,
                        "Time:",
                        "Customized Dialog",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        null,
                        null);
                label1 = new JLabel("" + event + "@ " + time);
                thisPanel.add(label1, BorderLayout.WEST);

            }
            */
        this.add(createButton, BorderLayout.SOUTH);
    }
    public static void main(String[] args) {
        // CalendarPage x = new CalendarPage();
    }


};



    // Main method just creates a PaintDemo object


