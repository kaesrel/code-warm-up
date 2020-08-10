import java.io.*;

/**
 * Write a description of class Counter here.
 *
 * @author Chanathip Thumkanon 6210546650
 * @version (a version number or a date)
 */
public class Counter
{
    private int count;
    private double total;
    private BufferedReader reader;
    
    /**
     * Constructor for objects of class Counter
     */
    public Counter()
    {
        count = 0;
        total = 0.0;
    }

    /**
     * Print an error message and exit with exit code 1.
     * @param message the error text to print
     */
    private static void error(String message) {
        System.out.println(message);
        System.exit(1);
    }
    
    /**
     * Reads data values from a file and add them to the sum and count.
     * If the file doesn�t exist then print �File not found: filename� and return. 
     */
    public void readfile(String filename)
    {
        File file = new File(filename);
        if (! file.exists() || ! file.isFile()) error("File not found: "+filename);
        if (! file.canRead()) error(filename+" is not readable");
        try
        {
            reader = new BufferedReader(new FileReader(filename));
            String s;
            while ((s = readOneLine()) != null)
            {
                s = s.trim();
                if (s.length() == 0 || s.startsWith("#"))
                {
                    continue;
                }
                count++;
                total += Double.parseDouble(s);
            }
        }
        catch (IOException ioe) 
        {
            error( ioe.getMessage() );
        }

    }
    
    /**
     * 
     */
    private String readOneLine() 
    {
        try
        {
            String line = reader.readLine();
            return line;
        }
        catch (IOException ex)
        {
            return null;
        }
    }
    
    /**
     * Return the number of values read so far. 
     */
    int getCount() 
    {
        return count;
    }
    
    /**
     * Return the total of values read so far. 
     */
    double getTotal()
    {
        return total;
    }
}
