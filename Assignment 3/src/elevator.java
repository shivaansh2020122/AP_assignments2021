public final class elevator extends ladder{
    public elevator(int i){
        super(8,"Elevator floor ",4,i);
    }
    @Override
    public int move(Player p,int pts){
        this.pr(p,pts);
        p.setposnchances(this.jump);
        this.pr2(p,pts+this.points);
        return this.points+1;

    }

}
