import java.io.*;
import java.util.*;


public class Main {
    private ArrayList<instructor> instructors;
    private ArrayList<student> students;
    private ArrayList<lecture> material;
    private ArrayList<comment> cmts;
    private ArrayList<assessment> assessments;

    public Main(){
        this.instructors=new ArrayList<>();
        this.students=new ArrayList<>();
        this.material=new ArrayList<>();
        this.cmts=new ArrayList<>();
        this.assessments=new ArrayList<>();
    }
    public void pr_avalaible_instructors(){
        for(int i=0;i<this.instructors.size();i++){
            System.out.println(i+" "+this.instructors.get(i).getname());
        }
    }
    public void pr_avaiable_students(){
        for(int i=0;i<this.students.size();i++){
            System.out.println(i+" "+this.students.get(i).getname());
        }
    }

    public static void main(String[] args) {
	// write your code here
        Main backpack= new Main();

        Scanner sc= new Scanner(System.in);
        while(true) {
            System.out.println("Welcome to Backpack\n" +
                    "1. Enter as instructor\n" +
                    "2. Enter as student\n" +
                    "3. Exit");
            int choice;
            choice = sc.nextInt();
            if (choice == 1) {
                System.out.println("Instructors ");
                backpack.pr_avalaible_instructors();
                System.out.println("Choose id ");
                int c = sc.nextInt();
                if (c >= backpack.instructors.size() || c < 0) {
                    System.out.println("This is not a valid choice ");
                }
                else {
                    while (true) {
                        user u = backpack.instructors.get(c);
                        System.out.println("Welcome " + u.getname());
                        System.out.println("INSTRUCTOR MENU\n" +
                                "1. Add class material\n" +
                                "2. Add assessments\n" +
                                "3. View lecture materials\n" +
                                "4. View assessments\n" +
                                "5. Grade assessments\n" +
                                "6. Close assessment\n" +
                                "7. View comments\n" +
                                "8. Add comments\n" +
                                "9. Logout");
                        int choice1 = sc.nextInt();
                        if (choice1 == 1) {
                            System.out.println("1. Add Lecture Slide\n" +
                                    "2. Add Lecture Video");
                            int n=sc.nextInt();
                            lecture m;
                            if(n==1||n==2){
                                if(n==1) {
                                    System.out.print("Enter topic of slides ");
                                    String t = sc.nextLine();
                                    System.out.print("Enter number of slides ");
                                    int nslides = sc.nextInt();
                                    String con[] = new String[nslides];
                                    System.out.println("Enter content of slides ");
                                    for (int i = 0; i < nslides; i++) {
                                        System.out.println("Content of slide " + (i + 1) + ": ");
                                        con[i] = sc.nextLine();
                                    }
                                    m = new slides(t, con, (instructor) u);
                                    ((instructor)u).addclass(backpack.material, m);
                                }
                                if(n==2){
                                    System.out.println("Enter topic of video");
                                    String t= sc.nextLine();
                                    System.out.println("Enter filename ");
                                    String fname= sc.nextLine();
                                    if(fname.endsWith(".mp4")){
                                        m= new video(t,fname,(instructor) u);
                                        ((instructor)u).addclass(backpack.material, m);
                                    }
                                    else{
                                        System.out.println("Invalid format for filename ");
                                    }

                                }

                            }
                            else {
                                System.out.println("Invalid choice ");
                            }

                        }
                        else if(choice1==2){
                            System.out.println("1. Add Assignment\n" +
                                    "2. Add Quiz");
                            int ch=sc.nextInt();
                            assessment a;
                            if(ch==1){
                                System.out.print("Enter problem statement: ");
                                String p= sc.nextLine();
                                System.out.print("Enter max marks: ");
                                int m= sc.nextInt();
                                a=new assignment(p,m, backpack.students);
                                ((instructor)u).addassesment(backpack.assessments,a);

                            }
                            else if(ch==2){
                                System.out.print("Enter quiz question: ");
                                String p = sc.nextLine();
                                a=new quiz(p, backpack.students);
                                ((instructor)u).addassesment(backpack.assessments,a);
                            }
                            else {
                                System.out.println("Invalid choice ");
                            }

                        }
                        else if(choice1==3){
                            u.view_lec(backpack.material);

                        }
                        else if(choice1==4){
                            u.view_assignment(backpack.assessments);
                        }
                        else if(choice1==5){
                            continue;
                        }
                        else if(choice1==6){
                            continue;
                        }
                        else if(choice1==7){

                        }

                        else if (choice1 == 9) {
                            break;
                        }
                        else {
                            System.out.println("Invalid choice");
                                    }
                                }
                        }
                    }
            else if(choice==2){
                System.out.println("Students");
                backpack.pr_avaiable_students();
            }
            else if(choice==3){
                break;
            }
            else{
                System.out.println("Invalid input ");
            }

        }

    }
}
