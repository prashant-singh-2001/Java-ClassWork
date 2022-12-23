import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.JLabel;

public class mouseHover extends Frame implements MouseListener {
    Button b;
    JLabel j;
    mouseHover() {
        j=new JLabel("Catch Me If You CAN!");
        j.setFont(new Font("Cartograph CF",Font.BOLD,40));
        j.setForeground(Color.WHITE);
        j.setBounds(250,20,500,100);
        b = new Button("Prashant");
        b.setBounds(20, 20, 100, 80);
         add(b);
        add(j);
       
        b.addMouseListener(this);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });


        setBackground(new Color(120,100,100));
        setSize(1000, 1000);
        setLayout(null);
        setVisible(true);
    }

    public void mouseEntered(MouseEvent e) {
        b.setBounds(getRandomNumberUsingNextInt(50,950),getRandomNumberUsingNextInt(50,950),100,80);
    }

    public int getRandomNumberUsingNextInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public static void main(String[] args) {
        new mouseHover();
    }
}
