package factory.impl.money.usd;

import factory.Factory;
import item.money.MoneyUSD;
import item.types.impl.Bill;

public class FiftyUSDFactory implements Factory<Bill>
{
    public Bill newItem()
    {
        return new Bill(new MoneyUSD(50));
    }
}
