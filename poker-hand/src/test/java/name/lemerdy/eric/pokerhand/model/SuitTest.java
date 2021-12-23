package name.lemerdy.eric.pokerhand.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SuitTest {
    @Test
    public void with_a_valid_suit_char_should_create_suit() {
        assertThat(Suit.withChar('♥')).isEqualTo(Suit.heart);
        assertThat(Suit.withChar('♦')).isEqualTo(Suit.diamond);
        assertThat(Suit.withChar('♠')).isEqualTo(Suit.spade);
        assertThat(Suit.withChar('♣')).isEqualTo(Suit.club);
    }

    @Test
    public void with_an_invalid_suit_should_not_create_suit() {
        Assertions.assertThatThrownBy(() -> Suit.withChar('f')).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void should_list_char_values() throws Exception {
        assertThat(Suit.charValues()).containsExactly('♥', '♦', '♠', '♣');
    }
}
