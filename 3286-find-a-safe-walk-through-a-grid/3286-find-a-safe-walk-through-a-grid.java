class Solution {

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {

           int m=grid.size();
          int n=grid.get(0).size();

        int vis[][]=new int[m][n];
  
          for(int i=0;i<m;i++)
                  Arrays.fill(vis[i],-1);

          Queue<int[]> q=new LinkedList<>();

           int start=health-grid.get(0).get(0);
         if(start<=0)
            return false;
        q.offer(new int[]{0,0,start});
        vis[0][0]=start;

        int dir[][]={{-1,0},{1,0},{0,-1},{0,1}};

 while(!q.isEmpty()){

            int cur[]=q.poll();

              int r=cur[0];
               int c=cur[1];
              int h=cur[2];
   
            if(r==m-1 && c==n-1)
                return true;
   
            for(int i=0;i<4;i++){
                 int nr=r+dir[i][0];
       int nc=c+dir[i][1];

     if(nr>=0 && nr<m && nc>=0 && nc<n){

                         int nh=h-grid.get(nr).get(nc);

       if(nh>0 && nh>vis[nr][nc]){
 
                        vis[nr][nc]=nh;
            q.offer(new int[]{nr,nc,nh});

  }

                }    }}

        return false;

    }}