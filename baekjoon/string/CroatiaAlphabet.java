import java.util.Scanner;

public class CroatiaAlphabet {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String words = sc.nextLine();
        // if문으로 contain하고 있으면 repalce로 변경해주기 (특정 다른 문자로)

        if (words.contains("dz=")){
            words = words.replace("dz=","a");
        }else if(words.contains("z=")){
            words = words.replace("z=","a");
        }
        if (words.contains("c="))  words = words.replace("c=","a");
        if (words.contains("c-"))  words = words.replace("c-","a");
        if (words.contains("d-"))  words = words.replace("d-","a");
        if (words.contains("lj"))  words = words.replace("lj","a");
        if (words.contains("nj"))  words = words.replace("nj","a");
        if (words.contains("s="))  words = words.replace("s=","a");
        if (words.contains("z="))  words = words.replace("z=","a");

        System.out.println(words.length());
    }
}
