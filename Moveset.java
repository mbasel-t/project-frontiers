//package project_frontiers;
import java.util.ArrayList;

public class Moveset {

    private ArrayList<Move> moves = new ArrayList<Move>(4);
    private ArrayList<Move> moves_unlocked = new ArrayList<Move>();
    // private ArrayList<Move> moves_unlockable = new ArrayList<Move>();

    public Moveset(Species species) {
        for (Move move : species.moves()) {
            if (!this.moves.contains(move)) {
                this.moves.add(move);
                this.moves_unlocked.add(move);
            }
        }
    }
    
    public Move move(int x) {
        return moves.get(x%moves.size());
    }

    public Move[] move() {
        return new Move[] { this.move(0), this.move(1), this.move(2), this.move(3) };
    }

    public String[] moveNames() {
        return new String[] { this.move(0).name(), this.move(1).name(), this.move(2).name(), this.move(3).name() };
    }
}