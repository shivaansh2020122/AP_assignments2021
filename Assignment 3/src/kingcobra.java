public final class kingcobra extends snake{
    public kingcobra(){
        super(8,"King Cobra floor ",-4);
    }
    @Override
    public int move(Player p,int pts){
        this.pr(p,pts);
        p.setposnchances(this.fall);
        this.pr2(p,pts+this.points);
        return this.points+1;

    }
}
