public class submission {
    private String sub;
    private int mar;
    //marks
    private instructor i;
    private boolean msub;
    //submitted or not
    public submission(){
        this.sub="";
        this.mar=-1;
        this.i=null;
        this.msub=false;
    }
    public void makesubmission(String s){
        this.sub=s;
        this.msub=true;
    }
    public void grade(instructor i,int m){
        this.mar=m;
        this.i=i;
    }
    //true implying non graded till now
    public boolean getgradedstat(){
        if(this.i==null){
            return true;
        }
        return false;
    }

    public boolean getmadesub(){
        return this.msub;
    }
    //whether submitted or not

    public void viewsubmitted(){
        System.out.println("Submission "+this.sub);
    }

    public void viewgradesstudent(){
        System.out.println(this.sub);
        System.out.println("Marks scored "+this.mar);
        System.out.println("Graded by "+this.i.getname());
    }
}
