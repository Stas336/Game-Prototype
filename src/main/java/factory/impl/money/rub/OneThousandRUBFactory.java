package factory.impl.money.rub;

import factory.Factory;
import item.money.RUB;

public class OneThousandRUBFactory implements Factory<RUB>
{
    public RUB newItem()
    {
        return new RUB(1000);
    }
}