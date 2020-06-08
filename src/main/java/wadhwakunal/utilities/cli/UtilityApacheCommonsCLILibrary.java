package wadhwakunal.utilities.cli;

import org.apache.commons.cli.*;

public class UtilityApacheCommonsCLILibrary {
    public static void main(String[] args){
        //Initialize parser to get command line options
        CommandLineParser parser = new DefaultParser();

        //Initialize Options
        Options options = new Options();
        options.addOption("name",true,"First Name");
        options.addOption("surname",true,"Last Name");

        try{
            //Get command line options using parser
            CommandLine cmdLine = parser.parse(options,args);
            if(cmdLine.hasOption("name") && !cmdLine.hasOption("surname")){
                System.out.println("Only name option is available");
                System.out.println("value: "+cmdLine.getOptionValue("name"));
            }else if(!cmdLine.hasOption("name") && cmdLine.hasOption("surname")){
                System.out.println("Only surname option is available");
                System.out.println("value: "+cmdLine.getOptionValue("surname"));
            }else{
                System.out.println("Both name and surname options are available");
                System.out.println("value: "+cmdLine.getOptionValue("name"));
                System.out.println("value: "+cmdLine.getOptionValue("surname"));
            }
        }catch (ParseException exception){
            System.out.println(exception.getMessage());
        }


    }
}
