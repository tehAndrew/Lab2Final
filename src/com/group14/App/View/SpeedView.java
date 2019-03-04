package com.group14.App.View;

import com.group14.App.Observer.CarMessage;
import com.group14.App.Observer.IObserver;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SpeedView implements IObserver {
    private JFrame frame;
    private JLabel label;
    private String text;

    public SpeedView(String title, int screenWidth, int screenHeight) {
        frame = new JFrame();
        frame.setTitle(title);
        frame.setSize(new Dimension(screenWidth, screenHeight));

        label = new JLabel("");
        frame.add(label);

        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setVisible(true);
    }

    public void notify(ArrayList<CarMessage> carMessages) {
        text = "<html>";
        for (CarMessage msg : carMessages) {
            text += msg.getImageKey() + ": " + msg.getCarSpeed() + "<br>";
        }
        text += "</html>";
        label.setText(text);
    }
}
