class Solution
{
    public int nCrModM(int n, int r, int m)
    {
        long ncr[][] = ncrFind(n, r, m);
        
        return (int)ncr[n][r];
    }
    
    public long[][] ncrFind(int n, int r, int mod)
    {
        long ncr[][] = new long[n+1][r+1];
        
        // fill 1st column as 1 apart of ncr[0][0]
        for(int i=0;i<=n;i++)
        {
            ncr[i][0] = 1;
        }
        
        // fill remaining box value of ncr[][] array
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=r && j<=i;j++)
            {
                if(i==j)
                {
                    ncr[i][j] = 1;
                }
                else
                {
                    ncr[i][j] = ( ncr[i-1][j] + ncr[i-1][j-1] )%mod;
                }
            }
        }
        
       return ncr;
    }
}