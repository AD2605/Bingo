import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.IntStream;

public class main {
    public static void main(String[] args) {
        ArrayList<Participants> participants = new ArrayList<Participants>();
        IntStream.range(0, 10).parallel().forEach(i -> {
            participants.add(new Participants(Integer.toString(i)));
        });
        Participants Moderator = new Participants("Moderator");

        for (Integer number : Moderator.numbers) {
            participants.parallelStream().forEach(participant -> {
                if (participant.numbers.contains(number))
                {
                    if (participant.bingos == 3)
                    {
                        System.out.println("THE WINNER IS");
                        System.out.println(participant.id);
                        participant.finishGame();
                    }
                    participant.bingos += 1;

                }
            });
        }
    }
}
