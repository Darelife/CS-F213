import java.io.*;

public class L10_Q1_Main {
    @SuppressWarnings("CallToPrintStackTrace")
    public static void main(String[] args) {
        // if (args.length != 1) {
        //     System.out.println("Usage: java Main <input_file> <output_file>");
        //     return;
        // }

        // String inputFile = args[0];
        // char a=inputFile.charAt(5);  // First argument is the input file path
        // String outputFile = ("output"+a+".txt");  // Second argument is the output file path

        try {
            ByteArrayOutputStream baos;
            PrintStream originalOut;
            // Create a ByteArrayOutputStream to capture printed output
            try ( // Step 1: Read input from the provided input file
                    BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in))) {
                // Create a ByteArrayOutputStream to capture printed output
                baos = new ByteArrayOutputStream();
                originalOut = System.out; // Save the original System.out
                // Create a custom PrintStream to capture the output only (no console printing)
                PrintStream silentStream = new PrintStream(baos);
                System.setOut(silentStream);  // Set the custom PrintStream
                // Read the first line to initialize parking lot (compact and large spots)
                String[] firstLine = inputReader.readLine().split(" ");
                int numCompact = Integer.parseInt(firstLine[0]);
                int numLarge = Integer.parseInt(firstLine[1]);
                ParkingLot parkingLot = new ParkingLot(numCompact, numLarge);
                // Step 2: Read vehicle details from the input file and park them
                String vehicleLine;
                while ((vehicleLine = inputReader.readLine()) != null) {
                    String[] vehicleData = vehicleLine.split(" ");
                    String vehicleType = vehicleData[0];
                    String licensePlate = vehicleData[1];
                    Vehicle vehicle = null;
                    
                    // Create the appropriate vehicle based on type
                    switch (vehicleType) {
                        case "Car":
                             vehicle = new Car(licensePlate);
                             break;
                        case "Bike":
                             vehicle = new Bike(licensePlate);
                             break;
                        case "Bus" :
                             vehicle = new Bus(licensePlate);
                             break;
                        default :
                             System.out.println("Unknown vehicle type: " + vehicleType);
                             break;
                    }
                    
                    // Try to park the vehicle and print the result
                    if (vehicle != null) {
                        parkingLot.parkVehicle(vehicle);  // Captured silently
                    }
                }
            }

            // Restore the original System.out
            System.setOut(originalOut);

            // Step 3: Compare captured stdout with the provided output file
            String actualOutput = baos.toString();  // Captured output from stdout

            // Print the actual captured output (stdout)
            System.out.println(actualOutput);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
}
