import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * This world is one of many in this game.
 * 
 * @author (Ben Presley), Anthony Neeser
 * @version (5/8/2018)
 */
public class World8 extends World
{
    private boolean angry;
    private int bX;
    private int bY;
    public static int archerCount = 2;
    public static int spearmanCount = 3;
    public static int blackKnightCount = 0;
    public static int fighterCount = 0;
    /**
     * Constructor for objects of class World8.
     * 
     */
    public World8()
    {
        super(1080, 920, 1); 
        
        MainWorld.topWorldID = 3;
        MainWorld.leftWorldID = 7;
        MainWorld.rightWorldID =9;
        MainWorld.bottomWorldID = 13;
        prepare();
        setup();
        spawnPlayer();
        setPaintOrder(InstructionParts.class, Icons.class, DialogParts.class, MusicButton.class, Treetop.class, Player.class, 
            JimboSubSystem.class, MattsSubSystem.class, Loot.class, Treebase.class, Shadow.class, BG.class, Barrier.class, ShopDoorExit.class);
    }

    /**
     * Controls the spawning position of player when transfering worlds.
     */
    public void spawnPlayer()
    {
        //Add player back to world when returning from shop world
        if (MainWorld.spawn == 8)
        {
            Player hawthorne = new Player();
            addObject(hawthorne, MainWorld.playerX,MainWorld.playerY);
        }
        MainWorld.state = 1;
    }
    
    /**
     * Upon starting the game, or if Player dies, this handles resetting the world to the starting zone. States are also set to initial values.
     */
    public void reset()
    {
        if(MainWorld.start == 0)
        {
            Greenfoot.setWorld(new World6());
        }
    }
    
