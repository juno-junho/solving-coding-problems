public class PerfectReversibleString {
    // This function basically
// checks if string is
// palindrome or not
    static boolean isReversible(String str)
    {
        int i = 0, j = str.length() - 1;

        // iterate from
        // left and right
        while (i < j)
        {
            if (str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    // Driver Code
    public static void main (String[] args){
        String str = "aba";
        if (isReversible(str))
            System.out.print("YES");
        else
            System.out.print( "NO");
    }
}
