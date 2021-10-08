public class slot {
    private int d;
    public int quan;
    private String  vname;
    public slot(int d,int quan,String n){
            this.d=d;
            this.quan=quan;
            this.vname=n;

    }
    public void pr(){
        System.out.println("for Day "+this.d+" Available quantity "+this.quan+" of "+this.vname);
    }
}
