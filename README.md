# Taschenrechner-App

Konsolen-Taschenrechner in Java. Der Benutzer gibt über die Konsole (`Scanner`) zwei Zahlen und
einen Operator ein, das Programm rechnet und zeigt zusätzlich die **letzten 5 Rechnungen** an.

## Funktionen

- Alle vier Grundrechenarten: `+`, `-`, `*`, `/`
- Eingabe über die Konsole mit `java.util.Scanner`
- Verlauf: die letzten 5 Rechnungen werden gespeichert und auf Wunsch ausgegeben
- Fehlerbehandlung: ungültige Eingaben und Division durch 0 führen nicht zum Absturz
- Endlosschleife mit Menü, Beenden über eine eigene Option

## Geplante Struktur

| Datei | Inhalt |
|---|---|
| `src/Main.java` | Programmstart, Menü-Schleife, Scanner-Eingabe |
| `src/Calculator.java` | Rechenlogik der vier Grundrechenarten |
| `src/History.java` | Speichern und Ausgeben der letzten 5 Rechnungen |

## Team & Aufgabenverteilung

Wir sind zwei Personen und teilen die Arbeit möglichst gleichmäßig auf:
eine Person übernimmt **Eingabe und Programmablauf**, die andere **Rechenlogik und Verlauf**.

### Person A — Johannes (`jothrainer`)

**Schwerpunkt: Ein-/Ausgabe und Programmablauf**

- Repository anlegen, Projektstruktur und `.gitignore`
- `Main.java`: `main`-Methode und Menü-Schleife
- Einlesen der Benutzereingaben mit `Scanner` (zwei Zahlen + Operator)
- Menüführung: Rechnung starten, Verlauf anzeigen, Programm beenden
- Prüfung der Eingaben: ungültige Zahlen und unbekannte Operatoren abfangen
- Formatierte Ausgabe des Ergebnisses auf der Konsole
- README pflegen

### Person B — *(Name Partner:in eintragen)*

**Schwerpunkt: Rechenlogik und Verlauf**

- `Calculator.java`: Methoden `add`, `subtract`, `multiply`, `divide`
- Division durch 0 abfangen und sauber melden
- `History.java`: Verlauf der Rechnungen als Liste verwalten
- Begrenzung auf die letzten 5 Einträge (ältester Eintrag fällt heraus)
- Methode zur Ausgabe des Verlaufs, z. B. `1) 4 + 5 = 9`
- Testen der Rechenfälle (inkl. Kommazahlen und negative Zahlen)

### Gemeinsam

- Festlegen der Schnittstellen zwischen den Klassen, bevor wir zu programmieren beginnen
- Code Reviews: jede:r schaut sich die Änderungen der anderen Person an
- Gemeinsamer Abschlusstest des gesamten Programms

## Arbeitsschritte

1. Projekt-Setup und README (Person A)
2. Grundgerüst der Klassen, Schnittstellen abstimmen (gemeinsam)
3. Scanner-Eingabe und Menü (Person A) / Rechenlogik (Person B) — parallel
4. Verlauf der letzten 5 Rechnungen (Person B)
5. Fehlerbehandlung (Person A)
6. Tests, Code Review und Abschluss (gemeinsam)

## Git-Workflow

- `main` bleibt immer lauffähig
- Jede:r arbeitet in einem eigenen Branch, z. B. `feature/eingabe` bzw. `feature/rechenlogik`
- Vor dem Mergen `git pull`, damit es keine unnötigen Konflikte gibt
- Aussagekräftige Commit-Messages, z. B. `Verlauf auf 5 Einträge begrenzt`

## Starten

```bash
javac -d out src/*.java
java -cp out Main
```
