package model;

import view.ShopView;

import java.util.HashMap;
import java.util.Scanner;

public class FruitList {
    private HashMap<Integer,Fruit> list;
    private Scanner scanner;
    private ShopView view;
    private Validator validator;
    public FruitList() {
        list = new HashMap();
        scanner = new Scanner(System.in);
        view = new ShopView();
        validator = new Validator();
    }

    public HashMap<Integer, Fruit> getList() {
        return list;
    }

    public void createFruit(){
        view.showMessage("======Create Fruit==========");
        view.requestInput("Enter Fruit Name:");
        String name = scanner.nextLine();
        while(!validator.checkName(name)){
            view.showMessage("Fruit name must be character");
            view.requestInput("Re-Enter Fruit Name:");
            name = scanner.nextLine();
        }
        view.requestInput("Enter origin:");
        String origin = scanner.nextLine();
        while(!validator.checkName(origin)){
            view.showMessage("Origin must be character");
            view.requestInput("Re-Enter origin:");
            origin = scanner.nextLine();
        }
        view.requestInput("Enter price:");
        String price = scanner.nextLine();
        while(!validator.checkPrice(price)){
            view.requestInput("Re-Enter price:");
            price = scanner.nextLine();
        }
        view.requestInput("Enter quantity:");
        String quantity = scanner.nextLine();
        while(!validator.checkQuantity(quantity)){
            view.requestInput("Re-Enter quantity:");
            quantity = scanner.nextLine();
        }
        int id = list.size() + 1;
        list.put(id, new Fruit(id,name, Double.parseDouble(price), Integer.parseInt(quantity),
                 origin ));
    }

}
