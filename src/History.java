import java.util.ArrayList;
import java.util.List;

/**
 * Verlauf der letzten 5 Rechnungen.
 * Zustaendig: Person B (Mario)
 */
public class History {

    /** Maximale Anzahl der gespeicherten Rechnungen. */
    public static final int MAX_EINTRAEGE = 5;

    /** Eintraege in Reihenfolge ihrer Entstehung, der aelteste steht vorne. */
    private final List<String> eintraege = new ArrayList<>();

    /**
     * Speichert eine Rechnung als Text, z. B. "4 + 5 = 9".
     * Sind schon 5 Eintraege vorhanden, faellt der aelteste heraus.
     */
    public void add(String eintrag) {
        eintraege.add(eintrag);
        if (eintraege.size() > MAX_EINTRAEGE) {
            eintraege.remove(0);
        }
    }

    /**
     * Gibt den Verlauf auf der Konsole aus, neueste Rechnung zuerst, z. B.:
     * 1) 4 + 5 = 9
     * Ist der Verlauf leer, erscheint ein entsprechender Hinweis.
     */
    public void print() {
        if (eintraege.isEmpty()) {
            System.out.println("Der Verlauf ist leer.");
            return;
        }
        int nummer = 1;
        for (int i = eintraege.size() - 1; i >= 0; i--) {
            System.out.println(nummer + ") " + eintraege.get(i));
            nummer++;
        }
    }
}
