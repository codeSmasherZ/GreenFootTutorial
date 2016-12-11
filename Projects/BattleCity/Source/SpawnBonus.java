import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SpawnBonus here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpawnBonus extends Actor
{
    /**
     * Act - do whatever the SpawnBonus wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int x;
    private int y;
    private boolean inited = false;
    
    
    
    public SpawnBonus()
    {
        x = 32 + 64*Greenfoot.getRandomNumber(13);
        y = 32 + 64*Greenfoot.getRandomNumber(13);
    }
    
    public void act() 
    {
        if(inited) return;
        drawBonus();
        inited = true;
    }
    
    public void drawBonus()
    {
        Bonus shovel = new Bonus(Bonus.BonusType.SHOVEL);
        getWorld().addObject(shovel, x, y);
    }
}
