// BRUTE FORCE
class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
        List<List<Integer>> ans=new ArrayList<>();
        HashSet<List<Integer>> set=new HashSet<>();
        int n=arr.length;
        if(n<3) return ans;
        for(int i=0;i<=n-3;i++){
            for(int j=i+1;j<=n-2;j++){
                for(int k=j+1;k<=n-1;k++){
                    int sum=arr[i]+arr[j]+arr[k];
                    if(sum==0){
                        List<Integer> temp=Arrays.asList(arr[i],arr[j],arr[k]);
                        Collections.sort(temp);
                        if(!set.contains(temp)){
                            ans.add(temp);
                            set.add(temp);
                        } 
                    }
                }
            }
        }
        return ans;
    }
}

// OPTIMAL APPROACH
class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(arr);
        int n=arr.length;
        if(n<3) return ans;
        for(int i=0;i<=n-3;i++){
            if(i>0 && arr[i]==arr[i-1]) continue;
            int j=i+1,k=n-1;
            while(j<k){
                int sum=arr[i]+arr[j]+arr[k];
                if(sum==0){
                    ans.add(Arrays.asList(arr[i],arr[j],arr[k]));
                    k--;
                    j++;
                    while(j<k && arr[j]==arr[j-1]) j++;
                    while(k>j && arr[k]==arr[k+1]) k--;
                }
                else if(sum<0) j++;
                else k--;
            }
            
        }
        return ans;
    }
}
