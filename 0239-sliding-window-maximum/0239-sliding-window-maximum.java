// class Solution {
//     public int[] maxSlidingWindow(int[] nums, int k) {
//         int n = nums.length;
//         int[] ans =new int[n-k+1];
//         for(int i=0; i<=n-k; i++){
//             int max = nums[i];
//             for(int j=i; j<i+k; j++){
//                 max = Math.max(max,nums[j]);
//             }
//             ans[i] = max;
//         }
//         return ans;
//     }
// }
import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        int[] ans = new int[n - k + 1];

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            // 1. Window ke bahar wale index ko remove karo
            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // 2. Chhoti values ko remove karo
            while (!deque.isEmpty() &&
                   nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }

            // 3. Current index add karo
            deque.offerLast(i);

            // 4. Window complete hone ke baad maximum store karo
            if (i >= k - 1) {
                ans[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return ans;
    }
}