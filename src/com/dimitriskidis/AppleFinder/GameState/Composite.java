package com.dimitriskidis.AppleFinder.GameState;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component{
    private List<Component> components = new ArrayList<>();

    public void addComponent(Component component) { // метод, чтобы добавлять новые компоненты
        components.add(component);
    }

//    public void removeComponent(Component component) {
//        components.remove(component);
//    }
    @Override
    public void setApplesOnMap() {
        for(Component component : components) {
            component.setApplesOnMap();
        }
    }
}
