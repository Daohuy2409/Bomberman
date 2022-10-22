package uet.oop.bomberman.graphics;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MapLevel {
    public static int level;
    public static int rows;
    public static int cols;
    public static char[][] mapArr;
    public static void setMapArr() {
        try{
            File file = new File("res/levels/Level1.txt");
            Scanner scanner = new Scanner(file);
            if (scanner.hasNextInt()) {
                level = scanner.nextInt();
                rows = scanner.nextInt();
                cols = scanner.nextInt();
                scanner.nextLine();
            }
            int line = 0;
            mapArr = new char[rows][cols];
            while (scanner.hasNextLine() && line < rows) {
                char[] text = scanner.nextLine().toCharArray();
                if (cols >= 0) System.arraycopy(text, 0, mapArr[line], 0, cols);
                line++;
            }
            for (int i = 0; i<rows; ++i) {
                for (int j= 0; j< cols; ++j) {
                    System.out.print(mapArr[i][j]);
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        setMapArr();
    }
}
