import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.*;

public class Main {
    JFrame frame;
    JPanel cardpanel, buttonpanel, subbuttonpanel;
    JButton card1Button, card2Button, pink, red, blue, grey, green;
    LocalDate now;
    int counter;

    public Main() {
        frame = new JFrame("Calendar 2022");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        cardpanel = new JPanel();
        cardpanel.setOpaque(false);
        cardpanel.setLayout(new CardLayout());


        now = LocalDate.now();
        now = now.minusDays(now.getDayOfMonth()-1);

        for (int i = 1; i<13; i++){
            JPanel p = new MonthPanel(i);
            cardpanel.add(p, i + "");
        }
        buttonpanel = new JPanel();
        //buttonpanel.setOpaque(false);
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
        subbuttonpanel = new JPanel();

        pink = new JButton("Pink");
        pink.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.getContentPane().setBackground(new Color (255, 181, 194));
            }
        });
        subbuttonpanel.add(pink);

        red = new JButton("Red");
        red.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.getContentPane().setBackground(new Color (255, 105, 97));
            }
        });
        subbuttonpanel.add(red);

        blue = new JButton("Blue");
        blue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.getContentPane().setBackground(new Color (156, 195, 227));
            }
        });
        subbuttonpanel.add(blue);

        grey = new JButton("Grey");
        grey.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.getContentPane().setBackground(new Color (229, 222, 224));
            }
        });
        subbuttonpanel.add(grey);

        green = new JButton("Green");
        green.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.getContentPane().setBackground(new Color (156,175,136));
            }
        });
        subbuttonpanel.add(green);


        frame.add(cardpanel, BorderLayout.CENTER);
        frame.add(buttonpanel, BorderLayout.SOUTH);
        buttonpanel.add(card1Button, BorderLayout.WEST);
        buttonpanel.add(card2Button, BorderLayout.EAST);
        buttonpanel.add(subbuttonpanel, BorderLayout.CENTER);






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
