package app;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = new int[4][4];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int) (Math.random() * 50)+1;
            }
        }

        System.out.println("Матриця 4x4:");
        for (int[] value : matrix) {
            for (int i : value) {
                System.out.printf("%4d", i);
            }
            System.out.println();
        }

        int sum1 = 0;
        for (int i = 0; i < matrix.length; i+=2) {
            for (int j = 0; j < matrix[i].length; j++) {
                sum1 += matrix[i][j];
            }
        }

        System.out.println("Сума елементів у парних рядках (рядок 0, 2): " + sum1);

        int sum2 = 0;
        for (int i = 1; i < matrix.length; i+=2) {
            for (int j = 0; j < matrix[i].length; j++) {
                sum2 += matrix[i][j];
            }
        }
        System.out.println("Сума елементів у непарних рядках (рядок  1, 3): " + sum2);

        long product1 = 1;
        for (int j = 0; j < matrix[0].length; j+=2) {
            for (int[] ints : matrix) {
                product1 *= ints[j];
            }
        }
        System.out.println("Добуток елементів у парних стовпцях (стовпець 0, 2):" + product1);

        long product2 = 1;
        for (int j = 1; j < matrix[0].length; j+=2) {
            for (int[] ints : matrix) {
                product2 *= ints[j];
            }
        }
        System.out.println("Добуток елементів у непарних стовпцях (стовпець 1, 3):" + product2);

        if (isMagicSquare(matrix)) {
            System.out.println("Матриця є магічним квадратом.");
        } else {
            System.out.println("Матриця не є магічним квадратом.");
        }
    }

    private static boolean isMagicSquare(int[][] matrix) {
        int size = matrix.length;
        int magicSum = 0;

        for (int j = 0; j < size; j++) {
            magicSum += matrix[0][j];
    }

        for (int[] ints : matrix) {
            int rowSum = 0;
            for (int j = 0; j < size; j++) {
                rowSum += ints[j];
            }
            if (rowSum != magicSum) {
                return false;
            }
        }

        for (int j = 0; j < size; j++) {
            int colSum = 0;
            for (int[] ints : matrix) {
                colSum += ints[j];
            }
            if (colSum != magicSum) {
                return false;
            }
        }

        int diag1Sum = 0;
        for (int i = 0; i < size; i++) {
            diag1Sum += matrix[i][i];
        }
        if (diag1Sum != magicSum) {
            return false;
        }

        int diag2Sum = 0;
        for (int i = 0; i < size; i++) {
            diag2Sum += matrix[i][size - 1 - i];
        }
        return diag2Sum == magicSum;
    }
}
