package item.money;

import player.Player;

public abstract class Money
{
    private String description;
    private int value;
    private Player owner;

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String newDescription) {
        this.description = newDescription;
    }

    public static Money newMoney(Currency currency)
    {
        switch (currency)
        {
            case RUB:
                return new MoneyRUB(0);
            case USD:
                return new MoneyUSD(0);
            case EUR:
                return new MoneyEUR(0);
        }
        return null;
    }

    public static Money newMoney(Currency currency, int value)
    {
        switch (currency)
        {
            case RUB:
                return new MoneyRUB(value);
            case USD:
                return new MoneyUSD(value);
            case EUR:
                return new MoneyEUR(value);
        }
        return null;
    }

    public int getValue()
    {
        return this.value;
    }
    public void setValue(int newValue)
    {
        this.value = newValue;
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
    public abstract MoneyUSD convertToUSD();
    public abstract MoneyEUR convertToEUR();
    public abstract MoneyRUB convertToRUB();
    public abstract Currency getCurrency();
}