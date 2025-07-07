// Node class representing a state in the text editor
class TextState {
    String content;
    TextState next, prev;

    public TextState(String content) {
        this.content = content;
        this.next = null;
        this.prev = null;
    }
}

// Doubly Linked List based Undo/Redo Text Editor
public class TextEditor {
    TextState head, tail, current;
    final int MAX_HISTORY = 10;
    int size = 0;

    // Add new state at the end (when user types or performs an action)
    void addState(String newText) {
        TextState newState = new TextState(newText);

        // If we’re adding after undo steps, discard all redo history
        if (current != null && current.next != null) {
            current.next.prev = null;
            current.next = null;
            tail = current;
            size = countFromHead();
        }

        if (head == null) {
            head = tail = current = newState;
        } else {
            tail.next = newState;
            newState.prev = tail;
            tail = newState;
            current = tail;
        }

        size++;

        // Limit history to last MAX_HISTORY states
        if (size > MAX_HISTORY) {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    // Undo operation (move to previous state)
    void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Undo performed.");
        } else {
            System.out.println("Cannot undo. Already at the oldest state.");
        }
    }

    // Redo operation (move to next state)
    void redo() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Redo performed.");
        } else {
            System.out.println("Cannot redo. Already at the latest state.");
        }
    }

    // Display current text content
    void displayCurrentState() {
        if (current != null) {
            System.out.println("Current Text: \"" + current.content + "\"");
        } else {
            System.out.println("Editor is empty.");
        }
    }

    // Helper: count nodes from head (for limiting size)
    int countFromHead() {
        int count = 0;
        TextState temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    // Test the text editor functionality
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();

        // Simulate typing or actions
        editor.addState("Hello");
        editor.addState("Hello, World");
        editor.addState("Hello, World!");
        editor.displayCurrentState(); // Should show: Hello, World!

        // Undo twice
        editor.undo();
        editor.displayCurrentState(); // Should show: Hello, World
        editor.undo();
        editor.displayCurrentState(); // Should show: Hello

        // Redo once
        editor.redo();
        editor.displayCurrentState(); // Should show: Hello, World

        // Add new content after undoing, should clear redo history
        editor.addState("Hello, GPT!");
        editor.displayCurrentState(); // Should show: Hello, GPT!
        editor.redo(); // Should not redo
        editor.displayCurrentState();

        // Add more to exceed max history
        for (int i = 1; i <= 10; i++) {
            editor.addState("Line " + i);
        }

        editor.displayCurrentState(); // Should show: Line 10
        editor.undo();
        editor.displayCurrentState(); // Should show: Line 9
    }
}
