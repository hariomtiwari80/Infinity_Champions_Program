class Solution {
    public int totalStrength(int[] arr){
    int res=0,ac=0,mod=(int)1e9+7,n=arr.length;
    Stack<Integer> stack=new Stack<>();
    int[] acc=new int[n+2];
    for(int r=0;r<=n;++r){
        int a=r<n?arr[r]:0;
        ac=(ac+a)%mod;
        acc[r+1]=(ac+acc[r])%mod;
        while(!stack.isEmpty() && arr[stack.peek()]>a){
            int i=stack.pop();
            int l=stack.isEmpty()?-1:stack.peek();
            long lacc=l<0?acc[i]:acc[i]-acc[l];
            long racc=acc[r]-acc[i];
            int ln=i-l,rn=r-i;
            res=(int)(res+(racc*ln-lacc*rn)%mod*arr[i]%mod) %mod;
        }
            stack.push(r);
    }
        return (res+mod)%mod;
    }

}
