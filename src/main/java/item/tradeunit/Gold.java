package item.tradeunit;

import item.money.USD;
import item.types.impl.TradeUnit;

public class Gold extends TradeUnit
{
    public Gold()
    {
        setDescription("Gold");
        setCost(new USD(100));
    }
}
