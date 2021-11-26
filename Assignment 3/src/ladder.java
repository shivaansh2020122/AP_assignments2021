public abstract class ladder extends floor{
    protected int jump;
    public ladder(int jp,String n,int pts,int i){
        super(n, pts,i);
        this.jump=jp;
    }

    public void pr2(Player p,int pt){
        System.out.println("Player position Floor - "+p.getPos());
        System.out.println(p.getName()+" has reached an Empty floor");
        System.out.println("Total points "+(pt+1));
        //System.out.println("");
    }
}
