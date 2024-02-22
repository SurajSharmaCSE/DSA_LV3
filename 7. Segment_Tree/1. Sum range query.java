import javax.swing.text.Segment;

class SumRangeQuery {
    int tree[];
    int arr[];

    public SegmentTree(int[] nums) 
    {
        arr = nums;
        tree = new int[4*nums.length];
        build(1,0,arr.length-1);
    }
    
    public void build(int node, int start, int end)
    {
        if(start==end)
        {
            tree[node] = arr[start];
        }
        else
        {
            int leftNode = node*2;
            int rightNode = node*2+1;
            int mid = (start+end)/2;

            build(leftNode,start,mid);
            build(rightNode,mid+1,end);

            tree[node] = tree[leftNode]+tree[rightNode];
        }
    }

    public void update(int node, int start, int end, int pos, int val)
    {
        if(start==end)
        {
            arr[start] = val;
            tree[node] = val;
        }
        else
        {
            int mid = (start+end)/2;
            if(start<=pos && pos<=mid)  // faith of -> left side call and update 
            {
               updateQuery(node*2,start,mid,pos,val);
            }
            else   // faith of -> right side call and update 
            {
               updateQuery(node*2+1,mid+1,end,pos,val);
            }
            //update the value after changing 
            tree[node] = tree[node*2]+tree[node*2+1];
        }
    }

    public int  query(int node, int start, int end, int l, int r)
    {
        if(end<l || r<start){return 0;}

        if(start==end)
        {
           return tree[node];
        }
        else if(l<=start && end<=r)
        {
          return tree[node];
        }
        else
        {
            int mid = (start+end)/2;

            int left = query(node*2,start,mid,l,r); // left side
            int right = query(node*2+1,mid+1,end,l,r); // righr side 

            return left+right;
        }
    }
}