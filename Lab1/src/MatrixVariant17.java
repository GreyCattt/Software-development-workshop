import java.util.Random;

public class MatrixVariant17 {
    public static void main(String[] args) {
        System.out.println("Розробник: Прiзвище Рудий I.В.\n");
        System.out.println("Варiант №17\n");

        int rows = 4;
        int cols = 3;
        int[][] B = new int[rows][cols];
        Random random = new Random();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                B[i][j] = random.nextInt(31) - 15; 
            }
        }

        System.out.println("Матриця В (до обробки):");
        printMatrix(B);

        int sum = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (B[i][j] < 0 && B[i][j] % 2 != 0) {
                    sum += B[i][j];
                }
            }
        }

        System.out.println("\n--- РЕЗУЛЬТАТИ ---");
        System.out.println("Сума всiх вiд'ємних непарних елементiв: " + sum);
        System.out.println("Матриця В:");
        printMatrix(B);
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
}