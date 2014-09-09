package name.lemerdy;

import static com.google.common.collect.Sets.newHashSet;

import java.util.Set;

public class Ana {
  public static Set<String> grams(String input) {
    if (input.length() == 1) {
      return newHashSet(input);
    } else {
      final Set<String> anagrams = newHashSet();
      for (int i = 0; i < input.length(); i++) {
        final String finalInput = input;
        grams(tail(input)).stream().forEach(s -> anagrams.add(head(finalInput) + s));
        input = permutations(input);
      }
      return anagrams;
    }
  }

  protected static String permutations(String input) {
    return tail(input) + head(input);
  }

  public static String head(String input) {
    return input.substring(0, 1);
  }

  public static String tail(String input) {
    return input.substring(1);
  }
}
