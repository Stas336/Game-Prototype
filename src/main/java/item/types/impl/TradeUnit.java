package item.types.impl;

import item.money.Currency;
import item.money.Money;
import item.types.Item;
import item.types.ItemType;
import player.Player;

public class TradeUnit extends Item
{
    public TradeUnit(Money cost, String description)
    {
        super(cost, description);
    }

    @Override
    public ItemType getType() {
        return ItemType.TRADE_UNIT;
    }
}
