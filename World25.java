import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * This world is one of many in this game.
 * 
 * @author (Ben Presley), Anthony Neeser
 * @version (5/8/2018)
 */
public class World25 extends World
{
    private boolean angry;
    private int bX;
    private int bY;
    public static int archerCount = 0;
    public static int spearmanCount = 0;
    public static int blackKnightCount = 0;
    public static int fighterCount = 0;
    /**
     * Constructor for objects of class World25.
     * 
     */
    public World25()
    {    
        super(1080, 920, 1); 
        
        //IDs of surrounding Worlds
        MainWorld.topWorldID = 20;
        MainWorld.leftWorldID = 24;
        MainWorld.rightWorldID = 99;
        MainWorld.bottomWorldID = 99;
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
        if (MainWorld.spawn == 25)
        {
            Player hawthorne = new Player();
            addObject(hawthorne, MainWorld.playerX,MainWorld.playerY);
        }
        //Returning from OldManHouse
        if (MainWorld.spawn == 35)
        {
            Player hawthorne = new Player();
            addObject(hawthorne, 714,665);
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
        World25BG world25bg = new World25BG();
        addObject(world25bg,437,456);
        world25bg.setLocation(541,460);
        Treetop treetop = new Treetop();
        addObject(treetop,858,42);
        treetop.setLocation(858,42);
        treetop.setLocation(858,42);
        treetop.setLocation(858,42);
        treetop.setLocation(858,42);
        treetop.setLocation(858,42);
        treetop.setLocation(858,42);
        treetop.setLocation(858,42);
        treetop.setLocation(858,42);
        treetop.setLocation(869,2);
        Treebase treebase = new Treebase();
        addObject(treebase,876,103);
        treebase.setLocation(871,89);
        Treetop treetop2 = new Treetop();
        addObject(treetop2,990,84);
        treetop2.setLocation(947,34);
        treetop2.setLocation(1039,10);
        Treebase treebase2 = new Treebase();
        addObject(treebase2,1036,110);
        treebase2.setLocation(1041,98);
        treebase2.setLocation(1040,97);
        Treetop treetop3 = new Treetop();
        addObject(treetop3,946,57);
        treetop3.setLocation(952,41);
        Treebase treebase3 = new Treebase();
        addObject(treebase3,963,102);
        treebase3.setLocation(955,123);
        Treetop treetop4 = new Treetop();
        addObject(treetop4,997,167);
        treetop4.setLocation(993,114);
        Treebase treebase4 = new Treebase();
        addObject(treebase4,990,218);
        treebase4.setLocation(994,202);
        Treetop treetop5 = new Treetop();
        addObject(treetop5,1059,160);
        treetop5.setLocation(1060,122);
        Treetop treetop6 = new Treetop();
        addObject(treetop6,1037,229);
        treetop6.setLocation(1045,197);
        Treebase treebase5 = new Treebase();
        addObject(treebase5,1057,298);
        treebase5.setLocation(1050,285);
        Treetop treetop7 = new Treetop();
        addObject(treetop7,1053,325);
        treetop7.setLocation(1059,291);
        Treetop treetop8 = new Treetop();
        addObject(treetop8,1073,367);
        treetop8.setLocation(1070,365);
        Treetop treetop9 = new Treetop();
        addObject(treetop9,1043,440);
        treetop9.setLocation(1047,425);
        Treetop treetop10 = new Treetop();
        addObject(treetop10,1074,483);
        Treebase treebase6 = new Treebase();
        addObject(treebase6,1045,662);
        treebase6.setLocation(1048,513);
        Treetop treetop11 = new Treetop();
        addObject(treetop11,1062,606);
        treetop11.setLocation(1052,575);
        Treetop treetop12 = new Treetop();
        addObject(treetop12,1060,698);
        treetop12.setLocation(1053,656);
        Treetop treetop13 = new Treetop();
        addObject(treetop13,1071,724);
        Treebase treebase7 = new Treebase();
        addObject(treebase7,975,813);
        treebase7.setLocation(1051,740);
        Treetop treetop14 = new Treetop();
        addObject(treetop14,1033,845);
        treetop14.setLocation(1013,804);
        Treebase treebase8 = new Treebase();
        Treebase treebase9 = new Treebase();
        addObject(treebase9,1041,889);
        treebase9.setLocation(1063,813);
        Treetop treetop15 = new Treetop();
        addObject(treetop15,1017,878);
        treetop15.setLocation(1039,867);
        Treebase treebase10 = new Treebase();
        addObject(treebase10,880,873);
        treebase10.setLocation(1011,891);
        Treetop treetop16 = new Treetop();
        addObject(treetop16,886,809);
        treetop16.setLocation(921,800);
        Treetop treetop17 = new Treetop();
        addObject(treetop17,619,826);
        treetop17.setLocation(668,817);
        Treetop treetop18 = new Treetop();
        addObject(treetop18,523,843);
        Treetop treetop19 = new Treetop();
        addObject(treetop19,331,816);
        Treetop treetop20 = new Treetop();
        addObject(treetop20,240,612);
        Treetop treetop21 = new Treetop();
        addObject(treetop21,286,222);
        Treetop treetop22 = new Treetop();
        addObject(treetop22,177,124);
        Treetop treetop23 = new Treetop();
        addObject(treetop23,175,274);
        Treetop treetop24 = new Treetop();
        addObject(treetop24,769,848);
        Treetop treetop25 = new Treetop();
        addObject(treetop25,224,480);
        Treetop treetop26 = new Treetop();
        addObject(treetop26,417,849);
        Treetop treetop27 = new Treetop();
        addObject(treetop27,347,131);
        Treetop treetop28 = new Treetop();
        addObject(treetop28,726,832);
        Treetop treetop29 = new Treetop();
        addObject(treetop29,249,534);
        treetop29.setLocation(204,523);
        treetop20.setLocation(272,595);
        Treebase treebase11 = new Treebase();
        addObject(treebase11,201,622);
        treebase11.setLocation(205,610);
        Treetop treetop30 = new Treetop();
        addObject(treetop30,199,397);
        treetop30.setLocation(177,354);
        Treebase treebase12 = new Treebase();
        addObject(treebase12,187,446);
        treetop25.setLocation(228,484);
        treebase12.setLocation(178,439);
        Treebase treebase13 = new Treebase();
        addObject(treebase13,276,692);
        treebase13.setLocation(275,684);
        Treebase treebase14 = new Treebase();
        addObject(treebase14,286,896);
        treebase14.setLocation(334,903);
        Treebase treebase15 = new Treebase();
        addObject(treebase15,467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(467,794);
        treebase15.setLocation(418,918);
        Treebase treebase16 = new Treebase();
        addObject(treebase16,596,777);
        treebase16.setLocation(596,777);
        treebase16.setLocation(596,777);
        treebase16.setLocation(596,777);
        treebase16.setLocation(596,777);
        treebase16.setLocation(523,917);
        Treebase treebase17 = new Treebase();
        addObject(treebase17,663,907);
        treebase17.setLocation(669,903);
        Treebase treebase18 = new Treebase();
        addObject(treebase18,608,813);
        treebase18.setLocation(724,919);
        treetop24.setLocation(796,818);
        Treebase treebase19 = new Treebase();
        addObject(treebase19,804,913);
        treebase19.setLocation(799,901);
        Treebase treebase20 = new Treebase();
        addObject(treebase20,930,885);
        treebase20.setLocation(925,888);
        Treebase treebase21 = new Treebase();
        addObject(treebase21,289,325);
        treebase21.setLocation(286,310);
        Treebase treebase22 = new Treebase();
        addObject(treebase22,360,213);
        treebase22.setLocation(351,220);
        Treebase treebase23 = new Treebase();
        addObject(treebase23,182,207);
        treebase23.setLocation(182,211);
        Treetop treetop31 = new Treetop();
        addObject(treetop31,237,701);
        treetop31.setLocation(236,680);
        Treebase treebase24 = new Treebase();
        addObject(treebase24,246,767);
        treebase24.setLocation(239,767);
        Treetop treetop32 = new Treetop();
        addObject(treetop32,187,756);
        treetop32.setLocation(185,750);
        Treetop treetop33 = new Treetop();
        addObject(treetop33,260,784);
        treetop33.setLocation(267,806);
        Treebase treebase25 = new Treebase();
        addObject(treebase25,265,886);
        treebase25.setLocation(267,894);
        Treebase treebase26 = new Treebase();
        addObject(treebase26,180,833);
        treebase26.setLocation(187,838);
        Treetop treetop34 = new Treetop();
        addObject(treetop34,159,665);
        treetop34.setLocation(165,595);
        Treebase treebase27 = new Treebase();
        addObject(treebase27,154,682);
        treebase27.setLocation(167,681);
        Treetop treetop35 = new Treetop();
        addObject(treetop35,86,706);
        treetop35.setLocation(94,702);
        Treebase treebase28 = new Treebase();
        addObject(treebase28,88,802);
        treebase28.setLocation(95,788);
        Treetop treetop36 = new Treetop();
        addObject(treetop36,114,802);
        treetop36.setLocation(113,796);
        Treebase treebase29 = new Treebase();
        addObject(treebase29,102,880);
        treebase29.setLocation(114,885);
        treebase29.setLocation(114,885);
        Treetop treetop37 = new Treetop();
        addObject(treetop37,55,879);
        treetop37.setLocation(44,871);
        Treetop treetop38 = new Treetop();
        addObject(treetop38,31,713);
        treetop38.setLocation(33,723);
        Treebase treebase30 = new Treebase();
        addObject(treebase30,406,730);
        treebase30.setLocation(32,810);
        Treetop treetop39 = new Treetop();
        addObject(treetop39,153,475);
        treetop39.setLocation(141,427);
        Treebase treebase31 = new Treebase();
        addObject(treebase31,90,549);
        treebase31.setLocation(142,516);
        Treetop treetop40 = new Treetop();
        addObject(treetop40,259,320);
        treetop40.setLocation(259,300);
        Treebase treebase32 = new Treebase();
        addObject(treebase32,295,400);
        treebase32.setLocation(260,388);
        Treetop treetop41 = new Treetop();
        addObject(treetop41,72,97);
        treetop41.setLocation(89,60);
        Treebase treebase33 = new Treebase();
        addObject(treebase33,63,152);
        treebase33.setLocation(91,147);
        Treetop treetop42 = new Treetop();
        addObject(treetop42,264,51);
        treetop42.setLocation(264,45);
        Treebase treebase34 = new Treebase();
        addObject(treebase34,248,142);
        treebase34.setLocation(263,133);
        treetop42.setLocation(260,47);
        OldManHouseEntrance oldmanhouseentrance = new OldManHouseEntrance();
        addObject(oldmanhouseentrance,714,609);
        Barrier barrier = new Barrier();
        addObject(barrier,612,629);
        barrier.setLocation(622,617);
        Barrier barrier2 = new Barrier();
        addObject(barrier2,604,559);
        barrier.setLocation(605,616);
        barrier2.setLocation(624,614);
        Barrier barrier3 = new Barrier();
        addObject(barrier3,802,618);
        barrier3.setLocation(793,614);
        Barrier barrier4 = new Barrier();
        addObject(barrier4,812,614);
        barrier4.setLocation(814,614);
        Barrier barrier5 = new Barrier();
        addObject(barrier5,808,531);
        barrier5.setLocation(815,538);
        Barrier barrier6 = new Barrier();
        addObject(barrier6,747,529);
        barrier6.setLocation(746,539);
        Barrier barrier7 = new Barrier();
        addObject(barrier7,664,542);
        barrier7.setLocation(674,539);
        Barrier barrier8 = new Barrier();
        addObject(barrier8,600,545);
        barrier8.setLocation(606,541);
        Barrier barrier9 = new Barrier();
        addObject(barrier9,614,473);
        barrier9.setLocation(607,464);
        Barrier barrier10 = new Barrier();
        addObject(barrier10,686,464);
        barrier9.setLocation(607,467);
        barrier10.setLocation(595,391);
        barrier9.setLocation(592,468);
        barrier10.setLocation(591,392);
        Barrier barrier11 = new Barrier();
        addObject(barrier11,584,320);
        barrier11.setLocation(591,317);
        Barrier barrier12 = new Barrier();
        addObject(barrier12,595,262);
        barrier12.setLocation(589,261);
        Barrier barrier13 = new Barrier();
        addObject(barrier13,654,232);
        barrier13.setLocation(640,220);
        Barrier barrier14 = new Barrier();
        addObject(barrier14,690,180);
        Barrier barrier15 = new Barrier();
        addObject(barrier15,760,192);
        barrier15.setLocation(738,186);
        barrier14.setLocation(694,176);
        barrier15.setLocation(751,204);
        Barrier barrier16 = new Barrier();
        addObject(barrier16,810,237);
        barrier16.setLocation(792,242);
        Barrier barrier17 = new Barrier();
        addObject(barrier17,837,281);
        barrier17.setLocation(832,287);
        Barrier barrier18 = new Barrier();
        addObject(barrier18,844,361);
        barrier18.setLocation(832,360);
        Barrier barrier19 = new Barrier();
        addObject(barrier19,830,434);
        barrier19.setLocation(832,430);
        Barrier barrier20 = new Barrier();
        addObject(barrier20,838,485);
        barrier20.setLocation(830,502);
        Barrier barrier21 = new Barrier();
        addObject(barrier21,884,64);
        barrier21.setLocation(870,40);
        Barrier barrier22 = new Barrier();
        addObject(barrier22,932,62);
        barrier22.setLocation(946,56);
        Barrier barrier23 = new Barrier();
        addObject(barrier23,988,116);
        barrier23.setLocation(978,110);
        Barrier barrier24 = new Barrier();
        addObject(barrier24,1000,155);
        Barrier barrier25 = new Barrier();
        addObject(barrier25,1032,198);
        Barrier barrier26 = new Barrier();
        addObject(barrier26,1056,265);
        Barrier barrier27 = new Barrier();
        addObject(barrier27,1054,336);
        Barrier barrier28 = new Barrier();
        addObject(barrier28,1060,418);
        barrier28.setLocation(1054,411);
        Barrier barrier29 = new Barrier();
        addObject(barrier29,1066,516);
        barrier29.setLocation(1054,484);
        Barrier barrier30 = new Barrier();
        addObject(barrier30,1063,583);
        barrier30.setLocation(1054,559);
        Barrier barrier31 = new Barrier();
        addObject(barrier31,1053,637);
        barrier31.setLocation(1052,631);
        barrier31.setLocation(1054,632);
        Barrier barrier32 = new Barrier();
        addObject(barrier32,1064,706);
        barrier32.setLocation(1052,707);
        Barrier barrier33 = new Barrier();
        addObject(barrier33,1044,786);
        barrier33.setLocation(1050,783);
        Barrier barrier34 = new Barrier();
        addObject(barrier34,995,816);
        barrier34.setLocation(996,814);
        Barrier barrier35 = new Barrier();
        addObject(barrier35,937,813);
        barrier35.setLocation(920,814);
        Barrier barrier36 = new Barrier();
        addObject(barrier36,853,829);
        barrier36.setLocation(852,818);
        Barrier barrier37 = new Barrier();
        addObject(barrier37,803,822);
        barrier37.setLocation(783,819);
        Barrier barrier38 = new Barrier();
        addObject(barrier38,702,820);
        barrier38.setLocation(715,820);
        Barrier barrier39 = new Barrier();
        addObject(barrier39,659,820);
        barrier39.setLocation(648,820);
        Barrier barrier40 = new Barrier();
        addObject(barrier40,572,837);
        barrier40.setLocation(574,820);
        Barrier barrier41 = new Barrier();
        addObject(barrier41,496,825);
        barrier41.setLocation(498,820);
        Barrier barrier42 = new Barrier();
        addObject(barrier42,409,818);
        barrier42.setLocation(424,820);
        Barrier barrier43 = new Barrier();
        addObject(barrier43,354,829);
        barrier43.setLocation(353,820);
        Barrier barrier44 = new Barrier();
        addObject(barrier44,286,808);
        Barrier barrier45 = new Barrier();
        addObject(barrier45,244,746);
        barrier45.setLocation(242,747);
        Barrier barrier46 = new Barrier();
        addObject(barrier46,251,658);
        barrier46.setLocation(245,672);
        Barrier barrier47 = new Barrier();
        addObject(barrier47,276,600);
        barrier47.setLocation(267,602);
        Barrier barrier48 = new Barrier();
        addObject(barrier48,221,532);
        barrier48.setLocation(236,526);
        Barrier barrier49 = new Barrier();
        addObject(barrier49,199,450);
        barrier49.setLocation(195,452);
        Barrier barrier50 = new Barrier();
        addObject(barrier50,210,387);
        barrier50.setLocation(198,376);
        Barrier barrier51 = new Barrier();
        addObject(barrier51,258,347);
        barrier51.setLocation(252,334);
        Barrier barrier52 = new Barrier();
        addObject(barrier52,281,276);
        barrier52.setLocation(277,276);
        Barrier barrier53 = new Barrier();
        addObject(barrier53,322,212);
        barrier53.setLocation(300,203);
        Barrier barrier54 = new Barrier();
        addObject(barrier54,344,158);
        barrier54.setLocation(344,161);
        Barrier barrier55 = new Barrier();
        addObject(barrier55,282,135);
        barrier55.setLocation(270,128);
        Barrier barrier56 = new Barrier();
        addObject(barrier56,188,108);
        barrier56.setLocation(198,110);
        Barrier barrier57 = new Barrier();
        addObject(barrier57,137,99);
        Treetop treetop50 = new Treetop();
        addObject(treetop50,23,32);
        treetop50.setLocation(28,31);
        Treebase treebase50 = new Treebase();
        addObject(treebase50,26,139);
        treebase50.setLocation(26,120);
        Barrier barrier58 = new Barrier();
        addObject(barrier58,81,100);
        barrier58.setLocation(87,98);
        Barrier barrier59 = new Barrier();
        addObject(barrier59,29,56);
        barrier59.setLocation(28,68);
        Barrier barrier60 = new Barrier();
        addObject(barrier60,167,633);
        barrier60.setLocation(173,638);
        Barrier barrier61 = new Barrier();
        addObject(barrier61,207,582);
        Barrier barrier62 = new Barrier();
        addObject(barrier62,138,699);
        Barrier barrier63 = new Barrier();
        addObject(barrier63,91,756);
        barrier63.setLocation(99,752);
        Barrier barrier64 = new Barrier();
        addObject(barrier64,48,795);
        barrier64.setLocation(33,791);
        Barrier barrier65 = new Barrier();
        addObject(barrier65,395,548);
        barrier65.setLocation(405,560);
        Barrier barrier66 = new Barrier();
        addObject(barrier66,438,542);
        barrier66.setLocation(442,521);
        Barrier barrier67 = new Barrier();
        addObject(barrier67,413,519);
        barrier67.setLocation(410,512);
        barrier66.setLocation(438,518);
        barrier67.setLocation(410,508);
    }
}
