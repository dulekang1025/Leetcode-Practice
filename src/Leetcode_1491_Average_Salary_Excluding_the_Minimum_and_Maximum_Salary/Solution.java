package Leetcode_1491_Average_Salary_Excluding_the_Minimum_and_Maximum_Salary;

import java.util.Arrays;

class Solution {
    public double average(int[] salary) {
        int sum = 0;
        Arrays.sort(salary);
        for(int i = 1; i < salary.length - 1; i++){
            sum += salary[i];
        }
        return sum / (salary.length - 2 * 1.0);
    }
}
