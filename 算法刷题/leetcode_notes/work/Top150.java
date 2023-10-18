package leetcode_notes.work;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author: Hodor_Zhu
 * @description
 * @date: 2023/6/26 22:10
 */
public class Top150 {
    /**
     * @author hodor_zhu
     * @description https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/
     * @date 2023/6/26 22:11
     */
    public int removeDuplicates(int[] nums) {
        int last = 2, suffix = 2;
        for (;suffix < nums.length; suffix++) {
            if(nums[suffix] != nums[last-2])
                nums[last++] = nums[suffix];
        }
        return last;
    }

/**
 * @author hodor_zhu
 * @description https://leetcode.cn/problems/majority-element/?envType=study-plan-v2&envId=top-interview-150
 * @date 2023/7/1 15:01
 */
    public int majorityElement(int[] nums) {
        int n = nums[0], c = 1;
        for (int i = 1; i < nums.length; i++) {
            if (n != nums[i]) c--; else c++;
            //i此时不可能 >= nums.length
            if (c == 0) n = nums[i+1];
        }
        return n;
    }

    /**
     * https://leetcode.cn/problems/rotate-array/comments/
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        rotate(nums, 0, nums.length - 1);
        rotate(nums, 0, k-1);
        rotate(nums, k, nums.length - 1);
    }
    public void rotate(int[] nums, int a, int b) {
        while (a < b){
            int t = nums[a];
            nums[a++] = nums[b];
            nums[b--] = t;
        }
    }

    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] arr = new int[len];
        Arrays.fill(arr, 1);
        int left = 1, right = 1;//保留arr[i]左右的乘积
        for (int i = 0; i < len; i++){
            //双指针i和len-i-1终会相遇，这里arr[i] = arr[i] * left右侧的arr[i]已经包含了右乘积
            arr[i] *= left;
            left *= nums[i];//更新左乘积
            //下面同理
            arr[len-i-1] *= right;
            right *= nums[len-i-1];
        }
        return arr;
    }

    /**
     * @author hodor_zhu
     * @description https://leetcode.cn/problems/gas-station/submissions/?envType=study-plan-v2&envId=top-interview-150
     * @date 2023/7/30 17:21
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int start = 0;
        while (start < len){//遍历每个起点
            int i = 0, tank = 0;
            while (i < len){
                int t = (start+i) % len;
                tank += gas[t] - cost[t];
                if (tank < 0){
                    break;
                }
                i++;
            }
            if (i == len) return start;//走了len的路程说明circle了
            else start = start + i + 1;//否则继续从 t+1 start
        }
        return -1;
    }


    /**
     * @author hodor_zhu
     * @description https://leetcode.cn/problems/text-justification/description/?envType=study-plan-v2&envId=top-interview-150
     * @date 2023/9/13 21:08
     */
    public List<String> fullJustify(String[] words, int maxWidth) {
        ArrayList<String> res = new ArrayList<>();
        int left = 0, right = 0;
        int length = words.length;
        while (true){
            int len = 0;
            //right-left表示space，动态计算，right循环后指向超出的那个单词
            while (len + words[right].length() + right-left <= maxWidth && right < length){
                len += words[right++].length();
            }
            StringBuilder s = new StringBuilder();
            //最后一行
            if (length == right){
                //TODO [left, right)的单词拼接进s，空格连接,后面补齐空格
                res.add(s.toString());
                return res;
            }
            //上次拼接完后left = right
            int num = right - left;
            int space = maxWidth - len;
            //不是最后一行但是只有1个word
            if (num == 1){
                s.append(words[left++]);
                //TODO 补齐空格
                res.add(s.toString());
                continue;
            }
            //不是最后一行且不止1个单词
            int gap = num - 1;
            int avg = space / gap;
            int extra = space % gap;
            //TODO 前extra个单词跟avg+1个space。其他的跟avg个
            res.add(s.toString());
        }
    }


    /**
     * @author hodor_zhu
     * https://leetcode.cn/problems/longest-substring-without-repeating-characters/discussion/?envType=study-plan-v2&envId=top-interview-150
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
     */
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int l = 0, r = 0;//左右边界
        int res = 0;
        while (r < s.length()){
            if (map.containsKey(s.charAt(r)))
                /** 为什么l要取max？？
                 * ele  .a..2..1.....2.a...
                 * idx   z  x  l    yr
                 *  遇到重复的2时此时l不动,map更新下标为第二个2的下标，res更新(l~r)的长度
                 *  (...~y)先前已经被计算过存进res了,不用担心(x~y)的长度被覆盖
                 *  l指向1开始算作字串起始时，map里应该只存l~r的下标，但此时map里其实还残留了l之前的下标:如z,
                 *  但r移到字符a时l并不影响(l~r)串的判断，因为l不会左移
                 **/
                l = Math.max(l, map.get(s.charAt(r)) + 1);
            map.put(s.charAt(r), r++);
            res = Math.max(res, r - l);
        }
        return res;
    }

    /**
     * @author hodor_zhu
     * @description 先删去前 i（i=0∼n−1）个字母后，将剩下的字母进行划分，如果末尾有不到 n 个字母也删去
     * @date 2023/10/16 20:58
     */
    public static List<Integer> findSubstring(String s, String[] words) {
        //统计words词频
        Map<String, Long> wordsMap = Arrays.stream(words)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        ArrayList<Integer> res = new ArrayList<>();
        //每个单词长度
        int wordLen = words[0].length();
        //words所有单词组合拼接长度
        int wordsLen = words.length * wordLen;
        //前l个字母不要
        int l = wordLen - 1;

        while (l >= 0) {
            //末尾有不到 n 个字母也删去
            int mod = (s.length() - l) % wordLen;
            String sub = mod == 0? s.substring(l, s.length()) : s.substring(l, s.length() - mod + 1);
            int left = 0, right = 0;
            HashMap<String, Long> diffMap = new HashMap<>(wordsMap);

            while (left <= sub.length() - wordLen && right <= sub.length() - wordLen){
                String in = sub.substring(left, left+wordLen);
                if (right >= wordsLen){//开始滑动
                    diffMap.put(in, diffMap.getOrDefault(in,0L) + 1);
                    String out = sub.substring(right, right+wordLen);
                    diffMap.put(out, diffMap.getOrDefault(out,0L) - 1);
                    right += wordLen;
                }else {//统计初始词频
                    diffMap.put(in, diffMap.getOrDefault(in,0L) - 1);
                }
                left += wordLen;
                if (left == wordsLen && right == 0){
                    left = 0;
                    right = wordsLen;
                }
                if (diffMap.values().stream().allMatch(p -> p == 0)){
                    res.add(l + left);
                }
            }
            l--;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(findSubstring("lingmindraboofooowingdingbarrwingmonkeypoundcake",
                new String[]{"fooo","barr","wing","ding","wing"}));
    }
}
