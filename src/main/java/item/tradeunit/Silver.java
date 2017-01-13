package item.tradeunit;

import item.money.USD;
import item.types.impl.TradeUnit;

public class Silver extends TradeUnit
{
    public Silver()
    {
        setDescription("Silver");
        setCost(new USD(50));
    }
}
