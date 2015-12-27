package name.lemerdy.eric.onlinestore;

public interface EmailNotification {

    void sendPaymentConfirmation(String userEmail, double amount);

}
