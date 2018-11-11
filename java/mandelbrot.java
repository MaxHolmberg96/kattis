import static java.lang.Math.*;

public class ComplexNr {

    private double a;
    private double b;

    public ComplexNr(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double length() {
        return sqrt(pow(a, 2) + pow(b, 2));
    }

    public ComplexNr add(ComplexNr n) {
        return new ComplexNr(a + n.getReal(), b + n.getImaginary());
    }

    public ComplexNr mul(ComplexNr n) {
        return new ComplexNr(a * n.getReal() - b * n.getImaginary(), a * n.getImaginary() + n.getReal() * b);
    }

    public ComplexNr pow2() {
        return new ComplexNr(pow(a, 2) - pow(b, 2), 2 * a * b);
    }

    public double getReal() {
        return a;
    }

    public double getImaginary() {
        return b;
    }

    @Override
    public String toString() {
        return a + " " + b + "i";
    }
}
