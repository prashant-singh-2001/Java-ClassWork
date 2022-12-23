import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class DigitalClock extends JFrame {

    private static final long serialVersionUID = 1L;

    private JLabel timeLabel;

    public DigitalClock() {
        setTitle("Digital Clock");
        setSize(new Dimension(300, 100));
        setLayout(new BorderLayout());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        timeLabel = new JLabel();
        timeLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 48));
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(timeLabel, BorderLayout.CENTER);

        // Start the clock thread
        Thread clockThread = new Thread(new ClockRunnable());
        clockThread.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DigitalClock().setVisible(true);
            }
        });
    }

    private class ClockRunnable implements Runnable {

        @Override
        public void run() {
            while (true) {
                Calendar calendar = new GregorianCalendar();
                int hour = calendar.get(Calendar.HOUR_OF_DAY);
                int minute = calendar.get(Calendar.MINUTE);
                int second = calendar.get(Calendar.SECOND);
                String time = String.format("%02d:%02d:%02d", hour, minute, second);
                timeLabel.setText(time);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
