import java.util.ArrayList;

public class citizen {
    private String name;
    private String uid;
    private int age;
    private String vacstat;
    private String vacname;
    private int next;
    //next date
    public int nd;
    //number of dozes
    public citizen(String n,String id,int r){
        this.name=n;
        this.uid=id;
        this.age=r;
        this.vacstat="Not Registered";
        this.vacname="Not applicable";
        this.next=0;
        this.nd=0;

    }
    public String retuid(){
        return this.uid;
    }
    public int retage(){
        return this.age;
    }
    public String getstat(){
        return this.vacstat;
    }
    public String getcitvacname(){
        return this.vacname;
    }
    public void setcitvacname(String s){
        this.vacname=s;
    }

    public String getcitName() {
        return this.name;
    }

    public int getNd() {
        return this.nd;
    }

    public int getNext() {
        return this.next;
    }

    public void setVacstat(String vacstat) {
        this.vacstat = vacstat;
    }
    public void setNd(){
        this.nd++;
    }
    public void setNext(int n){
        this.next=n;
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
    public void prc(){
        System.out.println("Citizen name "+this.name+" citizen age "+this.age+" and unique id "+this.uid);
    }
}
