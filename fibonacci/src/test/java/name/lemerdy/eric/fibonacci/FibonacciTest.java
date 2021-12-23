package name.lemerdy.eric.fibonacci;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class FibonacciTest {
  @Test
  public void fibonacci_of_0_is_1() {
    assertThat(Fibonacci.of(0)).isEqualTo(1);
  }

  @Test
  public void fibonacci_of_1_is_1() {
    assertThat(Fibonacci.of(1)).isEqualTo(1);
  }

  @Test
  public void fibonacci_of_2_is_2_as_of_fibonacci_of_0_plus_fibonacci_of_1() {
    assertThat(Fibonacci.of(2)).isEqualTo(2);
  }

  @Test
  public void fibonacci_of_3_is_3_as_of_fibonacci_of_1_plus_fibonacci_of_2() {
    assertThat(Fibonacci.of(3)).isEqualTo(3);
  }

  @Test
  public void fibonacci_of_4_is_5_as_of_fibonacci_of_2_plus_fibonacci_of_3() {
    assertThat(Fibonacci.of(4)).isEqualTo(5);
  }

  @Test
  public void should_generate_fibonacci_numbers_up_to_3() {
    assertThat(Fibonacci.sequenceUpTo(3)).containsExactly(1, 1, 2, 3);
  }
}
