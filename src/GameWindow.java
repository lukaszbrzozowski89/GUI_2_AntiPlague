import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


public class GameWindow extends JFrame {
    private JPanel gamePanel;
    private JButton leaveBtn;
    private JPanel statusPanel;
    private JLabel timeLabel;

    private Timer timer;
    private int time;

    private int size, width, height;

    public GameWindow(int width, int height, JFrame menuWnd) {
        this.size = width * height / 2;
        this.width = width;
        this.height = height;

        WindowListener leaveListener = new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int confirm = JOptionPane.showOptionDialog(
                        null, "Are you sure you want to leave the game?",
                        "Confirm", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, null, null);
                if (confirm == JOptionPane.YES_OPTION) {
                    ((JFrame) e.getSource()).setVisible(false);
                    menuWnd.setVisible(true);
                    timer.stop();
                    ((JFrame) e.getSource()).dispose();
                }
            }
        };
        addWindowListener(leaveListener);

        create();

        timer = new Timer(1000, (ActionEvent e) -> {
            ++time;
            timeLabel.setText("Time: " + String.format("%02d:%02d", time / 60, time % 60));
        });
        timer.start();
    }

    private void create() {
        timeLabel = new JLabel();
        Map map = new Map();
        setIconImage(new ImageIcon("icon.png").getImage());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Project GUI");
        setMinimumSize(new Dimension(1280, 720));
        setPreferredSize(new Dimension(1280, 720));

        statusPanel = new JPanel();
        statusPanel.setLayout(new BorderLayout());
        statusPanel.add(timeLabel, BorderLayout.WEST);

        leaveBtn = new JButton();
        leaveBtn.setText("To leave game click ALT + Q or click here");
        leaveBtn.setMnemonic('Q');
        leaveBtn.addActionListener(this::leaveBtnClicked);
        statusPanel.add(leaveBtn, BorderLayout.EAST);
        getContentPane().add(map, BorderLayout.CENTER);
        getContentPane().add(statusPanel, BorderLayout.PAGE_END);


        gamePanel = new JPanel();
        gamePanel.setLayout(new GridLayout(width, height));

    }

    private void leaveBtnClicked(ActionEvent evt) {
        processWindowEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }

}
