package javaoops;

public class InterfaceExample {

    public static void main(String[] args) {
        Report report = new ExtentReport();
        report.generateReport();
    }
}

interface Report {
    void generateReport();
}

class ExtentReport implements Report {
    @Override
    public void generateReport() {
        System.out.println("Generating Extent report");
    }
}
