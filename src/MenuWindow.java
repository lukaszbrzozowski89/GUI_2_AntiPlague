
import javax.swing.Box.Filler;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MenuWindow extends JFrame {
    private JButton backBtn;
    private JPanel controlPanel;
    private Filler filler1, filler2;
    private GameOptionsPanel gameOptionsPanel;
    private HighScoresPanel highScoresPanel;
    private MainMenuPanel mainMenuPanel;
    private JPanel submenuPanel;

    public MenuWindow() {
        create();
        setSubMenu(SubMenu.MAIN);
    }

    public void setSubMenu(SubMenu sm) throws IllegalArgumentException {
        switch (sm) {
            case MAIN:
                highScoresPanel.setVisible(false);
                gameOptionsPanel.setVisible(false);
                controlPanel.setVisible(false);
                mainMenuPanel.setVisible(true);
                break;
            case HIGH_SCORES:
                mainMenuPanel.setVisible(false);
                gameOptionsPanel.setVisible(false);
                highScoresPanel.setVisible(true);
                controlPanel.setVisible(true);
                break;
            case GAME_OPTIONS:
                mainMenuPanel.setVisible(false);
                highScoresPanel.setVisible(false);
                gameOptionsPanel.setVisible(true);
                controlPanel.setVisible(true);
                break;
            default:
                throw new IllegalArgumentException("Unsupported submenu type");
        }
    }

    private void create() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Project GUI");
        setIconImage(new ImageIcon("icon.png").getImage());
        setMinimumSize(new Dimension(640, 360));
        setPreferredSize(new Dimension(640, 360));

        filler1 = new Filler(new Dimension(0, 0), new Dimension(0, 0), new Dimension(32767, 0));
        filler2 = new Filler(new Dimension(0, 0), new Dimension(0, 0), new Dimension(32767, 0));
        mainMenuPanel = new MainMenuPanel();
        highScoresPanel = new HighScoresPanel();
        gameOptionsPanel = new GameOptionsPanel();
        controlPanel = new JPanel();

        submenuPanel = new JPanel();
        submenuPanel.setLayout(new BoxLayout(submenuPanel, BoxLayout.LINE_AXIS));
        submenuPanel.add(filler1);
        submenuPanel.add(mainMenuPanel);
        submenuPanel.add(highScoresPanel);
        submenuPanel.add(gameOptionsPanel);
        submenuPanel.add(filler2);

        getContentPane().add(submenuPanel, BorderLayout.CENTER);

        backBtn = new JButton();
        backBtn.setText("Back");
        backBtn.setAlignmentX(0.5F);
        backBtn.addActionListener(this::backBtnClicked);
        controlPanel.add(backBtn);

        getContentPane().add(controlPanel, BorderLayout.SOUTH);

        pack();
    }

    private void backBtnClicked(ActionEvent evt) {
        setSubMenu(SubMenu.MAIN);
    }

    public enum SubMenu {
        MAIN, HIGH_SCORES, GAME_OPTIONS
    }
}
