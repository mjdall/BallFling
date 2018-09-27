package name.small.ballflinggame;

public class SoccerMumName {
    private String firstname;
    private String lastname;
    private String id;
    private int score;

    public SoccerMumName (String firstname, String lastname, String id) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.id = id;
        this.score = -1;
    }

    @Override
    public String toString () {
        return score == -1 ? firstname + " " + lastname : firstname + " " + lastname + " " + Integer.toString(score);
    }

    public String getId () {
        return id;
    }

    public Boolean compareId (String id) {
        return this.id.equals(id);
    }

    public int getScore () {
        return score;
    }

    public void setScore (int score) {
        this.score = score;
    }
}
