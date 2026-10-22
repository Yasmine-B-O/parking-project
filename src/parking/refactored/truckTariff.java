package parking.refactored;

public class truckTariff implements Tariff{
    public double fee(int hours) {
        return 20 + hours * 10.0;
    }

}
