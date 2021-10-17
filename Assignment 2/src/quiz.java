public class quiz implements assessment {
    private String q;
    private boolean stat;

    public quiz(String a){
        this.q=a;
        this.stat=true;
    }
    @Override
    public void view(){
        System.out.println("Question : "+this.q);
    }
}
