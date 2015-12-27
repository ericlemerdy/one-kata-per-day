package name.lemerdy.eric.hundreddoors;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HundredDoorsTest {

    @Test
    public void should_create_a_row_with_one_door() throws Exception {
        Row row = new Row(1);

        assertThat(row.countDoors()).isEqualTo(1);
    }

    @Test
    public void by_default_row_has_hundred_doors() throws Exception {
        Row row = new Row();

        assertThat(row.countDoors()).isEqualTo(100);
    }

    @Test
    public void by_default_all_doors_are_closed() throws Exception {
        Row row = new Row();

        assertThat(row.isDoorOpenAt(1)).isFalse();
    }

    @Test
    public void should_open_first_door() throws Exception {
        Row row = new Row();

        row.toggleDoorAt(1);

        assertThat(row.isDoorOpenAt(1)).isTrue();
    }

    @Test
    public void should_open_first_and_second_door() throws Exception {
        Row row = new Row();

        row.toggleDoorAt(1);
        row.toggleDoorAt(2);

        assertThat(row.isDoorOpenAt(1)).isTrue();
        assertThat(row.isDoorOpenAt(2)).isTrue();
    }

    @Test
    public void should_close_the_open_door() throws Exception {
        Row row = new Row();

        row.toggleDoorAt(1);
        row.toggleDoorAt(1);

        assertThat(row.isDoorOpenAt(1)).isFalse();
    }

    @Test
    public void should_pass_on_row_of_size_1() throws Exception {
        Row row = new Row(1);

        row.pass();

        assertThat(row.isDoorOpenAt(1)).isTrue();
    }

    @Test
    public void should_pass_on_row_of_size_2() throws Exception {
        Row row = new Row(2);

        row.pass();

        assertThat(row.isDoorOpenAt(1)).isTrue();
        assertThat(row.isDoorOpenAt(2)).isFalse();
        assertThat(row.toString()).isEqualTo("▯▮");
        assertThat(row.countOpenDoors()).isEqualTo(1);
        assertThat(row.countClosedDoors()).isEqualTo(1);
    }

    @Test
    public void should_pass_on_row_of_size_3() throws Exception {
        Row row = new Row(3);

        row.pass();

        assertThat(row.isDoorOpenAt(1)).isTrue();
        assertThat(row.isDoorOpenAt(2)).isFalse();
        assertThat(row.isDoorOpenAt(3)).isFalse();
        assertThat(row.toString()).isEqualTo("▯▮▮");
        assertThat(row.countOpenDoors()).isEqualTo(1);
        assertThat(row.countClosedDoors()).isEqualTo(2);
    }

    @Test
    public void should_pass_on_row_of_size_4() throws Exception {
        Row row = new Row(4);

        row.pass();

        assertThat(row.isDoorOpenAt(1)).isTrue();
        assertThat(row.isDoorOpenAt(2)).isFalse();
        assertThat(row.isDoorOpenAt(3)).isFalse();
        assertThat(row.isDoorOpenAt(4)).isTrue();
        assertThat(row.toString()).isEqualTo("▯▮▮▯");
        assertThat(row.countOpenDoors()).isEqualTo(2);
        assertThat(row.countClosedDoors()).isEqualTo(2);
    }
}
