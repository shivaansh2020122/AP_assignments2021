import java.io.*;
import java.util.*;


public class Main {
    private ArrayList<vaccine> vlist;
    //used to easily display and easily get name of corresponding in hashmap
    private HashMap<String,citizen> rclist;
    //unique id citizen map
    private HashMap<String,vaccine> vac;
    private ArrayList<hospital> h;
    public Main(){
        this.vlist= new ArrayList<>();
        this.rclist=new HashMap<>();
        this.vac= new HashMap<>();
        this.h= new ArrayList<>();
    }



    public void addvac(String n,int nd,int gap){
        vaccine v = new vaccine(n,nd,gap);
        this.vlist.add(v);
        this.vac.put(n,v);
        this.vac.get(n).prd();
        //

    }
    public void reghosp(hospital h){
        this.h.add(h);
        //id based on size of array list
        h.changid(this.h.size());
        h.pr();
    }
    public void registercitizen(citizen obj){
        if(this.rclist.size()>0){
            if(this.rclist.containsKey(obj.retuid())){
                System.out.println("This id has already been registered on portal");
                return;
            }
            obj.vacstat="Registered";
            this.rclist.put(obj.retuid(),obj);

        }
        obj.vacstat="Registered";
        this.rclist.put(obj.retuid(),obj);
        obj.pr();
    }
    public void addsforhosp(String id,int d,int quan,String n){
        //id is hospital id
        //n is name of vaccine]
        //d is day of its administration

    }



    public static void main(String[] args) throws Exception {
	// write your code here
        Reader.init(System.in);
        System.out.println("Let's go");
        Main cowin = new Main();
        while (true){
            System.out.println(" ");
            System.out.println("1. Add Vaccine");
            System.out.println("2. Register Hospital ");
            System.out.println("3. Register Citizen");
            System.out.println("4. Add Slot for Vaccination");
            System.out.println("5. Book Slot for Vaccination");
            System.out.println("6. List all slots for a hospital");
            System.out.println("7. Check Vaccination Status");
            System.out.println("8. Exit");
            System.out.println(" ");
            int choice=Reader.nextint();
            if(choice==1){
                System.out.print("Enter vaccine name ");
                String name= Reader.next();
                System.out.print("Enter number of dozes required for the vaccine ");
                int nd= Reader.nextint();
                System.out.print("Enter the gap between dozes of the vaccine ");
                int gap=Reader.nextint();
                cowin.addvac(name,nd,gap);
            }
            else if(choice==2){
                System.out.print("Enter name of Hospital ");
                String name= Reader.next();
                System.out.print("Enter pincode ");
                String pin= Reader.next();
                hospital h= new hospital(name,pin);
                cowin.reghosp(h);
            }
            else if(choice==3){
                System.out.print("Enter citizen name ");
                String name=Reader.next();
                //System.out.println("");
                System.out.print("Enter age ");
                int age=Reader.nextint();
                //System.out.println("");
                System.out.print("Enter Unique id ");
                String uid=Reader.next();
                //System.out.println("");
                citizen ob= new citizen(name,uid,age);
                if(ob.retage()>=18){
                    cowin.registercitizen(ob);
                }
                else {
                    System.out.println("Age less than 18 years ");
                }
                }


            else if(choice==4){
                System.out.print("Enter hospital id ");
                String hid=Reader.next();
                if(hid.length()==6&&(cowin.h.size()>Integer.parseInt(hid))){
                    System.out.print("Enter number of slots you wish to add ");
                    int n_o_sl= Reader.nextint();
                    for(int i=0;i<n_o_sl;i++){
                        System.out.print("Enter day number ");
                        int dno=Reader.nextint();
                        System.out.print("Enter Quantity ");
                        int q= Reader.nextint();
                        System.out.println("Select vaccine ");
                        for(int j=0;j<cowin.vlist.size();j++){
                            System.out.println(j+" "+cowin.vlist.get(j).getvacname());
                        }
                        int a= Reader.nextint();
                        if(a>=cowin.vlist.size()|| a<0){
                            System.out.println("Invalid input for vaccine");
                        }
                        else{
                            String name=cowin.vlist.get(a).getvacname();
                            cowin.h.get(Integer.parseInt(hid)).addslot(dno,q,name);

                        }

                    }

                }
                else{
                    System.out.println("Hospital not registered or invalid id");
                }

            }
            else if(choice==5){
                choice=5;
            }
            else if(choice==6){
                choice=6;
            }
            else if(choice==7){
                choice=7;
            }
            else if(choice==8){
                break;
            }
            else {
                System.out.println("Invalid choice");
            }
        }
        //System.out.println(cowin.rclist);
    }
}



class Reader {

    static BufferedReader reader;
    static StringTokenizer tokenizer;

    static void init(InputStream input) {
        reader = new BufferedReader(new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }

    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            //TODO add check for eof if necessary
            tokenizer = new StringTokenizer(
                    reader.readLine() );
        }
        return tokenizer.nextToken();
    }

    static int nextint() throws IOException {
        return Integer.parseInt( next() );
    }

    static long nextlong() throws IOException {
        return Long.parseLong( next() );
    }

    static double nextdouble() throws IOException {
        return Double.parseDouble( next() );
    }

}
