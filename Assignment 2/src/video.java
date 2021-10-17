import java.util.Date;

public class video implements lecture {
    private String title;
    private String filename;
    private Date obj;
    private instructor i;
    public video(String t,String fname,instructor u){
        this.title=t;
        this.filename=fname;
        this.obj = new Date();
        this.i= u;
    }

    @Override
    public void show(){
        System.out.println("Title of video "+ this.title);
        System.out.println("Video file "+this.filename);
        System.out.println("Date of upload "+this.obj);
        System.out.println("uploaded by "+this.i.getname());


    }

}
