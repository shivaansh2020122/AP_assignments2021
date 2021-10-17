public class quiz implements assessment {
    private String q;
    private boolean stat;
    private int maxmarks;

    public quiz(String a){
        this.q=a;
        this.stat=true;
        this.maxmarks=1;
    }
    @Override
    public void view(){
        System.out.println("Question : "+this.q);
    }
}
