// BRUTE FORCE
class Solution {
    public int strStr(String s, String p) {
        int n=s.length(),m=p.length();
        if(m>n) return -1;
        for(int i=0;i<n-m+1;i++){
            if(s.charAt(i)==p.charAt(0)){
                int j=i,k=0;
                boolean b=true;
                while(k<p.length()){
                    if(s.charAt(j)!=p.charAt(k)){
                        b=false;
                        break;
                    }
                    else{
                        j++;
                        k++;
                    }
                }
                if(b) return i;
            }
        }
        return -1;
    }
}

// OPTIMAL APPROACH
class Solution {
    public int strStr(String s, String p) {
        int n=s.length(),m=p.length();
        if(m>n) return -1;
        for(int i=0;i<n-m+1;i++){
            if(s.charAt(i)==p.charAt(0) && s.substring(i,i+m).equals(p)) return i;
        }
        return -1;
    }
}
