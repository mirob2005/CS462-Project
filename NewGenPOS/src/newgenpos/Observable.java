/*
 * HW5.1 Observer Pattern
 */
package newgenpos;

import java.util.Observer;


public interface Observable {
    public void notifyObservers();
    public void registerObserver(Observer obs);
    public void unRegisterObservers(Observer obs);
}