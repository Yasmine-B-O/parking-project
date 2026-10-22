package parking.refactored;

public class DataBaseLogger implements Logger{
    private final String databaseUrl;

    public DataBaseLogger(String databaseUrl) {
        this.databaseUrl = databaseUrl;
    }

    @Override
    public void log(String line) {
        System.out.println("[DATABASE " + databaseUrl + "] Inserting log: " + line);

    }
}
