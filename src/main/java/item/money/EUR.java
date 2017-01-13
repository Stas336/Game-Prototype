package item.money;

import item.types.impl.Money;

public class EUR extends Money
{
    private static final double EURToUSD = 1.0615;
    private static final double EURToRUB = 63.1214;

    public EUR(int cost)
    {
        setDescription(cost + " EUR");
        setCost(cost);
    }
    public int showInUSD()
    {
        return (int) (this.getCost() * EURToUSD);
    }

    public int showInEUR() {
        return this.getCost();
    }

    public int showInRUB()
    {
        return (int) (this.getCost() * EURToRUB);
    }
    public USD convertToUSD()
    {
        return new USD((int) (this.getCost() * EURToUSD));
    }

    public EUR convertToEUR() {
        return this;
    }

    public RUB convertToRUB()
    {
        return new RUB((int) (this.getCost() * EURToRUB));
    }
    public String getCurrency()
    {
        return "EUR";
    }
}
