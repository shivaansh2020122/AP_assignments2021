import java.util.Date;

public class slides implements lecture {
    private String topic;
    private String content[];
    private Date obj;
    public slides(String t,String []c){
        this.topic=t;
        this.content=c;
        this.obj= new Date();

    }
    @Override
    public void show(){

    }

}
