package name.lemerdy.eric.com.adventofcode.seven;

import lombok.Value;

@Value
public class AndGate implements SignalProvider {
    SignalProvider left;
    SignalProvider right;
}
