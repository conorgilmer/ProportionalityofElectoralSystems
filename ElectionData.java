import java.io.*;
import java.util.ResourceBundle;


public class ElectionData
{

    private ResourceBundle res = ResourceBundle.getBundle("properties.ElectionData");
    private String electionInfo = new String();

    private static int year=1992;
    private static String outcome = new String(); //winner goverment
    private static String electoralSystem = "STV-PR";
    private static int dailSeats=166;
    private static int numofParties=6;
    double[] seats;
    double[] percent;
    double[] prseats;
    double[] seatbonus;
    String[] parties;
    String heading ="";


    /**
      *Class Constructor
    */
    public ElectionData(double[] eSeats, double[]eVotepc, String[]eParties, String eTitle, String eSystem, int eYear)
    {
    setYear(eYear);
    setParties(eParties.length);
    seats=eSeats;
    percent=eVotepc;
    heading=eTitle;
    }


   public void calculatePRseats(double[] cvotepc, int cseats){
			
	int intizedouble = 0;
	prseats = new double[cvotepc.length];
	for (int d=0; d < cvotepc.length; d++){
		intizedouble = (int) Math.round(((double)cseats/ 100.0) * cvotepc[d]);
		prseats[d] = (double) intizedouble;
	}
   }

   public void calculateBonus (double[] wonSeats, double[] prSeats){
	int intizedouble = 0;
	seatbonus = new double[wonSeats.length];
	for (int d=0; d<wonSeats.length; d++){
		seatbonus[d] = (double) (Math.round((wonSeats[d] - prSeats[d])));
//		bounce[d] = (double) intizedouble;
	}


}

    public void setYear(int syear)
    {
        year=syear;
    }
    public int getYear()
    {
        return year;
    }

    public int getSeats()
    {
        return dailSeats;
    }
    public void setSeats(int sseats)
    {
        dailSeats=sseats;
    }

    public void setParties(int partiesrunning)
    {
        numofParties=partiesrunning;
    }
    public int getParties()
    {
        return numofParties;
    }

    public static String getVersion()
    {
	return new String("$Revision: 35 $ $Date: 5.11.01 10:07 $");
    }

}

