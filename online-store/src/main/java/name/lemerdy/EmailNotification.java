package name.lemerdy;

public interface EmailNotification {

    void sendPaymentConfirmation(String userEmail, double amount);

}
