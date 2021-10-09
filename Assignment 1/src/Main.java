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
        if(this.vac.containsKey(n)){
            System.out.println("Vaccine with name already present ");
            return;
        }
        vaccine v = new vaccine(n,nd,gap);
        this.vlist.add(v);
        this.vac.put(n,v);
        this.vac.get(n).prd();
        //used to print vac details on adding them on portal

    }
    public void reghosp(hospital ho){
        //id based on size of array list
        String temp="";
        for(int i=0;i<6-(Integer.toString(this.h.size())).length();i++){
            temp="0"+temp;
        }
        ho.changeid(temp+Integer.toString(this.h.size()));
        this.h.add(ho);
        ho.prh();
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
        obj.prc();
    }

    public boolean searchprinthospitalpin(String p){
        int c=0;//could've directly used boolean variable but comfortable this way
        for(int i=0;i<this.h.size();i++){
            if(this.h.get(i).retpin().equals(p)){
                this.h.get(i).printdet();
                c=1;
            }
        }
        if(c==1){
            return true;
        }
        return false;
    }
    public boolean searchprinthospitalvacname(String vacname){
        int c1=0;int temp;
        for(int i=0;i<this.h.size();i++){

            if(this.h.get(i).printappslotforvacname(vacname)){
                if(c1==0){
                    c1=1;
                }
            }
        }
        if(c1==1){
            return true;
        }
        return false;
    }




    public static void main(String[] args) throws Exception {
	// write your code here
        Reader.init(System.in);

        Main cowin = new Main();
        System.out.println("Portal initialised ");
        while (true){
            System.out.println("---------------------------------");
            System.out.println("1. Add Vaccine");
            System.out.println("2. Register Hospital ");
            System.out.println("3. Register Citizen");
            System.out.println("4. Add Slot for Vaccination");
            System.out.println("5. Book Slot for Vaccination");
            System.out.println("6. List all slots for a hospital");
            System.out.println("7. Check Vaccination Status");
            System.out.println("8. Exit");
            System.out.println("---------------------------------");
            //System.out.println(" ");
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
                System.out.print("Enter patient Unique ID: ");
                String id=Reader.next();
                if(id.length()==12&&cowin.rclist.containsKey(id)) {
                    String stat=cowin.rclist.get(id).getstat();
                    if(stat.equals("Registered")||stat.equals("Partially vaccinated")){
                    System.out.println("1. Search by area");
                    System.out.println("2. Search by Vaccine");
                    System.out.println("3. Exit");
                    System.out.print("Enter choice ");
                    int ch = Reader.nextint();
                    if (ch == 1) {
                        //search by area
                        System.out.print("Enter pincode ");
                        String pincode =Reader.next();
                        boolean a= cowin.searchprinthospitalpin(pincode);
                        if(a){
                            System.out.println("Enter hospital id ");
                            String hid=Reader.next();
                            if(hid.length()==6&&(cowin.h.size()>Integer.parseInt(hid))){
                                if(cowin.h.get(Integer.parseInt(hid)).pin.equals(pincode)){
                                    //search for appropriate slot in the hospital
                                        int nslotsprinted=0;
                                        // number of slots printed
                                        if(cowin.h.get(Integer.parseInt(hid)).slts.size()==0){
                                            //System.out.println("No slots available");
                                            nslotsprinted=-1;
                                        }
                                        int l=cowin.h.get(Integer.parseInt(hid)).slts.size();
                                        for (int i=0;i<l;i++){
                                            if(cowin.h.get(Integer.parseInt(hid)).slts.get(i).retdayofslot()>=cowin.rclist.get(id).next) {
                                                if(stat.equals("Partially vaccinated")) {
                                                    if(cowin.h.get(Integer.parseInt(hid)).slts.get(i).retvacname().equals(cowin.rclist.get(id).getcitvacname())) {
                                                        System.out.println(i + "->" + "Day " + Integer.toString(cowin.h.get(Integer.parseInt(hid)).slts.get(i).retdayofslot()) + " quantity " + cowin.h.get(Integer.parseInt(hid)).slts.get(i).quan + " vaccine :" + cowin.h.get(Integer.parseInt(hid)).slts.get(i).retvacname());
                                                        nslotsprinted++;
                                                    }

                                                }
                                                else {
                                                    System.out.println(i + "->" + "Day " + Integer.toString(cowin.h.get(Integer.parseInt(hid)).slts.get(i).retdayofslot()) + " quantity " + cowin.h.get(Integer.parseInt(hid)).slts.get(i).quan + " vaccine :" + cowin.h.get(Integer.parseInt(hid)).slts.get(i).retvacname());
                                                    nslotsprinted++;
                                                }
                                            }
                                        }
                                        if(nslotsprinted>0) {
                                            System.out.print("Choose slot ");
                                            int cslot = Reader.nextint();
                                            //recheck
                                            if (cslot > l-1 || cslot < 0) {
                                                System.out.println("Invalid choice");
                                                continue;
                                            }
                                            if(stat.equals("Partially vaccinated")){
                                                if(!(cowin.h.get(Integer.parseInt(hid)).slts.get(cslot).retvacname().equals(cowin.rclist.get(id).getcitvacname()))){
                                                    System.out.println("Slot is not corresponding to the same vaccine ");
                                                    continue;
                                                }
                                                if(cowin.h.get(Integer.parseInt(hid)).retithslot(cslot).retdayofslot() < cowin.rclist.get(id).getNext()){
                                                    System.out.println("Invalid choice");
                                                    continue;
                                                }
                                            }

                                            vaccine v = cowin.vac.get(cowin.h.get(Integer.parseInt(hid)).slts.get(cslot).retvacname());
                                            cowin.h.get(Integer.parseInt(hid)).slts.get(cslot).quan--;
                                            if (cowin.h.get(Integer.parseInt(hid)).slts.get(cslot).quan < 0) {
                                                //kept in case some quantity initially was 0
                                                cowin.h.get(Integer.parseInt(hid)).slts.remove(cslot);
                                            } else {
                                                if (cowin.h.get(Integer.parseInt(hid)).slts.get(cslot).quan == 0) {
                                                    cowin.h.get(Integer.parseInt(hid)).slts.remove(cslot);
                                                }
                                                cowin.rclist.get(id).nd++;
                                                cowin.rclist.get(id).setcitvacname(v.getvacname());
                                                if (cowin.rclist.get(id).nd == v.getdozes()) {
                                                    cowin.rclist.get(id).vacstat = "Fully vaccinated";
                                                } else {
                                                    cowin.rclist.get(id).vacstat = "Partially vaccinated";
                                                }
                                                cowin.rclist.get(id).next = cowin.h.get(Integer.parseInt(hid)).retithslot(cslot).retdayofslot()+v.getgap();
                                                System.out.println(cowin.rclist.get(id).getcitName()+" vaccinated with "+cowin.rclist.get(id).getcitvacname());
                                            }
                                        }
                                        else {
                                            System.out.println("No slot available ");
                                        }

                                }
                                else{
                                    System.out.println("The hospital for id entered is not in that pincode");
                                }
                            }
                            else{
                                System.out.println("Such an id does not exist");
                            }

                        }
                        else {
                            System.out.println("No available hospital in that pincode ");
                        }


                    } else if (ch == 2) {
                        //search by vaccine
                        System.out.print("Enter vaccine name ");
                        String vname=Reader.next();


                        boolean a= cowin.searchprinthospitalvacname(vname);
                        //correction here needed

                        if(a){
                            System.out.println("Enter hospital id ");
                            String hid=Reader.next();
                            if(hid.length()==6&&(cowin.h.size()>Integer.parseInt(hid))){


                                //correction here

                                if(cowin.h.get(Integer.parseInt(hid)).searchslotvacname(vname)){
                                    //search for appropriate slot in the hospital
                                    int nslotsprinted=0;
                                    // number of slots printed
                                    //if(cowin.h.get(Integer.parseInt(hid)).slts.size()==0){
                                        //System.out.println("No slots available");
                                      //  nslotsprinted=-1;
                                    //}
                                    int l=cowin.h.get(Integer.parseInt(hid)).retslotsize();
                                    //retslotsize returns the size of hospital slts array list
                                    for (int i=0;i<l;i++){
                                        if(cowin.h.get(Integer.parseInt(hid)).retithslot(i).retvacname().equals(vname)) {
                                            if (cowin.h.get(Integer.parseInt(hid)).retithslot(i).retdayofslot() >= cowin.rclist.get(id).next) {
                                                if (stat.equals("Partially vaccinated")) {
                                                    if (cowin.h.get(Integer.parseInt(hid)).slts.get(i).retvacname().equals(cowin.rclist.get(id).getcitvacname())) {
                                                        System.out.println(i + "->" + "Day " + Integer.toString(cowin.h.get(Integer.parseInt(hid)).slts.get(i).retdayofslot()) + " quantity " + cowin.h.get(Integer.parseInt(hid)).slts.get(i).quan + " vaccine :" + cowin.h.get(Integer.parseInt(hid)).slts.get(i).retvacname());
                                                        nslotsprinted++;
                                                    }

                                                } else {
                                                    System.out.println(i + "->" + "Day " + Integer.toString(cowin.h.get(Integer.parseInt(hid)).slts.get(i).retdayofslot()) + " quantity " + cowin.h.get(Integer.parseInt(hid)).slts.get(i).quan + " vaccine :" + cowin.h.get(Integer.parseInt(hid)).slts.get(i).retvacname());
                                                    nslotsprinted++;
                                                }
                                            }
                                        }
                                    }
                                    if(nslotsprinted>0) {
                                        System.out.print("Choose slot ");
                                        int cslot = Reader.nextint();
                                        //recheck
                                        if (cslot > l-1 || cslot < 0) {
                                            System.out.println("Invalid choice");
                                            continue;
                                        }
                                        if(stat.equals("Partially vaccinated")){
                                            if(!(cowin.h.get(Integer.parseInt(hid)).slts.get(cslot).retvacname().equals(cowin.rclist.get(id).getcitvacname()))){
                                                System.out.println("Slot is not corresponding to the same vaccine ");
                                                continue;
                                            }
                                            if(cowin.h.get(Integer.parseInt(hid)).retithslot(cslot).retdayofslot() < cowin.rclist.get(id).getNext()){
                                                System.out.println("Invalid choice");
                                                continue;
                                            }
                                        }

                                        vaccine v = cowin.vac.get(cowin.h.get(Integer.parseInt(hid)).slts.get(cslot).retvacname());
                                        cowin.h.get(Integer.parseInt(hid)).slts.get(cslot).quan--;
                                        if (cowin.h.get(Integer.parseInt(hid)).slts.get(cslot).quan < 0) {
                                            //kept in case some quantity initially was 0
                                            cowin.h.get(Integer.parseInt(hid)).slts.remove(cslot);
                                        } else {
                                            if (cowin.h.get(Integer.parseInt(hid)).slts.get(cslot).quan == 0) {
                                                cowin.h.get(Integer.parseInt(hid)).slts.remove(cslot);
                                            }
                                            cowin.rclist.get(id).nd++;
                                            cowin.rclist.get(id).setcitvacname(v.getvacname());
                                            if (cowin.rclist.get(id).nd == v.getdozes()) {
                                                cowin.rclist.get(id).vacstat = "Fully vaccinated";
                                            } else {
                                                cowin.rclist.get(id).vacstat = "Partially vaccinated";
                                            }
                                            cowin.rclist.get(id).next = cowin.h.get(Integer.parseInt(hid)).retithslot(cslot).retdayofslot()+v.getgap();
                                            System.out.println(cowin.rclist.get(id).getcitName()+" vaccinated with "+cowin.rclist.get(id).getcitvacname());
                                        }
                                    }
                                    else {
                                        System.out.println("No slot available ");
                                    }

                                }
                                else{
                                    System.out.println("The hospital for has no slot for the vaccine");
                                }
                            }
                            else{
                                System.out.println("Such an id does not exist");
                            }

                        }
                        else {
                            System.out.println("No available hospital with that vaccine");
                        }


                    }
                    else if (ch == 3) {
                        continue;
                    } else {
                        System.out.println("Invalid option");
                    }
                    }
                    else{
                        System.out.println("Person is fully vaccinated ");
                    }
                }
                else {
                    System.out.println("Id not applicable registered for patients ");
                }

            }
            else if(choice==6){
                System.out.print("Enter hospital id ");
                String hid = Reader.next();
                if(cowin.h.size()<=Integer.parseInt(hid)||hid.length()!=6){
                    System.out.println("No such hospital");
                    continue;
                }
                if(cowin.h.get(Integer.parseInt(hid)).retslotsize()==0){
                    System.out.println("No slots available ");
                    continue;
                }
                for(int i=0;i<cowin.h.get(Integer.parseInt(hid)).retslotsize();i++){
                    System.out.println("Day "+Integer.toString(cowin.h.get(Integer.parseInt(hid)).retithslot(i).retdayofslot())+" "+cowin.h.get(Integer.parseInt(hid)).retithslot(i).retvacname()+" available quantity "+Integer.toString(cowin.h.get(Integer.parseInt(hid)).retithslot(i).getQuan()));
                }

            }
            else if(choice==7){
                System.out.print("Enter citizen id ");
                String id= Reader.next();
                if(cowin.rclist.containsKey(id)){
                    System.out.println(cowin.rclist.get(id).getstat());
                    if(cowin.rclist.get(id).getstat().equals("Registered")){
                        continue;
                    }
                    System.out.println("Vaccine given "+cowin.rclist.get(id).getcitvacname());
                    System.out.println("Number of dozes given  "+Integer.toString(cowin.rclist.get(id).getNd()));
                    if(cowin.rclist.get(id).getstat().equals("Partially vaccinated")){
                        System.out.println("Next due date "+Integer.toString(cowin.rclist.get(id).getNext()));

                    }
                }
                else{
                    System.out.println("No such citizen exists ");
                }
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
