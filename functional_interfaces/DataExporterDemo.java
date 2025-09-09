interface DataExporter {
    void export();

    default void exportToJSON() {
        System.out.println("Exporting data in JSON format (default).");
    }
}

class CSVExporter implements DataExporter {
    public void export() { System.out.println("Exporting CSV..."); }
}

public class DataExporterDemo {
    public static void main(String[] args) {
        DataExporter exporter = new CSVExporter();
        exporter.export();
        exporter.exportToJSON();
    }
}