package name.small.ballflinggame;

import java.util.ArrayList;
import java.util.Random;

public class SoccerMumNameGeneratorGoodnessXD {
    private String[] firstnames;
    private String[] lastnames;
    private Random rand;

    public SoccerMumNameGeneratorGoodnessXD () {
        firstnames = new String[]{ "Carol", "Linda", "Wendy", "Amelia", "Mary", "Jenny", "Jessica",
                "Lisa", "Susan", "Hannah", "Holly", "Shelly", "Barbara", "Gloria", "Lynn", "Leah", "Tracy", "Trish",
                "Chelsie", "Danny(iel)", "Morgan", "Jenna", "Audrey", "Jodi", "Laura", "Christina", "Donna"};
        lastnames  = new String[]{ "Jones", "Jefferies", "Alberts", "Parker", "Simmons", "Stokes", "Dally",
                "Blair", "Allen", "Carter", "Robinson", "Sanders", "Joyce", "Wakeman", "Smith", "Simmons", "Gonzalez",
                "Turner", "Lopez", "Hernandez", "Craig", "Rogers", "Peterson", "Iverson", "Charles", "Wilkins", "Gillies"};
    }

    // gens a new name
    public SoccerMumName getName (ArrayList<SoccerMumName> currentHighscores) {
        SoccerMumName new_name = genName();
        for (int i = 0; i < currentHighscores.size(); i++)
            if (new_name.compareId(currentHighscores.get(i).getId())) {
                new_name = genName();
                i = 0;
            }
        return new_name;
    }

    private SoccerMumName genName () {
        rand = new Random();
        int index1 = rand.nextInt(28);
        rand = new Random();
        int index2 = rand.nextInt(28);
        return new SoccerMumName(firstnames[index1], lastnames[index2], String.format("%03d%03d", index1, index2));
    }
}
