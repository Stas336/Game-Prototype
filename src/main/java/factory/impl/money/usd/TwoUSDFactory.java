package factory.impl.money.usd;

import factory.Factory;
import item.money.USD;

public class TwoUSDFactory implements Factory<USD>
{
    public USD newItem()
    {
        return new USD(2);
    }
}
