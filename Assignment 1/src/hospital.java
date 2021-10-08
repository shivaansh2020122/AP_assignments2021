import java.util.ArrayList;

public class hospital {
   private String name;
   public String pin;
   private String id;
   public ArrayList<slot> slts;
   public hospital(String n,String p){
       this.name=n;
       this.pin=p;
       this.id="000000";
       this.slts= new ArrayList<>();

   }
   public void changeid(String id){
    this.id=id;
   }

   public void prh(){
       System.out.println("Hospital name "+this.name+" pincode "+this.pin+" with id "+this.id);
   }
   public void addslot(int d,int quan,String name){
       slot s = new slot(d,quan,name);
       this.slts.add(s);
       System.out.print("Slot added for "+this.id);
       s.pr();
   }
   public void printdet(){
       System.out.println(this.id+" "+this.name);
   }
   public String retpin(){
       return this.pin;
   }


}
