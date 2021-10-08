public class vaccine {
    private String name;
    private int nd;
    //number of doses
    private int gap;
    public vaccine(String n,int ndo,int g){
        this.name=n;
        this.nd=ndo;
        this.gap=g;

    }
    public String getvacname(){
        return this.name;
    }
    public void prd(){
        System.out.println("Name of vaccine "+this.name+" Number of dozes required "+this.nd+" gap between dozes "+this.gap);
    }
}
