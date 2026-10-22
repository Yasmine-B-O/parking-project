package parking.refactored;

public class WalletPayment {
    private final String walletId;

    public WalletPayment(String walletId) { this.walletId = walletId; }

    public String name() { return "Wallet"; }

    public void pay(double amount) {
        System.out.println("[Wallet " + walletId+ "] paid " + amount + " MAD");
    }

    public void refund(double amount) {
        System.out.println("[Wallet " +walletId + "] refunded " + amount + " MAD");
    }
}
