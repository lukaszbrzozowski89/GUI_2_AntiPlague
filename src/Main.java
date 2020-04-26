import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        HighScores.loadFromFile();

        Runtime.getRuntime().addShutdownHook(new Thread(HighScores::saveToFile));

        javax.swing.SwingUtilities.invokeLater(() -> {
            JFrame menuWnd = new MenuWindow();
            menuWnd.setVisible(true);
        });
    }
}
