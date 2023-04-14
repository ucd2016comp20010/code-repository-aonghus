package project20280.tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class TreeMapTest {

    @Test
    void testSize() {
        TreeMap<Integer, String> map = new TreeMap<>();
        assertEquals(0, map.size());
        map.put(1, "one");
        map.put(2, "two");
        assertEquals(2, map.size());
    }

    @Test
    void testRoot() {
        TreeMap<Integer, String> map = new TreeMap<>();
        Integer[] arr = new Integer[]{35, 26, 15, 24, 33, 4, 12, 1, 23, 21, 2, 5};

        for (Integer i : arr) {
            map.put(i, Integer.toString(i));
        }

        assertEquals(35, map.root().getElement().getKey());
    }

    @Test
    void testGet() {
        TreeMap<Integer, String> map = new TreeMap<>();
        Integer[] arr = new Integer[]{35, 26, 15, 24, 33, 4, 12, 1, 23, 21, 2, 5};

        for (Integer i : arr) {
            map.put(i, Integer.toString(i));
        }
        assertEquals("15", map.get(15));
        assertEquals("24", map.get(24));
        assertNull(map.get(-1));

    }

    @Test
    void testPut() {
        TreeMap<Integer, String> map = new TreeMap<>();
        Integer[] arr = new Integer[]{35, 26, 15, 24, 33, 4, 12, 1, 23, 21, 2, 5};

        for (Integer i : arr) {
            map.put(i, Integer.toString(i));
        }

        assertEquals("[1, 2, 4, 5, 12, 15, 21, 23, 24, 26, 33, 35]", map.toString());
    }

    @Test
    void testRemoveK() {
        TreeMap<Integer, String> map = new TreeMap<>();
        //Integer[] arr = new Integer[]{35, 26, 15, 24, 33, 4, 12, 1, 23, 21, 2, 5};
        //Integer[] arr = new Integer[]{35, 26, 36};
        Integer [] arr = new Integer[] {44, 17, 88, 8, 32, 65, 97, 28, 21, 29, 54,82,93,76,80};

        for (Integer i : arr) {
            map.put(i, Integer.toString(i));
        }

        System.out.println(map.toBinaryTreeString());
//        assertEquals(arr.length, map.size());
//        int n = arr[arr.length-1];
//        assertEquals(Integer.toString(n), map.remove(n));
//        assertEquals(arr.length - 1, map.size());
//        System.out.println(map.toBinaryTreeString());

        //int n = arr[0];
        int n = 88;
        assertEquals(Integer.toString(n), map.remove(n));
        assertEquals(arr.length - 1, map.size());
        System.out.println(map.toBinaryTreeString());

        n = 32;
        assertEquals(Integer.toString(n), map.remove(n));
        assertEquals(arr.length - 2, map.size());
        System.out.println(map.toBinaryTreeString());

        n = 93;
        assertEquals(Integer.toString(n), map.remove(n));
        assertEquals(arr.length - 3, map.size());
        System.out.println(map.toBinaryTreeString());
    }

    @Test
    void testFirstEntry() {
        //TreeMap<Integer, String> map = new TreeMap<>();
        TreeMap<Integer, String> map = new TreeMap<>();
        //Integer[] arr = new Integer[]{35, 26, 15, 24, 33, 4, 12, 1, 23, 21, 2, 5};
        Integer [] arr = new Integer[] {44, 17, 88, 8, 32, 65, 97, 28, 21, 29, 54,82,93,76,80};


        for (Integer i : arr) {
            map.put(i, Integer.toString(i));
        }

        assertEquals(8, map.firstEntry().getKey());
    }

    @Test
    void testLastEntry() {
        TreeMap<Integer, String> map = new TreeMap<>();
        //java.util.TreeMap<Integer, String> map = new java.util.TreeMap<>();
        //Integer[] arr = new Integer[]{35, 26, 15, 24, 33, 4, 12, 1, 23, 21, 2, 5};
        Integer [] arr = new Integer[] {44, 17, 88, 8, 32, 65, 97, 28, 21, 29, 54,82,93,76,80};

        for (Integer i : arr) {
            map.put(i, Integer.toString(i));
        }

        assertEquals(97, map.lastEntry().getKey());
    }

    @Test
    void testCeilingEntry() {
        TreeMap<Integer, String> map = new TreeMap<>();
        //java.util.TreeMap<Integer, String> map = new java.util.TreeMap<>();
        //Integer[] arr = new Integer[]{35, 26, 15, 24, 33, 4, 12, 1, 23, 21, 2, 5};
        Integer [] arr = new Integer[] {44, 17, 88, 8, 32, 65, 97, 28, 21, 29, 54,82,93,76,80};

        for (Integer i : arr) {
            map.put(i, Integer.toString(i));
        }

        assertEquals(88, map.ceilingEntry(88).getKey());

        assertEquals(88, map.ceilingEntry(87).getKey());

        assertEquals(44, map.ceilingEntry(33).getKey());

    }

    @Test
    void testFloorEntry() {
        TreeMap<Integer, String> map = new TreeMap<>();
        //java.util.TreeMap<Integer, String> map = new java.util.TreeMap<>();
        //Integer[] arr = new Integer[]{35, 26, 15, 24, 33, 4, 12, 1, 23, 21, 2, 5};
        Integer [] arr = new Integer[] {44, 17, 88, 8, 32, 65, 97, 28, 21, 29, 54,82,93,76,80};

        for (Integer i : arr) {
            map.put(i, Integer.toString(i));
        }

        assertEquals(88, map.floorEntry(88).getKey());
        assertEquals(82, map.floorEntry(87).getKey());
        assertEquals(17, map.floorEntry(20).getKey());

    }

    @Test
    void testLowerEntry() {
        TreeMap<Integer, String> map = new TreeMap<>();
        //java.util.TreeMap<Integer, String> map = new java.util.TreeMap<>();
        //Integer[] arr = new Integer[]{35, 26, 15, 24, 33, 4, 12, 1, 23, 21, 2, 5};
        Integer [] arr = new Integer[] {44, 17, 88, 8, 32, 65, 97, 28, 21, 29, 54,82,93,76,80};

        for (Integer i : arr) {
            map.put(i, Integer.toString(i));
        }

        assertEquals(82, map.lowerEntry(88).getKey());
        assertEquals(65, map.lowerEntry(76).getKey());
        assertEquals(65, map.lowerEntry(75).getKey());
    }

    @Test
    void testHigherEntry() {
        TreeMap<Integer, String> map = new TreeMap<>();
        //java.util.TreeMap<Integer, String> map = new java.util.TreeMap<>();
        //Integer[] arr = new Integer[]{35, 26, 15, 24, 33, 4, 12, 1, 23, 21, 2, 5};
        Integer [] arr = new Integer[] {44, 17, 88, 8, 32, 65, 97, 28, 21, 29, 54,82,93,76,80};


        for (Integer i : arr) {
            map.put(i, Integer.toString(i));
        }

        assertEquals(93, map.higherEntry(88).getKey());
        assertEquals(97, map.higherEntry(93).getKey());
        assertEquals(null, map.higherEntry(100));
        assertEquals(54, map.higherEntry(44).getKey());
        assertEquals(44, map.higherEntry(33).getKey());
    }

    @Test
    void testToString() {
        TreeMap<Integer, String> map = new TreeMap<>();
        //java.util.TreeMap<Integer, String> map = new java.util.TreeMap<>();
        Integer[] arr = new Integer[]{35, 26, 15, 24, 33, 4, 12, 1, 23, 21, 2, 5};

        for (Integer i : arr) {
            map.put(i, Integer.toString(i));
        }
        assertEquals("[1, 2, 4, 5, 12, 15, 21, 23, 24, 26, 33, 35]", map.toString());
    }

    @Test
    void testSubMap() {
        TreeMap<Integer, String> map = new TreeMap<>();
        //java.util.TreeMap<Integer, String> map = new java.util.TreeMap<>();
        //Integer[] arr = new Integer[]{35, 26, 15, 24, 33, 4, 12, 1, 23, 21, 2, 5};
        Integer [] arr = new Integer[] {44, 17, 88, 8, 32, 65, 97, 28, 21, 29, 54,82,93,76,80};

        for (Integer i : arr) {
            map.put(i, Integer.toString(i));
        }

        //assertEquals("[12, 15, 21, 23, 24, 26, 33]", map.subMap(12, 34).toString());
        assertEquals("[44, 54, 65, 76, 80, 82]", map.subMap(33, 83).toString());
    }

}
