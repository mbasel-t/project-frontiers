//package project_frontiers;

public class Type {

    // PUBLIC TYPES

    public static final Type typeless = new Type("???", 1, 0);
    public static final Type normal = new Type("Normal", 1, 1, new double[] {1,1,1,1,1,2,1,1,0,1,1,1,1,1,1,1,1,1,1});
    public static final Type flying = new Type("Flying", 1, 2, new double[] {1,1,1,0.5,1,0.5,2,0,1,1,1,1,1,2,1,1,0.5,2,1});
    public static final Type bug = new Type("Bug", 1, 3, new double[] {1,1,2,1,1,0.5,2,0.5,1,1,1,2,1,1,1,1,0.5,1,1});
    public static final Type poison = new Type("Poison", 1, 4, new double[] {1,1,1,0.5,0.5,0.5,1,2,1,1,1,1,1,1,2,1,0.5,1,1});
    public static final Type fighting = new Type("Fighting", 1, 5, new double[] {1,1,2,0.5,1,1,0.5,1,1,1,1,1,1,1,2,0.5,1,1,1});
    public static final Type rock = new Type("Rock", 1, 6, new double[] {1,0.5,0.5,0.5,1,2,1,2,1,2,1,0.5,2,1,1,1,2,1,1});
    public static final Type ground = new Type("Ground", 1, 7, new double[] {1,1,1,1,0.5,1,0.5,1,1,1,1,1,2,0,1,1,2,2,1});
    public static final Type ghost = new Type("Ghost", 1, 8, new double[] {1,0,1,0.5,0.5,0,1,1,2,1,1,1,1,1,1,2,1,1,1});
    public static final Type steel = new Type("Steel", 1, 9, new double[] {1,0.5,0.5,0.5,0,2,0.5,2,0.5,0.5,1,2,1,1,0.5,0.5,0.5,0.5,0.5});
    public static final Type typeless_spec = new Type("???", 2, 10);
    public static final Type fire = new Type("Fire", 2, 11, new double[] {1,1,1,0.5,1,1,2,2,1,0.5,1,0.5,2,1,1,1,0.5,0.5,1});
    public static final Type water = new Type("Water", 2, 12, new double[] {1,1,1,1,1,1,1,1,1,0.5,1,0.5,0.5,2,1,1,2,0.5,1});
    public static final Type electric = new Type("Electric", 2, 13, new double[] {1,1,0.5,1,1,1,1,2,1,0.5,1,1,1,0.5,1,1,1,1,1});
    public static final Type psychic = new Type("Psychic", 2, 14, new double[] {1,1,1,2,1,0.5,1,1,2,1,1,1,1,1,0.5,2,1,1,1});
    public static final Type dark = new Type("Dark", 2, 15, new double[] {1,1,1,2,1,2,1,1,0.5,1,1,1,1,1,0,0.5,1,1,1});
    public static final Type grass = new Type("Grass", 2, 16, new double[] {1,1,2,2,2,1,0.5,0.5,1,1,1,2,0.5,0.5,1,1,0.5,2,1});
    public static final Type ice = new Type("Ice", 2, 17, new double[] {1,1,1,1,1,2,2,1,1,2,1,2,1,1,1,1,1,0.5,1});
    public static final Type dragon = new Type("Dragon", 2, 18, new double[] {1,1,1,1,1,1,1,1,1,1,1,0.5,0.5,0.5,1,1,0.5,2,2});

    public static final Type typeList[] = {
        Type.typeless, Type.normal, Type.flying, Type.bug,
        Type.poison, Type.fighting, Type.rock, Type.ground,
        Type.ghost, Type.steel, Type.typeless_spec, Type.fire,
        Type.water, Type.electric, Type.psychic, Type.dark,
        Type.grass, Type.ice, Type.dragon
    };

    /** Test output */
    public static void main(String[] args) {
        for (Type type : Type.typeList) {
            System.out.println("\n" + type.name());
            for (Type type2 : Type.typeList) {
                System.out.println("  " + type2.name() + ": " + type.weak(type2.ID()));
            }
        }
    } // method main


    // INSTANCE VARIABLES, METHODS, AND CONSTRUCTORS

    private String name;
    private int categoryID;
    private int typeID;
    private double[] interactions;

    /** Basic constructor */
    public Type(String n, int cat, int i, double[] wr) {
        this.name = n;
        this.categoryID = cat;
        this.typeID = i;
        this.setWeak(wr);
    } // basic constructor

    /** Default constructor */
    public Type(String n, int cat, int i) {
        this.name = n;
        this.categoryID = cat;
        this.typeID = i;
        this.setWeak(new double[] {});
    } // default constructor

    /** 
     * Edits the type's interactions.
     */
    private void setWeak(double[] wr) {
        if(wr.length == 19) {
            this.interactions = wr;
        } else if (interactions == null) {
            interactions = new double[] {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        }
    } // method setWeak

    /** Accessor for category */
    public int category() {
        return categoryID;
    } // method category
    
    /** Accessor for name */
    public String name() {
        return name;
    } // method name

    /** Accessor for ID */
    public int ID() {
        return typeID;
    } // method ID

    /** Accessor for weakness via type ID */
    public double weak(int ID) {
        double result = -1;
        if (ID < interactions.length) {
            result = interactions[ID];
        }
        return result;
    } // method weak

    /** Accessor for weakness via a Type class */
    public double weak(Type type) {
        return weak(type.ID());
    } // method weak
}