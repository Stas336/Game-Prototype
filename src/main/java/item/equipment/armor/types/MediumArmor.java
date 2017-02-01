package item.equipment.armor.types;

import item.equipment.armor.Armor;
import item.money.MoneyRUB;

public class MediumArmor extends Armor
{
    public MediumArmor()
    {
        super(new MoneyRUB(1500), "Heavy Armor");
        getOwner().setArmor(100);
    }
}
