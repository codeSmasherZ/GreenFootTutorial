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
        destroy();
        inited = true;
    }
    
    public void drawBonus()
    {
        int num_Bonus_Type = Greenfoot.getRandomNumber(2);
        switch(num_Bonus_Type)
        {
            case 0:
                Bonus shovel = new Bonus(Bonus.BonusType.SHOVEL);
                getWorld().addObject(shovel, x, y);
            break;
            
            case 1:
                Bonus bomb = new Bonus(Bonus.BonusType.BOMB);
                getWorld().addObject(bomb, x, y);
            break;
        }
    }
    
    private void destroy()
    {
        getWorld().removeObject(this);
    }
}
