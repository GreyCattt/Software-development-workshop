import java.util.InputMismatchException;
import java.util.Scanner;

public class FlowerShopVariant17 {
    public static void main(String[] args) {
        System.out.println("Розробник: Рудий I.В.");
        System.out.println("Лабораторна робота №3. Варiант №17\n");

        Flower[] shop = {
            new Flower(1, "Орхідея", "Кімнатна", "Квітуча", "Фаленопсис", 450.50, 15),
            new Flower(2, "Орхідея", "Кімнатна", "Квітуча", "Дендробіум", 500.00, 5),
            new Flower(3, "Фікус", "Кімнатна", "Листяна", "Бенджаміна", 300.00, 10),
            new Flower(4, "Троянда", "Вулична", "Квітуча", "Кущова", 150.00, 50),
            new Flower(5, "Фіалка", "Кімнатна", "Квітуча", "Сенполія", 120.00, 20)
        };

        Scanner scanner = new Scanner(System.in);
        
        System.out.println("--- АСОРТИМЕНТ МАГАЗИНУ ---");
        printTable(shop);

        boolean running = true;
        while (running) {
            System.out.println("\nОберiть дiю:");
            System.out.println("1 - Показати кiмнатнi квiтучi рослини та їх цiну (Завдання 1)");
            System.out.println("2 - Пошук пiдвидiв квiтки та їх кiлькостi (Завдання 2)");
            System.out.println("3 - Вихiд");
            
            int choice = getValidIntInput(scanner, "Ваш вибiр: ", 1, 3);

            switch (choice) {
                case 1:
                    printIndoorBlooming(shop);
                    break;
                case 2:
                    System.out.print("Введiть назву квiтки для пошуку (наприклад, Орхідея): ");
                    String searchName = scanner.nextLine();
                    printSubspeciesByName(shop, searchName);
                    break;
                case 3:
                    running = false;
                    System.out.println("Роботу завершено.");
                    break;
            }
        }
        scanner.close();
    }
    private static int getValidIntInput(Scanner scanner, String prompt, int min, int max) {
        int result = -1;
        while (true) {
            System.out.print(prompt);
            try {
                result = scanner.nextInt();
                scanner.nextLine(); 
                
                if (result >= min && result <= max) {
                    break; 
                } else {
                    System.out.println("Помилка: число повинно бути в дiапазонi вiд " + min + " до " + max + ".");
                }
            } catch (InputMismatchException e) {
                System.out.println("Помилка вводу! Очiкується цiле число.");
                scanner.nextLine(); 
            }
        }
        return result;
    }

    private static void printIndoorBlooming(Flower[] array) {
        System.out.println("\n--- РЕЗУЛЬТАТ ПОШУКУ (Кiмнатнi квiтучi рослини) ---");
        System.out.printf("| %-12s | %-12s | %-8s |\n", "Найменування", "Пiдвид", "Цiна");
        System.out.println("------------------------------------------");
        
        boolean found = false;
        for (Flower f : array) {
            if (f.type.equalsIgnoreCase("Кімнатна") && f.species.equalsIgnoreCase("Квітуча")) {
                System.out.printf("| %-12s | %-12s | %8.2f |\n", f.name, f.subspecies, f.price);
                found = true;
            }
        }
        if (!found) {
            System.out.println("За заданим критерiєм нiчого не знайдено.");
        }
    }

    private static void printSubspeciesByName(Flower[] array, String nameToSearch) {
        System.out.println("\n--- РЕЗУЛЬТАТ ПОШУКУ (Пiдвиди для: " + nameToSearch + ") ---");
        System.out.printf("| %-15s | %-10s |\n", "Пiдвид", "Кiлькiсть");
        System.out.println("------------------------------");
        
        boolean found = false;
        for (Flower f : array) {
            if (f.name.equalsIgnoreCase(nameToSearch)) {
                System.out.printf("| %-15s | %-10d |\n", f.subspecies, f.quantity);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Квiтку з такою назвою не знайдено.");
        }
    }

    private static void printTable(Flower[] array) {
        System.out.printf("| %-2s | %-10s | %-9s | %-10s | %-12s | %-7s | %-8s |\n", 
                "ID", "Назва", "Тип", "Вид", "Пiдвид", "Цiна", "К-сть");
        System.out.println("-----------------------------------------------------------------------------");
        for (Flower f : array) {
            System.out.printf("| %-2d | %-10s | %-9s | %-10s | %-12s | %7.2f | %-8d |\n", 
                    f.id, f.name, f.type, f.species, f.subspecies, f.price, f.quantity);
        }
        System.out.println("-----------------------------------------------------------------------------");
    }
}