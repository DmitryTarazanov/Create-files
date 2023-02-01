package src;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {
    static Calendar calendar = new GregorianCalendar();
    public static void main(String[] args) {


        File dir1 = new File("D://Games/src");
        createDir(dir1);

        File dir2 = new File("D://Games/res");
        createDir(dir2);

        File dir3 = new File("D://Games/savegames");
        createDir(dir3);

        File dir4 = new File("D://Games/temp");
        createDir(dir4);

        File dir5 = new File("D://Games/src/main");
        createDir(dir5);

        File dir6 = new File("D://Games/src/test");
        createDir(dir6);

        File file1 = new File("D://Games/src/main", "Main.java");
        createFile(file1);

        File file2 = new File("D://Games/src/main", "Utils.java");
        createFile(file2);

        File dir7 = new File("D://Games/res/drawables");
        createDir(dir7);

        File dir8 = new File("D://Games/res/vectors");
        createDir(dir8);

        File dir9 = new File("D://Games/res/icons");
        createDir(dir9);

        File file3 = new File("D://Games/temp", "temp.txt");
        createFile(file3);
    }

    public static void createDir(File file) {
        if (!file.mkdir()) {
            logging(file, false);
        } else {
            logging(file, true);
        }
    }

    public static void createFile(File file) {
        try {
            if (!file.createNewFile()) {
                logging(file,false);
            } else {
                logging(file,true);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void logging(File file,boolean condition) {
        String logRoot= "D://Games/temp/temp.txt";
        try (FileWriter writer = new FileWriter(logRoot, true)) {
        StringBuilder stringBuilder = new StringBuilder();
            if (condition) {
                StringBuilder log = stringBuilder
                        .append("[" + calendar.getTime() + " ")
                        .append("Создание в родительском каталоге " + file.getPath() + (file.isDirectory() ? " директории " : " файла ") + file.getName() + " ]\n");
                writer.write(log.toString());
                writer.flush();
            } else {
                StringBuilder log = stringBuilder
                        .append("[" + calendar.getTime() + " ")
                        .append("EXCEPTION! Создание в родительском каталоге " + file.getPath() + (file.isDirectory() ? " директории " : " файла ") + file.getName() + " не состоялось]\n");
                writer.write(log.toString());
                writer.flush();
            }
        }  catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
