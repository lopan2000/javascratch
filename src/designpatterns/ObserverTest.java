package designpatterns;

import java.util.ArrayList;
import java.util.List;

public class ObserverTest {

    public static void main(String[] args) {
        WeatherStation w = new WeatherStation();
        w.addObserver(new PhoneObserver());
        w.addObserver(new PhoneObserver());
        w.setTemp(100);
    }
}

class WeatherStation {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer o) {
        observers.add(o);
    }

    public void setTemp(int t) {
        for (Observer o : observers) {
            o.update(t);
        }
    }
}

interface Observer {
    void update(int temp);
}

class PhoneObserver implements Observer {
    public void update(int temp) {
        System.out.println(temp);
    }
}
