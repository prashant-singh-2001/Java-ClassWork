import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class trafficSignal extends Thread {

    int cid;
    drawing dr = new drawing(Color.RED);
    drawing dy = new drawing(Color.ORANGE);
    drawing dg = new drawing(Color.GREEN);
    JLabel j;

    public trafficSignal() {
        // creating a frame
        Frame f = new Frame("Canvas Example");
        Canvas c = new Canvas();
        c.setBounds(490, 650, 20, 300);
        c.setBackground(Color.BLACK);
        j = new JLabel();
        j.setFont(new Font("Cartograph CF", Font.BOLD, 20));
        j.setBackground(Color.CYAN);

        // j.setVisible(false);
        dr.setBounds(450, 350, 100, 100);
        dy.setBounds(450, 450, 100, 100);
        dg.setBounds(450, 550, 100, 100);

        f.add(j);
        f.add(dr);
        f.add(dy);
        f.add(dg);
        f.add(c);

        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        // setting layout, size and visibility of frame
        f.setBackground(Color.LIGHT_GRAY);
        f.setLayout(null);
        f.setSize(1000, 1000);
        f.setVisible(true);
    }

    public void run() {
        int i = 0;
        while (true) {
            if (i % 3 == 0) {
                change(i % 3);
                try {
                    j.setForeground(Color.RED);
                    j.setBounds(600, 370, 60, 60);
                    for (int k = 10; k > 0; k--) {
                        j.setText(Integer.toString(k));
                        sleep(999);
                    }
                    j.setText("");
                } catch (InterruptedException e) {}
            } else if ((i % 3) == 1) {
                change(i % 3);
                try {

                    j.setForeground(Color.orange);
                    j.setBounds(600, 470, 60, 60);
                    for (int k = 5; k > 0; k--) {
                        j.setText(Integer.toString(k));
                        sleep(999);
                    }
                    j.setText("");
                } catch (InterruptedException e) {}
            } else {
                change(i % 3);
                try {
                    j.setForeground(Color.GREEN);
                    j.setBounds(600, 570, 60, 60);
                    for (int k = 10; k > 0; k--) {
                        j.setText(Integer.toString(k));
                        sleep(999);
                    }
                    j.setText("");
                } catch (InterruptedException e) {}
            }
            i++;
        }
    }

    // main method
    public static void main(String args[]) {
        trafficSignal ts = new trafficSignal();
        Thread t1 = new Thread(ts);
        t1.start();

    }

    public void change(int cid) {
        if (cid == 0) {
            dr.changecolor(Color.RED);
            dy.changecolor(Color.BLACK);
            dg.changecolor(Color.BLACK);
        } else if (cid == 1) {
            dr.changecolor(Color.BLACK);
            dy.changecolor(Color.ORANGE);
            dg.changecolor(Color.BLACK);
        } else {
            dr.changecolor(Color.BLACK);
            dy.changecolor(Color.BLACK);
            dg.changecolor(Color.GREEN);
        }
    }
}

class drawing extends Canvas {
    Color c;

    // class constructor
    public drawing(Color c) {
        setSize(100, 100);
        setBackground(Color.BLACK);
        this.c = c;
    }

    // paint() method to draw inside the canvas
    public void paint(Graphics g) {
        // adding specifications

        g.setColor(Color.DARK_GRAY);
        g.fillOval(13, 13, 74, 74);
        g.setColor(c);
        g.fillOval(15, 15, 70, 70);
    }

    public void changecolor(Color c) {
        this.c = c;
        repaint();
    }
}