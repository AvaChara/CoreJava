import java.awt.*;
import java.awt.image.MemoryImageSource;
import java.util.Hashtable;

public abstract class BillTransition {
    static Hashtable object_table=new Hashtable(20);
    public Image[] cells;
    public int delay;

    Component owner;
    int cell_w;
    int cell_h;
    int pixels_per_cell;
    int[] current_pixels;
    int[] next_pixels;
    int[] work_pixels;

    public abstract void init(Component owner,int[] current_pixels,int[] next_pixels);

    final protected void init(Component owner,int[] current_pixels,int[] next_pixels,int number_of_cells,int delay){
        this.delay=delay;
        this.next_pixels=next_pixels;
        this.current_pixels=current_pixels;
        this.owner=owner;

        cells=new Image[number_of_cells];
        cell_w=owner.getSize().width;
        cell_h=owner.getSize().height;
        pixels_per_cell=cell_w*cell_h;
        work_pixels=new int[pixels_per_cell];
    }

    final protected void init(Component owner,int [] current_pixels,int[] next_pixels,int number_of_cells){
        init(owner,current_pixels,next_pixels,number_of_cells,12);
    }

    final void createCellFromWorkPixels(int cell){
        cells[cell]=owner.createImage(new MemoryImageSource(cell_w,cell_h,work_pixels,0,cell_w));
        owner.prepareImage(cells[cell],null);
    }
}
