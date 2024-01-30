import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    static String FILE_PATH = "results.txt";
    private static void saveToFile(String text) {
        File file = new File(FILE_PATH);
        FileWriter writer = null;
        try {
            writer = new FileWriter(file,true);
            writer.write(text);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        Lotto lotto = new Lotto();
        lotto.put(new Toy(1, "Teddy", 4));
        lotto.put(new Toy(3, "Doll", 7));
        lotto.put(new Toy(2, "Robot", 5));

        for (int attempt = 1; attempt <= 11; attempt++) {
            Toy toy = lotto.get();
            if (toy != null) {
                String str = String.format("Результат розыгрыша %d: %s\n", attempt, toy);
                System.out.printf(str);
                saveToFile(str);
            } else {
                String str = String.format("Розыгрыш остановлен %d: \n", attempt);
                System.out.printf(str);
                saveToFile(str);
                break;
            }
        }
        String str = lotto.getToysQty();
        System.out.println(str);
        saveToFile(str);
    }
}
