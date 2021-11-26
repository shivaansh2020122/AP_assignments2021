public class genericCalc<T>{
    private final T a;
    private final T b;
    genericCalc(T x,T y){
        if((x instanceof String||x instanceof Integer)&&((y instanceof Integer)||(y instanceof String))) {
            this.a = x;
            this.b = y;
        }
    else{
        throw new notvalidinput("Some input passed to ");
        }
    }
    public boolean calc(T x) throws Numberdivzero{
        if(x instanceof Integer) {
            return (((Integer)a/(Integer)b)==(Integer)x);
        }

        else if(x instanceof String){
            return (((String)a+(String)b)==(String) x);
        }
        else{
            throw new notvalidinput("The input provided did not match the type");
        }

    }
}
