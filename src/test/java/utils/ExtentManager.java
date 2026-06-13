package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExtentManager {

    private static final DateTimeFormatter REPORT_TIMESTAMP =
            DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");

    private static ExtentReports extent;

    public static ExtentReports getInstance() {

        if (extent == null) {
            createReportDirectory();

            ExtentSparkReporter reporter =
                    new ExtentSparkReporter(createReportPath());

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

    private static String createReportPath() {
        String timestamp = LocalDateTime.now().format(REPORT_TIMESTAMP);
        return "reports/extent-report-" + timestamp + ".html";
    }
}
