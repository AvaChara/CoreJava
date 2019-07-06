package twenty_two;

import java.applet.Applet;
import java.awt.*;

public class BorderLayoutDemo extends Applet{
    @Override
    public void init() {
        setLayout(new BorderLayout());
        add(new Button("This is across the top."),BorderLayout.SOUTH);
        add(new Button("Right"),BorderLayout.EAST);
        add(new Button("LEFT"),BorderLayout.WEST);
        String msg="The reasonable man adapts " +
                "himself to the world;\n" +
                "the unreasonable one persists in " +
                "trying to adapt the world to himself.\n" +
                "Therefore all progress depends " +
                "on the unresonable man.\n\n" +
                "       - George Bernard Shaw\n\n";
        add(new TextArea(msg),BorderLayout.CENTER);
    }
}
