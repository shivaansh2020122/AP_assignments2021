import java.util.Scanner;

public final class Game {

    private final floor rfoor[];
    //rfloor - real floor
    private final Dice d;
    private final Player p[];
    private int points[];
    private static Scanner sc;
    public Game(Player p1[]){
        d=new Dice(2);
        rfoor= new floor[14];
        rfoor[0]= new emptyfloor(0);
        rfoor[1] = new emptyfloor(1);
        rfoor[2]= new elevator(2);
        rfoor[3]= new emptyfloor(3);
        rfoor[4]= new emptyfloor(4);
        rfoor[5]= new nsnake(5);
        rfoor[6]=new emptyfloor(6);
        rfoor[7]= new emptyfloor(7);
        rfoor[8]= new nladder(8);
        rfoor[9]= new emptyfloor(9);
        rfoor[10]= new emptyfloor(10);
        rfoor[11]= new kingcobra(11);
        rfoor[12]=new emptyfloor(12);
        rfoor[13]= new emptyfloor(13);
        p=p1;
        points=new int[p1.length];
    }
    public void play(int n){
        int c=0;
        int i=0;
        while (true){

                System.out.print("Hit enter to roll");
                sc.nextLine();
                this.d.roll();
                c=this.d.getFaceValue();
                System.out.println("Dice gave " + this.d.getFaceValue());
                //System.out.println("");

            if(this.p[i%n].getPos()<0) {
                if (this.d.getFaceValue() != 1) {
                    c = 0;
                    System.out.println("Game cannot start until you get 1");
                    System.out.println("");
                    i++;
                    continue;
                    //game.p.setposnchances(0);
                }
            }
            if(c+this.p[i%n].getPos()<=13) {
                this.p[i%n].setposnchances(c);
                c = this.rfoor[this.p[i%n].getPos()].move(this.p[i%n], this.points[i%n]);
                this.setPoints(c,i%n);
                if(this.p[i%n].getPos()==13){
                    System.out.println("Game over ");
                    System.out.println(this.p[i%n].getName()+" has accummulated "+this.points[i%n]+" points ");
                    if(n>1){
                        System.out.println(this.p[i%n].getName()+" has reached first ");
                        System.out.println("Best of luck for the next time to the rest of the players");
                    }
                    break;
                }
                System.out.println("");

            }
            else{
                if(n>1) {
                    System.out.println("Player " + ((i % n)+1) + " cannot move ");
                    System.out.println("");
                }
                else{
                    System.out.println("Player cannot move ");
                    System.out.println("");
                }
            }

            i++;
        }
    }
    public void setPoints(int x,int i){
        this.points[i]+=x;
    }


    public static void main(String[] args) {
        // write your code here
        sc = new Scanner(System.in);
        System.out.println("Enter the number of players you want to have in the game ");
        int n=sc.nextInt();
        sc.nextLine();
        //this multiplayer just gives the winner and I could have added different number of faces for the die by changing just in the constructor but didn't because more faces just would've made the game short
        Player p1[] = new Player[n];
        for(int i=0;i<n;i++){
            int j=0;int k=0;
            System.out.println("Enter the player name and hit enter ");
            String name= sc.nextLine();
            while(j<i){
                if(p1[j].getName().equals(name)){
                    k++;
                }
                j++;
            }
            if(k!=0){
                System.out.println("Same name player already exists ");
                System.out.println("Player renamed to "+name+k);
                name=name+Integer.toString(k);
            }
            p1[i]= new Player(name);

        }

        Game game = new Game(p1);
        System.out.println("The game setup is ready");
        game.play(n);


    }
}
