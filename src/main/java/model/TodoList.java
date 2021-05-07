package model;
import java.util.ArrayList;

public class TodoList {
    ArrayList<Item> items;
    User admin;

    public TodoList(User admin) {
        this.items = new ArrayList<Item>();
        this.admin = admin;
    }

    public ArrayList<Item> addItem(Item item){
        if(this.items.size()<10){
            this.items.add(item);
        }
        return this.items;
    }

}
