import java.util.*;

public class assignment implements assessment{
    private String pstat;
    //pstat problem statement
    private int maxmarks;
    private boolean stat;
    private HashMap<student,submission> as;
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
    public void close(instructor i){
        this.stat=false;
    }

    @Override
    public void makesub(student a){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter filename of assignment: ");
        String fname= sc.next();
        if(fname.endsWith(".zip")){
            this.as.get(a).makesub(fname);
        }
        else{
            System.out.println("Error in name input of filename ");
        }
    }
}

