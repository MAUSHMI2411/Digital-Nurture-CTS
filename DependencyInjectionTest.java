/**
 * Demonstrates creating different configurations of Computer using the
 * Builder pattern.
 */
public class BuilderTest {
    public static void main(String[] args) {
        Computer officeComputer = new Computer.Builder()
                .cpu("Intel i5")
                .ram("8GB")
                .build();
        System.out.println("Office PC -> " + officeComputer);

        Computer gamingComputer = new Computer.Builder()
                .cpu("Intel i9")
                .ram("32GB")
                .storage("2TB NVMe SSD")
                .gpu("NVIDIA RTX 4080")
                .build();
        System.out.println("Gaming PC -> " + gamingComputer);
    }
}
