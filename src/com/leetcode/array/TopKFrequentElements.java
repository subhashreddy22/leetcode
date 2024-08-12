package com.leetcode.array;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

// https://leetcode.com/problems/top-k-frequent-elements/
public class TopKFrequentElements {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent(new int[] {1, 1, 1, 2, 2, 3}, 2)));
        System.out.println(Arrays.toString(topKFrequentWithHeap(new int[] {1, 1, 1, 2, 2, 3}, 2)));
    }

    private static int[] topKFrequentWithHeap(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        // max-heap
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a)); // comparator to store in descending order

        for (int i : map.keySet()) {
            queue.add(i);
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            result.add(queue.poll());
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

    // 1st solution
    private static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        LinkedHashMap<Integer, Integer> sortedMap = map.entrySet().stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (key1, key2) -> key1, LinkedHashMap::new));

        return sortedMap.entrySet().stream().limit(k).mapToInt(Map.Entry::getKey).toArray();
    }

}
