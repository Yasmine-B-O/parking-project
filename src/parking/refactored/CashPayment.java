package parking.refactored;

import parking.PaymentMethod;

public class CashPayment implements Payable {

    public String name() { return "CASH"; }

    public void pay(double amount) {
        System.out.println("[CASH] received " + amount + " MAD");
    }


}
