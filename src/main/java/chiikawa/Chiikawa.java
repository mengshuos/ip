package chiikawa;

import chiikawa.command.*;

/**
 * The Chiikawa class represents the main entry point of the program.
 * It takes care of initialising all other related classes and acts as the entry point
 * where the main program loop is ran.
 */
public class Chiikawa {
    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    /**
     * Constructor for a new Chiikawa instance.
     * @param filePath path to the storage file which contains all the saved tasks
     */
    public Chiikawa(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.loadFile());
        } catch (ChiikawaException e) {
            ui.showLoadingError();
            tasks = new TaskList();
        }
    }

    /**
     * Starts the program by showing the welcome message before waiting for users' input.
     * Upon receiving users' inputs, their input will be parsed and a new command will be returned,
     * which will then be executed.
     */
    public void run() {
        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                ui.showLine();
                Command c = Parser.parse(fullCommand);
                c.execute(tasks, ui, storage);
                isExit = c.isExit();
            } catch (ChiikawaException e) {
                ui.showError(e.getMessage());
            } finally {
                ui.showLine();
            }
        }
    }

    /**
     * The main entry point of the program.
     * @param args
     */
    public static void main(String[] args) {
        new Chiikawa("data/list.txt").run();
    }
}
