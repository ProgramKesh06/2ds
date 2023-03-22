import java.util.Scanner;

public class ArrayingAbout2D {
        public static void main(String[] args){
            Scanner scan = new Scanner(System.in);
            System.out.println("What size would you like the array to be? (PLease add a space between the two numbers) Ex.2 3");
            String size = scan.nextLine();
            String [] sizes = size.split(" ");
            int row = Integer.parseInt (sizes [0]);
            int col = Integer.parseInt (sizes [1]);
            int[][] userArray = new int [row][col];
            for (int r = 0; r<userArray.length; r++){
                for (int c = 0; c<userArray[r].length; c++){
                    System.out.println("What value would you like to place in row " + r + " and in column " + c+ " ?");
                    int placeVal = scan.nextInt();
                    userArray [r][c] = placeVal;
                }
            }
            double meanOf = mean(userArray);
            double[] devsOf = devs(userArray);
            double sumOf = sum(userArray);
            double varianceOf = variance(userArray);
            double standardDevOf = standardDev(userArray);
            System.out.println("The mean of array: ");
            String msg = message(userArray);
            System.out.println(msg);
            System.out.println("is: " + meanOf );

            System.out.println("The devs of array: ");
            msg = message(userArray);
            System.out.println(msg);
            String devsMsg = "";
            for (int j= 0; j<devsOf.length; j++){
                devsMsg += devsOf[j];
                devsMsg += ", ";
            }
            System.out.println("is: " + devsMsg );

            System.out.println("The sum of array: ");
            msg = message(userArray);
            System.out.println(msg);
            System.out.println("is: " + sumOf );

            System.out.println("The variance of array: ");
            msg = message(userArray);
            System.out.println(msg);
            System.out.println("is: " + varianceOf );

            System.out.println("The standard deviation of array: ");
            msg = message(userArray);
            System.out.println(msg);
            System.out.println("is: " + standardDevOf );


        }
        public static double mean (int[][] arr){
            int count1 = count(arr);
            int tot = 0;
            for (int r = 0; r<arr.length; r++){
                for (int c = 0; c<arr[r].length; c++){
                    int mid = 0;
                    mid = arr [r][c];
                    tot+=mid;
                }
            }
            double means = (double)tot/count1;
            return means;
        }

        public static double[] devs (int[][] arr){
            int count1 = count(arr);
            int tot = 0;
            //call mean method
            double mean =  mean(arr);

            double[] devsArr = new double [count1];
            int count2 = 0;
            for (int[] ints : arr) {
                for (int col: ints) {
                    int mid1 = 0;
                    mid1 += col;
                    double sub = mean - mid1;
                    double dev = sub * sub;
                    devsArr [count2] = dev;
                    count2 ++;
                }
            }

            return devsArr;

        }
        public static double sum (int[][] arr){
            double[] devs =  devs(arr);
            double totalDev = 0;
            for (int i = 0; i < devs.length; i++){
                totalDev += devs[i];
            }
            return totalDev;
        }
        public static double variance (int[][] arr){
            int count1 = count(arr);
            double total = sum(arr);
            double var = total/count1;
            return var;
        }

        public static double standardDev (int[][] arr) {
            double varianceOut = variance(arr);
            double standDev = Math.sqrt(varianceOut);
            return standDev;
        }
        public static int count (int[][] arr){
            int count = 0;
            for (int r = 0; r<arr.length; r++){
                for (int c = 0; c<arr[r].length; c++){
                    count++;
                }
            }
            return count;
        }
        public static String message (int [][] arr){
            String msg = "{";
            msg += "\n";
            for (int r = 0; r<arr.length; r++){
                for (int c = 0; c<arr[r].length; c++) {
                    msg+=arr[r][c];
                    msg+=", ";
                }
                msg += "\n";
            }
            msg+="}";
            return msg;
        }
}
