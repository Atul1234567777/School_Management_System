✅ Data Validation 
1. Numeric Field Validation
Student ID, Age and Teacher ID are validated to ensure they are integers:

java
Copy code
int id = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter Student ID:"));
int age = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter Student Age:"));
If the input is not a number, it throws a NumberFormatException, which is caught in the try-catch block.

2. Empty Input Check
If JOptionPane.showInputDialog() returns null (cancel) or an empty string, the parsing will fail or the logic can be extended:

java
Copy code
String name = JOptionPane.showInputDialog(this, "Enter Student Name:");
if (name == null || name.trim().isEmpty()) {
    throw new IllegalArgumentException("Name cannot be empty.");
}
You can add this enhancement for full robustness.

3. Try-Catch Error Handling
Ensures the application does not crash on invalid input:

java
Copy code
} catch (Exception ex) {
    JOptionPane.showMessageDialog(this, "❌ Invalid input. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
}
This is a crucial part of both data validation and robustness.

4. Feedback to User
Users are informed about invalid data in a friendly pop-up:

java
Copy code
JOptionPane.showMessageDialog(this, "❌ Invalid input. Please try again.", "Error", JOptionPane.ERROR_MESSAGE)
