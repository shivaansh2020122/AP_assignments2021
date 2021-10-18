import java.util.Date;

public class comment {
    private final String com;
    private final Date oc;
    private final user u;
    //date of comment (oc)
    public comment(String c,user a){
        this.com=c;
        this.oc = new Date();
        this.u=a;

    }
    public void disp(){
        System.out.println(this.com+" - "+ this.u.getname());
        System.out.println(this.oc);
    }

}
