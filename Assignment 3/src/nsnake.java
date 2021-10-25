public final class nsnake extends snake{
    public nsnake(){
        super(4,"Normal snake floor ",-2);

    }
    @Override
    public int move(Player p,int pts){
        this.pr(p,pts);
        p.setposnchances(this.fall);
        this.pr2(p,pts+this.points);
        return this.points+1;

    }
}

