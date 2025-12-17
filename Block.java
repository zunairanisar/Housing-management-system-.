public class Block{
    Plot[][] plots;
    String name;
    int count;
    Park[] parks;
    Market market;
    Plot[] bigPlots;
    Block(String name,int streets,int parks){
        this.name=name;
        int count=streets;
        this.parks= new Park[parks];
        for(int i=0;i<this.parks.length;i++){
            this.parks[i]= new Park(i,Shape.RECTANGLE,20,10,"park"+(i+1));
        }
        market= new Market("Market"+name,20);

        plots= new Plot[streets][];

        for(int i=0;i<plots.length;i++){
            plots[i]= new Plot[10+i];
            for(int j=0;j<plots[i].length;j++){
                if(i==0){
                    if(j==5){
                        plots[i][j]= new Plot( i, j,true,PlotType.PARKING,Shape.RECTANGLE,20,10);
                    }
                    else if(j==4){
                        plots[i][j]= new CornerPlot( i, j,true,PlotType.PARKING,Shape.RECTANGLE,20,10);
                    }
                    else{
                        plots[i][j]= new Plot( i, j,true,PlotType.RES_5_MARLA,Shape.RECTANGLE,20,10);
                    }
                }
                else if(i==1){
                    if(j==5){
                        plots[i][j]= new Plot( i, j,true,PlotType.PARKING,Shape.RECTANGLE,20,10);
                    }
                    else if(j==4){
                        plots[i][j]= new CornerPlot( i, j,true,PlotType.PARKING,Shape.RECTANGLE,20,10);
                    }
                    else
                    plots[i][j]= new Plot( i, j,true,PlotType.RES_10_MARLA,Shape.RECTANGLE,20,10);
                }
                else if(i==2){
                    if(j==5){
                        plots[i][j]= new Plot( i, j,true,PlotType.PARKING,Shape.RECTANGLE,20,10);
                    }
                    else if(j==4){
                        plots[i][j]= new CornerPlot( i, j,true,PlotType.PARKING,Shape.RECTANGLE,20,10);
                    }
                    else
                    plots[i][j]= new Plot( i, j,true,PlotType.RES_1_KANAL,Shape.TRAPEZOID,20,10);
                }
                else if(i==3){
                    if(j==5){
                        plots[i][j]= new Plot( i, j,true,PlotType.PARKING,Shape.RECTANGLE,20,10);
                    }
                    else if(j==4){
                        plots[i][j]= new CornerPlot( i, j,true,PlotType.PARKING,Shape.RECTANGLE,20,10);
                    }
                    else
                    plots[i][j]= new Plot( i, j,true,PlotType.COMM_SHOP,Shape.RECTANGLE,20,10);
                }
                else{

                     if(j==5){
                        plots[i][j]= new Plot( i, j,true,PlotType.PARKING,Shape.RECTANGLE,20,10);
                    }
                     else
                    plots[i][j]= new Plot( i, j,true,PlotType.COMM_OFFICE,Shape.RECTANGLE,20,10);
                }
            }



        }





    }
    public String toString(){
        StringBuilder temp = new StringBuilder();
        temp.append(name+"\n");
        for(int i=0;i< plots.length;i++){
            temp.append("street "+(i+1));
            temp.append("\n");
            for(int j=0;j<plots[i].length;j++){
                temp.append(plots[i][j]);
                temp.append("\n");
            }
        }
        temp.append("AMENITIES  \n");
        temp.append(market);
        for(int i=0;i< parks.length;i++){
            temp.append(parks[i]);
            temp.append("\n");
        }

        return temp.toString();
    }

     String chart(){
        StringBuilder temp= new StringBuilder();
        temp.append(name+"\n");
        for(int i=0;i< plots.length;i++){
            for(int j=0;j<plots[i].length;j++){
                temp.append(plots[i][j].chart());
            }
            temp.append("\n");
        }
        temp.append("\n" +"AMENITIES " +"\n");
        temp.append(market.chart()+"\n");
        for(int i=0;i< parks.length;i++){
            temp.append(parks[i].chart());
            temp.append("\n");
        }
        return temp.toString();
    }
    int total(){
        int total=0;
        for(int i=0;i< plots.length;i++){
            for(int j=0;j<plots[i].length;j++){
                total++;
            }
        }
        return total;
    }
    int totalAvailable(){
        int total=0;
        for(int i=0;i< plots.length;i++){
            for(int j=0;j<plots[i].length;j++){
                if(plots[i][j].getIsAvailable()){
                    total++;
                }
            }
        }

        return total;
    }
    void bookPlot(String plotId){
        for(int i=0;i<plots.length;i++){
            for(int j=0;j<plots[i].length;j++){
                if(plots[i][j].getId().equals(plotId)){
                    plots[i][j].setIsAvailable(false);
                }
            }
        }
    }
    void cancelBooking(String plotId){
        for(int i=0;i< plots.length;i++){
            for(int j=0;j<plots[i].length;j++){
                plots[i][j].setIsAvailable(true);
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
//    String firstAvailablePlot(PlotType type){
//        String temp= null;
//        for(int i=0;i< plots.length;i++){
//            for(int j=0;j<plots[i].length;j++){
//                if(plots[i][j].getType()==type&&plots[i][j].getIsAvailable()){
//                    temp=String.format("%s  plot > %s",name,plots[i][j]);
//                    break;
//                }
//
//            }
//        }
//        return temp;
//    }
String firstAvailablePlot(PlotType type) {
    for (int i = 0; i < plots.length; i++) {
        for (int j = 0; j < plots[i].length; j++) {
            if (plots[i][j].getType() == type && plots[i][j].getIsAvailable()) {
                return String.format("%s plot > %s", name, plots[i][j]);
            }
        }
    }
    return null;
}
Plot[] largestArea(){
        Plot[] large= new Plot[60];
        int bigAreaCount=0;
        int n=0;
        Plot largest=plots[0][0];
        for(int i=0;i< plots.length;i++){
            for(int j=0;j<plots[i].length;j++){
                if(i==0 && j==0){
                    continue;
                }
                if(plots[i][j].calculateArea()> largest.calculateArea()){
                    largest=plots[i][j];
                }
            }
        }
        for(int i=0;i< plots.length;i++){
            for(int j=0;j<plots[i].length;j++){
                if(plots[i][j].calculateArea()==largest.calculateArea()){
                    large[bigAreaCount]=plots[i][j];
                    bigAreaCount++;
                }
            }
        }
         bigPlots= new Plot[bigAreaCount];
        for(int i=0;i< bigPlots.length;i++){
            bigPlots[i]=large[i];
        }
        return bigPlots;
}







}





