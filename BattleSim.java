//package project_frontiers;

public class BattleSim {

    /** COMPONENTS:
     * Action + PriorityBracket
     * GameInterface
     * Event + EventBracket
     */

    private Pokemon_BS active_player;
    private Pokemon_BS active_opponent;

    private boolean battle_active;

    public static void main(String[] args) {
        BattleSim currentBattle = new BattleSim();

        /** Initialize combat */
        currentBattle.testInitialize();

        /** ROUND START
         *      \ Get player move choice
         *      \ Determine speed order, randomize ties
         *      \ Execute turns
         *          \ If a Pokemon faints, end the turn
         */
        while (currentBattle.battle_active) {
            currentBattle.round();
        }

        /** ROUND END
         *      \ Determine if the battle has ended
         *      \ If such is false, restart the round
         */

        /** BATTLE END
         *      \ Determine winner
         *      \ End code
         */
    }

    private void testInitialize() {
        Species[] selections = { Pokedex.moltres, Pokedex.dragonite, Pokedex.zapdos };
        String[] selections_names = new String[selections.length];

        for (int i = 0; i < selections.length; i++) {
            selections_names[i] = selections[i].name();
        }

        this.battle_active = true;

        Species select = selections[GameInterface.query("Choose Pokemon", selections_names, new String[] { "z", "x", "c" })%selections.length];
        GameInterface.delay();

        this.active_player = new Pokemon_BS(new Pokemon(select));
        this.active_opponent = new Pokemon_BS(new Pokemon(Pokedex.suicune));

        GameInterface.output("Opponent sent out " + this.active_opponent.name() + "!");
        GameInterface.delay();
        GameInterface.output("Go! " + this.active_player.name() + "!");
        GameInterface.delay();
        this.displayHP();
        GameInterface.delay(1200);
    }

    private void round() {
        PriorityBracket currentRound = new PriorityBracket();

        currentRound.add(new Action(this.active_player.moveset().move(selectMove()), active_player, active_opponent));
        currentRound.add(new Action(this.active_opponent.moveset().move(selectMove_opponent()), active_opponent, active_player));

        while(!currentRound.isEmpty() && this.battle_active) {
            this.executeAction(currentRound.pop());

            this.battle_active = this.active_player.HP_current() > 0 && this.active_opponent.HP_current() > 0;
        }
    }

    private int selectMove_opponent() {
        return (int)Math.floor(Math.random()*this.active_opponent.moveset().move().length);
    }

    private void executeAction(Action action) {
        GameInterface.output("\n" + action.user().name() + " used " + action.move().name() + "!");
        GameInterface.delay();
        if (action.move().toHit(action.user(), action.target())) {
            action.move().execute(action.user(), action.target());
            this.displayHP();
            GameInterface.output("");
        } else {
            GameInterface.output(action.user().name() + "'s attack missed!\n");
        }
    }

    private int selectMove() {
        return GameInterface.query("\nMOVE SELECT",  active_player.moveset().moveNames(), new String[] { "z", "x", "c", "v"});
    }

    private void displayHP() {
        GameInterface.output("\n" + active_player.name() + " HP: " + active_player.HP_current() + "/" + active_player.HP_max());
        GameInterface.output(active_opponent.name() + " HP: " + active_opponent.HP_current() + "/" + active_opponent.HP_max());
    }
}