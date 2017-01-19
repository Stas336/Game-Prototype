package random;

import java.util.Random;

public class Generator
{
    private static Random random;

    private static void randomizeSeed()
    {
        Random randomSeed = new Random();
        random.setSeed(randomSeed.nextLong());
    }
    public static int nextInt()
    {
        random = new Random();
        randomizeSeed();
        return random.nextInt();
    }
    public static int nextInt(int lowerBound, int higherBound)
    {
        random = new Random();
        randomizeSeed();
        return random.nextInt(higherBound-lowerBound) + lowerBound;
    }
}
