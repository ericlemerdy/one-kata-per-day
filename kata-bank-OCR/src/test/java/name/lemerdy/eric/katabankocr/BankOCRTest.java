package name.lemerdy.eric.katabankocr;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class BankOCRTest {

    @Test
    public void should_parse_an_entry() {
        Entry parsedInput = BankOCR.entry("" //
                + "    _  _     _  _  _  _  _ \n" //
                + "  | _| _||_||_ |_   ||_||_|\n" //
                + "  ||_  _|  | _||_|  ||_| _|\n" //
                + "                           ");
        assertThat(parsedInput.input()).containsExactly(1, 2, 3, 4, 5, 6, 7, 8, 9);
    }

    @Test
    public void an_entry_with_27_character_but_2_lines_is_invalid() {
        Assertions.assertThatThrownBy(() -> BankOCR.entry("" //
                        + "                           \n" //
                        + "                           ")
                )
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Expecting 4 lines for an entry");
    }

    @Test
    public void an_entry_with_4_lines_but_26_characters_is_invalid() {
        Assertions.assertThatThrownBy(() -> BankOCR.entry("" //
                        + "                          \n" //
                        + " \n" //
                        + " \n" //
                        + " ")
                )
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Expecting 27 characters per line for an entry");
    }

    @Test
    public void should_create_an_entry() throws Exception {
        Entry entry = BankOCR.entry("" //
                + "    _  _     _  _  _  _  _ \n" //
                + "  | _| _||_||_ |_   ||_||_|\n" //
                + "  ||_  _|  | _||_|  ||_| _|\n" //
                + "                           ");
        List<Integer> account = entry.input();
        assertThat(account).containsExactly(1, 2, 3, 4, 5, 6, 7, 8, 9);

    }
}
