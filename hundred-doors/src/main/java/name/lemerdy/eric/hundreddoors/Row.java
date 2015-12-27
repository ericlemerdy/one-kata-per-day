package name.lemerdy.eric.hundreddoors;

import com.google.common.primitives.Booleans;

import static java.lang.String.format;
import static java.lang.System.out;

public class Row {
    private final boolean[] doorsOpen;

    public Row(int doorsCount) {
        this.doorsOpen = new boolean[doorsCount];
    }

    public Row() {
        this(100);
    }

    public void toggleDoorAt(int i) {
        this.doorsOpen[i - 1] = !this.doorsOpen[i - 1];
    }

    public boolean isDoorOpenAt(int i) {
        return doorsOpen[i - 1];
    }

    public int countDoors() {
        return doorsOpen.length;
    }

    public void pass() {
        for (int i = 1; i <= countDoors(); i++) {
            for (int j = 1; j <= countDoors(); j++) {
                if (j % i == 0) {
                    toggleDoorAt(j);
                    out.println(toString());
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder states = new StringBuilder();
        for (int i = 1; i <= this.countDoors(); i++) {
            states.append(doorsOpen[i - 1] ? '▯' : '▮');
        }
        return states.toString();
    }

    public int countOpenDoors() {
        return Booleans.asList(doorsOpen).stream().mapToInt(b -> b ? 1 : 0).sum();
    }

    public int countClosedDoors() {
        return countDoors() - countOpenDoors();
    }

    public static void main(String[] args) {
        Row row = new Row();
        row.pass();
        out.println(row);
        out.println(format("%d open door(s)", row.countOpenDoors()));
        out.println(format("%d closed door(s)", row.countClosedDoors()));
    }
}
