package utils;

import factory.DriverFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class ScreenshotUtil {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss_SSS");

    private ScreenshotUtil() {
    }

    public static String capture(String testName) {
        WebDriver driver = DriverFactory.getDriver();
        if (driver == null) {
            return null;
        }

        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Path screenshotDir = Path.of("target", "screenshots");
        String fileName = testName + "_" + LocalDateTime.now().format(FORMATTER) + ".png";
        Path destination = screenshotDir.resolve(fileName);

        try {
            Files.createDirectories(screenshotDir);
            Files.copy(source.toPath(), destination, StandardCopyOption.REPLACE_EXISTING);
            return destination.toAbsolutePath().toString();
        } catch (IOException e) {
            throw new RuntimeException("Failed to capture screenshot", e);
        }
    }
}