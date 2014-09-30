package name.lemerdy;

import name.lemerdy.model.payment.PaymentStatus;

public class PaymentSuccessful implements PaymentStatus {

    @Override
    public String message() {
        return "";
    }

}
