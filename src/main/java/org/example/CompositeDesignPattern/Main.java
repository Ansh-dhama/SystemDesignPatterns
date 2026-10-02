package org.example.CompositeDesignPattern;

public class Main {
    public static void main(String[] args) {
        // 1. Create Root Folder
        Folder root = new Folder("root");
        root.add(new File("file1.txt", 1));
        root.add(new File("file2.txt", 1));

        // 2. Create 'docs' Subfolder & Add Files
        Folder docs = new Folder("docs");
        docs.add(new File("resume.pdf", 2));
        docs.add(new File("notes.txt", 1));

        // 3. Create 'images' Subfolder & Add Files
        Folder images = new Folder("images");
        images.add(new File("photo.jpg", 3));

        // 4. Build Hierarchy under Root
        root.add(docs);
        root.add(images);

        // --- Demo Operations ---

        System.out.println("=== 1. FULL EXPANDED HIERARCHY (openAll) ===");
        root.openAll(0);

        System.out.println("\n=== 2. ROOT DIRECTORY LISTING (ls) ===");
        root.ls(0);

        System.out.println("\n=== 3. TOTAL SIZE CALCULATION ===");
        System.out.println("Total Size of 'root': " + root.getSize() + " KB");

        System.out.println("\n=== 4. CHANGE DIRECTORY (cd into 'docs') ===");
        FileSystemItem targetDir = root.cd("docs");
        if (targetDir != null) {
            System.out.println("Switched to directory: " + targetDir.getName());
            System.out.println("Contents of 'docs':");
            targetDir.ls(2);
        }
    }
}