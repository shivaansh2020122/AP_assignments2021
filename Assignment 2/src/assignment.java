import java.util.*;

public class assignment implements assessment{
    private final String pstat;
    //pstat problem statement
    private final int maxmarks;
    private boolean stat;
    private final HashMap<student,submission> as;
    //as - assignment submission

    public assignment(String a, int m, ArrayList<student> s){
        this.pstat=a;
        this.maxmarks=m;
        this.stat=true;
        this.as=new HashMap<>();
        for(int i=0;i<s.size();i++){
            this.as.put(s.get(i),new submission());
        }
    }
    @Override
    public void view(){
        System.out.println("Assignment : "+this.pstat+" Max marks "+this.maxmarks);

    }
    @Override
    public boolean getstat(){
        return this.stat;
    }

    @Override
    public boolean getopengradedstat(student a){
        return this.as.get(a).getgradedstat();
    }

    @Override
    public boolean getsubmittedstat(student a){
        return this.as.get(a).getmadesub();
    }

    @Override
    public void close(instructor i){
        this.stat=false;
    }

    @Override
    public void makesub(student a){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter filename of assignment: ");
        String fname= sc.next();
        if(fname.endsWith(".zip")){
            this.as.get(a).makesubmission(fname);
        }
        else{
            System.out.println("Error in name input of filename ");
        }
    }

    @Override
    public void viewsub(student s){
        this.as.get(s).viewsubmitted();

    }
    @Override
    public void maxmarks(instructor i){
        System.out.println("Max marks "+this.maxmarks);
    }

    @Override
    public void gradation(student s,int m,instructor i){
        this.as.get(s).grade(i,m);
    }

    @Override
    public void getgradesinfo(student s){
        this.as.get(s).viewgradesstudent();
    }

}

