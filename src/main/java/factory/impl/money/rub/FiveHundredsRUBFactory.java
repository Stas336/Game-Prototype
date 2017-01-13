package factory.impl.money.rub;

import factory.Factory;
import item.money.RUB;

public class FiveHundredsRUBFactory implements Factory<RUB>
{
    public RUB newItem()
    {
        return new RUB(500);
    }
}