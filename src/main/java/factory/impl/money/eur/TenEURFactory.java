package factory.impl.money.eur;

import factory.Factory;
import item.money.MoneyEUR;
import item.types.impl.Bill;

public class TenEURFactory implements Factory<Bill>
{
    public Bill newItem()
    {
        return new Bill(new MoneyEUR(10));
    }
}
