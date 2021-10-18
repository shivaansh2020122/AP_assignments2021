import java.util.ArrayList;
import java.util.Scanner;

public class instructor implements user {
    private final String name;
    //private Main course;

    public instructor(String n){//,Main b){
        this.name=n;
        //this.course=b;
    }

    @Override
    public String getname(){
        return this.name;
    }


    //add lecture material
    public void addclass(ArrayList<lecture> l,lecture a){
        l.add(a);
    }

    public void addassesment(ArrayList<assessment> a,assessment b){
        a.add(b);
    }


    @Override
    public void view_lec(ArrayList<lecture> l){
        for(int i=0;i<l.size();i++){
            l.get(i).show();
            System.out.println("");

        }
    }

    //it will show all open and closed assigments
    @Override
    public void view_assignment(ArrayList<assessment> a){
        for(int i=0;i<a.size();i++){
            System.out.print("ID: "+i+" ");
            a.get(i).view();
            System.out.println("----------");
        }
    }

    public void close_assignments(ArrayList<assessment> a){
        int c=0;
        for(int i=0;i<a.size();i++){
            if(a.get(i).getstat()){
                if(c==0){
                    c=1;
                    System.out.println("List of open assignments ");
                }
                System.out.print("ID: "+i+" ");
                a.get(i).view();
                System.out.println("----------------");
            }
        }
        if(c!=0){
        System.out.println("Enter id of assignment to close ");
        Scanner sc=new Scanner(System.in);
        int ch= sc.nextInt();
        sc.nextLine();
        if(ch>0&&ch<a.size()){
        a.get(ch).close(this);}
        else {
            System.out.println("Invalid choice ");
        }
    }
        else {
            System.out.println("No open assignments ");
        }
    }

    //part 1 of grading
    public void grade_assessments1(ArrayList<assessment> assessments,ArrayList<student> students){
        Scanner sc= new Scanner(System.in);
        System.out.println("List of assessments ");
        for(int i=0;i<assessments.size();i++){
            System.out.print("ID: "+i+" ");
            assessments.get(i).view();
            System.out.println("----------------");

        }
        System.out.print("Enter ID of assessments to view submissions: ");

    }

    public boolean grade_assessments2(assessment a,ArrayList<student> students){
        int k=0;
        for(int i=0;i<students.size();i++){
            //might have to add a check for open assignments as well
            if(a.getopengradedstat(students.get(i))&& a.getsubmittedstat(students.get(i))){
                if(k==0){
                    k=1;
                    System.out.println("Choose ID from ungraded submission");
                }
                System.out.println(i+" "+students.get(i).getname());

            }
        }
        if(k==0){
            return false;
        }
        return true;

    }

    public void grade_view_sub(assessment assessments,student s){
            assessments.viewsub(s);
            assessments.maxmarks(this);
    }

    public void actual_grade(assessment a,student s,int m){
        a.gradation(s,m,this);
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
