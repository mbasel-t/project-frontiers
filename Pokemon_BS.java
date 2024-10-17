//package project_frontiers;

public class Pokemon_BS {

    private String name;
    private String speciesName;

    private Type type1;
    private Type type2;
    private double[] weak;

    private int HP_max;
    private int HP_current;

    private StatSet statSet;
    private Moveset moveset;

    /** Constructor */
    public Pokemon_BS(Pokemon pokemon) {
        this.speciesName = pokemon.speciesName();
        this.name = pokemon.name();

        this.type1 = pokemon.type(0);
        this.type2 = pokemon.type(1);
        this.weak = pokemon.weak();

        this.statSet = pokemon.statSet();
        this.moveset = pokemon.moveset();

        this.HP_max = pokemon.statSet().stat(0);
        this.HP_current = this.HP_max;
    } // constructor

    /** Current HP accessor */
    public int HP_current() {
        return this.HP_current;
    } // current HP accessor

    /** max HP accessor */
    public int HP_max() {
        return this.HP_max;
    } // max HP accessor

    /** Stat set accessor */
    public StatSet statSet() {
        return this.statSet;
    } // method statSet

    /** Moveset accessor */
    public Moveset moveset() {
        return this.moveset;
    }

    /**
     * Taking damage
     * @param damage The damage to be taken
     * @return whether the attack was a KO
    */
    public boolean damage(int damage) {
        this.HP_current = Math.max(0, this.HP_current - damage);
        return this.HP_current == 0;
    }

    /**
     * Healing
     * @param heal The healing to be healed
     * @return whether the heal brought the guy to full
     */
    public boolean heal(int heal) {
        this.HP_current = Math.min(this.HP_max, this.HP_current + heal);
        return this.HP_current == this.HP_max;
    }

    /** Type array accessor */
    public Type[] type() {
        return new Type[] { this.type1, this.type2 };
    } // type array accessor

    /** Specific type accessor */
    public Type type(int i) {
        return this.type()[i%2];
    } // specific type accessor

    /** Nickname accessor */
    public String name() {
        return this.name;
    } // nickname accessor

    /** Species name accessor */
    public String speciesName() {
        return this.speciesName;
    } // species name accessor

    /** STAB checker */
    public boolean getSTAB(Type type) {
        return ((type.ID() == type1.ID()) || (type.ID() == type2.ID())) && (type.ID()%10 != 0);
    } // STAB checker

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

    /** Test */
    public static void main(String[] args) {
        Pokemon test = new Pokemon(Pokedex.zapdos);
        Pokemon_BS testBS = new Pokemon_BS(test);

        System.out.println(testBS.type(0) == Type.electric);
        System.out.println(testBS.type(1) == Type.flying);
        System.out.println(testBS.statSet.nature());

        System.out.println();
        for (int i = 0; i < 5; i++) {
            System.out.println(testBS.statSet.stat_combat(i));
            testBS.statSet.statChange(i, 1);
        }
        System.out.println();
        for (int i = 0; i < 5; i++) {
            System.out.println(testBS.statSet.stat_combat(i));
            testBS.statSet.statChange(i, -1);
        }
        System.out.println();
        for (int i = 0; i < 5; i++) {
            System.out.println(testBS.statSet.stat_combat(i));
        }
    }
}