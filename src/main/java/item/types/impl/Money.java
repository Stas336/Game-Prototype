package item.types.impl;

import item.money.EUR;
import item.money.RUB;
import item.money.USD;
import item.types.Item;
import player.Player;

public abstract class Money implements Item
{
    private String description;
    private int cost;
    private Player owner;

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String newDescription) {
        this.description = newDescription;
    }

    public void setCost(Money newCost) {
        throw new UnsupportedOperationException();
    }
    public int getCost()
    {
        return this.cost;
    }
    public void setCost(int newCost)
    {
        this.cost = newCost;
    }
    public Player getOwner() {
        return this.owner;
    }
    public void setOwner(Player player) {
        this.owner = player;
    }
    public abstract int showInUSD();
    public abstract int showInEUR();
    public abstract int showInRUB();
    public abstract USD convertToUSD();
    public abstract EUR convertToEUR();
    public abstract RUB convertToRUB();
    public abstract String getCurrency();
}