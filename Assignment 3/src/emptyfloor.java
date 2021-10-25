public final class emptyfloor extends floor{
    public emptyfloor(){
        super("Empty floor ",1);
    }
    @Override
    public int move(Player p,int pts){
            pr(p,pts);
            return this.points;
    }
}
