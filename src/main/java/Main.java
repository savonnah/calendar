import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.*;

public class Main {
    JFrame frame;
    JPanel cardpanel, buttonpanel;
    JButton card1Button, card2Button;
    LocalDate now;
    int counter;

    public Main() {
        frame = new JFrame("Calendar 2022");
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
        buttonpanel = new JPanel();
        buttonpanel.setLayout(new BorderLayout());
        counter = 1;
        card1Button = new JButton("<");
        card1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                CardLayout cl = (CardLayout) cardpanel.getLayout();
                cl.show(cardpanel, "" + (counter-1));
                counter--;
            }
        });
        card2Button = new JButton(">");
        card2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                CardLayout cl = (CardLayout) cardpanel.getLayout();
                cl.show(cardpanel, "" + (counter+1));
                counter++;
            }
        });
        frame.add(cardpanel, BorderLayout.CENTER);
        frame.add(buttonpanel, BorderLayout.SOUTH);
        buttonpanel.add(card1Button, BorderLayout.WEST);
        buttonpanel.add(card2Button, BorderLayout.EAST);






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
