package ObservablePattern;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ObserverClass implements PropertyChangeListener {
    public static void main(String[] args) {
        ObservableClass observable = new ObservableClass();
        ObserverClass observer = new ObserverClass();

        observable.addPropertyChangeListener(observer);
        observable.setTranscurso("news");

        //assertEquals(observer.getNews(), "news");
    }

    private String news;

    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("ME HE ACTUALIZADO");
    }

}
