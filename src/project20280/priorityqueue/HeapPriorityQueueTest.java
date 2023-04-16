package project20280.priorityqueue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HeapPriorityQueueTest {

    @Test
    void testSize() {
        HeapPriorityQueue<Integer, String> pq = new HeapPriorityQueue<>();
        int n = 10;
        for (int i = 0; i < n; ++i) {
            pq.insert(i, Integer.toString(i));
        }
        assertEquals(n, pq.size());
    }

    @Test
    void testMin() {
        Integer[] arr = new Integer[]{35, 26, 15, 24, 33, 4, 12, 1, 23, 21, 2, 5};
        HeapPriorityQueue<Integer, String> pq = new HeapPriorityQueue<>();

        for (Integer i : arr) pq.insert(i, Integer.toString(i));

        assertEquals(1, pq.min().getKey());
        assertEquals("1", pq.min().getValue());
    }

    @Test
    void testInsert() {
        Integer[] arr = new Integer[]{35, 26, 15, 24, 33, 4, 12, 1, 23, 21, 2, 5};
        HeapPriorityQueue<Integer, String> pq = new HeapPriorityQueue<>();

        for (Integer i : arr) pq.insert(i, Integer.toString(i));

        assertEquals(12, pq.size());
        assertEquals("[1, 2, 5, 23, 4, 12, 15, 35, 24, 33, 21, 26]", pq.toString());

    }

    @Test
    void testRemoveMin() {
        Integer[] arr = new Integer[]{35, 26, 15, 24, 33, 4, 12, 1, 23, 21, 2, 5};
        HeapPriorityQueue<Integer, String> pq = new HeapPriorityQueue<>();

        for (Integer i : arr) pq.insert(i, Integer.toString(i));

        assertEquals(12, pq.size());
        assertEquals(1, pq.removeMin().getKey());
        assertEquals(11, pq.size());
        assertEquals(2, pq.min().getKey());
    }

    @Test
    void testToString() {
        Integer[] arr = new Integer[]{35, 26, 15, 24, 33, 4, 12, 1, 23, 21, 2, 5};
        HeapPriorityQueue<Integer, String> pq = new HeapPriorityQueue<>();

        for (Integer i : arr) pq.insert(i, Integer.toString(i));

        assertEquals("[1, 2, 5, 23, 4, 12, 15, 35, 24, 33, 21, 26]", pq.toString());
    }

    @Test
    void testHeapify() {
        Integer[] rands = new Integer[]{16,15,4,12,6,7,23,20,25,9,11,17,5,8,14};
        HeapPriorityQueue<Integer, Integer> pq = new HeapPriorityQueue<>(rands, rands);

        System.out.println(pq.toBinaryTreeString());
        
        System.out.println("elements: " + rands);
        System.out.println("after adding elements: " + pq);

        System.out.println("min element: " + pq.min());

        pq.removeMin();
        System.out.println("after removeMin: " + pq);
    }
}
