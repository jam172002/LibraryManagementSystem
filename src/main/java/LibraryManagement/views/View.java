package LibraryManagement.views;

import LibraryManagement.controllers.Controller;
import LibraryManagement.models.Book;
import LibraryManagement.models.LibraryItem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame {
    private JTextField titleField, authorField, genreField, yearField;
    private JButton previousButton, nextButton, addButton, updateButton, deleteButton, quitButton, saveBookButton, loadBookButton;

    private Controller controller;

    public View(Controller controller) {

        this.controller = controller;

        setTitle("Library Management System");
        setSize(950, 350);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel dataPanel = new JPanel(new GridLayout(4, 2, 0, 10));
        titleField = new JTextField();
        authorField = new JTextField();
        genreField = new JTextField();
        yearField = new JTextField();

        dataPanel.add(createLabel("Book Title:"));
        dataPanel.add(titleField);
        dataPanel.add(createLabel("Author:"));
        dataPanel.add(authorField);
        dataPanel.add(createLabel("Genre:"));
        dataPanel.add(genreField);
        dataPanel.add(createLabel("Year:"));
        dataPanel.add(yearField);


        JPanel buttonPanel = new JPanel(new GridLayout(1, 5, 10, 10));
        previousButton = new JButton("Previous");
        previousButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayItem(controller.getPreviousItem());
            }
        });

        nextButton = new JButton("Next");
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayItem(controller.getNextItem());
            }
        });


        addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                boolean dataValid = checkDataValid();

                if (dataValid) {
                    boolean isAdded = controller.addBook(titleField.getText(), authorField.getText(), genreField.getText(), Integer.parseInt(yearField.getText()));
                    if (isAdded) {
                        JOptionPane.showMessageDialog(null, "Book added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Book add failed", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        updateButton = new JButton("Update");
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                boolean dataValid = checkDataValid();
                if (dataValid) {
                    boolean isUpdated = controller.updateBook(titleField.getText(), authorField.getText(), genreField.getText(), Integer.parseInt(yearField.getText()));
                    if (isUpdated) {
                        JOptionPane.showMessageDialog(null, "Book updated successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Book update failed", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });


        deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                boolean dataValid = checkDataValid();
                if (dataValid) {
                    boolean isDeleted = controller.deleteBook(titleField.getText(), authorField.getText(), genreField.getText(), Integer.parseInt(yearField.getText()));
                    if (isDeleted) {
                        JOptionPane.showMessageDialog(null, "Book deleted successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                        if (controller.hasNextListItem()) {
                            displayItem(controller.getNextItem());
                        } else {
                            displayItem(controller.getPreviousItem());
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Book delete failed", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });


        quitButton = new JButton("Quit");
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        saveBookButton = new JButton("Save Book");
        saveBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Extracting values from the text fields
                    String title = titleField.getText();
                    String author = authorField.getText();
                    String genre = genreField.getText();
                    int publicationYear = Integer.parseInt(yearField.getText()); // Converting year from String to int

                    // Creating a new Book object using the constructor
                    Book book = new Book(title, author, genre, publicationYear);

                    // Assuming you have a method in your Controller to save a Book object
                    // Replace 'saveBookData' with the actual method in your controller
                    controller.saveBookData(book); // Adjust this line to match your controller's method
                    JOptionPane.showMessageDialog(null, "Book saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Year must be a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error saving book: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        loadBookButton = new JButton("Load Book");
        loadBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Book book = controller.loadBookData();
                if (book != null) {
                    displayItem(book);
                    JOptionPane.showMessageDialog(null, "Book loaded successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to load book.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });


        buttonPanel.add(previousButton);
        buttonPanel.add(nextButton);
        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(quitButton);
        buttonPanel.add(saveBookButton);
        buttonPanel.add(loadBookButton);

        dataPanel.setBackground(Color.PINK);
        mainPanel.setBackground(Color.PINK);
        buttonPanel.setBackground(Color.PINK);

        mainPanel.add(dataPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(mainPanel);


    }

    private boolean checkDataValid() {
        String title = titleField.getText();
        String author = authorField.getText();
        String genre = genreField.getText();
        String yearStr = yearField.getText();


        if (title.isEmpty() || author.isEmpty() || genre.isEmpty() || yearStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }


        try {
            int year = Integer.parseInt(yearStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Year must be a number.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }


    public void displayItem(LibraryItem item) {

        if (item instanceof Book book) {
            getTitleField().setText(book.getTitle());
            getAuthorField().setText(book.getAuthor());
            getGenreField().setText(book.getGenre());
            getYearField().setText(String.valueOf(book.getPublicationYear()));
        } else if (controller.isBookListEmpty()) {
            getTitleField().setText("");
            getAuthorField().setText("");
            getGenreField().setText("");
            getYearField().setText("");
        }
    }

    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        return label;
    }

    public JTextField getTitleField() {
        return titleField;
    }

    public JTextField getAuthorField() {
        return authorField;
    }

    public JTextField getGenreField() {
        return genreField;
    }

    public JTextField getYearField() {
        return yearField;
    }


}

