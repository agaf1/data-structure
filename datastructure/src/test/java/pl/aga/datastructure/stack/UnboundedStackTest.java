package pl.aga.datastructure.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UnboundedStackTest {

    @Test
    public void shouldPushElements() {
        Stack<String> stack = new UnboundedStack<>();

        boolean result = stack.push("cat");

        assertEquals(true, result);
    }

    @Test
    public void shouldPopElement() {
        Stack<String> stack = new UnboundedStack<>();
        stack.push("cat");
        stack.push("dog");
        stack.push("mouse");
        assertEquals(3, stack.size());

        assertEquals("mouse", stack.pop());
        assertEquals("dog", stack.pop());
        assertEquals("cat", stack.pop());
        assertEquals(0, stack.size());
    }

    @Test
    public void shouldPopNullIfEmptyStack() {
        Stack<String> stack = new UnboundedStack<>();
        String res = stack.pop();
        assertEquals(null, res);
    }

    @Test
    public void shouldIterate() {
        Stack<String> stack = new UnboundedStack<>();
        stack.push("cat");
        stack.push("dog");
        stack.push("mouse");

        for (String e : stack) {
            System.out.println(e);
        }
    }


}