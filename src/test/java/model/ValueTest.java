package model;

import org.junit.*;

import static org.fest.assertions.Assertions.*;

public class ValueTest {
	@Test
	public void should_get_values_as_string() {
		assertThat(Value.stringValues()).containsExactly("2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A");
	}

	@Test
	public void with_a_valid_string_should_create_a_value() throws Exception {
		assertThat(Value.withString("2")).isEqualTo(Value._2);
		assertThat(Value.withString("10")).isEqualTo(Value._10);
		assertThat(Value.withString("Q")).isEqualTo(Value.Queen);
	}

	@Test(expected = IllegalArgumentException.class)
	public void with_an_invalid_string_should_not_create_a_value() throws Exception {
		Value.withString("foo");
	}
}
