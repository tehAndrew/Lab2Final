package com.group14.App.View;

import com.group14.App.Observer.CarMessage;
import com.group14.App.Observer.IObserver;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SpeedView implements IObserver {

    private JFrame frame;

    public SpeedView(String title, int screenWidth, int screenHeight) {
        frame = new JFrame();
        frame.setTitle(title);
        frame.setPreferredSize(new Dimension(screenWidth, screenHeight));
        frame.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        frame.pack();
    }

    public void notify(ArrayList<CarMessage> carMessages) {
        for (CarMessage msg : carMessages) {

        }
    }


}
