import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AgeVerificationFrame extends JFrame {
    private JTextField ageTextField;
    private JButton submitButton;

    public AgeVerificationFrame() {
        super("Age Verification");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null); // Center the frame

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel ageLabel = new JLabel("Enter your age:");
        ageTextField = new JTextField(10);
        submitButton = new JButton("Submit");

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verifyAge();
            }
        });

        panel.add(ageLabel);
        panel.add(ageTextField);
        panel.add(submitButton);

        add(panel);
    }

    private void verifyAge() {
        try {
            int age = Integer.parseInt(ageTextField.getText());
            if (age < 18) {
                JOptionPane.showMessageDialog(this, "Sorry, this action is invalid for users aged 17 or below.",
                        "Invalid Action", JOptionPane.ERROR_MESSAGE);
            } else {
                NextFrame nextFrame = new NextFrame();
                nextFrame.setVisible(true);
                dispose(); // Close the current frame
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid age.", "Invalid Age", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                AgeVerificationFrame frame = new AgeVerificationFrame();
                frame.setVisible(true);
            }
        });
    }
}

class NextFrame extends JFrame {
    public NextFrame() {
        super("Next Frame");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null); // Center the frame

        JLabel label = new JLabel("Congratulations! You are eligible to proceed to the next frame.");
        add(label);
    }
}
