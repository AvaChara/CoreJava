public class TwoDArray {
    public static void main(String args[]){
        //二维数组定义模式1
        int twoD[][]=new int[4][5];
        int i,j,k=0;
        for (i=0;i<4;i++){
            for (j=0;j<5;j++){
                twoD[i][j]=k;
                k++;
            }
        }
        for (i=0;i<4;i++){
            for (j=0;j<5;j++){
                System.out.print(twoD[i][j]+" ");
            }
            System.out.println();
        }

        //二维数组定义模式2
        int twoD2[][]=new int[4][];
        twoD2[0]=new int[1];
        twoD2[1]=new int[2];
        twoD2[2]=new int[3];
        twoD2[3]=new int[4];
        int i1,j1,k1=0;
        for (i1=0;i1<4;i1++){
            for (j1=0;j1<i1+1;j1++){
                twoD2[i1][j1]=k1;
                k1++;
            }
        }
        for (i1=0;i1<4;i1++){
            for (j1=0;j1<i1+1;j1++){
                System.out.print(twoD2[i1][j1]+" ");
            }
            System.out.println();
        }
    }
}
