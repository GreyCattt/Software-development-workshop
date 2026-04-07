import java.util.Random;

public class TextProcessingVariant17 {
    public static void main(String[] args) {
        System.out.println("Розробник: Рудий I.В.");
        System.out.println("Лабораторна робота №2. Варiант №17\n");
        int length = 6;
        String originalNumber = generateRandomNumberString(length);
        System.out.println("Оригiнальне число: " + originalNumber);
        String processedNumber = processString(originalNumber);
        System.out.println("Оброблене число:   " + processedNumber);
    }

    private static String generateRandomNumberString(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        sb.append(random.nextInt(9) + 1); 

        for (int i = 1; i < length; i++) {
            sb.append(random.nextInt(10));
        }
        
        return sb.toString();
    }
    private static String processString(String numberStr) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numberStr.length(); i++) {
            char ch = numberStr.charAt(i);
            int digit = Character.getNumericValue(ch);

            if (digit == 9) {
                result.append('0');
            } else if (digit == 2) {
                result.append('1');
            } else {
                result.append(ch); 
            }
            
            if (digit % 2 == 0) {
                result.append(digit * 2);
            }
        } 
        return result.toString();
    }
}