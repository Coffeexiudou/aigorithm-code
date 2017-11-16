/*

Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
*/


class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> result;
        if(nums.size()<=1)return result;
        unordered_map<int,int> hashmap;
        int size = nums.size();
        for(int i =0;i<size;i++){
            hashmap[nums[i]] = i;
        }
        for(int i =0;i<size;i++){
            int temp = target-nums[i];
            if(hashmap.find(temp)!=hashmap.end()&&hashmap[temp]!=i){
                result.push_back(i);
                result.push_back(hashmap[temp]);
                break;
            }
        }
       return result;
        
    }
};


//只需一次循环，map记录target-nums[i]的值
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> result;
        if(nums.size()<=1)return result;
        unordered_map<int,int> hashmap;
        int size = nums.size();
        for(int i =0;i<size;i++){
            int temp = target-nums[i];
            if(hashmap.find(nums[i])!=hashmap.end()){
                result.push_back(hashmap[nums[i]]);
                result.push_back(i);
                break;
            }
            hashmap[temp]=i;
        
        }
       return result;
        
    }
};