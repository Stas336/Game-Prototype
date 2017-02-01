package item.tradeunit;

import item.money.MoneyUSD;
import item.types.impl.TradeUnit;

public class Gold extends TradeUnit
{
    public Gold()
    {
        super(new MoneyUSD(100), "Gold");
    }
}
