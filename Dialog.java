import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Handles dialog generation for shop, world, death message, and information bar at bottom of screen.
 * 
 * @author Anthony Neeser
 * @version 5/6/18
 */
public class Dialog extends Actor
{
    //Colors and Font size
    private Color boxColor = new Color(17, 30, 108, 90); //original color
    private Color boxColor2 = new Color(17, 30, 108, 150); //test color to match player dialog
    private Color boxColor3 = new Color(0,0,0,200);
    private Color textColorFG = new Color(255, 255, 255, 255); //test color
    private Color textColorBG = new Color(0, 0, 0, 0);
    private int fontSize = 24;

    //World
    private int worldDialogBoxWidth = 500;
    private int worldDialogBoxHeight = 200;
    private int worldBorderWidth = 520;
    private int worldBorderHeight = 220;
    private int worldX = 540;
    private int worldY = 820;

    //Shop
    private int shopDialogBoxWidth = 425;
    private int shopDialogBoxHeight = 200;
    private int shopBorderWidth = 450;
    private int shopBorderHeight = 225;
    private int ShopX = 633;
    private int shopY = 575;

    //Placement for shop/world dialogs
    private int abovePlayerX;
    private int abovePlayerY;

    //Player
    private int PlayerDialogBoxWidth = 450;
    private int PlayerDialogBoxXHeight = 100;
    private int PlayerBorderWidth = 450;
    private int PlayerBorderHeight = 100;
    private int playerX;
    private int playerY;

    /**
     * NPC dialog. Use this to create npc communication. 
     */
    public void generateDialog(String currentWorld, String text) 
    {
        abovePlayerX = getWorld().getWidth()/2;
        abovePlayerY = getWorld().getHeight()-PlayerBorderHeight/2-170;
        switch(currentWorld)
        {
            case "shop":   
            getWorld().addObject(new ShopDialogBox(shopDialogBoxWidth, shopDialogBoxHeight, boxColor), abovePlayerX, abovePlayerY);
            getWorld().addObject(new ShopDialog(text, textColorFG, textColorBG), abovePlayerX, abovePlayerY);
            getWorld().addObject(new ShopDialogBorder(shopBorderWidth, shopBorderHeight), abovePlayerX, abovePlayerY);
            break;
            case "world":  
            getWorld().addObject(new WorldDialogBox(worldDialogBoxWidth, worldDialogBoxHeight, boxColor2), abovePlayerX, abovePlayerY);
            getWorld().addObject(new WorldDialog(text, textColorFG, textColorBG), abovePlayerX, abovePlayerY);
            getWorld().addObject(new WorldDialogBorder(worldBorderWidth, worldBorderHeight), abovePlayerX, abovePlayerY);
            break;
            case "generic":
            getWorld().addObject(new GenericWorldDialogBox(worldDialogBoxWidth, worldDialogBoxHeight, boxColor2), abovePlayerX, abovePlayerY);
            getWorld().addObject(new GenericWorldDialog(text, textColorFG, textColorBG), abovePlayerX, abovePlayerY);
            getWorld().addObject(new GenericWorldDialogBorder(worldBorderWidth, worldBorderHeight), abovePlayerX, abovePlayerY);
            break;
            case "sign":
            getWorld().addObject(new GenericWorldDialogBox(worldDialogBoxWidth, worldDialogBoxHeight, boxColor2), abovePlayerX, abovePlayerY);
            getWorld().addObject(new GenericWorldDialog(text, textColorFG, textColorBG), abovePlayerX, abovePlayerY);
            getWorld().addObject(new GenericWorldDialogBorder(worldBorderWidth, worldBorderHeight), abovePlayerX, abovePlayerY);
            break;
        }
    }

    /**
     * Player dialog. Displays health, arrows, gold, etc...
     */
    public void generateDialog(String health, String mana, String armor, String ammo, String item, String item2, String gold, String world) 
    {
        if(MainWorld.spawn == 0 || MainWorld.spawn == 99)
        {
            world = "World: 6";
        }
        //Player dialog box at bottom
        playerX = getWorld().getWidth()/2;
        playerY = getWorld().getHeight()-PlayerBorderHeight/2-10;
        getWorld().addObject(new PlayerDialogBox(PlayerDialogBoxWidth, PlayerDialogBoxXHeight, boxColor), playerX, playerY);
        getWorld().addObject(new PlayerDialog(health, textColorFG, textColorBG), playerX-150, playerY-28);
        getWorld().addObject(new PlayerDialog(mana, textColorFG, textColorBG), playerX+130, playerY-28);
        getWorld().addObject(new PlayerDialog(armor, textColorFG, textColorBG), playerX-150, playerY);
        getWorld().addObject(new PlayerDialog(world, textColorFG, textColorBG), playerX, playerY+28);
        getWorld().addObject(new PlayerDialog("- "+MainWorld.playerName+" -", textColorFG, textColorBG), playerX, playerY-28);
        getWorld().addObject(new PlayerDialog(ammo, textColorFG, textColorBG), playerX-150, playerY+28);
        getWorld().addObject(new PlayerDialog(item, textColorFG, textColorBG), playerX+130, playerY);
        getWorld().addObject(new PlayerDialog(item2, textColorFG, textColorBG), playerX+130, playerY+28);
        getWorld().addObject(new PlayerDialog(gold, textColorFG, textColorBG), playerX, playerY);
        
        if(MainWorld.sword==1 && !MainWorld.swordActive)
        {
            getWorld().addObject(new PlayerDialog("Press 1 to use Sword", textColorFG, textColorBG), 100, 12);
        }
        if(MainWorld.bow==1 && !MainWorld.bowActive)
        {
            getWorld().addObject(new PlayerDialog("Press 2 to use Bow", textColorFG, textColorBG), 100, 35);
        }
        if(MainWorld.suit==1 && !MainWorld.suitActive)
        {
            getWorld().addObject(new PlayerDialog("Press 9 to use armor", textColorFG, textColorBG), getWorld().getWidth()-120, 12);
        }
        if(MainWorld.suit==1 && MainWorld.suitActive)
        {
            getWorld().addObject(new PlayerDialog("Press 0 to remove armor", textColorFG, textColorBG), getWorld().getWidth()-120, 35);
        }
        getWorld().addObject(new PlayerDialogBorder(PlayerBorderWidth+25, PlayerBorderHeight+20), playerX, playerY);
    }

