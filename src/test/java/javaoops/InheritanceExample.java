package javaoops;

public class InheritanceExample {

    public static void main(String[] args) {
        ChromeBrowser browser = new ChromeBrowser();
        browser.openBrowser();
        browser.openChromeSettings();
    }
}

class Browser {
    void openBrowser() {
        System.out.println("Opening browser");
    }
}

class ChromeBrowser extends Browser {
    void openChromeSettings() {
        System.out.println("Opening Chrome settings");
    }
}
