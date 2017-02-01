package item.equipment.cloth;

import item.money.Money;
import item.types.Item;
import item.types.impl.Equipment;

import java.util.ArrayList;

public class Cloth extends Equipment
{
    private ArrayList<Item> inventory;

    public Cloth(Money cost, String description)
    {
        super(cost, description);
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public Item getFromInventory(int index)
    {
        if (!getInventory().isEmpty())
        {
            return getInventory().remove(index);
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
}
