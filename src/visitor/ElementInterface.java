package visitor;

import mediator.Coalition;

public interface ElementInterface {
    boolean visit(Coalition attacker, Coalition defender);
}
