package model;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.stream.IntStream;

public class TodoList {
    ArrayList<Item> items;
    User admin;
    LocalDateTime lastInputItem = LocalDateTime.of(2021, 5, 8, 0, 0);    ;

    public TodoList(User admin) {
        this.items = new ArrayList<Item>();
        this.admin = admin;
    }

    public boolean addItem(Item item){
        if(this.items.size()>=10 || this.alreadyInTodo(item) || !this.verifyLastInputItem()){
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

}
