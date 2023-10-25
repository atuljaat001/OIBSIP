import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class guessinggame {
    // Declare variables and initialize them
    static int count = 0;
    static int player1Count = 0;
    static int player2Count = 0;
    static Random rand = new Random();
    static int generate = rand.nextInt(100);
    static int computerNumber = rand.nextInt(100);

    public static void main(String[] args) {
        // Create the main frame for the game
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(500, 600);

        // Load and display the main image
        ImageIcon image = new ImageIcon("D:/download.png");
        Image img = image.getImage();
        Image resize = img.getScaledInstance(500, 300, Image.SCALE_SMOOTH);
        ImageIcon resizeImage = new ImageIcon(resize);
        JLabel mainImageLabel = new JLabel(resizeImage);
        mainImageLabel.setBounds(10, 10, 500, 300);
        frame.add(mainImageLabel);

        // Create buttons for different game modes
        JButton playWithFriendButton = new JButton("Play with friend");
        playWithFriendButton.setBounds(50, 350, 150, 30);
        frame.add(playWithFriendButton);
        JButton playWithComputerButton = new JButton("Play with Computer");
        playWithComputerButton.setBounds(250, 350, 150, 30);
        frame.add(playWithComputerButton);
        JButton tipsButton = new JButton("Tips");
        tipsButton.setBounds(150, 400, 150, 30);
        frame.add(tipsButton);

        // Action for the "Play with Computer" button
        playWithComputerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Close the main frame and create a new frame for playing with the computer
                frame.dispose();
                JFrame frame3 = new JFrame();
                frame3.setSize(500, 600);
                frame3.setLayout(null);

                // Load the image for playing with the computer
                ImageIcon img = new ImageIcon("D:/images (1).jpeg");
                Image image = img.getImage();
                Image resizeImage = image.getScaledInstance(500, 200, Image.SCALE_SMOOTH);
                ImageIcon resizedImage = new ImageIcon(resizeImage);
                JLabel computerPlayImageLabel = new JLabel(resizedImage);
                computerPlayImageLabel.setBounds(10, 10, 500, 200);
                frame3.add(computerPlayImageLabel);

                // Create input elements for user guesses
                JLabel guessLabel = new JLabel("Guess the number");
                guessLabel.setFont(new Font(null, Font.BOLD, 15));
                guessLabel.setBounds(10, 220, 150, 40);
                frame3.add(guessLabel);
                JTextField guessTextField = new JTextField(10);
                guessTextField.setBounds(170, 230, 100, 30);
                frame3.add(guessTextField);

                // Create buttons for actions
                JButton backButton = new JButton("Back");
                backButton.setBounds(170, 380, 100, 30);
                frame3.add(backButton);

                backButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                        frame3.dispose();
                        frame.setVisible(true);
                    }
                });

                JButton submitButton = new JButton("Submit");
                submitButton.setBounds(170, 280, 100, 30);
                frame3.add(submitButton);

                // Action for the "Submit" button
                submitButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String userGuess = guessTextField.getText();
                        int userNumber = Integer.parseInt(userGuess);

                        if (userNumber > computerNumber) {
                            JOptionPane.showMessageDialog(frame3, "Enter a smaller number");
                            count++;
                        } else if (userNumber < computerNumber) {
                            JOptionPane.showMessageDialog(frame3, "Enter a larger number");
                            count++;
                        } else {
                            JOptionPane.showMessageDialog(frame3, "You guessed correctly\nYou took " + count + " times to guess.");
                        }
                    }
                });

                JButton restartButton = new JButton("Restart");
                restartButton.setBounds(170, 330, 100, 30);
                frame3.add(restartButton);

                // Action for the "Restart" button
                restartButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        guessTextField.setText("");
                        count = 0;
                        computerNumber = rand.nextInt(100);
                    }
                });

                frame3.setVisible(true);
            }
        });

        // Action for the "Tips" button
        tipsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Show game tips
                JOptionPane.showMessageDialog(frame, "One player thinks of a number, while others take turns making guesses.\n"
                        + "Players receive hints or clues to refine their guesses, with the goal of correctly identifying the answer within a limited number of tries.", "Tips", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Action for the "Play with friend" button
        playWithFriendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Close the main frame and create a new frame for playing with a friend
                frame.dispose();
                JFrame frame2 = new JFrame();
                frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame2.setSize(500, 600);
                frame2.setLayout(null);

                // Load the image for playing with a friend
                ImageIcon img = new ImageIcon("D:/download.jpeg");
                Image image = img.getImage();
                Image resizeImage = image.getScaledInstance(500, 300, Image.SCALE_SMOOTH);
                ImageIcon imageResize = new ImageIcon(resizeImage);
                JLabel friendPlayImageLabel = new JLabel(imageResize);
                friendPlayImageLabel.setBounds(10, 10, 500, 300);
                frame2.add(friendPlayImageLabel);

                JLabel player1Label = new JLabel("Player 1 Guess The Number: ");
                player1Label.setFont(new Font(null, Font.BOLD, 15));
                player1Label.setBounds(50, 320, 300, 40);
                frame2.add(player1Label);

                JLabel player2Label = new JLabel("Player 2 Guess The Number ");
                player2Label.setFont(new Font(null, Font.BOLD, 15));
                player2Label.setBounds(50, 360, 300, 40);
                frame2.add(player2Label);

                JTextField player1TextField = new JTextField(10);
                player1TextField.setBounds(300, 330, 80, 20);
                frame2.add(player1TextField);
                JTextField player2TextField = new JTextField(10);
                player2TextField.setBounds(300, 370, 80, 20);
                frame2.add(player2TextField);

                JButton submitButton = new JButton("Submit");
                submitButton.setBounds(50, 430, 100, 30);
                frame2.add(submitButton);

                // Action for the "Submit" button
                submitButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String player1Guess = player1TextField.getText();
                        int player1Number = Integer.parseInt(player1Guess);
                        String player2Guess = player2TextField.getText();
                        int player2Number = Integer.parseInt(player2Guess);

                        if (player1Number == generate && player2Number == generate) {
                            JOptionPane.showMessageDialog(frame2, "It's a tie!");
                        } else if (player1Number == generate) {
                            JOptionPane.showMessageDialog(frame2, "Player 1 wins! They guessed the correct number first.\nGuess at " + player1Count + " times");
                        } else if (player2Number == generate) {
                            JOptionPane.showMessageDialog(frame2, "Player 2 wins! They guessed the correct number first.\nGuess at " + player2Count + " times");
                        } else {
                            if (player1Number > generate) {
                                JOptionPane.showMessageDialog(frame2, "Player 1 Guess Smaller Number");
                                player1Count++;
                            } else if (player1Number < generate) {
                                JOptionPane.showMessageDialog(frame2, "Player 1 Guess Larger Number");
                                player1Count++;
                            }

                            if (player2Number > generate) {
                                JOptionPane.showMessageDialog(frame2, "Player 2 Guess Smaller Number");
                                player2Count++;
                            } else if (player2Number < generate) {
                                JOptionPane.showMessageDialog(frame2, "Player 2 Guess Larger Number");
                                player2Count++;
                            }
                        }
                    }
                });

                JButton restartButton = new JButton("Restart");
                restartButton.setBounds(200, 430, 100, 30);
                frame2.add(restartButton);

                // Action for the "Restart" button
                restartButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        player1TextField.setText("");
                        player2TextField.setText("");
                        generate = rand.nextInt(100);
                        player1Count = 0;
                        player2Count = 0;
                    }
                });

                JButton backButton = new JButton("Back");
                backButton.setBounds(350, 430, 100, 30);
                frame2.add(backButton);

                // Action for the "Back" button
                backButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        frame2.dispose();
                        frame.setVisible(true);
                    }
                });

                frame2.setVisible(true);
            }
        });

        frame.setVisible(true);
    }
}
