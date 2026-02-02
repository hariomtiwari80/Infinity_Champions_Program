class Solution {
    public int getDecimalValue(ListNode head) {
        String num="";
        while(head!=null){
            num+=head.val;
            head=head.next;
        }
        int ans=0;
        int c=1;
        for(int i=num.length()-1;i>=0;i--){
            if(num.charAt(i)=='1'){
                ans+=c;
            }
            c*=2;
        }
        return ans;
    }
}
