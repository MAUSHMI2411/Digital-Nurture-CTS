/**
 * Exercise 5: Task Management System
 *
 * Linked List types:
 *   Singly Linked List  – each node holds data + pointer to next.
 *   Doubly Linked List  – each node holds data + pointer to next AND previous.
 *                         Allows O(1) deletion when node reference is known.
 *   Circular Linked List– last node points back to head; useful for round-robin.
 *
 * Advantages over arrays:
 *   - Dynamic size – no upfront capacity needed.
 *   - O(1) insertion/deletion at head (no shifting).
 *   - Memory allocated only for existing elements.
 *
 * Time complexity:
 *   addAtHead    O(1)
 *   addAtTail    O(n)  – must traverse to end (can be O(1) with tail pointer)
 *   search       O(n)
 *   traverse     O(n)
 *   delete       O(n)  – search + pointer update
 *
 * When to prefer linked lists:
 *   Frequent insertions/deletions at arbitrary positions, unknown or highly
 *   variable number of elements, when random index-based access is not needed.
 */
public class TaskManager {

    // ---------------------------------------------------------------- model
    static class Task {
        int    taskId;
        String taskName;
        String status;
        Task   next;

        Task(int id, String name, String status) {
            this.taskId   = id;
            this.taskName = name;
            this.status   = status;
            this.next     = null;
        }

        @Override public String toString() {
            return String.format("Task[id=%d, name=%s, status=%s]",
                    taskId, taskName, status);
        }
    }

    private Task head;

    // ------------------------------------------------------------------ add
    /** Add at tail – O(n); change to add at head for O(1) */
    public void addTask(Task task) {
        if (head == null) { head = task; }
        else {
            Task cur = head;
            while (cur.next != null) cur = cur.next;
            cur.next = task;
        }
        System.out.println("Added: " + task);
    }

    // --------------------------------------------------------------- search
    /** O(n) */
    public Task searchById(int id) {
        Task cur = head;
        while (cur != null) {
            if (cur.taskId == id) return cur;
            cur = cur.next;
        }
        return null;
    }

    // -------------------------------------------------------------- traverse
    /** O(n) */
    public void traverse() {
        System.out.println("--- Task List ---");
        if (head == null) { System.out.println("(empty)"); return; }
        Task cur = head;
        while (cur != null) {
            System.out.println(cur);
            cur = cur.next;
        }
    }

    // --------------------------------------------------------------- delete
    /** O(n) */
    public void deleteTask(int id) {
        if (head == null) { System.out.println("List is empty."); return; }

        if (head.taskId == id) {
            System.out.println("Deleted: " + head);
            head = head.next;
            return;
        }

        Task prev = head, cur = head.next;
        while (cur != null) {
            if (cur.taskId == id) {
                System.out.println("Deleted: " + cur);
                prev.next = cur.next;
                return;
            }
            prev = cur;
            cur  = cur.next;
        }
        System.out.println("Task id " + id + " not found.");
    }

    // ----------------------------------------------------------------- main
    public static void main(String[] args) {
        TaskManager mgr = new TaskManager();

        mgr.addTask(new Task(1, "Design DB schema",   "Pending"));
        mgr.addTask(new Task(2, "Implement API",       "In Progress"));
        mgr.addTask(new Task(3, "Write unit tests",    "Pending"));
        mgr.addTask(new Task(4, "Deploy to staging",   "Not Started"));

        System.out.println();
        mgr.traverse();

        System.out.println();
        Task found = mgr.searchById(2);
        System.out.println("Search id=2: " + (found != null ? found : "not found"));

        System.out.println();
        mgr.deleteTask(3);
        mgr.deleteTask(99);

        System.out.println();
        mgr.traverse();
    }
}
