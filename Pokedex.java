//package project_frontiers;

public class Pokedex {

    /** GENERATION ONE */
    public static final Species dragonite = new Species(149, "Dragonite", Type.dragon, Type.flying,
    91, 134, 95, 100, 100, 80,
    new Move[] { Movedex.dragonClaw, Movedex.heatWave, Movedex.hiddenPower_flying, Movedex.extremeSpeed },
    new Move[] {});

    public static final Species zapdos = new Species(145, "Zapdos", Type.electric, Type.flying,
    90, 90, 85, 125, 90, 100,
    new Move[] { Movedex.thunderbolt, Movedex.hiddenPower_grass, Movedex.drillPeck, Movedex.heatWave },
    new Move[] {});

    public static final Species moltres = new Species(146, "Moltres", Type.fire, Type.flying,
    90, 100, 90, 125, 85, 90,
    new Move[] { Movedex.flamethrower, Movedex.hiddenPower_grass },
    new Move[] {});

    /** GENERATION TWO */
    public static final Species suicune = new Species(245, "Suicune", Type.water, Type.typeless,
    100, 75, 115, 90, 115, 85,
    new Move[] { Movedex.surf, Movedex.extremeSpeed, Movedex.iceBeam, Movedex.hiddenPower_electric },
    new Move[] {});

    public static final Species tyranitar = new Species(248, "Tyranitar", Type.rock, Type.dark,
    100, 134, 110, 95, 100, 61,
    new Move[] { Movedex.crunch, Movedex.rockSlide, Movedex.fireBlast, Movedex.hiddenPower_bug },
    new Move[] {});

    /** GENERATION THREE */
    public static final Species latias = new Species(380, "Latias", Type.dragon, Type.psychic,
    80, 80, 90, 110, 130, 110,
    new Move[] { Movedex.dragonClaw, Movedex.psychic, Movedex.flamethrower, Movedex.surf },
    new Move[] {});

    public static final Species jirachi = new Species(385, "Jirachi", Type.steel, Type.psychic,
    100, 100, 100, 100, 100, 100,
    new Move[] { Movedex.icePunch, Movedex.firePunch, Movedex.psychic, Movedex.thunder },
    new Move[] {});

    /** GENERATION FOUR */
    public static final Species gliscor = new Species(472, "Gliscor", Type.ground, Type.flying,
    75, 85, 125, 45, 75, 95,
    new Move[] { Movedex.earthquake, Movedex.rockSlide, Movedex.hiddenPower_flying, Movedex.brickBreak },
    new Move[] {});

    public static final Species mamoswine = new Species(473, "Mamoswine", Type.ice, Type.ground,
    110, 130, 80, 70, 60, 80,
    new Move[] { Movedex.earthquake, Movedex.bodySlam, Movedex.rockSlide, Movedex.iceBeam },
    new Move[] {});

    /** GENERATION FIVE */
    public static final Species samurott = new Species(000, "Samurott", Type.water, Type.dark,
    90, 108, 80, 100, 65, 85,
    new Move[] { Movedex.hydroPump, Movedex.hiddenPower_dark, Movedex.iceBeam, Movedex.megahorn },
    new Move[] {});

    /** GENERATION SIX */
    public static final Species goodra = new Species(000, "Goodra", Type.dragon, Type.typeless,
    90, 100, 70, 110, 150, 80,
    new Move[] {},
    new Move[] {});

    public static final Species zygarde = new Species(718, "Zygarde", Type.dragon, Type.ground,
    108, 100, 121, 81, 95, 95,
    new Move[] {},
    new Move[] {});

    /** GENERATION SEVEN */
    public static final Species buzzwole = new Species(794, "Buzzwole", Type.bug, Type.fighting,
    107, 139, 139, 53, 53, 79,
    new Move[] {},
    new Move[] {});

    public static final Species marshadow = new Species(802, "Marshadow", Type.fighting, Type.ghost,
    90, 105, 80, 90, 90, 125,
    new Move[] { Movedex.shadowBall, Movedex.focusPunch , Movedex.brickBreak, Movedex.icePunch },
    new Move[] {});

    /** GENERATION EIGHT */

    /** GENERATION NINE */
    public static final Species tinkaton = new Species(959, "Tinkaton", Type.steel, Type.typeless,
    95, 95, 77, 70, 105, 94,
    new Move[] { Movedex.meteorMash, Movedex.rockSlide, Movedex.brickBreak },
    new Move[] {});

    public static final Species flutter_mane = new Species(987, "Flutter Mane", Type.ghost, Type.normal,
    53, 53, 53, 125, 125, 125,
    new Move[] {},
    new Move[] {});

    public static final Species iron_bundle = new Species(991, "Iron Bundle", Type.ice, Type.water,
    56, 80, 106, 106, 60, 126,
    new Move[] {Movedex.hydroPump, Movedex.iceBeam, Movedex.drillPeck, Movedex.hiddenPower_grass});
}