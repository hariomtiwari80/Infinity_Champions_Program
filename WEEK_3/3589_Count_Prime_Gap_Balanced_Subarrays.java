// BRUTE FORCE
class Solution {
    public int primeSubarray(int[] arr, int k) {
        int ans=0;
        for(int i=0;i<arr.length;i++){
            int c=0,min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
            for(int j=i;j<arr.length;j++){
                if(prime(arr[j])){
                    min=Math.min(min,arr[j]);
                    max=Math.max(max,arr[j]);
                    c++;
                }
                if(c>=2 && max-min<=k){
                    ans++;
                }
            }
        }
        return ans;
    }
    public boolean prime(int n) {
        if(n<=1) return false;
        if(n==2) return true;
        if(n%2==0) return false;
        for(int i=3;i*i<=n;i+=2) {
            if(n%i==0) return false;
        }
        return true;
    }
}

// OPTIMAL APPROACH
