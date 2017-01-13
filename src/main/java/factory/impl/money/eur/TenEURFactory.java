package factory.impl.money.eur;

import factory.Factory;
import item.money.EUR;

public class TenEURFactory implements Factory<EUR>
{
    public EUR newItem()
    {
        return new EUR(10);
    }
}
