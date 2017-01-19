package player.npc;

import item.map.ItemsMap;
import item.types.Item;
import item.types.impl.Money;
import player.Player;
import random.Generator;

import java.util.HashMap;
import java.util.Map;

public class Trader extends Player
{
    public void updateMarketplace(ItemsMap map)
    {
        int amount = Generator.nextInt(1, 100);
        for (int i = 0;i < amount;i++)
        {
            insertIntoInventory(map.getItem(Generator.nextInt(0, map.getAllItemTypesAmount())));
        }
    }
    public void showItems()
    {
        Boolean itemsCheck = false;
        HashMap<Item, Integer> map = getAllItemTypes();
        for (Map.Entry<Item, Integer> cursor:map.entrySet())
        {
            if (!(cursor.getKey() instanceof Money))
            {
                itemsCheck = true;
                break;
            }
        }
        if (map.isEmpty() || !itemsCheck)
        {
            System.out.println("I dont have any items for trade");
        }
        else
        {
            System.out.println("I have this items for trade:");
            for (Map.Entry<Item, Integer> cursor:map.entrySet())
            {
                if (!(cursor.getKey() instanceof Money))
                {
                    System.out.print(cursor.getKey().getDescription()+" X"+cursor.getValue()+" ");
                    System.out.println(cursor.getKey().getCost()+" "+cursor.getKey().getCurrency());
                }
            }
        }
    }
    public void showAvailableMoney()
    {
        System.out.printf("I have %d RUB, %d USD and %d EUR right now\n", getMoneyRUB(), getMoneyUSD(), getMoneyEUR());
    }
}
