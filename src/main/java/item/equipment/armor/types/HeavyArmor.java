package item.equipment.armor.types;

import item.equipment.armor.Armor;
import item.money.MoneyRUB;

public class HeavyArmor extends Armor
{
    public HeavyArmor()
    {
        super(new MoneyRUB(2500), "Heavy Armor");
        getOwner().setArmor(100);
    }
}
