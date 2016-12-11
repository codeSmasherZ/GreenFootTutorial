import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class Camp here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Camp extends Actor
{
    /**
     * Act - do whatever the Camp wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private World _BattleCityWorld;
    private Wall[][] _Wall = new Wall[2][8];
    private boolean inited = false;
    private int x = 16 + 352;
    private int y = 16 + 736;
    private int _countBlock = 8;
    
    private static Camp _staticCamp;
    
    public static Camp getCamp()
    {
        return _staticCamp;
    }
    
    public Camp()
    {
        Animation.scaleSprite(getImage(), BattleCity.SCALE);
        _staticCamp = this;
    }
    
    public void act()
    {
        if(inited) return;
        
        _BattleCityWorld = getWorld();
        GreenfootImage background = _BattleCityWorld.getBackground();
        background.setColor(Color.WHITE);
        int size = background.getHeight();
       
        //background.drawLine(352, 832, 352, 736);
        //background.drawLine(480, 832, 480, 736);
        //background.drawLine(352, 736, 480, 736);
       
        drawWall(0);
        //drawStone();
        
        inited = true;
    }
   
    public void drawWall( int _typeWall )
    {
        for (int i = 0; i < _countBlock; i++)
            {
                switch(_typeWall)
                {
                    case 0:
                        _Wall[_typeWall][i] = new Brick();
                    break;
                    
                    case 1:
                        _Wall[_typeWall][i] = new Stone();
                    break;
                }
                
                if ( i < 3 )
                {
                    _BattleCityWorld.addObject(_Wall[_typeWall][i], x, y + i*32);
                }
                else
                {  
                    if ( i < 6)
                    {
                        _BattleCityWorld.addObject(_Wall[_typeWall][i], x + (i-2)*32, y);
                    }
                    else
                    {
                        _BattleCityWorld.addObject(_Wall[_typeWall][i], x + 3*32, y + (i - 5)*32);
                    }
                }
            }
    }
    
    public void deleteStone()
    {
        for (int i = 0; i < _countBlock; i++)
            {
                _BattleCityWorld.removeObject(_Wall[1][i]);
            }
    }
    
    public void hit()
    {
        setImage("camp_dead.png");
        Animation.scaleSprite(getImage(), BattleCity.SCALE);
    }    
}