package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfSystemProperties;

import static org.junit.jupiter.api.Assertions.*;
@Nested
class LinkedListTest {
    private LinkedList<Integer> list;

    @BeforeEach
    public void setUp() {
        list = new LinkedList<>();
    }

    @Test
    @DisplayName("T1 - testAdd()")
    public void testAdd() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(3, list.size());
    }

    @Test
    @DisplayName("T2 - testRemove()")
    public void testRemove() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertTrue(list.remove(2));
        assertFalse(list.remove(4));
        assertEquals(2, list.size());
    }

    @Test
    @DisplayName("T3 - testGet()")
    public void testGet() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(2, list.get(1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(3));
    }

    @Test
    @DisplayName("T4 - testSizeAndIsEmpty()")
    public void testSizeAndIsEmpty() {
        assertTrue(list.isEmpty());
        list.add(1);
        assertFalse(list.isEmpty());
        assertEquals(1, list.size());
        list.remove(1);
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test
    @DisplayName("T5 - testNodeConstructor()")
    public void testNodeConstructor() {
        Integer testData = 42;
        LinkedList<Integer>.Node<Integer> node = list.new Node<Integer> (testData);
        assertEquals(testData, node.getData());
        assertNull(node.getNext());
    }
}