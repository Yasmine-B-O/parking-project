package parking.refactored;
import java.util.*;

public class ReportFormatter {
    public String formatReceipt(Vehicle vehicle,double hours,double amount,Payable method){
        return vehicle.getPlate() + " | " + vehicle.getType() + " | "
                + hours + " h | " + amount + " MAD | " + method.name();

    }
    public String dailyReport(List<String> receipts,double total) {
        StringBuilder sb = new StringBuilder("=== Daily report ===\n");
        for (String receipt : receipts) {
            sb.append(receipt).append("\n");
        }
        sb.append("Total: ").append(total).append(" MAD");
        return sb.toString();
    }
}
