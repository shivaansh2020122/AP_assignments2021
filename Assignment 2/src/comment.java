import java.util.Date;

public class comment {
    private String com;
    private Date oc;
    private user u;
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
