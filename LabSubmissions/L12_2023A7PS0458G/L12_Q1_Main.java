import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class L12_Q1_Main {
    public static void main(String[] args) {
        // Read all input first
        Scanner scanner = new Scanner(System.in);
        List<String> inputCommands = readAllInput(scanner);
        scanner.close();

        // Process the commands
        processCommands(inputCommands);
    }

    private static List<String> readAllInput(Scanner scanner) {
        List<String> commands = new ArrayList<>();
        
        // Read number of charging ports
        String numberOfPorts = scanner.nextLine();
        commands.add(numberOfPorts);
        
        // Read number of commands
        int n = Integer.parseInt(scanner.nextLine());
        commands.add(String.valueOf(n));
        
        // Read all commands
        for (int i = 0; i < n; i++) {
            commands.add(scanner.nextLine());
        }
        
        return commands;
    }

    private static void processCommands(List<String> commands) {
        // Parse number of ports
        int numberOfPorts = Integer.parseInt(commands.get(0));
        
        // Create charging manager
        ChargingManager chargingManager = new ChargingManager(numberOfPorts);
        
        // Get number of commands
        int n = Integer.parseInt(commands.get(1));
        
        // Process each command
        for (int i = 0; i < n; i++) {
            String line = commands.get(i + 2); // +2 to skip the first two lines
            String[] parts = line.split(" ");
            String action = parts[0];
            String name = parts[1];
            
            try {
                if (action.equals("ARRIVE")) {
                    if (parts.length > 2) {
                        // New car owner arrival
                        String make = parts[2];
                        String model = parts[3];
                        double batteryCapacity = Double.parseDouble(parts[4]);
                        chargingManager.processArrival(name, make, model, batteryCapacity);
                    } else {
                        // Existing car owner arrival
                        chargingManager.processArrival(name);
                    }
                } else if (action.equals("DEPART")) {
                    chargingManager.processDeparture(name);
                } else {
                    System.out.println("Error: Unknown action " + action);
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid battery capacity format");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Error: Invalid command format");
            }
        }
        
        // Display final results
        chargingManager.displayAllChargingHistories();
    }
}