//package project_frontiers;

public class Action {

    private Pokemon_BS user;
    private Pokemon_BS target;
    private Move move;
    private int priority;
    private int speed;

    /** test constructor for PriorityBracket.java */
    public Action(int _priority, int _speed) {
        this.priority = _priority;
        this.speed = _speed;
    } // test constructor; DO NOT USE

    /** general use constructor */
    public Action(Move _move, Pokemon_BS _user, Pokemon_BS _target) {
        this.move = _move;
        this.priority = _move.priority();
        this.user = _user;
        this.target = _target;
        this.speed = this.user.statSet().stat_combat(4);
    }

    /** user accessor */
    public Pokemon_BS user() {
        return user;
    } // method user

    /** target accessor */
    public Pokemon_BS target() {
        return target;
    } // method target

    /** move accessor */
    public Move move() {
        return move;
    } // method move

    /** priority accessor */
    public int priority() {
        return priority;
    } // method priority

    /** speed accessor */
    public int speed() {
        return speed;
    } // method speed
}