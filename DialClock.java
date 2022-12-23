import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;

import javax.swing.*;

public class DialClock extends JPanel {
    private static final long serialVersionUID = 1L;
    private Calendar calendar = Calendar.getInstance();
    private int hour = calendar.get(Calendar.HOUR_OF_DAY);
    private int minute = calendar.get(Calendar.MINUTE);
    private int second = calendar.get(Calendar.SECOND);

    public DialClock() {
        Timer timer = new Timer(1000, new TimerActionListener());
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.translate(getWidth() / 2, getHeight() / 2);
        g2d.scale(0.8, 0.8);
        g2d.rotate(-Math.PI / 2);

        g2d.setStroke(new BasicStroke(1.5f));
        g2d.setFont(new Font("SansSerif", Font.PLAIN, 10));
        for (int i = 0; i < 12; i++) {
            double angle = Math.PI / 6 * i;
            int x = (int) (Math.cos(angle) * 100);
            int y = (int) (Math.sin(angle) * 100);
            g2d.drawString(String.valueOf(i + 1), x - 3, y + 3);
            g2d.drawLine(x, y, (int) (x * 0.9), (int) (y * 0.9));
        }
        g2d.setStroke(new BasicStroke(3f));
        g2d.drawArc(-100, -100, 200, 200, 0, 360);

        double angle = Math.PI * hour / 6 + Math.PI / 360 * minute + Math.PI / 21600 * second;
        int x = (int) (Math.cos(angle) * 70);
        int y = (int) (Math.sin(angle) * 70);
        g2d.setColor(Color.BLACK);
        g2d.drawLine(0, 0, x, y);

        angle = Math.PI * minute / 30 + Math.PI / 1800 * second;
        x = (int) (Math.cos(angle) * 90);
        y = (int) (Math.sin(angle) * 90);
        g2d.setColor(Color.BLACK);
        g2d.drawLine(0, 0, x, y);

        angle = Math.PI * second / 30;
        x = (int) (Math.cos(angle) * 100);
        y = (int) (Math.sin(angle) * 100);
        g2d.setColor(Color.RED);
        g2d.drawLine(0, 0, x, y);
    }

    private class TimerActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            calendar = Calendar.getInstance();
            hour = calendar.get(Calendar.HOUR_OF_DAY);
            minute = calendar.get(Calendar.MINUTE);
            second = calendar.get(Calendar.SECOND);
            repaint();
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 200);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.add(new DialClock(), BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}