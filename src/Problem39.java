import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem39 {

    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        dfs(candidates, target, list, 0);
        return ans;
    }
    public void dfs(int[] candidates, int target, List<Integer> list, int index){
        if(target < 0){
            return;
        }
        if(target == 0){
            ans.add(new ArrayList<>(list));
        }
        for(int i = index; i < candidates.length; i++){

            list.add(candidates[i]);
            dfs(candidates, target - candidates[i], list, i);
            list.remove(list.size() - 1);
        }
    }
}
