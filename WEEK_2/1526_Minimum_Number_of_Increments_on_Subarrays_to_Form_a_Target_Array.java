// APPROACH-1
class Solution {
    public int minNumberOperations(int[] arr) {
        int n=arr.length;
        int ans=arr[0];
        for(int i=1;i<n;i++){
            if(arr[i]-arr[i-1]>0){
                ans+=arr[i]-arr[i-1];
            }
        }
        return ans;
    }
}

// APPROACH-2
class Solution {
    public int minNumberOperations(int[] arr) {
        int n=arr.length;
        Stack<Integer> st=new Stack<>();
        st.push(arr[0]);
        int ans=arr[0];
        for(int i=1;i<n;i++){
            if(arr[i]-st.peek()>0){
                ans+=arr[i]-st.peek();
            }
            st.push(arr[i]);
        }
        return ans;
    }
}
