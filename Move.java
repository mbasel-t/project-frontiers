public abstract class Move {

    /** Name accessor */
    public abstract String name();

    /** Priority accessor */
    public abstract int priority();

    /** Type accessor */
    public abstract Type type();

    /** Status move accessor */
    public abstract boolean isStatus();

    /** Self-target accessor */
    public abstract boolean selfTarget();

    /** Move use function */
    public abstract use();
}
