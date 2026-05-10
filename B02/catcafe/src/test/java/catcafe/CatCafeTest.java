package catcafe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class CatCafeTest {
  // Diese Hilfsmethode spart Code:
  // Statt in jedem Test wieder drei Katzen anzulegen, baue ich hier einmal
  // ein Beispiel-Café auf und kann es in mehreren Tests wiederverwenden.
  private CatCafe createCafeWithThreeCats() {
    CatCafe cafe = new CatCafe();
    cafe.addCat(new FelineOverLord("Morticia", 3));
    cafe.addCat(new FelineOverLord("Fitzby Darnsworth", 5));
    cafe.addCat(new FelineOverLord("Miss Chief Sooky", 2));
    return cafe;
  }

  @Test
  void givenEmptyCafe_whenGetCatCount_thenReturnZero() {
    // given = Ausgangslage:
    // Es gibt ein neues Café und darin ist noch keine Katze.
    CatCafe cafe = new CatCafe();

    // then = das erwartete Ergebnis:
    // Wenn noch nichts eingefügt wurde, muss die Anzahl 0 sein.
    assertEquals(0, cafe.getCatCount());
  }

  @Test
  void givenEmptyCafe_whenAddOneCat_thenCountBecomesOne() {
    // given = Ausgangslage:
    // Das Café ist am Anfang leer.
    CatCafe cafe = new CatCafe();

    // when = die Aktion:
    // Ich füge genau eine Katze in das Café ein.
    cafe.addCat(new FelineOverLord("Morticia", 3));

    // then = das erwartete Ergebnis:
    // Danach muss das Café genau eine Katze enthalten.
    assertEquals(1, cafe.getCatCount());
  }

  @Test
  void givenCafeWithThreeCats_whenGetCatCount_thenReturnThree() {
    // given = Ausgangslage:
    // Das Café enthält schon drei Katzen.
    CatCafe cafe = createCafeWithThreeCats();

    // then = das erwartete Ergebnis:
    // Die Zählmethode muss dann auch 3 zurückgeben.
    assertEquals(3, cafe.getCatCount());
  }

  @Test
  void givenNullCat_whenAddCat_thenThrowNullPointerException() {
    // given = Ausgangslage:
    // Es gibt ein normales leeres Café.
    CatCafe cafe = new CatCafe();

    // then = das erwartete Ergebnis:
    // null ist keine gültige Katze.
    // Deshalb erwarten wir hier absichtlich eine NullPointerException.
    assertThrows(NullPointerException.class, () -> cafe.addCat(null));
  }

  @Test
  void givenExistingName_whenGetCatByName_thenReturnMatchingCat() {
    // given = Ausgangslage:
    // Im Café ist bereits eine Katze mit dem Namen "Morticia".
    CatCafe cafe = createCafeWithThreeCats();

    // when = die Aktion:
    // Ich suche nach dem Namen "Morticia".
    FelineOverLord cat = cafe.getCatByName("Morticia");

    // then = das erwartete Ergebnis:
    // Es muss eine Katze gefunden werden und sie muss die richtigen Daten haben.
    assertNotNull(cat);
    assertEquals("Morticia", cat.name());
    assertEquals(3, cat.weight());
  }

  @Test
  void givenUnknownName_whenGetCatByName_thenReturnNull() {
    // given = Ausgangslage:
    // Im Café gibt es zwar Katzen, aber keine mit dem Namen "Wednesday".
    CatCafe cafe = createCafeWithThreeCats();

    // then = das erwartete Ergebnis:
    // Bei einem unbekannten Namen soll nichts gefunden werden.
    assertNull(cafe.getCatByName("Wednesday"));
  }

  @Test
  void givenNullName_whenGetCatByName_thenReturnNull() {
    // given = Ausgangslage:
    // Das Café enthält Katzen.
    CatCafe cafe = createCafeWithThreeCats();

    // then = das erwartete Ergebnis:
    // Mit null kann sinnvoll nicht nach einem Namen gesucht werden.
    // Deshalb erwarten wir keinen Treffer.
    assertNull(cafe.getCatByName(null));
  }

  @Test
  void givenMatchingWeightRange_whenGetCatByWeight_thenReturnCatInsideRange() {
    // given = Ausgangslage:
    // Im Café gibt es Katzen mit verschiedenen Gewichten.
    CatCafe cafe = createCafeWithThreeCats();

    // when = die Aktion:
    // Ich suche nach einer Katze mit Gewicht ab 3, aber unter 4.
    FelineOverLord cat = cafe.getCatByWeight(3, 4);

    // then = das erwartete Ergebnis:
    // Es muss eine Katze gefunden werden, deren Gewicht in diesen Bereich passt.
    assertNotNull(cat);
    assertEquals("Morticia", cat.name());
    assertEquals(3, cat.weight());
  }

  @Test
  void givenNegativeMinimumWeight_whenGetCatByWeight_thenReturnNull() {
    // given = Ausgangslage:
    // Das Café enthält Katzen.
    CatCafe cafe = createCafeWithThreeCats();

    // then = das erwartete Ergebnis:
    // Ein negativer Mindestwert ist ungültig.
    // Deshalb soll kein Ergebnis zurückkommen.
    assertNull(cafe.getCatByWeight(-1, 4));
  }

  @Test
  void givenMaximumBelowMinimum_whenGetCatByWeight_thenReturnNull() {
    // given = Ausgangslage:
    // Das Café enthält Katzen.
    CatCafe cafe = createCafeWithThreeCats();

    // then = das erwartete Ergebnis:
    // Wenn die obere Grenze kleiner als die untere ist,
    // ist der Suchbereich unsinnig und es darf kein Treffer kommen.
    assertNull(cafe.getCatByWeight(5, 4));
  }

  @Test
  void givenWeightRangeWithoutMatchingCat_whenGetCatByWeight_thenReturnNull() {
    // given = Ausgangslage:
    // Das Café enthält Katzen, aber keine im Bereich 6 bis 8.
    CatCafe cafe = createCafeWithThreeCats();

    // then = das erwartete Ergebnis:
    // Wenn keine Katze in diesen Bereich fällt, muss null zurückkommen.
    assertNull(cafe.getCatByWeight(6, 8));
  }

  @Test
  void givenUpperBoundEqualToWeight_whenGetCatByWeight_thenExcludeCat() {
    // given = Ausgangslage:
    // Im Café gibt es eine Katze mit Gewicht 2.
    CatCafe cafe = createCafeWithThreeCats();

    // then = das erwartete Ergebnis:
    // Die obere Grenze zählt hier nicht mit.
    // Deshalb darf Gewicht 2 bei [0,2) nicht mehr enthalten sein.
    assertNull(cafe.getCatByWeight(0, 2));
  }
}
