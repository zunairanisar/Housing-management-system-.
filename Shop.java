public class Shop extends Plot {


    Shop(int r, int c, boolean isAvailable,Shape shape,double depth1,double width1){
        super(r,c,isAvailable,PlotType.COMM_SHOP,shape,depth1,width1);
    }

    Shop(int r, int c, boolean isAvailable,Shape shape,double depth1,double width1,double depth2,double width2){
        super(r,c,isAvailable,PlotType.COMM_SHOP,shape,depth1,width1,depth2,width2);
    }
    Shop(int r, int c, boolean isAvailable,Shape shape,double depth1,double front ,double back){
        super(r,c,isAvailable,PlotType.COMM_SHOP,shape,depth1,front,back);

    }



}
