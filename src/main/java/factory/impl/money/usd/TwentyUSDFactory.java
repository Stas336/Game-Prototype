package factory.impl.money.usd;

import factory.Factory;
import item.money.USD;

public class TwentyUSDFactory implements Factory<USD>
{
    public USD newItem()
    {
        return new USD(20);
    }
}