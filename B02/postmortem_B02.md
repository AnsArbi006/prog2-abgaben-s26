# Post Mortem B02

Fuer Blatt 02 habe ich mich mit Git-Branches, Merges, JUnit und einer einfachen
CI-Pipeline beschaeftigt.

Im Teil GitQuest habe ich verschiedene Merge-Situationen ausprobiert. Dabei habe
ich gesehen, dass Git Aenderungen in verschiedenen Dateien ohne Konflikt
zusammenfuehren kann. Auch Aenderungen in derselben Datei koennen automatisch
gemergt werden, wenn sie an unterschiedlichen Stellen liegen. Wenn jedoch
derselbe Bereich unterschiedlich geaendert wird, entsteht ein Merge-Konflikt,
der manuell aufgeloest werden muss. Ausserdem habe ich beobachtet, dass ein
Merge nach dem Aktualisieren von `end` auf `master` als Fast-forward ablaufen
kann.

Im Teil Cat Cafe habe ich das Projekt mit Gradle konfiguriert und JUnit 6 sowie
Spotless eingebunden. Ich habe Tests fuer die Klasse `CatCafe` erstellt und
geprueft, dass das Projekt ueber Gradle gestartet, getestet und auf
Formatierung geprueft werden kann. Zusaetzlich habe ich eine einfache
CI-Pipeline eingerichtet, die Kompilierung, Tests und Formatpruefung ausfuehrt.

Meine Testfaelle halte ich fuer relevant, weil sie die wichtigsten Funktionen
von `CatCafe` sowie Randfaelle und Fehlerfaelle pruefen. Sie sind
unterschiedlich, weil sie verschiedene Situationen abdecken, zum Beispiel
leeres Cafe, gueltige Eingaben, ungueltige Eingaben, `null`-Werte und
Grenzfaelle bei Gewichtsbereichen.

Insgesamt habe ich bei diesem Blatt besser verstanden, wie Git mit Branches und
Konflikten arbeitet und wie man Tests und CI in ein Java-Projekt integriert.
