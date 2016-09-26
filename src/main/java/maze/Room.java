package maze;

/**
 * Created by Russell Fillmore on 9/23/2016.
 */
public class Room {
    Wall north;
    Wall south;
    Wall east;
    Wall west;

    public Room(){
    }

    public Room(Wall north, Wall south, Wall east, Wall west) {
        this.north = north;
        this.south = south;
        this.east = east;
        this.west = west;
    }

    public Wall getNorth() {
        return north;
    }

    public void setNorth(Wall north) {
        this.north = north;
    }

    public Wall getSouth() {
        return south;
    }

    public void setSouth(Wall south) {
        this.south = south;
    }

    public Wall getEast() {
        return east;
    }

    public void setEast(Wall east) {
        this.east = east;
    }

    public Wall getWest() {
        return west;
    }

    public void setWest(Wall west) {
        this.west = west;
    }


    @Override
    public String toString() {
        return "\nRoom{" +
                "north=" + north +
                ", south=" + south +
                ", east=" + east +
                ", west=" + west +
                '}';
    }
}
