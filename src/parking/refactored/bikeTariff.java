package parking.refactored;

public class bikeTariff implements Tariff{
    public double fee(int hours) {
        return hours * 2.0;
    }
}
