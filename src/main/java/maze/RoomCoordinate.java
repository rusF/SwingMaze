package maze;

/**
 * Created by Manifest on 9/23/2016.
 */
public class RoomCoordinate implements Cloneable{
    public int x;
    public int y;

    public RoomCoordinate(int y, int x) {
        this.x = x;
        this.y = y;
    }

    public RoomCoordinate getNorth(){
        return new RoomCoordinate(y-1, x);
    }

    public RoomCoordinate getWest(){
        return new RoomCoordinate(y, x-1);
    }

    public RoomCoordinate getSouth(){
        return new RoomCoordinate(y+1, x);
    }

    public RoomCoordinate getEast(){
        return new RoomCoordinate(y, x+1);
    }

    @Override
    public String toString(){
        return "<"+x+","+y+">";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoomCoordinate that = (RoomCoordinate) o;

        if (x != that.x) return false;
        return y == that.y;

    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
