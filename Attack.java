//package project_frontiers;

abstract class Attack extends Move {

    /** Name accessor */
    public abstract String name();

    /** Priority accessor */
    public abstract int priority();

    /** Type accessor */
    public abstract Type type();

    /** Status move accessor should always return False */
    public abstract boolean isStatus();

    /** Self-target accessor */
    public abstract boolean selfTarget();

    /** Move use function */
    public abstract use(Pokemon_BS user, Pokemon_BS target/**, Field field */);

    /** Roll-to-hit function */
    public abstract boolean toHit();

    /** Damage calculation function */
    public abstract boolean calcDamage();
}
