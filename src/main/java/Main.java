import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.*;

public class Main {
    JFrame frame;
    JPanel cardpanel;
    JButton card1Button;
    LocalDate now;

    public Main() {
        frame = new JFrame("Calendar Program");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        cardpanel = new JPanel();
        cardpanel.setLayout(new CardLayout());


        now = LocalDate.now();
        now = now.minusDays(now.getDayOfMonth()-1);

        for (int i = 1; i<13; i++){
            JPanel p = new MonthPanel(i);
            cardpanel.add(p, i + "");
        }

        card1Button = new JButton("November");
        card1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                CardLayout cl = (CardLayout) cardpanel.getLayout();
                cl.show(cardpanel, "11");
            }
        });
        frame.add(cardpanel, BorderLayout.CENTER);
        frame.add(card1Button, BorderLayout.SOUTH);






        int count = now.getDayOfWeek().getValue() % 7;
        System.out.println(count);

//        LocalDate earlier = now.minusMonths(1); // 2022-4-17
//        int count = earlier.minusDays(now.getDayOfMonth()-1).getDayOfWeek().getValue();



        frame.pack();
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        Main m = new Main();
    }
}
