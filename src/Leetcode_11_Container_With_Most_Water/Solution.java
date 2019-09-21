package Leetcode_11_Container_With_Most_Water;

class Solution {
    public int maxArea(int[] height) {
        //variables pointing to left and right walls
        int left = 0;
        int right = height.length-1;
        int maxArea = 0;

        while (left != right ){
            //terminates when left and right are the same
            //the lenght of the area must always be the min of
            //the two walls
            int length = Math.min(height[left], height[right]);
            int area = length * (right -left);
            //update maxArea
            maxArea = Math.max(maxArea, area);
            //only update or move left and right closer to each
            //other if they are the smaller one.
            //this is because you want to maintain the larger
            //length to achieve max area
            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxArea;
    }
}
