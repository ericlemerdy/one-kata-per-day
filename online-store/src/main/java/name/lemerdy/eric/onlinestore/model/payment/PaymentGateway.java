package name.lemerdy.eric.onlinestore.model.payment;

public interface PaymentGateway {

    PaymentStatus send(String creditCardNumber, String owner, String date, double price);

}
