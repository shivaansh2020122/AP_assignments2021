import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public final class game {
    private final Tile[] carpet;
    private final player p;
    private final Random random;
    public game(){
        carpet= new Tile[20];
        p = new player();
        softToy[] softToys;
        random=new Random();
        softToys= new softToy[20];
        softToys[0]=new softToy("Hugsy");
        softToys[1]=new softToy("Teddy");
        softToys[2]=new softToy("Donald duck");
        softToys[3]=new softToy("Micky");
        softToys[4]=new softToy("Pink panther");
        softToys[5]=new softToy("Minion Kevin");
        softToys[6]=new softToy("Minion Stuart");
        softToys[7]=new softToy("Minion Bob");
        softToys[8]=new softToy("Beaver");
        softToys[9]=new softToy("Fluffy");
        softToys[10]=new softToy("Squishy");
        softToys[11]=new softToy("Pikachu");
        softToys[12]=new softToy("Jigglypuff");
        softToys[13]=new softToy("Evee");
        softToys[14]=new softToy("Cuddles");
        softToys[15]=new softToy("Boo");
        softToys[16]=new softToy("Stewie");
        softToys[17]=new softToy("Tom");
        softToys[18]=new softToy("Jerry");
        softToys[19]=new softToy("Buzz");
        for(int i=0;i<20;i++){
            carpet[i]= new Tile(softToys[i]);
        }

    }
    public boolean intdiv(){
        try {
            int a1=this.generaterandom();
            int a2=this.generaterandom();
            System.out.println("Calculate the result of "+a1+" divided by "+a2);
            genericCalc<Integer> c=new genericCalc<Integer>(a1,a2);
            Scanner sc=new Scanner(System.in);
            int a3=sc.nextInt();
            sc.nextLine();
            if(c.calc(a3)){
                System.out.println("Correct answer");
                return true;
            }
            System.out.println("Incorrect answer");
            return false;
        }
        catch (Exception e){
            e.getMessage();
            return intdiv();

        }
    }
    public boolean strconcat(){
        try {
            String a1=this.generateString();
            String a2= this.generateString();
            System.out.println("Calculate the concatenation of strings "+a1+" and "+a2);
            Scanner sc=new Scanner(System.in);
            String a3=sc.nextLine();
            genericCalc<String> c=new genericCalc<String>(a1,a3);
            if(c.calc(a3)){
                System.out.println("Correct answer");
                return true;
            }
            System.out.println("Incorrect answer");
            return false;
        }
        catch (Exception e){
            e.getMessage();
            return strconcat();
        }
    }
    public void oddjump(int r){
        try {
            System.out.println("Question answer round. Integer or strings? ");
            String s;
            Scanner sc= new Scanner(System.in);
            s= sc.nextLine();
            if(s.equals("integer")){
                if(this.intdiv()){
                    System.out.println("You won a "+this.carpet[r-1].getwhichToystr()+" soft toy");
                }
                else{
                    System.out.println("You did not win any toy");
                }
            }
            else if(s.equals("string")){
                if(this.strconcat()){
                    System.out.println("You won a "+this.carpet[r-1].getwhichToystr()+" soft toy");
                }
                else{
                    System.out.println("You did not win any toy");
                }
            }
            else {
                throw new invalidchoice("Invalid choice provided by the user");
            }

        }
        catch (Exception e){
            e.getMessage();
            oddjump(r);
        }

    }
    public String generateString(){
        String s="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String gen="";
        for(int i=0;i<4;i++){
            gen=gen+s.charAt(this.generaterandom(s.length()));
        }
        return gen;
    }

    public int generaterandom(){
        return random.nextInt();
        //generating random number

    }
    public int generaterandom(int n){
        return random.nextInt(n);
    }
    public static void main(String[] args) throws IOException {
        //System.out.println("hi");
        //Object a = 5;
        //System.out.println(a instanceof Integer);
        Scanner sc= new Scanner(System.in);
        String s;
        System.out.println("Hit enter to initialize the game");
        s= sc.nextLine();
        game g = new game();
        System.out.println("Game is ready");
        int a=0;
        String number[]={"first hop ","second hop","third hop","fourth hop","fifth hop"};
        while(a<5){
            System.out.println("Hit enter for you "+number[a]);
            s=sc.nextLine();
            int r= 1+g.generaterandom(21);
            try {
                if(r>=21){
                    throw new beyondCarpet("You are too energetic and zoomed past all the tiles. Muddy Puddle Splash!");
                }
                if(r%2==0){
                    System.out.println("You landed on tile "+r);
                    g.p.setPos(r);
                    System.out.println("You won a "+g.carpet[r-1].getwhichToystr()+" soft toy");
                    g.p.addinbuck(g.carpet[r-1].getSoft().Clone());

                }
                else{
                    System.out.println("You landed on tile "+r);
                    g.p.setPos(r);
                    g.oddjump(r);
                }
            }
            catch (beyondCarpet b){
                b.getMessage();
            }
            a++;
            g.p.setPos(0);
        }
        System.out.println("Game over");
        System.out.println("Soft toys won by you are: ");
        g.p.prbucket();
    }
}
