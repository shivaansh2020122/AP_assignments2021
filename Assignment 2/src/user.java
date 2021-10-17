import java.util.ArrayList;

public interface user {

    public String getname();

    public void view_lec(ArrayList<lecture> l);

    public void add_cmts(ArrayList<comment> c,String cm);

    public void view_cmts(ArrayList<comment> c);


}
