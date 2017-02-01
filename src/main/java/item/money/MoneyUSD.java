package item.money;

public class MoneyUSD extends Money
{
    private static final double USDToEUR = 0.942;
    private static final int USDToRUB = 60;

    public MoneyUSD(int cost)
    {
        setDescription(cost + " USD Bill");
        setValue(cost);
    }

    public int showInUSD()
    {
        return this.getValue();
    }
    public int showInEUR()
    {
        return (int) (this.getValue() * USDToEUR);
    }
    public int showInRUB()
    {
        return this.getValue() * USDToRUB;
    }

    public MoneyUSD convertToUSD()
    {
        return this;
    }

    public MoneyEUR convertToEUR()
    {
        return new MoneyEUR((int) (this.getValue() * USDToEUR));
    }
    public MoneyRUB convertToRUB()
    {
        return new MoneyRUB(this.getValue() * USDToRUB);
    }
    public Currency getCurrency()
    {
        return Currency.USD;
    }
}
