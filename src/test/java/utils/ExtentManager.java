package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.nio.file.Files;
import java.nio.file.Path;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {

        if (extent == null) {
            createReportDirectory();

            ExtentSparkReporter reporter =
                    new ExtentSparkReporter("reports/extent-report.html");

            reporter.config().setReportName("Automation Test Report");
            reporter.config().setDocumentTitle("Test Results");

            extent = new ExtentReports();
            extent.attachReporter(reporter);
        }

        return extent;
    }

    private static void createReportDirectory() {
        try {
            Files.createDirectories(Path.of("reports"));
        } catch (Exception e) {
            throw new RuntimeException("Unable to create reports directory", e);
        }
    }
}
