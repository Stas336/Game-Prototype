package player;

import item.money.EUR;
import item.money.RUB;
import item.money.USD;
import item.types.Item;
import item.types.impl.Money;

import java.util.ArrayList;
import java.util.HashMap;

public class Player
{
    private int health;
    private int armor;
    private int moneyRUB;
    private int moneyUSD;
    private int moneyEUR;
    private ArrayList<Item> inventory;
    //private ArrayList<Item> rightHand;
    //private ArrayList<Item> leftHand;
    //private ArrayList<Item> torso;

    public Player()
    {
        setHealth(0);
        setArmor(0);
        setMoneyRUB(0);
        setMoneyUSD(0);
        setMoneyEUR(0);
        inventory = new ArrayList<>();
    }

    public void showPlayerInfo()
    {
        String leftAlignFormat = "| %-3d| %-3d   | %-5d       | %-5d       | %-5d       |%n";
        System.out.format("+----+-------+-------------+-------------+-------------+%n");
        System.out.format("| HP | ARMOR | MONEY (RUB) | MONEY (USD) | MONEY (EUR) |%n");
        System.out.format("+----+-------+-------------+-------------+-------------+%n");
        System.out.format(leftAlignFormat, getHealth(), getArmor(), getMoneyRUB(), getMoneyUSD(), getMoneyEUR());
        System.out.format("+----+-------+-------------+-------------+-------------+%n");
    }

    public void increaseMoneyCheck(Item item)
    {
        if (item instanceof RUB)
        {
            moneyRUB += ((Money) item).getCost();
        }
        else if (item instanceof USD)
        {
            moneyUSD += ((Money) item).getCost();
        }
        else if (item instanceof EUR)
        {
            moneyEUR += ((Money) item).getCost();
        }
    }
    public void decreaseMoneyCheck(Item item)
    {
        if (item instanceof RUB)
        {
            moneyRUB -= ((Money) item).getCost();
        }
        else if (item instanceof USD)
        {
            moneyUSD -= ((Money) item).getCost();
        }
        else if (item instanceof EUR)
        {
            moneyEUR -= ((Money) item).getCost();
        }
    }

