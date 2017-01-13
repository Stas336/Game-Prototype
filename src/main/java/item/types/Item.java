package item.types;

import item.types.impl.Money;
import player.Player;

public interface Item
{
    String getDescription();
    void setDescription(String newDescription);
    int getCost();
    void setCost(Money newCost);
    Player getOwner();
    void setOwner(Player player);
}