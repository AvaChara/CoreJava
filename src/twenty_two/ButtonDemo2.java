package twenty_two;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ButtonDemo2 extends Applet {
    MyButton myButton;
    static int i=0;

    @Override
    public void init() {
        myButton=new MyButton("Test Button");
        add(myButton);
    }
    class MyButton extends Button{
        public MyButton(String lable){
            super(lable);
            enableEvents(AWTEvent.ACTION_EVENT_MASK);
        }

        @Override
        protected void processActionEvent(ActionEvent e) {
            showStatus("action event: "+i++);
            super.processActionEvent(e);
        }
    }
}
