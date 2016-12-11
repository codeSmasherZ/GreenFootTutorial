import greenfoot.*;
import java.awt.Color;
/**
 * Write a description of class Map here.
 *
 * @author Vitaliy Vitushkin
 * @version (a version number or a date)
 */
public class Map
{
    private World world;
    
    private int _offset = 0;
    private int _blocks;
    private int _blockSize;
    private int _countBlock = 4;
    private int x = 16;
    private int y = 16;
    
    private int[][] mapObjects = { {0,0,0,0,0,0,0,0,0,0,0,0,0},
                                   {0,1,0,1,0,1,0,1,0,1,0,1,0},
                                   {0,1,0,1,0,1,0,1,0,1,0,1,0},
                                   {0,1,0,1,0,1,2,1,0,1,0,1,0},
                                   {0,1,0,1,0,1,0,1,0,1,0,1,0},
                                   {0,1,0,1,0,0,0,0,0,1,0,1,0},
                                   {0,0,0,0,0,1,1,1,0,0,0,0,0},
                                   {2,1,1,1,0,0,0,0,0,1,1,1,2},
                                   {0,0,0,0,0,1,0,1,0,0,0,0,0},
                                   {0,1,0,1,0,1,1,1,0,1,0,1,0},
                                   {0,1,0,1,0,1,0,1,0,1,0,1,0},
                                   {0,1,0,1,0,0,0,0,0,1,0,1,0},
                                   {0,0,0,0,0,0,0,0,0,0,0,0,0}
                                 };
 
    public Map( int blocks, int blockSize)
    {        
        _blocks = blocks;
        _blockSize = blockSize;
    }
    
    public void build(World world)
    {
        Wall[][][] wall = new Wall[_blocks][_blocks][_countBlock];
        Bonus[][] bonuses = new Bonus[_blocks][_blocks];
       
       
        for (int i = 0; i < _blocks; i++)
        {
            for (int j = 0; j < _blocks; j++)
            {
                for ( int k = 0; k < _countBlock; k++ )
                {
                    if ( mapObjects[i][j] == 1) {wall[i][j][k] = new Brick();}
                    if ( mapObjects[i][j] == 2) {wall[i][j][k] = new Stone();}
                }
            }
        }
       
       
        for (int i = 0; i < _blocks; i++)
        {
            for (int j = 0; j < _blocks; j++)
            {
                int _x = x + 64*j;
                int _y = y + 64*i;
                
                if ( mapObjects[i][j] == 1 || mapObjects[i][j] == 2 )
                {
                    for (int k = 0; k < _countBlock; k++)
                    {
                        if ( k < 2 )
                        {
                            world.addObject(wall[i][j][k], _x, _y + k*32);
                        }
                        else
                        {  
                            world.addObject(wall[i][j][k], _x + 32, _y + (k - 2)*32);
                        }
                    }
                }
            }
        }
    }
 
    public int getOffset()
    {
        return _offset;
    }
    
    public int getSize()
    {
        return _blocks * _blockSize;
    }
    
    public boolean isInside(int x, int y)
    {
        int scaledSize = BattleCity.mapSize;
        
        return x > _offset && x < _offset + scaledSize &&
               y > _offset && y < _offset + scaledSize;
    }
}