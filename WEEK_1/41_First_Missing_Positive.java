// APPROACH-1
class Solution {
    public int firstMissingPositive(int[] arr) {
        HashSet<Integer> set=new HashSet<>();
        int max=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>0) set.add(arr[i]);
            max=Math.max(max,arr[i]);
        }
        if(max==0) return 1;
        for(int i=1;i<=max;i++){
            if(!set.contains(i)){
                return i;
            }
        }
        return max+1;
    }
}

// APPROACH-2
import java.util.Arrays;
class Solution {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int n=1;
        for(int x:nums){
            if (x==n){
                n++;
            }
        }
        return n;
    }
}
