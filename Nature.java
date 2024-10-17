//package project_frontiers;

public class Nature {

    private int plus;
    private int minus;
    private String name;
    
    /** Basic constructor */
    public Nature(String _name, int _plus, int _minus) {
        this.plus = _plus;
        this.minus = _minus;
        this.name = _name;
    } // basic constructor

    /** Default constructor */
    public Nature() {
        int key = (int)Math.floor(Math.random()*25.0);
        this.plus = Nature.constructNature_boost(key);
        this.minus = Nature.constructNature_drop(key);
        this.name = Nature.constructNature_name(key);
    } // default constructor

    /** Accessor for plus */
    public int boost() {
        return plus;
    } // method boost

    /** Accessor for drop */
    public int drop() {
        return minus;
    } // method drop

    /** Accessor for a given stat's multiplier */
    public double bonus(int stat) {
        double result = 1.0;
        if (plus != minus) {
            if (stat == plus) {
                result = 1.1;
            } else if (stat == minus) {
                result = 0.9;
            }
        }
        return result;
    } // method bonus

    /** Accessor for name */
    public String name() {
        return name;
    } // method name


    // NATURE AUTOGENERATION

    /**
     * Produces and returns a randomly-generated nature. Automates naming process.
     * @return a randomly-generated Nature class.
     */
    public static Nature constructNature() {
        int key = (int)Math.floor(Math.random()*25.0);
        return new Nature(constructNature_name(key), constructNature_boost(key), constructNature_drop(key));
    } // method constructNature

    /**
     * Given a number key from 0 to 24, returns the corresponding nature name.
     * @param key Number key for the nature
     * @return corresponding nature to the key
     */
    private static String constructNature_name(int key) {
        String[] outputs = {
            "Hardy", "Lonely", "Adamant", "Naughty", "Brave",
            "Bold", "Docile", "Impish", "Lax", "Relaxed",
            "Modest", "Mild", "Bashful", "Rash", "Quiet",
            "Calm", "Gentle", "Careful", "Quirky", "Sassy",
            "Timid", "Hasty", "Jolly", "Naive", "Serious" };
        return outputs[key%outputs.length];
    } // method constructNature_name

    /**
     * Given a number key from 0 to 24, returns the raise stat for the corresponding
     * nature.
     * @param key Number key for the nature
     * @return corresponding stat boost to the key
     */
    private static int constructNature_boost(int key) {
        return 1 + (int)Math.floor(key/5.0);
    } // method constructNature_boost

    /**
     * Given a number key from 0 to 24, returns the drop stat for the corresponding
     * nature.
     * @param key Number key for the nature
     * @return corresponding stat drop to the key
     */
    private static int constructNature_drop(int key) {
        return 1 + (key%5);
    } // method constructNature_drop

    /** Test output */
    public static void main(String[] args) {
        System.out.println("TEST - Nature.java");
        Nature x = Nature.constructNature();
        System.out.println(x.name + "\nBoost: " + x.boost() + "\nDrop: " + x.drop());
        System.out.println();
        for(int i = 1; i <= 5; i++) {
            System.out.println(String.format("Stat multiplier %1$x: ", i) + x.bonus(i));
        }
        System.out.println("\nTEST CONCLUDED\n");
    } // method main
}