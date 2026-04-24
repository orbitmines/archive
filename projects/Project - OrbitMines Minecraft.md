
# FoG / Prison / SkyBlock gamemode
Ok so this gamemode will combine ideas from Fractals of the Galaxy (FoG), Prison and Skyblock into a single experience. So see `cd @orbitmines/minecraft/archive/code & workspace/arcs/4-2015-2016-split/FoG`, `arcs/5-2016-17-workspace/Prison`, `arcs/5-2016-17-workspace/SkyBlock` & `.orbitmines/repositories/servers/prison` (especially for the blocks-mined counter here).

Take inspiration from the current `@orbitmines/minecraft/remastered` setup for KitPvP for items, custom enchants, Creative for the world loading, and Survival for the usual setup. We'll call the gamemode FoG so create the associated boilerplate for a new server, but under FoG. So this is the typical player/model record specific to the gamemode.

It's like a Rogue-like Prison/SkyBlock/DarkOrbit-kind of PvE gamemode. There's a `Run`, which should be a database record, which stored information specific to that run.

What information should be tracked? (each a separate database model)
- `The Player model`: Which run is currently active.
- `Run`: Like creative this generates a world (just an Overworld), that world will be given a name like creative [UUID]_fog_[ID], which we'll put in the OMMap entries, then refer to the world file name of that world in this `Run` entry.
	- a field `difficulty`
		- Normal (Lose max 5 levels on death)
		- Hard (Lose max 10 levels on death, harder mobs)
		- Same as hard Hardcore (Hard + Permedeath) ; can still visit the map as a spectator.
	- 
