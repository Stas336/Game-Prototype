package player;

import item.equipment.cloth.Cloth;
import item.money.*;
import item.money.Currency;
import item.types.Item;
import item.types.ItemType;
import item.types.impl.Bill;
import item.types.impl.BillsPack;

import java.util.*;

public class Player
{
    private int health;
    private int armor;
    private List<Money> currencies;
    private List<Item> inventory;
    private List<Cloth> clothes;
    /*private Cloth head;
    private Cloth leftHand;
    private Cloth rightHand;
    private Cloth upperBodyPart;
    private Cloth lowerBodyPart;
    private Cloth leftKnee;
    private Cloth rightKnee;
    private Cloth leftLeg;
    private Cloth rightLeg;*/


    public Player()
    {
        setHealth(0);
        setArmor(0);
        currencies = new ArrayList<>();
        inventory = new ArrayList<>();
        clothes = new ArrayList<>();
    }

    public void showPlayerInfo()
    {
        System.out.println("+----+---+");
        System.out.printf("| HP | %d |\n", getHealth());
        System.out.println("+----+---+");
        System.out.println("+-------+---+");
        System.out.printf("| ARMOR | %d |\n", getArmor());
        System.out.println("+-------+---+");
        for (Money money:currencies)
        {
            System.out.println("+-------------+-----+");
            System.out.printf("| MONEY (%s) | %d |\n", money.getCurrency(), money.getValue());
            System.out.println("+-------------+-----+");
        }
    }

    public void increaseMoneyCheck(Bill bill)
    {
        for (Money money:getCurrencies())
        {
            if (money.getCurrency() == bill.getCost().getCurrency())
            {
                money.setValue(money.getValue() + bill.getCost().getValue());
                return;
            }
        }
        if (bill.getCost().getCurrency() == Currency.RUB)
        {
            getCurrencies().add(new MoneyRUB(bill.getCost().getValue()));
        }
        else if (bill.getCost().getCurrency() == Currency.USD)
        {
            getCurrencies().add(new MoneyUSD(bill.getCost().getValue()));
        }
        else if (bill.getCost().getCurrency() == Currency.EUR)
        {
            getCurrencies().add(new MoneyEUR(bill.getCost().getValue()));
        }
    }
    public void increaseMoneyCheck(BillsPack billsPack)
    {
        for (Money money:getCurrencies())
        {
            if (money.getCurrency() == billsPack.getCurrency())
            {
                money.setValue(money.getValue() + billsPack.getCost().getValue());
                return;
            }
        }
        if (billsPack.getCost().getCurrency() == Currency.RUB)
        {
            getCurrencies().add(new MoneyRUB(billsPack.getCost().getValue()));
        }
        else if (billsPack.getCost().getCurrency() == Currency.USD)
        {
            getCurrencies().add(new MoneyUSD(billsPack.getCost().getValue()));
        }
        else if (billsPack.getCost().getCurrency() == Currency.EUR)
        {
            getCurrencies().add(new MoneyEUR(billsPack.getCost().getValue()));
        }
    }
    public void decreaseMoneyCheck(Bill bill)
    {
        for (Money money:getCurrencies())
        {
            if (bill.getCost().getCurrency() == money.getCurrency())
            {
                money.setValue(money.getValue() - bill.getCost().getValue());
                if (money.getValue() == 0)
                {
                    getCurrencies().remove(money);
                }
                return;
            }
        }
    }
    public void decreaseMoneyCheck(BillsPack billsPack)
    {
        for (Money money:getCurrencies())
        {
            if (billsPack.getCost().getCurrency() == money.getCurrency())
            {
                money.setValue(money.getValue() - billsPack.getCost().getValue());
                if (money.getValue() == 0)
                {
                    getCurrencies().remove(money);
                }
                return;
            }
        }
    }

