import javax.swing.*;
import java.awt.*;

public class Main {
    JFrame frame;
    CalendarPage [][] d;
    JPanel panel1, panel2;

    public Main() {
        int count = 1;
        frame = new JFrame("Calendar Program");
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label1 = new JLabel("May");
        label1.setHorizontalAlignment(JLabel.CENTER);
        //creds: https://www.tutorialspoint.com/how-to-align-jlabel-text-vertically-top-in-java
        frame.add(label1);

        panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());
        panel2.add(new JLabel("\n"), BorderLayout.NORTH);
        panel2.add(new JLabel("           Sun                  Mon                   Tue                   Wed                   Thu                   Fri                   Sat"));
        frame.add(panel2);

        panel1 = new JPanel();

        panel1.setLayout(new GridLayout(5,7));
        d = new CalendarPage[5][7];

        panel1.add(new CalendarPage());

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 7; j++) {
                //do math on starting count of the math thing
                if (count<32) {
                    d[i][j] = new CalendarPage(count);
                    panel1.add(d[i][j]);
                    count++;
                }
            }
        }

        frame.add(panel1, BorderLayout.CENTER);

        frame.pack();
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        Main m = new Main();
    }
}
