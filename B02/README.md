# B02 Arbeitsordner

- `gitquest_v1`: erster Merge-Versuch
- `gitquest_v2`: zweiter frischer Klon fuer den naechsten Merge-Versuch
- `catcafe`: Java-/Gradle-Projekt fuer den zweiten Aufgabenteil

## Wichtige Cat-Cafe-Befehle

```bash
./gradlew run
./gradlew test
./gradlew spotlessCheck
./gradlew spotlessApply
```

## Hinweis zu `google-java-format`

Die Einrueckung ist dort nicht frei auf 4 Leerzeichen umstellbar. Das ist gerade der Punkt des Tools:
ein fester Stil. `reflowLongStrings()` kann man aktivieren, aber die Grund-Einrueckung bleibt nicht beliebig konfigurierbar.
