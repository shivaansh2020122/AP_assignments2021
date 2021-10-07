import java.io.*;
import java.util.*;


public class Main {
    private HashMap<String,citizen> rclist =new HashMap<>();
    private HashMap<String,vaccine> vac = new HashMap<>();


    public void addvac(){

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
                choice=1;
            }
            else if(choice==2){
                choice=2;
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
                if(age>=18){
                    citizen ob= new citizen(name,uid,age);
                    cowin.registercitizen(ob);
                }
                else {
                    System.out.println("Age less than 18 years ");
                }
                }


            else if(choice==4){
                choice=4;
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
                choice=8;
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
