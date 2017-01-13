package factory.impl.money.usd;

import factory.Factory;
import item.money.USD;

public class FiveUSDFactory implements Factory<USD>
{
    public USD newItem()
    {
        return new USD(5);
    }
}
