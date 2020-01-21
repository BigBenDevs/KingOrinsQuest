import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * This world is one of many in this game.
 * 
 * @author (Ben Presley), Anthony Neeser
 * @version (5/8/2018)
 */
public class World6 extends World
{
    private boolean angry;
    private int bX;
    private int bY;
    public static int archerCount = 0;
    public static int spearmanCount = 0;
    public static int blackKnightCount = 0;
    public static int fighterCount = 0;
    private int instructions = 0;
    /**
     * Constructor for objects of class World6.
     * 
     */
    public World6()
    {    
        super(1080, 920, 1); 

        MainWorld.topWorldID = 1;
        MainWorld.leftWorldID = 99;
        MainWorld.rightWorldID = 7;
        MainWorld.bottomWorldID = 11;
        prepare();
        setup();
        spawnPlayer();
        setPaintOrder(InstructionParts.class, Icons.class, DialogParts.class, MusicButton.class, Treetop.class, Player.class, 
            JimboSubSystem.class, MattsSubSystem.class, Loot.class, Treebase.class, Shadow.class, BG.class, Barrier.class, ShopDoorExit.class);
    }

    /**
     * Controls the spawning position of player when transfering worlds.
     * "Backspace" world reset and game start name set by Anthony Neeser
     */
    public void spawnPlayer()
    {
        //Set player name at start of game
        if(MainWorld.nameSet == 0)
        {
            MainWorld.playerName = Greenfoot.ask("Enter your desired player name (Please limit to 13 characters to display properly):");
            MainWorld.nameSet = 1;
        }
        //Entering world 6 from adjacent worlds
        if (MainWorld.spawn == 6)
        {
            Player hawthorne = new Player();
            addObject(hawthorne, MainWorld.playerX,MainWorld.playerY);
        }
        //Add player into world on game start or after player death
        if (MainWorld.spawn == 0)
        {
            Player hawthorne = new Player();
            addObject(hawthorne, 260,755);
            MainWorld.spawn = 6;
        }
        //Spawn after "backspace"
        if (MainWorld.spawn == 99)
        {
            Player hawthorne = new Player();
            addObject(hawthorne, 260,755);
            MainWorld.spawn = 6;
        }
        //Returning from Town Shop
        if (MainWorld.spawn == 31)
        {
            Player hawthorne = new Player();
            addObject(hawthorne, 268,730);
        }
        MainWorld.state = 1;
    }

    /**
     * Upon starting the game, or if Player dies, this handles resetting the world to the starting zone. States are also set to initial values.
     */
    public void reset()
    {
        if(MainWorld.spawn == 0)
        {
            Greenfoot.setWorld(new World6());
        }
    }

    /**
     * Monitor world state.
     * @author Anthony Neeser
     */
    public void act()
    {
        reset();
        archerCount = getObjects(Archer.class).size();
        spearmanCount = getObjects(Spearman.class).size();
        blackKnightCount = getObjects(BlackKnight.class).size();
        fighterCount = getObjects(Fighter.class).size();
        if(instructions < 800)
        {
            showText("Press 'i' to view instructions", 540, 790);
        }
        else
        {
            showText(" ", 540, 790);
        }
        instructions++;
    }

