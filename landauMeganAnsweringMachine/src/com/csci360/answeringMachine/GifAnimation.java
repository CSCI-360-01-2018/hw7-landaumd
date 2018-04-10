/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csci360.answeringMachine;

import java.util.ArrayList;
import java.util.List;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TimelineBuilder;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 *
 * @author MeganLandau
 */
public class GifAnimation {
    Group am;
    
    String imagePath = "/com/csci360/answeringMachine/images/";
    final Image am_1 =  new Image(GifAnimation.class.getResource(imagePath + "answering_machine_00.png").toString());
    final Image am_2 =  new Image(GifAnimation.class.getResource(imagePath + "answering_machine_01.png").toString());
    final Image am_3 =  new Image(GifAnimation.class.getResource(imagePath + "answering_machine_02.png").toString());
    final Image am_4 =  new Image(GifAnimation.class.getResource(imagePath + "answering_machine_03.png").toString());
    final Image am_5 =  new Image(GifAnimation.class.getResource(imagePath + "answering_machine_04.png").toString());
    final Image am_6 =  new Image(GifAnimation.class.getResource(imagePath + "answering_machine_05.png").toString());
    final Image am_7 =  new Image(GifAnimation.class.getResource(imagePath + "answering_machine_06.png").toString());
    final Image am_8 =  new Image(GifAnimation.class.getResource(imagePath + "answering_machine_07.png").toString());
    final Image am_9 =  new Image(GifAnimation.class.getResource(imagePath + "answering_machine_08.png").toString());
    final Image am_10 =  new Image(GifAnimation.class.getResource(imagePath + "answering_machine_09.png").toString());
    final Image am_11 =  new Image(GifAnimation.class.getResource(imagePath + "answering_machine_11.png").toString());
    final Image am_12 =  new Image(GifAnimation.class.getResource(imagePath + "answering_machine_12.png").toString());
    final Image am_13 =  new Image(GifAnimation.class.getResource(imagePath + "answering_machine_13.png").toString());
    final Image am_14 =  new Image(GifAnimation.class.getResource(imagePath + "answering_machine_14.png").toString());
    final Image am_15 =  new Image(GifAnimation.class.getResource(imagePath + "answering_machine_15.png").toString());
    final Image am_16 =  new Image(GifAnimation.class.getResource(imagePath + "answering_machine_16.png").toString());
    final Image am_17 =  new Image(GifAnimation.class.getResource(imagePath + "answering_machine_17.png").toString());
    final Image am_18 =  new Image(GifAnimation.class.getResource(imagePath + "answering_machine_18.png").toString());    
    final Image am_19 =  new Image(GifAnimation.class.getResource(imagePath + "answering_machine_19.png").toString());
    final Image am_20 =  new Image(GifAnimation.class.getResource(imagePath + "answering_machine_21.png").toString());
    final Image am_21 =  new Image(GifAnimation.class.getResource(imagePath + "answering_machine_22.png").toString());
    final Image am_22 =  new Image(GifAnimation.class.getResource(imagePath + "answering_machine_23.png").toString());
    final Image am_23 =  new Image(GifAnimation.class.getResource(imagePath + "answering_machine_24.png").toString());
    final Image am_24 =  new Image(GifAnimation.class.getResource(imagePath + "answering_machine_25.png").toString());
    final Image am_25 =  new Image(GifAnimation.class.getResource(imagePath + "answering_machine_26.png").toString());
    final Image am_26 =  new Image(GifAnimation.class.getResource(imagePath + "answering_machine_27.png").toString());
    final Image am_27 =  new Image(GifAnimation.class.getResource(imagePath + "answering_machine_28.png").toString());
    final Image am_28 =  new Image(GifAnimation.class.getResource(imagePath + "answering_machine_29.png").toString());
    final Image am_29 =  new Image(GifAnimation.class.getResource(imagePath + "answering_machine_30.png").toString());
    final Image am_30 =  new Image(GifAnimation.class.getResource(imagePath + "answering_machine_31.png").toString());
    final Image am_31 =  new Image(GifAnimation.class.getResource(imagePath + "answering_machine_32.png").toString());
    final Image am_32 =  new Image(GifAnimation.class.getResource(imagePath + "answering_machine_33.png").toString());
    final Image am_33 =  new Image(GifAnimation.class.getResource(imagePath + "answering_machine_34.png").toString());
    final Image am_34 =  new Image(GifAnimation.class.getResource(imagePath + "answering_machine_35.png").toString());
    final Image am_35 =  new Image(GifAnimation.class.getResource(imagePath + "answering_machine_36.png").toString());
    final Image am_36 =  new Image(GifAnimation.class.getResource(imagePath + "answering_machine_37.png").toString());
    final Image am_37 =  new Image(GifAnimation.class.getResource(imagePath + "answering_machine_38.png").toString());
    final Image am_38 =  new Image(GifAnimation.class.getResource(imagePath + "answering_machine_39.png").toString());
    final Image am_39 =  new Image(GifAnimation.class.getResource(imagePath + "answering_machine_40.png").toString());
    final Image am_40 =  new Image(GifAnimation.class.getResource(imagePath + "answering_machine_41.png").toString());
    final Image am_41 =  new Image(GifAnimation.class.getResource(imagePath + "answering_machine_42.png").toString());
    final Image am_42 =  new Image(GifAnimation.class.getResource(imagePath + "answering_machine_43.png").toString());
    final Image am_43 =  new Image(GifAnimation.class.getResource(imagePath + "answering_machine_44.png").toString());

