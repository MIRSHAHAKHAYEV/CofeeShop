package Service;

import Model.Products;
import Model.Order;
import db.DataOfProducts;
import java.util.Iterator;
import static Util.Utils.sc;
import static db.DataOfProducts.dataOfProducts;
import static db.DataOfProducts.dataOfTables;

public class OrderService {
    public void addCoffeeOrSweet(String name, double price, String description){
        Products cf=new Products(name, price, description);
        dataOfProducts.put(cf.getId(),cf);
    }
    public void addCoffeeOrSweet(String name, double price, String description,double calorie){
        Products sw=new Products(name, price, description,calorie);
        dataOfProducts.put(sw.getId(),sw);
    }
    public Order createTable(){
        System.out.println("Zəhmət olmasa masa nömrənizi daxil edin:");
        return new Order(sc.nextInt());
    }
    public void openMenu(){
        System.out.println("=== COFFEE SHOP MENU ===\n" +
                "1. Sifariş et\n" +
                "2. Ümumi hesabı göstər\n" +
                "3. Hesab iste\n" +
                "4. Çıxış\n" +
                "Seçiminizi daxil edin:");
    }
    public void showProducts(){
        Iterator<Integer> nameOfProducts=dataOfProducts.keySet().iterator();
        System.out.println("0.CIXIS\n--- COFFEES ---");
        while (nameOfProducts.hasNext()){
            Products currentProduct=dataOfProducts.get(nameOfProducts.next());
            if(currentProduct.getCalorie()==0){
                System.out.println(currentProduct.getId()+"."+currentProduct.getName()+" - "+currentProduct.getPrice()+" AZN");
            }
        }
        nameOfProducts=dataOfProducts.keySet().iterator();
        System.out.println("--- SWEETS ---");
        while (nameOfProducts.hasNext()){
            Products currentProduct=dataOfProducts.get(nameOfProducts.next());
            if(currentProduct.getCalorie()!=0){
                System.out.println(currentProduct.getId()+"."+currentProduct.getName()+" - "+currentProduct.getPrice()+" AZN");
            }
        }

    }
    public void requestOrder(Order table){
        System.out.println("sifaris elemek istediyiniz yemeyi/icmeyi secin");
        int id=sc.nextInt();
        while (id!=0) {
            table.getOrders().add(DataOfProducts.dataOfProducts.get(id));
            table.setTotalPrice(table.getTotalPrice() + DataOfProducts.dataOfProducts.get(id).getPrice());
            id=sc.nextInt();
        }
    }
    public void showTotal(Order table){
        System.out.println("=== Masa "+table.getTable()+" üçün Sifarişlər ===");
        Iterator<Products>allProducts=table.getOrders().iterator();
        double total =0;
        while (allProducts.hasNext()){
            Products currentProduct=allProducts.next();
            System.out.println(currentProduct.getName()+" - "+currentProduct.getPrice()+" AZN");
            total+=currentProduct.getPrice();
        }
        System.out.println("--------------------------");
        System.out.println("Cəmi: "+total+" AZN");
    }
    public void getBill(Order table){
        showTotal(table);
        dataOfTables.remove(table.getTable());
        System.out.println("“Təşəkkür edirik!” ");
    }
}
