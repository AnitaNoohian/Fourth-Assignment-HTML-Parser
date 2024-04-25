public class Haki {
    private String name;
    private String year;
    private int wins;
    private int loses;

    public Haki(String name, String year, int wins, int loses) {
        //TODO
        this.name = name;
        this.year = year;
        this.wins = wins;
        this.loses = loses;
    }

    public String getName() {
        return name;
    }

    public String getYear() {
        return year;
    }

    public int getWins() {
        return wins;
    }

    public int getLoses() {
        return loses;
    }

    @Override
    public String toString() {
        //TODO
        return  "-Team name: " + getName() + " Year: " + getYear() + " Wins: " +
                getWins() + " Loses: " + getLoses() + "\n";
    }
}
