import java.awt.*;

public class SmashTransition extends BillTransition{
    final static int CELLS=8;
    final static float FOLDS=8.0f;
    static int[] fill_pixels;

    static void setupFillPiexls(int width){
        if (fill_pixels!=null&&fill_pixels.length<=width){
            return;
        }
        fill_pixels=new int[width];
        for (int f = 0; f <width ; f++) {
            fill_pixels[f]=0xFFFFFFFF;
        }
    }

    int drop_amount;
    int location;

    @Override
    public void init(Component owner, int[] current, int[] next) {
        init(owner,current,next,CELLS,160);
        setupFillPiexls(cell_w);
        drop_amount=(cell_h/CELLS)*cell_w;
        location=pixels_per_cell-((cell_h/CELLS)/2)*cell_w;
        for (int c = CELLS-1; c >=0 ; --c) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Smash(c+1);
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            createCellFromWorkPixels(c);
            location-=drop_amount;
        }
        work_pixels=null;
    }

    void Smash(int max_fold){
        System.arraycopy(next_pixels,pixels_per_cell-location,work_pixels,0,location);
        int height=cell_h-location/cell_w;
        float fold_offset_adder=(float)max_fold* FOLDS/(float)height;
        float fold_offset=0.0f;
        int fold_width=cell_w-max_fold;
        float src_y_adder=(float)cell_h/(float)height;
        float src_y_offset=cell_h-src_y_adder/2;
        for (int p = pixels_per_cell-cell_w; p >=location; p-=cell_w) {
            System.arraycopy(fill_pixels,0,work_pixels,p,cell_w);
            System.arraycopy(current_pixels,(int)src_y_offset*cell_w,work_pixels,p+(int)fold_offset,fold_width);
            src_y_offset-=src_y_adder;
            fold_offset+=fold_offset_adder;
            if (fold_offset<0.0||fold_offset>=max_fold){
                fold_offset_adder*=-1.0f;
            }
        }
    }
}
