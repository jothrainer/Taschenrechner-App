/**
 * Verlauf der letzten 5 Rechnungen.
 * Zustaendig: Person B (Mario)
 *
 * Nur die abgestimmte Schnittstelle, die Implementierung fehlt noch.
 */
public class History {

    /** Maximale Anzahl der gespeicherten Rechnungen. */
    public static final int MAX_EINTRAEGE = 5;

    /**
     * Speichert eine Rechnung als Text, z. B. "4 + 5 = 9".
     * Sind schon 5 Eintraege vorhanden, faellt der aelteste heraus.
     */
    public void add(String eintrag) {
        // TODO Mario: Eintrag zur Liste hinzufuegen und auf MAX_EINTRAEGE begrenzen
    }

    /**
     * Gibt den Verlauf auf der Konsole aus, neueste Rechnung zuerst, z. B.:
     * 1) 4 + 5 = 9
     * Ist der Verlauf leer, soll ein entsprechender Hinweis erscheinen.
     */
    public void print() {
        // TODO Mario: Verlauf ausgeben
        System.out.println("Der Verlauf ist noch nicht implementiert (Teil von Mario).");
    }
}
