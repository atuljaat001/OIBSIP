// account number 123456
// password 0000
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class atmm {
    private static double amount = 10000;
    private static JTextField active = new JTextField();

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(500, 600);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create main labels
        JLabel l1 = new JLabel("ATM Simulator");
        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setBounds(50, 50, 350, 50);
        l1.setFont(new Font("Arial", Font.BOLD, 24));
        l1.setForeground(Color.BLUE);
        JLabel l2 = new JLabel("Account Number");
        l2.setBounds(50, 100, 150, 50);
        l2.setFont(new Font("Arial", Font.BOLD, 15));
        JLabel l3 = new JLabel("Password");
        l3.setBounds(50, 150, 150, 50);
        l3.setFont(new Font("Arial", Font.BOLD, 15));
        frame.add(l1);
        frame.add(l2);
        frame.add(l3);

        JTextField tf = new JTextField(10);
        tf.setBounds(200, 110, 150, 25);
        frame.add(tf);
        active = tf;

        JTextField pass = new JTextField(10);
        pass.setBounds(200, 160, 150, 25);
        frame.add(pass);
        active = tf;

        JButton enter = new JButton("Enter");
        enter.setBounds(140, 450, 140, 70);
        frame.add(enter);

        // Action for "Enter" button to switch focus
        enter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (active == tf) {
                    pass.requestFocusInWindow(); // Set focus on the password field
                    active = pass;
                } else {
                    tf.requestFocusInWindow(); // Set focus back to the account number field
                    active = tf;
                }
            }
        });

        // Create number buttons
        JButton[] buttons = new JButton[10];
        for (int i = 0; i <= 9; i++) {
            buttons[i] = new JButton(String.valueOf(i));
            buttons[i].setBounds(70 + (i % 3) * 70, 240 + (i / 3) * 70, 70, 70);
            frame.add(buttons[i]);
            final int number = i;
            buttons[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String buttonText = buttons[number].getText();
                    String currentText = active.getText();
                    active.setText(currentText + buttonText);
                }
            });
        }

        JButton clear = new JButton("Clear");
        clear.setBounds(300, 379, 100, 63);
        frame.add(clear);

        // Action for "Clear" button
        clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tf.setText("");
                pass.setText("");
            }
        });

        JButton next = new JButton("Next");
        next.setBounds(300, 315, 100, 63);
        frame.add(next);

        next.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String account = tf.getText();
                String password = pass.getText();
                if (account.equals("123456") && password.equals("0000")) {
                    JFrame frame2 = new JFrame();
                    frame2.setSize(500, 600);
                    frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame2.setLayout(null);

                    // Labels for account information
                    JLabel l1 = new JLabel("Welcome");
                    l1.setHorizontalAlignment(JLabel.CENTER);
                    l1.setBounds(50, 10, 400, 60);
                    l1.setFont(new Font("Arial", Font.BOLD, 35));
                    l1.setForeground(Color.BLUE);
                    frame2.add(l1);

                    String accountt = tf.getText();
                    JLabel l2 = new JLabel("Account number: " + String.valueOf(accountt));
                    l2.setBounds(50, 100, 400, 60);
                    l2.setFont(new Font(null, Font.BOLD, 15));
                    String passwordd = pass.getText();
                    JLabel l3 = new JLabel("Password: " + String.valueOf(passwordd));
                    l3.setBounds(50, 150, 400, 60);
                    l3.setFont(new Font(null, Font.BOLD, 15));
                    frame2.add(l2);
                    frame2.add(l3);

                    // Buttons for different actions
                    JButton balance = new JButton("Check Balance");
                    balance.setBounds(30, 250, 200, 40);
                    frame2.add(balance);

                    JButton withdraw = new JButton("Withdraw Amount");
                    withdraw.setBounds(30, 300, 200, 40);
                    frame2.add(withdraw);

                    JButton deposit = new JButton("Deposit Money");
                    deposit.setBounds(30, 350, 200, 40);
                    frame2.add(deposit);

                    JButton info = new JButton("Account Info");
                    info.setBounds(30, 400, 200, 40);
                    frame2.add(info);

                    JButton back = new JButton("Back");
                    back.setBounds(250, 250, 200, 40);
                    frame2.add(back);

                    JButton history = new JButton("Transaction History");
                    history.setBounds(30, 450, 200, 40);
                    frame2.add(history);

                    // String to store transaction history
                    StringBuilder transactionHistory = new StringBuilder();

                    // Action for "Transaction History" button
                    history.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            // Display the transaction history in a dialog or a new window
                            JTextArea historyTextArea = new JTextArea(transactionHistory.toString());
                            historyTextArea.setEditable(false);
                            JScrollPane scrollPane = new JScrollPane(historyTextArea);

                            JFrame historyFrame = new JFrame();
                            historyFrame.setSize(400, 300);
                            historyFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            historyFrame.setLayout(new BorderLayout());
                            historyFrame.add(scrollPane, BorderLayout.CENTER);
                            historyFrame.setVisible(true);
                        }
                    });

                    // Action for "Transfer" button
                    JButton transfer = new JButton("Transfer");
                    transfer.setBounds(30, 500, 200, 40);
                    frame2.add(transfer);

                    transfer.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            JFrame frame4 = new JFrame();
                            frame4.setSize(500, 500);
                            frame2.dispose();
                            frame.dispose();
                            frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            frame4.setLayout(null);

                            JLabel l1 = new JLabel("Account Number: ");
                            l1.setBounds(50, 50, 200, 50);
                            l1.setFont(new Font(null, Font.BOLD, 15));
                            JLabel l2 = new JLabel("Money: ");
                            l2.setBounds(50, 100, 200, 50);
                            l2.setFont(new Font(null, Font.BOLD, 15));
                            frame4.add(l1);
                            frame4.add(l2);

                            JTextField tf1 = new JTextField(10);
                            tf1.setBounds(200, 70, 150, 25);
                            frame4.add(tf1);
                            JTextField tf2 = new JTextField(10);
                            tf2.setBounds(200, 120, 150, 25);
                            frame4.add(tf2);

                            JButton enter = new JButton("Enter");
                            enter.setBounds(100, 170, 150, 40);
                            frame4.add(enter);

                            enter.addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    String get = tf2.getText();
                                    double money = Double.parseDouble(get);
                                    if (money > amount || money < 0) {
                                        JOptionPane.showMessageDialog(frame4, "Insufficient balance", "Error", JOptionPane.WARNING_MESSAGE);
                                    } else {
                                        amount -= money;
                                        transactionHistory.append("Transfer: " + money + "\n");
                                        JOptionPane.showMessageDialog(frame4, "The money has been transferred\nBalance " + amount);
                                    }

                                   
                                }
                            });

                            JButton back = new JButton("Back");
                            back.setBounds(100, 250, 150, 40);
                            frame4.add(back);

                            back.addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    frame4.dispose();
                                    frame2.setVisible(true);
                                }
                            });

                            frame4.setVisible(true);
                        }
                    });

                    // Action for "Check Balance" button
                    balance.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            JOptionPane.showMessageDialog(frame2, "Your current balance is: " + amount);
                        }
                    });

                    // Action for "Back" button
                    back.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            frame2.dispose();
                            tf.setText("");
                            pass.setText("");
                            frame.setVisible(true);
                        }
                    });

                    // Action for "Deposit Money" button
                    deposit.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            String a = JOptionPane.showInputDialog(frame2, "Enter amount: ");
                            double sum = Double.parseDouble(a);
                            if (sum < 0) {
                                JOptionPane.showMessageDialog(frame2, "Invalid amount", "Error", JOptionPane.WARNING_MESSAGE);
                            } else {
                                amount += sum;
                                transactionHistory.append("Deposit: " + sum + "\n");
                            }

                            JOptionPane.showMessageDialog(frame2, "Added\nBalance " + amount);
                        }
                    });

                    // Action for "Account Info" button
                    info.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            frame.dispose();
                            frame2.dispose();
                            JFrame frame3 = new JFrame();
                            frame3.setSize(500, 600);
                            frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            frame3.setLayout(null);

                            // Example account information (replace with actual data)
                            String name = "Atul Chauhdary";
                            JLabel l1 = new JLabel("Name: " + name);
                            l1.setFont(new Font(null, Font.BOLD, 15));
                            l1.setBounds(20, 50, 400, 60);
                            frame3.add(l1);

                            String number = "952868";
                            JLabel l2 = new JLabel("Phone No. " + number);
                            l2.setFont(new Font(null, Font.BOLD, 15));
                            l2.setBounds(20, 100, 400, 60);
                            frame3.add(l2);

                            double accountBalance = 10000.00; // Replace with the actual account balance
                            JLabel l3 = new JLabel("Account Balance: " + accountBalance);
                            l3.setFont(new Font(null, Font.BOLD, 15));
                            l3.setBounds(20, 150, 400, 60);
                            frame3.add(l3);

                            String address = "Meerut"; // Replace with the actual address
                            JLabel l4 = new JLabel("Address: " + address);
                            l4.setFont(new Font(null, Font.BOLD, 15));
                            l4.setBounds(20, 200, 400, 60);
                            frame3.add(l4);

                            // Load and display an image (adjust the path and dimensions)
                            ImageIcon photo = new ImageIcon("D:/Image/atul.jpg");
                            Image img = photo.getImage();
                            Image resizedImg = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                            ImageIcon resizedPhoto = new ImageIcon(resizedImg);
                            JLabel l5 = new JLabel(resizedPhoto);
                            l5.setBounds(300, 30, 100, 100);
                            frame3.add(l5);

                            // Action for "Back" button in the account info screen
                            JButton back = new JButton("Back");
                            back.setBounds(50, 300, 200, 40);
                            frame3.add(back);

                            back.addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    frame3.dispose();
                                    frame2.setVisible(true);
                                }
                            });

                            frame3.setVisible(true);
                        }
                    });

                    // Action for "Withdraw Amount" button
                    withdraw.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            String a = JOptionPane.showInputDialog(frame2, "Enter amount: ");
                            double sum = Double.parseDouble(a);
                            if (sum > amount&& sum<0) {
                                JOptionPane.showMessageDialog(frame2, "Insufficient balance", "Error", JOptionPane.WARNING_MESSAGE);
                            } else {
                                amount -= sum;
                                JOptionPane.showMessageDialog(frame2, "Deducted\nBalance " + amount);
                            }

                        }
                    });

                    frame2.setVisible(true);
                    frame.dispose();
                } else {
                    JOptionPane.showMessageDialog(frame, "Wrong password or account number", "Error", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        frame.setVisible(true);
    }
}
