// BRUTE FORCE
class Solution {
    ArrayList<String> l=new ArrayList<>();
    public String smallestSubsequence(String s, int k, char letter, int r) {
        find(s,0,"",k);
        String ans="";
        for(int i=0;i<l.size();i++){
            if(l.get(i).length()==k){
                if(valid(l.get(i),letter,r)){
                    if(ans.equals("")) ans=l.get(i);
                    else{
                        if(ans.length()>l.get(i).length()){
                            ans=l.get(i);
                        }
                        else if(ans.length()==l.get(i).length()){
                            ans=check(ans,l.get(i));
                        }
                    }
                }
            }
        }
        return ans;
    }
    public void find(String s,int i,String temp,int k){
        if(i==s.length()){
            if(temp.length()==k) l.add(temp);
            return;
        }
        find(s,i+1,temp,k);
        temp+=s.charAt(i);
        find(s,i+1,temp,k);
    }
    public boolean valid(String s,char c,int r){
        int cnt=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==c){
                cnt++;
            }
        }
        return cnt>=r;
    }
    public String check(String s,String p){
        int i=0;
        while(i<s.length()){
            if(s.charAt(i)<p.charAt(i)) return s;
            else if(s.charAt(i)>p.charAt(i)) return p;
            i++;
        }
        return s;
    }
}


// OPTIMAL APPROACH
class Solution {
    public String smallestSubsequence(String s, int k, char letter, int r) {
        int n_letters=0;
        for (int i=0;i<s.length();i++)
            if (s.charAt(i)==letter)
                n_letters++;

        Stack<Character> stack=new Stack<>();
        for (int i=0;i<s.length();i++) {
            char c=s.charAt(i);
            while(!stack.isEmpty() && stack.peek()>c && (s.length()-i+stack.size()>k) && (stack.peek()!=letter || n_letters>r)){
                if (stack.pop() == letter) r ++;
            }
            if(stack.size()<k) {
                if (c==letter) {
                    stack.push(c);
                    r--;
                } else if(k - stack.size() > r) {
                    stack.push(c);
                }
            }
            
            if (c==letter) n_letters --;
        }
        StringBuilder sb=new StringBuilder(stack.size());
        for(Character c:stack) sb.append(c);
        return sb.toString();
    }
}
