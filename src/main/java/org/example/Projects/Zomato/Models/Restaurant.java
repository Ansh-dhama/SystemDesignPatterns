package org.example.Projects.Zomato.Models;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private static int nextId = 0;
    private int id;
    private String name;
    private String location;
     private List<MenuItem> menuItems;

     public Restaurant( String name, String location) {
         this.id = ++nextId;
         this.name = name;
         this.location = location;
         this.menuItems = new ArrayList<>();
     }
     public int getId() {
        return id;
      }

     public String getName() {
         return name;
     }


     public String getLocation() {
         return location;
     }

     public void addMenuItem(MenuItem menuItem) {
         menuItems.add(menuItem);
     }

     @Override
     public String toString() {
         return "Restaurant [id=" + id + ", name=" + name + ", location=" + location;
     }

    public List<MenuItem> getMenuItems() {
         return menuItems;
    }
}
