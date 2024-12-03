import java.util.*;

public class L12_Q1_Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());
        Library library = new Library();

        for (int i = 0; i < n; i++) {
            String commandLine = scanner.nextLine().trim();
            String[] parts = commandLine.split(" ", 2);
            String command = parts[0];

            try {
                if (parts.length > 1) {
                    String arguments = parts[1];

                    switch (command) {
                        case "ADD_BOOK":
                            String isbn = arguments.substring(0, arguments.indexOf("\"")).trim();
                            List<String> bookDetails = extractQuotedStrings(arguments);
                            library.addBook(isbn, bookDetails.get(0), bookDetails.get(1));
                            break;

                        case "REGISTER_MEMBER":
                            String[] memberParts = arguments.split("\"");
                            String memberId = memberParts[0].trim();
                            String memberName = memberParts[1].trim();
                            library.registerMember(memberId, memberName);
                            break;

                        case "BORROW":
                            String[] borrowParts = arguments.trim().split("\\s+");
                            library.borrowBook(borrowParts[1], borrowParts[0]); // Note: ISBN, ID order
                            break;

                        case "RETURN":
                            String[] returnParts = arguments.trim().split("\\s+");
                            library.returnBook(returnParts[1], returnParts[0]); // Note: ISBN, ID order
                            break;

                        case "DISPLAY_MEMBER":
                            library.displayMemberHistory(arguments.trim());
                            break;
                    }
                } else if (command.equals("DISPLAY_CATALOG")) {
                    library.displayBookCatalog();
                }

            } catch (Exception e) {
                System.out.println("Error processing command: " + commandLine);
                e.printStackTrace();
            }
        }
        scanner.close();
    }

    private static List<String> extractQuotedStrings(String input) {
        List<String> matches = new ArrayList<>();
        int start = -1;
        boolean inQuote = false;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '"') {
                if (!inQuote) {
                    start = i + 1;
                    inQuote = true;
                } else {
                    matches.add(input.substring(start, i));
                    inQuote = false;
                }
            }
        }

        return matches;
    }
}