import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GridLayoutExample {
    JFrame frame;
    JButton[][] comps;

    public GridLayoutExample() {
        // 1. Create the frame (the window that will pop up)
        frame = new JFrame("GridLayout");

        // 2. Choose what happens when you click the exit button
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // The JFrame will still use BorderLayout but there is a Panel that uses CardLayout
        frame.setLayout(new GridLayout(4,3));
        comps = new JButton[4][3];

        // 3. Create components and put them in the frame

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                comps[i][j] = new JButton("Hello!");
                frame.add(comps[i][j]);
            }
        }

        // By adding all this stuff to a 2D array, you can now access it later!
        ((JButton) comps[1][2]).setText("Hi!");


        // 4. Size the frame
        frame.pack();

        // 5. Show the frame
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        GridLayoutExample b = new GridLayoutExample();
    }
}