    /**
     * Instructions for play. 
     */
    public void instructions(String text)
    {
        getWorld().addObject(new InstructionDialogBox(750, 900, boxColor3), playerX, 440);
        getWorld().addObject(new InstructionDialog(text, textColorFG, textColorBG), playerX, 435);
        getWorld().addObject(new InstructionDialogBorder(775, 1025), playerX, 460);
    }
    
    /**
     * Instructions/death dialog generator.
     */
    public void generateDialog(String text1, String text2, String text3)
    {
        //Death dialog (or whatever you want displayed in the middle of the screen)
        playerX = getWorld().getWidth()/2;
        playerY = getWorld().getHeight()/2;
        getWorld().addObject(new WorldDialogBox(worldDialogBoxWidth, worldDialogBoxHeight, boxColor), playerX, playerY);
        getWorld().addObject(new WorldDialog(text1, textColorFG, textColorBG), playerX, playerY-25);
        getWorld().addObject(new WorldDialog(text2, textColorFG, textColorBG), playerX, playerY);
        getWorld().addObject(new WorldDialog(text3, textColorFG, textColorBG), playerX, playerY+25);
        getWorld().addObject(new WorldDialogBorder(worldBorderWidth, worldBorderHeight), playerX, playerY);
    }

    /**
     * Shop item dialog box. Purchase items with this. 
     */
    public void generateDialog(String text, int item1Price, int item2Price, int item3Price, int item4Price, int item5Price, int item6Price, String escape)
    {
        abovePlayerX = getWorld().getWidth()/2;
        abovePlayerY = getWorld().getHeight()-PlayerBorderHeight/2-285;

        getWorld().addObject(new ShopDialogBox(shopDialogBoxWidth+20, shopDialogBoxHeight*2, boxColor2), abovePlayerX, abovePlayerY);
        getWorld().addObject(new ShopDialogBorder(shopBorderWidth+20, shopBorderHeight*2), abovePlayerX, abovePlayerY);
        getWorld().addObject(new ShopDialog(text, textColorFG, textColorBG), abovePlayerX, abovePlayerY-175);

        //Item 1: Arrows
        getWorld().addObject(new ArrowsIcon(), abovePlayerX-110, abovePlayerY-110);
        getWorld().addObject(new ShopDialog(item1Price+" gold", textColorFG, textColorBG), abovePlayerX-110, abovePlayerY-50);

        //Item 2: Shield
        getWorld().addObject(new ShieldIcon(), abovePlayerX+110, abovePlayerY-110);
        getWorld().addObject(new ShopDialog(item2Price+" gold", textColorFG, textColorBG), abovePlayerX+110, abovePlayerY-50);

        //Item 3: Sword
        getWorld().addObject(new SwordIcon(), abovePlayerX, abovePlayerY-110);
        getWorld().addObject(new ShopDialog(item3Price+" gold", textColorFG, textColorBG), abovePlayerX, abovePlayerY-50);

        //Item 4: Bow
        getWorld().addObject(new BowIcon(), abovePlayerX-110, abovePlayerY+90);
        getWorld().addObject(new ShopDialog(item4Price+" gold", textColorFG, textColorBG), abovePlayerX-110, abovePlayerY+150);

        //Item 5: Health Potion
        getWorld().addObject(new HealthPotionIcon(104), abovePlayerX, abovePlayerY+90);
        getWorld().addObject(new ShopDialog(item5Price+" gold", textColorFG, textColorBG), abovePlayerX, abovePlayerY+150);

        //Item 6: Mana Potion
        getWorld().addObject(new ManaPotionIcon(104), abovePlayerX+110, abovePlayerY+90);
        getWorld().addObject(new ShopDialog(item5Price+" gold", textColorFG, textColorBG), abovePlayerX+110, abovePlayerY+150);

        getWorld().addObject(new ShopDialog(escape, textColorFG, textColorBG), abovePlayerX, abovePlayerY+175);
    }
}
