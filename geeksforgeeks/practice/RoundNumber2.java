public class RoundNumber2 {
    // Program to round the number to the
    // nearest number having one's digit 0
    public static String round(String s, int n)
    {
        char[] c=s.toCharArray();

        // last character is 0 then return the
        // original string
        if(c[n-1]=='0')
            return s;

            // if last character is
            // 1 or 2 or 3 or 4 or 5 make it 0
        else if(c[n-1] == '1' || c[n-1] == '2' ||
                c[n-1] == '3' || c[n-1] == '4')
        {
            c[n-1]='0';
            return new String(c);
        }
        else
        {
            c[n-1]='0';

            // process carry
            for(int i = n - 2 ; i >= 0 ; i--)
            {
                if(c[i] == '9')
                    c[i]='0';
                else
                {
                    int t= c[i] - '0' + 1;
                    c[i]=(char)(48+t);
                    break;
                }
            }
        }

        String s1=new String(c);

        if(s1.charAt(0) == '0')
            s1="1"+s1;

        // return final string
        return s1;
    }

    // Driver Code
    public static void main (String[] args)
    {

        String s="999";
        int n=s.length();

        // Function Call
        System.out.println(round(s,n));

    }
}
