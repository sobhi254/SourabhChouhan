package listeners;

import base.DriverFactory;
import com.aventstack.extentreports.*;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.ExtentManager;
import utils.ScreenshotUtil;

public class TestListener implements ITestListener {

    private static final ExtentReports EXTENT = ExtentManager.getInstance();
    private static final ThreadLocal<ExtentTest> TEST = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        TEST.set(EXTENT.createTest(result.getName()));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        TEST.get().pass("Test Passed");
        TEST.remove();
    }

    @Override
    public void onTestFailure(ITestResult result) {

        String path = ScreenshotUtil.captureScreenshot(
                DriverFactory.getDriver(),
                result.getName()
        );

        TEST.get().fail(result.getThrowable());

        if (path != null) {
            TEST.get().addScreenCaptureFromPath(path);
        }

        TEST.remove();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        TEST.get().skip(result.getThrowable());
        TEST.remove();
    }

    @Override
    public void onFinish(ITestContext context) {
        EXTENT.flush();
    }
}
