package Leetcode_1603_Design_Parking_System;

class ParkingSystem {

    int b;
    int m;
    int s;

    public ParkingSystem(int big, int medium, int small) {
        this.b = big;
        this.m = medium;
        this.s = small;
    }

    public boolean addCar(int carType) {
        // big, medium, or small, which are represented by 1, 2, and 3
        if(carType == 1){
            if(b == 0) return false;
            else{
                b--;
                return true;
            }
        }else if(carType == 2){
            if(m == 0) return false;
            else{
                m--;
                return true;
            }
        }else{
            if(s == 0) return false;
            else{
                s--;
                return true;
            }
        }
    }
}

