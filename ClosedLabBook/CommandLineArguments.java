package ClosedLabBook;

public class CommandLineArguments {

	public static void main(String[] args) {
		if (args.length > 0) {
            System.out.println("The command line arguments are:");
            for (String val : args)
                // Printing command line arguments
                System.out.println(val);
        }
        else
            System.out.println("No command line arguments found.");

	}

}
