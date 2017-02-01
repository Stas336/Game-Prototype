package item.money;

public class MoneyEUR extends Money
{
    private static final double EURToUSD = 1.0615;
    private static final double EURToRUB = 63.1214;

    public MoneyEUR(int cost)
    {
        setDescription(cost + " EUR Bill");
        setValue(cost);
    }
    public int showInUSD()
    {
        return (int) (this.getValue() * EURToUSD);
    }

    public int showInEUR() {
        return this.getValue();
    }

    public int showInRUB()
    {
        return (int) (this.getValue() * EURToRUB);
    }
    public MoneyUSD convertToUSD()
    {
        return new MoneyUSD((int) (this.getValue() * EURToUSD));
    }

    public MoneyEUR convertToEUR() {
        return this;
    }

    public MoneyRUB convertToRUB()
    {
        return new MoneyRUB((int) (this.getValue() * EURToRUB));
    }
    public Currency getCurrency()
    {
        return Currency.EUR;
    }
}
