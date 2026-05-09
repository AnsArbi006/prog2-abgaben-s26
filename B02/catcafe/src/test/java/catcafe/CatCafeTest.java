package catcafe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class CatCafeTest {
  private CatCafe createCafeWithThreeCats() {
    CatCafe cafe = new CatCafe();
    cafe.addCat(new FelineOverLord("Morticia", 3));
    cafe.addCat(new FelineOverLord("Fitzby Darnsworth", 5));
    cafe.addCat(new FelineOverLord("Miss Chief Sooky", 2));
    return cafe;
  }

  @Test
  void givenEmptyCafe_whenGetCatCount_thenReturnZero() {
    CatCafe cafe = new CatCafe();

    assertEquals(0, cafe.getCatCount());
  }

  @Test
  void givenEmptyCafe_whenAddOneCat_thenCountBecomesOne() {
    CatCafe cafe = new CatCafe();

    cafe.addCat(new FelineOverLord("Morticia", 3));

    assertEquals(1, cafe.getCatCount());
  }

  @Test
  void givenCafeWithThreeCats_whenGetCatCount_thenReturnThree() {
    CatCafe cafe = createCafeWithThreeCats();

    assertEquals(3, cafe.getCatCount());
  }

  @Test
  void givenNullCat_whenAddCat_thenThrowNullPointerException() {
    CatCafe cafe = new CatCafe();

    assertThrows(NullPointerException.class, () -> cafe.addCat(null));
  }

  @Test
  void givenExistingName_whenGetCatByName_thenReturnMatchingCat() {
    CatCafe cafe = createCafeWithThreeCats();

    FelineOverLord cat = cafe.getCatByName("Morticia");

    assertNotNull(cat);
    assertEquals("Morticia", cat.name());
    assertEquals(3, cat.weight());
  }

  @Test
  void givenUnknownName_whenGetCatByName_thenReturnNull() {
    CatCafe cafe = createCafeWithThreeCats();

    assertNull(cafe.getCatByName("Wednesday"));
  }

  @Test
  void givenNullName_whenGetCatByName_thenReturnNull() {
    CatCafe cafe = createCafeWithThreeCats();

    assertNull(cafe.getCatByName(null));
  }

  @Test
  void givenMatchingWeightRange_whenGetCatByWeight_thenReturnCatInsideRange() {
    CatCafe cafe = createCafeWithThreeCats();

    FelineOverLord cat = cafe.getCatByWeight(3, 4);

    assertNotNull(cat);
    assertEquals("Morticia", cat.name());
    assertEquals(3, cat.weight());
  }

  @Test
  void givenNegativeMinimumWeight_whenGetCatByWeight_thenReturnNull() {
    CatCafe cafe = createCafeWithThreeCats();

    assertNull(cafe.getCatByWeight(-1, 4));
  }

  @Test
  void givenMaximumBelowMinimum_whenGetCatByWeight_thenReturnNull() {
    CatCafe cafe = createCafeWithThreeCats();

    assertNull(cafe.getCatByWeight(5, 4));
  }

  @Test
  void givenWeightRangeWithoutMatchingCat_whenGetCatByWeight_thenReturnNull() {
    CatCafe cafe = createCafeWithThreeCats();

    assertNull(cafe.getCatByWeight(6, 8));
  }

  @Test
  void givenUpperBoundEqualToWeight_whenGetCatByWeight_thenExcludeCat() {
    CatCafe cafe = createCafeWithThreeCats();

    assertNull(cafe.getCatByWeight(0, 2));
  }
}
