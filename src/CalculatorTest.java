/**
 * Einfache Tests fuer Calculator und History (ohne Testframework).
 * Zustaendig: Person B (Mario)
 *
 * Start: java -cp out CalculatorTest
 */
public class CalculatorTest {

    private static int fehler = 0;

    public static void main(String[] args) {
        Calculator c = new Calculator();

        pruefe("4 + 5", 9, c.add(4, 5));
        pruefe("-3 + 8", 5, c.add(-3, 8));
        pruefe("0.1 + 0.2", 0.3, c.add(0.1, 0.2));
        pruefe("4 - 9", -5, c.subtract(4, 9));
        pruefe("-2 - -5", 3, c.subtract(-2, -5));
        pruefe("2.5 - 1.25", 1.25, c.subtract(2.5, 1.25));
        pruefe("6 * 7", 42, c.multiply(6, 7));
        pruefe("-3 * 4", -12, c.multiply(-3, 4));
        pruefe("-3 * -4", 12, c.multiply(-3, -4));
        pruefe("1.5 * 2", 3, c.multiply(1.5, 2));
        pruefe("9 / 3", 3, c.divide(9, 3));
        pruefe("1 / 4", 0.25, c.divide(1, 4));
        pruefe("-8 / 2", -4, c.divide(-8, 2));
        pruefe("0 / 5", 0, c.divide(0, 5));

        try {
            c.divide(5, 0);
            melde("5 / 0 wirft keine ArithmeticException");
        } catch (ArithmeticException e) {
            System.out.println("OK   5 / 0 -> " + e.getMessage());
        }

        testeVerlauf();

        System.out.println(fehler == 0 ? "Alle Tests bestanden." : fehler + " Test(s) fehlgeschlagen.");
        if (fehler > 0) {
            System.exit(1);
        }
    }

    private static void testeVerlauf() {
        History h = new History();
        System.out.println("--- Leerer Verlauf:");
        h.print();

        for (int i = 1; i <= 7; i++) {
            h.add(i + " + 1 = " + (i + 1));
        }
        System.out.println("--- Nach 7 Eintraegen (erwartet: 5 Zeilen, neueste zuerst, 7+1 bis 3+1):");
        h.print();
    }

    private static void pruefe(String name, double erwartet, double ist) {
        if (Math.abs(erwartet - ist) < 1e-9) {
            System.out.println("OK   " + name + " = " + ist);
        } else {
            melde(name + ": erwartet " + erwartet + ", war " + ist);
        }
    }

    private static void melde(String text) {
        fehler++;
        System.out.println("FAIL " + text);
    }
}
