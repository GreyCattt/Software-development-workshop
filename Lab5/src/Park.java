import java.util.ArrayList;

public class Park {
    private String name;
    private ArrayList<Attraction> attractions;

    public Park(String name) {
        this.name = name;
        this.attractions = new ArrayList<>();
    }

    public class Attraction {
        private String type;
        private String workingHours;
        private double cost;
        private int minAge;

        public Attraction(String type, String workingHours, double cost, int minAge) {
            this.type = type;
            this.workingHours = workingHours;
            this.cost = cost;
            this.minAge = minAge;
        }

        public void displayInfo() {
            System.out.printf("| %-18s | %-12s | %7.2f | %-6d |\n", type, workingHours, cost, minAge);
        }

        public int getMinAge() { return minAge; }
        public double getCost() { return cost; }
    }

    public void addAttraction(String type, String hours, double cost, int minAge) {
        Attraction attraction = this.new Attraction(type, hours, cost, minAge);
        attractions.add(attraction);
        System.out.println("[СТАТУС] Атракціон '" + type + "' успішно додано до парку!");
    }

    public void showAllAttractions() {
        System.out.println("\n--- Атракціони парку: " + name + " ---");
        printTableHeader();
        if (attractions.isEmpty()) {
            System.out.println("| Парк поки порожній. Додайте атракціони!                        |");
        } else {
            for (Attraction a : attractions) {
                a.displayInfo();
            }
        }
        System.out.println("---------------------------------------------------------");
    }

    public void searchAttractions(int userAge, double maxCost) {
        System.out.println("\n[СТАТУС] Пошук атракціонів для віку " + userAge + "+ та бюджетом до " + maxCost + " грн...");
        boolean found = false;
        
        printTableHeader();
        for (Attraction a : attractions) {
            if (userAge >= a.getMinAge() && a.getCost() <= maxCost) {
                a.displayInfo();
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("| За вашими критеріями нічого не знайдено.                       |");
        }
        System.out.println("---------------------------------------------------------");
    }

    private void printTableHeader() {
        System.out.println("---------------------------------------------------------");
        System.out.printf("| %-18s | %-12s | %-7s | %-6s |\n", "Тип (Назва)", "Час роботи", "Вартість", "Вік від");
        System.out.println("---------------------------------------------------------");
    }
}