    /**
     * Monitor world state.
     */
    public void act()
    {
        reset();
        archerCount = getObjects(Archer.class).size();
        spearmanCount = getObjects(Spearman.class).size();
        blackKnightCount = getObjects(BlackKnight.class).size();
        fighterCount = getObjects(Fighter.class).size();
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

    private void prepare()
    {
        SilverChest silverchest = new SilverChest(52, 52);
        addObject(silverchest, 275, 435);
        World8BG world8bg = new World8BG();
        addObject(world8bg,571,455);
        world8bg.setLocation(549,474);
        world8bg.setLocation(541,457);
        world8bg.setLocation(541,459);
        world8bg.setLocation(541,460);
        Treebase treebase = new Treebase();
        addObject(treebase,1018,154);
        Treetop treetop = new Treetop();
        addObject(treetop,1027,99);
        treetop.setLocation(1014,65);
        Treebase treebase2 = new Treebase();
        addObject(treebase2,747,87);
        Treetop treetop2 = new Treetop();
        addObject(treetop2,751,29);
        treetop2.setLocation(751,29);
        treetop2.setLocation(751,29);
        treetop2.setLocation(744,2);
        treebase2.setLocation(749,90);
        Treetop treetop3 = new Treetop();
        addObject(treetop3,903,73);
        treetop3.setLocation(903,73);
        treetop3.setLocation(903,73);
        treetop3.setLocation(899,3);
        Treebase treebase3 = new Treebase();
        addObject(treebase3,918,116);
        treebase3.setLocation(903,92);
        Treetop treetop4 = new Treetop();
        addObject(treetop4,254,36);
        treetop4.setLocation(254,36);
        treetop4.setLocation(248,32);
        Treebase treebase4 = new Treebase();
        addObject(treebase4,256,117);
        treebase4.setLocation(251,120);
        Barrier barrier49 = new Barrier();
        addObject(barrier49,255,118);
        Barrier barrier50 = new Barrier();
        addObject(barrier50,755,84);
        Barrier barrier51 = new Barrier();
        addObject(barrier51,909,76);
        Barrier barrier52 = new Barrier();
        addObject(barrier52,1026,144);
        Crow crow = new Crow();
        addObject(crow,206,314);
        removeObject(crow);
        Cow cow = new Cow();
        addObject(cow,219,325);
        Cow cow2 = new Cow();
        addObject(cow2,346,584);
        Pig pig = new Pig();
        addObject(pig,382,391);
        Crow crow2 = new Crow();
        addObject(crow2,857,187);
        crow2.setLocation(850,172);
        crow2.setLocation(841,174);
        Barrier barrier5 = new Barrier();
        addObject(barrier5,828,199);
        Barrier barrier6 = new Barrier();
        addObject(barrier6,400,841);
        barrier6.setLocation(394,836);
        Barrier barrier7 = new Barrier();
        addObject(barrier7,950,701);
        barrier7.setLocation(945,671);
        Barrier barrier8 = new Barrier();
        addObject(barrier8,946,754);
        barrier8.setLocation(946,745);
        Barrier barrier9 = new Barrier();
        addObject(barrier9,944,824);
        Barrier barrier10 = new Barrier();
        addObject(barrier10,948,898);
        Barrier barrier11 = new Barrier();
        addObject(barrier11,101,417);
        Barrier barrier12 = new Barrier();
        addObject(barrier12,93,344);
        Barrier barrier13 = new Barrier();
        addObject(barrier13,98,284);
        Barrier barrier14 = new Barrier();
        addObject(barrier14,95,221);
        Barrier barrier15 = new Barrier();
        addObject(barrier15,141,166);
        Barrier barrier16 = new Barrier();
        addObject(barrier16,206,174);
        Barrier barrier17 = new Barrier();
        addObject(barrier17,268,173);
        Barrier barrier18 = new Barrier();
        addObject(barrier18,335,170);
        Barrier barrier19 = new Barrier();
        addObject(barrier19,394,175);
        Barrier barrier20 = new Barrier();
        addObject(barrier20,457,167);
        Barrier barrier21 = new Barrier();
        addObject(barrier21,478,245);
        Barrier barrier22 = new Barrier();
        addObject(barrier22,479,300);
        Barrier barrier23 = new Barrier();
        addObject(barrier23,478,367);
        Barrier barrier24 = new Barrier();
        addObject(barrier24,477,433);
        Barrier barrier25 = new Barrier();
        addObject(barrier25,487,506);
        Barrier barrier26 = new Barrier();
        addObject(barrier26,482,571);
        Barrier barrier27 = new Barrier();
        addObject(barrier27,483,648);
        Barrier barrier28 = new Barrier();
        addObject(barrier28,446,705);
        Barrier barrier29 = new Barrier();
        addObject(barrier29,395,715);
        Barrier barrier30 = new Barrier();
        addObject(barrier30,336,704);
        Barrier barrier31 = new Barrier();
        addObject(barrier31,275,710);
        Barrier barrier32 = new Barrier();
        addObject(barrier32,224,706);
        Barrier barrier33 = new Barrier();
        addObject(barrier33,149,709);
        Barrier barrier34 = new Barrier();
        addObject(barrier34,97,711);
        Barrier barrier35 = new Barrier();
        addObject(barrier35,83,653);
        Barrier barrier36 = new Barrier();
        addObject(barrier36,96,603);
        barrier11.setLocation(106,394);
        barrier12.setLocation(104,333);
        barrier13.setLocation(105,278);
        barrier14.setLocation(104,218);
        barrier15.setLocation(123,157);
        barrier16.setLocation(195,155);
        barrier17.setLocation(259,157);
        barrier18.setLocation(333,155);
        barrier19.setLocation(393,155);
        barrier20.setLocation(468,166);
        barrier21.setLocation(477,237);
        barrier22.setLocation(478,297);
        barrier25.setLocation(478,505);
        barrier26.setLocation(479,575);
        barrier27.setLocation(478,646);
        barrier28.setLocation(443,700);
        barrier29.setLocation(394,698);
        barrier30.setLocation(336,699);
        barrier31.setLocation(272,700);
        barrier32.setLocation(224,702);
        barrier33.setLocation(162,702);
        barrier34.setLocation(102,699);
        barrier35.setLocation(103,649);
        barrier36.setLocation(106,580);
        barrier29.setLocation(393,690);
        barrier28.setLocation(445,687);
        barrier30.setLocation(333,694);
    }
}
