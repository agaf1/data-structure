package pl.aga.datastructure.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
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

        assertEquals(2, stack.size());

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

    @Test
    public void shouldIterate() {

        String[] testElements = {"a", "b", "c", "d"};
        Stack<String> stack = new BoundedStack<>(String.class, testElements.length);

        for (String ele : testElements) {
            stack.push(ele);
        }

        assertEquals(4, stack.size());


        String[] testElementsRevers = new String[testElements.length];
        int j = 0;
        for (int i = testElements.length - 1; i >= 0; i--) {
            testElementsRevers[j++] = testElements[i];
        }

        String[] testStack = new String[testElements.length];
        int k = 0;

        for (String element : stack) {
            testStack[k++] = element;
        }

        assertArrayEquals(testElementsRevers, testStack);

    }
}

