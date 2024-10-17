//package project_frontiers;

public class Species {

    private String name;
    private int ID;

    private Type type1;
    private Type type2;

    private Move[] moves;
    private Move[] unlockableMoves;

    private int baseHP;
    private int baseATK;
    private int baseDEF;
    private int baseSPA;
    private int baseSPD;
    private int baseSPE;

    /** Constructor */
    public Species(int _ID, String _name, Type _type1, Type _type2, int _baseHP, int _baseATK, int _baseDEF, int _baseSPA, int _baseSPD, int _baseSPE, Move[] _baseMoves, Move[] _bonusMoves) {
        this.ID = _ID;
        this.type1 = _type1;
        this.type2 = _type2;
        this.baseHP = _baseHP;
        this.baseATK = _baseATK;
        this.baseDEF = _baseDEF;
        this.baseSPA = _baseSPA;
        this.baseSPD = _baseSPD;
        this.baseSPE = _baseSPE;
        this.name = _name;

        // add moves
        this.moves = _baseMoves;
        this.unlockableMoves = _bonusMoves;
    } // constructor

    /** Accessor for types */
    public Type[] type() {
        return new Type[] {this.type1, this.type2};
    } // method type

    /** Accessor for specific type */
    public Type type(int x) {
        return this.type()[x%2];
    } // method type

    /** Accessor for base stats */
    public int[] baseStats() {
        return new int[] {this.baseHP, this.baseATK, this.baseDEF, this.baseSPA, this.baseSPD, this.baseSPE};
    } // method baseStats

    /** Accessor for specific base stat */
    public int baseStats(int x) {
        int result = -1;
        if (x >= 0 && x < 6) {
            result = this.baseStats()[x];
        }
        return result;
    } // method baseStats

    /** Accessor for name */
    public String name() {
        return this.name;
    } // method name

    /** Accessor for species ID */
    public int ID() {
        return this.ID;
    } // method ID

    /** Accessor for default species move list */
    public Move[] moves() {
        return this.moves;
    } // method moves

    /** Accessor for specific default species move */
    public Move moves(int x) {
        Move[] result = this.moves();
        return result[x%result.length];
    } // method moves

    /** Accessor for species unlockable moves */
    public Move[] unlockableMoves() {
        return this.unlockableMoves;
    } // method unlockableMoves

    /** Accessor for specific species unlockable move */
    public Move unlockableMoves(int x) {
        Move[] result = this.unlockableMoves();
        return result[x%result.length];
    } // method unlockableMoves
}