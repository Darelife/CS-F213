### Required Collections Knowledge
- ArrayList/LinkedList: For storing lists of books, borrowing history
- HashMap: For storing member information and book catalog
- Queue: For managing book reservation requests
- Basic operations: add, remove, search, iterate

---
### Lab Documentation: Library Management System

**Objective**: To develop a simple library management system that allows for book cataloging, member registration, book borrowing, and return functionalities. This system also maintains borrowing history for each member and supports reservations for unavailable books.

---

### Scenario Overview

The library system consists of four main classes: `Book`, `Library`, `Member`, and a `Main` class for interaction. In this scenario:

- **Books** can be added to a library catalog, with each book having details such as ISBN, title, author, and availability status.
- **Members** can register with the library, borrow books if available, and reserve books if they are currently borrowed.
- The **Library** manages book cataloging, member registration, borrowing/return processes, and reservation queues.
- A **Main** class handles user commands and input/output, allowing the library to process commands for adding books, registering members, borrowing/returning books, displaying the catalog, and showing member histories.

---

### Class Overview

#### 1. `Book` Class

Represents a book with:
- **Attributes**: ISBN, title, author, and availability status.
- **Key Methods**:
  - `isAvailable()`: Checks if the book is available.
  - `setAvailable(boolean)`: Updates the availability status.
  - `toString()`: Returns a string representation of the book with title, author, and ISBN.

#### 2. `Member` Class

Represents a library member with:
- **Attributes**: ID, name, and borrowing history.
- **Key Methods**:
  - `addBorrowedBook(Book)`: Adds a book to the member’s borrowing history.
  - `displayBorrowingHistory()`: Displays all books borrowed by the member.

#### 3. `Library` Class

Manages the library operations, including:
- **Attributes**:
  - `bookCatalog`: Maps ISBNs to `Book` objects.
  - `members`: Maps member IDs to `Member` objects.
  - `reservationQueues`: Maps ISBNs to a queue of member IDs waiting for the book.
- **Key Methods**:
  - `addBook(String, String, String)`: Adds a book to the catalog.
  - `registerMember(String, String)`: Registers a new member.
  - `borrowBook(String, String)`: Borrows a book for a member if available; otherwise, adds the member to the reservation queue.
  - `returnBook(String, String)`: Returns a book; assigns it to the next member in the queue if applicable.
  - `displayBookCatalog()`: Prints details of all books in the catalog.
  - `displayMemberHistory(String)`: Shows borrowing history for a specific member.

#### 4. `Main` Class

Handles user input and commands for the library:
- Uses `Scanner` to parse and process commands like `ADD_BOOK`, `REGISTER_MEMBER`, `BORROW`, `RETURN`, `DISPLAY_CATALOG`, and `DISPLAY_MEMBER`.
- Processes each command by invoking appropriate methods in the `Library` class.

---

### Input and Output Requirements

1. **Input**:
   - Commands are provided in a structured format with specific arguments:
     - `ADD_BOOK ISBN "Title" "Author"`
     - `REGISTER_MEMBER ID "Name"`
     - `BORROW MemberID ISBN`
     - `RETURN MemberID ISBN`
     - `DISPLAY_CATALOG`
     - `DISPLAY_MEMBER MemberID`
   - The input is parsed in `Main` to perform appropriate actions in the `Library`.

2. **Output**:
   - Confirmation and error messages for each operation, such as:
     - Book addition confirmation.
     - Member registration confirmation.
     - Borrowing or reservation status.
     - Return confirmation and re-assignment if a reservation exists.
   - Catalog display with book availability statuses.
   - Member-specific borrowing history.

---

### Sample Use Case

**Example Commands and Expected Outputs**:

1. **Command**: `ADD_BOOK 12345 "The Great Gatsby" "F. Scott Fitzgerald"`
   - **Output**: `Book added: The Great Gatsby by F. Scott Fitzgerald`

2. **Command**: `REGISTER_MEMBER 001 "Alice"`
   - **Output**: `Member registered: Alice with ID: 001`

3. **Command**: `BORROW 001 12345`
   - **Output**: `Alice has borrowed: The Great Gatsby`

4. **Command**: `RETURN 001 12345`
   - **Output**: `The Great Gatsby has been returned by Alice`

5. **Command**: `DISPLAY_CATALOG`
   - **Output**:
     ```
     Library Catalog:
     12345: The Great Gatsby by F. Scott Fitzgerald - available
     ```

6. **Command**: `DISPLAY_MEMBER 001`
   - **Output**:
     ```
     Borrowing history for Alice:
     - The Great Gatsby by F. Scott Fitzgerald
     ```

---

### Conclusion

This system, developed across multiple classes, allows for streamlined library management with clear input commands and structured outputs. The design also facilitates adding future functionalities, such as extending borrowing limits or introducing late return fees. This documentation serves as a blueprint for understanding and testing the complete system.

INPUT :
```
12
ADD_BOOK 12345 "The Great Gatsby" "F. Scott Fitzgerald"
ADD_BOOK 67890 "1984" "George Orwell"
REGISTER_MEMBER 001 "Alice"
REGISTER_MEMBER 002 "Bob"
BORROW 001 12345
BORROW 002 12345
DISPLAY_CATALOG
DISPLAY_MEMBER 001
DISPLAY_MEMBER 002
RETURN 001 12345
DISPLAY_CATALOG
DISPLAY_MEMBER 002
```

OUTPUT :
```
Book added: The Great Gatsby by F. Scott Fitzgerald
Book added: 1984 by George Orwell
Member registered: Alice with ID: 001
Member registered: Bob with ID: 002
Alice has borrowed: The Great Gatsby
Book not available. Added to reservation queue.
Library Catalog:
12345: The Great Gatsby by F. Scott Fitzgerald - borrowed
67890: 1984 by George Orwell - available
Borrowing history for Alice:
- The Great Gatsby by F. Scott Fitzgerald
Borrowing history for Bob:
No books borrowed yet.
The Great Gatsby has been returned by Alice
The Great Gatsby has been assigned to next member in queue: Bob
Library Catalog:
12345: The Great Gatsby by F. Scott Fitzgerald - borrowed
67890: 1984 by George Orwell - available
Borrowing history for Bob:
- The Great Gatsby by F. Scott Fitzgerald
```