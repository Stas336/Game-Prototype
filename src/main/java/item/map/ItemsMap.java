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
        map.put("1 MoneyUSD", new OneUSDFactory());
        map.put("2 MoneyUSD", new TwoUSDFactory());
        map.put("5 MoneyUSD", new FiveUSDFactory());
        map.put("10 MoneyUSD", new TenUSDFactory());
        map.put("20 MoneyUSD", new TwentyUSDFactory());
        map.put("50 MoneyUSD", new FiftyUSDFactory());
        map.put("100 MoneyUSD", new OneHundredUSDFactory());
        map.put("5 MoneyEUR", new FiveEURFactory());
        map.put("10 MoneyEUR", new TenEURFactory());
        map.put("20 MoneyEUR", new TwentyEURFactory());
        map.put("50 MoneyEUR", new FiftyEURFactory());
        map.put("100 MoneyEUR", new OneHundredEURFactory());
        map.put("200 MoneyEUR", new TwoHundredsEURFactory());
        map.put("500 MoneyEUR", new FiveHundredsEURFactory());
        map.put("5 MoneyRUB", new FiveRUBFactory());
        map.put("10 MoneyRUB", new TenRUBFactory());
        map.put("50 MoneyRUB", new FiftyRUBFactory());
        map.put("100 MoneyRUB", new OneHundredRUBFactory());
        map.put("500 MoneyRUB", new FiveHundredsRUBFactory());
        map.put("1000 MoneyRUB", new OneThousandRUBFactory());
        map.put("5000 MoneyRUB", new FiveThousandsRUBFactory());
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