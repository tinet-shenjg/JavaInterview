# 两数之和   

给定一个整数数组nums 和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，
并返回他们的数组下标。
你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

示例:
```
给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]
```

## 解法一：
双重for循环暴力破解
```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] == target - nums[i]) {
                return new int[] { i, j };
            }
        }
    }
    return null;
}
}
```
复杂度分析：   
时间复杂度：O(n^2)   
空间复杂度：O(1)。  

---
## 解法二：    
使用map缓存一次循环
```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // 构建map存储数组数据和索引位置 k:数据 v:索引位置
        Map<Integer, Integer> map = new HashMap(nums.length);
        
        int num = 0;
       // 遍历数组，寻找符合的数据
        for(int i = 0 ; i < nums.length; i++){
            num = nums[i];
            // map中存在数据返回索引
            if(map.containsKey(target - num)){
                return new int[]{i , map.get(target - num)};
            }
            // 不存在，存储当前数据和索引，以备后续使用
            map.put(num, i);
        }
        return null;
        
    }
}
```   

复杂度分析：   
数据遍历：时间复杂度O(n)   
map缓存：空间复杂度O(n)
