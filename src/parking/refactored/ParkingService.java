package parking.refactored;


import java.io.IOException;
import java.util.List;

public class ParkingService {
    private  final List<String> receipts ;
    private final  Logger logger ;
    private double total;
    private ReportFormatter formater;

    public ParkingService(double total,List<String> receipts,Logger logger,ReportFormatter formater){
        this.total=total;
        this.receipts=receipts;
        this.logger=logger;
        this.formater=formater;
    }
    public void checkout(Tariff tariff,Vehicle vehicle ,int hours, Payable method)
            throws IOException {
        double amount = tariff.fee(hours);
        method.pay(amount);
        total += amount;


        String receipt =formater.formatReceipt(vehicle,hours,amount,method);
        receipts.add(receipt);
        logger.log(receipt);
    }
    public void cancel(Tariff tariff,int hours, RefundablePayment method) {
        double amount = tariff.fee( hours);
        method.refund(amount);

        total -= amount;
    }
    public double getTotal(){
        return total;
    }

}
