package factory.impl.money.rub;

import factory.Factory;
import item.money.RUB;

public class FiftyRUBFactory implements Factory<RUB>
{
    public RUB newItem()
    {
        return new RUB(50);
    }
}