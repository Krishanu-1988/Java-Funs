package in.myproject.csvreader;

import java.io.*;


public class CSVRead{

    public static void main(String[] arg)
    {
    	try {
    		//readCSV("");
    		readAllCSV();
		} catch (Exception e) {
			System.out.println(e);
		}
        
    } 
    
    public static void readCSV(String cell) throws Exception
    {
    	BufferedReader CSVFile = new BufferedReader(new FileReader("Example.csv"));

        String dataRow = CSVFile.readLine();
        while (dataRow != null){
            String[] dataArray = dataRow.split(",");
            {
            for (int i=0;i<dataArray.length;i++)
            { 
            	if(dataArray[0].equalsIgnoreCase(cell))
            	{
            		System.out.print(dataArray[i]+"\t");
            	}
            }            
            //System.out.println();
            }
            dataRow = CSVFile.readLine(); 
        }
        CSVFile.close();
        System.out.println();
    }
    
    public static String[] readAllCSV() throws Exception
    {
    	int colIndex=0;
    	String[] col = new String[500];
    	BufferedReader CSVFile = new BufferedReader(new FileReader("Example.csv"));
    	System.out.println("Reading CSV");
        String dataRow = CSVFile.readLine();
        while (dataRow != null){
            String[] dataArray = dataRow.split(",");
            {
            for (int i=0;i<dataArray.length;i++)
            { 
            		col[colIndex]=dataArray[0];

            }
            System.out.println(col[colIndex]);
            System.out.println();
            }
            dataRow = CSVFile.readLine(); 
            colIndex++;
        }
        CSVFile.close();
        System.out.println();
        return col;
    }
} 