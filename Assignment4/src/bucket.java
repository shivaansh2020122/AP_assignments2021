import java.util.ArrayList;

public final class bucket {
    private final ArrayList<softToy> s;
    public bucket(){
        s= new ArrayList<>();
    }
    public void add(softToy a){
        s.add(a);
    }
    public void pr() {
        if(s.size()==0){
            System.out.println("Bucket is empty");
        }
        else {

            for (int i = 0; i < s.size() - 1; i++) {
                System.out.print(s.get(i).getStoy() + " ,");
            }
            System.out.println(s.get(s.size() - 1).getStoy());
        }
    }
}
