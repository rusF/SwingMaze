package maze;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Manifest on 9/26/2016.
 */
public class MazeCoordinateBuilderTest {
    int[][][] rooms = new int[3][4][2];





    @Test
    public void testGenerateRoomCoordinatesMakesAllNeededCoordinates() throws Exception {
        fillRooms();
        List<RoomCoordinate> coordinates = MazeCoordinateBuilder.generateRoomCoordinates(4,3);
        for(int[][] roomx : rooms){
            for(int[] roomxy : roomx){
                RoomCoordinate newRoomCoordinate =new RoomCoordinate(roomxy[1],roomxy[0]);
                assertTrue("Coordinates Must Contain ["+roomxy[0]+","+roomxy[1]+"] in a 3 by 4 maze",coordinates.contains(newRoomCoordinate));
                int index = coordinates.indexOf(new RoomCoordinate(roomxy[1],roomxy[0]));
                assertTrue("Coordinate x must be "+roomxy[0]+" at ["+roomxy[0]+","+roomxy[1]+"]", roomxy[0] == coordinates.get(index).x);
                assertTrue("Coordinate y must be "+roomxy[1]+" at ["+roomxy[0]+","+roomxy[1]+"]", roomxy[1] == coordinates.get(index).y);
            }
        }

    }

    private void fillRooms(){
        for(int i = 1; i<=3; i++){
            for(int j = 1; j<=4; j++){
                rooms[i-1][j-1] = new int[]{i,j};
            }
        }
    }



    @Test
    public void testGenerateWallCoordinatesMakesAllValidCoordinates() throws Exception {
        List<RoomCoordinate> roomCoordinates= MazeCoordinateBuilder.generateRoomCoordinates(4,3);
        List<WallCoordinate> wallCoordinates = MazeCoordinateBuilder.generateWallCoordinates(roomCoordinates,4,3);
        for(WallCoordinate coordinate : wallCoordinates){
            assertTrue("Each wall coordinate must be valid", coordinate.isValidWall());
        }
    }

    @Test
    public void testGenerateWallCoordinatesMakesANorthWallForEachRoom(){
        fillRooms();
        List<RoomCoordinate> roomCoordinates= MazeCoordinateBuilder.generateRoomCoordinates(4,3);
        List<WallCoordinate> wallCoordinates = MazeCoordinateBuilder.generateWallCoordinates(roomCoordinates,4,3);
        for(int[][] roomx : rooms) {
            for (int[] roomxy : roomx) {
                RoomCoordinate mainRoom = new RoomCoordinate(roomxy[1], roomxy[0]);
                RoomCoordinate northRoom = new RoomCoordinate(roomxy[1]-1, roomxy[0]);
                WallCoordinate northWallCoordinate = new WallCoordinate(northRoom, mainRoom);
                assertTrue("Each Room must have a north wall",wallCoordinates.contains(northWallCoordinate));
            }
        }
    }

    @Test
    public void testGenerateWallCoordinatesMakesAWestWallForEachRoom(){
        fillRooms();
        List<RoomCoordinate> roomCoordinates= MazeCoordinateBuilder.generateRoomCoordinates(4,3);
        List<WallCoordinate> wallCoordinates = MazeCoordinateBuilder.generateWallCoordinates(roomCoordinates,4,3);
        for(int[][] roomx : rooms) {
            for (int[] roomxy : roomx) {
                RoomCoordinate mainRoom = new RoomCoordinate(roomxy[1], roomxy[0]);
                RoomCoordinate westRoom = new RoomCoordinate(roomxy[1], roomxy[0]-1);
                WallCoordinate westWallCoordinate = new WallCoordinate(westRoom, mainRoom);
                assertTrue("Each Room must have a north wall",wallCoordinates.contains(westWallCoordinate));
            }
        }
    }

    @Test
    public void testGenerateWallCoordinatesMakesASouthWallForEachRoom(){
        fillRooms();
        List<RoomCoordinate> roomCoordinates= MazeCoordinateBuilder.generateRoomCoordinates(4,3);
        List<WallCoordinate> wallCoordinates = MazeCoordinateBuilder.generateWallCoordinates(roomCoordinates,4,3);
        for(int[][] roomx : rooms) {
            for (int[] roomxy : roomx) {
                RoomCoordinate mainRoom = new RoomCoordinate(roomxy[1], roomxy[0]);
                RoomCoordinate southRoom = new RoomCoordinate(roomxy[1]+1, roomxy[0]);
                WallCoordinate southWallCoordinate = new WallCoordinate(mainRoom, southRoom);
                assertTrue("Each Room must have a south wall",wallCoordinates.contains(southWallCoordinate));
            }
        }
    }

    @Test
    public void testGenerateWallCoordinatesMakesAEastWallForEachRoom(){
        fillRooms();
        List<RoomCoordinate> roomCoordinates= MazeCoordinateBuilder.generateRoomCoordinates(4,3);
        List<WallCoordinate> wallCoordinates = MazeCoordinateBuilder.generateWallCoordinates(roomCoordinates,4,3);
        for(int[][] roomx : rooms) {
            for (int[] roomxy : roomx) {
                RoomCoordinate mainRoom = new RoomCoordinate(roomxy[1], roomxy[0]);
                RoomCoordinate eastRoom = new RoomCoordinate(roomxy[1], roomxy[0]+1);
                WallCoordinate eastWallCoordinate = new WallCoordinate(mainRoom, eastRoom);
                assertTrue("Each Room must have a east wall",wallCoordinates.contains(eastWallCoordinate));
            }
        }
    }

    @Test
    public void testGenerateWallCoordinatesMakesCorrectNumberOfWalls(){
        List<RoomCoordinate> roomCoordinates= MazeCoordinateBuilder.generateRoomCoordinates(4,3);
        List<WallCoordinate> wallCoordinates = MazeCoordinateBuilder.generateWallCoordinates(roomCoordinates,4,3);
        assertEquals("If height is "+4+" and width is "+3+" then the total number of rooms must be "+31, 31, wallCoordinates.size());
    }

    @Test
    public void testGenerateRoomsCoordinatesMakesCorrectNumberOfRooms(){
        List<RoomCoordinate> roomCoordinates= MazeCoordinateBuilder.generateRoomCoordinates(4,3);
        assertEquals("If height is 4 and width is 3 then the total number of rooms must be 12", 12, roomCoordinates.size());
    }

    @Test
    public void testGenerateWallCoordinatesDoesNotChangeNumberOfRoomCoordinates(){
        List<RoomCoordinate> roomCoordinates= MazeCoordinateBuilder.generateRoomCoordinates(4,3);
        List<WallCoordinate> wallCoordinates = MazeCoordinateBuilder.generateWallCoordinates(roomCoordinates,4,3);
        assertEquals("After wall coordinates generated the number of room cooridinates for height 4 and width 3 must be 12", 12, roomCoordinates.size());
    }

}