package model;

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

    public boolean verifAssigned(User user){
        if(this.assigned != null){
            return true;
        }
        return false;
    }

    public User addAssignement(User user){
        if(!verifAssigned(user)){
            user.setAssigned(this);
        }
        return user;
    }

}
