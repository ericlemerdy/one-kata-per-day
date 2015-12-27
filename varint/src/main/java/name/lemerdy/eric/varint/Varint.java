package name.lemerdy.eric.varint;

import com.google.common.base.Function;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Joiner.on;
import static com.google.common.base.Strings.padStart;
import static com.google.common.collect.Iterables.transform;
import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Lists.reverse;
import static java.lang.Integer.toBinaryString;

public class Varint {
    public static String intToVarint(int input) {
        return on(" ").join(addMSB(reverse(groupOfSevenBits(toBinaryString(input)))));
    }

    protected static List<String> groupOfSevenBits(String binaryString) {
        binaryString = padStart(binaryString, (((binaryString.length() - 1) / 7) + 1) * 7, '0');
        ArrayList<String> groups = newArrayList();
        for (int i = 0; i < (binaryString.length() / 7); i++) {
            StringBuffer substring = new StringBuffer(binaryString.substring(i * 7, (i * 7) + 7));
            substring.insert(3, ' ');
            groups.add(substring.toString());
        }
        return groups;
    }

    protected static List<String> addMSB(List<String> strings) {
        int lastIndex = strings.size() - 1;
        List<String> withSMB = newArrayList(transform(strings, new Function<String, String>() {
            @Override
            public String apply(String input) {
                return "1" + input;
            }
        }));
        String value = "0" + strings.get(lastIndex);
        withSMB.set(lastIndex, value);
        return withSMB;
    }

}
