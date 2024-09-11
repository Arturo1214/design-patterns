package bo.com.ahosfot.patterns.behavior.mediator.component;

import bo.com.ahosfot.patterns.behavior.mediator.mediator.Mediator;

public interface Component {
    void setMediator(Mediator mediator);
    String getName();
}
