public final class genericCalc<T>{
    private T a;
    private T b;
    public void set(T x,T y){
        if((x instanceof String||x instanceof Integer)&&((y instanceof Integer)||(y instanceof String))) {
            this.a = x;
            this.b = y;
        }
    else{
        throw new notvalidinput("Some input passed to ");
        }
    }
    public boolean calc(T x){
        if(x instanceof Integer) {
            return (((Integer)a/(Integer)b)==(Integer)x);
        }

        else if(x instanceof String){
//            System.out.println(((String)b));
//            System.out.println(x);
//            System.out.println((((String)a+(String)b).equals((String) x)));
            return (((String)a+(String)b).equals((String) x));
        }
        else{
            throw new notvalidinput("The input provided did not match the type");
        }

    }
}
