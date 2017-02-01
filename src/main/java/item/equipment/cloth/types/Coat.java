package item.equipment.cloth.types;

import item.equipment.cloth.Cloth;
import item.money.MoneyRUB;

public class Coat extends Cloth
{
    public Coat()
    {
        super(new MoneyRUB(500), "Coat");
    }
}
