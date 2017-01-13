package factory.impl.tradeunit;

import item.tradeunit.Gold;
import factory.Factory;

public class GoldFactory implements Factory<Gold>
{
    public Gold newItem()
        {
            return new Gold();
        }
}
