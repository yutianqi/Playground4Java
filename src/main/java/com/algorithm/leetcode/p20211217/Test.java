/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2022-2022. All rights reserved.
 */

package main.java.com.algorithm.leetcode.p20211217;

import java.util.Arrays;

/**
 * xxx
 *
 * @author y00290641
 * @since 2021/12/9
 */
public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] tmp1 = {0,2};
        int[] tmp2 = {0,1};
        int[] tmp3 = {1,2};
        int[] tmp4 = {0,2};
        int[] tmp5 = {0,1};
        int[][] ret = new int[5][];
        ret[0] = tmp1;
        ret[1] = tmp2;
        ret[2] = tmp3;
        ret[3] = tmp4;
        ret[4] = tmp5;
        System.out.println(Arrays.toString(solution.checkConnectivity(5, ret)));

        // int[] tmp1 = {1, 1};
        // int[] tmp2 = {0, 4};
        // int[] tmp3 = {0, 1};
        // int[] tmp4 = {1, 4};
        // int[] tmp5 = {1, 1};
        // int[] tmp6 = {0, 4};
        // int[][] ret = new int[6][];
        // ret[0] = tmp1;
        // ret[1] = tmp2;
        // ret[2] = tmp3;
        // ret[3] = tmp4;
        // ret[4] = tmp5;
        // ret[5] = tmp6;
        // System.out.println(Arrays.toString(solution.checkConnectivity(6, ret)));

        // int[] tmp1 = {0,5};
        // int[][] ret = new int[1][];
        // ret[0] = tmp1;
        // System.out.println(Arrays.toString(solution.checkConnectivity(6, ret)));


        // int[][] tmp = {{0, 0}, {0, 1}, {0, 2}, {0, 3}, {0, 4}, {0, 5}, {0, 6}, {1, 3}};
        // System.out.println(Arrays.toString(tmp[0]));
        // System.out.println(Arrays.toString(solution.checkConnectivity(7, tmp)));

        // System.out.println(newSolution.check(Arrays.asList(true, true, true)));
        // System.out.println(newSolution.check(Arrays.asList(false, false, false)));
        // System.out.println(newSolution.check(Arrays.asList(true, true, false)));

        // int[][] ret = new int[2][3];
        // ret[1][2] = 5;
        // System.out.println(Arrays.toString(ret[1]));

    }
}