    public void insertIntoInventory(Item item)
    {
        increaseMoneyCheck(item);
        inventory.add(item);
    }
    public int getAmount(Item item)
    {
        int qty = 0;
        for (Item tempItem:inventory)
        {
            if (item.getDescription().equals(tempItem.getDescription()))
            {
                qty++;
            }
        }
        return qty;
    }
    public ArrayList<Money> getPackOfMoney(String currency, int amount)
    {
        ArrayList<Money> moneyPack = new ArrayList<>();
        int money = 0;
        if (currency.equalsIgnoreCase("RUB"))
        {
            money = getMoneyRUB();
        }
        else if (currency.equalsIgnoreCase("USD"))
        {
            money = getMoneyUSD();
        }
        else if (currency.equalsIgnoreCase("EUR"))
        {
            money = getMoneyEUR();
        }
        if (money >= amount)
        {
            for (Item item:getInventory())
            {
                if (item instanceof Money)
                {
                    if (item.getCurrency().equalsIgnoreCase(currency) && item.getCost() <= amount)
                    {
                        moneyPack.add((Money) item);
                        amount -= item.getCost();
                        if (amount == 0)
                        {
                            for (Item item1:moneyPack)
                            {
                                deleteFromInventory(item1);
                            }
                            return moneyPack;
                        }
                    }
                }
            }
        }
        else
        {
            System.out.println("You dont have that amount of money");
            return null;
        }
        return null;
    }
    public int getPackOfMoneyCost(ArrayList<Money> pack)
    {
        int cost = 0;
        for (Money money:pack)
        {
            cost += money.getCost();
        }
        return cost;
    }
    public void givePackOfMoney(ArrayList<Money> pack, Player player)
    {
        for (Money money:pack)
        {
            player.insertIntoInventory(money);
        }
    }
    public Item buy(String itemName, ArrayList<Money> money, Player player)
    {
        Item item = player.getFromInventory(itemName);
        if (item == null)
        {
            System.out.println("Selected player doesnt have that item");
            return null;
        }
        if (getPackOfMoneyCost(money) >= item.getCost())
        {
            givePackOfMoney(money, player);
            return item;
        }
        System.out.println("You gave not enough money for that item");
        return null;
    }
    public void give(String itemName, Player player)
    {
        Item item = getFromInventory(itemName);
        player.insertIntoInventory(item);
    }
    public ArrayList<Money> sell(String itemName, int cost, String currency, Player player)
    {
        ArrayList<Money> pack = player.getPackOfMoney(currency, cost);
        Item item = getFromInventory(itemName);
        if (getPackOfMoneyCost(pack) >= cost && item != null)
        {
            player.insertIntoInventory(item);
            return pack;
        }
        else
        {
            System.out.println("You dont have this item or another player dont have such amount of money");
            return null;
        }
    }
    public Item take(String itemName, Player player)
    {
        Item item = player.getFromInventory(itemName);
        if (item != null)
        {
            return item;
        }
        else
        {
            System.out.println("Another player dont have this item");
            return null;
        }
    }
    public void deleteFromInventory(Item item)
    {
        if (!inventory.isEmpty())
        {
            inventory.remove(item);
            decreaseMoneyCheck(item);
        }
    }
    public Item getFromInventory(int index)
    {
        if (!inventory.isEmpty())
        {
            Item item = inventory.remove(index);
            decreaseMoneyCheck(item);
            return item;
        }
        else
        {
            return null;
        }
    }
    public Item getFromInventory(String name)
    {
        if (!inventory.isEmpty())
        {
            for (Item item:inventory)
            {
                if (item.getDescription().equalsIgnoreCase(name))
                {
                    inventory.remove(item);
                    decreaseMoneyCheck(item);
                    return item;
                }
            }
            return null;
        }
        else
        {
            return null;
        }
    }

    public HashMap<Item, Integer> getAllItemTypes()
    {
        if (!getInventory().isEmpty())
        {
            ArrayList<Item> types = new ArrayList<>();
            int[] typesAmount = new int[getInventory().size()];
            Boolean check = true;
            for (Item item:getInventory())
            {
                if (types.isEmpty())
                {
                    types.add(item);
                    typesAmount[types.indexOf(item)] = 1;
                }
                else
                {
                    for (Item item1:types)
                    {
                        if (item.getDescription().equals(item1.getDescription()))
                        {
                            typesAmount[types.indexOf(item1)]++;
                            check = false;
                        }
                    }
                    if (check)
                    {
                        types.add(item);
                        typesAmount[types.indexOf(item)] = 1;
                    }
                    check = true;
                }
            }
            HashMap<Item, Integer> map = new HashMap<>();
            for (Item item:types)
            {
                map.put(item, typesAmount[types.indexOf(item)]);
            }
            return map;
        }
        else
        {
            System.out.println("Inventory is empty");
            return null;
        }
    }
    public ArrayList<Item> getInventory()
    {
        return inventory;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public void increaseArmor(int armor)
    {
        this.armor += armor;
    }

    public void decreaseArmor(int armor)
    {
        this.armor -= armor;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void increaseHealth(int health)
    {
        this.health += health;
    }

    public void decreaseHealth(int health)
    {
        this.health -= health;
    }

    public int getMoneyRUB() {
        return moneyRUB;
    }

    public void setMoneyRUB(int moneyRUB) {
        this.moneyRUB = moneyRUB;
    }

    public int getMoneyUSD() {
        return moneyUSD;
    }

    public void setMoneyUSD(int moneyUSD) {
        this.moneyUSD = moneyUSD;
    }

    public int getMoneyEUR() {
        return moneyEUR;
    }

    public void setMoneyEUR(int moneyEUR) {
        this.moneyEUR = moneyEUR;
    }
}