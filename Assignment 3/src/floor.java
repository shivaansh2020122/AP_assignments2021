public abstract class floor {
    protected final String nfloor;
    protected final int points;
    //nfloor = name of floor
    protected final int position;
    public floor(String n,int pts,int position){
        this.nfloor=n;
        this.points=pts;
        this.position=position;
    }
    public abstract int move(Player p,int pts);
    //dval is the dice value or the jump that ladder or snake make it take
    public void pr(Player p,int pt){
        System.out.println("Player position Floor - "+position);
        System.out.println(p.getName()+" has reached an "+this.nfloor);
        System.out.println("Total points "+(pt+this.points));
        //System.out.println("");
    }
}
