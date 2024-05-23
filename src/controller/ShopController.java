package controller;

import model.FruitList;
import model.OrderList;
import view.ShopView;

import java.util.Scanner;


public class ShopController {
    private ShopView view;
    private OrderList orders;
    private FruitList fruitList;
    private Scanner scanner;

    public ShopController() {
        view = new ShopView();
        orders = new OrderList();
        fruitList = new FruitList();
        scanner = new Scanner(System.in);
        startProgram();
    }
    public void startProgram(){
        view.showMenu();
        actionListener();
    }
    public void actionListener(){
        String command = scanner.nextLine();
        while(!command.equals(4)){
            switch (command){
                case "1":
                    createFruit();
                    break;
                case "2":
                    viewOrder();
                    break;
                case "3":
                    buyFruit();
                    break;
                case "4":
                    return;
                default:
                    view.showMessage("You must select 1 -> 4");
                    break;
            }
            command = scanner.nextLine();
        }
    }
    public void createFruit(){
        fruitList.createFruit();
        String command;
        do{
            view.showMessage("Do you want to continue (Y/N)?");
            view.requestInput("Enter your choice:");
            command = scanner.nextLine();
            if (command.equalsIgnoreCase("y")){
                fruitList.createFruit();
            } else if (command.equalsIgnoreCase("n")) {
                view.showMenu();
                return;
            } else {
                view.showMessage("You must select Y/N!");
            }
        }
        while (!command.equalsIgnoreCase("n"));
    }
    public void viewOrder(){
        orders.showOrders();
        view.showMenu();
    }
    public void buyFruit(){
        view.showMessage("List of Fruit:");
        showFruitList();
        orders.makeOrder(fruitList.getList());
        view.showMenu();
    }
    public void showFruitList(){
        view.showFruit(fruitList.getList());
    }
}
