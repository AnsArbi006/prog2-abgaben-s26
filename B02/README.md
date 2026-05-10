# B02 Arbeitsordner


### `gitquest_v1`

Mein Vorgehen:

1. Frischen Klon erstellen.
2. Eine Datei waehlen, die in `end` nicht veraendert wurde, zum Beispiel
   `hero.md`.
3. In `hero.md` eine eigene Zeile ergaenzen.
4. `git add hero.md`
5. `git commit -m "Hero-Text ergänzt"`
6. `git merge origin/end`

Beobachtung:
Der Merge laeuft ohne Konflikt, weil `master` und `end` unterschiedliche
Dateien veraendern.

Hinweis:
Im aktuellen Ordner `gitquest_v1` ist kein eigener Versuchs-Commit mehr in der
Historie sichtbar. Deshalb ist dieser Teil als konkrete moegliche Variante
formuliert und nicht als exakt rekonstruierte Git-Historie.

### `gitquest_v2`

Mein Vorgehen:

1. Frischen Klon erstellen.
2. Die Datei `stats.md` aendern.
3. Die Aenderung an einer anderen Stelle machen als in `end`.
4. `git add stats.md`
5. `git commit -m "änderung gleiche datei andere platzt"`
6. `git merge origin/end`
7. Falls Git den Editor oeffnet: Merge-Nachricht bestaetigen oder den Merge mit
   `git commit -m "Merge origin/end into master"` abschliessen.

Beobachtung:
Der Merge klappt ohne Konflikt, obwohl dieselbe Datei betroffen ist, weil die
Aenderungen an verschiedenen Stellen liegen.

### `gitquest_v3`

Mein Vorgehen:

1. Frischen Klon erstellen.
2. In `stats.md` den Wert bei `health` von `8` auf `99` aendern.
3. `git add stats.md`
4. `git commit -m "leben geändert"`
5. `git merge origin/end`
6. Konflikt in `stats.md` ansehen.
7. Konfliktmarker manuell entfernen.
8. `git add stats.md`
9. `git commit -m "merge konflikt gelösst"`

Beobachtung:
Hier entsteht ein echter Merge-Konflikt, weil `master` und `end` denselben
Bereich unterschiedlich veraendern.

### `gitquest_v4`

Mein Vorgehen:

1. Frischen Klon erstellen.
2. In `stats.md` die `health`-Zeile identisch zu `end` aendern, also von `8`
   auf `2`.
3. `git add stats.md`
4. `git commit -m "leben 8 -> 2"`
5. `git merge origin/end`
6. Konflikt in `stats.md` ansehen.
7. Datei manuell bereinigen.
8. `git add stats.md`
9. `git commit -m "Merge-Konflikt nach identischer health-Änderung gelöst"`

Beobachtung:
Obwohl die `health`-Zeile identisch geaendert wurde, blieb im selben Block noch
ein Konflikt, weil `experience` und `hunger` weiterhin unterschiedlich waren.

### `gitquest_v5`

Mein Vorgehen:

1. Frischen Klon erstellen.
2. Auf `master` in `hero.md` eine eigene Zeile anhaengen:
   `Markus rastete kurz vor dem letzten Aufstieg.`
3. `git add hero.md`
4. `git commit -m "Hero-Text ergänzt"`
5. `git checkout -b end origin/end`
6. `git merge master`
7. Falls der Merge noch offen ist: `git commit -m "master in end gemergt"`
8. `git checkout master`
9. `git merge end`

Beobachtung:
Nachdem `end` zuerst auf den Stand von `master` gebracht wurde, lief der Merge
zurueck nach `master` als `Fast-forward`.

## Cat Cafe

Der Ordner `catcafe` enthaelt den zweiten Aufgabenteil mit der Gradle-,
JUnit- und CI-Konfiguration.

Für die Klasse `CatCafe` wurden 12 JUnit-Tests erstellt. Die Tests decken
normales Verhalten, Randfälle und Fehlerfälle ab, zum Beispiel:

- Hinzufügen einer Katze
- Zählen der Katzen
- Suche nach vorhandenem Namen
- Suche nach unbekanntem Namen
- Suche in einem gültigen Gewichtsbereich
- `null` als Eingabe
- negativer Mindestwert beim Gewicht
- oberes Gewicht kleiner als unteres
- kein Treffer im Gewichtsbereich
- obere Gewichtsgrenze wird nicht mitgezählt

bennenung  `given-when-then` system 
## Wichtige Cat-Cafe-Befehle

```bash
./gradlew run
./gradlew test
./gradlew spotlessCheck
./gradlew spotlessApply
```
