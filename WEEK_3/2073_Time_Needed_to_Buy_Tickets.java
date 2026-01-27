// PAIR APPROACH(QUEUE)
class Solution {
    class pair{
        int n,i;
        pair(int n,int i){
            this.n=n;
            this.i=i;
        }
    }
    public int timeRequiredToBuy(int[] arr, int k) {
        int m=arr.length;
        if(m==1) return arr[0];
        Queue<pair> q=new LinkedList<>();
        for(int i=0;i<m;i++){
            q.add(new pair(arr[i],i));
        }
        int ans=0;
        while(!q.isEmpty()){
            pair p=q.poll();
            if(p.i==k){
                if(p.n==1) return ans+1;
                else q.add(new pair(p.n-1,p.i));
            }
            else{
                if(p.n>1){
                    q.add(new pair(p.n-1,p.i));
                }
            }
            ans++;
        }
        return -1;
    }
}
