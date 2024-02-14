class Solution {
    static int[] arr;

    // Call this method before using findPrimeFactors
    static void sieve() 
    {
        arr = new int[200001];
        sieve1();
    }

    static List<Integer> findPrimeFactors(int N) 
    {
        List<Integer> ans = new ArrayList<>();
        while (N > 1) 
        {
            ans.add(arr[N]);
            N /= arr[N];
        }
        return ans;
    }

    public static void sieve1() 
    {
        for(int i=1;i<arr.length;i++)
        {
            arr[i] = i;
        }
        
        for (int i = 2; i*i < arr.length; i++) 
        {
            if (arr[i] == i) 
            { // This indicates that i is a prime number
                for (int j = i*i; j < arr.length; j += i) 
                {
                    if (arr[j] == j) 
                    {
                        arr[j] = i;
                    }
                }
            }
        }
    }
}