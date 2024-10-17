//package project_frontiers;

public class Pokemon {

    private String species;

    private String nickname;

    private StatSet statSet;
    private Moveset moveset;
    private Type type1;
    private Type type2;
    private double[] weak;
    
    /** Constructor */
    public Pokemon(Species _species) {
        this.species = _species.name();
        this.nickname = this.species;

        this.statSet = new StatSet(_species);
        this.moveset = new Moveset(_species);

        this.type1 = _species.type(0);
        this.type2 = _species.type(1);

        this.weak = new double[19];
        for (int i = 0; i < 19; i++) {
            this.weak[i] = this.type1.weak(i) * this.type2.weak(i);
        }
    } // constructor

    /** Accessor for stat set */
    public StatSet statSet() {
        return this.statSet;
    } // method statSet

    public Moveset moveset() {
        return this.moveset;
    } // method moveset

    /** Accessor for species name */
    public String speciesName() {
        return this.species;
    } // method speciesName

    /** Accessor for nickname */
    public String name() {
        return this.nickname;
    } // method name

    /** Accessor for both types */
    public Type[] type() {
        return new Type[] {this.type1, this.type2};
    } // method type

    /** Accessor for one type at a time */
    public Type type(int i) {
        return type()[i%2];
    } // method type

    /** Accessor for type defenses array */
    public double[] weak() {
        return this.weak;
    } // method weak

    /** Accessor for specific weakness by ID */
    public double weak(int i) {
        return this.weak()[i%19];
    } // method weak

    /** Accessor for specific weakness by type */
    public double weak(Type type) {
        return this.weak(type.ID());
    } // method weak
}