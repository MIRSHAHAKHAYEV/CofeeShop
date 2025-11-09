package Model;

public class Products {
    static int staticId=1;
    int id;
    String name;
    double price;
    String description;
    double calorie;

    public Products(String name, double price, String description) {
        id=staticId;
        staticId++;
        this.name = name;
        this.price = price;
        this.description = description;
    }
    public Products(String name, double price, String description, double calorie) {
        id=staticId;
        staticId++;
        this.name = name;
        this.price = price;
        this.description = description;
        this.calorie=calorie;
    }


    public double getCalorie() {
        return calorie;
    }

    public void setCalorie(double calorie) {
        this.calorie = calorie;
    }

    public  int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
