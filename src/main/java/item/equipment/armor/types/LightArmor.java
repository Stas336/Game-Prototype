package item.equipment.armor.types;

import item.equipment.armor.Armor;
import item.money.MoneyRUB;

public class LightArmor extends Armor {

    public LightArmor()
    {
        super(new MoneyRUB(1000), "Heavy Armor");
        getOwner().setArmor(100);
    }
}