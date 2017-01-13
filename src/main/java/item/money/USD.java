package item.money;

import item.types.impl.Money;

public class USD extends Money
{
    private static final double USDToEUR = 0.942;
    private static final int USDToRUB = 60;

    public USD(int cost)
    {
        setDescription(cost + " USD");
        setCost(cost);
    }

    public int showInUSD()
    {
        return this.getCost();
    }
    public int showInEUR()
    {
        return (int) (this.getCost() * USDToEUR);
    }
    public int showInRUB()
    {
        return this.getCost() * USDToRUB;
    }

    public USD convertToUSD()
    {
        return this;
    }

    public EUR convertToEUR()
    {
        return new EUR((int) (this.getCost() * USDToEUR));
    }
    public RUB convertToRUB()
    {
        return new RUB(this.getCost() * USDToRUB);
    }
    public String getCurrency()
    {
        return "USD";
    }
}
