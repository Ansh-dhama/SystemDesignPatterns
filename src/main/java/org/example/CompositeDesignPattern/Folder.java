package org.example.CompositeDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class Folder implements FileSystemItem {
    private final String name;
    private final List<FileSystemItem> children;

    public Folder(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }

    public void add(FileSystemItem item) {
        children.add(item);
    }

    @Override
    public void ls(int indent) {
        for (FileSystemItem child : children) {
            String prefix = child.isFolder() ? "+ " : "";
            System.out.println(" ".repeat(indent) + prefix + child.getName());
        }
    }

    @Override
    public void openAll(int indent) {
        // Print folder name first
        System.out.println(" ".repeat(indent) + "+ " + name);
        
        // Recursively trigger openAll on all children
        for (FileSystemItem child : children) {
            child.openAll(indent + 4);
        }
    }

    @Override
    public int getSize() {
        // Accumulate size recursively across all sub-items
        int totalSize = 0;
        for (FileSystemItem child : children) {
            totalSize += child.getSize();
        }
        return totalSize;
    }

    @Override
    public FileSystemItem cd(String target) {
        for (FileSystemItem child : children) {
            if (child.isFolder() && child.getName().equalsIgnoreCase(target)) {
                return child;
            }
        }
        System.out.println("Directory not found: " + target);
        return null;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public boolean isFolder() {
        return true;
    }
}