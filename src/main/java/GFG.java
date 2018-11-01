public class GFG 
{
    static int count_palindromes(String s)
    {
    	int n = s.length();
        int dp_cache[][] = new int[n][n];
      
        boolean palindromes[][] = new boolean[n][n];
      
        for (int i= 0; i< n; i++)
            palindromes[i][i] = true;
      
        for (int i=0; i<n-1; i++)
        {
            if (s.charAt(i) == s.charAt(i+1))
            {
                palindromes[i][i+1] = true;
                dp_cache[i][i+1] = 1 ;
            }
        }
      
        for (int gap=2 ; gap<n; gap++)
        {
            for (int i=0; i<n-gap; i++)
            {
                int j = gap + i;
                if (s.charAt(i) == s.charAt(j) && palindromes[i+1][j-1] )
                    palindromes[i][j] = true;
      
                if (palindromes[i][j] == true)
                    dp_cache[i][j] = dp_cache[i][j-1] + dp_cache[i+1][j] + 1 - dp_cache[i+1][j-1];
                else
                    dp_cache[i][j] = dp_cache[i][j-1] + dp_cache[i+1][j] - dp_cache[i+1][j-1];
            }
        }
      
        return dp_cache[0][n-1];
    }
    
    public static void main(String[] args)
    {
        String str = "hellollo";
        System.out.println(count_palindromes(str));
    }
    
}