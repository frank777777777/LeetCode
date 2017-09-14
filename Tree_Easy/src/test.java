import javax.swing.plaf.synth.SynthTextAreaUI;

/**
 * Created by Frank on 7/31/2017.
 */
public class test {
    public void foo(dog d){
        d.name="new changed";
    }

    public static void main(String[] args){
        dog tom = new dog("tom");
        new test().foo(tom);
        System.out.print(tom.name);
    }





}

class dog{
    String name;
    public dog(String name){
        this.name=name;
    }
}



