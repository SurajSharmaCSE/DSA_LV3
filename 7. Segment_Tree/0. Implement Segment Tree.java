public static class segment_Tree
   /*
    We have to Write 3 function 
    1 - Build()
    2 - Query()
    3 - Update()
    */
    {
        int tree[];
        int arr[];
        segment_Tree(int a[])
        {
            arr = a;
            tree = new int[4*arr.length];
            build(1,0,arr.length);   // paramenters (Index of node, StartIndex, EndIndex) i.e range
        }
        private void build(int node, int start, int end)
        {
            if(start==end)
            {
                tree[node] = arr[start];
            }
            else
            {
                int mid = (start+end)/2;
                int left = node*2;
                int right = node*2+1;

                build(left, start, mid);
                build(right, mid+1, end);

                tree[node] = Math.max( tree[left], tree[right] );
            }
        }

        private int query(int node, int start, int end, int l , int r)
        {
            if(end<l || r<start)   // 1.e this range not lieng in my range
            {
                return Integer.MIN_VALUE;
            }

            if(start==end)  // it our single range element 
            {
               return tree[node];
            }
            else if(l <=start && end <=r)  // it lieng in half ans
            {
                return tree[node]; 
            }
            else
            {
                int mid = (start+end)/2;

                int left = query(node*2, start, mid, l, r);
                int right = query(node*2+1, mid+1, end, l, r);
                
                return max(left,right);

            }
        }

        private void update(int node, int start, int end, int pos, int val)
        {
            if(start==end)
            {
                arr[start] = val;
                tree[node] = val;
            }
            else
            {
                int mid = (start+end)/2;
                if(start <= pos && post<=mid)  // i.e we have to go left side and set value
                {
                   update(node*2, start, mid, pos, val);
                }
                else
                {
                    update(node*2+1, mid+1, end, pos, val);
                }
                                     //  left side      right side
                tree[node] = Math.max( tree[node*2], tree[node*2+1]);
            }
        }
    }