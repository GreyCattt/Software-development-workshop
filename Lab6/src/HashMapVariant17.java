import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapVariant17 {
    public static void main(String[] args) {
        System.out.println("Розробник: Рудий I.В.");
        System.out.println("Лабораторна робота №6. Варiант №17\n");

        Map<String, List<Integer>> gradebook = new HashMap<>();

        gradebook.put("Олексiй", Arrays.asList(95, 92, 98, 90)); 
        gradebook.put("Iван", Arrays.asList(75, 80, 85, 82));   
        gradebook.put("Марiя", Arrays.asList(98, 100, 95, 96));  
        gradebook.put("Анна", Arrays.asList(88, 85, 90, 89));   
        gradebook.put("Петро", Arrays.asList(60, 70, 65, 75));

        System.out.println("--- ЗАГАЛЬНИЙ ЖУРНАЛ УСПIШНОСТI ---");
        printGradebook(gradebook);

        Map<String, List<Integer>> needsImprovement = new HashMap<>();


        for (Map.Entry<String, List<Integer>> entry : gradebook.entrySet()) {
            String studentName = entry.getKey();
            List<Integer> grades = entry.getValue();

            double average = calculateAverage(grades);

            if (average < 90.0) {
                needsImprovement.put(studentName, grades);
            }
        }

        System.out.println("\n--- СТУДЕНТИ IЗ СЕРЕДНIМ БАЛОМ НИЖЧЕ 90 ---");
        if (needsImprovement.isEmpty()) {
            System.out.println("Таких студентiв немає. Всi вчаться вiдмiнно!");
        } else {
            printGradebook(needsImprovement);
        }
    }

    private static double calculateAverage(List<Integer> grades) {
        if (grades == null || grades.isEmpty()) return 0;
        
        double sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }

    private static void printGradebook(Map<String, List<Integer>> map) {
        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            String name = entry.getKey();
            List<Integer> grades = entry.getValue();
            double avg = calculateAverage(grades);
            
            System.out.printf("Студент: %-10s | Оцiнки: %-15s | Середнiй бал: %.2f\n", 
                    name, grades.toString(), avg);
        }
    }
}