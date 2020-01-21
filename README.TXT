PROJECT TITLE: "King Orin's Quest"
PURPOSE OF PROJECT: Top-down world to show off what we have learned and what we are capable of.
VERSION or DATE: 1.0  5/10/2018
HOW TO START THIS PROJECT: Compile and run.
AUTHORS: The Four Horsemen
USER INSTRUCTIONS:
Movement:
 - Move Left with Left arrow or "a" keys.
 - Move Right with Right arrow or "d" keys.
 - Move Up with Up arrow or "w" keys.
 - Move Down with Down arrow or "s" keys.
 - Shoot arrows with "Space" key in the direction of your mouse cursor.
 - Click on NPC's or signs to interact with them.												 

 
 Subsystems:
 Guild's
	-DialogBox - For creating dialog boxes
	-BG - Superclass for background objects. 
		-MyWorldBG - MyWorld background object. 
	-Shadow - For generating shadows under NPCs
	-SpriteSheet - For easy cutting of Sprites to shape the worlds. (Removed from published build)
 
 Ben's:
	-BensSubSystem
		-Player - Playable character. Uses key input to walk around. 
		-WorldConstruct - Superclass of world buiding objects. 
			-Treetop - Top of tree
			-ShopDoorExit - Use to exit shop to MyWorld
			-ShopDoorEntrance - Use to enter shop from MyWorld
			-Cave1Entrance
			-Cave1Exit
			-Cave2Entrance
			-Cave2Exit
			-CastleEntrance
			-CastleExit
			-Barrier - Invisible object used to contain NPC and Player movement
			-Treebase - Tree trunk
		-MusicButton - mute and unmute music
		-Loot - Superclass of loot objects
			-Mushroom - loot object
			-HealthPotion - loot object
		-KingOrin
	-MainWorld - Superclass of worlds
		-ALL THE WORLDS ARE BELONG TO BEN

---------------------------------------------------------------------------------
Anthony Neeser:
-Overall completion of classes: 95%.
	- Need to implement magic on Player
	- Need to complete implementation of Inventory 
		- Need image for reference
	- Would like to add more generic dialog options in FriendlyNPC
		- Need imagination
	- Need 3 more sets of images to complete Player image changes
		- Linked to items in inventory. Images change based on active
		  items (sword, bow, armor suit). 
	- Need to implement melee enemy attacks
	- Need to implement Player sword attacks
-------------------------------------
Classes:
-Co-Writer of:   -Player.class
				 -ShopOwner.class
				 - All worlds (Ben Presley wrote and designed worlds, I added 
		  	       enemy loops and some functionality.) 

-------------------------------------
-Main writer of:   Sign.class
-------------------------------------

-Classes outside subsystem:
	Dialog.class
	|___DialogParts.class
		|___DialogBox.class
		|	|___PlayerDialogBox.class
		|	|___ShopDialogBox.class
		|	|___GenericWorldDialogBox.class
		|	|___WorldDialogBox.class
		|___DialogBorder.class
		|	|___InventoryBorder.class
		|	|___ShopDialogBorder.class
		|	|___WorldDialogBorder.class
		|	|___PlayerDialogBorder.class
		|	|___GenericWorldDialogBorder.class
		|___DialogText.class
			|___ShopDialog.class
			|___PlayerDialog.class
			|___GenericWorldDialog.class
			|___WorldDialog.class
	Shadow.class
	Gold.class
	Dead.class
	NPC2.class
	Icons.class (By Ben Presley)
	|___ShieldIcon.class
	|___SwordIcon.class
	|___BowIcon.class
	|___NoArmorIcon.class
	|___ManaPotionIcon.class
	|___ArrowsIcon.class
	|___HealthPotionIcon.class
	|___ArmorIcon.class
	|___SuitBorder.class
	|___WeaponBorder.class

-------------------------------------
-Subsystem:
	JimboSubSystem.class
	|___PlayerProjectiles.class
	|	|___PlayerArrow.class
	|___NPC.class
	|	|___EnemyNPC.class
	|	|	|___Melee.class
	|	|	|	|___BlackKnight.class
	|	|	|	|___Fighter.class
	|	|	|___Ranged.class
	|	|		|___Archer.class
	|	|		|___Spearman.class
	|	|___Animals.class
	|	|	|___Chicken.class
	|	|	|___Cow.class
	|	|	|___Pig.class
	|	|	|___Llama.class
	|	|	|___Crow.class
	|	|	|___Sheep.class
	|	|___FriendlyNPC.class
	|		|___Villager.class
	|			|___Jenny.class
	|			|___James.class
	|			|___Chloe.class
	|			|___Cindy.class	
	|			|___Knight.class
	|			|___Sasha.class
	|			|___Walter.class
	|			|___Villager1.class
	|			|___Villager2.class
	|			|___Villager3.class
	|			|___Villager4.class
	|			|___Villager5.class
	|			|___Villager6.class
	|			|___Villager7.class
	|			|___Villager8.class
	|			|___Villager9.class
	|			|___Villager10.class
	|			|___Villager11.class
	|			|___Villager12.class
	|___Projectiles
		|___Fireball.class
		|___Arrow.class
		|___Spear.class
		|___Iceball.class
---------------------------------------------------------------------------------

 Matt's
	- NPC2 - Copy of James' NPC to guide extraneous NPC movement and player interaction
	- Sign - To assign the different dialog between the different signs around all the worlds. (50%) - need to add more signs and more dialog for signs around the world.
		-ShopOwner - Shop owner. Future salesman. Offers items for purchase by player for gold. (initializeImages()) (100%)
		- GoldChest - Open the chest to obtain items including weapons, potions, or gold. (80%) - Need to add to more wo
			
CREDITS:
	Character sprite sheets created by DoubleLeggy
		https://doubleleggy.deviantart.com/
	Sprite Sheet cutter created by Game/Maniac (This was used in the creation of the worlds, but removed from build)
		http://www.greenfoot.org/scenarios/8502
	World assets created by Daniel Thomas.  Purchased on itch.io
		https://danielthomasart.itch.io/
	Soundtracks (Resolution and TheZone) by Homiku
		http://freemusicarchive.org/search/?sort=track_date_published&d=1&quicksearch=Komiku
	Pile of Coins image by Nolan, via www.engine001.com
		https://www.engine001.com/resources/Pile%20Of%20Coins_322.htm
	Gold Chest images by aweryn via Rpg Maker VX Resource planet
	https://vxresource.files.wordpress.com/2010/07/treasurechest01.png