    public void insertIntoInventory(Item item)
    {
        item.setOwner(this);
        if (item.getType() == ItemType.BILL)
        {
            Bill bill = (Bill) item;
            increaseMoneyCheck(bill);
        }
        else if (item.getType() == ItemType.BILLS_PACK)
        {
            BillsPack billsPack = (BillsPack) item;
            increaseMoneyCheck(billsPack);
        }
        getInventory().add(item);
    }
    public int getAmount(Item item)
    {
        int qty = 0;
        for (Item tempItem:getInventory())
        {
            if (item.getDescription().equals(tempItem.getDescription()))
            {
                qty++;
            }
        }
        return qty;
    }
    /*public BillsPack getBillsPack(String currency, int cost)
    {
        int money = 0, costTemp = cost;
        for (Money currency1:getCurrencies())
        {
            if (currency1.getCurrency().equalsIgnoreCase(currency))
            {
                money = currency1.getValue();
            }
        }
        if (money >= costTemp)
        {
            BillsPack billsPack = new BillsPack();
            for (Item item:getInventory())
            {
                if (item instanceof Money)
                {
                    if (item.getCurrency().equalsIgnoreCase(currency) && item.getValue() <= costTemp)
                    {
                        billsPack.getBillsPack().add((Money) item);
                        costTemp -= item.getValue();
                        if (costTemp == 0)
                        {
                            for (Item item1:billsPack.getBillsPack())
                            {
                                getFromInventory(item1);
                            }
                            billsPack.setValue(cost);
                            billsPack.setOwner(this);
                            billsPack.setDescription(cost+" "+currency+" Bills Pack");
                            return billsPack;
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
    }*/
    /*public void makeBillsPack(String currency, int cost)
    {
        insertIntoInventory(getBillsPack(currency, cost));
    }*/
    public Item buy(String itemName, BillsPack billsPack, Player player)
    {
        Item item = player.getFromInventory(itemName);
        if (item == null)
        {
            System.out.println("Selected player doesnt have that item");
            return null;
        }
        if (billsPack.getCost().getValue() >= item.getCost().getValue())
        {
            give(billsPack, player);
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
    public void give(Item item, Player player)
    {
        player.insertIntoInventory(item);
    }
    public BillsPack sell(String itemName, int cost, Currency currency, Player player) //TODO
    {
        BillsPack billsPack = new BillsPack(currency);
        if (billsPack != null)
        {
            if (billsPack.getCost().getValue() >= cost)
            {
                Item item = getFromInventory(itemName);
                if (item != null)
                {
                    player.insertIntoInventory(item);
                    return billsPack;
                }
                else
                {
                    System.out.println("Another player doesnt have required item");
                    return null;
                }
            }
            else
            {
                System.out.println("Another player doesnt have such amount of money");
                return null;
            }
        }
        else
        {
            System.out.println("Another player doesnt have such amount of money");
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
            System.out.println("Another player doesnt have this item");
            return null;
        }
    }
    public Item getFromInventory(Item item)
    {
        if (!getInventory().isEmpty() && getInventory().contains(item))
        {
            getInventory().remove(item);
            if (item.getType() == ItemType.BILL)
            {
                Bill bill = (Bill) item;
                decreaseMoneyCheck(bill);
            }
            else if (item.getType() == ItemType.BILLS_PACK)
            {
                BillsPack billsPack = (BillsPack) item;
                decreaseMoneyCheck(billsPack);
            }
            return item;
        }
        return null;
    }
    public Item getFromInventory(int index)
    {
        if (!getInventory().isEmpty())
        {
            Item item = getInventory().remove(index);
            if (item.getType() == ItemType.BILL)
            {
                Bill bill = (Bill) item;
                decreaseMoneyCheck(bill);
            }
            else if (item.getType() == ItemType.BILLS_PACK)
            {
                BillsPack billsPack = (BillsPack) item;
                decreaseMoneyCheck(billsPack);
            }
            return item;
        }
        else
        {
            return null;
        }
    }
    public Item getFromInventory(String name)
    {
        if (!getInventory().isEmpty())
        {
            for (Item item:getInventory())
            {
                if (item.getDescription().equalsIgnoreCase(name))
                {
                    getInventory().remove(item);
                    if (item.getType() == ItemType.BILL)
                    {
                        Bill bill = (Bill) item;
                        decreaseMoneyCheck(bill);
                    }
                    else if (item.getType() == ItemType.BILLS_PACK)
                    {
                        BillsPack billsPack = (BillsPack) item;
                        decreaseMoneyCheck(billsPack);
                    }
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
    public List<Item> getInventory()
    {
        return inventory;
    }

    public List<Money> getCurrencies()
    {
        return currencies;
    }

    public List<Cloth> getClothes()
    {
        return clothes;
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