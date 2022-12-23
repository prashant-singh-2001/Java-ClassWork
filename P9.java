import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * P9
 */
public class P9 extends JFrame implements ActionListener, KeyListener {
    private JButton[] tiles;

    private GridLayout grid;

    private int emptyIndex;

    private JPanel jp;

    private JLabel jl;

    P9() {
        super("9 Puzzle");
        grid = new GridLayout(3, 3);
        jp = new JPanel();
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }

        jl = new JLabel("Can You Solve this?");
        jl.setBounds(200, 20, 250, 50);
        jl.setFont(new Font("", Font.BOLD, 20));
        add(jl);

        tiles = new JButton[9];

        ArrayList<Integer> nums = new ArrayList<>();
        int i = 0;
        while (i < 8) {
            int num = getRandomNumberUsingNextInt(1, 9);
            boolean b = nums.indexOf(num) != -1 ? false : true;
            if (b) {
                tiles[i] = new JButton("" + num);
                tiles[i].addActionListener(this);
                tiles[i].addKeyListener(this);
                jp.add(tiles[i]);
                nums.add(num);
                i++;
            }
        }

        tiles[8] = new JButton();
        tiles[8].addActionListener(this);
        jp.add(tiles[8]);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        jp.setBounds(10, 100, 560, 450);
        jp.setLayout(grid);
        jp.setBackground(Color.BLUE);
        jp.setVisible(true);
        add(jp);
        emptyIndex = 8;
        tiles[emptyIndex].setText("");
        setBackground(Color.WHITE);
        setSize(600, 600);
        setLayout(null);
        setVisible(true);
    }

    public int getRandomNumberUsingNextInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        boolean flag = true;
        try {
            for (int i = 0; i < (tiles.length - 2); i++) {
                if ((Integer.parseInt(tiles[i].getText()) + 1) == (Integer.parseInt(tiles[i + 1].getText()))) {
                    continue;
                } else {
                    flag = false;
                    break;
                }
            }
        } catch (NumberFormatException ex) {
            flag = false;
        }
        if (!flag) {
            try {
                switch (keyCode) {
                    case KeyEvent.VK_UP:
                        tiles[emptyIndex].setText(tiles[emptyIndex - 3].getText());
                        tiles[emptyIndex - 3].setText("");
                        emptyIndex = emptyIndex - 3;
                        break;
                    case KeyEvent.VK_DOWN:
                        tiles[emptyIndex].setText(tiles[emptyIndex + 3].getText());
                        tiles[emptyIndex + 3].setText("");
                        emptyIndex = emptyIndex + 3;
                        break;
                    case KeyEvent.VK_LEFT:
                        if (emptyIndex % 3 != 0) {
                            tiles[emptyIndex].setText(tiles[emptyIndex - 1].getText());
                            tiles[emptyIndex - 1].setText("");
                            emptyIndex = emptyIndex - 1;
                        }
                        break;
                    case KeyEvent.VK_RIGHT:
                        if ((emptyIndex + 1) % 3 != 0) {
                            tiles[emptyIndex].setText(tiles[emptyIndex + 1].getText());
                            tiles[emptyIndex + 1].setText("");
                            emptyIndex = emptyIndex + 1;
                        }
                        break;
                }
            } catch (Exception ex) {
            }
        } else {
            jl.setBounds(150, 20, 300, 50);
            jl.setText("Congratulation!! You WON!!");
        }
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton) e.getSource();
        boolean flag = true;

        try {
            for (int i = 0; i < (tiles.length - 2); i++) {
                if ((Integer.parseInt(tiles[i].getText()) + 1) == (Integer.parseInt(tiles[i + 1].getText()))) {
                    continue;
                } else {
                    flag = false;
                    break;
                }
            }
        } catch (NumberFormatException ex) {
            flag = false;
        }

        if (!flag) {
            int clickedIndex = -1;
            for (int i = 0; i < 9; i++) {
                if (clicked == tiles[i]) {
                    clickedIndex = i;
                    break;
                }
            }

            if (clickedIndex != -1 && (clickedIndex == emptyIndex + 1 || clickedIndex == emptyIndex - 1
                    || clickedIndex == emptyIndex + 3 || clickedIndex == emptyIndex - 3)) {
                tiles[emptyIndex].setText(clicked.getText());
                clicked.setText("");
                emptyIndex = clickedIndex;
            }
        } else {

            jl.setBounds(150, 20, 300, 50);
            jl.setText("Congratulation!! You WON!!");
        }
    }

    public static void main(String[] args) {
        new P9();
    }

}