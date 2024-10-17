//package project_frontiers;

public class Event {
    private int ID;
    private int priority;
    private int speed;

    public Event(int _id, int _priority, int _speed) {
        this.ID = _id;
        this.priority = _priority;
        this.speed = _speed;
    }

    /** ID accessor */
    public int ID() {
        return this.ID;
    } // method ID

    /** priority accessor */
    public int priority() {
        return this.priority;
    } // method priority

    /** speed accessor */
    public int speed() {
        return this.speed;
    } // method speed

    /**  */

    // ADD EVENT EXECUTOR AND HELPER METHODS FOR EACH I.D.
}
