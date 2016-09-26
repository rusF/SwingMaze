package maze;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Russell Fillmore on 9/23/2016.
 */
public class Maze {
    private int height = 0;
    private int width = 0;
    private Map<RoomCoordinate, Room> rooms = new HashMap<RoomCoordinate, Room>();
    private Map<WallCoordinate, Wall> walls = new HashMap<WallCoordinate, Wall>();

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public Map<RoomCoordinate, Room> getRooms() {
        return rooms;
    }

    public void setRooms(Map<RoomCoordinate, Room> rooms) {
        this.rooms = rooms;
    }

    public Map<WallCoordinate, Wall> getWalls() {
        return walls;
    }

    public void setWalls(Map<WallCoordinate, Wall> walls) {
        this.walls = walls;
    }

    public Maze(int height, int width){
        this.height = height;
        this.width = width;
    }

    public Maze fill(){
        List<RoomCoordinate> roomCoordinates = MazeCoordinateBuilder.generateRoomCoordinates(height, width);
        List<WallCoordinate> wallCoordinates = MazeCoordinateBuilder.generateWallCoordinates(height, width);
        makeWalls(wallCoordinates);
        makeRooms(roomCoordinates);
        return this;
    }

    private void makeWalls(List<WallCoordinate> wallCoordinates) {
        for (WallCoordinate coordinate : wallCoordinates){
            Wall wall = new Wall();
            if(!checkForEdgeWall(coordinate)){
                wall.randomize();
            }
            walls.put(coordinate,wall);
        }
    }

    private boolean checkForEdgeWall(WallCoordinate coordinate) {
        boolean isEdge = false;
        if(coordinate.roomNW.x == 0 || coordinate.roomNW.y == 0 || coordinate.roomNW.x > width || coordinate.roomNW.y > height){
            isEdge = true;
        }
        if(coordinate.roomSE.x == 0 || coordinate.roomSE.y == 0 || coordinate.roomSE.x > width || coordinate.roomSE.y > height){
            isEdge = true;
        }
        return isEdge;
    }

    private void makeRooms(List<RoomCoordinate> roomCoordinates) {
        for(RoomCoordinate coordinate : roomCoordinates){
            Wall northWall = walls.get(new WallCoordinate(coordinate.getNorth(), coordinate));
            Wall southWall = walls.get(new WallCoordinate(coordinate, coordinate.getSouth()));
            Wall westWall = walls.get(new WallCoordinate(coordinate.getWest(), coordinate));
            Wall eastWall = walls.get(new WallCoordinate(coordinate, coordinate.getEast()));

            Room room = new Room(northWall,southWall,westWall,eastWall);
            rooms.put(coordinate, room);
        }
    }


    @Override
    public String toString() {
        return "Maze{" +
                "height=" + height +
                ", width=" + width +
                ",\n rooms=" + rooms +
                '}';
    }
}
