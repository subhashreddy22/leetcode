package com.leetcode.heap;

import java.util.Arrays;

public class MinHeap {

    int capacity;
    int size;
    int[] heap;

    public MinHeap() {
        this.capacity = 10;
        this.size = 0;
        this.heap = new int[capacity];
    }

    public int peek() {
        if (heap.length == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        return heap[0];
    }

    public void insert(int value) {
        resize();
        heap[size] = value;
        size++;
        heapifyUp();
    }

    public int poll() {
        if (heap.length == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        int value = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown();
        return value;
    }

    private void heapifyUp() {
        int index = size - 1;

        while (getParentIndex(index) >= 0) {
            if (heap[getParentIndex(index)] > heap[index]) {
                swap(getParentIndex(index), index);
                index = getParentIndex(index);
            } else {
                break;
            }
        }
    }

    private void heapifyDown() {
        int index = 0;

        while(getLeftChildIndex(index) < size) {
            int smallerIndex = index;
            if (heap[getLeftChildIndex(index)] < heap[smallerIndex]) {
                smallerIndex = getLeftChildIndex(index);
            }
            if (heap[getRightChildIndex(index)] < heap[smallerIndex]) {
                smallerIndex = getRightChildIndex(index);
            }
            if (smallerIndex != index) {
                swap(smallerIndex, index);
            } else {
                break;
            }
        }
    }

    private void resize() {
        if (capacity == size) {
            heap = Arrays.copyOf(heap, 2 * capacity);
            capacity = 2 * capacity;
        }
    }

    private int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    private int getLeftChildIndex(int parentIndex) {
        return (2 * parentIndex) + 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return (2 * parentIndex) + 2;
    }

    private void swap(int parentIndex, int index) {
        int temp = heap[parentIndex];
        heap[parentIndex] = heap[index];
        heap[index] = temp;
    }

    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + "->");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();
        minHeap.insert(4);
        minHeap.insert(10);
        minHeap.insert(3);
        minHeap.insert(5);
        minHeap.insert(1);
        minHeap.printHeap();
        System.out.println("peek --> " + minHeap.peek());
        minHeap.printHeap();
        System.out.println("poll --> " + minHeap.poll());
        minHeap.printHeap();
        minHeap.insert(1);
        minHeap.printHeap();
    }
}
