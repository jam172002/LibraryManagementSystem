package LibraryManagement;

import LibraryManagement.controllers.Controller;
import LibraryManagement.models.Book;
import LibraryManagement.models.Library;
import LibraryManagement.models.LibraryItem;
import LibraryManagement.views.View;

public class Main {
    public static void main(String[] args) {


        Controller controller = new Controller();
        View view = new View(controller);
        view.setVisible(true);
    }
}
