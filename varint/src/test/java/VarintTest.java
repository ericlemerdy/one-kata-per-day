import org.assertj.core.api.Assertions;
import org.junit.Test;

import static com.google.common.collect.Lists.newArrayList;
import static org.assertj.core.api.Assertions.assertThat;

public class VarintTest {
    @Test
    public void acceptance() {
        assertThat(Varint.intToVarint(1)).isEqualTo("0000 0001");
        assertThat(Varint.intToVarint(300)).isEqualTo("1010 1100 0000 0010");
    }

    @Test
    public void should_convert_int_to_varint() {
        assertThat(Varint.intToVarint(1)).isEqualTo("0000 0001");
        assertThat(Varint.intToVarint(7)).isEqualTo("0000 0111");
        assertThat(Varint.intToVarint(8)).isEqualTo("0000 1000");
        assertThat(Varint.intToVarint(127)).isEqualTo("0111 1111");
        assertThat(Varint.intToVarint(128)).isEqualTo("1000 0000 0000 0001");
        assertThat(Varint.intToVarint(129)).isEqualTo("1000 0001 0000 0001");
    }

    @Test
    public void should_pad_binary_with_seven_bytes_groups() {
        assertThat(Varint.groupOfSevenBits("1")).containsExactly("000 0001");
        assertThat(Varint.groupOfSevenBits("10")).containsExactly("000 0010");
        assertThat(Varint.groupOfSevenBits("1000")).containsExactly("000 1000");
        assertThat(Varint.groupOfSevenBits("1111111")).containsExactly("111 1111");
        assertThat(Varint.groupOfSevenBits("10000000")).containsExactly("000 0001", "000 0000");
        assertThat(Varint.groupOfSevenBits("10000001")).containsExactly("000 0001", "000 0001");
        assertThat(Varint.groupOfSevenBits("100000000")).containsExactly("000 0010", "000 0000");
        assertThat(Varint.groupOfSevenBits("10000000000000")).containsExactly("100 0000", "000 0000");
        assertThat(Varint.groupOfSevenBits("100000000000000")).containsExactly("000 0001", "000 0000", "000 0000");
    }

    @Test
    public void should_add_msb() {
        assertThat(Varint.addMSB(newArrayList("000 0001"))).containsExactly("0000 0001");
        assertThat(Varint.addMSB(newArrayList("000 1000"))).containsExactly("0000 1000");
        assertThat(Varint.addMSB(newArrayList("000 0000", "000 0001"))).containsExactly("1000 0000", "0000 0001");
        assertThat(Varint.addMSB(newArrayList("000 0001", "000 0001"))).containsExactly("1000 0001", "0000 0001");
        assertThat(Varint.addMSB(newArrayList("000 0000", "000 0010"))).containsExactly("1000 0000", "0000 0010");
        assertThat(Varint.addMSB(newArrayList("000 0000", "100 0000"))).containsExactly("1000 0000", "0100 0000");
        assertThat(Varint.addMSB(newArrayList("000 0000", "000 0000", "000 0001"))).containsExactly("1000 0000", "1000 0000", "0000 0001");
    }
}
