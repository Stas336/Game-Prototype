package factory.impl.money.eur;

import factory.Factory;
import item.money.EUR;

public class TwentyEURFactory implements Factory<EUR>
{
    public EUR newItem()
    {
        return new EUR(20);
    }
}
