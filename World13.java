import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * This world is one of many in this game.
 * 
 * @author (Ben Presley), Anthony Neeser
 * @version (5/8/2018)
 */
public class World13 extends World
{
    private boolean angry;
    private int bX;
    private int bY;
    public static int archerCount = 3;
    public static int spearmanCount = 0;
    public static int blackKnightCount = 0;
    public static int fighterCount = 0;
    /**
     * Constructor for objects of class World13.
     * 
     */
    public World13()
    {
        super(1080, 920, 1); 
        MainWorld.topWorldID = 8;
        MainWorld.leftWorldID = 12;
        MainWorld.rightWorldID =14;
        MainWorld.bottomWorldID = 18;
        prepare();
        setup();
        spawnPlayer();
        setPaintOrder(/*Barrier.class*/ InstructionParts.class, Icons.class, DialogParts.class, MusicButton.class, Treetop.class, Player.class, Sign.class, JimboSubSystem.class, MattsSubSystem.class, Loot.class, Treebase.class, Shadow.class, BG.class, Barrier.class, ShopDoorExit.class);
    }

    /**
     * Controls the spawning position of player when transfering worlds.
     */
    public void spawnPlayer()
    {
        if (MainWorld.spawn == 13)
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

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        World13BG world13bg = new World13BG();
        addObject(world13bg,572,467);
        world13bg.setLocation(540,460);
        
        SilverChest silverchest = new SilverChest(52, 52);
        addObject(silverchest, 255, 825);
        Barrier barrier42 = new Barrier();
        addObject(barrier42, 963, 187);
        Barrier barrier43 = new Barrier();
        addObject(barrier43, 1017, 187);
        Barrier barrier44 = new Barrier();
        addObject(barrier44, 1064, 187);
        Sign sign = new Sign();
        addObject(sign,960,175);
        Treebase treebase = new Treebase();
        addObject(treebase,325,596);
        Treetop treetop = new Treetop();
        addObject(treetop,325,538);
        treetop.setLocation(324,508);
        Treetop treetop2 = new Treetop();
        addObject(treetop2,417,578);
        treetop2.setLocation(407,536);
        Treebase treebase2 = new Treebase();
        addObject(treebase2,418,623);
        treebase2.setLocation(408,625);
        Treetop treetop3 = new Treetop();
        addObject(treetop3,177,538);
        treetop3.setLocation(181,515);
        Treebase treebase3 = new Treebase();
        addObject(treebase3,188,597);
        treebase3.setLocation(182,604);
        Treetop treetop4 = new Treetop();
        addObject(treetop4,118,585);
        treetop4.setLocation(128,558);
        Treebase treebase4 = new Treebase();
        addObject(treebase4,134,638);
        treebase4.setLocation(130,647);
        Treetop treetop5 = new Treetop();
        addObject(treetop5,216,631);
        treetop5.setLocation(206,600);
        Treebase treebase5 = new Treebase();
        addObject(treebase5,208,685);
        treebase5.setLocation(206,689);
        Barrier barrier = new Barrier();
        addObject(barrier,179,574);
        Barrier barrier2 = new Barrier();
        addObject(barrier2,208,684);
        treebase5.setLocation(207,689);
        treebase5.setLocation(344,713);
        barrier2.setLocation(134,625);
        treebase5.setLocation(209,688);
        Barrier barrier3 = new Barrier();
        addObject(barrier3,340,764);
        barrier3.setLocation(209,665);
        Barrier barrier4 = new Barrier();
        addObject(barrier4,328,686);
        barrier4.setLocation(334,575);
        Barrier barrier5 = new Barrier();
        addObject(barrier5,412,706);
        barrier5.setLocation(406,601);
        Treetop treetop6 = new Treetop();
        addObject(treetop6,355,672);
        treetop6.setLocation(351,584);
        Treebase treebase6 = new Treebase();
        addObject(treebase6,354,674);
        treebase6.setLocation(353,673);
        Barrier barrier6 = new Barrier();
        addObject(barrier6,376,764);
        barrier6.setLocation(358,645);
        Treetop treetop7 = new Treetop();
        addObject(treetop7,408,722);
        treetop7.setLocation(416,598);
        Treebase treebase7 = new Treebase();
        addObject(treebase7,436,740);
        treebase7.setLocation(419,687);
        Barrier barrier7 = new Barrier();
        addObject(barrier7,366,800);
        barrier7.setLocation(413,660);
        Treetop treetop8 = new Treetop();
        addObject(treetop8,57,626);
        treetop8.setLocation(47,571);
        Treebase treebase8 = new Treebase();
        addObject(treebase8,45,672);
        treebase8.setLocation(50,660);
        Barrier barrier8 = new Barrier();
        addObject(barrier8,41,765);
        barrier8.setLocation(49,638);
        Treetop treetop9 = new Treetop();
        addObject(treetop9,126,700);
        treetop9.setLocation(123,622);
        Treebase treebase9 = new Treebase();
        addObject(treebase9,133,722);
        treebase9.setLocation(126,711);
        Barrier barrier9 = new Barrier();
        addObject(barrier9,130,795);
        barrier9.setLocation(128,685);
        Treetop treetop10 = new Treetop();
        addObject(treetop10,419,738);
        treetop10.setLocation(379,645);
        Treebase treebase10 = new Treebase();
        addObject(treebase10,389,780);
        treebase10.setLocation(380,734);
        Barrier barrier10 = new Barrier();
        addObject(barrier10,379,832);
        barrier10.setLocation(383,710);
        Treetop treetop11 = new Treetop();
        addObject(treetop11,170,772);
        treetop11.setLocation(187,642);
        Treebase treebase11 = new Treebase();
        addObject(treebase11,190,772);
        treebase11.setLocation(192,731);
        Barrier barrier11 = new Barrier();
        addObject(barrier11,237,832);
        barrier11.setLocation(190,702);
        Treetop treetop12 = new Treetop();
        addObject(treetop12,98,811);
        treetop12.setLocation(53,674);
        Treebase treebase12 = new Treebase();
        addObject(treebase12,49,776);
        treebase12.setLocation(55,763);
        Barrier barrier12 = new Barrier();
        addObject(barrier12,63,843);
        barrier12.setLocation(54,742);
        Treetop treetop13 = new Treetop();
        addObject(treetop13,47,864);
        treetop13.setLocation(75,794);
        Treebase treebase13 = new Treebase();
        addObject(treebase13,76,899);
        treebase13.setLocation(78,883);
        Barrier barrier13 = new Barrier();
        addObject(barrier13,174,877);
        barrier13.setLocation(77,865);
        Treetop treetop14 = new Treetop();
        addObject(treetop14,432,880);
        treetop14.setLocation(444,820);
        Treebase treebase14 = new Treebase();
        addObject(treebase14,461,912);
        treebase14.setLocation(446,908);
        Barrier barrier14 = new Barrier();
        addObject(barrier14,312,861);
        barrier14.setLocation(446,899);
        Barrier barrier15 = new Barrier();
        addObject(barrier15,580,900);
        barrier15.setLocation(580,895);
        Barrier barrier16 = new Barrier();
        addObject(barrier16,587,819);
        barrier16.setLocation(580,822);
        Barrier barrier17 = new Barrier();
        addObject(barrier17,594,758);
        barrier17.setLocation(580,747);
        Barrier barrier18 = new Barrier();
        addObject(barrier18,578,690);
        barrier18.setLocation(580,676);
        Barrier barrier19 = new Barrier();
        addObject(barrier19,649,665);
        barrier19.setLocation(638,675);
        barrier19.setLocation(637,676);
        Barrier barrier20 = new Barrier();
        addObject(barrier20,644,614);
        barrier20.setLocation(637,623);
        Barrier barrier21 = new Barrier();
        addObject(barrier21,712,616);
        barrier21.setLocation(706,623);
        Barrier barrier22 = new Barrier();
        addObject(barrier22,799,625);
        barrier22.setLocation(779,623);
        Barrier barrier23 = new Barrier();
        addObject(barrier23,871,618);
        barrier23.setLocation(853,623);
        Barrier barrier24 = new Barrier();
        addObject(barrier24,895,578);
        barrier24.setLocation(877,596);
        Barrier barrier25 = new Barrier();
        addObject(barrier25,917,567);
        barrier25.setLocation(901,561);
        Barrier barrier26 = new Barrier();
        addObject(barrier26,973,571);
        barrier26.setLocation(968,561);
        Barrier barrier27 = new Barrier();
        addObject(barrier27,1039,567);
        barrier27.setLocation(1026,561);
        Barrier barrier28 = new Barrier();
        addObject(barrier28,1043,627);
        barrier28.setLocation(1050,561);
        Barrier barrier29 = new Barrier();
        addObject(barrier29,1066,687);
        barrier29.setLocation(1055,657);
        Barrier barrier30 = new Barrier();
        addObject(barrier30,982,655);
        barrier30.setLocation(984,657);
        Barrier barrier31 = new Barrier();
        addObject(barrier31,926,661);
        barrier31.setLocation(924,655);
        Barrier barrier32 = new Barrier();
        addObject(barrier32,886,704);
        barrier32.setLocation(873,708);
        Barrier barrier33 = new Barrier();
        addObject(barrier33,890,787);
        barrier33.setLocation(873,769);
        Barrier barrier34 = new Barrier();
        addObject(barrier34,889,852);
        barrier34.setLocation(872,834);
        Barrier barrier35 = new Barrier();
        addObject(barrier35,883,892);
        barrier35.setLocation(872,889);
        Barrier barrier36 = new Barrier();
        addObject(barrier36,1050,135);
        barrier36.setLocation(1055,106);
        Barrier barrier37 = new Barrier();
        addObject(barrier37,994,110);
        barrier37.setLocation(988,106);
        Barrier barrier38 = new Barrier();
        addObject(barrier38,960,51);
        barrier38.setLocation(963,106);
        Barrier barrier39 = new Barrier();
        addObject(barrier39,958,35);
        barrier39.setLocation(961,38);
        Treetop treetop15 = new Treetop();
        addObject(treetop15,581,70);
        Treebase treebase15 = new Treebase();
        addObject(treebase15,591,179);
        treebase15.setLocation(582,159);
        Barrier barrier40 = new Barrier();
        addObject(barrier40,577,259);
        barrier40.setLocation(582,141);
        Treetop treetop16 = new Treetop();
        addObject(treetop16,142,127);
        Treebase treebase16 = new Treebase();
        addObject(treebase16,146,216);
        treebase16.setLocation(146,216);
        Barrier barrier41 = new Barrier();
        addObject(barrier41,155,333);
        barrier41.setLocation(146,198);
        barrier3.setLocation(201,665);
        barrier4.setLocation(342,572);
    }
}
