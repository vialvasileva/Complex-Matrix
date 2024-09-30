public class Matrix {
    private int row, col; // row - количество строк, col - столбцов
    private ComplexNum[][] matrix;


    // Геттеры для строк и столбцов
    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }


    // Конструкторы
    public Matrix() {
        row = 0;
        col = 0;
    }

    public Matrix(int row, int col) {
        this.row = row;
        this.col = col;
        matrix = new ComplexNum[row][col];
    }


    // Значение элемента матрицы
    public ComplexNum value(int row, int col) {
        return matrix[row][col];
    }


    // Вывод матрицы
    public void print() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(matrix[i][j] + "\t\t");
            }
            System.out.println();
        }
    }


    // Заполнение матрицы
    public void set(int row, int col, ComplexNum value) {
        matrix[row][col] = value;
    }

    public static Matrix fill2x2() {
        Matrix matrix = new Matrix(2, 2);

        matrix.set(0, 0, new ComplexNum(1, 2));
        matrix.set(0, 1, new ComplexNum(-3, -1));
        matrix.set(1, 0, new ComplexNum(-2, 4));
        matrix.set(1, 1, new ComplexNum(-1, 0));

        return matrix;
    }

    public static Matrix fill2x3() {
        Matrix matrix = new Matrix(2, 3);

        matrix.set(0, 0, new ComplexNum(-2, 0));
        matrix.set(0, 1, new ComplexNum(1, 1));
        matrix.set(0, 2, new ComplexNum(3, -2));
        matrix.set(1, 0, new ComplexNum(0, 4));
        matrix.set(1, 1, new ComplexNum(-3, 0));
        matrix.set(1, 2, new ComplexNum(-1, -1));

        return matrix;
    }

    public static Matrix fill3x3() {
        Matrix matrix = new Matrix(3, 3);

        matrix.set(0, 0, new ComplexNum(-2, 0));
        matrix.set(0, 1, new ComplexNum(1, 1));
        matrix.set(0, 2, new ComplexNum(3, -2));
        matrix.set(1, 0, new ComplexNum(0, 4));
        matrix.set(1, 1, new ComplexNum(-3, 0));
        matrix.set(1, 2, new ComplexNum(-1, -1));
        matrix.set(2, 0, new ComplexNum(-5, 0));
        matrix.set(2, 1, new ComplexNum(2, -1));
        matrix.set(2, 2, new ComplexNum(0, 0));

        return matrix;
    }


    // МЕТОДЫ АРИФМЕТИЧЕСКИХ ОПЕРАЦИЙ
    // Сложение матриц
    public Matrix add(Matrix operand) {
        if ((this.row != operand.row) || (this.col != operand.col)) {
            System.out.println("Некорекктный ввод. Количество строк и столбцов матриц должно совпадать.");
            return null;
        }

        Matrix rez = new Matrix(this.row, this.col);

        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                ComplexNum operand1 = this.value(i, j);
                ComplexNum operand2 = operand.value(i, j);
                rez.set(i, j, operand1.add(operand2));
            }
        }

        return rez;
    }

    // Вычитание матриц
    public Matrix subtract(Matrix operand) {
        if ((this.row != operand.row) || (this.col != operand.col)) {
            System.out.println("Некорекктный ввод. Количество строк и столбцов матриц должно совпадать.");
            return null;
        }

        Matrix rez = new Matrix(this.row, this.col);

        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                ComplexNum operand1 = this.value(i, j);
                ComplexNum operand2 = operand.value(i, j);
                rez.set(i, j, operand1.subtract(operand2));
            }
        }

        return rez;
    }

    // Умножение матриц
    public Matrix multiply(Matrix operand) {
        if (this.col != operand.row) {
            System.out.println("Некорекктный ввод. Количество столбцов первой матрицы должно быть равно количеству строк второй матрицы.");
            return null;
        }

        Matrix rez = new Matrix(this.row, operand.col);

        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < operand.col; j++) {
                ComplexNum union = new ComplexNum(0, 0);
                for (int k = 0; k < this.col; k++) {
                    ComplexNum operand1 = this.value(i, k);
                    ComplexNum operand2 = operand.value(k, j);
                    ComplexNum product = operand1.multiply(operand2);
                    union = union.add(product);
                }
                rez.set(i, j, union);
            }
        }

        return rez;
    }

    // Транспонирование матрицы
    public Matrix transpose() {
        Matrix rez = new Matrix(this.col, this.row);

        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                rez.set(j, i, this.value(i, j));
            }
        }

        return rez;
    }

    // Детерминант матрицы
    public ComplexNum det() {
        if (this.row != this.col) {
            System.out.println("Некорекктный ввод. Матрица должна быть квадратной.");
            return null;
        }

        if (this.row == 2) {
            ComplexNum operand1 = this.value(0, 0).multiply(this.value(1, 1));
            ComplexNum operand2 = this.value(0, 1).multiply(this.value(1, 0));
            return operand1.subtract(operand2);
        }

        ComplexNum product1 = this.value(1, 1).multiply(this.value(2, 2));
        ComplexNum product2 = this.value(1, 2).multiply(this.value(2, 1));
        ComplexNum product3 = this.value(1, 0).multiply(this.value(2, 2));
        ComplexNum product4 = this.value(1, 2).multiply(this.value(2, 0));
        ComplexNum product5 = this.value(1, 0).multiply(this.value(2, 1));
        ComplexNum product6 = this.value(1, 1).multiply(this.value(2, 0));
        ComplexNum difference1 = product1.subtract(product2);
        ComplexNum difference2 = product3.subtract(product4);
        ComplexNum difference3 = product5.subtract(product6);
        ComplexNum operand1 = this.value(0, 0).multiply(difference1);
        ComplexNum operand2 = this.value(0, 1).multiply(difference2);
        ComplexNum operand3 = this.value(0, 2).multiply(difference3);
        return operand1.subtract(operand2).add(operand3);
    }
}