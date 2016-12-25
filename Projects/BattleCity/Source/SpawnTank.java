import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Iterator;
import java.util.List;


/**
 * Write a description of class SpawnTank here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpawnTank extends Actor
{
    /**
     * Act - do whatever the SpawnTank wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int x;
    private int y;
    private boolean inited = false;
    private Timer _timer = new Timer();
    private int count = 1;
    private int counter = 0;
    //List<Tank> tanks;
    
    public SpawnTank(int _count)
    {
        count = _count;
        x = 32;
        y = 32;
        _timer.setRange(2000);
    }
    
    public void act() 
    {
        /*tanks = getWorld().getObjects(Tank.class);
        Iterator it = tanks.iterator();
        int lenght = 0;
        if(it.hasNext())
        {
            while( it.hasNext() )
            {
                lenght++;
            }
        }*/
        
        if(!inited)
        {
            if ( _timer.outRange()  )
            {
                drawTank();
                counter++;
                _timer.reset();
            }
        }
        //drawTank();
        if ( counter == count )
        {
            inited = true;
            destroy();
        }
    }
    
    public int randomNumOfPos()
    {
        int[] _positionsNums = {32, 32*15, 32*22};
        return _positionsNums[Greenfoot.getRandomNumber(3)];
    }
    
    public void drawTank()
    {
        if ( counter+1%4 == 4 )
        {
            Tank tank = new Tank(Tank.Type.ENEMY,true);
            getWorld().addObject(tank, randomNumOfPos(), y);
        }
        else
        {
            Tank tank = new Tank(Tank.Type.ENEMY,false);
            getWorld().addObject(tank, randomNumOfPos(), y);
        }
    }
    
    private void destroy()
    {
        getWorld().removeObject(this);
    }
}
