package net.godlyMark.launchpadhotkeys;

import io.cassaundra.rocket.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.Getter;
import net.godlyMark.launchpadhotkeys.handlers.EffectHandler;
import net.godlyMark.launchpadhotkeys.handlers.KeyHandler;
import org.jetbrains.annotations.NotNull;

import java.awt.event.ActionEvent;

public class Main extends Application {

    @Getter private static Rocket rocket;

    @Override
    public void start(Stage stage) throws Exception {

        KeyHandler.init();
        Thread thread = new Thread(new EffectHandler());
        thread.start();

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("dashboard.fxml"));
        stage.setTitle("Launchpad Hotkey - Development");
        stage.setScene(new Scene(root, 972, 682));
        stage.setResizable(false);
        stage.show();

        rocket = new Rocket();
        rocket.beginMidiScan();

        rocket.addListener(new LaunchpadListener() {
            @Override
            public void onPadDown(@NotNull Pad pad) {
                rocket.setPad(pad, Color.GREEN);
            }

            @Override
            public void onPadUp(@NotNull Pad pad) {

            }

            @Override
            public void onButtonDown(@NotNull Button button) {

            }

            @Override
            public void onButtonUp(@NotNull Button button) {

            }
        });
    }

    public void pressButton(ActionEvent event){
        System.out.println(event.getActionCommand());
    }


    public static void main(String[] args) {
        Platform.runLater(() -> {
            try {
                new Main().start(new Stage());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }
}
