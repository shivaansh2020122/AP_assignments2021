import java.util.ArrayList;

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

    @Override
    public void view_assignment(ArrayList<assessment> a){
        for(int i=0;i<a.size();i++){
            System.out.print("ID "+i);
            a.get(i).view();
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
