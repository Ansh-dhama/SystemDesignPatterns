package org.example.Projects.Restaurant;

import org.example.Projects.Restaurant.DiscountStrategy.PercentageStrategy;
import org.example.Projects.Restaurant.Dishs.DishType;
import org.example.Projects.Restaurant.Dishs.MenuFactory;
import org.example.Projects.Restaurant.Payment.Payment;
import org.example.Projects.Restaurant.Payment.PaymentMethod;
import org.example.Projects.Restaurant.inter.DiscountStrategy;
import org.example.Projects.Restaurant.inter.MenuItem;
import org.example.Projects.Restaurant.model.Bill;
import org.example.Projects.Restaurant.model.Order;
import org.example.Projects.Restaurant.model.Restaurant;
import org.example.Projects.Restaurant.model.Table;

public class RestaurantSystemDemo {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant("Dhama",10);
        Table table1 = restaurant.getTable(1);

        table1.occupied();
        Order order = new Order("ORD-101", table1);

        MenuItem menuItem1 = MenuFactory.createItem(DishType.VEG,"Paneer Tikka",220);
        MenuItem menuItem2 = MenuFactory.createItem(DishType.NON_VEG,"Chikkan ",120);
        System.out.println(menuItem1.getDescription());
        order.addItem(menuItem1);
        order.addItem(menuItem2);

        order.startPreparation();
        order.serve();

        DiscountStrategy discountStrategy = new PercentageStrategy(10);
        Bill bill = new Bill("1",order,discountStrategy);
        bill.printReceipt();

        Payment payment = new Payment("1", bill.calculate(), PaymentMethod.CASH);

        if(payment.process()){
            System.out.println("Payment successful");
            order.pay();
            table1.vacate();
            System.out.println("Table 1 vacated");
        }

    }
}
