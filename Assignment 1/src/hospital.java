public class hospital {
   private String name;
   private String pin;
   private String id;
   hospital(String n,String p){
       this.name=n;
       this.pin=p;
       this.id="000000";
   }
   public void changid(int n){
       String temp="";
       for(int i=0;i<6-(Integer.toString(n)).length();i++){
           temp="0"+temp;
       }
       this.id=temp+Integer.toString(n);
   }
   public void pr(){
       System.out.println("Hospital name "+this.name+" pincode "+this.pin+" with id "+this.id);
   }

}
