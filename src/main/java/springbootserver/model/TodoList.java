package springbootserver.model;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.stream.IntStream;

public class TodoList {
    public String name;
    public ArrayList<Item> items;
    public User admin;
    public LocalDateTime lastInputItem = LocalDateTime.now().minusMinutes(30);

    public TodoList(User admin, String name) {
        this.name = name;
        this.items = new ArrayList<>();
        this.admin = admin;
    }

    public boolean addItem(Item item){
        isThere8Items();
        if(this.items.size()>=10 || this.alreadyInTodo(item) || !this.verifyLastInputItem()){
            return false;
        }
        this.items.add(item);
        this.lastInputItem = LocalDateTime.now();
        return true;
    }

    public boolean deleteItem(int index){
        this.items.remove(index);
        this.lastInputItem = LocalDateTime.now();
        return true;
    }

    public boolean addItemWithoutTime(Item item){
        if(this.items.size()>=10 || this.alreadyInTodo(item)){
            return false;
        }
        this.items.add(item);
        this.lastInputItem = LocalDateTime.now();
        return true;
    }

    public boolean alreadyInTodo(Item item){
        return IntStream.range(0, this.items.size()).anyMatch(i -> this.items.get(i).name.equals(item.name));
    }

    public boolean verifyLastInputItem(){
        LocalDateTime newDate = LocalDateTime.now();
        long diff = ChronoUnit.MINUTES.between(this.lastInputItem, newDate);
        return diff >= 30;
    }

    public boolean isThere8Items(){
        if( this.items.size() == 8){
            EmailSenderService.sendEmail();
            return true;
        }
        return false;
    }


}
