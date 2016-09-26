package maze;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Manifest on 9/23/2016.
 */
public class WallCoordinate {
    public static enum WallAxis {NORTH_SOUTH,EAST_WEST};
    public RoomCoordinate roomNW;
    public RoomCoordinate roomSE;
    public WallAxis axis;


    public WallCoordinate(RoomCoordinate roomNW, RoomCoordinate roomSE) {
        this.roomNW = roomNW;
        this.roomSE = roomSE;
        assignWallAxis();
    }

    public List<Integer> getIntCoordinates(){
        List<Integer> coordinateList = new ArrayList<Integer>();
        coordinateList.add(roomNW.x);
        coordinateList.add(roomNW.y);
        coordinateList.add(roomSE.x);
        coordinateList.add(roomSE.y);
        return coordinateList;
    }

    public boolean isValidWall(){
        boolean isValid = false;
        if(roomNW.x == roomSE.x){
            isValid = true;
        }
        if(roomNW.y == roomSE.y){
            isValid = true;
        }
        if(roomNW.equals(roomSE)){
            isValid = false;
        }
        return isValid;
    }

    public WallAxis assignWallAxis(){
        if(isValidWall()){
            if (roomNW.x == roomSE.x){
                axis = WallAxis.EAST_WEST;
            } else if( roomNW.y == roomSE.y){
                axis = WallAxis.NORTH_SOUTH;
            }
        }
        return this.axis;
    }

    @Override
    public String toString(){
        return "( "+roomNW.toString()+" , "+roomSE.toString()+" )";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WallCoordinate that = (WallCoordinate) o;

        if (!roomNW.equals(that.roomNW)) return false;
        return roomSE.equals(that.roomSE);

    }

    @Override
    public int hashCode() {
        int result = roomNW.hashCode();
        result = 31 * result + roomSE.hashCode();
        return result;
    }
}