    /**
     * Setup handles enemy generation away from barriers.
     * @author Anthony Neeser
     */
    private void setup()
    {
        List<Barrier> barriers = getObjects(Barrier.class);
        for(Barrier boundary : barriers)
        {
            bX = boundary.getX();
            bY = boundary.getY();
        }
        int a = 0;
        while(a < archerCount)
        {
            if(getObjectsAt(bX, bY, Barrier.class) != null)
            {
                if(Greenfoot.getRandomNumber(6) <= 2)
                {
                    angry = true;
                }
                int x = Greenfoot.getRandomNumber(450);
                int y = Greenfoot.getRandomNumber(450);
                addObject(new Archer(angry), x, y);
                a++;
            }
        }
        int b = 0;
        while(b < spearmanCount)
        {
            if(getObjectsAt(bX, bY, Barrier.class) != null)
            {
                if(Greenfoot.getRandomNumber(6) <= 2)
                {
                    angry = true;
                }
                int x = Greenfoot.getRandomNumber(450);
                int y = Greenfoot.getRandomNumber(450);
                addObject(new Spearman(angry), x, y);
                b++;
            }
        }
        int c = 0;
        while(c < blackKnightCount)
        {
            if(getObjectsAt(bX, bY, Barrier.class) != null)
            {
                if(Greenfoot.getRandomNumber(6) <= 2)
                {
                    angry = true;
                }
                int x = Greenfoot.getRandomNumber(450);
                int y = Greenfoot.getRandomNumber(450);
                addObject(new BlackKnight(angry), x, y);
                c++;
            }
        }
        int d = 0;
        while(d < fighterCount)
        {
            if(getObjectsAt(bX, bY, Barrier.class) != null)
            {
                if(Greenfoot.getRandomNumber(6) <= 2)
                {
                    angry = true;
                }
                int x = Greenfoot.getRandomNumber(450);
                int y = Greenfoot.getRandomNumber(450);
                addObject(new Fighter(angry), x, y);
                d++;
            }
        }
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        World6BG world6bg = new World6BG();
        addObject(world6bg,482,513);
        world6bg.setLocation(541,460);
        ShopDoorEntrance shopdoorentrance2 = new ShopDoorEntrance();
        addObject(shopdoorentrance2,268,673);
        Barrier barrier = new Barrier();
        addObject(barrier,903,648);
        barrier.setLocation(880,612);
        Barrier barrier2 = new Barrier();
        addObject(barrier2,956,613);
        Barrier barrier3 = new Barrier();
        addObject(barrier3,1026,612);
        Barrier barrier4 = new Barrier();
        addObject(barrier4,851,544);
        Barrier barrier5 = new Barrier();
        addObject(barrier5,833,479);
        Barrier barrier6 = new Barrier();
        addObject(barrier6,819,415);
        Barrier barrier7 = new Barrier();
        addObject(barrier7,835,352);
        Barrier barrier8 = new Barrier();
        addObject(barrier8,904,357);
        Barrier barrier9 = new Barrier();
        addObject(barrier9,963,357);
        Barrier barrier10 = new Barrier();
        addObject(barrier10,1032,357);
        Barrier barrier11 = new Barrier();
        addObject(barrier11,1069,358);
        Barrier barrier12 = new Barrier();
        addObject(barrier12,1060,429);
        Barrier barrier13 = new Barrier();
        addObject(barrier13,1060,487);
        Barrier barrier14 = new Barrier();
        addObject(barrier14,1059,532);
        Barrier barrier15 = new Barrier();
        addObject(barrier15,1066,593);
        Barrier barrier16 = new Barrier();
        addObject(barrier16,1067,613);
        Barrier barrier17 = new Barrier();
        addObject(barrier17,537,334);
        Barrier barrier18 = new Barrier();
        addObject(barrier18,551,400);
        Barrier barrier19 = new Barrier();
        addObject(barrier19,548,459);
        Barrier barrier20 = new Barrier();
        addObject(barrier20,542,510);
        Barrier barrier21 = new Barrier();
        addObject(barrier21,504,569);
        Barrier barrier22 = new Barrier();
        addObject(barrier22,502,603);
        Barrier barrier23 = new Barrier();
        addObject(barrier23,452,604);
        Barrier barrier24 = new Barrier();
        addObject(barrier24,440,647);
        Barrier barrier25 = new Barrier();
        addObject(barrier25,389,661);
        Barrier barrier26 = new Barrier();
        addObject(barrier26,353,666);
        Barrier barrier27 = new Barrier();
        addObject(barrier27,342,607);
        Barrier barrier28 = new Barrier();
        addObject(barrier28,277,595);
        Barrier barrier29 = new Barrier();
        addObject(barrier29,215,603);
        Barrier barrier30 = new Barrier();
        addObject(barrier30,186,669);
        Barrier barrier31 = new Barrier();
        addObject(barrier31,152,670);
        Barrier barrier32 = new Barrier();
        addObject(barrier32,153,616);
        Barrier barrier33 = new Barrier();
        addObject(barrier33,148,555);
        Barrier barrier34 = new Barrier();
        addObject(barrier34,143,504);
        Barrier barrier35 = new Barrier();
        addObject(barrier35,142,450);
        Barrier barrier36 = new Barrier();
        addObject(barrier36,144,394);
        Barrier barrier37 = new Barrier();
        addObject(barrier37,143,340);
        Barrier barrier38 = new Barrier();
        addObject(barrier38,146,285);
        Barrier barrier39 = new Barrier();
        addObject(barrier39,170,229);
        Barrier barrier40 = new Barrier();
        addObject(barrier40,210,195);
        Barrier barrier41 = new Barrier();
        addObject(barrier41,255,174);
        Barrier barrier42 = new Barrier();
        addObject(barrier42,310,197);
        Barrier barrier43 = new Barrier();
        addObject(barrier43,344,232);
        Barrier barrier44 = new Barrier();
        addObject(barrier44,382,275);
        Barrier barrier45 = new Barrier();
        addObject(barrier45,412,323);
        Barrier barrier46 = new Barrier();
        addObject(barrier46,478,333);
        Barrier barrier47 = new Barrier();
        addObject(barrier47,17,805);
        Barrier barrier48 = new Barrier();
        addObject(barrier48,17,749);
        Barrier barrier49 = new Barrier();
        addObject(barrier49,18,698);
        Barrier barrier50 = new Barrier();
        addObject(barrier50,19,649);
        Barrier barrier51 = new Barrier();
        addObject(barrier51,18,600);
        Barrier barrier52 = new Barrier();
        addObject(barrier52,20,541);
        Barrier barrier53 = new Barrier();
        addObject(barrier53,19,498);
        Barrier barrier54 = new Barrier();
        addObject(barrier54,17,449);
        Barrier barrier55 = new Barrier();
        addObject(barrier55,13,397);
        Barrier barrier56 = new Barrier();
        addObject(barrier56,10,344);
        Barrier barrier57 = new Barrier();
        addObject(barrier57,13,291);
        Barrier barrier58 = new Barrier();
        addObject(barrier58,14,238);
        Barrier barrier59 = new Barrier();
        addObject(barrier59,19,184);
        Barrier barrier60 = new Barrier();
        addObject(barrier60,22,124);
        Barrier barrier61 = new Barrier();
        addObject(barrier61,23,74);
        Barrier barrier62 = new Barrier();
        addObject(barrier62,16,23);
        Barrier barrier63 = new Barrier();
        addObject(barrier63,23,879);
        Barrier barrier64 = new Barrier();
        addObject(barrier64,26,913);
        Villager1 villager1 = new Villager1();
        addObject(villager1,559,166);
        Villager5 villager5 = new Villager5();
        addObject(villager5,794,816);
        Villager2 villager2 = new Villager2();
        addObject(villager2,1038,178);
        addObject(new Sasha(), 300, 750);
    }
}
