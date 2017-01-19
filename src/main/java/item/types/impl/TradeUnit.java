package item.types.impl;

import item.types.Item;
import player.Player;

public class TradeUnit implements Item
{
    private String description;
    private Money cost;
    private Player owner;

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String newDescription) {
        this.description = newDescription;
    }

    public int getCost() {
        return this.cost.getCost();
    }

    public void setCost(Money newCost) {
        this.cost = newCost;
    }

    public String getCurrency()
    {
        return cost.getCurrency();
    }

    public Player getOwner() {
        return this.owner;
    }

    public void setOwner(Player player) {
        this.owner = player;
    }
}
