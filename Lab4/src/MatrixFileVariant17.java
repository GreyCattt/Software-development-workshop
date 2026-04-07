import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MatrixFileVariant17 {
    public static void main(String[] args) {
        System.out.println("Розробник: Рудий I.В.");
        System.out.println("Лабораторна робота №4. Варiант №17\n");

        Scanner consoleScanner = new Scanner(System.in);
        System.out.print("Введiть шлях до вхiдного файлу (наприклад, input.txt): ");
        String inputFilePath = consoleScanner.nextLine();

        System.out.print("Введiть шлях для збереження результату (наприклад, output.txt): ");
        String outputFilePath = consoleScanner.nextLine();

        System.out.println("\n--- ПОЧАТОК ОБРОБКИ ---");

        int[][] matrix = null;
        int n = 0;
        try {
            System.out.println("[СТАТУС] Вiдкриваємо файл для читання: " + inputFilePath);
            File inputFile = new File(inputFilePath);
            Scanner fileScanner = new Scanner(inputFile);

            if (fileScanner.hasNextInt()) {
                n = fileScanner.nextInt();
                System.out.println("[СТАТУС] Розмiрнiсть матрицi: " + n + "x" + n);
                matrix = new int[n][n];

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (fileScanner.hasNextInt()) {
                            matrix[i][j] = fileScanner.nextInt();
                        } else {
                            System.out.println("[ПОМИЛКА] Недостатньо даних у файлi для матрицi " + n + "x" + n);
                            return;
                        }
                    }
                }
                System.out.println("[СТАТУС] Матрицю устiшно прочитано з файлу.");
            } else {
                System.out.println("[ПОМИЛКА] Файл порожнiй або має неправильний формат.");
                return;
            }
            fileScanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("[ПОМИЛКА] Вхiдний файл не знайдено! Перевiрте шлях: " + inputFilePath);
            return;
        }

        System.out.println("[СТАТУС] Виконуємо розворот матрицi на 180 градусiв...");
        int[][] rotatedMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotatedMatrix[n - 1 - i][n - 1 - j] = matrix[i][j];
            }
        }
        System.out.println("[СТАТУС] Обробку завершено.");

        try {
            System.out.println("[СТАТУС] Вiдкриваємо файл для запису: " + outputFilePath);
            PrintWriter writer = new PrintWriter(new File(outputFilePath));

            writer.println(n);

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    writer.print(rotatedMatrix[i][j] + "\t"); 
                }
                writer.println();
            }
            
            writer.close();
            System.out.println("[СТАТУС] Результат успiшно збережено у файл: " + outputFilePath);

        } catch (FileNotFoundException e) {
            System.out.println("[ПОМИЛКА] Не вдалося створити файл для запису: " + outputFilePath);
        }

        System.out.println("--- РОБОТУ ЗАВЕРШЕНО ---");
        consoleScanner.close();
    }
}