package item.map;

import factory.impl.money.usd.*;
import factory.impl.money.eur.*;
import factory.impl.money.rub.*;
import factory.impl.tradeunit.GoldFactory;
import factory.impl.tradeunit.SilverFactory;
import item.types.Item;
import factory.Factory;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class ItemsMap
{
    private Map<String, Factory<? extends Item>> map = new HashMap<String, Factory<? extends Item>>();
    private ItemsMap()
    {
        map.put("1 USD", new OneUSDFactory());
        map.put("2 USD", new TwoUSDFactory());
        map.put("5 USD", new FiveUSDFactory());
        map.put("10 USD", new TenUSDFactory());
        map.put("20 USD", new TwentyUSDFactory());
        map.put("50 USD", new FiftyUSDFactory());
        map.put("100 USD", new OneHundredUSDFactory());
        map.put("5 EUR", new FiveEURFactory());
        map.put("10 EUR", new TenEURFactory());
        map.put("20 EUR", new TwentyEURFactory());
        map.put("50 EUR", new FiftyEURFactory());
        map.put("100 EUR", new OneHundredEURFactory());
        map.put("200 EUR", new TwoHundredsEURFactory());
        map.put("500 EUR", new FiveHundredsEURFactory());
        map.put("5 RUB", new FiveRUBFactory());
        map.put("10 RUB", new TenRUBFactory());
        map.put("50 RUB", new FiftyRUBFactory());
        map.put("100 RUB", new OneHundredRUBFactory());
        map.put("500 RUB", new FiveHundredsRUBFactory());
        map.put("1000 RUB", new OneThousandRUBFactory());
        map.put("5000 RUB", new FiveThousandsRUBFactory());
        map.put("Gold", new GoldFactory());
        map.put("Silver", new SilverFactory());
    }
    public static ItemsMap newInstance()
    {
        return new ItemsMap();
    }
    public Item getItem(String itemType)
    {
        Factory<? extends Item> factory = map.get(itemType);
        if (factory == null)
        {
            return null;
        }
        else
        {
            return factory.newItem();
        }
    }
    public Item getItem(int position)
    {
        for(Map.Entry<String, Factory<? extends Item>> entry : map.entrySet())
        {
            if (position-- == 0)
            {
                Factory factory=entry.getValue();
                if (factory == null)
                {
                    return null;
                }
                else
                {
                    return factory.newItem();
                }
            }
        }
        return null;
    }
    public Set<String> getAllItemTypes()
    {
        return map.keySet();
    }
    public int getAllItemTypesAmount()
    {
        return map.size();
    }
}