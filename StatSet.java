//package project_frontiers;

public class StatSet {
    
    private Nature nature;

    private int[] stats;
    private int[] stats_base;
    private int[] EVs;
    private int[] IVs;
    private int[] statStages;
    private int[] stats_combat;

    private double acc = 1;
    private double eva = 1;

    /** Constructor */
    public StatSet(Species species) {
        this.nature = new Nature();

        this.initializeStats(species);
        this.revertStatChanges();

    } // constructor


    // BATTLE STATS
    
    /**
     * Updates stats to match stages
     */
    public void updateStats() {
        for (int i = 0; i < 5; i++) {
            double statMult;
            if (this.statStages[i] > 0) {
                statMult = 1.0 + 0.5*this.statStages[i];
            } else {
                statMult = 2.0 / (2.0 - this.statStages[i]);
            }
            this.stats_combat[i] = Math.max((int)(this.stats[i+1] * statMult), 1);
        }

        if (this.statStages[5] > 0) {
            this.acc = (3.0 + this.statStages[5]) / 3.0;
        } else {
            this.acc = 3.0 / (3.0 - this.statStages[5]);
        }

        if (this.statStages[6] > 0) {
            this.eva = 3.0 / (3.0 + this.statStages[6]);
        } else  {
            this.eva = (3.0 - this.statStages[6]) / 3.0;
        }
    } // method updateStats

    /**
     * Alters a stat stage, ensuring that the stat change stays within (-6 <= statStages[x] <= 6);
     * @param stat The stat to be changed
     * @param change The number of stages to be boosted or dropped by (negative if dropping)
     * @return whether the stat change was successful or not
     */
    public boolean statChange(int stat, int change) {
        stat = stat%this.statStages.length;
        boolean result = !((this.statStages[stat] >= 6 && change > 0) || (this.statStages[stat] <= -6 && change < 0));

        if(result && change > 0) {
            this.statStages[stat] = Math.min(6, this.statStages[stat] + change);
        } else if (result) {
            this.statStages[stat] = Math.max(-6, this.statStages[stat] + change);
        }

        this.updateStats();
        return result;
    } // method statChange
    
    /**
     * Reverts all stat stages to 0, then updates stats.
     */
    public void revertStatChanges() { 
        this.statStages = new int[7];
        this.updateStats();
    } // method revertStatChanges


    // POKEMON STATS

    /** Initializes stats */
    private void initializeStats(Species species) {
        this.stats_base = species.baseStats();
        this.IVs = new int[] { 0, 0, 0, 0, 0, 0 };
        this.EVs = new int[] { 0, 0, 0, 0, 0, 0 };

        setStats();

        this.stats_combat = new int[5];
        this.revertStatChanges();
    }

    /** Sets underlying stats */
    private void setStats() {
        this.stats = new int[6];
        this.stats[0] = (2*this.stats_base[0] + this.IVs[0] + this.EVs[0]) + 110;
        for (int i = 0; i <= 5; i++) {
            this.stats[i] = (int)((2*this.stats_base[i] + this.IVs[i] + this.EVs[i] + 5)*this.nature.bonus(i));
        }
    } // method setStats


    // ACCESSORS

    /** Base stat accessor */
    public int stat_base(int stat) {
        return this.stats_base[stat%this.stats_base.length];
    }

    /** Combat stat accessor */
    public int stat_combat(int stat) {
        return this.stats_combat[stat%this.stats_combat.length];
    }

    /** Stat accessor */
    public int stat(int stat) {
        return this.stats[stat%this.stats.length];
    } // method stat

    /** Accuracy accessor */
    public double acc() {
        return this.acc;
    }

    /** Evasion accessor */
    public double eva() {
        return this.eva;
    }

    /** IV accessor */
    public int IV(int IV) {
        return this.IVs[IV%this.IVs.length];
    } // method IV

    /** EV accessor */
    public int EV(int EV) {
        return this.EVs[EV%this.EVs.length];
    } // method EV

    /** Nature accessor */
    public String nature() {
        return this.nature.name();
    } // method nature

    /**
     * test output
     * @param args
     */
    public static void main(String[] args) {
        Species zapdos = new Species(0, "Zapdos", Type.electric, Type.flying, 90, 90, 85, 125, 90, 100, new Move[] {}, new Move[] {});

        StatSet stats = new StatSet(zapdos);

        GameInterface.output("BASE STATS:");
        for (int stat : stats.stats_base) {
            GameInterface.output(String.format(" %1$s", stat));
        }
        GameInterface.output("NORMAL STATS, MIN EVs:");
        for (int stat : stats.stats) {
            GameInterface.output(String.format(" %1$s", stat));
        }
        GameInterface.output(stats.nature.name() + " NATURE");

        GameInterface.output("\nBATTLE STATS, +1:");
        for (int i = 0; i < stats.stats_combat.length; i++) {
            stats.statChange(i, 1);
        }
        for (int stat : stats.stats_combat) {
            GameInterface.output(String.format(" %1$s", stat));
        }
        for (int stat : stats.statStages) {
            GameInterface.output(String.format(" %1$s%2$s", (stat<0 ? "" : "+"), stat));
        }

        stats.revertStatChanges();
        GameInterface.output("\n BACK TO NORMAL:");
        for (int stat : stats.stats_combat) {
            GameInterface.output(String.format(" %1$s", stat));
        }
        for (int stat : stats.statStages) {
            GameInterface.output(String.format(" %1$s%2$s", (stat<0 ? "" : "+"), stat));
        }

        GameInterface.output("\nBATTLE STATS, -1:");
        for (int i = 0; i < stats.stats_combat.length; i++) {
            stats.statChange(i, -1);
        }
        for (int stat : stats.stats_combat) {
            GameInterface.output(String.format(" %1$s", stat));
        }
        for (int stat : stats.statStages) {
            GameInterface.output(String.format(" %1$s%2$s", (stat<0 ? "" : "+"), stat));
        }
        
        stats.revertStatChanges();
        GameInterface.output("\n BACK TO NORMAL:");
        for (int stat : stats.stats_combat) {
            GameInterface.output(String.format(" %1$s", stat));
        }
        for (int stat : stats.statStages) {
            GameInterface.output(String.format(" %1$s%2$s", (stat<0 ? "" : "+"), stat));
        }
    }
}