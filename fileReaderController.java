/**
 * Andrew Pereira
 * August 12, 2020
 */

package JavaFXAPIFileReader;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;

public class fileReaderController {

    @FXML
    private Button btView;

    @FXML
    private TextField inputText;

    @FXML
    private TextArea outputText;

    @FXML
    private Button btClear;

    @FXML
    private Label errorOutput;

    @FXML
    private MenuItem btClose;

    @FXML
    void clearHandler(ActionEvent event) {
        outputText.setText("");

    }

    @FXML
    void viewHandler(ActionEvent event)  {

        try {
            readInput(); //calls method to read input file
            writeOutput(); //calls method to write file
            errorOutput.setText(""); //removes error message if there was an error shown
        }
        catch (Exception e){
            errorOutput.setText("File not found");
            System.out.println("Error: " + e);
            outputText.setText("");
        }

    }
    @FXML
    void openHandler(ActionEvent event){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose a file"); //user can choose file from C drive
        File file = fileChooser.showOpenDialog(new Stage());
        if (file != null){
            inputText.setText("" + file.getName());
            errorOutput.setText("");
        }
        else{
            errorOutput.setText("File not found");
        }
    }
    @FXML
    void closeHandler(ActionEvent event) {
        inputText.setText("");
        outputText.setText("");

    }

    /**
     *
     * @throws IOException
     */
    void readInput() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File(inputText.getText())));
        String line;
        while ((line = reader.readLine()) != null) {
            outputText.appendText(line + "\n");}
    } //method for reading input from txt file

    void writeOutput() throws IOException {


        File outFile = new File("NewExamFile.txt");
        FileOutputStream outFileStream = new FileOutputStream(outFile);
        PrintWriter outStream = new PrintWriter(outFileStream);

        outStream.write(String.valueOf(outputText.getText()));


        outStream.close();

    } //method for writing contents of selected file to new file. I chose a new filename.

}

