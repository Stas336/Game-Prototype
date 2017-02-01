package item.types.impl;

import item.money.Currency;
import item.money.Money;
import item.types.ItemType;

import java.util.*;

public class BillsPack extends Bill
{
    private List<Bill> bills = new ArrayList<>();
    private Currency currency;

    public BillsPack(Currency currency)
    {
        super(Money.newMoney(currency));
        this.currency = currency;
        setDescription("0 " +currency+" Bills Pack");
    }

    @Override
    public void setCost(Money newCost) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Money getCost()
    {
        return Money.newMoney(getCurrency(), bills.stream().mapToInt(b -> b.getCost().getValue()).sum());
    }

    @Override
    public ItemType getType() {
        return ItemType.BILLS_PACK;
    }

    public Currency getCurrency()
    {
        return currency;
    }

    public List<Bill> getBillsUnmodifiable()
    {
        return Collections.unmodifiableList(bills);
    }

    public void insertBill(Bill bill)
    {
        if (bill.getCost().getCurrency() == getCurrency())
        {
            if (!bills.contains(bill))
            {
                bills.add(bill);
                setCost(Money.newMoney(getCurrency(), getCost().getValue()+bill.getCost().getValue()));
                setDescription(getCost().getValue()+" "+getCurrency()+" Bills Pack");
            }
            else
            {
                System.out.println("CHEATER");
            }
        }
        else
        {
            System.out.println("Insert "+getCurrency()+" bill, not "+bill.getCost().getCurrency());
        }
    }
    public Bill retrieveBill(String billName)
    {
        if (!bills.isEmpty())
        {
            for (Bill bill:bills)
            {
                if (bill.getDescription().equalsIgnoreCase(billName))
                {
                    bills.remove(bill);
                    setCost(Money.newMoney(getCurrency(), getCost().getValue()-bill.getCost().getValue()));
                    if (getCost().getValue() == 0)
                    {
                        setDescription("Empty Bills Pack");
                    }
                    else
                    {
                        setDescription(getCost().getValue()+" "+getCurrency()+" Bills Pack");
                    }
                    return bill;
                }
            }
            System.out.println("There are no bill that you require in that bills pack");
            return null;
        }
        else
        {
            System.out.println("Bills pack is empty");
            return null;
        }
    }
    public Map<Bill, Integer> getAllBillsTypes()
    {
        if (!bills.isEmpty())
        {
            ArrayList<Bill> types = new ArrayList<>();
            int[] typesAmount = new int[bills.size()];
            Boolean check = true;
            for (Bill bill:bills)
            {
                if (types.isEmpty())
                {
                    types.add(bill);
                    typesAmount[types.indexOf(bill)] = 1;
                }
                else
                {
                    for (Bill billTypes:types)
                    {
                        if (bill.getDescription().equals(billTypes.getDescription()))
                        {
                            typesAmount[types.indexOf(billTypes)]++;
                            check = false;
                        }
                    }
                    if (check)
                    {
                        types.add(bill);
                        typesAmount[types.indexOf(bill)] = 1;
                    }
                    check = true;
                }
            }
            Map<Bill, Integer> map = new HashMap<>();
            for (Bill billTypes:types)
            {
                map.put(billTypes, typesAmount[types.indexOf(billTypes)]);
            }
            return map;
        }
        else
        {
            System.out.println("Bills pack is empty");
            return null;
        }
    }
}