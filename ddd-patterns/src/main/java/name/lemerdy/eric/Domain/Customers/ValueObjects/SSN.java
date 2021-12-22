package name.lemerdy.eric.Domain.Customers.ValueObjects;

/**
 * SSN <see href="https://github.com/ivanpaulovich/clean-architecture-manga/wiki/Domain-Driven-Design-Patterns#entity">Entity Design Pattern</see>.
 */
public final class SSN {
    private final static String RegExForValidation = "^\\d{6,8}[-|(\\s)]{0,1}\\d{4}$";

    private final String _text;

    /**
     * Initializes a new instance of the <see cref="SSN"/> struct.
     *
     * @param text SSN.
     */
    public SSN(String text) {
        if (text == null || text.trim().isEmpty()) {
            throw new SSNShouldNotBeEmptyException("The text field is required.");
        }

        if (!java.util.regex.Pattern.matches(RegExForValidation, text)) {
            throw new InvalidSSNException("Invalid text format. Use YYMMDDNNNN.");
        }

        this._text = text;
    }

    /**
     * Converts into string.
     *
     * @return string.
     */
    public String toString() {
        return this._text;
    }
}
