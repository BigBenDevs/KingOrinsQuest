import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the Shop world.  It contains a demo shop with shopkeep that you can interact with.
 * 
 * @author (Benjamin Presley) 
 * @version (04/30/18)
 */
public class Shop extends World
{
    /**
     * Constructor for Shop.
     */
    public Shop()
    {    
        super (900, 700, 1); 
        setPaintOrder(/*Barrier.class,*/ Icons.class, DialogParts.class, MusicButton.class, Treetop.class, Player.class, 
        JimboSubSystem.class, MattsSubSystem.class, Loot.class, Shadow.class, ShopBG.class, Barrier.class, ShopDoorExit.class, InstructionParts.class);    
        prepare();
        spawnPlayer();
    }
    
    /**
     * Controls the spawning of player when transfering between worlds
     */
    public void spawnPlayer()
    {
        if (MainWorld.spawn == 27)
        {
            Player hawthorne = new Player();
            addObject(hawthorne, 285,350);
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
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Barrier barrier = new Barrier();
        addObject(barrier,193,230);
        barrier.setLocation(195,221);
        Barrier barrier2 = new Barrier();
        addObject(barrier2,259,224);
        barrier2.setLocation(247,221);
        Barrier barrier3 = new Barrier();
        addObject(barrier3,382,143);
        barrier3.setLocation(379,144);
        Barrier barrier4 = new Barrier();
        addObject(barrier4,454,150);
        barrier4.setLocation(452,145);
        barrier4.setLocation(455,144);
        Barrier barrier5 = new Barrier();
        addObject(barrier5,499,150);
        barrier5.setLocation(529,144);
        Barrier barrier6 = new Barrier();
        addObject(barrier6,554,136);
        barrier6.setLocation(602,144);
        Barrier barrier7 = new Barrier();
        addObject(barrier7,669,142);
        barrier7.setLocation(675,144);
        Barrier barrier8 = new Barrier();
        addObject(barrier8,760,145);
        barrier8.setLocation(751,144);
        Barrier barrier9 = new Barrier();
        addObject(barrier9,799,215);
        barrier9.setLocation(798,217);
        Barrier barrier10 = new Barrier();
        addObject(barrier10,805,286);
        barrier10.setLocation(800,292);
        Barrier barrier11 = new Barrier();
        addObject(barrier11,802,380);
        barrier11.setLocation(800,368);
        Barrier barrier12 = new Barrier();
        addObject(barrier12,806,447);
        barrier12.setLocation(800,443);
        Barrier barrier13 = new Barrier();
        addObject(barrier13,798,520);
        barrier13.setLocation(800,518);
        Barrier barrier14 = new Barrier();
        addObject(barrier14,749,555);
        barrier14.setLocation(744,537);
        Barrier barrier15 = new Barrier();
        addObject(barrier15,663,408);
        barrier15.setLocation(668,403);
        Barrier barrier16 = new Barrier();
        addObject(barrier16,626,454);
        barrier16.setLocation(624,438);
        Barrier barrier17 = new Barrier();
        addObject(barrier17,579,449);
        barrier17.setLocation(583,456);
        Barrier barrier18 = new Barrier();
        addObject(barrier18,584,402);
        barrier18.setLocation(584,387);
        Barrier barrier19 = new Barrier();
        addObject(barrier19,621,388);
        barrier19.setLocation(633,387);
        Barrier barrier20 = new Barrier();
        addObject(barrier20,541,441);
        Barrier barrier21 = new Barrier();
        addObject(barrier21,464,443);
        barrier21.setLocation(469,421);
        Barrier barrier22 = new Barrier();
        addObject(barrier22,395,408);
        barrier22.setLocation(396,421);
        Barrier barrier23 = new Barrier();
        addObject(barrier23,375,433);
        barrier23.setLocation(356,420);
        Barrier barrier24 = new Barrier();
        addObject(barrier24,281,490);
        barrier24.setLocation(320,486);
        Barrier barrier25 = new Barrier();
        addObject(barrier25,255,487);
        barrier25.setLocation(245,486);
        Barrier barrier26 = new Barrier();
        addObject(barrier26,471,489);
        barrier26.setLocation(468,496);
        Barrier barrier27 = new Barrier();
        addObject(barrier27,471,575);
        barrier27.setLocation(468,569);
        Barrier barrier28 = new Barrier();
        addObject(barrier28,482,607);
        barrier28.setLocation(517,612);
        Barrier barrier29 = new Barrier();
        addObject(barrier29,569,605);
        barrier29.setLocation(592,612);
        Barrier barrier30 = new Barrier();
        addObject(barrier30,675,618);
        barrier30.setLocation(668,612);
        Barrier barrier31 = new Barrier();
        addObject(barrier31,734,604);
        barrier31.setLocation(744,612);
        Barrier barrier32 = new Barrier();
        addObject(barrier32,817,155);
        barrier32.setLocation(798,155);
        Barrier barrier33 = new Barrier();
        addObject(barrier33,201,451);
        barrier33.setLocation(213,457);
        Barrier barrier34 = new Barrier();
        addObject(barrier34,204,403);
        barrier34.setLocation(213,423);
        Barrier barrier35 = new Barrier();
        addObject(barrier35,146,418);
        barrier35.setLocation(139,423);
        Barrier barrier36 = new Barrier();
        addObject(barrier36,79,418);
        barrier36.setLocation(92,422);
        Barrier barrier37 = new Barrier();
        addObject(barrier37,115,371);
        barrier37.setLocation(88,359);
        Barrier barrier38 = new Barrier();
        addObject(barrier38,92,298);
        barrier38.setLocation(88,303);
        Barrier barrier39 = new Barrier();
        addObject(barrier39,112,242);
        barrier39.setLocation(88,232);
        Barrier barrier40 = new Barrier();
        addObject(barrier40,110,174);
        barrier40.setLocation(89,166);
        Barrier barrier41 = new Barrier();
        addObject(barrier41,103,116);
        barrier41.setLocation(90,103);
        Barrier barrier42 = new Barrier();
        addObject(barrier42,169,72);
        barrier42.setLocation(164,90);
        Barrier barrier43 = new Barrier();
        addObject(barrier43,244,98);
        barrier43.setLocation(238,89);
        Barrier barrier44 = new Barrier();
        addObject(barrier44,312,81);
        barrier44.setLocation(309,90);
        Barrier barrier45 = new Barrier();
        addObject(barrier45,377,86);
        barrier45.setLocation(384,90);
        ShopDoorExit shopdoorexit = new ShopDoorExit();
        addObject(shopdoorexit,291,438);
        shopdoorexit.setLocation(285,429);
        ShopOwner shopowner = new ShopOwner();
        addObject(shopowner,341,220);
        //MusicButton musicbutton = new MusicButton();
        //addObject(musicbutton,867,666);
        //musicbutton.setLocation(858,664);
        //musicbutton.setLocation(862,673);
        ShopBG shopbg = new ShopBG();
        addObject(shopbg,485,370);
        shopbg.setLocation(450,350);
    }
}
