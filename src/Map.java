import javax.swing.*;
import java.awt.*;

public class Map extends JPanel {

    Map() {
        super();
        JButton poland = new JButton("Polska");
        JButton ukraine = new JButton("Ukraina");
        JButton belarus = new JButton("Białorus");
        JButton latvia = new JButton("Łotwa");
        JButton lithuania = new JButton("Litwa");
        JButton germany = new JButton("Niemcy");
        JButton czechRepublic = new JButton("Czechy");
        JButton norway = new JButton("Norwegia");
        JButton slovakia = new JButton("Słowacja");
        JButton china = new JButton("Chiny");
        JButton sweden = new JButton("Szwecja");
        JButton russia = new JButton("Rosja");

        add(poland);
        add(ukraine);
        add(belarus);
        add(latvia);
        add(lithuania);
        add(germany);
        add(czechRepublic);
        add(norway);
        add(slovakia);
        add(china);
        add(sweden);
        add(russia);

        setVisible(true);
        setLayout(new GridLayout(3, 3, 150, 150));
    }
}
