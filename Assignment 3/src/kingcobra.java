public final class kingcobra extends snake{
    public kingcobra(int i){
        super(8,"King Cobra floor ",-4,i);
    }
    @Override
    public int move(Player p,int pts){
        this.pr(p,pts);
        p.setposnchances(this.fall);
        this.pr2(p,pts+this.points);
        return this.points+1;

    }
}
