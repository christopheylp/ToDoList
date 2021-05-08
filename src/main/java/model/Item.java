package model;

public class Item {
    String name;
    String content;
    User assigned;

    public Item(String name, String content) {
        this.name = name;
        this.content = content;
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

    public void addAssignement(User user){
        if(!verifAssigned()){
            user.setAssigned(this);
            this.assigned = user;
        }
    }

    public boolean addInTodo(TodoList todo){
        return todo.addItem(this);
    }

}
