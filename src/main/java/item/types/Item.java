package item.types;

import item.money.Money;
import player.Player;

public abstract class Item
{
    private Money cost;
    private String description;
    private Player owner;

    public Item(Money cost)
    {
        this(cost, "");
    }

    public Item(Money cost, String description)
    {
        setCost(cost);
        setDescription(description);
    }

    public Player getOwner()
    {
        return owner;
    }

    public void setOwner(Player player)
    {
        owner = player;
    }
    public String getDescription()
    {
        return description;
    }

    public void setDescription(String newDescription)
    {
        description = newDescription;
    }

    public Money getCost()
    {
        return cost;
    }

    public void setCost(Money newMoney)
    {
        cost = newMoney;
    }
    public abstract ItemType getType();
}