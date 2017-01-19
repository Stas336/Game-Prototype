package item.types.impl;

import item.types.Item;

import java.util.ArrayList;

public class Cloth extends Equipment
{
    private ArrayList<Item> inventory;

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public Item getItemFromInventory()
    {
        throw new UnsupportedOperationException();
    }
}
