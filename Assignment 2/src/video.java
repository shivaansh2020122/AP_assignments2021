import java.util.Date;

public class video implements lecture {
    private final String title;
    private final String filename;
    private final Date obj;
    private final instructor i;
    public video(String t,String fname,instructor u){
        this.title=t;
        this.filename=fname;
        this.obj = new Date();
        this.i= u;
    }

    @Override
    public void show(){
        System.out.println("Title of video: "+ this.title);
        System.out.println("Video file: "+this.filename);
        System.out.println("Date of upload: "+this.obj);
        System.out.println("Uploaded by: "+this.i.getname());


    }

}
