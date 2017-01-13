package item.money;

import item.types.impl.Money;

public class RUB extends Money
{
    private static final double RUBToEUR = 0.01584;
    private static final double RUBToUSD = 0.01682;

    public RUB(int cost)
    {
        setDescription(cost + " RUB");
        setCost(cost);
    }

    public int showInRUB() {
        return this.getCost();
    }

    public int showInEUR()
    {
        return (int) (this.getCost() * RUBToEUR);
    }
    public int showInUSD()
    {
        return (int) (this.getCost() * RUBToUSD);
    }
    public USD convertToUSD()
    {
        return new USD( ((int) (this.getCost() * RUBToUSD)));
    }
    public EUR convertToEUR()
    {
        return new EUR((int) (this.getCost() * RUBToEUR));
    }

    public RUB convertToRUB() {
        return this;
    }

    public String getCurrency()
    {
        return "RUB";
    }
}
