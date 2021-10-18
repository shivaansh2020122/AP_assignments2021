import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class student implements user {
    private final String name;
    //private Main course;

    public student(String n){//,Main c){
        this.name=n;
        //this.course=c;
    }

    @Override
    public String getname() {
        return this.name;
    }

    @Override
    public void view_lec(ArrayList<lecture> l){
        for(int i=0;i<l.size();i++){
            l.get(i).show();
            System.out.println("");
        }
    }
    //it will show all open and closed asssignments
    //as allowed in comments by vasu sir on Srijan Question
    //otherwise just one if needed to be added
    @Override
    public void view_assignment(ArrayList<assessment> a){
        for(int i=0;i<a.size();i++){
            System.out.print("ID: "+i+" ");
            a.get(i).view();
            System.out.println("----------");
        }
    }

    public void view_grades(ArrayList<assessment> assessments){
        System.out.println("Graded submissions");
        for(int i=0;i<assessments.size();i++){
            if((assessments.get(i).getopengradedstat(this)==false)&&assessments.get(i).getsubmittedstat(this)){
                assessments.get(i).getgradesinfo(this);
            }
        }
        System.out.println("");
        System.out.println("Ungraded submissions ");
        for(int i=0;i<assessments.size();i++){
            if(assessments.get(i).getsubmittedstat(this)&&assessments.get(i).getopengradedstat(this)){
                assessments.get(i).viewsub(this);
            }
        }

    }

    public void sub_assignment(ArrayList<assessment> a){
        int c=0;
        for(int i=0;i<a.size();i++){
            if(a.get(i).getopengradedstat(this)&&a.get(i).getstat()&&(!a.get(i).getsubmittedstat(this))){
                if(c==0){
                   c=1;
                   System.out.println("Pending assignments ");
                }
                System.out.print("ID: "+i+" ");
                a.get(i).view();
            }

        }
        if(c==0){
            System.out.println("No pending assignments ");
        }
        else {
            Scanner sc= new Scanner(System.in);
            System.out.print("Enter id of assessment ");
            int ch=sc.nextInt();
            sc.nextLine();
            a.get(ch).makesub(this);
        }

    }

    @Override
    public void add_cmts(ArrayList<comment> c,String cm){
        c.add(new comment(cm,(user)this));
    }
    @Override
    public void view_cmts(ArrayList<comment> c){
        if(c.size()>0) {
            for (int i = 0; i < c.size(); i++) {
                c.get(i).disp();
                System.out.println("");
            }
        }
        else {
            System.out.println("No comments till now");
        }
    }

}
