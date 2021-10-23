public abstract class snake extends floor {
    protected final int fall;
    public snake(int f,String n,int p){
        super(n,p);
        this.fall=-f;
    }

    public void pr2(Player p,int pt){
        System.out.println("Player position Floor - "+p.getPos());
        System.out.println(p.getName()+" has reached an Empty floor");
        System.out.println("Total points "+(pt+1));
    }
}
