package dayThree.GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import java.lang.Math;

import java.util.Scanner;

public class labFourController {

    private static int numPixels = 0;
    private static double estimate = 0;
    private static int estimateWidth = 0;
    @FXML
    private Label display;
    @FXML
    private Slider slider;
    @FXML
    private Label results;
    @FXML
    private TextField txtField;
    @FXML
    private Label precisionResult;

    @FXML
    public void firstDisplay() {
        display.setText("");
        results.setText("");
        numPixels = 0;
        estimate = 0;
        estimateWidth = 0;

        int width = (int) slider.getValue();

        topAndBottom(width);

        middle(width);

        topAndBottom(width);

        addToLabel(results, +numPixels + " / " + width * width + " = " + (4 * numPixels) / (double) (width * width));
    }

    @FXML
    public void secondDisplay(){
        estimateCalc((int)slider.getValue());
    }


    public void topAndBottom(int width) {
        addToLabel(display, "+");
        for (int i = 0; i < width + 2; i++) {
            addToLabel(display, "-");
        }
        addToLabel(display, "+\n");
    }

    public double middle(int width) {
        int height = width - 1;
        for (int j = 0; j < width; j++) {
            addToLabel(display, "| ");
            for (int k = 0; k < width; k++) {
                if (Math.sqrt((height * height) + (k * k)) <= width - 0.5) {
                    numPixels++;
                    addToLabel(display, "*");
                } else {
                    addToLabel(display, " ");
                }
            }
            addToLabel(display, " |\n");
            height--;
        }
        return 4 * numPixels / (double) (width * width);
    }

    public static void estimateCalc(int width) {
        int height = width - 1;
        for (int j = 0; j < width; j++) {

            for (int k = 0; k < width; k++) {
                if (Math.sqrt((height * height) + (k * k)) <= width - 0.5) {
                    numPixels++;
                }
            }
            height--;
        }

        estimate = 4 * numPixels / (double) (width * width);
    }


    public static void addToLabel(Label label, String string) {
        String oldLabel = label.getText();
        label.setText(oldLabel + string);
    }

}
