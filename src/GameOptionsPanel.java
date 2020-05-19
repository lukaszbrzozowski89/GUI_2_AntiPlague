import javax.swing.Box.Filler;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GameOptionsPanel extends JPanel {
    private Filler filler1, filler2;
    private JComboBox<String> sizeCombo;
    private JLabel sizeLabel;
    private JButton startBtn;

    private int[][] sizes = new int[][]{{4, 4}, {6, 4}, {6, 5}};

    public GameOptionsPanel() {
        create();
    }

    private void create() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setAlignmentX(0.5F);
        setMaximumSize(new Dimension(220, 80));
        setMinimumSize(new Dimension(220, 80));
        setPreferredSize(new Dimension(220, 80));

        sizeLabel = new JLabel();
        sizeLabel.setText("Choose difficulty:");
        sizeLabel.setAlignmentX(0.5F);
        add(sizeLabel);
        filler1 = new Filler(new Dimension(0, 4), new Dimension(0, 4), new Dimension(32767, 4));
        add(filler1);

        sizeCombo = new JComboBox<>();
        sizeCombo.setModel(new DefaultComboBoxModel<>(new String[]{
                "Easy",
                "Medium",
                "Hard"
        }));
        sizeCombo.setMaximumSize(new Dimension(32767, 25));
        add(sizeCombo);

        filler2 = new Filler(new Dimension(0, 4), new Dimension(0, 4), new Dimension(32767, 4));
        add(filler2);

        startBtn = new JButton();
        startBtn.setText("Start game...");
        startBtn.setAlignmentX(0.5F);
        startBtn.addActionListener((ActionEvent evt) -> {
            startBtnClicked();
        });
        add(startBtn);
    }

    private void startBtnClicked() {
        MenuWindow menuWnd = (MenuWindow) SwingUtilities.getWindowAncestor(this);

        GameWindow gameWnd = new GameWindow(200, 400, menuWnd);
        gameWnd.setVisible(true);
        menuWnd.setSubMenu(MenuWindow.SubMenu.MAIN);
        menuWnd.setVisible(false);
    }
}
