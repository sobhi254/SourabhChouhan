package javaoops;

public class MethodOverridingExample {

    public static void main(String[] args) {
        WebBrowser browser = new EdgeBrowser();
        browser.openBrowser();
    }
}

class WebBrowser {
    void openBrowser() {
        System.out.println("Opening browser");
    }
}

class EdgeBrowser extends WebBrowser {
    @Override
    void openBrowser() {
        System.out.println("Opening Edge browser");
    }
}
