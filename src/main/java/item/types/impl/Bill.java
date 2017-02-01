package item.types.impl;

import item.money.Money;
import item.types.Item;
import item.types.ItemType;

public class Bill extends Item
{
    public Bill(Money money)
    {
        super(money, money.getValue() + " " + money.getCurrency().toString() +" Bill");
    }

    @Override
    public ItemType getType()
    {
        return ItemType.BILL;
    }
}