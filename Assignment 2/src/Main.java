import java.io.*;
import java.util.*;


public class Main {
    private ArrayList<instructor> instructors;
    private ArrayList<student> students;
    private ArrayList<lecture> material;

    public Main(){
        this.instructors=new ArrayList<>();
        this.students=new ArrayList<>();
    }
    public void pr_avalaible_instructors(){
        for(int i=0;i<this.instructors.size();i++){
            System.out.println(i+" "+this.instructors.get(i).getinstructorsname());
        }
    }
    public void pr_avaiable_students(){
        for(int i=0;i<this.students.size();i++){
            System.out.println(i+" "+this.students.get(i).getstudentName());
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
                        System.out.println("Welcome " + backpack.instructors.get(c).getinstructorsname());
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

                        }
                        else if(choice1==2){
                            System.out.println("1. Add Assignment\n" +
                                    "2. Add Quiz");
                        }
                        else if(choice1==3){

                        }
                        else if(choice1==4){

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
