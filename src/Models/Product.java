package Models;

public class Product {
    private String name;
    private String description;
    private int stock;
    private int price;

    public Product(String name, String description, int stock , int price){
        this.name = name;
        this.description = description;
        this.stock = stock;
        this.price = price;
    }

    public String getName(){
        return this.name;
    }
    public String getDescription(){return this.description;}
    public int getPrice(){
        return this.price;
    }
    public int getStock(){
        return this.stock;
    }



}
