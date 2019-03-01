package com.group14.App.View;

import com.group14.App.Observer.CarMessage;
import com.group14.App.Observer.IObserver;
import com.group14.ResourceLoader.ImageLoader;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CarView implements IObserver {
    public enum Button {
        GAS,
        TURBO_ON,
        LIFT_BED,
        BRAKE,
        TURBO_OFF,
        LOWER_BED,
        START,
        STOP
    }

    private ImageLoader imageLoader;
    private JFrame frame;
    private DrawPanel drawPanel;
    private JPanel controlPanel;
    private JPanel gasPanel;
    private JSpinner gasSpinner;
    private JButton[] buttons;

    public CarView(String title, int screenWidth, int screenHeight) {
        frame = new JFrame();
        frame.setTitle(title);
        frame.setPreferredSize(new Dimension(screenWidth, screenHeight));
        frame.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        drawPanel = new DrawPanel(screenWidth, screenHeight - 240);
        frame.add(drawPanel);

        gasSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        gasPanel = new JPanel();
        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(new JLabel("Gas: "), BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);
        frame.add(gasPanel);

        buttons = new JButton[8];
        buttons[Button.GAS.ordinal()] = new JButton("Gas");
        buttons[Button.BRAKE.ordinal()] = new JButton("Brake");
        buttons[Button.TURBO_OFF.ordinal()] = new JButton("Saab Turbo off");
        buttons[Button.TURBO_ON.ordinal()] = new JButton("Saab Turbo on");
        buttons[Button.LIFT_BED.ordinal()] = new JButton("Scania Lift Bed");
        buttons[Button.LOWER_BED.ordinal()] = new JButton("Lower Lift Bed");
        buttons[Button.START.ordinal()] = new JButton("Start all cars");
        buttons[Button.STOP.ordinal()] = new JButton("Stop all cars");

        controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(2,4));
        controlPanel.add(buttons[Button.GAS.ordinal()], 0);
        controlPanel.add(buttons[Button.TURBO_ON.ordinal()], 1);
        controlPanel.add(buttons[Button.LIFT_BED.ordinal()], 2);
        controlPanel.add(buttons[Button.BRAKE.ordinal()], 3);
        controlPanel.add(buttons[Button.TURBO_OFF.ordinal()], 4);
        controlPanel.add(buttons[Button.LOWER_BED.ordinal()], 5);
        controlPanel.setPreferredSize(
                new Dimension((screenWidth / 2) + 4, 200));
        frame.add(controlPanel);

        buttons[Button.START.ordinal()].setBackground(Color.blue);
        buttons[Button.START.ordinal()].setForeground(Color.green);
        buttons[Button.START.ordinal()].setPreferredSize(
                new Dimension(screenWidth / 5 - 15, 200));
        frame.add(buttons[Button.START.ordinal()]);

        buttons[Button.STOP.ordinal()].setBackground(Color.red);
        buttons[Button.STOP.ordinal()].setForeground(Color.black);
        buttons[Button.STOP.ordinal()].setPreferredSize(
                new Dimension(screenWidth / 5 - 15, 200));
        frame.add(buttons[Button.STOP.ordinal()]);

        frame.pack();

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width / 2 - frame.getSize().width / 2,
                          dim.height / 2 - frame.getSize().height / 2);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setImageLoader(ImageLoader imageLoader) {
        this.imageLoader = imageLoader;
    }

    public void mapBehaviorToButton(int buttonIndex, ActionListener behavior) {
        buttons[buttonIndex].addActionListener(behavior);
    }

    public void mapBehaviorToSpinner(ChangeListener behavior) {
        gasSpinner.addChangeListener(behavior);
    }

    // From IObserver
    public void notify(ArrayList<CarMessage> carMessages) {
        for (CarMessage msg : carMessages) {
            drawPanel.queryDrawCall(imageLoader.getImage(msg.getImageKey()),
                                    msg.getCarX(),
                                    msg.getCarY());
        }
        drawPanel.repaint();
    }
}