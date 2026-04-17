import java.util.InputMismatchException;
import java.util.Scanner;
import java.nio.charset.StandardCharsets;
import java.io.PrintStream;

public class ParkAppVariant17 {
    public static void main(String[] args) {
        configureWindowsConsoleUtf8();
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        System.setErr(new PrintStream(System.err, true, StandardCharsets.UTF_8));

        System.out.println("Розробник: Рудий І.В.");
        System.out.println("Лабораторна робота №5. Варіант №17\n");

        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        Park myPark = new Park("Центральний Парк Відпочинку");

        myPark.addAttraction("Американські гірки", "10:00-22:00", 250.0, 14);
        myPark.addAttraction("Колесо огляду", "09:00-23:00", 150.0, 3);
        myPark.addAttraction("Кімната страху", "12:00-00:00", 200.0, 16);

        boolean running = true;
        while (running) {
            System.out.println("\n--- МЕНЮ ПАРКУ ---");
            System.out.println("1. Додати новий атракціон");
            System.out.println("2. Показати всі атракціони");
            System.out.println("3. Знайти атракціон (за віком та ціною)");
            System.out.println("0. Вихід");
            System.out.print("Ваш вибір: ");

            int choice = getValidInt(scanner);

            switch (choice) {
                case 1:
                    System.out.print("Введіть назву/тип: ");
                    String type = scanner.nextLine();
                    System.out.print("Введіть час роботи (напр. 10:00-20:00): ");
                    String hours = scanner.nextLine();
                    System.out.print("Введіть вартість квитка: ");
                    double cost = getValidDouble(scanner);
                    System.out.print("Введіть мінімальний вік: ");
                    int age = getValidInt(scanner);
                    
                    myPark.addAttraction(type, hours, cost, age);
                    break;
                case 2:
                    myPark.showAllAttractions();
                    break;
                case 3:
                    System.out.print("Введіть ваш вік: ");
                    int searchAge = getValidInt(scanner);
                    System.out.print("Введіть ваш максимальний бюджет (грн): ");
                    double maxCost = getValidDouble(scanner);
                    
                    myPark.searchAttractions(searchAge, maxCost);
                    break;
                case 0:
                    running = false;
                    System.out.println("[СТАТУС] Вихід з програми...");
                    break;
                default:
                    System.out.println("[ПОМИЛКА] Невідома команда.");
            }
        }
        scanner.close();
    }

    private static void configureWindowsConsoleUtf8() {
        if (!System.getProperty("os.name").toLowerCase().contains("win")) {
            return;
        }

        try {
            Process process = new ProcessBuilder("cmd", "/c", "chcp 65001 > nul").start();
            process.waitFor();
        } catch (Exception e) {
    
        }
    }


    private static int getValidInt(Scanner scanner) {
        while (true) {
            try {
                int value = scanner.nextInt();
                scanner.nextLine(); 
                return value;
            } catch (InputMismatchException e) {
                System.out.print("[ПОМИЛКА] Будь ласка, введіть ціле число: ");
                scanner.nextLine();
            }
        }
    }

    private static double getValidDouble(Scanner scanner) {
        while (true) {
            try {
                String input = scanner.next().replace(',', '.');
                double value = Double.parseDouble(input);
                scanner.nextLine();
                return value;
            } catch (NumberFormatException e) {
                System.out.print("[ПОМИЛКА] Будь ласка, введіть число (наприклад 150.50): ");
                scanner.nextLine();
            }
        }
    }
}