package twenty_six;

import javax.swing.*;
import java.awt.*;

public class JTableDemo extends JApplet {
    @Override
    public void init() {
        Container container=getContentPane();
        container.setLayout(new BorderLayout());
        final String[] colHeads={"Name","Phone","Fax"};
        final Object[][] data={
                {"Gail","4567","6543"},
                {"Ken","4242","1234"},
                {"Viviane","4324","7554"},
                {"Malenie","6434","1346"},
                {"Anne","8903","7894"},
                {"John","6542","1346"},
                {"Matt","3424","1363"},
                {"Claire","6453","7585"},
                {"Erwin","3325","5224"},
                {"Ellen","6575","2467"},
                {"Jennifer","2567","9544"},
                {"Ed","5346","7566"},
                {"Helen","2467","5789"},
        };

        JTable table=new JTable(data,colHeads);
        int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
        int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
        JScrollPane jsp=new JScrollPane(table,v,h);

        container.add(jsp,BorderLayout.CENTER);
    }
}
