public class slot {
    private int d;
    public int quan;
    private String  vname;

    public slot(int d,int quan,String n){
            this.d=d;
            this.quan=quan;
            this.vname=n;

    }
    //used when hospital adds slots
    public void pr(){
        System.out.println("for Day "+this.d+" Available quantity "+this.quan+" of "+this.vname);
    }
    //while booking printing slots
    public void prslot(){

    }
}
