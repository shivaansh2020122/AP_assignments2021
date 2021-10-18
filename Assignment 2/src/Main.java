import java.io.*;
import java.util.*;


public class Main {
    private final ArrayList<instructor> instructors;
    private final ArrayList<student> students;
    private final ArrayList<lecture> material;
    private final ArrayList<comment> cmts;
    private final ArrayList<assessment> assessments;

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
        backpack.students.add(new student("S0"));
        backpack.students.add(new student("S1"));
        backpack.students.add(new student("S2"));
        backpack.instructors.add(new instructor("IO"));
        backpack.instructors.add(new instructor("I1"));


        Scanner sc= new Scanner(System.in);
        while(true) {
            System.out.println("Welcome to Backpack\n" +
                    "1. Enter as instructor\n" +
                    "2. Enter as student\n" +
                    "3. Exit");
            int choice;
            choice = sc.nextInt();
            sc.nextLine();
            if (choice == 1) {
                System.out.println("Instructors ");
                backpack.pr_avalaible_instructors();
                System.out.print("Choose id ");
                int c = sc.nextInt();
                sc.nextLine();
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
                        sc.nextLine();
                        if (choice1 == 1) {
                            System.out.println("1. Add Lecture Slide\n" +
                                    "2. Add Lecture Video");
                            int n=sc.nextInt();
                            sc.nextLine();
                            lecture m;
                            if(n==1||n==2){
                                if(n==1) {
                                    System.out.print("Enter topic of slides ");
                                    String t = sc.nextLine();
                                    //System.out.println(t);
                                    System.out.print("Enter number of slides ");
                                    int nslides = sc.nextInt();
                                    sc.nextLine();
                                    String con[] = new String[nslides];
                                    System.out.println("Enter content of slides ");
                                    for (int i = 0; i < nslides; i++) {
                                        System.out.print("Content of slide " + (i + 1) + ": ");
                                        con[i] = sc.nextLine();
                                    }
                                    m = new slides(t, con, (instructor) u);
                                    ((instructor)u).addclass(backpack.material, m);
                                }
                                if(n==2){
                                    System.out.print("Enter topic of video ");
                                    String t= sc.nextLine();
                                    System.out.print("Enter filename ");
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
                            sc.nextLine();
                            assessment a;
                            if(ch==1){
                                System.out.print("Enter problem statement: ");
                                String p= sc.nextLine();
                                System.out.print("Enter max marks: ");
                                int m= sc.nextInt();
                                sc.nextLine();
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

                            ((instructor) u).grade_assessments1(backpack.assessments, backpack.students);
                            int ch= sc.nextInt();
                            sc.nextLine();
                            assessment a = backpack.assessments.get(ch);
                            if(((instructor) u).grade_assessments2(a, backpack.students)){
                                ch= sc.nextInt();
                                sc.nextLine();
                                System.out.println("Submission: ");
                                student s= backpack.students.get(ch);
                                ((instructor) u).grade_view_sub(a,s);
                                System.out.print("Marks scored ");
                                int m= sc.nextInt();
                                sc.nextLine();
                                ((instructor) u).actual_grade(a,s,m);
                            }
                            else {
                                System.out.println("No ungraded submissions available ");
                            }

                        }
                        else if(choice1==6){
                            ((instructor) u).close_assignments(backpack.assessments);
                        }
                        else if(choice1==7){
                            u.view_cmts(backpack.cmts);
                        }
                        else if(choice1==8){
                            System.out.print("Enter comment ");
                            String a=sc.nextLine();
                            u.add_cmts(backpack.cmts,a);
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
                System.out.print("Choose id ");
                int c= sc.nextInt();
                sc.nextLine();
                while (true){
                    user u = backpack.students.get(c);
                    System.out.println("Welcome " + u.getname());
                    System.out.println("1. View lecture materials\n" +
                            "2. View assessments\n" +
                            "3. Submit assessment\n" +
                            "4. View grades\n" +
                            "5. View comments\n" +
                            "6. Add comments\n" +
                            "7. Logout");
                    int choice1= sc.nextInt();
                    sc.nextLine();
                    if(choice1==1){
                        u.view_lec(backpack.material);
                    }
                    else if(choice1==2){
                        u.view_assignment(backpack.assessments);
                    }
                    else if(choice1==3){
                        ((student)u).sub_assignment(backpack.assessments);
                    }
                    else if(choice1==4){
                        ((student) u).view_grades(backpack.assessments);
                    }
                    else if(choice1==5){
                        u.view_cmts(backpack.cmts);
                    }
                    else if(choice1==6){
                        System.out.print("Enter comment ");
                        String a = sc.nextLine();
                        u.add_cmts(backpack.cmts, a);
                    }
                    else if(choice1==7){
                        break;
                    }
                    else {
                        System.out.println("Invalid choice ");
                    }


                }


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
