import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Puzz extends JFrame implements ActionListener, KeyListener {
    private JButton[] tiles;

    private GridLayout grid;

    private int emptyIndex;

    private JPanel jp;

    private JLabel jl;

    private final int num = 9;

    Puzz() {
        super("16 Puzzle");
        grid = new GridLayout(4, 4);
        jp = new JPanel();
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }

        jl = new JLabel("Can You Solve this?");
        jl.setBounds(200, 20, 250, 50);
        jl.setFont(new Font("", Font.BOLD, 20));
        add(jl);

        tiles = new JButton[num];

        ArrayList<Integer> nums = new ArrayList<>();
        int i = 0;
        while (i < num - 1) {
            int nu = getRandomNumberUsingNextInt(1, num);
            boolean b = nums.indexOf(nu) != -1 ? false : true;
            if (b) {
                tiles[i] = new JButton("" + nu);
                tiles[i].addActionListener(this);
                tiles[i].addKeyListener(this);
                tiles[i].setFont(new Font("", Font.BOLD, 30));
                jp.add(tiles[i]);
                nums.add(nu);
                i++;
            }
        }

        tiles[num - 1] = new JButton();
        tiles[num - 1].addActionListener(this);
        tiles[num - 1].setFont(new Font("", Font.BOLD, 30));
        jp.add(tiles[num - 1]);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        jp.setBounds(10, 100, 560, 450);
        jp.setLayout(grid);
        jp.setBackground(Color.DARK_GRAY);
        jp.setVisible(true);
        add(jp);
        emptyIndex = num - 1;
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
                        tiles[emptyIndex].setText(tiles[emptyIndex - 4].getText());
                        tiles[emptyIndex - 4].setText("");
                        emptyIndex = emptyIndex - 4;
                        break;
                    case KeyEvent.VK_DOWN:
                        tiles[emptyIndex].setText(tiles[emptyIndex + 4].getText());
                        tiles[emptyIndex + 4].setText("");
                        emptyIndex = emptyIndex + 4;
                        break;
                    case KeyEvent.VK_LEFT:
                        if (emptyIndex % 4 != 0) {
                            tiles[emptyIndex].setText(tiles[emptyIndex - 1].getText());
                            tiles[emptyIndex - 1].setText("");
                            emptyIndex = emptyIndex - 1;
                        }
                        break;
                    case KeyEvent.VK_RIGHT:
                        if ((emptyIndex + 1) % 4 != 0) {
                            tiles[emptyIndex].setText(tiles[emptyIndex + 1].getText());
                            tiles[emptyIndex + 1].setText("");
                            emptyIndex = emptyIndex + 1;
                        }
                        break;
                }
            } catch (Exception ex) {
            }
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
            for (int i = 0; i < num; i++) {
                if (clicked == tiles[i]) {
                    clickedIndex = i;
                    break;
                }
            }

            if (clickedIndex != -1 && (clickedIndex == emptyIndex + 1 || clickedIndex == emptyIndex - 1
                    || clickedIndex == emptyIndex + 4 || clickedIndex == emptyIndex - 4)) {
                tiles[emptyIndex].setText(clicked.getText());
                clicked.setText("");
                emptyIndex = clickedIndex;
            }
        } else {
            jl.setText("Congratulation!! You WON!!");
        }
    }

    public static void main(String[] args) {
        new Puzz();
    }

}