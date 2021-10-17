import javax.swing.*;
import java.util.ArrayList;

public class student implements user {
    private final String name;

    public student(String n){
        this.name=n;
    }

    @Override
    public String getname() {
        return this.name;
    }

    @Override
    public void view_lec(ArrayList<lecture> l){
        for(int i=0;i<l.size();i++){
            l.get(i).show();
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
