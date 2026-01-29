class Solution{
    public long calculateScore(String s){
        int n=s.length();
        long score=0;

        int[] mirror=new int[26];
        for(int i=0;i<26;i++){
            mirror[i]=25-i;
        }

        Map<Integer,Stack<Integer>> map=new HashMap<>();
        for(int i=0;i<26;i++){
            map.put(i,new Stack<>());
        }

        for(int i=0;i<n;i++){
            int chIdx=s.charAt(i)-'a';
            if(!map.get(mirror[chIdx]).isEmpty()){
                int j=map.get(mirror[chIdx]).pop();
                score+=i-j;
            }else{
                Stack<Integer> stk=map.get(chIdx);
                stk.push(i);
                map.put(chIdx,stk);
            }
        }
        return score;
    }
}
