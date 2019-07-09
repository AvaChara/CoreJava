package twenty_six;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JtreeEvents extends JApplet {

    JTree tree;
    JTextField jtf;

    @Override
    public void init() {
        Container container=getContentPane();
        container.setLayout(new BorderLayout());

        DefaultMutableTreeNode top=new DefaultMutableTreeNode("Options");

        DefaultMutableTreeNode a=new DefaultMutableTreeNode("A");
        top.add(a);
        DefaultMutableTreeNode a1=new DefaultMutableTreeNode("A1");
        a.add(a1);
        DefaultMutableTreeNode a2=new DefaultMutableTreeNode("A2");
        a.add(a2);

        DefaultMutableTreeNode b=new DefaultMutableTreeNode("B");
        top.add(b);
        DefaultMutableTreeNode b1=new DefaultMutableTreeNode("B1");
        b.add(b1);
        DefaultMutableTreeNode b2=new DefaultMutableTreeNode("B2");
        b.add(b2);
        DefaultMutableTreeNode b3=new DefaultMutableTreeNode("B3");
        b.add(b3);

        tree=new JTree(top);

        int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
        int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
        JScrollPane jsp=new JScrollPane(tree,v,h);

        container.add(jsp,BorderLayout.CENTER);

        jtf=new JTextField("",20);
        container.add(jtf,BorderLayout.SOUTH);

        tree.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                doMouseCilcked(e);
            }
        });
    }

    void doMouseCilcked(MouseEvent me){
        TreePath tp=tree.getPathForLocation(me.getX(), me.getY());
        if (tp!=null)
            jtf.setText(tp.toString());
        else
            jtf.setText("");
    }
}
