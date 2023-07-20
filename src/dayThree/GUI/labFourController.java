package dayThree.GUI;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.lang.Math;

public class labFourController {

    private static long numPixels = 0;
    private static double estimate = 0;
    private static int estimateWidth = 0;
    private static double lastError = 0;
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
    private Label progress;

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
    public void secondDisplay() {
        double error = Double.parseDouble(txtField.getText());
        precisionResult.setText("");
            if (error > lastError){
                estimateWidth = 0;
            }

        estimate = 0;
        estimateWidth = 0;

        while (Math.abs(estimate - Math.PI) > error) {
            estimateWidth++;
            numPixels = 0;
            estimate = estimateCalc(estimateWidth);
            progress.setText("Estimate: " + estimate);
        }

        lastError = error;
        addToLabel(precisionResult, "An estimate of " + estimate + " was achieved with a width of " + estimateWidth + ".");
    }


    public void topAndBottom(int width) {
        addToLabel(display, "+");
        for (int i = 0; i < width + 2; i++) {
            addToLabel(display, "-");
        }
        addToLabel(display, "+\n");
    }

    public void middle(int width) {
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
    }

    public static double estimateCalc(int width) {
        int height = width - 1;
        for (int j = 0; j < width; j++) {

            for (int k = 0; k < width; k++) {
                if (Math.sqrt((height * height) + (k * k)) <= width - 0.5) {
                    numPixels++;
                }
            }
            height--;
        }

        return 4 * numPixels / (double) (width * width);
    }


    public static void addToLabel(Label label, String string) {
        String oldLabel = label.getText();
        label.setText(oldLabel + string);
    }

}
