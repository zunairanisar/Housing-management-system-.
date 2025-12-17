public class Market {

    private String name;
    Shop[] shops;
    private int count;
    Market(String name,int n){
      this. name=name;
      this.count=n;
      shops= new Shop[n];
      for(int i=0;i<shops.length;i++){
          shops[i]=new Shop(i,0,true,Shape.RECTANGLE,20,10);
      }
    }
    void bookShop(int r){
     for(int i=0;i<count;i++){
         if(i==r){
             shops[i].setIsAvailable(false);
         }
     }
    }
     void cancelBooking(int r){
            for(int i=0;i<count;i++){
                if(i==r){
                    shops[i].setIsAvailable(true);
                }
            }



    }
    public String toString(){
        StringBuilder temp= new StringBuilder();
        temp.append(name+"\n");
        for(int i=0;i<count;i++){
         temp.append(shops[i]);
         temp.append("\n");
        }
        String temp2= String.format("no of shops: %d    Available shops:%d",totalShops(),availableShops());
        temp.append(temp2);

        return temp.toString();
    }
    String chart(){
        StringBuilder temp= new StringBuilder();
        temp.append(name);
        for(int i=0;i< shops.length;i++){
            temp.append(shops[i].chart());

        }
        return temp.toString();
    }
    int totalShops(){
        return count;
    }
    int availableShops(){
        int total=0;
        for(int i=0;i<shops.length;i++){
        if(shops[i].getIsAvailable()){
            total++;
        }
        }
        return total;
    }
// will add addshop() later






}