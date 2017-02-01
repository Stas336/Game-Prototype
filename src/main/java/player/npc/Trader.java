package player.npc;

import item.map.ItemsMap;
import item.types.Item;
import item.money.Money;
import item.types.ItemType;
import player.Player;
import random.Generator;

import java.util.HashMap;
import java.util.Map;

public class Trader extends Player
{
    public void updateMarketplace(ItemsMap map, int minRequiredItems, int maxRequiredItems)
    {
        if (minRequiredItems <= 0 || minRequiredItems > maxRequiredItems)
        {
            System.out.println("Enter right parameters");
            return;
        }
        int amount = Generator.nextInt(minRequiredItems, maxRequiredItems);
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
            if (!(cursor.getKey().getType() == ItemType.BILL))
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
                if (!(cursor.getKey().getType() == ItemType.BILL))
                {
                    System.out.print(cursor.getKey().getDescription()+" X"+cursor.getValue()+" ");
                    System.out.println(cursor.getKey().getCost()+" "+cursor.getKey().getCost().getCurrency());
                }
            }
        }
    }
    public void showAvailableMoney()
    {
        if (!getCurrencies().isEmpty())
        {
            for (Money money:getCurrencies())
            {
                System.out.printf("I have %d %s right now\n", money.getValue(), money.getCurrency());
            }
        }
        else
        {
            System.out.println("I dont have money at all right now");
        }
    }
}
