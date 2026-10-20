package parking.refactored;

import parking.PaymentMethod;

import java.io.IOException;
import java.util.List;

public class ParkingService {
    private  final List<String> receipts ;
    private final  Logger logger ;
    private double total;
    private ReportFormatter formater;

    public ParkingService(double total,List<String> receipts,Logger logger){
        this.total=total;
        this.receipts=receipts;
        this.logger=logger;
    }
    public void checkout(Tariff tariff,Vehicle vehicle ,int hours, PaymentMethod method)
            throws IOException {
        double amount = tariff.fee(hours);
        method.pay(amount);
        total += amount;


        String receipt =formater.formatReceipt(vehicle,hours,amount,method);
        receipts.add(receipt);
        logger.log(receipt);
    }

}
