public class CommandProcessor {
    private String[] commands;
    private Car car;

    public void processInput(String input) {
        this.commands = input.split(",");
        int fuel = Integer.parseInt(commands[1]);
        String type = commands[0];
        this.car = createCar(type, fuel);
        int numCommands = commands.length;
        for(int i = 2; i < numCommands; ++i) {
            String comm = commands[i];
            if(comm.equals("accelerate")) {
                this.car.accelerate();
            } else if (comm.equals("brake")) {
                this.car.brake();
            } else if (comm.startsWith("drive")) {
                int distance = Integer.parseInt(comm.split(" ")[1]);
                car.drive(distance);
            }
            // System.out.println(car.toString());
        }
    };

    private Car createCar(String type, int fuel) {
        if (type.equals("Sedan")) {
            return new Sedan(fuel);
        } else if (type.equals("SUV")) {
            return new SUV(fuel);
        } else {
            return new SportsCar(fuel);
        }
    };

    private void executeCommand(String command) {

    };

    public String getResult() {
        String carTypeAndModel = commands[0];
        String res = "";
        res += (carTypeAndModel + " - Model: " + carTypeAndModel) + "\n";
        res += ("Final Speed: " + car.getSpeed() + " km/h") + "\n";
        res += ("Fuel Remaining: " + car.getFuel()) + "\n";
        res += ("Distance Covered: " + car.getDistanceCovered() + " km") + "\n";
        return res;
    }
}