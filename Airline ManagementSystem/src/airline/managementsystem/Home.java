package airline.managementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener {

    public Home() {
        setLayout(null);

        // Get the screen dimensions
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();

        // Heading label with modern font and colors
        JLabel heading = new JLabel("AIR INDIA WELCOMES YOU", SwingConstants.CENTER);
        heading.setForeground(new Color(0x2D9CDB)); // Vibrant blue color
        heading.setFont(new Font("Verdana", Font.BOLD, 42)); // Modern font, larger size
        heading.setBounds(0, 30, width, 60);
        add(heading);

        // Background image and set bounds based on screen dimensions
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airline/managementsystem/icons/front.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, width, height);
        add(image);

        // Menu Bar with modern colors and font
        JMenuBar menubar = new JMenuBar();
        menubar.setBackground(new Color(0x333333)); // Dark background
        menubar.setForeground(Color.WHITE);
        menubar.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setJMenuBar(menubar);

        // "Details" menu with updated colors and fonts
        JMenu details = new JMenu("Details");
        details.setForeground(Color.WHITE);
        details.setFont(new Font("Arial", Font.PLAIN, 18));
        menubar.add(details);

        JMenuItem flightDetails = createMenuItem("Flight Details");
        details.add(flightDetails);

        JMenuItem customerDetails = createMenuItem("Add Customer Details");
        details.add(customerDetails);

        JMenuItem bookFlight = createMenuItem("Book Flight");
        details.add(bookFlight);

        JMenuItem journeyDetails = createMenuItem("Journey Details");
        details.add(journeyDetails);

        JMenuItem ticketCancellation = createMenuItem("Cancel Ticket");
        details.add(ticketCancellation);

        // "Ticket" menu with similar design
        JMenu ticket = new JMenu("Ticket");
        ticket.setForeground(Color.WHITE);
        ticket.setFont(new Font("Arial", Font.PLAIN, 18));
        menubar.add(ticket);

        JMenuItem boardingPass = createMenuItem("Boarding Pass");
        ticket.add(boardingPass);

        // Set frame properties for a full-screen view
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }

    // Helper method to create a styled menu item
    private JMenuItem createMenuItem(String title) {
        JMenuItem item = new JMenuItem(title);
        item.setFont(new Font("Arial", Font.PLAIN, 16));
        item.setBackground(Color.WHITE);
        item.setForeground(new Color(0x007ACC)); // Blue color for elegance
        item.setBorder(BorderFactory.createEmptyBorder(5, 20, 5, 20)); // Add padding
        item.addActionListener(this);

        // Adding hover effect
        item.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                item.setForeground(Color.WHITE);
                item.setBackground(new Color(0x007ACC)); // Switch to blue background on hover
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                item.setForeground(new Color(0x007ACC)); // Revert to original colors
                item.setBackground(Color.WHITE);
            }
        });

        return item;
    }

    public void actionPerformed(ActionEvent ae) {
        String text = ae.getActionCommand();

        // Perform actions based on selected menu items
        if (text.equals("Add Customer Details")) {
            new AddCustomer();
        } else if (text.equals("Flight Details")) {
            new FlightInfo();
        }
        else if (text.equals("Book Flight")) {
            new BookFlight();
        } 
        else if (text.equals("Journey Details")) {
            new JourneyDetails();
        } else if (text.equals("Cancel Ticket")) {
            new Cancel();
        }
        else if(text.equals("Boarding Pass")){
            new BoardingPass();
        }
    }

    public static void main(String[] args) {
        new Home();
    }
}
