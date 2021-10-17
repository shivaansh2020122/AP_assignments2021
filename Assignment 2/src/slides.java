import java.util.Date;

public class slides implements lecture {
    private String topic;
    private String content[];
    private Date obj;
    private instructor i;
    public slides(String t,String []c,instructor l){
        this.topic=t;
        this.content=c;
        this.obj= new Date();
        this.i=l;

    }

    @Override
    public void show(){
        System.out.println("Title: "+this.topic);
        if(this.content.length>0) {
            for (int i = 0; i < content.length; i++) {
                System.out.println("Slide " + i + ": " + this.content[i]);
            }
            System.out.println("Number of slides " + this.content.length);
        }
        else {
            System.out.println("No slides inside");
        }
        System.out.println("Date of upload "+this.obj);
        System.out.println("Uploaded by "+this.i.getname());

    }

}
