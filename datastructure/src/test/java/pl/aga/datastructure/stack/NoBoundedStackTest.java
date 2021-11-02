package pl.aga.datastructure.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NoBoundedStackTest {

    @Test
    public void shouldPushElements() {
        Stack<String> stack = new NoBoundedStack<>();

        boolean result = stack.push("cat");

        assertEquals(true, result);
    }

    @Test
    public void shouldPopElement() {
        Stack<String> stack = new NoBoundedStack<>();
        stack.push("cat");
        stack.push("dog");
        stack.push("mouse");

        assertEquals("mouse", stack.pop());
        assertEquals("dog", stack.pop());
        assertEquals("cat", stack.pop());
        assertEquals(0, stack.size());
    }

    @Test
    public void shouldPopNullIfEmptyStack() {
        Stack<String> stack = new NoBoundedStack<>();
        String res = stack.pop();
        assertEquals(null, res);
    }


}