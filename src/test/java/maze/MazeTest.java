package maze;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Russell Fiilmore on 9/26/2016.
 */
public class MazeTest {

    private final int height = 7;
    private final int width = 10;
    Maze maze;

    @Before
    public void before(){
        maze = new Maze(height, width);
    }

    @Test
    public void testFillMakesCorrectNumOfRooms() throws Exception {
        maze.fill();
        assertEquals("If height is "+height+" and width is "+width+" then the total number of rooms must be "+height*width, height*width, maze.getRooms().size());
    }

    @Test
    public void testFillMakesCorrectNumOfWalls() throws Exception {
        maze.fill();
        assertEquals("If height is "+height+" and width is "+width+" then the total number of rooms must be "+2*height*width+height+width, 2*height*width+height+width, maze.getWalls().size());
    }

}