import java.util.Date;

public class video implements lecture {
    private String topic;
    private String filename;
    private Date obj;

    public video(String t,String fname){
        this.topic=t;
        this.filename=fname;
        this.obj = new Date();
    }

    @Override
    public void show(){

    }

}
