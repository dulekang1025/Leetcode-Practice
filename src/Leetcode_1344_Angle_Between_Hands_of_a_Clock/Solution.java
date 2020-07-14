package Leetcode_1344_Angle_Between_Hands_of_a_Clock;

class Solution {
    public double angleClock(int hour, int minutes) {
        double hourAngle = 30.0;
        double minuteAngle = 6.0;
        double m = minutes * minuteAngle;
        double h = (hour % 12 + minutes / 60.0) * hourAngle;
        double diff = Math.abs(m - h);
        return Math.min(diff, 360.0 - diff);
    }
}
