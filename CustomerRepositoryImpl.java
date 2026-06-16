/**
 * Exercise 3: Implementing the Builder Pattern
 *
 * Computer has several optional parts. The nested Builder class manages
 * the step-by-step construction so the client doesn't need a constructor
 * with many parameters.
 */
public class Computer {

    // Required
    private final String cpu;
    private final String ram;

    // Optional
    private final String storage;
    private final String gpu;
    private final boolean wifiEnabled;
    private final boolean bluetoothEnabled;

    // Private constructor only callable from Builder.build()
    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.gpu = builder.gpu;
        this.wifiEnabled = builder.wifiEnabled;
        this.bluetoothEnabled = builder.bluetoothEnabled;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "cpu='" + cpu + '\'' +
                ", ram='" + ram + '\'' +
                ", storage='" + storage + '\'' +
                ", gpu='" + gpu + '\'' +
                ", wifiEnabled=" + wifiEnabled +
                ", bluetoothEnabled=" + bluetoothEnabled +
                '}';
    }

    public static class Builder {
        private String cpu;
        private String ram;
        private String storage = "256GB SSD";   // sensible defaults
        private String gpu = "Integrated Graphics";
        private boolean wifiEnabled = true;
        private boolean bluetoothEnabled = true;

        public Builder cpu(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public Builder ram(String ram) {
            this.ram = ram;
            return this;
        }

        public Builder storage(String storage) {
            this.storage = storage;
            return this;
        }

        public Builder gpu(String gpu) {
            this.gpu = gpu;
            return this;
        }

        public Builder wifiEnabled(boolean wifiEnabled) {
            this.wifiEnabled = wifiEnabled;
            return this;
        }

        public Builder bluetoothEnabled(boolean bluetoothEnabled) {
            this.bluetoothEnabled = bluetoothEnabled;
            return this;
        }

        public Computer build() {
            if (cpu == null || ram == null) {
                throw new IllegalStateException("CPU and RAM are required to build a Computer");
            }
            return new Computer(this);
        }
    }
}
