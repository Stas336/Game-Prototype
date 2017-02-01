package item.equipment.armor;

import item.money.Money;
import item.types.impl.Equipment;

public abstract class Armor extends Equipment
{
    public Armor(Money cost, String description)
    {
        super(cost, description);
    }
}
