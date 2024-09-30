public class Main {
    public static void main(String[] args) {
        // СОЗДАНИЕ
        // 4 квадратных матрицы: две размером 2х2, одна - 2х3 и одна - 3х3
        Matrix matrix1 = Matrix.fill2x2();
        Matrix matrix2 = Matrix.fill2x2().transpose();
        Matrix matrix3 = Matrix.fill2x3();
        Matrix matrix4 = Matrix.fill3x3();


        // ВЫВОД
        // Вывод исходных матриц
        printMatrix("Матрица 1:", matrix1);
        printMatrix("\nМатрица 2:", matrix2);
        printMatrix("\nМатрица 3:", matrix3);
        printMatrix("\nМатрица 4:", matrix4);

        // Вывод бинарных операций на матрицах
        printBinary("\nСумма матриц 1 и 2:", matrix1, matrix2, "+");
        printBinary("\nСумма матриц 1 и 3:", matrix1, matrix3, "+"); // выдаст ошибку
        printBinary("\nРазность матриц 1 и 2:", matrix1, matrix2, "-");
        printBinary("\nРазность матриц 1 и 4:", matrix1, matrix4, "-"); // выдаст ошибку
        printBinary("\nПроизведение матриц 3 и 4:", matrix3, matrix4, "*");
        printBinary("\nПроизведение матриц 2 и 4:", matrix2, matrix4, "*"); // выдаст ошибку

        // Вывод унарных операций на матрицах
        printUnary("\nТранспонированная матрица 1:", matrix1, "t");
        printUnary("\nТранспонированная матрица 2:", matrix2, "t");
        printUnary("\nТранспонированная матрица 3:", matrix3, "t");
        printUnary("\nТранспонированная матрица 4:", matrix4, "t");
        printUnary("\nДетерминант матрицы 1:", matrix1, "d");
        printUnary("\nДетерминант матрицы 2:", matrix2, "d");
        printUnary("\nДетерминант матрицы 3:", matrix3, "d"); // выдаст ошибку
        printUnary("\nДетерминант матрицы 4:", matrix4, "d");
    }

    private static void printMatrix(String string, Matrix matrix) {
        System.out.println(string);
        matrix.print();
    }

    private static void printBinary(String string, Matrix matrix1, Matrix matrix2, String operation) {
        System.out.println(string);

        Matrix rez = switch (operation) {
            case "+" -> matrix1.add(matrix2);
            case "-" -> matrix1.subtract(matrix2);
            case "*" -> matrix1.multiply(matrix2);
            default -> null;
        };

        if (rez != null) {
            rez.print();
        }
    }

    private static void printUnary(String string, Matrix matrix, String operation) {
        System.out.println(string);

        if (operation == "t") {
            matrix.transpose().print();
        }

        if (operation == "d") {
            ComplexNum det = matrix.det();
            if (det != null) {
                System.out.println(det);
            }
        }
    }
}
