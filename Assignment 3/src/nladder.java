public final class nladder extends ladder{
    public nladder(int i){
        super(4,"Normal ladder floor ",2,i);
    }
    @Override
    public int move(Player p,int pts){
        this.pr(p,pts);
        p.setposnchances(this.jump);
        this.pr2(p,pts+this.points);
        return this.points+1;

    }
}