    final ImageView am1 = new ImageView(am_1);
    final ImageView am2 = new ImageView(am_2);
    final ImageView am3 = new ImageView(am_3);
    final ImageView am4 = new ImageView(am_4);
    final ImageView am5 = new ImageView(am_5);
    final ImageView am6 = new ImageView(am_6);
    final ImageView am7 = new ImageView(am_7);
    final ImageView am8 = new ImageView(am_8);
    final ImageView am9 = new ImageView(am_9);
    final ImageView am10 = new ImageView(am_10);
    final ImageView am11 = new ImageView(am_11);
    final ImageView am12 = new ImageView(am_12);
    final ImageView am13 = new ImageView(am_13);
    final ImageView am14 = new ImageView(am_14);
    final ImageView am15 = new ImageView(am_15);
    final ImageView am16 = new ImageView(am_16);
    final ImageView am17 = new ImageView(am_17);
    final ImageView am18 = new ImageView(am_18);
    final ImageView am19 = new ImageView(am_19);
    final ImageView am20 = new ImageView(am_20);
    final ImageView am21 = new ImageView(am_21);
    final ImageView am22 = new ImageView(am_22);
    final ImageView am23 = new ImageView(am_23);
    final ImageView am24 = new ImageView(am_24);
    final ImageView am25 = new ImageView(am_25);
    final ImageView am26 = new ImageView(am_26);
    final ImageView am27 = new ImageView(am_27);
    final ImageView am28 = new ImageView(am_28);
    final ImageView am29 = new ImageView(am_29);
    final ImageView am30 = new ImageView(am_30);
    final ImageView am31 = new ImageView(am_31);
    final ImageView am32 = new ImageView(am_32);
    final ImageView am33 = new ImageView(am_33);
    final ImageView am34 = new ImageView(am_34);
    final ImageView am35 = new ImageView(am_35);
    final ImageView am36 = new ImageView(am_36);
    final ImageView am37 = new ImageView(am_37);
    final ImageView am38 = new ImageView(am_38);
    final ImageView am39 = new ImageView(am_39);
    final ImageView am40 = new ImageView(am_40);
    final ImageView am41 = new ImageView(am_41);
    final ImageView am42 = new ImageView(am_42);
    final ImageView am43 = new ImageView(am_43);
    
