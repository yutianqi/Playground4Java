/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2022-2022. All rights reserved.
 */

package main.java.com.algorithm.leetcode.p20211217;

/**
 * Solution
 *
 * @author y00290641
 * @since 2021/12/17
 */
public class Solution {

    private boolean[][] statusArray = null;

    private boolean[] connectivityArray = null;

    private int maxLevel = 0;

    /**
     * 连通性检测
     *
     * @param num 节点数
     * @param operations 操作数组
     * @return 操作结果数组
     */
    public int[] checkConnectivity(int num, int[][] operations) {
        this.maxLevel = num;
        init(num);

        int[] ret = new int[operations.length];
        for (int i = 0; i < operations.length; i++) {
            int[] operation = operations[i];
            int serverIndex = operation[0];
            int nodeIndex = operation[1];
            updateStatus(serverIndex, nodeIndex);
            // System.out.println(this.STATUS_LIST);
            updateConnectivity(nodeIndex);
            updateConnectivity(nodeIndex + 1);
            // System.out.println(this.CONNECTIVITY_LIST);
            ret[i] = check(this.connectivityArray);
        }
        return ret;
    }

    private void init(int num) {
        this.statusArray = new boolean[num][2];
        this.connectivityArray = new boolean[num];
        for (int i = 0; i < num; i++) {
            boolean[] initValue = {true, true};
            this.statusArray[i] = initValue;
            connectivityArray[i] = true;
        }
    }

    private void updateStatus(int serverIndex, int nodeIndex) {
        boolean[] site = this.statusArray[nodeIndex];
        site[serverIndex] = !site[serverIndex];
    }

    /**
     * 更新第index个节点状态更新后，前一节点和当前节点的连通性状态
     *
     * @param index 操作节点索引
     */
    private void updateConnectivity(int index) {
        if (index > this.maxLevel - 1) {
            return;
        }
        boolean[] previousNode = null;
        boolean[] nextNode = null;
        if (index > 0) {
            previousNode = this.statusArray[index - 1];
        }
        if (index < this.maxLevel - 1) {
            nextNode = this.statusArray[index + 1];
        }
        boolean[] currentNode = this.statusArray[index];

        this.connectivityArray[index] = (previousNode == null || getNodeConnectivity(currentNode, previousNode)) && (
            nextNode == null || getNodeConnectivity(currentNode, nextNode));
    }

    /**
     * 更新第index个节点状态更新后，前一节点和当前节点的连通性状态
     *
     * @param node1 比较节点1
     * @param node2 比较节点2
     */
    private boolean getNodeConnectivity(boolean[] node1, boolean[] node2) {
        return (node1[0] && node2[0]) || (node1[1] && node2[1]);
    }

    /**
     * 检测连通性
     *
     * @param array 节点连通性数组
     * @return 0:不连通 1:连通
     */
    private int check(boolean[] array) {
        for (boolean item : array) {
            if (!item) {
                return 0;
            }
        }
        return 1;
    }
}
