package pl.aga.datastructure.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BoundedStackTest {

    @Test
    public void shouldAddElement() {

        Stack<String> stack = new BoundedStack<String>(String.class, 5);

        boolean result = stack.push("cat");
        boolean result1 = stack.push("dog");

        assertEquals(true, result);
        assertEquals(true, result1);
        assertEquals(2, stack.size());
    }

    @Test
    public void shouldGetElement() {
        Stack<String> stack = new BoundedStack<String>(String.class, 5);

        stack.push("cat");
        stack.push("dog");
        String result = stack.pop();
        String result1 = stack.pop();

        assertEquals("dog", result);
        assertEquals("cat", result1);
    }

    @Test
    public void shouldIndexBeOnO() {
        Stack<String> stack = new BoundedStack<String>(String.class, 5);

        stack.push("cat");
        stack.push("dog");
        String result1 = stack.pop();
        String result2 = stack.pop();
        String result3 = stack.pop();

        assertEquals(0, stack.size());
        assertEquals("dog", result1);
        assertEquals("cat", result2);
        assertEquals(null, result3);
    }

    @Test
    public void shouldReturnFalseAfterAddToMuchElement() {
        Stack<String> stack = new BoundedStack<>(String.class, 1);

        stack.push("cat");
        stack.push("dog");
        boolean result = stack.push("mouse");

        assertEquals(false, result);
    }
}