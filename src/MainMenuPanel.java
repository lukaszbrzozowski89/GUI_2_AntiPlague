import javax.swing.Box.Filler;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MainMenuPanel extends JPanel {
    private JButton exitBtn;
    private Filler filler1;
    private Filler filler2;
    private JButton highScoresBtn;
    private JButton newGameBtn;

    public MainMenuPanel() {
        create();
    }

    private void create() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        newGameBtn = new JButton();
        newGameBtn.setText("New Game");
        newGameBtn.setAlignmentX(0.5F);
        newGameBtn.addActionListener(this::newGameBtnClicked);
        add(newGameBtn);

        filler1 = new Filler(new Dimension(0, 5), new Dimension(0, 5), new Dimension(32767, 5));
        add(filler1);

        highScoresBtn = new javax.swing.JButton();
        highScoresBtn.setText("High Scores");
        highScoresBtn.setAlignmentX(0.5F);
        highScoresBtn.addActionListener(this::highScoresBtnClicked);
        add(highScoresBtn);

        filler2 = new Filler(new Dimension(0, 5), new Dimension(0, 5), new Dimension(32767, 5));
        add(filler2);

        exitBtn = new JButton();
        exitBtn.setText("Exit");
        exitBtn.setAlignmentX(0.5F);
        exitBtn.addActionListener(this::exitBtnClicked);
        add(exitBtn);
    }

    private void highScoresBtnClicked(ActionEvent event) {
        ((MenuWindow) SwingUtilities.getWindowAncestor(this)).setSubMenu(MenuWindow.SubMenu.HighScores);
    }

    private void newGameBtnClicked(ActionEvent event) {
        ((MenuWindow) SwingUtilities.getWindowAncestor(this)).setSubMenu(MenuWindow.SubMenu.GameOptions);
    }

    private void exitBtnClicked(ActionEvent event) {
        SwingUtilities.getWindowAncestor(this).dispose();
    }
}
