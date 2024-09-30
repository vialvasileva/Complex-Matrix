public class ComplexNum {
    private double real, im;


    // Геттеры для действительной и мнимой частей
    public double getReal() {
        return real;
    }

    public double getIm() {
        return im;
    }


    // Конструкторы
    public ComplexNum() {
        real = 0;
        im = 0;
    }

    public ComplexNum(double real, double im) {
        this.real = real;
        this.im = im;
    }


    // Вывод комплексного числа (переопределение метода toString)
    @Override
    public String toString() {
        return real + ((im >= 0) ? " + " + im : " - " + (-im)) + "i";
    }


    // МЕТОДЫ АРИФМЕТИЧЕСКИХ ОПЕРАЦИЙ
    // Сложение комплексных чисел
    public ComplexNum add(ComplexNum operand) {
        return new ComplexNum(this.real + operand.real, this.im + operand.im);
    }

    // Вычитание комплексных чисел
    public ComplexNum subtract(ComplexNum operand) {
        return new ComplexNum(this.real - operand.real, this.im - operand.im);
    }

    // Умножение комплексных чисел
    public ComplexNum multiply(ComplexNum operand) {
        double productReal = this.real * operand.real - this.im * operand.im;
        double productIm = this.real * operand.im + operand.real * this.im;
        return new ComplexNum(productReal, productIm);
    }

}
