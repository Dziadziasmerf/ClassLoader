package factory.methods;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by dziadziasmerf on 28.12.16.
 */

@Getter
@Setter
public class Method {

    public String name;
    private Frame frame;

    public Method(String name) {
        setName(name);
        setFrame(new Frame());
    }

}
