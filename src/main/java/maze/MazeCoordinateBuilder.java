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

    public static List<WallCoordinate> generateWallCoordinates(List<RoomCoordinate> roomCoordinates, int height, int width){
        List<RoomCoordinate> falseRoomCoordinates = generateFalseRoomCoordinates(height, width);
        List<RoomCoordinate> roomCoordinatesForWalls = roomCoordinates.subList(0,roomCoordinates.size());
        roomCoordinatesForWalls.addAll(falseRoomCoordinates);
        List<WallCoordinate> wallCoordinates = new ArrayList<WallCoordinate>();
        for (RoomCoordinate roomCoordinate1 : roomCoordinatesForWalls){
            for (RoomCoordinate roomCoordinate2 : roomCoordinatesForWalls){
                WallCoordinate tempCoordinate = makeTemporaryWallCoordinate(roomCoordinate1,roomCoordinate2, height, width);
                if(tempCoordinate != null){
                    wallCoordinates.add(tempCoordinate);
                }
            }
        }
        return  wallCoordinates;
    }

    private static List<RoomCoordinate> generateFalseRoomCoordinates(int height, int width) {
        List<RoomCoordinate> falseRoomCoordinates = new ArrayList<RoomCoordinate>();
        for(int i=1; i<=height; i++){
            falseRoomCoordinates.add(new RoomCoordinate(i,0));
            falseRoomCoordinates.add(new RoomCoordinate(i,width+1));
        }
        for(int j=1; j<=width; j++){
            falseRoomCoordinates.add(new RoomCoordinate(0,j));
            falseRoomCoordinates.add(new RoomCoordinate(height+1,j));
        }
        return falseRoomCoordinates;
    }

    private static WallCoordinate makeTemporaryWallCoordinate(RoomCoordinate roomCoordinate1, RoomCoordinate roomCoordinate2, int height, int width) {
        WallCoordinate wallCoordinate = null;
        if(roomCoordinate1.x==roomCoordinate2.x-1 && roomCoordinate1.y==roomCoordinate2.y  && roomCoordinate1.y != 0 && roomCoordinate1.y <= height){
            wallCoordinate = new WallCoordinate(roomCoordinate1,roomCoordinate2);
        }else if(roomCoordinate1.x == roomCoordinate2.x && roomCoordinate1.y==roomCoordinate2.y-1 && roomCoordinate1.x != 0 && roomCoordinate1.x <= width){
            wallCoordinate = new WallCoordinate(roomCoordinate1, roomCoordinate2);
        }
        return wallCoordinate;
    }
}
