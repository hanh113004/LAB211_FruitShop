package model;

import view.ShopView;

import java.util.HashMap;

public class Validator {
    private ShopView view;
    public Validator(){
        view = new ShopView();
    }
    public boolean checkName(String name){
        if(!name.matches("[a-zA-Z ]+"))
            return false;
        else return true;
    }
    public Boolean checkPrice(String price){
        try {
            double xPrice = Double.parseDouble(price);
            return true;
        }catch (NumberFormatException e){
            view.showMessage("You must enter real number");
            return false;
        }
    }
    public Boolean checkQuantity(String quantity){
        try {
            int xQuantity = Integer.parseInt(quantity);
            return true;
        }catch (NumberFormatException e){
            view.showMessage("You must enter integer number");
            return false;
        }
    }
    public boolean checkID(String id, HashMap<Integer, Fruit> list){
        try {
            int xId = Integer.parseInt(id);
            if (id.equalsIgnoreCase("0"))
                return false;
            if (!list.containsKey(xId)){
                view.showMessage("Id Fruit doesn't exist!");
                return false;
            }
            return true;
        }catch (NumberFormatException e){
            view.showMessage("You must enter integer number");
            return false;
        }
    }
    public boolean isAvailable(int id, String quantity, HashMap<Integer, Fruit> list){
        try {
            int xQuantity = Integer.parseInt(quantity);
            if (list.get(id).getQuantity() < xQuantity){
                view.showMessage("Quantity  of " + list.get(id).getName() + "doesn't enough");
                view.showMessage("Remaining: " + list.get(id).getQuantity());
                return false;
            } else
            return true;
        }catch (NumberFormatException e){
            view.showMessage("You must enter integer number");
            return false;
        }
    }
}
