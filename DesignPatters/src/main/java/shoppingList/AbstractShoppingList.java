package shoppingList;

public abstract class AbstractShoppingList {
    protected String description;

    public String getDescription(){
        return description;
    }

    public abstract double price();

    @Override
    public String toString(){
        return getDescription() + " - " + price();
    }
}
