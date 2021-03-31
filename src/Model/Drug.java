package Model;


import java.util.Arrays;
import java.util.Vector;

public class Drug {
    private String name;
    private double price;
    private Vector<String> ingredients;

    public Drug(String name, double price, Vector<String> ingredients) {
        this.name = name;
        this.price = price;
        this.ingredients = ingredients;
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

    public Vector<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Vector<String> ingredients) {
        this.ingredients = ingredients;
    }
}
