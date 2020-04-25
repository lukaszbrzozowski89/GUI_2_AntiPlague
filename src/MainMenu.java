import javax.swing.*;
import java.awt.*;

import static javax.swing.SwingConstants.CENTER;

public class MainMenu extends JFrame {


    public MainMenu() {
        JPanel jPanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.PAGE_AXIS));
        int frameHeight = getSize().height;
        int frameWidth = getSize().width;
        setSize(Utils.width / 2, Utils.height / 2);

        setLocation((Utils.width - frameWidth) / 2, (Utils.height - frameHeight) / 2);
        JButton buttonNewGame = new JButton("New game");
        JButton buttonHighScore = new JButton("High scores");
        JButton buttonQuitGame = new JButton("Quit");
        buttonPanel.add(buttonNewGame);
        buttonPanel.add(buttonHighScore);
        buttonPanel.add(buttonQuitGame);
        jPanel.add(buttonPanel);

        jPanel.setBackground(Color.darkGray);
        buttonHighScore.addActionListener(e -> {
            onHighScoreClick();
        });
        buttonQuitGame.addActionListener(e -> {
            onQuitClick();
        });

        buttonNewGame.addActionListener(e -> {
            onNemGameClick();
        });
        add(jPanel);
        setResizable(false);
        setAlwaysOnTop(true);
        setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png"));
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void onNemGameClick() {

        //TODO

    }


    private void onHighScoreClick() {
        JDialog dialog = new JDialog();
        JList<String> jList = new JList<>();
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        dialog.setSize(width / 2, height / 2);
        int frameHeight = getSize().height;
        int frameWidth = getSize().width;
        dialog.setLocation((width - frameWidth) / 2, (height - frameHeight) / 2);

        dialog.setAlwaysOnTop(true);
        dialog.setVisible(true);
        dialog.setAutoRequestFocus(true);
        dialog.setTitle("High scores");
        dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void onQuitClick() {
        JDialog quitDialog = new JDialog();
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.PAGE_AXIS));

        quitDialog.setSize(250, 150);
        quitDialog.setLocation(400,400);
        quitDialog.setTitle("Quit");
        JLabel quitText = new JLabel();
        quitText.setText("Are you sure you want to exit?");
        quitText.setEnabled(false);
        quitText.setHorizontalAlignment(CENTER);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setAlignmentY(CENTER_ALIGNMENT);
        JButton yesButton = new JButton("Yes");
        JButton noButton = new JButton("No");
        buttonPanel.add(yesButton);
        buttonPanel.add(noButton);
        jPanel.add(quitText);
        jPanel.add(buttonPanel);

        yesButton.addActionListener(e -> System.exit(0));
        noButton.addActionListener(e -> quitDialog.dispose());
        quitDialog.add(jPanel);
        quitDialog.setAlwaysOnTop(true);
        quitDialog.setVisible(true);
        quitDialog.setAutoRequestFocus(true);
        quitDialog.setTitle("Quit");
        quitDialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
