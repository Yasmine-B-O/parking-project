package parking.refactored;

import java.util.List;

public class CsvReportFormatter extends ReportFormatter {

    @Override
    public String dailyReport(List<String> receipts, double total) {
        StringBuilder sb = new StringBuilder();

        // CSV Header
        sb.append("Plate,Type,Hours,Amount (MAD),Payment Method\n");

        // Data rows
        for (String receipt : receipts) {
            // The receipts are currently formatted with " | " from formatReceipt().
            // To make it a true CSV, we replace the " | " with a comma.
            sb.append(receipt.replace(" | ", ",")).append("\n");
        }

        // Footer with Total
        sb.append("TOTAL,,,,").append(total).append(" MAD\n");

        return sb.toString();
    }
}