package ObservablePattern;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ObservableClass {
    private String transcurso;

    private PropertyChangeSupport support;

    public ObservableClass() {
        support = new PropertyChangeSupport(this);
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }

    public void setTranscurso(String value) {
        support.firePropertyChange("transcurso", this.transcurso, value);
        this.transcurso = value;
    }
}
