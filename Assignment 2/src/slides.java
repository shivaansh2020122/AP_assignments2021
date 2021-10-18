import java.util.Date;

public class slides implements lecture {
    private final String topic;
    private final String content[];
    private final Date obj;
    private final instructor i;
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
                System.out.println("Slide " + (i+1) + ": " + this.content[i]);
            }
            System.out.println("Number of slides " + this.content.length);
        }
        else {
            System.out.println("No slides inside");
        }
        System.out.println("Date of upload: "+this.obj);
        System.out.println("Uploaded by: "+this.i.getname());

    }

}
