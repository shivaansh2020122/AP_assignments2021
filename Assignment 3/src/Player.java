public class Player {
    private int pos;
    private final String name;
    public Player(String n){
        this.pos=-1;
        this.name=n;
    }
    public int getPos() {
        return this.pos;
    }
    public String getName(){
        return this.name;
    }
    public void setposnchances(int x){
        this.pos+=x;

    }
}
