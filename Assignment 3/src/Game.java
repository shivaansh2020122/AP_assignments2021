import java.util.Scanner;

public class Game {

    private final floor rfoor[];
    //rfloor - real floor
    private final Dice d;
    private final Player p;
    private int points;
    public static Scanner sc;
    public Game(String name){
        d=new Dice(2);
        rfoor= new floor[14];
        rfoor[0]= new emptyfloor();
        rfoor[1] = new emptyfloor();
        rfoor[2]= new elevator();
        rfoor[3]= new emptyfloor();
        rfoor[4]= new emptyfloor();
        rfoor[5]= new nsnake();
        rfoor[6]=new emptyfloor();
        rfoor[7]= new emptyfloor();
        rfoor[8]= new nladder();
        rfoor[9]= new emptyfloor();
        rfoor[10]= new emptyfloor();
        rfoor[11]= new kingcobra();
        rfoor[12]=new emptyfloor();
        rfoor[13]= new emptyfloor();
        p= new Player(name);

    }
    public void play(){
        int c=0;
        while (true){
            if(this.p.getPos()==13){
                System.out.println("Game over ");
                System.out.println(this.p.getName()+" has accummulated "+this.points+" points ");
                break;
            }
                System.out.print("Hit enter to roll");
                sc.nextLine();
                this.d.roll();
                c=this.d.getFaceValue();
                System.out.println("Dice gave " + this.d.getFaceValue());

            if(this.p.getPos()<0) {
                if (this.d.getFaceValue() != 1) {
                    c = 0;
                    System.out.println("Game cannot start until you get 1");
                    continue;
                    //game.p.setposnchances(0);
                }
            }
            if(c+this.p.getPos()<=13) {
                this.p.setposnchances(c);
                c = this.rfoor[this.p.getPos()].move(this.p, this.points);
                this.setPoints(c);
            }
            else{
                System.out.println("Player cannot move ");
            }


        }
    }
    public void setPoints(int x){
        this.points+=x;
    }


    public static void main(String[] args) {
        // write your code here
        sc = new Scanner(System.in);
        System.out.println("Enter the player name and hit enter ");
        String name= sc.nextLine();
        Game game = new Game(name);
        System.out.println("The game setup is ready");
        game.play();


    }
}
