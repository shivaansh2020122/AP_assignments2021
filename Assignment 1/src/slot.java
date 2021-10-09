public class slot {
    private int d;
    private int quan;
    private String  vname;

    public slot(int d,int quan,String n){
            this.d=d;
            this.quan=quan;
            this.vname=n;

    }
    //used when hospital adds slots
    public void pr(){
        System.out.println(" for Day "+this.d+" Available quantity "+this.quan+" of "+this.vname);
    }
    //while booking printing slots
    //public void prslot(){


    //}
    public String retvacname(){
        return this.vname;
    }
    public int retdayofslot(){
        return this.d;
    }
    public int getQuan(){
        return this.quan;
    }
    public void redQuan(){
        this.quan--;
    }
}
