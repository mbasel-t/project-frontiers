# Purpose
Project Frontiers is inspired by the Battle Frontier from some older Pokémon
games, like Pokémon Emerald (2005), Pokémon Platinum (2008), and Pokémon
HeartGold and SoulSilver (2009). The Battle Frontier was a location where
players could participate in special combat challenges with their Pokémon; for
instance, in the Battle Tower challenge, players will face several opponents
back-to-back, while, in the Battle Pyramid challenge, players will traverse a
dark dungeon where they can come across challenges to get rewards, such as hints
about the dungeon's layout, or items to help the player succeed in the challenge.

With Project Frontier, I aim to create a full-fledged game with a system
similar to the Battle Frontier as its main focus. Although the intricacies of
the combat system will be largely based on that of Pokémon Emerald (2005), it
will include newer characters, items, and skills for players to make use of,
while still maintaining the spirit of Pokémon Emerald's gameplay.

Project Frontiers will not be monetized in any capacity.

## Short-term programming goals
I have reached a phase of being able to have two Pokémon have a very simple
battle. These two Pokémon can use a few different attacks, and these attacks
can miss, but that's about it. Compared to the original version of Pokémon,
this is lacking.

The current way I have had moves set up is very simple, but not scaleable. Each
attack was an instance of the same Move.java class, meaning they could not
really do anything super unique, which is bad because Pokémon Emerald has a lot
of unique moves. Let's take Snore, for instance. Snore is an attack that only
works if the user is sleeping. If the user hits Snore on a target that has not
moved this turn, the target has a 30% chance of having that action skipped. As
a "sound-based" move, Snore also has special interactions with certain
defensive benefits of other Pokémon that may allow it to deal damage when an
attack normally would not, or cause it to do nothing when most other moves
would work just fine. Moves like Snore that have a number of unique properties
cannot be instances of the exact same class as every other move in the game.

That being said, my solution is to divide moves into smaller groups with very
similar properties. For instance, there are a lot of Fire-type attacks that
have a chance to Burn the target, like Ember, Flamethrower, Fire Blast, Heat
Wave, Inferno, and Sacred Fire. Aside from having variances in the damage these
attacks deal, their chance of hitting, and their chance of Burning the target,
these are all the exact same move, so it is reasonable for them to be instances
of the same class. However, a very different move that has a completely
different set of features, like Snore, will be under a different class.

Currently, this new system of implementing moves is a work-in-progress, and is
divided into three levels. As of now, all move classes extend the Move.java
abstract class. Damage-dealing moves will extend the Attack.java abstract
class. Every Move object will have the use() function, which will be called
in the battle to execute the move's effects.

Because the implementations are a work-in-progress, my code is currently
non-functional. However, I am working to restore this program to its previous
level. Once this is done, it will be significantly easier to develop battles
to the point of being able to simulate an actual Pokémon Emerald battle with
any set of moves in that game.

# Long-Term Goals

## Graphics, Visuals, and Aesthetics
The graphical features of the game are essentially in the planning phase, but
the general aesthetic of the game aims to replicate that of Pokémon Emerald as
well.

Here is an example of how this might look: 
https://youtu.be/uvlWKOf7aeE?si=CoTch6Mw-qKNoXbk&t=43

As far as sprites (2D character models) are concerned, characters with existing
sprites in Pokémon Emerald will have their sprites from that game used, while
characters from newer Pokémon games will have sprites commissioned from sprite
artists in the artistic style of Pokémon Emerald for exclusive use in Project
Frontiers.

## Gameplay (WIP)

### Combat
Combat within Project Frontiers mimics the general formula of combat in Pokémon
games. There are two Pokémon trainers— in the case of Project Frontiers, the
player and the game AI— who each possess a team of 1-6 Pokémon; however, each
trainer may only have one Pokémon on-field at a time. The objective of each
trainer is to defeat the opposing trainer's entire team, by reducing their
Pokémon to 0 HP (hit-points) individually. When a Pokémon is reduced to 0 HP,
it faints, rendering it unusable for the remainder of the battle.

On each turn, both trainers have the option to either switch their own Pokémon
for another one in their party, or command their current Pokémon on-field to
make one action, called a Move. Switches are always executed before Moves.
Moves are executed first in order of "priority", which is an innate property of
each Move, regardless of the Pokémon using it. Almost all Moves have a priority
of 0, but some have increased or reduced priority, as high as +5 and as low as
-7. In the case of a tie between two Pokémon's Moves' priority, the Pokémon's
Speed stat is used instead. The turn executes in order of priority first, then
Speed, unless a Pokémon faints; in the case that this happens, the turn is
ended instantly, regardless of if any Pokémon have yet to act; then, the
trainer whose Pokémon has fainted immediately switches in a new one. If both
trainers' Pokémon fainted in the same turn, they choose the replacement
simultaneously.

Many Pokémon Moves deal damage directly, reducing the opponent's HP immediately
after execution. These are called attacks. Attacks can also have secondary
effects, or a chance of inflicting secondary effects, but the vast majority
serve the primary purpose of dealing immediate damage. Attacks have one of
seventeen Types, which interact with the Type of the target Pokémon. For
instance, a Flying-type Pokémon is naturally weak to Rock-, Electric-, and
Ice-type attacks, but resists Fighting-, Bug-, and Grass-type attacks, and is
completely immune to Ground-type attacks. Meanwhile, a Dragon-type Pokémon is
weak to Dragon- and Ice-type attacks, and resists Fire-, Water-, Grass-, and
Electric-type attacks; the Dragon type has no immunities. When a Pokémon uses
an attack and that attack's type matches its own, that attack gains a damage
bonus! Some Pokémon have two types, as well. Offensively, this means they gain
damage bonuses on two types of attack, and, defensively, this means they have
weaknesses and resistances combining both their types. A Flying- and
Dragon-type Pokémon will resist Fighting-, Bug-, Grass-, Water-, and Fire-type
attacks, and will be weak to Rock-, Dragon-, and Ice-type attacks. Because both
Dragon and Flying are weak to Ice and resist Grass, these interactions will be
intensified, so a Dragon- and Flying-type Pokémon will shrug off almost any
Grass-type attack, but will take fatal damage from an Ice-type one.

Aside from type effectiveness, the damage of an attack is based on either the
user's Physical Attack and the target's Physical Defense stat, or the user's
Special Attack stat and the target's Special Defense stat. Whether an attack
interacts with Physical or Special stats depends on its type. The
aforementioned Flying type is Physical, and Dragon is Special, for instance.
This helps a lot of Pokémon define their role in combat; since Dragon has no
Physical-category weaknesses, for instance, a Dragon-type Pokémon can be very
difficult to defeat with Physical attacks if it has high Physical Defense.

Some Moves are not attacks. These Moves have types, but usually do not
interact with the user's type or the target's. These are often called Status
Moves. Status Moves can have a range of effects, ranging from setting up traps
on the enemy side of the field, poisoning enemies to deal damage over time, and
altering the user's or opponent's stats in your favor. While these Moves do not
directly deal damage, they can serve a variety of offensive, defensive, and
utility functions to help the player achieve their goal of defeating all
opposing Pokémon.

There are obviously a lot of intricacies to the game, but they are fairly easy
to get used to through experience, and, once the player understands the various
systems within the game and how to exploit them, they will be rewarded greatly
through success in combat.

### Challenges (WIP)

### Pokémon (WIP)
