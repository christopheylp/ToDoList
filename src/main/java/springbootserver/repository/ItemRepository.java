package springbootserver.repository;

import org.springframework.stereotype.Repository;
import springbootserver.model.Item;
import springbootserver.model.TodoList;
import springbootserver.model.User;

import java.time.LocalDate;
import java.util.ArrayList;

@Repository
public class ItemRepository {

    private static final ArrayList<Item> itemsList = new ArrayList<>();

    static {
        initItems();
    }

    private static void initItems() {
        Item item1 = new Item("item1", "desc1");
        Item item2 = new Item("item2", "desc2");
        Item item3 = new Item("item3", "desc3");
        itemsList.add(item1);
        itemsList.add(item2);
        itemsList.add(item3);
    }


    public Item getItem(int No) {
        return itemsList.get(No - 1);
    }

    public Item addItem(Item item) {
        itemsList.add(item);
        return item;
    }

    public Item updateItem(int i, Item item) {
        itemsList.set(i, item);
        return item;
    }

    public Item deleteItem(int nb) {
        return itemsList.remove(nb);
    }

    public ArrayList<Item> getAllItems() {
        return itemsList;
    }

    public TodoList addItemInTodo(TodoList todo, Item item) {
        todo.addItem(item);
        return todo;
    }

    public TodoList deleteItemInTodo(TodoList todo, int indexItemInTodo) {
        todo.deleteItem(indexItemInTodo);
        return todo;
    }
}
