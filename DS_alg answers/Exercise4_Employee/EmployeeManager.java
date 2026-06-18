/**
 * Exercise 4: Employee Management System
 *
 * Array memory representation:
 *   Arrays occupy a contiguous block of memory. Each element is accessed
 *   via base_address + (index × element_size), giving O(1) random access.
 *   This makes arrays cache-friendly and extremely fast for index-based reads.
 *
 * Advantages of arrays:
 *   - O(1) access by index
 *   - Low memory overhead (no pointers)
 *   - Cache-friendly sequential access
 *
 * Limitations:
 *   - Fixed size – must specify capacity upfront
 *   - Insertion/deletion in middle requires shifting → O(n)
 *   - Wasteful if many slots are empty
 *
 * Time complexity:
 *   add (at next slot)  O(1)
 *   search by id        O(n)  – must scan unsorted array
 *   traverse            O(n)
 *   delete              O(n)  – search + shift
 *
 * When to use arrays:
 *   Use when the size is known in advance, frequent index-based access is
 *   needed, and insertions/deletions are infrequent.
 */
public class EmployeeManager {

    static class Employee {
        int    employeeId;
        String name;
        String position;
        double salary;

        Employee(int id, String name, String position, double salary) {
            this.employeeId = id;
            this.name       = name;
            this.position   = position;
            this.salary     = salary;
        }

        @Override public String toString() {
            return String.format("Employee[id=%d, name=%s, position=%s, salary=%.2f]",
                    employeeId, name, position, salary);
        }
    }

    private Employee[] employees;
    private int size;

    public EmployeeManager(int capacity) {
        employees = new Employee[capacity];
        size      = 0;
    }

    // ------------------------------------------------------------------- add
    /** O(1) – appends at next available index */
    public void addEmployee(Employee e) {
        if (size == employees.length) {
            System.out.println("Array full – cannot add " + e.name);
            return;
        }
        employees[size++] = e;
        System.out.println("Added: " + e);
    }

    // ---------------------------------------------------------------- search
    /** O(n) – linear scan */
    public Employee searchById(int id) {
        for (int i = 0; i < size; i++) {
            if (employees[i].employeeId == id) return employees[i];
        }
        return null;
    }

    // -------------------------------------------------------------- traverse
    /** O(n) */
    public void traverse() {
        System.out.println("--- All Employees ---");
        for (int i = 0; i < size; i++) System.out.println(employees[i]);
    }

    // ---------------------------------------------------------------- delete
    /** O(n) – find + shift left */
    public boolean deleteEmployee(int id) {
        for (int i = 0; i < size; i++) {
            if (employees[i].employeeId == id) {
                Employee removed = employees[i];
                // Shift remaining elements left
                for (int j = i; j < size - 1; j++) employees[j] = employees[j + 1];
                employees[--size] = null;
                System.out.println("Deleted: " + removed);
                return true;
            }
        }
        System.out.println("Employee id " + id + " not found.");
        return false;
    }

    // ----------------------------------------------------------------- main
    public static void main(String[] args) {
        EmployeeManager mgr = new EmployeeManager(10);

        mgr.addEmployee(new Employee(1, "Alice",   "Engineer",   85000));
        mgr.addEmployee(new Employee(2, "Bob",     "Manager",   120000));
        mgr.addEmployee(new Employee(3, "Carol",   "Designer",   70000));
        mgr.addEmployee(new Employee(4, "Dave",    "Engineer",   90000));

        System.out.println();
        mgr.traverse();

        System.out.println();
        Employee found = mgr.searchById(3);
        System.out.println("Search id=3: " + (found != null ? found : "not found"));

        System.out.println();
        mgr.deleteEmployee(2);
        mgr.deleteEmployee(99);

        System.out.println();
        mgr.traverse();
    }
}
