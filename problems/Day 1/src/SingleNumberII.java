//137. Single Number II
import java.util.Hashtable;

public class SingleNumberII {
	
    public int singleNumber(int[] nums) {
        Hashtable<Integer, Integer> solution = new Hashtable<>();
        int answer = 0;
        for(int i = 0; i < nums.length; i++) {
        	if(!solution.containsKey(nums[i])) {
        		solution.put(nums[i], 1);
        	}
        	else {
        		int a = solution.get(nums[i]) + 1;
        		solution.put(nums[i], a);
        	}
        }
        for(int k : solution.keySet()) {
        	if(solution.get(k) == 1) {
        		answer = k;
        	}
        }
        return answer;
    }

}
