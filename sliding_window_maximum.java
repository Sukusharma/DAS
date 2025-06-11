// Sliding Window Maximum 
//Find the maximum in every window of size k in the array nums[].
// Given an array nums[] and a window size k,
// this function returns an array of the maximums from each sliding window. Using Deque

public class SlidingWindowMaximum {

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] ans = maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {

//FORGOT TO ADD EDGE CASE 

      if(nums == 0 || k<=0){
return new int[0]  // it has to return an array, even if it's empty.so i return an empty zero integer array
}

int n = nums.length;
        int[] result = new int[n-k+1];
        Deque<Integer> deque = new ArrayDeque<>();

        for(int i =0;i < n; i++){
             // Remove from front if index is out of window range k
            if(!deque.isEmpty() && nums[deque.peek()] < i - k + 1){ 

//CANT COMPARE ONLY DEQUE.PEEK CAUSE IT STORE ONLY INDEX SO NUMS[DEQUE.PEEK()] USED

                deque.poll();
            }

            // remove smaller numbers in  range k as they are useless

            while(!deque.isEmpty() && deque.peekLast()< nums[i] ){
                deque.pollLast();
            }
            deque.offer(i);
//jese hi 3 range ka ek max niklta he add in result array here i->3=k-1-->3-1=2
            if(i>=k-1){
                //deque.peek() gives index of max nums[deque.peek()] gives value of max
                result[i-k+1] = nums[deque.peek()];
            }

        }
        return result;
    }

}//corrected
