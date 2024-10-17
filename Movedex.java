//package project_frontiers;

public class Movedex {

    /**
     * ARGUMENTS: String _name, Type _type, boolean _status, int _pow, int _acc) {
    */

    // NORMAL
    public static final Move bodySlam = new Move("Body Slam", Type.normal, false, 85, 100, 0); // 30% paralysis chance
    public static final Move extremeSpeed = new Move("Extreme Speed", Type.normal, false, 80, 100, 2);

    // FLYING
    public static final Move drillPeck = new Move("Drill Peck", Type.flying, false, 80, 100, 0);
    public static final Move skyAttack = null; // figure out what this will do

    // BUG
    public static final Move megahorn = new Move("Megahorn", Type.bug, false, 120, 75, 0);

    // POISON
    public static final Move sludgeBomb = new Move("Sludge Bomb", Type.poison, false, 80, 100, 0); // 30% poison chance

    // FIGHTING
    public static final Move brickBreak = new Move("Brick Break", Type.fighting, false, 75, 100, 0); // break screens
    public static final Move focusPunch = new Move("Focus Punch", Type.fighting, false, 150, 100, -5); // focus punch
    public static final Move machPunch = new Move("Mach Punch", Type.fighting, false, 40, 100, 1);

    // ROCK
    public static final Move rockSlide = new Move("Rock Slide", Type.rock, false, 75, 90, 0); // 30% flinch chance

    // GROUND
    public static final Move earthquake = new Move("Earthquake", Type.ground, false, 100, 100, 0);

    // GHOST
    public static final Move shadowBall = new Move("Shadow Ball", Type.ghost, false, 80, 100, 0); // 20% DEF down chance

    // STEEL
    public static final Move meteorMash = new Move("Meteor Mash", Type.steel, false, 100, 85, 0);

    // FIRE
    public static final Move fireBlast = new Move("Fire Blast", Type.fire, false, 120, 85, 0); // 10% burn chance
    public static final Move firePunch = new Move("Fire Punch", Type.fire, false, 75, 100, 0); // 15% burn chance
    public static final Move flamethrower = new Move("Flamethrower", Type.fire, false, 95, 100, 0); // 10% burn chance
    public static final Move heatWave = new Move("Heat Wave", Type.fire, false, 75, 90, 0); // 30% burn chance, heavily limit access; DO NOT A THE MOLTRES

    // WATER
    public static final Move hydroPump = new Move("Hydro Pump", Type.water, false, 120, 85, 0);
    public static final Move surf = new Move("Surf", Type.water, false, 95, 100, 0);
    public static final Move waterfall = new Move("Waterfall", Type.water, false, 80, 100, 0); // 20% flinch chance

    // ELECTRIC
    public static final Move thunder = new Move("Thunder", Type.electric, false, 120, 70, 0); // 100% ACC if raining, 50% ACC if sunny, 30% paralysis chance
    public static final Move thunderbolt = new Move("Thunderbolt", Type.electric, false, 95, 100, 0); // 10% paralysis chance
    public static final Move thunderPunch = new Move("Thunder Punch", Type.electric, false, 75, 100, 0); // 15% paralysis chance

    // PSYCHIC
    public static final Move psychic = new Move("Psychic", Type.psychic, false, 90, 100, 0); // 10% SPD down chance

    // DARK
    public static final Move crunch = new Move("Crunch", Type.dark, false, 80, 100, 0); // 20% SPD down chance

    // GRASS
    public static final Move gigaDrain = new Move("Giga Drain", Type.grass, false, 60, 100, 0); // 50% HP drain

    // ICE
    public static final Move blizzard = new Move("Blizzard", Type.ice, false, 120, 70, 0); // 10% freeze chance, 100% ACC if hailing
    public static final Move iceBeam = new Move("Ice Beam", Type.ice, false, 95, 100, 0); // 5% freeze chance
    public static final Move icePunch = new Move("Ice Punch", Type.ice, false, 75, 100, 0); // 10% freeze chance

    // DRAGON
    public static final Move dragonClaw = new Move("Dragon Claw", Type.dragon, false, 80, 100, 0);

    // HIDDEN POWERS
    public static final Move hiddenPower_normal = new Move("Hidden Power", Type.normal , false, 70, 100, 0);
    public static final Move hiddenPower_flying = new Move("Hidden Power", Type.flying , false, 70, 100, 0);
    public static final Move hiddenPower_bug = new Move("Hidden Power", Type.bug , false, 70, 100, 0);
    public static final Move hiddenPower_poison = new Move("Hidden Power", Type.poison , false, 70, 100, 0);
    public static final Move hiddenPower_fighting = new Move("Hidden Power", Type.fighting , false, 70, 100, 0);
    public static final Move hiddenPower_rock = new Move("Hidden Power", Type.rock , false, 70, 100, 0);
    public static final Move hiddenPower_ground = new Move("Hidden Power", Type.ground , false, 70, 100, 0);
    public static final Move hiddenPower_ghost = new Move("Hidden Power", Type.ghost , false, 70, 100, 0);
    public static final Move hiddenPower_steel = new Move("Hidden Power", Type.steel , false, 70, 100, 0);
    public static final Move hiddenPower_fire = new Move("Hidden Power", Type.fire , false, 70, 100, 0);
    public static final Move hiddenPower_water = new Move("Hidden Power", Type.water , false, 70, 100, 0);
    public static final Move hiddenPower_electric = new Move("Hidden Power", Type.electric , false, 70, 100, 0);
    public static final Move hiddenPower_psychic = new Move("Hidden Power", Type.psychic , false, 70, 100, 0);
    public static final Move hiddenPower_dark = new Move("Hidden Power", Type.dark , false, 70, 100, 0);
    public static final Move hiddenPower_grass = new Move("Hidden Power", Type.grass , false, 70, 100, 0);
    public static final Move hiddenPower_ice = new Move("Hidden Power", Type.ice , false, 70, 100, 0);
    public static final Move hiddenPower_dragon = new Move("Hidden Power", Type.dragon , false, 70, 100, 0);
}