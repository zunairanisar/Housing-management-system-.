public class Park {

    String name;
    String id;
    Shape shape;
    double depth1;
    double depth2;
    double width1;
    double width2;
    double front;
    double back;





    Park(int r,Shape shape,double depth1,double width1,String name){
        this. id= String.format("%d",r);
        this.shape=shape;
        this.depth1=depth1;
        this.width1=width1;
        this.name=name;
    }
    Park(int r,Shape shape,double depth1,double width1,double depth2,double width2,String name){
        this(r,shape,depth1,width1,name);
        this.depth2=depth2;
        this.width2=width2;
    }
    Park(int r, int c,Shape shape,double depth1,double front ,double back,String name){
        String id= String.format("%d",r);
        this.shape=shape;
        this.depth1=depth1;
        this.front=front;
        this.back=back;
        this.name=name;
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

    public String toString(){
        return String.format("%s %s %s %.2f",name,id,shape,calculateArea());

    }
    public String chart(){
        return "P";
    }











}