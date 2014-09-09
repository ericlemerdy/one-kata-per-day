package name.lemerdy;

import static com.google.common.collect.Lists.newArrayList;

import java.util.List;

public class Fibonacci {

  public static int of(int i) {
    if (i == 0) {
      return 1;
    }
    if (i == 1) {
      return 1;
    }
    return Fibonacci.of(i - 2) + Fibonacci.of(i - 1);
  }

  public static List<Integer> sequenceUpTo(int limit) {
    List<Integer> sequence = newArrayList();
    for (int i = 0; i <= limit; i++) {
      sequence.add(Fibonacci.of(i));
    }
    return sequence;
  }
}
