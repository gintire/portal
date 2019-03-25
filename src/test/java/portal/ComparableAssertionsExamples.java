package portal;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

/**
 * Comparable assertions specific examples
 * 
 * @author Joel Costigliola
 */
public class ComparableAssertionsExamples {

  @Test
  public void comparable_assertions_examples() {

    Rating goodRating = new Rating(8);
    Rating badRating = new Rating(4);
    assertThat(goodRating).isGreaterThan(badRating);
    assertThat(goodRating).isGreaterThanOrEqualTo(badRating);
    assertThat(badRating).isLessThan(goodRating);
    assertThat(badRating).isLessThanOrEqualTo(goodRating);
    assertThat(goodRating).isEqualByComparingTo(goodRating);
    assertThat(goodRating).isNotEqualByComparingTo(badRating);
    try {
      assertThat(badRating).isGreaterThan(goodRating);
    } catch (AssertionError e) {
    }
    // just to show that we can use ObjectAssert assertion:
    assertThat(goodRating).isEqualToComparingFieldByField(new Rating(8));
  }

  private static class Rating implements Comparable<Rating> {

    private int note;

    public Rating(int note) {
      this.note = note;
    }

    @Override
    public int compareTo(Rating o) {
      return note - o.note;
    }
    
    @Override
    public String toString() {
      return String.valueOf(note);
    }
  }

}
