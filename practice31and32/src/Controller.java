import Items.Dish;
import Items.Drink;
import Items.MenuItem;
import Managers.InternetOrdersManager;
import Managers.TableOrdersManager;

public class Controller {
    private InternetOrdersManager internetOrdersManager;
    private TableOrdersManager tableOrdersManager;
    private final MenuItem[] menu;
    public Controller(){
        internetOrdersManager = new InternetOrdersManager();
        tableOrdersManager = new TableOrdersManager();
        menu = new MenuItem[]{new Drink(100,"Coffee","Strong and sweet"),
                new Drink(100,"Black tea","Sweet and honey tea"), new Drink(100,"Green tea","Tart and Mild green tea"),
                new Drink(80,"Milk","Warm cup of milk"),new Drink(120,"Juice","Cup of an apple tea"),
                new Drink(50,"Water","Cup of a water"), new Drink(150,"Soda","Bottle of cream soda"),
                new Drink(200,"Beer","Bottle of cold beer"), new Drink(200,"Wine","Glass of dry white wine"), new Drink(250,"Vodka","Shot of vodka"),
                new Drink(250,"Brandy","Shot of brandy"), new Drink(200,"Champagne","Glass of sweet champagne"), new Drink(300,"Whiskey","Shot of whiskey"),
                new Drink(350,"Tequila","Shot of tequila"), new Drink(350,"Rum","Shot of Carribean Rum"), new Drink(350,"Vermuth","Glass of vermuth"),
                new Drink(350,"Liquor","Shot of liquor"), new Drink(350,"Jagermeister","Shot of jagermeister"),
                new Dish(200,"Mashed Potatoes","Plate of mashed potatoes"), new Dish(230,"Carbonara","Plate of spaghetti with cheese and bacon"),
                new Dish(400,"New York steak","Beef steak with pepper"), new Dish(220,"Mushroom Soup","Bowl of mushroom soup"),
                new Dish(350,"Caviar Pancake","Pancake with a red caviar")};
    }

    public MenuItem[] getMenu() {
        return menu.clone();
    }

    public InternetOrdersManager getInternetOrdersManager() {
        return internetOrdersManager;
    }

    public TableOrdersManager getTableOrdersManager() {
        return tableOrdersManager;
    }
}
