package item.tradeunit;

import item.money.MoneyUSD;
import item.types.impl.TradeUnit;

public class Silver extends TradeUnit
{
    public Silver()
    {
        super(new MoneyUSD(50), "Silver");
    }
}
