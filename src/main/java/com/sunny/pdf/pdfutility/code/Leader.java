package com.sunny.pdf.pdfutility.code;

public class Leader {

        public int findMajorityIndex(int[] nums) {
            int candidate = -1;
            int count = 0;

            // Find potential majority candidate
            for (int num : nums) {
                if (count == 0) {
                    candidate = num;
                    count = 1;
                } else if (num == candidate) {
                    count++;
                } else {
                    count--;
                }
            }

            // Verify if the candidate is the majority element
            count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == candidate) {
                    count++;
                    if (count > nums.length / 2) {
                        return i;
                    }
                }
            }

            return -1; // No majority element found
        }
        public int equiLeader(int[] A) {
            int leader = findLeader(A);
            if (leader == -1)
                return 0; // No leader found, so no equi leaders

            int countLeader = 0;
            for (int num : A) {
                if (num == leader)
                    countLeader++;
            }

            int equiLeaders = 0;
            int leadersInPrefix = 0;
            int totalLeaders = countLeader;

            for (int i = 0; i < A.length - 1; i++) {
                if (A[i] == leader)
                    leadersInPrefix++;

                if (leadersInPrefix > (i + 1) / 2 && (totalLeaders - leadersInPrefix) > (A.length - i - 1) / 2)
                    equiLeaders++;
            }

            return equiLeaders;
        }

        private int findLeader(int[] A) {
            int size = 0;
            int value = 0;

            for (int num : A) {
                if (size == 0) {
                    size++;
                    value = num;
                } else {
                    if (value == num)
                        size++;
                    else
                        size--;
                }
            }

            if (size <= 0)
                return -1;

            int count = 0;
            for (int num : A) {
                if (num == value)
                    count++;
            }

            return count > A.length / 2 ? value : -1;
        }

}
