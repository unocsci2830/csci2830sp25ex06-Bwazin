package pizza.crust;

public class ThickCrust extends PizzaCrust {
    private Boolean isDeepDish;

    @Override
    public String toString() {
        return "Thick Crust";
    }

    public String toNiceString(){
        return super.toNiceString() + "\n  Deep Dish: " + isDeepDish;
    }

    public Boolean getDeepDish() {
        return isDeepDish;
    }

    public void setIsDeepDish(Boolean deepDish) {
        this.isDeepDish = deepDish;
    }

    public String checkIntegrity(){
        return this.ingredient.equalsIgnoreCase("Cauliflower")? "Handle carefully: crust might fall apart" :
            super.checkIntegrity();
    }
}
