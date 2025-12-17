public class Society {
    String name;
    Block[] blocks;
    int count;
    Plot[] bigPlot;
    Society(String name,int n){
        this.name=name;
        this.count =n;
        blocks= new Block[n];
        for(int i=0;i< blocks.length;i++){
            blocks[i]= new Block("block"+(i+1),5,2);
        }
    }
    void addBlock(Block block){
        Block[] big = new Block[count+1];
        for(int i=0;i<big.length;i++){
            if(i==count){
                big[i]=block;
            }
            else{
            big[i]=blocks[i];
        }
        }
        blocks=big;
        count++;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    int  totalPlots(){
        int total=0;
        for(int i=0;i<blocks.length;i++){
            total=total + blocks[i].total();
        }
        return total;
    }
    void bookPlot(String blockName,String id){
        for(int i=0;i< blocks.length;i++){
            if(blocks[i].getName().equals(blockName)){
                blocks[i].bookPlot(id);
            }
        }
    }
    void cancelBooking(String blockName,String id){
        for(int i=0;i< blocks.length;i++){
            if(blocks[i].getName().equals(blockName)){
                blocks[i].cancelBooking(id);
            }
        }
    }
    public String toString(){
        StringBuilder temp=new StringBuilder();
        temp.append(name+"\n");
        for(int i=0;i< blocks.length;i++){
            temp.append(blocks[i]);
            temp.append("\n");
        }
        return temp.toString();
    }
//    String firstAvailablePlot(PlotType type){
//        StringBuilder temp= new StringBuilder();
//        for(int i=0;i< blocks.length;i++){
//            if(blocks[i].firstAvailablePlot(type)!=null){
//                temp.append(name+" > "+blocks[i].firstAvailablePlot(type));
//            break;
//            }
//        }
//        return temp.toString();
//    }
String firstAvailablePlot(PlotType type){
    for(int i=0;i< blocks.length;i++){
        String found = blocks[i].firstAvailablePlot(type);
        System.out.println("Checking " + name + " " + blocks[i].getName() + " → " + found);
        if(found != null){
            return name + " > " + found;
        }
    }
    return null;
}
Plot[] largestArea(){
        Plot[][] large= new Plot[count][];
        for(int i=0;i< blocks.length;i++){
            large[i]=blocks[i].largestArea();
        }
        Plot largest=large[0][0];
        for(int i=0;i<large.length; i++){
            if(large[i][0].calculateArea()> largest.calculateArea()){
                largest=large[i][0];
            }
        }
        Plot[] temp= new Plot[600];
        int count=0;
        for(int i=0;i<large.length;i++){
            for(int j=0;j<large[i].length;j++){
                if(large[i][j].calculateArea()== largest.calculateArea()){
                    temp[count]=large[i][j];
                    count++;
                }
            }
        }
        bigPlot= new Plot[count];
        for(int i=0;i< bigPlot.length;i++){
            bigPlot[i]=temp[i];
        }
return bigPlot;
}


String chart(){
        StringBuilder temp = new StringBuilder();
        temp.append(name+"\n");
        for(int i=0;i< count;i++){
            temp.append(blocks[i].chart()+"\n");
        }
        return temp.toString();
}





}
