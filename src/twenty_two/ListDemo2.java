package twenty_two;

import com.sun.deploy.security.MozillaMyKeyStore;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;

public class ListDemo2 extends Applet {
    MyList list;

    @Override
    public void init() {
        list=new MyList();
        list.add("red");
        list.add("green");
        list.add("blue");
        add(list);
    }

    class MyList extends List{
        MyList(){
            enableEvents(AWTEvent.ACTION_EVENT_MASK|AWTEvent.ITEM_EVENT_MASK);
        }

        @Override
        protected void processActionEvent(ActionEvent e) {
            showStatus("Action event: "+e.getActionCommand());
            super.processActionEvent(e);
        }

        @Override
        protected void processItemEvent(ItemEvent e) {
            showStatus("Item event: "+getSelectedItem());
            super.processItemEvent(e);
        }
    }
}
