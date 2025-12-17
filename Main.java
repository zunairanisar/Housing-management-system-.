import java.util.Random;
public class Main {
    public static void main(String[] args) {
//    Block block= new Block("a block",5,2);
////        System.out.println(block.chart());
//        System.out.println(block);
        CityHousing cityHousing= new CityHousing("lahore",5);
//        cityHousing.subtractSociety("society"+1);
//        System.out.println(cityHousing.getCount());
////        System.out.println(cityHousing.firstAvailable(PlotType.RES_1_KANAL));
//        System.out.println(cityHousing.chart());




//                // Step 1: Create CityHousing
//                CityHousing city = new CityHousing("Lahore Smart City", 2);
//                System.out.println("=== CITY CREATED ===");
//                System.out.println(city);
//
//                // Step 2: Display chart of the whole city
//                System.out.println("=== CITY CHART ===");
//                System.out.println(city.chart());
//
//                // Step 3: Book and cancel plots
//                System.out.println("=== BOOKING TEST ===");
//                city.bookPlot("society1", "block1", "0-3");
//                city.bookPlot("society1", "block2", "1-2");
//                city.cancelBooking("society1", "block1", "0-3");
//                System.out.println(city);
//
//                // Step 4: Find first available plot of each type
//                System.out.println("=== FIRST AVAILABLE TEST ===");
//                System.out.println(city.firstAvailable(PlotType.RES_1_KANAL));
//                System.out.println(city.firstAvailable(PlotType.COMM_SHOP));
//
//                // Step 5: Largest area plots in city
//                System.out.println("=== LARGEST AREA TEST ===");
//                Plot[] biggest = city.largestArea();
//                for (Plot p : biggest) {
//                    System.out.println(p);
//                }
//
//                // Step 6: Add a new society manually
//                System.out.println("=== ADDING NEW SOCIETY ===");
//                Society s3 = new Society("society3", 3);
//                city.addSociety(s3);
//                System.out.println(city);
//
//                // Step 7: Remove a society
//                System.out.println("=== REMOVING SOCIETY2 ===");
//                city.subtractSociety("society2");
//                System.out.println(city);
//
//                // Step 8: Market test
//                System.out.println("=== MARKET TEST ===");
//                Market m = new Market("Downtown Market", 5);
//                System.out.println(m);
//                m.bookShop(2);
//                m.bookShop(4);
//                System.out.println(m);
//                m.cancelBooking(2);
//                System.out.println(m);
//
//                // Step 9: Park area check
//                System.out.println("=== PARK TEST ===");
//                Park park = new Park(1, Shape.TRAPEZOID, 20, 10, 20, 15, "Central Park");
//                System.out.println(park);
//                System.out.println("Area: " + park.calculateArea());
//
//                // Step 10: Corner plot test
//                System.out.println("=== CORNER PLOT TEST ===");
//                CornerPlot cp = new CornerPlot(2, 5, true, PlotType.RES_10_MARLA, Shape.RECTANGLE, 30, 40);
//                System.out.println(cp);
//                System.out.println("Area: " + cp.calculateArea());
//                System.out.println("Has second frontage: " + cp.getHasSecondFrontage());
//
//                // Step 11: Society total plots and availability
//                System.out.println("=== SOCIETY TOTAL PLOTS ===");
//                System.out.println("Total plots in society1: " + city.societies[0].totalPlots());
//                System.out.println("City chart again:\n" + city.chart());
//
//                System.out.println("\n=== TEST COMPLETED SUCCESSFULLY ===");




                // Step 1: Create CityHousing
                CityHousing city = new CityHousing("Lahore Smart City", 2);
                System.out.println("=== CITY CREATED ===");
                System.out.println(city);

                // Step 2: Display initial chart
                System.out.println("=== INITIAL CITY CHART ===");
                System.out.println(city.chart());

                // Step 3: Manual booking / cancel
                System.out.println("=== BASIC BOOKING TEST ===");
                city.bookPlot("society1", "block1", "0-  3 ");
                city.bookPlot("society1", "block2", "1-  2 ");
                city.cancelBooking("society1", "block1", "0-  3 ");
                System.out.println(city);

                // Step 4: Random bookings (keep your exact ID pattern)
                System.out.println("=== RANDOM BOOKING TEST ===");
                Random rand = new Random();
                String[] societies = {"society1", "society2"};
                String[] blocks = {"block1", "block2"};

                for (int i = 0; i < 6; i++) {
                    String soc = societies[rand.nextInt(societies.length)];
                    String blk = blocks[rand.nextInt(blocks.length)];
                    int row = rand.nextInt(3);   // adjust if your blocks have more rows
                    int col = rand.nextInt(5);   // adjust if your blocks have more cols

                    String id = String.format("%d-%3d ", row, col); // your pattern

                    System.out.println("Booking " + id + "in " + soc + " → " + blk);
                    city.bookPlot(soc, blk, id);
                }

                // Step 5: Show updated chart
                System.out.println("=== UPDATED CITY CHART AFTER RANDOM BOOKINGS ===");
                System.out.println(city.chart());

                System.out.println("\n=== TEST COMPLETED SUCCESSFULLY ===");
            }
        }









