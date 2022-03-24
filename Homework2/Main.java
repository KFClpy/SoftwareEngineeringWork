public class Main{
	public static void main(String[] args) {
		Solution sl=new Solution();
		int []nums=new int []{-2,11,-4,13,-5,-2};
		int result=sl.maxSum(nums);
		System.out.println(result);
	}
}
class Solution{
	public int maxSum(int []nums)
	{
		int p=0;
		int ans=Integer.MIN_VALUE;
		for(int val:nums)
		{
			p=Math.max(val,p+val);
			ans=Math.max(p,ans);
		}
		return ans;
	}
}