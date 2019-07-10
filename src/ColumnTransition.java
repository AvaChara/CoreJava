import java.awt.*;

public class ColumnTransition extends BillTransition {
    final static int CELLS=7;
    final static int WIDTH_INCREMENT=3;
    final static int MAX_COLUMN_WIDTH=24;

    int rightmost_columns_max_width;
    int rightmost_columns_x_start;
    int column_width=WIDTH_INCREMENT;

    @Override
    public void init(Component owner, int[] current, int[] next) {
        init(owner,current,next,CELLS,200);
        rightmost_columns_max_width=cell_w%MAX_COLUMN_WIDTH;
        rightmost_columns_x_start=cell_w-rightmost_columns_max_width;

        System.arraycopy(current_pixels,0,work_pixels,0,pixels_per_cell);

        for (int c = 0; c < CELLS; c++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            NextCell();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            createCellFromWorkPixels(c);
            column_width+=WIDTH_INCREMENT;
        }
        work_pixels=null;
    }

    void NextCell(){
        int old_column_width=MAX_COLUMN_WIDTH-column_width;
        for (int p = pixels_per_cell-cell_w; p >=0; p-=cell_w) {
            for (int x = 0; x < rightmost_columns_x_start; x+=MAX_COLUMN_WIDTH) {
                System.arraycopy(next_pixels,x+p,work_pixels,old_column_width+x+p,column_width);
            }
            if (old_column_width<=rightmost_columns_max_width){
                System.arraycopy(next_pixels, rightmost_columns_x_start + p, work_pixels, rightmost_columns_x_start + old_column_width + p - 1, rightmost_columns_max_width - old_column_width + 1);
            }
        }
    }
}
