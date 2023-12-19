package threads;

import javafx.concurrent.Task;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class Controller {

    @FXML
    private ListView<String> computationalTimesListView;

    @FXML
    private Button executeButton;

    @FXML
    private TextField numbersText;

    @FXML
    private TextField threadsText;

    @FXML
    void onExecuteHandler(MouseEvent event) throws InterruptedException {
        int numberOfNumbers = Integer.parseInt(numbersText.getText());
        int numberOfThreads = Integer.parseInt(threadsText.getText());

        long start = System.currentTimeMillis();
        int intervalLength = (int)numberOfNumbers/numberOfThreads;

        Thread[] threads = new Thread[numberOfThreads];
        int[] array = Utils.generateArray(numberOfNumbers);

        for (int i = 0; i < numberOfThreads; i++) {
            threads[i] = new Thread(new PrimeWorker(i * intervalLength,
                    (i+1) * intervalLength, array));
        }

        for (int i = 0; i < numberOfThreads; i++)
            threads[i].start();

        for (int i = 0; i < numberOfThreads; i++)
            threads[i].join();

        long end = System.currentTimeMillis();
        computationalTimesListView.getItems().add((end-start) + " milliseconds");



//        Task<Integer> task = new Task<Integer>() {
//            @Override
//            protected Integer call() throws Exception {
//
//                int[] array = Utils.generateArray(numberOfNumbers);
//                int numberOfPrimes = 0;
//                for (int i = 0; i < numberOfNumbers; i++)
//                    if (Utils.isPrime(array[i]))
//                        numberOfPrimes++;
//                return numberOfPrimes;
//            }
//        };
//
//        Thread t = new Thread(task);
//        t.start();
//
//        t.join();
//
//        long end = System.currentTimeMillis();
//
//        task.setOnSucceeded(ev -> {
//            computationalTimesListView.getItems().add((end-start) + " milliseconds");
//        });
    }
}
