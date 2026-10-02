package org.example.CompositeDesignPattern;

public class File implements FileSystemItem {
    private final String name;
    private final int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public void ls(int indent) {
        System.out.println(" ".repeat(indent) + name);
    }

    @Override
    public void openAll(int indent) {
        // Files are leaf nodes; opening a file prints its name
        System.out.println(" ".repeat(indent) + name);
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public FileSystemItem cd(String target) {
        // Changing directory into a file is invalid
        System.out.println("Cannot 'cd' into file: " + name);
        return null;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public boolean isFolder() {
        return false;
    }
}