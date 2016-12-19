import greenfoot.*;
import java.util.Iterator;
import java.util.List;

/**
 * Write a description of class Bonus here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bonus extends Actor
{
    public enum BonusType {
        TANK, 
        STAR, 
        BOMB, 
        SHOVEL
    }
    
    private BonusType _type = BonusType.SHOVEL;
    private Camp _camp;
    private boolean inited = false;
    
    public Bonus(BonusType type)
    {
        _type = type;
        
        switch(_type)
        {
            case STAR:
                setImage("bonus_star.png");
                Animation.scaleSprite(getImage(), BattleCity.SCALE);
            break;
            
            case BOMB:
                setImage("bonus_bomb.png");
                Animation.scaleSprite(getImage(), BattleCity.SCALE);
            break;
            
            case SHOVEL:
                setImage("bonus_shovel.png");
                Animation.scaleSprite(getImage(), BattleCity.SCALE);
            break;
        }
        
    }
    
    public void act() 
    {
        if(!inited) _camp = getWorldOfType(BattleCity.class).getCamp();
        
        inited = true;
    }
    
    public void pickedUP()
    {
        prize();
        destroy();
    }
    
    public void prize()
    {
        switch(_type)
        {
            case STAR:
            break;
            
            case BOMB:
                //List<Tank> tank = getWorldOfType(BattleCity.class).getObjects(Tank.class);
            break;
            
            case SHOVEL:
                _camp.drawWall(1);
            break;
        }
    }
    
    private void destroy()
    {
        getWorld().removeObject(this);
    }
}
