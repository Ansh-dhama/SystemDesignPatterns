package org.example.Projects.Restaurant.model;

public class Table {
    private int totalNumber;
    private boolean isOccupied;

    public Table(int totalNumber ) {
        this.totalNumber = totalNumber;
    }
    public int getTotalNumber() {
        return totalNumber;
    }
    public  int getTableNumber() {
        return  totalNumber;
    }
    public boolean getIsOccupied() {
        return isOccupied;
    }
    public void occupied() {
        isOccupied = true;
    }
    public void vacate() {
        isOccupied = false;
    }

    public boolean tryOccupy() {
        return isOccupied == false ? true : false;
    }
}
