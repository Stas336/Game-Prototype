package factory.impl.tradeunit;

import item.tradeunit.Silver;
import factory.Factory;

public class SilverFactory implements Factory<Silver>
{
    public Silver newItem()
    {
        return new Silver();
    }
}
