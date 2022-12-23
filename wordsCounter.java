import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class wordsCounter extends JFrame implements ActionListener {
    JTextArea tx;
    JButton b1;
    JButton b2;
    JButton b3;
    JLabel l1;
    JLabel l2;
    JLabel l3;
    wordsCounter() {
        tx = new JTextArea();
        tx.setBounds(0, 80,1280,670);
        b1 = new JButton("Count Words!");
        b1.setBackground(Color.GREEN);
        b1.setBounds(10, 25, 150, 40);
        b2 = new JButton("Count Letters!");
        b2.setBackground(Color.GREEN);
        b2.setBounds(210, 25, 150, 40);
        b3 = new JButton("Clear!");
        b3.setBackground(Color.ORANGE);
        b3.setBounds(1100, 25, 150, 40);
        l1=new JLabel("Total Words : ");
        l1.setBounds(420,25,200,40);
        l2=new JLabel("Total letters : ");
        l2.setBounds(610,25,200,40);
        l3=new JLabel();
        l3.setBounds(570,0,200,25);
        l3.setVisible(false);
        l1.setVisible(false);
        l2.setVisible(false);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

        add(tx);add(b1);add(b2);add(b3);add(l1);add(l2);add(l3);

        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });


        setForeground(Color.magenta);
        setSize(1280, 720);
        setLayout(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        String sw=tx.getText();
        if(e.getSource()==b1 )
            {
                if(sw.length()==0){
                    l3.setVisible(true);
                    l3.setText("None Entered!");
                }
                int l=sw.split("[ ]+").length;
                l1.setVisible(true);
                l1.setText("Total words : "+l);
            }
        else if(e.getSource()==b2)
        {
            if(sw.length()==0){
                l3.setVisible(true);
                l3.setText("None Entered!");
            }
            int l=0;
            for (String str : sw.split("[ ]+")) {
                l+=str.length();
            }
            l2.setVisible(true);
            l2.setText("Total letters : "+l);
        }
        else{
            tx.setText("");
            l3.setVisible(false);
        l1.setVisible(false);
        l2.setVisible(false);
        }

    }

    public static void main(String[] args) {
        new wordsCounter();
    }
}
