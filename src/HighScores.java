import java.io.*;
import java.util.ArrayList;


public class HighScores{

    private static final String FILE_PATH = "highscores.dat";

    public static class Row {
        public final String name;
        public final int score;

        public Row(String name, int score) {
            this.name = name.substring(0, name.length() >= 127 ? 127 : name.length());
            this.score = score;
        }
    }


    public static final ArrayList<Row> list = new ArrayList<>();

    public static ArrayList<Row> getList() {
        return list;
    }

    public static void loadFromFile() {
        list.clear();
        DataInputStream input = null;
        try {
            input = new DataInputStream(new FileInputStream(FILE_PATH));
            while (input.available() > 0) {
                String name = "";
                byte nameLen = input.readByte();
                for (byte i = 0; i < nameLen; ++i)
                    name += input.readChar();
                int score = input.readInt();
                list.add(new Row(name, score));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (input != null) {
                    input.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void saveToFile() {
        DataOutputStream output = null;
        try {
            File file = new File(FILE_PATH);
            file.createNewFile();
            output = new DataOutputStream(new FileOutputStream(file));
            for (Row row : list) {
                output.writeByte(row.name.length());
                output.writeChars(row.name);
                output.writeInt(row.score);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (output != null) {
                    output.close();

                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
