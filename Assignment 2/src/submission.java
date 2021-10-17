public class submission {
    private String sub;
    private int mar;
    //marks
    private instructor i;
    public submission(){
        this.sub="";
        this.mar=-1;
        this.i=null;
    }
    public void makesub(String s){
        this.sub=s;
    }
    public void grade(){

    }
    //true implying non graded till now
    public boolean getgradedstat(){
        if(this.i==null){
            return true;
        }
        return false;
    }
}
