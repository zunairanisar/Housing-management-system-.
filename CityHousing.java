public class CityHousing {
    String name;
    Society[] societies;
    int count;
    Plot bigPlots[];

    CityHousing(String name,int n){
        this.name=name;
        this.count =n;
        societies= new Society[n];
        for(int i=0;i< societies.length;i++){
            societies[i]= new Society("society"+(i+1),5);
        }
        largestArea();
    }
    void addSociety(Society society){
        Society[] big= new Society[count+1];
        for(int i=0;i<big.length;i++){
            if(i==count){
                big[i]=society;
            }
            else{
                big[i]=societies[i];
            }

        }
        societies=big;
        count++;
    }
    void subtractSociety(String societyName){
        boolean flag=false;
        Society[] small= new Society[count-1];
        for(int i=0;i< societies.length;i++){
           if(societies[i].getName().equals(societyName)){
               flag=true;
               for(int j=0;j< small.length;j++){
                   if(j>=i){
                       small[j]=societies[j+1];
                   }
                   else{
                       small[j]=societies[j];
                   }
               }
           }

        }
        if(flag){
        societies=small;
        count--;
    }
    }
    int getCount(){
        return count;
    }
    void bookPlot(String societyName,String blockName,String plotId){
        for(int i=0;i< societies.length;i++){
            if(societies[i].getName().equals(societyName)){
                societies[i].bookPlot(blockName,plotId);
            }
        }
    }
    void cancelBooking(String societyName,String blockName,String plotId){
        for(int i=0;i< societies.length;i++){
            if(societies[i].getName().equals(societyName)){
                societies[i].cancelBooking(blockName,plotId);
            }
        }
    }
    String firstAvailable(PlotType type){
        StringBuilder temp= new StringBuilder();
        for(int i=0;i< societies.length;i++){
            if(societies[i].firstAvailablePlot(type)!=null){
                temp.append(name+" > "+societies[i].firstAvailablePlot(type));
                temp.append("\n");
                break;
            }
        }
        return temp.toString();
    }
@Override
    public String toString(){

        StringBuilder temp= new StringBuilder();
        temp.append(name+"\n");
        for(int i=0;i< societies.length;i++){
            temp.append(societies[i]+"\n");
        }
        return temp.toString();
}
    Plot[] largestArea(){
        int tempCount=0;
        Plot[][] temp1= new Plot[count][];
        for(int i=0;i<societies.length;i++){
            temp1[i]=societies[i].largestArea();
        }
        Plot largest=temp1[0][0];
        for(int i=0;i<temp1.length;i++){
            if(temp1[i][0].calculateArea()> largest.calculateArea()){
                largest=temp1[i][0];
            }
        }
        for(int i=0;i<temp1.length;i++){
            for(int j=0;j<temp1[i].length;j++){
                if(temp1[i][j].calculateArea()== largest.calculateArea()){
                    tempCount++;
                }
            }
        }
        bigPlots= new Plot[tempCount];
        int idx=0;
        for(int i=0;i<temp1.length;i++){
            for(int j=0;j<temp1[i].length;j++){
                if(temp1[i][j].calculateArea()== largest.calculateArea()){
                    bigPlots[idx]=temp1[i][j];
                    idx++;
                }
            }
        }





    return bigPlots;
    }
    String chart(){
        StringBuilder temp = new StringBuilder();
        temp.append(name+"\n");
        for(int i=0;i< count;i++){
            temp.append(societies[i].chart()+"\n");
        }
        return temp.toString();
    }




}
