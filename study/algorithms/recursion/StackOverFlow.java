package recursion;

public class StackOverFlow {
    int counter = 0;
    public String inception(){
        System.out.println(counter);
        if (counter > 3) {
           return "done!";
        }
        counter ++;
        return inception();
    }

    public static void main(String[] args) {
        StackOverFlow stackoverflow = new StackOverFlow();
        stackoverflow.inception();
    }
}
