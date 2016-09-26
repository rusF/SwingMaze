
import maze.Room;

import javax.swing.*;

/**
 * Created by Manifest on 9/23/2016.
 */
public class MainFrame extends JFrame{
    JPanel mainPanel = new JPanel();
    JButton northButton = new JButton("North: ");
    JButton southButton = new JButton("South: ");
    JButton eastButton = new JButton("East: ");
    JButton westButton = new JButton("West: ");

    public MainFrame(){
        super("Swing Maze");
        setSize(600, 800);
        setResizable(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainPanel.add(northButton);
        mainPanel.add(southButton);
        mainPanel.add(eastButton);
        mainPanel.add(westButton);

        add(mainPanel);
        setVisible(true);
    }

    public void loadRoom(Room room){
    }
}
