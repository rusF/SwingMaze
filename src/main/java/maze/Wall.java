package maze;

/**
 * Created by Russell Fillmore on 9/23/2016.
 */
public class Wall {
    boolean solid;
    Boolean door;
    Boolean locked;

    public Wall(){
        this.solid = true;
    }

    public Wall(boolean solid){
        this.solid = solid;
    }

    public Wall randomize(){
        if(randomBoolean()){
            this.solid = true;
            this.addRandomDoor();
        }else{
            this.solid = false;
        }
        return this;
    }

    private void addRandomDoor(){
        if(randomBoolean()) {
            this.door = true;
            randomizeDoorLock();
        }
    }

    private void randomizeDoorLock(){
        if(randomBoolean()){
            this.locked = true;
        }else{
            this.locked = false;
        }
    }

    public boolean isSolid() {
        return solid;
    }

    public void setSolid(boolean solid) {
        this.solid = solid;
    }

    public Boolean getDoor() {
        return door;
    }

    public void setDoor(Boolean door) {
        this.door = door;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    private boolean randomBoolean(){
        return Math.floor(Math.random()*2)==1;
    }

    @Override
    public String toString(){
        String string = "";
        if(solid){
            string += "Is solid";
            if(door != null && door){
                string += " and has door";
                if(locked != null && door){
                    string+= " that is locked";
                }
            }
        }else{
            string+= "Has opening";
        }
        string+="!";
        return string;
    }
}
