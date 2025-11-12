package designPattern.builder;

public class Computer {
    // required
    private String ram;
    private String hdd;

    // optional
    private boolean isBluetoothEnable;
    private boolean isGraphiccardEnable;

    // constructor
    private Computer(ComputerBuilder builder) {
        this.ram = builder.ram;
        this.hdd = builder.hdd;
        this.isBluetoothEnable = builder.isBluetoothEnable;
        this.isGraphiccardEnable = builder.isGraphiccardEnable;
    }

    // getter
    public String getRam() {
        return this.ram;
    }

    public String getHdd() {
        return this.hdd;
    }

    public boolean isBluetoothEnable() {
        return this.isBluetoothEnable;
    }

    public boolean isGraphiccardEnable() {
        return this.isGraphiccardEnable;
    }

    // create a builder class nested inside this class
    public static class ComputerBuilder {
        // required
        private String ram;
        private String hdd;

        // optional
        private boolean isBluetoothEnable;
        private boolean isGraphiccardEnable;

        // public constructor where client can do and it only include the required data field not the optional one
        public ComputerBuilder(String ram, String hdd) {
            this.ram = ram;
            this.hdd = hdd;
        }

        // as for optional parameter is by setter
        public ComputerBuilder setBluetoothEnable(boolean bluetoothEnable) {
            this.isBluetoothEnable = bluetoothEnable;
            return this;
        }

        public ComputerBuilder setGraphiccardEnable(boolean graphiccardEnable) {
            this.isGraphiccardEnable = graphiccardEnable;
            return this;
        }

        public Computer build() {
            // access the constructor of the outer class
            return new Computer(this);
        }
    }
}
