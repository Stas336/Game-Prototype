package game;

import com.diogonunes.jcdp.color.ColoredPrinter;
import com.diogonunes.jcdp.color.api.Ansi;
import game.input.ValueReader;
import game.output.ConsoleCleaner;
import item.money.Currency;
import item.types.Item;
import item.map.ItemsMap;
import item.types.impl.Bill;
import item.types.impl.BillsPack;
import item.money.Money;
import player.Player;
import player.npc.Trader;

import java.util.ArrayList;

public class Game
{
    private static int userInputInt = 0;
    private static String userInputStr;
    private static ArrayList<Player> players = new ArrayList<Player>();
    private static final int MAIN_PLAYER = 0;
    private static ItemsMap itemsMap = ItemsMap.newInstance();
    private static ColoredPrinter cp;
    public static void main(String[] args)
    {
        cp = new ColoredPrinter.Builder(1, false)
                .foreground(Ansi.FColor.WHITE).background(Ansi.BColor.BLUE)
                .build();
        addPlayer();
        while(true)
        {
            System.out.println("1. Show items");
            System.out.println("2. Create item");
            System.out.println("3. Insert into inventory");
            System.out.println("4. Get from inventory");
            System.out.println("5. Show player info");
            System.out.println("6. Show trader");
            System.out.println("7. Get pack of money");
            System.out.println("8. Exit");
            //cp.print("MADE ", Ansi.Attribute.NONE, Ansi.FColor.YELLOW, Ansi.BColor.GREEN);
            userInputStr = ValueReader.readValue();
            if (userInputStr == null)
            {
                throw new NullPointerException();
            }
            userInputInt = Integer.parseInt(userInputStr);
            switch (userInputInt)
            {
                case 1:
                    ConsoleCleaner.clear();
                    int i = 0;
                    String leftAlignFormat = "| %-15s | %-4d |%n";
                    System.out.format("+-----------------+------+%n");
                    System.out.format("| Column name     | ID   |%n");
                    System.out.format("+-----------------+------+%n");
                    for (String string: itemsMap.getAllItemTypes())
                    {
                        System.out.format(leftAlignFormat, string, i++);
                        System.out.format("+-----------------+------+%n");
                    }
                    //System.out.println(itemsMap.getAllItemTypes().toArray());
                    break;
                case 2:
                    ConsoleCleaner.clear();
                    System.out.println("Enter item id");
                    userInputStr = ValueReader.readValue();
                    userInputInt = Integer.parseInt(userInputStr);
                    Item item = itemsMap.getItem(userInputInt);
                    System.out.println("Item id is " + item.toString());
                    System.out.println("Item cost is " + item.getCost());
                    System.out.println("Item description is " + item.getDescription());
                    break;
                case 3:
                    ConsoleCleaner.clear();
                    System.out.println("Enter item id");
                    userInputStr = ValueReader.readValue();
                    userInputInt = Integer.parseInt(userInputStr);
                    Item item1 = itemsMap.getItem(userInputInt);
                    players.get(MAIN_PLAYER).insertIntoInventory(item1);
                    i = 0;
                    leftAlignFormat = "| %-15s | %-4d |%n";
                    System.out.format("+-----------------+------+%n");
                    System.out.format("| Column name     | ID   |%n");
                    System.out.format("+-----------------+------+%n");
                    for (Item tempItem: players.get(MAIN_PLAYER).getInventory())
                    {
                            System.out.format(leftAlignFormat, tempItem.getDescription(), i++);
                            System.out.format("+-----------------+------+%n");
                    }
                    break;
                case 4:
                    ConsoleCleaner.clear();
                    System.out.println("Enter item id");
                    userInputStr = ValueReader.readValue();
                    userInputInt = Integer.parseInt(userInputStr);
                    Item tempItem = players.get(MAIN_PLAYER).getFromInventory(userInputInt);
                    System.out.println("Item acquired from inventory");
                    System.out.println(tempItem.getDescription());
                    System.out.println(tempItem.getCost());
                    break;
                case 5:
                    ConsoleCleaner.clear();
                    players.get(MAIN_PLAYER).showPlayerInfo();
                    break;
                case 6:
                    ConsoleCleaner.clear();
                    addTrader();
                    System.out.println("Trader");
                    if (players.get(1) instanceof Trader)
                    {
                        ((Trader) players.get(1)).updateMarketplace(itemsMap, 1, 100);
                        ((Trader) players.get(1)).showItems();
                        ((Trader) players.get(1)).showAvailableMoney();
                    }
                    break;
                case 7: //TODO
                    ConsoleCleaner.clear();
                    System.out.println("Enter amount of money for your pack");
                    userInputStr = ValueReader.readValue();
                    int amount = Integer.parseInt(userInputStr);
                    System.out.println("Enter currency for your pack");
                    userInputStr = ValueReader.readValue();
                    BillsPack billsPack = new BillsPack(Currency.valueOf(userInputStr));
                    if (billsPack != null)
                    {
                        System.out.println("Pack of money contains:");
                        for (Bill bill:billsPack.getBillsUnmodifiable())
                        {
                            System.out.println(bill.getDescription());
                        }
                    }
                    break;
                case 8:
                    ConsoleCleaner.clear();
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    ConsoleCleaner.clear();
                    System.out.println("Enter right variant");
                    break;
            }
        }
    }
    public static void addPlayer()
    {
        Player player = new Player();
        players.add(player);
    }
    public static void addTrader()
    {
        Trader trader = new Trader();
        players.add(trader);
    }
}