public class CornerPlot extends Plot {
    boolean hasSecondFrontage;




    CornerPlot(int r, int c, boolean isAvailable,PlotType type,Shape shape,double depth1,double width1){
        super(r,c,isAvailable,type,shape,depth1,width1);
        this.price=(8.0/100 * price)+price;
        hasSecondFrontage=true;

    }
    CornerPlot(int r, int c, boolean isAvailable,PlotType type,Shape shape,double depth1,double width1,double depth2,double width2){
        super(r,c,isAvailable,type,shape,depth1,width1,depth2,width2);
        this.price=(8.0/100 * price)+price;
        hasSecondFrontage=true;
    }
    CornerPlot(int r, int c, boolean isAvailable,PlotType type,Shape shape,double depth1,double front ,double back){
        super(r,c,isAvailable,type,shape,depth1,front,back);
        this.price=(8.0/100 * price)+price;
    }
    String getHasSecondFrontage(){
        if(hasSecondFrontage)
            return "yes";
        return "no";
    }
    @Override
    public String toString(){
        return String.format("%s %b %.2f %s %s %s ",id,isAvailable,price,type,shape,getHasSecondFrontage());
    }














}