class Solution{
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
    static int[] gcd(int a,int b)
    {
        // code here
        pair ans = EEA(a,b);
        int f_ans[] = {ans.x,ans.y,ans.gcd};
        return f_ans;
    }