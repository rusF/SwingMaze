
import maze.Maze;


public class Main{

    public static void main(String[] args) {
        Maze maze = new Maze(3,7);
        maze.fill();
        new MainFrame();
        System.out.println(maze);
    }
}
