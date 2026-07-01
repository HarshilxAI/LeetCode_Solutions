class Solution {

    public int maximumSafenessFactor(List<List<Integer>> grid) {

        int n = grid.size();

        int d[][] = new int[n][n];

        for(int i=0;i<n;i++){
            Arrays.fill(d[i],-1);
        }

        Queue<int[]> q = new LinkedList<>();

             for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
   
                 if(grid.get(i).get(j)==1){
                      d[i][j]=0;
                      q.offer(new int[]{i,j});
                }
    
            }
          }

            int dir[][]={{-1,0},{1,0},{0,-1},{0,1}};

           while(!q.isEmpty()){

            int cur[]=q.poll();

              int r=cur[0];
            int c=cur[1];
  
              for(int k=0;k<4;k++){
  
                 int nr=r+dir[k][0];
                  int nc=c+dir[k][1];
 
                   if(nr>=0 && nr<n && nc>=0 && nc<n && d[nr][nc]==-1){

                      d[nr][nc]=d[r][c]+1;
                    q.offer(new int[]{nr,nc});
  
                }   

            }

        }

        int low=0  ;
           int high=2*n;
  while(low<=high){
 
            int mid=(low+high)/2;
     
            if(check(d,mid)) low=mid+1;
              else high=mid-1;
    
          }
 
          return high;

    }


      boolean check(int d[][],int safe){

           int n=d.length;
 
        if(d[0][0]<safe)
            return false;
  
        boolean vis[][]=new boolean[n][n];
  
          Queue<int[]> q=new LinkedList<>();
 
        q.offer(new int[]{0,0});
            vis[0][0]=true;

         int dir[][]={{-1,0},{1,0},{0,-1},{0,1}};

        while(!q.isEmpty()){
  
            int temp[]=q.poll();

            int r=temp[0];
              int c=temp[1];
 
              if(r==n-1 && c==n-1)
                 return true;
 
            for(int i=0;i<4;i++){

                int nr=r+dir[i][0];
                int nc=c+dir[i][1];

                if(nr>=0 && nr<n && nc>=0 && nc<n){

                      if(!vis[nr][nc] && d[nr][nc]>=safe){

                        vis[nr][nc]=true;
                         q.offer(new int[]{nr,nc});

                    }

                }

            }

        }

         return false;

    }

      }