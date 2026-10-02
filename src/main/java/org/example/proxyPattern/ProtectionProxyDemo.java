package org.example.proxyPattern;

// User Class representing context
class User {
    private final String name;
    private final boolean isPremium;

    public User(String name, boolean isPremium) {
        this.name = name;
        this.isPremium = isPremium;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public String getName() {
        return name;
    }
}

// 1. Common Interface
interface DocumentReader {
    void unlockPdf(String filePath, String password);
}

// 2. Real Subject (Actual PDF Unlocker)
class RealDocumentReader implements DocumentReader {
    @Override
    public void unlockPdf(String filePath, String password) {
        System.out.println("SUCCESS: PDF unlocked at path '" + filePath + "' using password.");
    }
}

// 3. Protection Proxy (Enforces Premium Check)
class ProtectionDocumentProxy implements DocumentReader {
    private final RealDocumentReader realReader;
    private final User user;

    public ProtectionDocumentProxy(User user) {
        this.user = user;
        this.realReader = new RealDocumentReader();
    }

    @Override
    public void unlockPdf(String filePath, String password) {
        // Authentication & Authorization check
        if (user != null && user.isPremium()) {
            System.out.println("[Protection Proxy] User '" + user.getName() + "' verified as Premium.");
            realReader.unlockPdf(filePath, password);
        } else {
            System.out.println("[Protection Proxy] ACCESS DENIED: User '" 
                + (user != null ? user.getName() : "Guest") + "' is not a Premium user.");
        }
    }
}

// 4. Client Code
public class ProtectionProxyDemo {
    public static void main(String[] args) {
        User freeUser = new User("Ansh", false);
        User premiumUser = new User("Dhama", true);

        System.out.println("--- Free User Attempt ---");
        DocumentReader freeUserProxy = new ProtectionDocumentProxy(freeUser);
        freeUserProxy.unlockPdf("/docs/confidential.pdf", "1234");

        System.out.println("\n--- Premium User Attempt ---");
        DocumentReader premiumUserProxy = new ProtectionDocumentProxy(premiumUser);
        premiumUserProxy.unlockPdf("/docs/confidential.pdf", "1234");
    }
}