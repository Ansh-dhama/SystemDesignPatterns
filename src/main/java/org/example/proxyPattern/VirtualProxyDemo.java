package org.example.proxyPattern;

// 1. Common Subject Interface
interface Image {
    void display();
}

// 2. Real Subject (Heavy/Expensive Object)
class RealImage implements Image {
    private final String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk(); // Expensive/Heavy Operation in constructor!
    }

    private void loadFromDisk() {
        System.out.println("[Disk I/O] Loading heavy image file from disk: " + fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying image: " + fileName);
    }
}

// 3. Virtual Proxy (Delays Real Object creation until needed)
class ImageProxy implements Image {
    private RealImage realImage; // Reference to Real Subject
    private final String fileName;

    public ImageProxy(String fileName) {
        this.fileName = fileName;
        this.realImage = null; // Do NOT load heavy object in constructor
    }

    @Override
    public void display() {
        // Lazy Initialization
        if (realImage == null) {
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}

// 4. Client Code
public class VirtualProxyDemo {
    public static void main(String[] args) {
        System.out.println("--- Instantiating Image Proxy ---");
        Image image = new ImageProxy("high_res_photo.jpg"); // Heavy loading hasn't happened yet!

        System.out.println("\n--- First Call to display() ---");
        image.display(); // Loads from disk AND displays

        System.out.println("\n--- Second Call to display() ---");
        image.display(); // Reuses loaded image without reloading from disk
    }
}