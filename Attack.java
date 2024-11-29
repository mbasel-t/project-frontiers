//package project_frontiers;

public class Attack {

    private int power;
    private int accuracy;
    private boolean status = false;
    private int priority;
    private int offensiveStat;
    private int defensiveStat;

    private Type type;

    private String name;

    public Move(String _name, Type _type, int _pow, int _acc, int _priority) {
        this.name = _name;
        this.type = _type;
        this.power = _pow;
        this.accuracy = _acc;
        this.priority = _priority;
        this.offensiveStat = (this.type.category() == 2 ? 2 : 0);
        this.defensiveStat = (this.type.category() == 2 ? 3 : 1);
    }

    /** Name accessor */
    public String name() {
        return this.name;
    } // method name

    /** Damage calculator incl. STAB and type effectiveness */
    public int attack(Pokemon_BS attacker, Pokemon_BS defender) {
        double powerMult = (Math.random() * 0.15 + 0.85) * (attacker.getSTAB(this.type) ? 1.5 : 1) * (defender.weak(type));
        
        return this.damage(attacker, defender, powerMult);
    } // method attack
    
    /** Raw DMG calculator with ATK and DEF. Includes powerMult if used as an argument. */
    public int damage(Pokemon_BS attacker, Pokemon_BS defender, double powerMult) {
        return (int)(this.power * ((double)attacker.statSet().stat_combat(this.offensiveStat) / (double)defender.statSet().stat_combat(this.defensiveStat)) * powerMult);
    } // method damage

    /** Hit rate checker */
    public boolean toHit(Pokemon_BS attacker, Pokemon_BS defender) {
        return Math.random() < ((double)this.accuracy * 0.01 * attacker.statSet().acc() * attacker.statSet().eva());
    } // method toHit

    /** Status accessor */
    public boolean status() {
        return this.status;
    } // method status

    /** Priority accessor */
    public int priority() {
        return this.priority;
    } // method priority
}
