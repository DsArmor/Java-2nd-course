package Items;

public final class Drink extends MenuItem implements Alcoholable {
    private final double alcoholVol;
    private final DrinkTypeEnum type;

    public Drink(int cost,String name, String description) {
        super(cost,name,description);
        this.type = getType();
        this.alcoholVol = getAlcoholVol();

    }

    public DrinkTypeEnum getType(){
        switch(getName()){
            case "Juice":
                return DrinkTypeEnum.JUICE;
            case "Water":
                return DrinkTypeEnum.WATER;
            case "Black tea":
                return DrinkTypeEnum.BLACK_TEA;
            case "Green tea":
                return DrinkTypeEnum.GREEN_TEA;
            case "Milk":
                return DrinkTypeEnum.MILK;
            case "Soda":
                return DrinkTypeEnum.SODA;
            case "Coffee":
                return DrinkTypeEnum.COFFEE;
            case "Rum":
                return DrinkTypeEnum.RUM;
            case "Beer":
                return DrinkTypeEnum.BEER;
            case "Wine":
                return DrinkTypeEnum.WINE;
            case "Vodka":
                return DrinkTypeEnum.VODKA;
            case "Brandy":
                return DrinkTypeEnum.BRANDY;
            case "Liquor":
                return DrinkTypeEnum.LIQUOR;
            case "Tequila":
                return DrinkTypeEnum.TEQUILA;
            case "Vermuth":
                return DrinkTypeEnum.VERMUTH;
            case "Whiskey":
                return DrinkTypeEnum.WHISKEY;
            case "Champagne":
                return DrinkTypeEnum.CHAMPAGNE;
            case "Jagermeister":
                return DrinkTypeEnum.JAGERMEISTER;
            default:
                break;
        }
        return null;
    }
    @Override
    public boolean isAlcoholicDrink() {
        switch (type){
            case JUICE:
            case WATER:
            case BLACK_TEA:
            case GREEN_TEA:
            case MILK:
            case SODA:
            case COFFEE:
                return false;
            case RUM:
            case BEER:
            case WINE:
            case VODKA:
            case BRANDY:
            case LIQUOR:
            case TEQUILA:
            case VERMUTH:
            case WHISKEY:
            case CHAMPAGNE:
            case JAGERMEISTER:
                return true;
            default:
                break;
        }
        return false;
    }
    @Override
    public double getAlcoholVol() {
        switch (type){
            case JUICE:
            case WATER:
            case BLACK_TEA:
            case GREEN_TEA:
            case MILK:
            case SODA:
            case COFFEE:
                return 0;
            case JAGERMEISTER:
                return 35;
            case BEER:
                return 4.8;
            case CHAMPAGNE:
                return 9.2;
            case VODKA:
            case WHISKEY:
            case RUM:
            case TEQUILA:
            case LIQUOR:
            case VERMUTH:
            case BRANDY:
                return 40;
            case WINE:
                return 12;
            default:
                break;
        }
        return -1;
    }

}
