package pl.aga.datastructure.linkedMap;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class LinkedMapTest {

    @Test
    public void shouldPutNewPair() {
        LinkedMap<String, String> map = new LinkedMap<>();
        map.put("Tom", "doctor");
        map.put("Luke", "teacher");
        assertEquals(2, map.size());
    }

    @Test
    public void shouldReplaceValueForExistingKey() {
        LinkedMap<String, String> map = new LinkedMap<>();
        map.put("Tom", "doctor");
        map.put("Luke", "teacher");
        map.put("Ann", "teacher");
        map.put("Kate", "civil engineer");

        assertEquals(4, map.size());

        map.put("Ann", "driver");
        assertEquals("driver", map.get("Ann"));

        assertEquals(4, map.size());
    }

    @Test
    public void shouldThrowIAException() {
        LinkedMap<String, String> map = new LinkedMap<>();

        assertThrows(IllegalArgumentException.class, () -> map.put(null, "doctor"));
    }

    @Test
    public void shouldDeletePairWhenNullValue() {
        LinkedMap<String, String> map = new LinkedMap<>();
        map.put("Tom", "doctor");
        map.put("Luke", "teacher");
        map.put("Ann", "driver");

        assertEquals(3, map.size());

        map.put("Mike", null);
        assertEquals(3, map.size());

        map.put("Luke", null);
        assertEquals(2, map.size());

        map.put("Tom", null);
        assertEquals(1, map.size());

        map.put("Ann", null);
        assertEquals(0, map.size());

    }

    @Test
    public void shouldReturnValueByKey() {
        LinkedMap<String, String> map = new LinkedMap<>();

        map.put("Luke", "teacher");
        map.put("Kate", "civil engineer");

        assertEquals("teacher", map.get("Luke"));
        assertEquals("civil engineer", map.get("Kate"));
    }

    @Test
    public void shouldReturnNullIfKeyNotExists() {
        LinkedMap<String, String> map = new LinkedMap<>();
        map.put("Tom", "doctor");
        map.put("Luke", "teacher");

        assertNull(map.get("Sofia"));
    }

    @Test
    public void shouldRemove() {
        LinkedMap<String, String> map = new LinkedMap<>();
        map.put("Tom", "doctor");
        map.delete("Tom");

        assertEquals(0, map.size());
    }

    @Test
    public void shouldValueExists() {
        LinkedMap<String, String> map = new LinkedMap<>();
        map.put("Tom", "doctor");
        map.put("Luke", "teacher");
        map.put("Ann", "driver");

        assertTrue(map.contains("Tom"));
        assertTrue(map.contains("Luke"));
        assertTrue(map.contains("Ann"));
    }

    @Test
    public void shouldValueNotExists() {
        LinkedMap<String, String> map = new LinkedMap<>();
        map.put("Tom", "doctor");
        map.put("Luke", "teacher");
        map.put("Ann", "driver");

        assertFalse(map.contains("Jess"));
    }

    @Test
    public void shouldIterateOverKeys() {
        Set<String> keys = Set.of("a", "b", "c");

        LinkedMap<String, String> map = new LinkedMap<>();
        for (String key : keys) {
            map.put(key, key);
        }

        Set<String> keysFromIterator = new HashSet<>();
        Iterator<String> it = map.keys();
        while (it.hasNext()) {
            keysFromIterator.add(it.next());
        }

        assertEquals(keys, keysFromIterator);
    }
}