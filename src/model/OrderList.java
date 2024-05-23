package model;


import view.ShopView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class OrderList {
    private ArrayList<Order> orders;
    private ShopView view;
    private Scanner scanner;
    private HashMap<Integer,Fruit> order;
    private Validator validator;
    public OrderList() {
        this.orders = new ArrayList<>();
        view = new ShopView();
        scanner = new Scanner(System.in);
        validator = new Validator();
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }
    public void addFruitToOrder(HashMap<Integer, Fruit> list){
            view.showMessage("===========================");
            view.requestInput("Please input id fruit:");
            String input = scanner.nextLine();
                while(!validator.checkID(input,list)){
                    if (input.equalsIgnoreCase("0"))
                        return;
                    view.requestInput("Re-Enter id fruit:");
                    input = scanner.nextLine();
                }
                int id = Integer.parseInt(input);
                view.showMessage("You selected: " + list.get(id).getName());
                view.requestInput("Please input quantity:");
                input = scanner.nextLine();
                while(!validator.isAvailable(id,input,list)){
                    view.requestInput("Re-Enter quantity:");
                    input = scanner.nextLine();
                }
                int quantity = Integer.parseInt(input);
                list.get(id).setQuantity(list.get(id).getQuantity()-quantity);
                if (order.containsKey(id)){
                    quantity += order.get(id).getQuantity();
                    order.get(id).setQuantity(quantity);
                }
                else {
                    Fruit fruit = new Fruit(id, list.get(id).getName(), list.get(id).getPrice(), quantity, list.get(id).getOrigin());
                    order.put(id,fruit);
                }
    }

    public void makeOrder(HashMap<Integer, Fruit> list){
        String command = "y";
        order= new HashMap<>();
        do{
            addFruitToOrder(list);
            view.showMessage("Do you want to continue (Y/N)?");
            view.requestInput("Enter your choice:");
            command = scanner.nextLine();
            if (command.equalsIgnoreCase("y")){
                continue;
            } else if (command.equalsIgnoreCase("n")) {
                if (order.isEmpty())
                    return;
                view.showOrder(order);
                view.requestInput("Input your name:");
                String name = scanner.nextLine();
                while (!validator.checkName(name)){
                    view.showMessage("Name must be character");
                    view.requestInput("Re-Enter Name:");
                    name = scanner.nextLine();
                }
                orders.add(new Order(name,order));
                return;
            }
        }while (!command.equalsIgnoreCase("n"));
    }
    public void showOrders(){
        for(Order i : orders){
            view.showMessage("Customer: " + i.getCustomerName());
            view.showOrder(i.getOrder());
            view.showMessage("");
        }
    }
}
