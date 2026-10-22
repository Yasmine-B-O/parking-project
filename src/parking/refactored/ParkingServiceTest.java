package parking.refactored;

import java.util.ArrayList;
import java.util.List;

public class ParkingServiceTest {

    public static void main(String[] args) {
        // Création du Test Double (Fake Logger en mémoire)
        FakeLogger fakeLogger = new FakeLogger();

        //Initialisation du service avec le faux logger
        List<String> receipts = new ArrayList<>();
        ParkingService service = new ParkingService(0.0, receipts, fakeLogger,new ReportFormatter());

        //Création des véhicules et des tarifs
        Vehicle car = new Vehicle("12345-A-6", "CAR");
        Vehicle bike = new Vehicle("67890-B-1", "MOTORBIKE");
        Vehicle truck = new Vehicle("24680-D-8", "TRUCK");

        Tariff carTariff = new CarTariff();       // 5.0 MAD/h
        Tariff bikeTariff = new bikeTariff(); // 2.0 MAD/h (supposé)
        Tariff truckTariff = new truckTariff();    // 20 + 10.0 MAD/h (supposé)

        Payable card = new CardPayment("4242");

        // 4. Exécution des checkouts
        try {
            service.checkout(carTariff, car, 3, card);   // 3 * 5 = 15.0
            service.checkout(bikeTariff, bike, 2, card); // 2 * 2 = 4.0
            service.checkout(truckTariff, truck, 4, card);// 20 + 4*10 = 60.0
        } catch (Exception e) {
            System.err.println("Erreur lors du checkout : " + e.getMessage());
        }

        // Vérification des résultats
        double expectedTotal = 15.0+4.0+60.0; // 79.0 MAD

        // Vérification du total
        System.out.println("Vérification du Total :");
        if (Math.abs(service.getTotal() - expectedTotal) < 0.001) {
            System.out.println("Total correct : " + service.getTotal() + " MAD");
        } else {
            System.out.println(" Total incorrect. Attendu : " + expectedTotal + ", Obtenu : " + service.getTotal());
        }

        // Vérification qu'aucun fichier n'a été créé
        System.out.println("\nVérification du Logger :");
        System.out.println("Logs interceptés en mémoire : " + fakeLogger.getLogs().size());
        System.out.println("Aucun fichier parking.log n'a été créé.");
    }
}

// Le Test Double
class FakeLogger implements Logger {
    private final List<String> logs = new ArrayList<>();

    @Override
    public void log(String line) {
        logs.add(line); // On stocke en mémoire au lieu d'écrire dans un fichier
    }

    public List<String> getLogs() {
        return logs;
    }
}
