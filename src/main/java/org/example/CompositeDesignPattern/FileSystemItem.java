package org.example.CompositeDesignPattern;

public interface FileSystemItem {
    void ls(int indent);
    void openAll(int indent);
    int getSize();
    FileSystemItem cd(String target);
    String getName();
    boolean isFolder();
}