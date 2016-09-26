package maze;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Manifest on 9/23/2016.
 */
public class MazeCoordinateBuilder {
    public static List<RoomCoordinate> generateRoomCoordinates(int height, int width){
        List<RoomCoordinate> roomCoordinates = new ArrayList<RoomCoordinate>();
        for(int i=1; i<=height; i++){
            for(int j=1; j<=width; j++){
                roomCoordinates.add(new RoomCoordinate(i,j));
            }
        }
        return roomCoordinates;
    }

    public static List<WallCoordinate> generateWallCoordinates(int height, int width){
        List<WallCoordinate> wallCoordinates = new ArrayList<WallCoordinate>();
        for(int i=1; i<=height; i++){
            for(int j=1; j<=width; j++){
                RoomCoordinate mainRoom = new RoomCoordinate(i,j);
                addNorthAndWestWalls(wallCoordinates, mainRoom);
                if(i == height){
                    addSouthWall(wallCoordinates, mainRoom);
                }
                if(j == width){
                    addEastWall(wallCoordinates, mainRoom);
                }
            }
        }
        return  wallCoordinates;
    }

    private static void addNorthAndWestWalls(List<WallCoordinate> wallCoordinates, RoomCoordinate mainRoom) {
        WallCoordinate northWall = new WallCoordinate(mainRoom.getNorth(), mainRoom);
        WallCoordinate westWall = new WallCoordinate(mainRoom.getWest(), mainRoom);
        wallCoordinates.add(northWall);
        wallCoordinates.add(westWall);
    }

    private static void addEastWall(List<WallCoordinate> wallCoordinates, RoomCoordinate mainRoom){
        WallCoordinate eastWall = new WallCoordinate(mainRoom, mainRoom.getEast());
        wallCoordinates.add(eastWall);
    }

    private static void  addSouthWall(List<WallCoordinate> wallCoordinates, RoomCoordinate mainRoom){
        WallCoordinate southWall = new WallCoordinate(mainRoom, mainRoom.getSouth());
        wallCoordinates.add(southWall);
    }

}
