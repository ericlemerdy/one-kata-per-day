package name.lemerdy.eric.onlinestore.model.payment;

public class PaymentFailure implements PaymentStatus {

    private String message;

    public PaymentFailure(String message) {
        this.message = message;
    }

    @Override
    public String message() {
        return message;
    }

}
