import Model.Order;
import Service.OrderService;

import java.util.Scanner;

public class App {
    public static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        OrderService os=new OrderService();
        os.addCoffeeOrSweet("Espresso", 3.50, "Tünd və qatı qəhvə");
        os.addCoffeeOrSweet("Latte", 4.20, "Süd və qəhvə qarışığı, yüngül dad");
        os.addCoffeeOrSweet("Cheesecake", 5.00, "Kremli pendir tortu", 320);
        os.addCoffeeOrSweet("Tiramisu", 4.80, "Qəhvə dadlı italyan deserti", 290);
        Order table=os.createTable();
        int op=0;
        while (op!=4) {
            os.openMenu();
            op= sc.nextInt();
            switch (op) {
                case 1:
                    os.showProducts();
                    os.requestOrder(table);
                    break;
                case 2:
                    os.showTotal(table);
                    break;
                case 3:
                    os.getBill(table);
                    table=os.createTable();
                    break;
                default:
                    System.out.println("zehmet olmasa duzgun emeliyyat secin");
            }
        }

    }
}
