package view;

import model.Fruit;
import model.FruitList;

import java.util.ArrayList;
import java.util.HashMap;

public class ShopView {
    public ShopView() {
    }
    public void showMenu(){
        System.out.println("=====================");
        System.out.println("FRUIT SHOP SYSTEM");
        System.out.println("1. Create Fruit");
        System.out.println("2. View orders");
        System.out.println("3. Shopping (for buyer)");
        System.out.println("4. Exit");
        System.out.println("(Please choose 1 to create product, 2 to view order, 3 for shopping, 4 to Exit program).");
        System.out.print("Enter your choice: ");
    }
    public void showMessage(String msg){
        System.out.println(msg);
    }
    public void requestInput(String msg){
        System.out.print(msg);
    }
    public void showFruit(HashMap<Integer, Fruit> list){
        System.out.printf("| %10s | %20s | %15s | %15s |\n", "++ Item ++" , "++ Fruit Name ++",
                "++ Origin ++", "++ Price ++");
        for (int i : list.keySet()){
            Fruit object = list.get(i);
            System.out.printf("| %10d | %20s | %15s | %15.2f |\n", object.getID(), object.getName(),
                    object.getOrigin(), object.getPrice());
        }
    }
    public void showOrder(HashMap<Integer,Fruit> list){
        System.out.printf("%20s | %10s | %10s | %10s\n", "Product", "Quantity", "Price", "Amount");
        double total = 0;
        int index = 1;
        for(int j : list.keySet()){
            Fruit i =  list.get(j);
            if (i.getQuantity() != 0){
                System.out.printf("%20s | %10d | %10.2f$ | %10.2f$\n", index +". " + i.getName() ,
                        i.getQuantity(), i.getPrice(), i.getPrice() * i.getQuantity());
                total += i.getPrice() * i.getQuantity();
                index ++;
            }
        }
        System.out.println("Total: " + total + "$");
    }

}
