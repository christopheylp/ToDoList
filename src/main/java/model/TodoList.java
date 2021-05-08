package model;
import java.util.ArrayList;
import java.util.stream.IntStream;

public class TodoList {
    ArrayList<Item> items;
    User admin;

    public TodoList(User admin) {
        this.items = new ArrayList<Item>();
        this.admin = admin;
    }

    public boolean addItem(Item item){
        if(this.items.size()>=10 || this.alreadyInTodo(item)){
            return false;
        }
        this.items.add(item);
        return true;
    }

    public boolean alreadyInTodo(Item item){
        return IntStream.range(0, this.items.size()).anyMatch(i -> this.items.get(i).name.equals(item.name));
    }


}
