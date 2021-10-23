public abstract class floor {
    protected final String nfloor;
    protected final int points;
    //nfloor = number of floor
    public floor(String n,int pts){
        this.nfloor=n;
        this.points=pts;
    }
    public abstract int move(Player p,int pts);
    //dval is the dice value or the jump that ladder or snake make it take
    public void pr(Player p,int pt){
        System.out.println("Player position Floor - "+p.getPos());
        System.out.println(p.getName()+" has reached an "+this.nfloor);
        System.out.println("Total points "+(pt+this.points));
    }
}
