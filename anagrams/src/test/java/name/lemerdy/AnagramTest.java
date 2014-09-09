package name.lemerdy;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class AnagramTest {
  @Test
  public void anagrams_of_a_should_be_a() throws Exception {
    assertThat(Ana.grams("a")).containsOnly("a");
  }

  @Test
  public void anagrams_of_b_should_be_b() throws Exception {
    assertThat(Ana.grams("b")).containsOnly("b");
  }

  @Test
  public void anagrams_of_ab_should_be_ab_ba() throws Exception {
    assertThat(Ana.grams("ab")).containsOnly("ab", "ba");
  }

  @Test
  public void anagrams_of_abc_should_be_abc_acb_bac_bca_cab_cba() throws Exception {
    assertThat(Ana.grams("abc")).containsOnly("abc", "acb", "bac", "bca", "cab", "cba");
  }

  @Test
  public void permutations() throws Exception {
    assertThat(Ana.head("ab")).isEqualTo("a");
    assertThat(Ana.tail("ab")).isEqualTo("b");
    assertThat(Ana.permutations("ab")).isEqualTo("ba");
    assertThat(Ana.permutations("abc")).isEqualTo("bca");
    assertThat(Ana.head("abcd")).isEqualTo("a");
    assertThat(Ana.tail("abcd")).isEqualTo("bcd");
    assertThat(Ana.permutations("abcd")).isEqualTo("bcda");
  }
}
