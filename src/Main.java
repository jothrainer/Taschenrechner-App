import java.util.Scanner;

/**
 * Konsolen-Taschenrechner: Menuefuehrung, Eingabe und Ausgabe.
 * Zustaendig: Person A (Johannes)
 */
public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Calculator calculator = new Calculator();
    private static final History history = new History();

    public static void main(String[] args) {
        System.out.println("=== Taschenrechner ===");

        boolean laeuft = true;
        while (laeuft) {
            zeigeMenue();
            String auswahl = scanner.nextLine().trim();

            switch (auswahl) {
                case "1":
                    rechnen();
                    break;
                case "2":
                    history.print();
                    break;
                case "0":
                    laeuft = false;
                    System.out.println("Programm beendet. Auf Wiedersehen!");
                    break;
                default:
                    System.out.println("Ungueltige Auswahl. Bitte 1, 2 oder 0 eingeben.");
            }
        }

        scanner.close();
    }

    /** Zeigt das Auswahlmenue an. */
    private static void zeigeMenue() {
        System.out.println();
        System.out.println("--------------------------");
        System.out.println("1) Neue Rechnung");
        System.out.println("2) Letzte 5 Rechnungen anzeigen");
        System.out.println("0) Beenden");
        System.out.print("Auswahl: ");
    }

    /** Liest eine komplette Rechnung ein, berechnet sie und speichert sie im Verlauf. */
    private static void rechnen() {
        double erste = leseZahl("Erste Zahl: ");
        char operator = leseOperator();
        double zweite = leseZahl("Zweite Zahl: ");

        try {
            double ergebnis = berechne(erste, operator, zweite);
            String eintrag = formatiere(erste) + " " + operator + " "
                    + formatiere(zweite) + " = " + formatiere(ergebnis);

            System.out.println("Ergebnis: " + eintrag);
            history.add(eintrag);
        } catch (ArithmeticException e) {
            // z. B. Division durch 0
            System.out.println("Fehler: " + e.getMessage());
        } catch (UnsupportedOperationException e) {
            System.out.println("Hinweis: " + e.getMessage());
        }
    }

    /** Ruft je nach Operator die passende Methode des Calculators auf. */
    private static double berechne(double a, char operator, double b) {
        switch (operator) {
            case '+':
                return calculator.add(a, b);
            case '-':
                return calculator.subtract(a, b);
            case '*':
                return calculator.multiply(a, b);
            case '/':
                return calculator.divide(a, b);
            default:
                // kann nicht vorkommen, da leseOperator() bereits prueft
                throw new IllegalArgumentException("Unbekannter Operator: " + operator);
        }
    }

    /**
     * Liest eine Zahl ein und fragt bei ungueltiger Eingabe erneut.
     * Komma wird als Dezimaltrennzeichen akzeptiert.
     */
    private static double leseZahl(String aufforderung) {
        while (true) {
            System.out.print(aufforderung);
            String eingabe = scanner.nextLine().trim().replace(',', '.');
            try {
                return Double.parseDouble(eingabe);
            } catch (NumberFormatException e) {
                System.out.println("Das war keine gueltige Zahl. Bitte nochmal versuchen.");
            }
        }
    }

    /** Liest einen Operator ein und fragt bei ungueltiger Eingabe erneut. */
    private static char leseOperator() {
        while (true) {
            System.out.print("Operator (+, -, *, /): ");
            String eingabe = scanner.nextLine().trim();

            if (eingabe.length() == 1 && "+-*/".indexOf(eingabe.charAt(0)) >= 0) {
                return eingabe.charAt(0);
            }
            System.out.println("Ungueltiger Operator. Erlaubt sind +, -, * und /.");
        }
    }

    /** Gibt ganze Zahlen ohne ".0" aus, z. B. 9 statt 9.0. */
    private static String formatiere(double zahl) {
        if (!Double.isInfinite(zahl) && !Double.isNaN(zahl) && zahl == Math.floor(zahl)) {
            return String.valueOf((long) zahl);
        }
        return String.valueOf(zahl);
    }
}
