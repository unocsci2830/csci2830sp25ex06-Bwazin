package pizza;

import pizza.crust.ThinCrust;
import pizza.sauce.AlfredoSauce;
import pizza.sauce.TomatoSauce;
import pizza.crust.ThickCrust;
import pizza.topping.*;

import java.util.Scanner;

public class PizzaMain {
    private Pizza pizza;
    private Scanner input;

    public PizzaMain() {
        pizza = new Pizza();
        input = new Scanner(System.in);
    }

    private void inputCrustChoice() {
        Boolean validChoice = false;
        Integer choice = 0;
        System.out.println("What kind of crust would you like:");
        System.out.println("1 - Thin Crust");
        System.out.println("2 - Thick Crust");
        System.out.print("Your choice: ");
        while (!validChoice) {
            choice = input.nextInt();
            switch(choice) {
                case 1:
                    pizza.setCrust(new ThinCrust());
                    validChoice = true;
                    break;
                case 2:
                    pizza.setCrust(new ThickCrust());
                    validChoice = true;
                    break;
                default:
                    System.out.println("Pick between 1-2");
            }
        }

        System.out.println("Select crust ingredient:");
        System.out.println("1 - Flour");
        System.out.println("2 - Cauliflower");
        System.out.print("Your choice: ");
        validChoice = false;
        while (!validChoice) {
            Integer ingredientChoice = input.nextInt();
            switch(ingredientChoice) {
                case 1:
                    pizza.getCrust().setIngredient("Flour");
                    validChoice = true;
                    break;
                case 2:
                    pizza.getCrust().setIngredient("Cauliflower");
                    validChoice = true;
                    break;
                default:
                    System.out.println("Pick between 1-2");
            }
        }

        if (choice == 2) {
            ThickCrust thickCrust = (ThickCrust) pizza.getCrust();
            System.out.print("Deep Dish? (Y/N)");
            validChoice = false;
            while (!validChoice) {
                String deepDishChoice = input.next();
                switch(deepDishChoice) {
                    case "Y":
                    case "y":
                        thickCrust.setIsDeepDish(true);
                        validChoice = true;
                        break;
                    case "N":
                    case "n":
                        thickCrust.setIsDeepDish(false);
                        validChoice = true;
                        break;
                    default:
                        System.out.println("Pick between Y or N");
                }
            }

        }


    }

    private void inputSauceChoice() {
        Boolean validChoice = false;
        System.out.println("What kind of sauce would you like:");
        System.out.println("1 - Tomato Sauce");
        System.out.println("2 - Alfredo Sauce");
        System.out.print("Your choice: ");
        while (!validChoice) {
            Integer choice = input.nextInt();
            switch(choice) {
                case 1:
                    pizza.setSauce(new TomatoSauce());
                    validChoice = true;
                    break;
                case 2:
                    pizza.setSauce(new AlfredoSauce());
                    validChoice = true;
                    break;
                default:
                    System.out.println("Pick between 1-2");
            }
        }
    }

    private void inputToppingChoices() {
        System.out.print("How many toppings? ");
        Integer numToppings = input.nextInt();
        for (Integer i = 0; i < numToppings; i++) {
            Boolean validChoice = false;
            System.out.println("1 - Pepperoni");
            System.out.println("2 - Sausage");
            System.out.println("3 - Olives");
            System.out.println("4 - Green Onions");
            System.out.println("5 - Mozzarella");
            System.out.println("6 - Parmesan");
            System.out.print("Your choice: ");
            while (!validChoice) {
                Integer choice = input.nextInt();
                switch(choice) {
                    case 1:
                        pizza.addTopping(new PepperoniTopping());
                        validChoice = true;
                        break;
                    case 2:
                        pizza.addTopping(new SausageTopping());
                        validChoice = true;
                        break;
                    case 3:
                        pizza.addTopping(new OlivesTopping());
                        validChoice = true;
                        break;
                    case 4:
                        pizza.addTopping(new GreenOnionsTopping());
                        validChoice = true;
                        break;
                    case 5:
                        pizza.addTopping(new MozarellaTopping());
                        validChoice = true;
                        break;
                    case 6:
                        pizza.addTopping(new ParmesanTopping());
                        validChoice = true;
                        break;
                    default:
                        System.out.println("Pick between 1-6");
                }
            }
        }
    }

    private void showPizza() {
        pizza.display();
    }

    public void runMenu() {
        inputCrustChoice();
        inputSauceChoice();
        inputToppingChoices();
        showPizza();
    }

    public static void main(String[] args) {
        PizzaMain pm = new PizzaMain();
        pm.runMenu();

    }
}