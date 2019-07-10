import java.awt.*;

public class UnrollTransition extends BillTransition {
    final static int CELLS=9;
    static int fill_pixels[]={0xFFFFFFFF,0xFF000000,0xFF000000,0xFFFFFFFF};
    private static  int[] createUnrollAmountArray(int cell_h){
        float unroll_increment=((float)cell_h/(float)(CELLS+1))/((float)(CELLS+2)/2.0f);
        int total=0;
        int unroll_amount[]=new int[CELLS+1];
        for (int u = 0; u <=CELLS ; ++u) {
            unroll_amount[u]= (int) (unroll_increment*(CELLS-u+1));
            total+=unroll_amount[u];
        }
        if (total<0){
            unroll_amount[0]-=1;
        }
        return unroll_amount;
    }
    int location;
    int[] unroll_amount;

    @Override
    public void init(Component owner, int[] current, int[] next) {
        init(owner,current,next,CELLS,220);
        location=pixels_per_cell;
        System.arraycopy(current_pixels,0,work_pixels,0,pixels_per_cell);
        unroll_amount=(int[])object_table.get(getClass().getName()+cell_h);
        if (unroll_amount==null){
            unroll_amount=createUnrollAmountArray(cell_h);
            object_table.put(getClass().getName()+cell_h,unroll_amount);
        }
        for (int c = 0; c <CELLS ; ++c) {
            location-=unroll_amount[c]*cell_w;
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Unroll(c);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            createCellFromWorkPixels(c);
            System.arraycopy(next_pixels,location,work_pixels,location,unroll_amount[c]*cell_w);
        }
        work_pixels=null;
    }

    void Unroll(int c){
        int y_filp=cell_w;
        int offset[]=new int[unroll_amount[c]];
        for (int o=0;o<unroll_amount[c];++o){
            offset[o]=4;
        }
        offset[0]=2;
        if (unroll_amount[c]>1){
            offset[1]=3;
        }
        if (unroll_amount[c]>2){
            offset[unroll_amount[c]-1]=2;
        }
        if (unroll_amount[c]>3){
            offset[unroll_amount[c]-2]=3;
        }
        int offset_index=0;
        int end_location=location+unroll_amount[c]*cell_w;
        for (int p = location; p <end_location ; p+=cell_w) {
            System.arraycopy(next_pixels,p-y_filp+offset[offset_index],work_pixels,p,cell_w-offset[offset_index]);
            System.arraycopy(fill_pixels,0,work_pixels,p+cell_w-offset[offset_index],offset[offset_index]);
            ++offset_index;
            y_filp+=cell_w+cell_w;
        }
        for (int x = location+cell_w-1; x >location ; --x) {
            work_pixels[x]|=0xFFAAAAAA;
            work_pixels[x+unroll_amount[c]]&=0xFF555555;

        }
    }
}
