package figure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class Figure {
    public static void main(String[] args) throws IndexOutOfBoundsException, IOException {
        String fileName = getFileName();
        if (Files.exists(Paths.get(fileName))) {
            AbstractFigure figureFromFile = getFigureFromFile(fileName);
            figureFromFile.getInfoFigure();
        } else {
            System.out.println("Данный файл не найден!");
        }
    }

    public static String getFileName() throws IOException {
        System.out.println("Введите название файла:");
        Reader reader = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(reader);
        String fileName = in.readLine() + ".txt";
        return fileName;

    }

    public static AbstractFigure getFigureFromFile(String fileName) throws IOException {
        AbstractFigure result = null;
        List<String> lines = Files.readAllLines(Paths.get(fileName), Charset.defaultCharset());
        String figure = lines.get(0);
        switch (figure) {
            case "CIRCLE": 
                result = new Circle(Integer.parseInt(lines.get(1)));
                break;
            case "SQUARE":
                result = new Square(Integer.parseInt(lines.get(1)));
                break;
            case "RECTANGLE": 
                result = new Rectangle(Integer.parseInt(lines.get(1)), Integer.parseInt(lines.get(2))); 
                break;
                }
        return result;
    }
}