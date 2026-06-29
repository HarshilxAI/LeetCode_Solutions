class Solution {

public int[] searchRange(int[] nums, int target) {
    int ans[] = {-1,-1};
      ans[0] = first(nums,target);
    ans[1] = last(nums,target);
    return ans;
}
int first(int nums[], int target)
{
    int low=0;
      int high=nums.length-1;
    int res = -1;
    while(low<=high)
    {
int mid = low + (high-low)/2;
if(nums[mid]==target)
        {
            res = mid;
            high = mid-1;
        }else if(nums[mid] < target)
        {
            low = mid+1;
        }

        else {
            high = mid-1;
        }}

 return res;

}

int last(int nums[], int target)
{
 int low=0;
    int high=nums.length-1;
      int res = -1;
    while(low<=high)
    {
 int mid = low + (high-low)/2;
 if(nums[mid]==target)
     {
       res = mid;
  low = mid+1;
        }else if(nums[mid] < target)
        {
            low = mid+1;
        } else
        {
            high = mid-1;
        }
    }
      return res;

}}