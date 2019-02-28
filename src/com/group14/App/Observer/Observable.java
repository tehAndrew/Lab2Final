package com.group14.App.Observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable {
    private List<IObserver> observers;

    protected Observable(){
        observers = new ArrayList<>();
    }

    public void addObserver(IObserver observer){
        observers.add(observer);
    }

    public void removeObserver(IObserver observer){
        observers.remove(observer);
    }

    protected void notifyObservers(ArrayList<CarMessage> carMessages){
        for(IObserver obs : observers){
            obs.notify(carMessages);
        }
    }

}
