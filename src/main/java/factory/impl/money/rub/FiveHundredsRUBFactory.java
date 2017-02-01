package factory.impl.money.rub;

import factory.Factory;
import item.money.MoneyRUB;
import item.types.impl.Bill;

public class FiveHundredsRUBFactory implements Factory<Bill>
{
    public Bill newItem()
    {
        return new Bill(new MoneyRUB(500));
    }
}