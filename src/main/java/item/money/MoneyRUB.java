package item.money;

public class MoneyRUB extends Money
{
    private static final double RUBToEUR = 0.01584;
    private static final double RUBToUSD = 0.01682;

    public MoneyRUB(int cost)
    {
        setDescription(cost + " RUB Bill");
        setValue(cost);
    }

    public int showInRUB() {
        return this.getValue();
    }

    public int showInEUR()
    {
        return (int) (this.getValue() * RUBToEUR);
    }
    public int showInUSD()
    {
        return (int) (this.getValue() * RUBToUSD);
    }
    public MoneyUSD convertToUSD()
    {
        return new MoneyUSD( ((int) (this.getValue() * RUBToUSD)));
    }
    public MoneyEUR convertToEUR()
    {
        return new MoneyEUR((int) (this.getValue() * RUBToEUR));
    }

    public MoneyRUB convertToRUB() {
        return this;
    }

    public Currency getCurrency()
    {
        return Currency.RUB;
    }
}
