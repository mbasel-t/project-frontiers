public class Moves {

    public class Extreme_Speed extends Attack {

        private int power;
        private int accuracy;
        private int priority;
        private int offensiveStat;
        private int defensiveStat;

        private Type type;

        private String name;

        public Extreme_Speed(String _name, Type _type, int _pow, int _acc, int _priority) {
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

        /** Type accessor */
        public Type type() {
            return this.type;
        }

        /** Priority accessor */
        public int priority() {
            return this.priority;
        } // method priority

        /**
         * Calculates and deals damage to the target according to the move used in-question
         * @param attacker Attacking Pokémon
         * @param defender Defending Pokémon
         * @return The damage dealt by this attack
         */
        public int execute(Pokemon_BS attacker, Pokemon_BS defender) {
            int damageDealt = defender.attack(this.damage(attacker, defender));

            return damageDealt;
        }

        /** Damage calculator incl. STAB and type effectiveness */
        public int attack(Pokemon_BS attacker, Pokemon_BS defender) {
            double powerMult = (Math.random() * 0.15 + 0.85) * (attacker.getSTAB(this.type) ? 1.5 : 1) * (defender.weak(type));
            
            return this.attackHelper(attacker, defender, powerMult);
        } // method attack
        
        /** Raw damage calculator with ATK and DEF. Used alongside powerMult to determine entire damage. */
        private int attackHelper(Pokemon_BS attacker, Pokemon_BS defender, double powerMult) {
            return (int)(this.power * ((double)attacker.statSet().stat_combat(this.offensiveStat) / (double)defender.statSet().stat_combat(this.defensiveStat)) * powerMult);
        } // method damage



        /** Hit rate checker */
        public boolean toHit(Pokemon_BS attacker, Pokemon_BS defender) {
            return Math.random() < ((double)this.accuracy * 0.01 * attacker.statSet().acc() * attacker.statSet().eva());
        } // method toHit

        /** Status accessor */
        public boolean isStatus() {
            return false;
        } // method status

        /** Self-target accessor */
        public boolean selfTarget() {
            return false;
        }
    }
}
