import greenfoot.*;

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
    //private boolean inited = false;
    private Timer _timer = new Timer();;
    
    public Bonus(BonusType type)
    {
        _type = type;
        _timer.setRange(5);
        Animation.scaleSprite(getImage(), BattleCity.SCALE);
    }
    
    public void act() 
    {
        //
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
            case TANK:
            break;
            
            case STAR:
            break;
            
            case BOMB:
            break;
            
            case SHOVEL:
                Camp _camp = getWorldOfType(BattleCity.class).getCamp();
                _timer.reset();
                _camp.drawWall(1);
                /*if ( _timer.outRange() )
                {
                    _camp.deleteStone();
                }*/
            break;
        }
    }
    
    private void destroy()
    {
        getWorld().removeObject(this);
    }
}
