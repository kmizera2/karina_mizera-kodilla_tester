public class FirstClass {
    public static void main(String[] args) {         // [2]
        Notebook notebook = new Notebook(600, 1000, 1999);
        Notebook heavyNotebook = new Notebook(2000, 1500, 2020);
        Notebook oldNotebook = new Notebook(1600, 0, 2024);

        displayAllNotebookParameters(notebook);
        displayAllNotebookParameters(heavyNotebook);
        displayAllNotebookParameters(oldNotebook);
    }

    private static void displayAllNotebookParameters(Notebook notebook) {
        System.out.println(notebook.weight + " " + notebook.price);
        notebook.checkPrice();
        notebook.checkWeight();
        notebook.checkYearAndPrice();
    }
}
