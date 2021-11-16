package pl.aga.datastructure.dequeue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DequeueTest {

    @Test
    public void shouldIsEmpty() {
        Dequeue<String> dequeue = new Dequeue<>();

        assertEquals(true, dequeue.isEmpty());
    }

    @Test
    public void shouldPushLeft() {
        Dequeue<String> dequeue = new Dequeue<>();

        dequeue.pushLeft("cat");
        dequeue.pushLeft("dog");

        assertEquals(2, dequeue.size());

        String result = dequeue.popLeft();

        assertEquals("dog", result);
    }

    @Test
    public void shouldPushRight() {
        Dequeue<String> dequeue = new Dequeue<>();

        dequeue.pushRight("ala");
        dequeue.pushRight("kasia");
        dequeue.pushRight("gosia");
        dequeue.pushRight("zosia");

        assertEquals(4, dequeue.size());

        String result1 = dequeue.popRight();
        String result2 = dequeue.popRight();
        String result3 = dequeue.popRight();
        String result4 = dequeue.popRight();

        assertEquals("zosia", result1);
        assertEquals("gosia", result2);
        assertEquals("kasia", result3);
        assertEquals("ala", result4);


        assertEquals(0, dequeue.size());
    }

    @Test
    public void shouldPop() {
        Dequeue<String> dequeue = new Dequeue<>();

        dequeue.pushRight("ala");
        dequeue.pushRight("kasia");
        dequeue.pushRight("gosia");
        dequeue.pushRight("zosia");

        dequeue.popRight();
        dequeue.popRight();
        dequeue.popRight();
        dequeue.popRight();
        String result = dequeue.popLeft();

        assertEquals(null, result);
    }

    @Test
    public void shouldPushRightAndLeft() {
        Dequeue<String> dequeue = new Dequeue<>();
        dequeue.pushRight("tulipan");
        dequeue.pushRight("róza");
        dequeue.pushLeft("stokrotka");
        dequeue.pushRight("rumianek");

        assertEquals(4, dequeue.size());

    }

    @Test
    public void shouldPopRightAndLeft() {
        Dequeue<String> dequeue = new Dequeue<>();
        dequeue.pushRight("tulipan");
        dequeue.pushRight("róza");
        dequeue.pushLeft("stokrotka");
        dequeue.pushRight("rumianek");

        dequeue.popLeft();
        assertEquals(3, dequeue.size());

        dequeue.popLeft();
        assertEquals(2, dequeue.size());

        String result = dequeue.popRight();
        assertEquals("rumianek", result);
        assertEquals(false, dequeue.isEmpty());

        dequeue.popRight();
        assertEquals(0, dequeue.size());

        String result1 = dequeue.popLeft();
        assertEquals(null, result1);

        assertEquals(true, dequeue.isEmpty());

    }


}