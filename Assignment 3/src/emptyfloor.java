public final class emptyfloor extends floor{
    public emptyfloor(int i){
        super("Empty floor ",1,i);
    }
    @Override
    public int move(Player p,int pts){
            pr(p,pts);
            return this.points;
    }
}
