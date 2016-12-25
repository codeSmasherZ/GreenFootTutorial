import greenfoot.*;
import java.awt.Color;

/**
 * Клон игры BattleCity
 * 
 * @author Fedor Kuzin
 * @author Vitaliy Vitushkin
 * @version 1
 */
public class BattleCity extends World
{
    public enum GameState
    {
        MENU,
        GAME_STARTING,
        PAUSE,
        GAME,
        GAME_OVER
    }
    
    public static final int SCALE = 4;
    
    public static final int blocks = 13;
    public static final int blockSize = 16;
    public static final int mapSize = blocks * blockSize * SCALE;
    
    private Map _map = new Map(blocks, blockSize);
    private GameState _state = GameState.GAME;
    private Camp camp = new Camp();
    
    
    public BattleCity()
    {
        super(mapSize, mapSize, 1, false); 
        
        GreenfootImage background = getBackground();
        background.setColor(Color.BLACK);
        background.fill();
        
        addObject(camp, 416, 800);
        
        prepare();
    }

    public void act()
    {
        switch(_state)
        {
            case MENU:
            break;
            
            case GAME_STARTING:
            break;
            
            case PAUSE:
            break;
            
            case GAME:
            break;
            
            case GAME_OVER:
            break;
        }
    }
    
    public void setState(GameState state)
    {
        _state = state;
    }
    
    public GameState getState()
    {
        return _state;
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Tank tankPlayer1 = new Tank(Tank.Type.PLAYER_1, false);
        addObject(tankPlayer1,225,800);
        
        Tank tankPlayer2 = new Tank(Tank.Type.PLAYER_2, false);
        addObject(tankPlayer2, 609, 800);
        
        SpawnTank spwanTanks = new SpawnTank(4);
        addObject(spwanTanks, 0, 0);
        
        /*for ( int i = 1; i < 3; i++ )
        {
            SpawnTank spwanTanks = new SpawnTank();
            addObject(spwanTanks, 0, 0);
        }*/
        
        /*Tank tankEnemy = new Tank(Tank.Type.ENEMY, false);
        addObject(tankEnemy, 32, 32);
        
        Tank tankEnemy2 = new Tank(Tank.Type.ENEMY,false);
        addObject(tankEnemy2, 32*15, 32);
        
        Tank tankEnemy3 = new Tank(Tank.Type.ENEMY,false);
        addObject(tankEnemy3, 32*22, 32);*/        
        
        //Bonus bonus = new Bonus(); //тест бонуса лопата
        //addObject(bonus, 290, 736);
        
        //Tank tankEnemyBonus = new Tank(Tank.Type.BONUS_ENEMY, false);
        //addObject(tankEnemyBonus, 32*15, 32*11); 
        
        //Tank tankEnemyBonus = new Tank(Tank.Type.ENEMY,true);
        //addObject(tankEnemyBonus, 32*15, 32*11);
        
        buildMap();
    }
    
    public void started(){

    }
    
    private void buildMap()
    {
        _map.build(this);
    }
    
    public Map getMap()
    {
        return _map;
    }
    
    public Camp getCamp()
    {
        return camp;
    }
}