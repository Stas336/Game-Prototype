package game;

import com.diogonunes.jcdp.color.ColoredPrinter;
import com.diogonunes.jcdp.color.api.Ansi;
import input.ValueReader;
import item.types.Item;
import map.ItemsMap;
import player.Player;

public class Game
{
    private static int userInputInt = 0;
    private static String userInputStr;
    private static Player player1 = new Player();
    private static Player player2 = new Player();
    private static ItemsMap itemsMap = ItemsMap.newInstance();
    private static ColoredPrinter cp;
    public static void main(String[] args)
    {
        cp = new ColoredPrinter.Builder(1, false)
                .foreground(Ansi.FColor.WHITE).background(Ansi.BColor.BLUE)
                .build();
        player1.initialize();
        while(true)
        {
            System.out.println("1. Show items");
            System.out.println("2. Create item");
            System.out.println("3. Insert into inventory");
            System.out.println("4. Get from inventory");
            System.out.println("5. Show player info");
            System.out.println("6. Exit");
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
                    System.out.println("Enter item id");
                    userInputStr = ValueReader.readValue();
                    userInputInt = Integer.parseInt(userInputStr);
                    Item item = itemsMap.getItem(userInputInt);
                    System.out.println("Item id is " + item.toString());
                    System.out.println("Item cost is " + item.getCost());
                    System.out.println("Item description is " + item.getDescription());
                    break;
                case 3:
                    System.out.println("Enter item id");
                    userInputStr = ValueReader.readValue();
                    userInputInt = Integer.parseInt(userInputStr);
                    Item item1 = itemsMap.getItem(userInputInt);
                    player1.insertIntoInventory(item1);
                    i = 0;
                    leftAlignFormat = "| %-15s | %-4d |%n";
                    System.out.format("+-----------------+------+%n");
                    System.out.format("| Column name     | ID   |%n");
                    System.out.format("+-----------------+------+%n");
                    for (Item tempItem: player1.getAllItemTypes())
                    {
                            System.out.format(leftAlignFormat, tempItem.getDescription(), i++);
                            System.out.format("+-----------------+------+%n");
                    }
                    break;
                case 4:
                    System.out.println("Enter item id");
                    userInputStr = ValueReader.readValue();
                    userInputInt = Integer.parseInt(userInputStr);
                    Item tempItem = player1.getFromInventory(userInputInt);
                    System.out.println("Item acquired from inventory");
                    System.out.println(tempItem.getDescription());
                    System.out.println(tempItem.getCost());
                    break;
                case 5:
                    player1.showPlayerInfo();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }
}