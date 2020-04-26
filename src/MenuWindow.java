
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
        setSubMenu(SubMenu.Main);
    }

    public void setSubMenu(SubMenu sm) throws IllegalArgumentException {
        switch (sm) {
            case Main:
                highScoresPanel.setVisible(false);
                gameOptionsPanel.setVisible(false);
                controlPanel.setVisible(false);
                mainMenuPanel.setVisible(true);
                break;
            case HighScores:
                mainMenuPanel.setVisible(false);
                gameOptionsPanel.setVisible(false);
                highScoresPanel.setVisible(true);
                controlPanel.setVisible(true);
                break;
            case GameOptions:
                mainMenuPanel.setVisible(false);
                highScoresPanel.setVisible(false);
                gameOptionsPanel.setVisible(true);
                controlPanel.setVisible(true);
                break;
            default:
                throw new IllegalArgumentException("unsupported submenu type");
        }
    }

    private void create() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Projekt GUI");
        setMinimumSize(new Dimension(640, 360));
        setPreferredSize(new Dimension(640, 360));

        filler1 = new Filler(new Dimension(0, 0), new Dimension(0, 0), new Dimension(32767, 0)); // sztuczne wypełnienie
        filler2 = new Filler(new Dimension(0, 0), new Dimension(0, 0), new Dimension(32767, 0)); // tak zwany klej ( glue)
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
        setSubMenu(SubMenu.Main);
    }

    public enum SubMenu { // enum - pole enumeracyjne udogodnienie (zeby nie bylo jakis stringow)
        Main, HighScores, GameOptions
    }
}
