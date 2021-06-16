package springbootserver.model;

public class Item {
    public String name;
    public String content;
    public User assigned;

    public Item(String name, String content) {
        this.name = name;
        this.content = content.length() > 1000 ? content.substring(0, 1000) : content;
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
