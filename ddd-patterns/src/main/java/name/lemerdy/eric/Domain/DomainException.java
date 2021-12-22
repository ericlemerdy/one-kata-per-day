package name.lemerdy.eric.Domain;

/**
 * Domain Exception.
 */
public class DomainException extends RuntimeException {

    public DomainException() {
    }

    /**
     * Initializes a new instance of the <see cref="DomainException"/> class.
     *
     * @param businessMessage Message.
     */
    public DomainException(String businessMessage) {
        super(businessMessage);
    }
}
