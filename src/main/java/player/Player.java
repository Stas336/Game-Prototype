package player;

import item.types.Item;
import item.types.impl.Money;

import java.util.ArrayList;

public class Player
{
    private int health;
    private int armor;
    private int money; //RUB
    private ArrayList<Item> inventory;

    public void initialize()
    {
        setHealth(0);
        setArmor(0);
        setMoney(0);
        inventory = new ArrayList<Item>();
    }

    public void showPlayerInfo()
    {
        String leftAlignFormat = "| %-3d| %-3d   | %-5d       |%n";
        System.out.format("+----+-------+-------------+%n");
        System.out.format("| HP | ARMOR | MONEY (RUB) |%n");
        System.out.format("+----+-------+-------------+%n");
        System.out.format(leftAlignFormat, getHealth(), getArmor(), getMoney());
        System.out.format("+----+-------+-------------+%n");
    }

    public void insertIntoInventory(Item item)
    {
        if (item instanceof Money)
        {
            money += ((Money) item).showInRUB();
        }
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
    public Item getFromInventory(int index)
    {
        if (!inventory.isEmpty())
        {
            Item item = inventory.remove(index);
            if (item instanceof Money)
            {
                money -= ((Money) item).showInRUB();
            }
            return item;
        }
        else
        {
            return null;
        }
    }

    public ArrayList<Item> getAllItemTypes()
    {
        return this.inventory;
    }

    public int getMoney()
    {
        return money;
    }

    public void setMoney(int money)
    {
        this.money = money;
    }

    public void increaseMoney(int money)
    {
        this.money += money;
    }

    public void decreaseMoney(int money)
    {
        this.money -= money;
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
}