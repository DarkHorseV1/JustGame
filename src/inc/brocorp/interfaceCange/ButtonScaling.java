package inc.brocorp.interfaceCange;

import javafx.animation.ScaleTransition;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.util.Duration;

public class ButtonScaling {

    public static void setButtonsScale(ObservableList<Node> buttonList) {
        for (Node x : buttonList) {
            if (x instanceof Button)
                setButtonScale((Button) x);
        }
    }

    public static void setButtonScale(Button btn) {
        btn.setOnMouseEntered(event -> {
            ScaleTransition st = new ScaleTransition(Duration.seconds(0.2),btn);
            st.setToX(1.15);
            st.setToY(1.15);
            st.play();
        });
        btn.setOnMouseExited(event -> {
            ScaleTransition st = new ScaleTransition(Duration.seconds(0.2), btn);
            st.setFromX(1.15);
            st.setFromY(1.15);
            st.setToX(1);
            st.setToY(1);
            st.play();
        });
    }
}
