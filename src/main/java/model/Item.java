package model;

import java.util.ArrayList;

public class Item {
    String name;
    String description;
    User assigned;

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public User getAssigned() {
        return assigned;
    }

    public void setAssigned(User assigned) {
        this.assigned = assigned;
    }

    public boolean verifAssigned(){
        return this.assigned != null;
    }

    public User addAssignement(User user){
        if(!verifAssigned()){
            user.setAssigned(this);
            this.assigned = user;
        }
        return user;
    }

    public ArrayList<Item> addInTodo(TodoList todo){
        return todo.addItem(this);
    }

}
