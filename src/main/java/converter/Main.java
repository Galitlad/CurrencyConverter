package converter;

//import statement
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Main - currency converter program.
 * @author galit ladani
 * @version 1.0
 *
 * Use this class to convert currency:
 * Dollar to Shekel
 * Shekel to Dollar
 * Shekel to Eure
 */

public class Main {


    public static void main(String[] args) throws Exception {


        System.out.println("Welcome to currency converter");//An opening title

        /**
         * The answer of the user choosing Y or N to start over currency converter.
         * @param String the answer.
         */
        String answer;

        /**
         * format the amount to 2 digits after the decimal point.
         */
        DecimalFormat df = new DecimalFormat("#,##0.00");


        do {
            /**
             * Create an object according to the coin, and use- getCoinInstance method from CoinFactory class.
             */
            Coin ilsValue = CoinFactory.getCoinInstance(Coins.ILS);
            Coin usdValue = CoinFactory.getCoinInstance(Coins.USD);
            Coin eurValue = CoinFactory.getCoinInstance(Coins.EUR);

            /**
             * asks user to select coin type according to the options.
             */
            System.out.println();
            System.out.println("Please choose an option 1 or 2 or 3 :");
            System.out.println("1. Dollar to Shekel ");
            System.out.println("2. Shekel to Dollar ");
            System.out.println("3. Shekel to EUR ");

            /**
             * The input of the user choosing 1 or 2 or 3 from the options.
             * @param String the input.
             */
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            /**
             * loop through of possible input that user enter, if user enter invalid input
             * (except of options 1/2/3) he will get invalid choice message.
             */
            while (Pattern.matches("\\D|[0|4|5|6|7|8|9]", input)) {
                System.out.println("Invalid Choice, please try again");
                input = scanner.nextLine();
            }

            /**
             * In case user select option 1 its convert Dollar to Shekel,
             * user will enter an amount and it calculate according to getCoinInstance method from CoinFactory class.
             */
            switch (input) {
                case "1" -> {
                    System.out.println(Coins.USD);/**print user choice*/
                    System.out.println("Please enter an amount to convert");
                    System.out.println();

                    int amount = scanner.nextInt();/**The amount that user want to convert.@param int the amount*/
                    double a = amount;/**widening castin type int amount to type double a*/
                    System.out.println("The amount is : " + df.format(a) + " $ convert to ILS");/**printing the amount that user enter*/
                    double value = usdValue.calculate(a);/**The value that gets from converting. @param double the value*/

                    System.out.println();
                    System.out.printf(" - The amount after conversion is : " + df.format(value) + " ILS"); /**printing the value after conversion and using df.format() method*/
                    System.out.println();

                    /**
                     * loop through all possible value that user enter into a result.txt file.
                     */
                    try {
                        File resultFile = new File("result.txt");/**the file name*/
                        FileWriter writer = new FileWriter(resultFile, true);/**writing the value into the file*/
                        PrintWriter printWriter = new PrintWriter(writer);

                        printWriter.println("Conversion result : " + " Convert " + df.format(amount) + " USD to ILS = " + df.format(value));/**printing the value in the file and using df.format() method*/
                        printWriter.close();
                    } catch (IOException e) {/**catch error file not found*/
                        System.out.println("Error in saveResult");/**print error*/
                    }
                }

                /**
                 * In case user select option 2 its convert Shekel to Dollar,
                 * user will enter an amount and it calculate according to getCoinInstance method from CoinFactory class.
                 */
                case "2" -> {
                    System.out.println(Coins.ILS);/**print user choice*/
                    System.out.println("Please enter an amount to convert");
                    System.out.println();
                    int amount = scanner.nextInt();/**The amount that user want to convert.@param int the amount*/
                    double a = amount;/**widening castin type int amount to type double a*/
                    System.out.printf("The amount is : " + df.format(a) + " ILS convert to $ ");/**printing the amount that user enter and using df.format() method*/
                    double value = ilsValue.calculate(a);/**The value that gets from converting. @param double the value*/

                    System.out.println("- The amount after conversion is : " + df.format(value) + " $"); /**printing the value after conversion and using df.format() method*/

                    /**
                     * loop through all possible value that user enter into a result.txt file.
                     */
                    try {
                        File resultFile = new File("result.txt");/**the file name*/
                        FileWriter writer = new FileWriter(resultFile, true);/**writing the value into the file*/
                        PrintWriter printWriter = new PrintWriter(writer);

                        printWriter.println("Conversion result : " + " Convert " + df.format(amount) + " ILS to USD = " + df.format(value));/**printing the value in the file and using df.format() method*/
                        printWriter.close();
                    } catch (IOException e) {/**catch error file not found*/
                        System.out.println("Error in saveResult");/**print error*/
                    }
                }

                /**
                 * In case user select option 2 its convert Shekel to Euro,
                 * user will enter an amount and it calculate according to getCoinInstance method from CoinFactory class.
                 */
                case "3" -> {
                    System.out.println(Coins.EUR);
                    System.out.println("Please enter an amount to convert");
                    System.out.println();
                    int amount = scanner.nextInt();
                    double a = amount;/**widening castin type int amount to type double a*/
                    System.out.printf("The amount is : " + df.format(a) + " ILS convert to EUR ");/**printing the amount that user enter and using df.format() method*/
                    double value = eurValue.calculate(a);/**The value that gets from converting. @param double the value*/

                    System.out.println("- The amount after conversion is : " + df.format(value) + " EUR");/**printing the value after conversion and using df.format() method*/

                    /**
                     * loop through all possible value that user enter into a result.txt file.
                     */
                    try {
                        File resultFile = new File("result.txt");/**the file name*/
                        FileWriter writer = new FileWriter(resultFile, true);/**writing the value into the file*/
                        PrintWriter printWriter = new PrintWriter(writer);

                        printWriter.println("Conversion result : " + " Convert " + df.format(amount) + " ILS to EUR = " + df.format(value));/**printing the value in the file and using df.format() method*/
                        printWriter.close();
                    } catch (IOException e) {/**catch error file not found*/
                        System.out.println("Error in saveResult");/**print error*/
                    }
                }

            }

            System.out.println();
            System.out.println("Whould you like to start over? Y or N");//**option for user to start over*/
            answer = scanner.next();//**@param answer*/

        }


        while (answer.equalsIgnoreCase("Y"));//**@param answer , user answer Y to start over, using equalsIgnoreCase()method*/
        while (answer.equalsIgnoreCase("N")) {//**@param answer , user answer N to end, using equalsIgnoreCase()method*/


            System.out.println("Thanks for using our currency converter .");//**printing titel in end using currency converter*/
            System.out.println();


            File file = new File("result.txt");//**result file will open in the end*/
            Scanner input = new Scanner(file);
            try {

                while (input.hasNext()) {//**list will enter into the file*/
                    String list = input.nextLine();
                    System.out.println(list);
                }

                if (!Desktop.isDesktopSupported()) {//**if user's desktop support file type, using isDesktopSupported() method*/
                    System.out.println("Desktop is not supported");//**message if user's desktop is not support file type*/
                    return;
                }
                Desktop desktop = Desktop.getDesktop();
                if (file.exists()) desktop.open(file);//**if exists file will open i*/

                System.exit(0);//**close system*/

            }catch (Exception e){
                System.out.println("file can not open");//**catch error*/


            }

        }

    }
}

