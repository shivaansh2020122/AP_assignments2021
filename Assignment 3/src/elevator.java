public class elevator extends ladder{
    public elevator(){
        super(8,"Elevator floor ",4);
    }
    @Override
    public int move(Player p,int pts){
        this.pr(p,pts);
        p.setposnchances(this.jump);
        this.pr2(p,pts+this.points);
        return this.points+1;

    }

}
