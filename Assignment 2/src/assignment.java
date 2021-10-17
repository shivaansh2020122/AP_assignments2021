public class assignment implements assessment{
    private String pstat;
    //pstat problem statement
    private int maxmarks;
    private boolean stat;

    public assignment(String a,int m){
        this.pstat=a;
        this.maxmarks=m;
        this.stat=true;
    }
    @Override
    public void view(){
        System.out.print("Assignment : "+this.stat+" Max marks "+this.maxmarks);

    }
}