    Scene am_scene;
    Timeline t;
    
public GifAnimation(){
    List<Image> images = new ArrayList<Image>();
    images.add(am_1);
    images.add(am_2);
    images.add(am_3);
    images.add(am_4);
    images.add(am_5);
    images.add(am_6);
    images.add(am_7);
    images.add(am_8);
    images.add(am_9);
    images.add(am_10);
    images.add(am_11);
    images.add(am_12);
    images.add(am_13);
    images.add(am_14);
    images.add(am_15);
    images.add(am_16);
    images.add(am_17);
    images.add(am_18);
    images.add(am_19);
    images.add(am_20);
    images.add(am_21);
    images.add(am_22);
    images.add(am_23);
    images.add(am_24);
    images.add(am_25);
    images.add(am_26);
    images.add(am_27);
    images.add(am_28);
    images.add(am_29);
    images.add(am_30);
    images.add(am_31);
    images.add(am_32);
    images.add(am_33);
    images.add(am_34);
    images.add(am_35);
    images.add(am_36);
    images.add(am_37);
    images.add(am_38);
    images.add(am_39);
    images.add(am_40);
    images.add(am_41);
    images.add(am_42);
    images.add(am_43);

    List<ImageView> imageViews = new ArrayList<ImageView>();
    imageViews.add(am1);
    imageViews.add(am2);
    imageViews.add(am3);
    imageViews.add(am4);
    imageViews.add(am5);
    imageViews.add(am6);
    imageViews.add(am7);
    imageViews.add(am8);
    imageViews.add(am9);
    imageViews.add(am10);
    imageViews.add(am11);
    imageViews.add(am12);
    imageViews.add(am13);
    imageViews.add(am14);
    imageViews.add(am15);
    imageViews.add(am16);
    imageViews.add(am17);
    imageViews.add(am18);
    imageViews.add(am19);
    imageViews.add(am20);
    imageViews.add(am21);
    imageViews.add(am22);
    imageViews.add(am23);
    imageViews.add(am24);
    imageViews.add(am25);
    imageViews.add(am26);
    imageViews.add(am27);
    imageViews.add(am28);
    imageViews.add(am29);
    imageViews.add(am30);
    imageViews.add(am31);
    imageViews.add(am32);
    imageViews.add(am33);
    imageViews.add(am34);
    imageViews.add(am35);
    imageViews.add(am36);
    imageViews.add(am37);
    imageViews.add(am38);
    imageViews.add(am39);
    imageViews.add(am40);
    imageViews.add(am41);
    imageViews.add(am42);
    imageViews.add(am43);
    
    for (ImageView i : imageViews ){
        i.setFitWidth(368);
        i.setFitHeight(597);
    }

    am = new Group(am1);
    t = buildAnimation();
    Group f = new Group(am);
    am.setTranslateX(10);
    am.setTranslateY(10);
    am_scene = new Scene(f, 388, 617);
}

public void play(){
    this.t.play();
}

public void pause(){
    this.t.pause();
}

public Timeline buildAnimation(){
    return TimelineBuilder.create()
            .cycleCount(Animation.INDEFINITE)
            .keyFrames(new KeyFrame(Duration.millis(100), new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent t) {
                        am.getChildren().setAll(am1);
                    }
                }),
                new KeyFrame(Duration.millis(200), new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent t) {
                         am.getChildren().setAll(am2);
                    }
                }),
                new KeyFrame(Duration.millis(300), new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent t) {
                         am.getChildren().setAll(am3);
                    }
                }),
                new KeyFrame(Duration.millis(400), new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent t) {
                         am.getChildren().setAll(am4);
                    }
                }),
                new KeyFrame(Duration.millis(500), new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent t) {
                         am.getChildren().setAll(am5);
                    }
                }),
                new KeyFrame(Duration.millis(600), new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent t) {
                         am.getChildren().setAll(am6);
                    }
                }),
                new KeyFrame(Duration.millis(700), new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent t) {
                         am.getChildren().setAll(am7);
                    }
                }),
                new KeyFrame(Duration.millis(800), new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent t) {
                         am.getChildren().setAll(am8);
                    }
                }),
                new KeyFrame(Duration.millis(900), new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent t) {
                         am.getChildren().setAll(am9);
                    }
                }),
                new KeyFrame(Duration.millis(100), new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent t) {
                        am.getChildren().setAll(am10);
                    }
                }),
