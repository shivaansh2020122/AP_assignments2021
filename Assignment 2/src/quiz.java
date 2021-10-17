import java.util.*;

public class quiz implements assessment {
    private String q;
    private boolean stat;
    private int maxmarks;
    private HashMap<student,submission> as;

    public quiz(String a, ArrayList<student> s){
        this.q=a;
        this.stat=true;
        this.maxmarks=1;
        this.as=new HashMap<>();
        for(int i=0;i<s.size();i++){
            this.as.put(s.get(i),new submission());
        }
    }
    @Override
    public void view(){
        System.out.println("Question : "+this.q);
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
    public void makesub(student a){
        System.out.print(this.q+" ");
        Scanner sc = new Scanner(System.in);
        String s=sc.next();
        this.as.get(a).makesub(s);

    }

    @Override
    public void close(instructor i){
        this.stat=false;
    }
}
