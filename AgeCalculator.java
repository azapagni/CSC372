import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class AgeCalculator extends JFrame {
    private JTextField dayField, monthField, yearField;
    private JLabel resultLabel;
    
    public AgeCalculator() {
        // Set up the JFrame
        super("Age Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        
        // Create main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // Create input panel for birth date fields
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 5, 10));
        
        // Add day input
        inputPanel.add(new JLabel("Day:"));
        dayField = new JTextField(5);
        inputPanel.add(dayField);
        
        // Add month input
        inputPanel.add(new JLabel("Month:"));
        monthField = new JTextField(5);
        inputPanel.add(monthField);
        
        // Add year input
        inputPanel.add(new JLabel("Year:"));
        yearField = new JTextField(5);
        inputPanel.add(yearField);
        
        // Create button panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton calculateButton = new JButton("Calculate Age");
        
        // Add ActionListener to the button
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateAge();
            }
        });
        
        buttonPanel.add(calculateButton);
        
        // Create result panel
        JPanel resultPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        resultLabel = new JLabel("Your age will appear here");
        resultLabel.setFont(new Font("Arial", Font.BOLD, 16));
        resultPanel.add(resultLabel);
        
        // Add all panels to main panel
        mainPanel.add(new JLabel("Enter your birth date:", JLabel.CENTER), BorderLayout.NORTH);
        mainPanel.add(inputPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        mainPanel.add(resultPanel, BorderLayout.SOUTH);
        
        // Add main panel to the frame
        add(mainPanel);
        
        // Display the window
        setVisible(true);
    }
    
    private void calculateAge() {
        try {
            // Get input values
            int day = Integer.parseInt(dayField.getText().trim());
            int month = Integer.parseInt(monthField.getText().trim());
            int year = Integer.parseInt(yearField.getText().trim());
            
            // Validate date components
            if (day < 1 || day > 31 || month < 1 || month > 12 || year < 1900) {
                resultLabel.setText("Please enter a valid date");
                return;
            }
            
            // Format date string to ensure it has leading zeros where needed
            String dateString = String.format("%04d-%02d-%02d", year, month, day);
            
            // Parse birth date
            LocalDate birthDate = LocalDate.parse(dateString, DateTimeFormatter.ISO_DATE);
            LocalDate currentDate = LocalDate.now();
            
            // Calculate age
            Period period = Period.between(birthDate, currentDate);
            
            // Check if birth date is in the future
            if (birthDate.isAfter(currentDate)) {
                resultLabel.setText("Birth date cannot be in the future");
                return;
            }
            
            // Display age
            resultLabel.setText("Your age is: " + period.getYears() + " years, " +
                              period.getMonths() + " months, " +
                              period.getDays() + " days");
        } catch (NumberFormatException e) {
            resultLabel.setText("Please enter valid numbers");
        } catch (DateTimeParseException e) {
            resultLabel.setText("Please enter a valid date");
        } catch (Exception e) {
            resultLabel.setText("Error: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        // Create the application on the Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AgeCalculator();
            }
        });
    }
}