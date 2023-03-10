package generics;

public class User implements Userable {
    private int points;

    public User(int points) {
        this.points = points;
    }



    @Override
    public String toString() {
        return "Points=" + points;
    }
}