new KeyFrame(Duration.millis(100), new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent t) {
                        am.getChildren().setAll(am1);
                    }
                }),
                new KeyFrame(Duration.millis(200), new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent t) {
                         am.getChildren().setAll(am2);
                    }
                }),
                new KeyFrame(Duration.millis(300), new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent t) {
                         am.getChildren().setAll(am3);
                    }
                }),
                new KeyFrame(Duration.millis(400), new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent t) {
                         am.getChildren().setAll(am4);
                    }
                }),
                new KeyFrame(Duration.millis(500), new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent t) {
                         am.getChildren().setAll(am5);
                    }
                }),
                new KeyFrame(Duration.millis(600), new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent t) {
                         am.getChildren().setAll(am6);
                    }
                }),
                new KeyFrame(Duration.millis(700), new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent t) {
                         am.getChildren().setAll(am7);
                    }
                }),
                new KeyFrame(Duration.millis(800), new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent t) {
                         am.getChildren().setAll(am8);
                    }
                }),
                new KeyFrame(Duration.millis(900), new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent t) {
                         am.getChildren().setAll(am9);
                    }
                }),
                new KeyFrame(Duration.millis(1000), new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent t) {
                        am.getChildren().setAll(am10);
                    }
                }),
                new KeyFrame(Duration.millis(1100), new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent t) {
                        am.getChildren().setAll(am11);
                    }
                }),
                new KeyFrame(Duration.millis(1200), new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent t) {
                         am.getChildren().setAll(am12);
                    }
                }),
                new KeyFrame(Duration.millis(1300), new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent t) {
                         am.getChildren().setAll(am13);
                    }
                }),
                new KeyFrame(Duration.millis(1400), new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent t) {
                         am.getChildren().setAll(am14);
                    }
                }),
                new KeyFrame(Duration.millis(1500), new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent t) {
                         am.getChildren().setAll(am15);
                    }
                }),
                new KeyFrame(Duration.millis(1600), new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent t) {
                         am.getChildren().setAll(am16);
                    }
                }),
                new KeyFrame(Duration.millis(1700), new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent t) {
                         am.getChildren().setAll(am17);
                    }
                }),
                new KeyFrame(Duration.millis(1800), new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent t) {
                         am.getChildren().setAll(am18);
                    }
                }),
                new KeyFrame(Duration.millis(1900), new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent t) {
                         am.getChildren().setAll(am19);
                    }
                }),
                new KeyFrame(Duration.millis(2000), new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent t) {
                        am.getChildren().setAll(am20);
                    }
                }),
                new KeyFrame(Duration.millis(2100), new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent t) {
                        am.getChildren().setAll(am21);
                    }
                }),
                new KeyFrame(Duration.millis(2200), new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent t) {
                         am.getChildren().setAll(am22);
                    }
                }),
                new KeyFrame(Duration.millis(2300), new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent t) {
                         am.getChildren().setAll(am23);
                    }
                }),
                new KeyFrame(Duration.millis(2400), new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent t) {
                         am.getChildren().setAll(am24);
                    }
                }),
                new KeyFrame(Duration.millis(2500), new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent t) {
                         am.getChildren().setAll(am25);
                    }
                }),
                new KeyFrame(Duration.millis(2600), new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent t) {
                         am.getChildren().setAll(am26);
                    }
                }),
                new KeyFrame(Duration.millis(2700), new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent t) {
                         am.getChildren().setAll(am27);
                    }
                }),
                new KeyFrame(Duration.millis(2800), new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent t) {
                         am.getChildren().setAll(am28);
                    }
                }),
                new KeyFrame(Duration.millis(2900), new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent t) {
                         am.getChildren().setAll(am29);
                    }
                }),
                new KeyFrame(Duration.millis(3000), new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent t) {
                        am.getChildren().setAll(am30);
                    }
                }),
                new KeyFrame(Duration.millis(3100), new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent t) {
                        am.getChildren().setAll(am31);
                    }
                }),
                new KeyFrame(Duration.millis(3200), new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent t) {
                         am.getChildren().setAll(am32);
                    }
                }),
                new KeyFrame(Duration.millis(3300), new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent t) {
                         am.getChildren().setAll(am33);
                    }
                }),
                new KeyFrame(Duration.millis(3400), new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent t) {
                         am.getChildren().setAll(am34);
                    }
                }),
                new KeyFrame(Duration.millis(3500), new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent t) {
                         am.getChildren().setAll(am35);
                    }
                }),
                new KeyFrame(Duration.millis(3600), new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent t) {
                         am.getChildren().setAll(am36);
                    }
                }),
                new KeyFrame(Duration.millis(3700), new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent t) {
                         am.getChildren().setAll(am37);
                    }
                }),
                new KeyFrame(Duration.millis(3800), new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent t) {
                         am.getChildren().setAll(am38);
                    }
                }),
                new KeyFrame(Duration.millis(3900), new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent t) {
                         am.getChildren().setAll(am39);
                    }
                }),
                new KeyFrame(Duration.millis(4000), new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent t) {
                        am.getChildren().setAll(am40);
                    }
                }),
                new KeyFrame(Duration.millis(4100), new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent t) {
                         am.getChildren().setAll(am41);
                    }
                }),
                new KeyFrame(Duration.millis(4200), new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent t) {
                        am.getChildren().setAll(am42);
                    }
                })
            )
            .build();
    }


}
