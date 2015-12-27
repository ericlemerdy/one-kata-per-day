package name.lemerdy.eric.com.adventofcode.seven;

import lombok.Value;

import java.util.regex.Matcher;

import static java.util.regex.Pattern.compile;

@Value
public class Instruction {
    Signal signal;
    Wire wire;

    public Instruction(String instruction) {
        Matcher signalProvidedToWire;

        signalProvidedToWire = compile("(\\d+) -> (\\w+)").matcher(instruction);
        if (signalProvidedToWire.matches()) {
            signal = new Signal(Integer.valueOf(signalProvidedToWire.group(1)));
            wire = new Wire(signalProvidedToWire.group(2));
            return;
        }

        signalProvidedToWire = compile("(\\d+) AND (\\d+) -> (\\w+)").matcher(instruction);
        if (signalProvidedToWire.matches()) {
            signal = new Signal(Integer.valueOf(signalProvidedToWire.group(1)) & Integer.valueOf(signalProvidedToWire.group(2)));
            wire = new Wire(signalProvidedToWire.group(3));
            return;
        }

        throw new IllegalArgumentException("'" + instruction + "' is not parsable");
    }
}
