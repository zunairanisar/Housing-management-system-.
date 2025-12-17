public class Plot{
    String id;
    boolean isAvailable;
    double price;
    PlotType type;
    Shape shape;



double depth1;
double depth2;
double width1;
double width2;
double front;
double back;

    Plot(int r, int c, boolean isAvailable,PlotType type,Shape shape,double depth1,double width1){
        this. id= String.format("%d-%3d ",r,c);
        this.shape=shape;
        this.isAvailable=isAvailable;
        setPrice(type);
        this.type=type;
        this.depth1=depth1;
        this.width1=width1;
    }

    Plot(int r, int c, boolean isAvailable,PlotType type,Shape shape,double depth1,double width1,double depth2,double width2){
        this(r,c,isAvailable,type,shape,depth1,width1);
        this.shape=shape;
        this.depth2=depth2;
        this.width2=width2;
    }
    Plot(int r, int c, boolean isAvailable,PlotType type,Shape shape,double depth1,double front ,double back){

        this. id= String.format("%d-%3d ",r,c);
        this.isAvailable=isAvailable;
        setPrice(type);
        this.type=type;
        this.depth1=depth1;
        this.front=front;
        this.back=back;
        this.shape=shape;
    }

    Shape getShape(){
        return shape;
    }
    PlotType getType(){
        return type;
    }
    public boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean available) {
        isAvailable = available;
    }
    String getId(){
        return id;
    }


    void setPrice(PlotType type){
        if(type==PlotType.RES_5_MARLA){
            this.price=4000000;
        }
        else if(type==PlotType.RES_10_MARLA){
            this.price=7500000;
        }
        else if(type==PlotType.RES_1_KANAL){
            this.price=14000000;
        }
        else if(type==PlotType.COMM_SHOP ){
            this.price=3000000;
        }
        else if(type==PlotType.COMM_OFFICE){
            this.price=5000000;
        }
        else {
            this.price=200000;
        }





    }
    double calculateArea() {
        if (shape == Shape.RECTANGLE) {
            return width1 * depth1;
        }
        else if(shape==Shape.TRAPEZOID){
            return ((front + back) / 2) * depth1;
        }
        else if(shape==Shape.L_SHAPE){
            return (width1 * depth1) + (width2 * depth2);
        }
        return 0;

    }





    @Override
    public String toString(){
        return String.format("%s %b %.2f %s %s ",id,isAvailable,price,type,shape);
    }
    String chart(){
        if(isAvailable)
            return "O";
        else {
        return "X";
    }
    }















}
