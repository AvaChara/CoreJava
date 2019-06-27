import com.sun.tools.corba.se.idl.toJavaPortable.ValueBoxGen24;

class Box{
    double width;
    double heigth;
    double depth;

    Box(Box ob){
        width=ob.width;
        heigth=ob.heigth;
        depth=ob.depth;
    }

    Box(double w,double h,double d){
        width=w;
        heigth=h;
        depth=d;
    }

    Box(){
        width=-1;
        heigth=-1;
        depth=-1;
    }

    Box(double len){
        width=heigth=depth=len;
    }

    double volume(){
        return width*heigth*depth;
    }
}

class BoxWeight extends Box{
    double weight;

    BoxWeight(BoxWeight ob){
        super(ob);
        weight=ob.weight;
    }
    /*BoxWeight(double w,double h,double d,double m){
        width=w;
        heigth=h;
        depth=d;
        weight=m;
    }*/
    BoxWeight(double w,double h,double d, double m){
        super(w,h,d);
        weight=m;
    }
    BoxWeight(){
        super();
        weight=-1;
    }
    BoxWeight(double len,double m){
        super(len);
        weight=m;
    }

}

public class DemoBox {
    public static void main(String args[]){
        BoxWeight mybox1=new BoxWeight(10,20,15,34.3);
        BoxWeight mybox2=new BoxWeight(2,3,4,0.076);
        BoxWeight mybox3=new BoxWeight();
        BoxWeight mycube=new BoxWeight(3,2);
        BoxWeight myclone=new BoxWeight(mybox1);
        double vol;

        vol=mybox1.volume();
        System.out.println("Volume of mybox1:"+vol);
        System.out.println("Weight of mybox1:"+mybox1.weight);
        System.out.println();

        vol=mybox2.volume();
        System.out.println("Volume of mybox2:"+vol);
        System.out.println("Weight of mybox2:"+mybox2.weight);
        System.out.println();

        vol=mybox3.volume();
        System.out.println("Volume of mybox3:"+vol);
        System.out.println("Weight of mybox3:"+mybox3.weight);
        System.out.println();

        vol=myclone.volume();
        System.out.println("Volume of myclone:"+vol);
        System.out.println("Weight of myclone:"+myclone.weight);
        System.out.println();

        vol=mycube.volume();
        System.out.println("Volume of mycube:"+vol);
        System.out.println("Weight of mycube:"+mycube.weight);
        System.out.println();
    }
}
