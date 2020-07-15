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
                    participant.numbers.remove(Integer.valueOf(number));

                }
            });
        }
        //If no one gets bingos  = 3, the participant with highest bingo wins.
        Integer bingos  = 0;
        String highest = "someone";
        for(Participants participant : participants)
        {
            if (participant.bingos>bingos)
            {
                highest = participant.id;
                bingos = participant.bingos;
            }
        }
        System.out.println("NO ONE GOT 3 BINGOS, HIGHEST BINGOS IS ACHIEVED BY - ");
        System.out.println(highest);
        System.out.println(bingos);
    }
}
