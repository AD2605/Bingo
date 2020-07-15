import java.util.*;
import java.util.Random;
import java.util.stream.IntStream;

public class Participants {
    String id;
    ArrayList<Integer> numbers = new ArrayList<Integer>();
    Integer bingos = 0;

    Participants(String id)
    {
        this.id = id;
        Random rand = new Random();
        IntStream.range(0, 10).parallel().forEach(i -> {
            while (true)
            {
                Integer integer = rand.nextInt(50);
                if (!numbers.contains(integer))
                {
                    numbers.add(integer);
                    break;
                }
            }
        });
    }
    void finishGame()
    {
        System.exit(1);
    }
}
