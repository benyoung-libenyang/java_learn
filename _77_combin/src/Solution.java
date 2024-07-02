import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {

    private List<List<Integer>> result =new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtracking(n, k, 1);
        return result;
    }

//    [startIndex...n ]中选取一个数放入path中
    private void backtracking(int n, int k, int startIndex){
        if(path.size() == k){
//            因为java中是关于对象的引用，如果直接add(path),后续改变了path的值会导致result中的引用也发生错误

            result.add(new ArrayList<>(path));
            return ;
        }
        for(int i = startIndex; i <= n; i++){
//            可能会自己调用Integer的构造函数
            path.add(i);
            backtracking(n, k, i+1);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] test = (int[][]) solution.combine(4,2).toArray();
        for(int[] i : test){
            System.out.println(i[0]);
        }
    }
}