- `RunStore`: A key-value store assocaited with a specific run
	- `member:<UUID>`; all the players who are added to a run; like how creative/survival add players to claims/worlds.
		- `member:<UUID>:play-time` Duration of play for each run per player in that run, using the same system we currently use to keep track of player online information, but then a hook into it such that we record it per-run per-member.
		- `member:<UUID>:level`: The level the member is currently at
		- `member:<UUID>:experience`: The experience they've currently gained for the current level.
	- There needs to be a modular class used for both Drones & Players which keeps track of all the stats and whether something else we'll yet define applies to them.
		- `member:<UUID>:stats:tool:TOOL_TYPE:blocks_broken`: The number of blocks broken, we also keep track of that separately on the NMS of the tools as well; periodically update the database.
		- `member:<UUID>:drone:DRONE_ID:[All the same stats fields also used for players]` So an example would be `member:<UUID>:drone:1:tool:TOOL_TYPE:blocks_broken

Each level the player chooses one of three options. The player is flaoted up into the world, up into the air through blocks teleported if they're there. Then they see three options in the air, using personalized holograms showing them what, the description (on several lines ofc, padded such that it's nicely readable and each line is the same length. Padded with dark gray .), then the name and an appropraite floating item representing the choice. Click on it makes the choice. Then brings the player slowly back down.

On Death:
- All Items, enchantments, unlockables are ALL tied to a specific level choice. When that level is taken away on death, those items enter a stage called: "DAMAGED" all the custom enchantments will say in a strike through and "DAMAGED" in red in front of. If a Map upgrade was unlocked with this level, that area will now be set as off-limits, creating a stainglass red barrier around it.
	- When a person re-levels up, one of the choices is garanteed to be the choice they previously made on that level. If the person choosse a different one, this unlock is lost. If that was a map upgrade, that map upgrade comes available again in the pool of possible upgrades for other players/members (and themselves too). Still holding the red stained glass barrier. If a person then levels up again, it's the second thing they chose etc..  The choice is highlighted that it was previously made in the hologram selection, more on that later.

Levels (choose one out 3 each time.)  50% Common/ 30% Rare/15% Epic/ 5% Legendary, potentially unique: applicable only once per run for all players. ; All choices are stored under `member:<UUID>:choice:<LEVEL>:<CHOICE>`
- field `faction`: Choose Faction, Unique
	- description: Unlocks faction-specific choices: abilities, upgrades, modules.
	- Omega
	- Alpha
	- Beta
- `member:<UUID>:extra_hp` + 4 Hearts Base HP
- (after lvl 10) [EPIC] Get Drone (max 9) Allays which are equipable and can do stuff for you.
	- All tools, enchantments buffs, everything which is applicable to a player, can also be applicable to an Allay. They swarm around you when idle, and when activated (this is togglable item in the hotbar) they do whatever they have equipped. If they have a Skill equipped, they do that skill. For instance if there's a tree nearby and they're a lumberjack, they'll have the axe in their hand and chop down nearby trees. They have a sphere of influence for status effects which affect all players. They have a health bar and can get damaged. The player should be able to repair them in the Drone Factory.
- [LEGENDARY] Map Expansion (selection of; go into spectate mode to select one.)
- [EPIC] New Structures/Compartiments (When generated they are in decayed form, spawning a dungeon of mobs until claimed); they need to be captured. These should be generated and places into the worlds city in a place which isn't occupied yet, placing them somewhat near each-other.
	- Farm areas
	- [LEGENDARY] Unlock 4-hourly Crate [stackable up to 5]
	- Enchanting Area; Unlocks custom enchantments
	- [Garanteed at lvl 10, and random afterwards if not unlocked] Unique Drone Factory
- [RARE] Botany X + 1: Increased Tree/Crop growth ; can be increased 
- Unlock Skill (decreases effect of other traits. the more traits you have, but certain effects and enchantments scale with number of skills you have.)
	- Lumberjack
	- Fishing
- Unlock Ores
	- (Usual Ores too) Copper, Cobalt, Strontium, Amethyst, Uranium, Iridium, Francium, ...
- Unlock Trees (create like ores a list of how valueable each tree-type is.)
- Unlock Honey; randomly scattered around trees, (which will then become unbreakable); the drones dont target these trees anymore.
- Unlock Recipes
	- Craft Suits from Ores.
	- Pickaxe upgrade, by crafting with the existing pickaxe.
- Unlock Items
- Unlock Questlines
	- Generate like types of quests in SkyBlock's style.
- Backpack; Better bundles. These are bundles which allow increased stacking if we can enable that, so that more than 64 items go in those bags.

- Empower weapons with ores for some duration.

Like the greenbook recipes system, the player should have an item in their inventory for all the things they have seen and unlocked in a specific run, that way they can navigate recipes, see why and how certain mechanics works. (Like the fact that the Drone Factory unlocks and is garanteed at lvl 10) etc..

Shop
Monetary system is Credits like Survival.

- Buy Keys: Crates
- Buy Enchantments (very expensive, selective)
- Buy experience bottles (faster progression)
- Buy Recipes
- Upgrade enchantment to Module with money.
- Remove enchantment from tool.

Crates
- Get level-up triggers from crates with different percentages towards the rarities. Different crates have different rate drops.

Drone Modules
- Collect Module
- Skill Module
- Enchantment Module
- Combat Module
- Shield Module
- Inspire Module (more attack if they're nearby)
- -> Like I said everything that can be put on a player can be put on a drone and then has an effect. Certain things can only be put on drones.
Drone Repairing
- Based on the types of modules used on the drone different ores are required to repair a drone if damaged.
Removing Modules from Drones
- Removing modules from drones is costly, but you can do so using ores; depending on what is currently on the drone tells you how much it will cost. It will always have to do with what was put there in the first place, its recipe costs etc.

Add FoG to server selector, in the description is should list; Galactic Prison Planet, Prison/SkyBlock themes.
Make sure to translate everything into dutch as well, use the translation files for every message.

Abilities/Enchantments
- Scale by the number of skills you've unlocked. ?
- Combat
	- Absorption; Shield Generator only regens out of comabt, but regens fast.
	- Rain arrows from above
	- Shield: 
- Axe
	- Chop down whole tree.
- Homing Arrow launcher
	- Automatic homing arrow launchers

- Expand region being expand

Quests
- Collect X
- Defeat X
- What else?
Gain experience, specific items etc..

On first join the player is teleported into a freshly generated world for them creative-style, a random location is chosen, the player is teleported there. It has to be a location where there's a big cave, and the biome is randomized, so not sure how taht would work but maybe use /locate to a big cave. Then the player is floating in the air, jsut like when choosing a level, and the options are "Start a new Run", "Join someone else's run" in the same style as the level up, but then those two. Underneath him the world for his new run is already being generated, generating a city-like wall around the premises where the player is allowed to explore pre-map upgrades. Map upgrades- expand this area, and then of course generate the area accordingly. You also gain an item in your hotbar whenever you to change to a different run. Your inventory and everything should be stored in the store with serialized nms and everything so that when you switch to a different run you get all your items back properly and in the right place.

When you start a new run, you're instantly confronted with a Lvl 0 challenge choice. You can pick the one of three.

Your level should just like KitPvP be shared in the chat and reflected in the experience bar. No other experience can be allowed to change this experience, but ofc we keep track of the experience separately too.

You cannot drop the custom items.

During the time that there are members online, there are Raids, they show up as raids in the top bar as well, using like the number of stuff still required to kill as the progressive healthbar. They change/increase in difficulty depending on the level. The amount of players online and their level respectively goes into this calculation.

Mobs have a sphere of influence, based on nearby players their difficulty goes up/down. Lower-level players increase the mobs difficulty less than higher-level players.
Enemies

**

Fire undead mage throws fire balls 4 sec cd at you from a distance that do aoe dmg and leave a lingering fire on the slowing field (goes away once the slowing field is gone as well). While walking it leaves behind a fire trail that lingers for 10 seconds. Explodes on death

Debuff undead mage who throws a lingering slow field for 30 seconds and can recast it every 20 seconds (so eventually everything could be slowed) throws a withering skull towards you if it hits get the withering effect for 1 seconds 5 sec cd. 

Zombies if a zombie attacks you you have a chance to get the hunger debuff if your food bar is completely empty you can't run for a couple of seconds before it recharges.

  
  

Bull charges at you knocking you up in the air if it hits you

Bee flies towards you and tries to sting you. The sting has a chance of poisoning you for 2 seconds


Undead knight (first boss)

every 30 seconds summons a random undead mage

Every 15 seconds he will summon 2 zombies if below 75% its 3 below 50% 4 and below 25% 5 (please note that the zombies can not be hit by any attacks or abilities from other enemies like the undead mages or the undead knight)

Every 10 seconds pulls all enemies in front of him towards him make the area shown where he is going to attack so that if youre fast enough you can dodge this

Uses melee attacks 

If he is below 50% hp he will randomly charge towards someone knocking them up into the air

Once he is below 25% hp he will do so again and continue to do so every 15 seconds


For the generated parts of the maps, just generate nice placeholders ideas for now well create something nice to use later.

Be sure to ask as many questions as you want at any stage of the process, this is a big project, so let's get a proof of concept working. Feel free to take some liberties to add some ideas here and there.

---

Also the difficulty selection after hitting start a new run in the same way. (1) place it in com.orbitmines.minecraft.spigot.servers.fog (2) It is the creator/owner, permadeath is per-player so others can still keep playing. Allow people to keep spectating the runs if they wish as gamemode spectator (Alsoa dd an item for that to join other worlds as spectator from a list of online players or a command like /world [PLAYER], selecting their active run). (3)No do proper cave-scoring I want the base situated above a big cave. We could also search for this while the player is still choosing gamemode etc.. It's not that bad for it to take a little bit, just tell the player the world is being prepared for them, then generate the base. (4) Yes Normal, Hard and Hardcore. (5) Exactly crates push tracked XP. (6) Do everything in code for now. (7) English is the main which you'll generate, dutch is just a side translation. ()


---

/
Rogue like game thing
How does the game work

Core gameplay
After every level up you can choose between 1 of 3 temporary upgrades/buffs which will be lost upon dying or prestiging 

Prestige at Lvl 100


---

- Prison gamemode generate worlds with certain features. ? Mathematical way of doing this? Or using /locate things like that.
- Survival/creative/lobbies claims new events
- javelin attack speed noticed somewhere


- version in glass packets sent? not laggy?
- Specific chaces to drop some item, as enchant

---

Raid boss for fun team pve which rewards the players with coins consumables as well as items used to unlock a new kit and items to upgrade a kit each kit requires different items those upgrades can be small for example +2 hearts (1 full heart) 
How the raid boss works
Each person gets rewards if they contribute at least a certain amount and if they contribute a lot they get some extra rewards or higher chance of getting better loot
There are multiple phases of the riad boss so it will do different moves depending on the hp threshold 
Monthly/weekly rotation of the raid bosses which give different rewards to keep the playbase from having reasons to check back

---
Survival
- Lobby eating should be allowed.
- 

--- 
Kitpvp

- M1903 Springfield Soldier texture pack
- Full invis for wizard
- /spawn out of combat
- Grim Reaper damage insane, (bleed probably)
- golem heals
- streak effects unlock with levels, masteries back
- Cyclone still destroys map
- ]ENchanter info that it gets random item from each class.
- Boots not in kit selector?
- Anti-cheat
- 1. zou t mogelijk zijn dat je mij in de toekomst een item kan geven wat 0 attack heeft maar een bleed effect wil dat effect namelijk testen aan gezien jente gisteren zij dat bleed veel dmg doet --> items with custom enchants give to others. or on current held and allow to drop in opmode. (mayb ein creative, with a /survival)


Add bots that fight others in the kitpvp arena so that even if no one else is online people can still play kitpvp of course the rewards of killing such bots should be lower than killing actual players and only give coins no xp and they dont help with quests bots can spawn with any kit

Instead of using hearts use health where it says in numbers so for example 100 and thats how much health you have then you can write on every weapon easily how much damage that they do as well as with defense add numbers to it as well to make it easily seen by people hey he has that much defense which can also mean you have 100 armour normally but against ranged attacks its 150 for example etc.

After getting a kill heal instantly 2 full hearts and give reduce dmg taken by 10% for 1 second to reduce cleaning a bit but not stop it

Add consumables to the shop to spend coins for example a hp pot but add cooldown on those consumables and you can only carry 2 at the same time before having to purchase them again

Add temporary buffs to specific kits for coins for example with archer reduce the arrow regain by 1 second 
Can also be generic for example if you are 10 seconds out of combat for this life you get an extra little bit of regeneration or can be to get a small xp and coin boost for a couple of minutes/1 life

---



Add weekly quests

Add custom texture pack to make it very easy for everyone to see which kit the other person is using 

Add a rotating maps so that every week there is a new map which people pvp on

Give tree (the kit) 5% knockback resist it doesnt make sense why a tree doesnt have knockback resist

Add a prestige option based on account level to kitpvp which will unlock new things mainly cosmetics that can be bought or buffs/consumables people can buy can only be bought from a certain prestige onward it can also give other rewards for example getting a triple kill (killing 3 people within a certain timer) will give you health regen the way to unlock this is by prestigeing but it resets all kits purchased/upgraded
Add a prestige option based on kit xp where you have to do certain challenges with the kit as well inorder to be capable of prestigeing a specific kit this will not bring any benefits just cosmetics do note that the kit prestige does not reset by prestigeing your account

Add a 1v1 game mode add an option so that the player can choose if their winrates are public or not and keep all the other data private like winrate of kits etc. so that better balancing decisions can be made

Weekend events 
Juggernaut every 30 min 1 person will randomly become the juggernaut if there is no other juggernaut
they get increased health regen good armour with some projectile protection high dmg melee weapon but slower attack speed
If someone kills the juggernaut they get increased xp and coins

make it so that all the kits are sorted based on price so its easier for players to know what the price of kits are maybe make kits shiny of the player can buy m or something just for quality of life