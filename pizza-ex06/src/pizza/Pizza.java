package pizza;

import pizza.crust.PizzaCrust;
import pizza.sauce.PizzaSauce;
import pizza.topping.PizzaTopping;

import java.util.ArrayList;

public class Pizza implements MenuItem {
    private PizzaCrust crust;
    private PizzaSauce sauce;
    private ArrayList<PizzaTopping> toppingList;
    private ArrayList<MenuItem> selectionList;

    public Pizza() {
        this.crust = null;
        this.sauce = null;
        this.toppingList = new ArrayList<PizzaTopping>();
        this.selectionList = new ArrayList<MenuItem>();
    }

    public PizzaCrust getCrust() {
        return this.crust;
    }

    public void setCrust(PizzaCrust crust) {
        this.crust = crust;
        this.selectionList.add(crust);
    }

    public PizzaSauce getSauce() {
        return this.sauce;
    }

    public void setSauce(PizzaSauce sauce) {
        this.sauce = sauce;
        this.selectionList.add(sauce);
    }

    public ArrayList<PizzaTopping> getTopping() {
        return this.toppingList;
    }

    public void setTopping(ArrayList<PizzaTopping> toppings) {
        this.toppingList = toppings;
    }

    public void addTopping(PizzaTopping topping) {
        this.toppingList.add(topping);
        this.selectionList.add(topping);
    }

    public void display() {
        System.out.println("Pizza: $" + this.getPrice());
        System.out.println("  " +this.crust.toNiceString());
        System.out.println("  " + this.sauce.toNiceString());
        for (PizzaTopping t : this.toppingList) {
            System.out.println("  " + t.toNiceString());
        }
    }

    @Override
    public Double getPrice() {
        Double totalPrice = 0.0;
        for (MenuItem m : this.selectionList) {
            totalPrice += m.getPrice();
        }
        return totalPrice;
    }
}
