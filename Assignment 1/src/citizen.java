import java.util.ArrayList;

public class citizen {
    private String name;
    private String uid;
    private int age;
    public String vacstat;
    public citizen(String n,String id,int r){
        this.name=n;
        this.uid=id;
        this.age=r;
        this.vacstat="Not Registered";
    }
    public String retuid(){
        return this.uid;
    }

   // public boolean checkcitizen(ArrayList<citizen> c, String n, String id, int r){
     //   boolean a=true;
       // for(int i=0;i<c.size();i++){
         //   if(c.get(i).name.equals(n)){
           //     if(c.get(i).age==r && c.get(i).uid.equals(id)){
             //       a=false;
               //     break;
                //}
            //}
        //}
        //return a;
    //}
    public void pr(){
        System.out.println("Citizen name "+this.name+" citizen age "+this.age+" and unique id "+this.uid);
    }
}
