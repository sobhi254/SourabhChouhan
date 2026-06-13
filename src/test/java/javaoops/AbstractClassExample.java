package javaoops;

public class AbstractClassExample {

    public static void main(String[] args) {
        TestCase testCase = new LoginTestCase();
        testCase.runTest();
    }
}

abstract class TestCase {
    void openApplication() {
        System.out.println("Opening application");
    }

    abstract void runTest();
}

class LoginTestCase extends TestCase {
    @Override
    void runTest() {
        openApplication();
        System.out.println("Running login test");
    }
}
