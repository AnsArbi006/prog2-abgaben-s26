# Post Mortem B02

Für Blatt 02 habe ich mich mit Git-Branches, Merges, JUnit und einer einfachen
CI-Pipeline beschäftigt.

Im Teil GitQuest habe ich verschiedene Merge-Situationen ausprobiert. Dabei habe
ich gesehen, dass Git Änderungen in verschiedenen Dateien ohne Konflikt
zusammenführen kann. Auch Änderungen in derselben Datei können automatisch
gemergt werden, wenn sie an unterschiedlichen Stellen liegen. Wenn jedoch
derselbe Bereich unterschiedlich geändert wird, entsteht ein Merge-Konflikt,
der manuell aufgelöst werden muss. Außerdem habe ich beobachtet, dass ein
Merge nach dem Aktualisieren von `end` auf `master` als Fast-forward ablaufen
kann.

Im Teil Cat Cafe habe ich das Projekt mit Gradle konfiguriert und JUnit 6 sowie
Spotless eingebunden. Ich habe Tests für die Klasse `CatCafe` erstellt und
geprüft, dass das Projekt über Gradle gestartet, getestet und auf
Formatierung geprüft werden kann. Zusätzlich habe ich eine einfache
CI-Pipeline eingerichtet, die Kompilierung, Tests und Formatprüfung ausführt.

Meine Testfälle halte ich für relevant, weil sie die wichtigsten Funktionen
von `CatCafe` sowie Randfälle und Fehlerfälle prüfen. Sie sind
unterschiedlich, weil sie verschiedene Situationen abdecken, zum Beispiel
leeres Café, gültige Eingaben, ungültige Eingaben, `null`-Werte und
Grenzfälle bei Gewichtsbereichen.

Insgesamt habe ich bei diesem Blatt besser verstanden, wie Git mit Branches und
Konflikten arbeitet und wie man Tests und CI in ein Java-Projekt integriert.
