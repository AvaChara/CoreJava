import java.awt.*;

public class TearTransition extends BillTransition {

    static  final int CELLS=7;
    static final float INITIAL_X_CROSS=1.6f;
    static final float X_CROSS_DIVISOR=3.5f;
    float x_cross;

    @Override
    public void init(Component owner, int[] current, int[] next) {
        init(owner,current,next,CELLS);
        System.arraycopy(next_pixels,0,work_pixels,0,pixels_per_cell);
        System.arraycopy(current_pixels,0,work_pixels,0,cell_w);
        x_cross=INITIAL_X_CROSS;
        for (int c = CELLS; c >=0 ; --c) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Tear();
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            createCellFromWorkPixels(c);
            x_cross/=X_CROSS_DIVISOR;
        }
        work_pixels=null;
    }
    final void Tear(){
        float x_increment;
        int p,height_adder;

        p=height_adder=cell_w;
        for (int y = 1; y <cell_h ;++y) {
            x_increment=x_cross*y;
            if (x_increment>=0.50f){
                float fx=0.0f;
                x_increment+=1.0f;
                int x=0;
                do {
                    work_pixels[p++]=current_pixels[height_adder+x];
                    x= (int) (fx+=x_increment);
                }while (x<cell_w);
            }
            else {
                float overflow=1.0f/x_increment;
                float dst_end=overflow/2.0f+1.49999999f;
                int dst_start=0,src_offset=0,length= (int) dst_end;
                while (dst_start+src_offset+length<cell_w){
                    System.arraycopy(current_pixels,p+src_offset,work_pixels,p,length);
                    ++src_offset;
                    dst_end+=overflow;
                    p+=length;
                    dst_start+=length;
                    length= (int) (dst_end-dst_start);
                }
                length=cell_w-src_offset-dst_start;
                System.arraycopy(current_pixels,p+src_offset,work_pixels,p,length);
            }
            p=height_adder+=cell_w;
        }
    }
}
