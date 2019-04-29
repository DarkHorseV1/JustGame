package inc.brocorp.interfaceCange;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;

public class ButtonScaling {

    public static void setButtonsScale(ObservableList<Node> buttonList) {
        for (Node x : buttonList) {
            if (x instanceof Button)
                setButtonScale((Button) x);
        }
    }

    public static void setButtonScale(Button btn) {
        btn.setOnMouseEntered(eh -> {
            btn.setScaleX(1.08);
            btn.setScaleY(1.08);
        });
        btn.setOnMouseExited(eh -> {
            btn.setScaleX(1);
            btn.setScaleY(1);
        });
    }
}
