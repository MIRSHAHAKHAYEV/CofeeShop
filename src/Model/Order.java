package Model;

import java.util.ArrayList;

public class Order {
    static int staticId=1;
    int id;
    int table;
    double totalPrice=0;
    ArrayList<Products> orders=new ArrayList<>();

    public Order(int table) {
        id=staticId;
        staticId++;
        this.table = table;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public ArrayList<Products> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Products> orders) {
        this.orders = orders;
    }

    public int getTable() {
        return table;
    }

    public void setTable(int table) {
        this.table = table;
    }
}
