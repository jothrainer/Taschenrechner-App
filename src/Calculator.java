/**
 * Rechenlogik der vier Grundrechenarten.
 * Zustaendig: Person B (Mario)
 */
public class Calculator {

    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    /**
     * Division. Bei b == 0 wird eine ArithmeticException mit verstaendlicher
     * Meldung geworfen - Main faengt sie ab und gibt sie aus.
     */
    public double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Division durch 0 ist nicht erlaubt.");
        }
        return a / b;
    }
}
