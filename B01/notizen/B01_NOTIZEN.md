# Blatt 01: Git Basics, Gradle

## Git Status erklären

Ich bin auf dem Branch `b03`.
`CONTRIBUTING.md` und `homework/b03.md` wurden geändert, sind aber noch nicht gestaged.
`foo.java` ist neu und noch untracked.
Im Staging-Bereich liegt aktuell nichts.

Nur `foo.java` committen:

```bash
git add foo.java
git commit -m "Add foo.java"
```

## Git-Spiel

- `tag 01`: Markus steigt in den Dungeon ein und trifft auf die ersten rattenähnlichen Monster.
- Erste `4 experience`: `tag 01.3`
- Erste `10 hunger`: `tag 02`
- Heiltränke insgesamt im Rucksack: `2`
- Gekauft: `1 Brot` und `1 Heiltrank`
- Bezahlt: `5 Gold` für das Brot und `5 Gold` für den Heiltrank
- Zwischen `tag 03` und `tag 04`: Markus kauft Brot und Heiltrank, benutzt beides, `health` steigt von `5` auf `10`, `hunger` fällt von `10` auf `0`.
- Gegessen: ja, bei `tag 03.17`

Änderungen:

- `tag 04.5`: `experience` auf `42` korrigiert
- `tag 04.6`: nur `questlog.md` geändert
- `tag 04.7`: Geschichte mit mehreren Dateien fortgesetzt
- `tag 04.8`: Ausrüstung aus `stats.md` nach `gear.md` verschoben

## Commit-Meldungen

### Commit `46530b6`

Thema und Issue-Bezug sind erkennbar.
Die Nachricht ist aber unübersichtlich und mischt Fachliches mit `rebase` und `spotlessApply`.
Besser wären klarere und kleinere Commits.

### Commit `3e37472`

Thema und Issue-Bezug sind gut erkennbar.
Der Commit fasst aber viele Änderungen zusammen.
Besser wären getrennte Commits für die Teiländerungen.

## Gradle

Tasks anzeigen:

```bash
./gradlew tasks --all
```

Projektlayout:

- `app/src/main/java`
- `app/src/test/java`
- `app/build.gradle`
- `settings.gradle`
- `gradlew`

Aufbau des Buildskripts:

- `plugins`
- `repositories`
- `dependencies`
- `java`
- `application`
- `spotless`

Wichtige `application`-Tasks:

- `app:run`
- `app:startScripts`
- `app:installDist`
- `app:distZip`
- `app:distTar`

Weitere Tasks:

- `app:build`
- `app:assemble`
- `app:test`

In der IDE kann ich die Tasks über die Gradle-Ansicht oder das Terminal starten.

## Java und Spotless

- `java -version` geprüft: Java `25` LTS
- Ausgabe in Java:

```java
System.out.println(System.getProperty("java.version"));
```

- Gradle-Projekt als Basisprojekt angelegt
- Start in der IDE über Gradle
- `Spotless` eingebunden

Wichtige Befehle:

```bash
./gradlew spotlessCheck
./gradlew spotlessApply
./gradlew build
```
