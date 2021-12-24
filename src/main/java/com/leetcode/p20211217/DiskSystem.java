/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package main.java.com.leetcode.p20211217;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * xxx
 *
 * @author y00290641
 * @since 2021/12/17
 */
public class DiskSystem {
    private static final int EMPTY = 9999;

    private final List<Integer> list = new ArrayList<>();

    private final int capacity;

    private int used;

    private final Map<Integer, Integer> fileMap = new HashMap<>();

    public DiskSystem(int capacity) {
        this.capacity = capacity;
        this.used = 0;
        for (int i = 0; i < capacity; i++) {
            list.add(EMPTY);
        }
    }

    /**
     * cal add
     *
     * @param fileId 文件ID
     * @param fileSize 文件大小
     * @return 文件索引
     */
    public int add(int fileId, int fileSize) {
        if (this.used + fileSize > this.capacity) {
            return -1;
        }
        this.used += fileSize;
        this.fileMap.put(fileId, fileSize);
        for (int i = 0; i < list.size(); i++) {
            Integer item = list.get(i);
            if (item != EMPTY) {
                continue;
            }
            list.set(i, fileId);
            fileSize -= 1;
            if (fileSize == 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * cal remove
     *
     * @param fileId 文件ID
     * @return 剩余空间
     */
    public int remove(int fileId) {
        if (!this.fileMap.containsKey(fileId)) {
            return -1;
        }
        for (int i = 0; i < list.size(); i++) {
            Integer item = list.get(i);
            if (item == fileId) {
                list.set(i, EMPTY);
            }
        }
        this.used -= this.fileMap.get(fileId);
        this.fileMap.remove(fileId);
        return this.capacity - this.used;
    }

    /**
     * cal defrag
     *
     * @return 剩余文件数
     */
    public int defrag() {
        this.list.sort(Comparator.comparingInt(item -> item));
        return this.fileMap.size();
    }
}