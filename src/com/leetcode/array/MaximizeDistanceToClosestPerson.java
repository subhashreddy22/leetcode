package com.leetcode.array;

// https://leetcode.com/problems/maximize-distance-to-closest-person/
public class MaximizeDistanceToClosestPerson {

    public static void main(String[] args) {
        System.out.println(maxDistToClosest(new int[]{1, 0, 0, 0, 1, 0, 1}));
    }

    static int maxDistToClosest(int[] seats) {

        int maxDistance = 0;

        for (int i = 0; i < seats.length; i++) {

            if (seats[i] == 0) {

                int leftMax = 1;
                int rightMax = 1;

                boolean leftMaxExists = false;
                boolean rightMaxExists = false;

                for (int j = i - 1; j >= 0; j--) {
                    if (seats[j] == 0) {
                        leftMax++;
                    } else {
                        leftMaxExists = true;
                        break;
                    }
                }

                for (int j = i + 1; j < seats.length; j++) {
                    if (seats[j] == 0) {
                        rightMax++;
                    } else {
                        rightMaxExists = true;
                        break;
                    }
                }

                int distance = 0;

                if (leftMaxExists && rightMaxExists) {
                    distance = Math.min(leftMax, rightMax);
                } else if (leftMaxExists) {
                    distance = leftMax;
                } else {
                    distance = rightMax;
                }

                maxDistance = Math.max(maxDistance, distance);
            }
        }

        return maxDistance;
    }
}
