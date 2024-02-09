/*
 Notes in Ipad
 */
class Solution{
    
    static int isPossible(int a,int b, int k)
    {
        // code here
       pair ans = EEA(a,b);
        ans.x*=k;
        ans.y*=k;
        
       if (k % ans.gcd == 0) 
       {
         return 1;
       }
       return 0;
    }
    
    public static class pair
    {
        int x;
        int y;
        int gcd;
        pair(int x, int y, int gcd)
        {
            this.x = x;
            this.y = y;
            this.gcd = gcd;
        }
    }
    public static pair EEA(int a, int b)
    {
        if(b==0)
        {
            return new pair(1,0,a);
        }
        
        pair dash = EEA(b,a%b);
        
        return new pair(dash.y, dash.x-(a/b)*dash.y,dash.gcd);
    }
}