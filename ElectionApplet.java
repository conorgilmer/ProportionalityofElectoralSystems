/* ElectionApplet.java
 * Plot a Bar Chart for election results
 * Layout uses ElectionsPlotLayout.java
 * Chart Plotted by BarPlot.java
 * Called by ElectionsApplet.html
 *
 *
 * by Conor Gilmer (cgilmer@tinet.ie)
 */
import java.awt.*;
import java.io.*;

//----------------------------------------------------------
// "ElectionApplet" is the main class, i.e. the applet
// which is a container for all the user-interface elements.
//----------------------------------------------------------
public class ElectionApplet extends java.applet.Applet {

	private static final long serialVersionUID = 5609007611332443510L;
	// Below, constants, i.e. "final static" data members:
	final static int NUMBER_COMPONENTS	= 13;
	final static int MIN_X_STEPS =   2,
			 MIN_Y_STEPS =   2,
			 MAX_X_STEPS = 100,
			 MAX_Y_STEPS = 100;
	final static String EOL	= System.getProperty("line.separator");
	final static String DEFAULT_Z	= " Elections Bounce";
	String selection = "1992"; // default year
	String parl = "Dáil "; // default year
	int numbercols = 8;
	int executiveseats = 12;
        double reps = 166.0; // default number of TD's in the Dail

        //2010 Election Data
	double[] seats2010 =  new double[]  {306, 258, 57, 29};
	double[] percent2010 =  new double[]{36.1, 29.0, 23.0, 11.9};
	double[] bounce2010 = new double[]  {-7.35, 9.68, 4.89, -1.8,};
	String[] lang2010 = {"Con","Lab","Lib Dem", "Others"};
	Color[] partyc2010 = {Color.blue,Color.red.brighter(), Color.orange, Color.cyan};

//2011 Election Data
	double[] seats2011ni =  new double[]  {16, 38, 14, 29, 8, 1,1,1};
	double[] percent2011ni =  new double[]{12.9, 29.3, 13.9, 26.3, 7.7, 2.4, 0.9, 6.6};
	double[] bounce2011ni = new double[]  {8,7,6,5,4,3,2,1 };
	String[] lang2011ni = {"UUP","DUP","SDLP", "SF","Alliance", "TUV", "Green", "Ind"};
	Color[] partyc2011ni = {Color.blue,Color.blue.darker(),Color.red.brighter(), Color.green.darker(), Color.yellow, Color.magenta, Color.green.brighter(), Color.cyan};

        //2011 Election Data
	double[] seats2011 =  new double[]  {20, 76, 37, 14, 0, 5, 14};
	double[] percent2011 =  new double[]{17.4, 36.1, 19.4, 9.9, 1.8, 2.2, 13.2};
	double[] bounce2011 = new double[]  {-7.35, 9.68, 4.89, -1.47, -1.8, 0.51, -4.47};
	String[] lang2011 = {"FF","FG","LAB", "SF","Green", "ULA","Ind"};
	Color[] partyc2011 = {Color.green.darker(),Color.blue,Color.red.brighter(), Color.cyan.darker(), Color.green, Color.red.darker(), Color.yellow};

        //2007 Election Data
        double[] seats2007   =  new double[]{78, 51, 20, 4, 6, 2, 5};
	double[] percent2007 =  new double[]{41.6, 27.3, 10.1,6.9, 4.7, 2.7, 6.7};
	String[] lang2007    = {"FF","FG","LAB", "SF","Green", "PD" ,"Ind"};
	Color[] partyc2007   = {Color.green.darker(),Color.blue,Color.red, Color.cyan.darker(), Color.green, Color.blue.darker(), Color.yellow};
	double[] bounce2007  = new double[]{5.39, 3.42, 1.95, -4.49,-1.09, -1.5, -3.59};

        //2002 Election Data
        double[] seats2002   =  new double[]{81, 32, 20, 5, 1, 6, 8, 13};
	double[] percent2002 =  new double[]{41.5, 22.5, 10.8, 6.5, 0.8, 3.8, 4.0, 9.9};
	double[] bounce2002  = new double[]{7.2, -4, 1.2, -3.5,-0.2, -0.2, 0.8, 1.7};
	String[] lang2002    = {"FF","FG","LAB", "SF","SP", "Green", "PD", "Ind"};
	Color[] partyc2002   = {Color.green.darker(), Color.blue, Color.red, Color.cyan.darker(), Color.red.darker(), Color.green, Color.blue.darker(), Color.yellow};

        //1997 Election Data
        double[] seats1997   =  new double[]{77, 54, 17, 1, 4, 2, 4, 7};
	double[] percent1997 =  new double[]{39.3, 27.9, 10.4, 2.5, 2.5, 2.8, 4.7, 9.9};
	double[] bounce1997  = new double[]{7.1, 4.6, -0.2, -1.9,-0.1, -1.6, -2.3, -4.31};
	String[] lang1997    = {"FF","FG","LAB", "SF","DL", "Green", "PD", "Ind/SP"};
	Color[] partyc1997   = {Color.green.darker(), Color.blue, Color.red, Color.cyan.darker(), Color.orange, Color.green, Color.blue.darker(), Color.yellow};

        //1992 Election Data
        double[] seats1992   =  new double[]{68, 45, 33, 0, 4, 1, 10, 5};
	double[] percent1992 =  new double[]{39.1, 24.5, 19.9, 1.6, 2.4, 1.4, 4.7, 6.7};
	double[] bounce1992  = new double[]{1.8, 2.6, 0.3, -1.6, -0.4, -0.8, 1.3, -1.2};
	String[] lang1992    = {"FF","FG","LAB", "SF","DL", "Green", "PD", "Ind"};
	Color[] partyc1992   = {Color.green.darker(), Color.blue, Color.red, Color.cyan.darker(), Color.orange, Color.green, Color.blue.darker(), Color.yellow};

	//Default Election is 1992
        double[] seats     = new double[]{68, 45, 33, 0, 4, 1, 10, 5};
	double[] percent   = new double[]{39.1, 24.5, 19.9, 1.6, 2.4, 1.4, 4.7, 6.7};
	double[] bounce    = new double[]{1.8, 2.6, 0.3, -1.6, -0.4, -0.8, 1.3, -1.2};
	String[] lang      = {"FF","FG","LAB", "SF","DL", "Green", "PD", "Ind"};
	Color[] partyc     = {Color.green.darker(), Color.blue, Color.red, Color.cyan.darker(), Color.orange, Color.green, Color.blue.darker(), Color.yellow};
        String graphtitle  = "Dáil Election 1992";


	// Below, the user-interface components:
	BarPlot thePlot	   = new BarPlot(seats, lang, partyc,graphtitle, false);
	Pie3D thePie	   = new Pie3D(seats, lang, partyc,graphtitle, false);
	Label selectLabel  = new Label("", Label.LEFT);
	Label cabseatsLabel  = new Label("Ministers", Label.LEFT);
	TextField cabSeats = new TextField("15");
	Choice	 years 	   = new Choice(); // years of elections
	Button	 bonusBtn  = new Button();
	Button	 seatsBtn  = new Button();
	Button	 prBtn     = new Button();
	Button	 dhpBtn    = new Button();
	Button	 dhsBtn    = new Button();
	Button	 prcompBtn = new Button();
	Button   pcBtn     = new Button();
	TextArea results   = new TextArea(); //text output


	// Below, class data members read from the <APPLET> tag:
	static String	contourValuesTitle,infoStrX,infoStrY,
			errParse,errLog,errComp,errEqual,
			errExpect,errEOF,errBounds;

	//-------------------------------------------------------
	// "init" overrides "super.init()" and initializes the
	// applet by:
	//	1. getting parameters from the <APPLET> tag;
	// 2. setting layout to instance of "ElectionsPlotLayout";
	// 3. initializing and adding the six user-interface
	//		components, using the method "add()" which will
	//		also call "ElectionsPlotLayout.addLayoutComponent()".
	//-------------------------------------------------------
	public void init() {
		infoStrX = getParameter("stringX");
		infoStrY = getParameter("stringY");
	//Election Years Available
  		years.addItem("2011");
  		years.addItem("2011 NI");
  		years.addItem("2010 UK");
		years.addItem("2007");
		years.addItem("2002");
		years.addItem("1997");
		years.addItem("1992");

		setLayout(new ElectionsPlotLayout());
		add("thePlot", thePlot);
		selectLabel.setText(getParameter("select")); // Select election
		add("selectLabel", selectLabel);
		//verbiage.setBackground(Color.white);
		add("Years", years);

		//bonusBtn.setLabel(getParameter("seatbonus"));
		bonusBtn.setLabel("Seat Bonus");
		bonusBtn.setFont(new Font("Helvetica", Font.BOLD, 10));
		bonusBtn.setBackground(Color.white);
		add("bonusBtn", bonusBtn);

		//seatsBtn.setLabel(getParameter("dailseats"));
		seatsBtn.setLabel("Seats won");
		seatsBtn.setFont(new Font("Helvetica", Font.BOLD, 10));
		seatsBtn.setBackground(Color.white);
		add("seatsBtn", seatsBtn);

		prBtn.setLabel("Seats if PR");
		prBtn.setFont(new Font("Helvetica", Font.BOLD, 10));
		prBtn.setBackground(Color.white);
		add("prBtn", prBtn);

		pcBtn.setLabel("Vote (%)");
		pcBtn.setFont(new Font("Helvetica", Font.BOLD, 10));
		pcBtn.setBackground(Color.white);
		add("pcBtn", pcBtn);

		prcompBtn.setLabel("Compare Seats with PR");
		prcompBtn.setFont(new Font("Helvetica", Font.BOLD, 10));
		prcompBtn.setBackground(Color.white);
		add("prcompBtn", prcompBtn);
		add("cabseatsLabel", cabseatsLabel);
		add("cabSeats", cabSeats);

		dhpBtn.setLabel("D'hondt PR");
		dhpBtn.setFont(new Font("Helvetica", Font.BOLD, 10));
		dhpBtn.setBackground(Color.white);
		add("dhpBtn", dhpBtn);

		dhsBtn.setLabel("D'hondt Seats");
		dhsBtn.setFont(new Font("Helvetica", Font.BOLD, 10));
		dhsBtn.setBackground(Color.white);
		add("dhsBtn", dhsBtn);

		results.setEditable(false);
		results.setFont(new Font("Courier", Font.PLAIN, 9));
		results.setBackground(Color.white);
		add("results", results); // text output
	}

	//-------------------------------------------------------
	// Handle events. The only event not handled by the
	// superclass is a mouse hit (i.e. "Event.ACTION_EVENT")
	// in the "Draw" button.
	//-------------------------------------------------------
	@SuppressWarnings("deprecation")
	public boolean handleEvent(Event e) {
		//calculate bonus seats 
		if ((e != null) &&
			(e.id == Event.ACTION_EVENT) &&
			(e.target == bonusBtn)) {
			 
		        int intizedouble = 0;
			double [] prseats = new double[numbercols];
			for (int d=0; d<numbercols; d++){
				intizedouble = (int) Math.round((reps/ 100.0) * percent[d]);
				prseats[d] = (double) intizedouble;
				//prseats[d] =  ((reps/ 100.0) * percent[d]);
				//intizedouble = (int) ((reps/ 100.0) * percent[d]);
				//prseats[d] = (double) intizedouble;
				bounce[d] = (double) (Math.round((seats[d] - prseats[d])));
//				bounce[d] = (double) intizedouble;
			}
			DrawBarPlot(bounce, lang, partyc, "Seat Bonus " + selection, false);

			return true;
		}
		// graph the actual seats won
		else if ((e != null) &&
			(e.id == Event.ACTION_EVENT) &&
			(e.target == seatsBtn)) {
			DrawBarPlot(seats, lang, partyc, parl +" Seats " + selection, false);
			return true;
		}
		// compare PR Seat allocation with actual results 
		else if ((e != null) &&
			(e.id == Event.ACTION_EVENT) &&
			(e.target == prcompBtn)) {

			int intizedouble = 0;
			double [] prseats = new double[numbercols];
			for (int d=0; d < numbercols; d++){
				intizedouble = (int) Math.round((reps/ 100.0) * percent[d]);
				prseats[d] = (double) intizedouble;
			}
			double [] compSeats = new double[numbercols*2];
			String [] compName = new String[numbercols*2];
			Color [] compCol = new Color[numbercols*2];
			int z=0;
			for (int f=0; f < (numbercols); f++){
				compSeats[z] = seats[f];
				compName[z] = lang[f];
				compCol[z] = partyc[f];
				z++;
				compSeats[z] = prseats[f];
				//compName[z] = "("+lang[f]+")";
				compName[z] = " ";
				compCol[z] = (partyc[f]).darker();
				z++;
			}

//			DrawPie(prseats, lang, partyc, "Proportional Dáil Seats " + selection, false);
			DrawBarPlot(compSeats, compName, compCol, "PR Compare " +parl+ "  Seats " + selection, false);
			return true;
		}

			else if ((e != null) &&
			(e.id == Event.ACTION_EVENT) &&
			(e.target == dhpBtn)) {
			//double[] wpercent = percent;
			double[] wpercent = new double[percent.length];
			wpercent = percent;
			executiveseats = Integer.parseInt(cabSeats.getText());
			double[] cabseatsa = CalculateDhondt(wpercent, executiveseats);
			DrawBarPlot(cabseatsa, lang, partyc, "Vote % Seats " + selection , false);
			return true;
		}
		
		else if ((e != null) &&
			(e.id == Event.ACTION_EVENT) &&
			(e.target == dhsBtn)) {
//			double[] wseats = seats;
			double[] wseats = new double[seats.length];
			wseats = seats;
			executiveseats = Integer.parseInt(cabSeats.getText());
			double[] cabseatsb = CalculateDhondt(wseats, executiveseats);
			//double[] cabseatsb = newCalculateDhondt(wseats, executiveseats);
			DrawBarPlot(cabseatsb, lang, partyc, "Vote % Seats " + selection , false);
			return true;
		}
		// PR graph
		else if ((e != null) &&
			(e.id == Event.ACTION_EVENT) &&
			(e.target == prBtn)) {

			int intizedouble = 0;
			double [] prseats = new double[numbercols];
			for (int d=0; d < numbercols; d++){
				intizedouble = (int) Math.round((reps/ 100.0) * percent[d]);
				prseats[d] = (double) intizedouble;
			}

//			DrawPie(prseats, lang, partyc, "Proportional Dáil Seats " + selection, false);
			DrawBarPlot(prseats, lang, partyc, "Proportional "+parl+" Seats " + selection, false);
			return true;
		}
		//percentage graph
		else if ((e != null) &&
			(e.id == Event.ACTION_EVENT) &&
			(e.target == pcBtn)) {
			DrawBarPlot(percent, lang, partyc, "Vote % Seats " + selection , true);
			return true;
		}
		//Selecting Elections
		else if ((e != null) &&
			(e.id == Event.ACTION_EVENT) &&
			(e.target == years)) {
			selection = years.getSelectedItem();
		        if (selection.equals("2011")) {
			numbercols = lang2011.length;
			lang = lang2011;
			reps = 166.0;
			parl = "Dáil";
			seats=seats2011;			
			percent=percent2011;			
			bounce=bounce2011;			
			partyc = partyc2011;

			DrawBarPlot(seats2011, lang2011, partyc2011, ""+parl+" Seats " +selection , false);
			}

		else if (selection.equals("2011 NI")) {
			numbercols = lang2011ni.length;
			lang = lang2011ni;
			reps = 108.0;
			parl = "Assembly";
			seats=seats2011ni;			
			percent=percent2011ni;			
			bounce=bounce2011ni;			
			partyc = partyc2011ni;

			DrawBarPlot(seats2011ni, lang2011ni, partyc2011ni, parl + " Seats " +selection , false);
			}

	        else if (selection.equals("2007")) {
			numbercols = lang2007.length;
			lang = lang2007;
			reps = 166.0;
			parl ="Dáil";
			seats=seats2007;			
			percent=percent2007;			
			bounce=bounce2007;			
			lang = lang2007;
			partyc = partyc2007;
			DrawBarPlot(seats, lang2007, partyc2007, ""+parl+" Seats " + selection, false);
			}

	        else if (selection.equals("2002")) {
			numbercols = lang2002.length;
			lang = lang2002;
			reps = 166.0;
			parl ="Dáil";
			seats=seats2002;			
			percent=percent2002;			
			bounce=bounce2002;			
			partyc = partyc2002;
			DrawBarPlot(seats2002, lang2002, partyc2002, ""+parl+" Seats " + selection, false);
			}

	        else if (selection.equals("1997")) {
			numbercols = lang1997.length;
			lang = lang1997;
			reps = 166.0;
			parl ="Dáil";
			seats=seats1997;			
			percent=percent1997;			
			bounce=bounce1997;			
			partyc = partyc1997;
//			for (int u=0; u < partyc1997.length; u++){
//			partyc1997[u] = (partyc1997[u]).darker();}

			DrawBarPlot(seats1997, lang1997, partyc1997, ""+parl+" Seats " + selection, false);
			}

	        else if (selection.equals("1992")) {
			numbercols = lang1992.length;
			reps = 166.0;
			parl ="Dáil";
			lang = lang1992;
			seats=seats1992;			
			percent=percent1992;			
			bounce=bounce1992;			
			partyc = partyc1992;
			DrawBarPlot(seats1992, lang1992, partyc1992, ""+parl+" Seats " + selection, false);
			}
	        else if (selection.equals("2010 UK")) {
			numbercols = lang2010.length;
			lang = lang2010;
			reps = 650.0;
		 	parl ="UK";	
			seats=seats2010;			
			percent=percent2010;			
			bounce=bounce2010;			
			partyc = partyc2010;
			DrawBarPlot(seats2010, lang2010, partyc2010, parl+" 2010 Seats ", false);
			}
			return true;
		}
		else return super.handleEvent(e);
	}


	public double[] newCalculateDhondt(double[] votes, int chairs)
	{

	double [][] dhondtTable = new double [chairs][votes.length];
	System.out.println("Dhondt Table chairs="+chairs+ " parties= " +votes.length+ "\n");
	for (int m = 0; m < chairs; m++) {
		for (int n = 0; n < votes.length; n++) {
			if (m == 0)
				dhondtTable[m][n] = votes[n];
			else
				dhondtTable[m][n] = dhondtTable[0][n]/(m+1);
		}
	}
		
	DrawDhondtTable(dhondtTable, chairs, votes.length);
	
	int wint =0;
	double[] working   = new double[votes.length];
//	working = votes;
	double[] allocated   = new double[votes.length];
	for (int u=0; u<votes.length; u++){
		allocated[u] = 0.0;
		working[u] = votes[u];
	}

	for (int c=0; c <chairs; ) {

		double maxValue = dhondtTable[0][0];
	 	int maxElement = 0;
		for (int sn = 0; sn < votes.length; sn++) {
			for (int sm = 0; sm < chairs; sm++) {
	                System.out.println("("+sn+","+sm+") ");
			if(dhondtTable[sm][sn] > maxValue){
				maxValue = dhondtTable[sm][sn];
				dhondtTable[sm][sn] = 0.0;
				allocated[sn] = allocated[sn] +1;
				c++;
				System.out.println(maxValue+" means Seat "+ c + " for "+sn+ " Seat no " + allocated[sn] +"\n");
			}
		  }
		}
		allocated[wint] = allocated[wint] +1;
	}
	return allocated;
	}

	public void DrawDhondtTable(double [][]dTable ,int pM, int pN) {
		String row = "";;		
		for (int n = 0; n < pN; n++) {
			for (int m = 0; m < pM; m++) {
				row = row + dTable[m][n] +", ";
			}
			row = row + "\n";
		System.out.println(row);
		results.setText(row);

		}
	}

	public double[] CalculateDhondt(double[] votes, int chairs)
	{

	int wint =0;
	double[] working   = new double[votes.length];
//	working = votes;
	double[] allocated   = new double[votes.length];
	for (int u=0; u<votes.length; u++){
		allocated[u] = 0.0;
		working[u] = votes[u];
	}

	for (int c=0; c <chairs; c++) {
		wint = getMaxElement(working);
		working[wint] = (working[wint]/2.0);
		allocated[wint] = allocated[wint] +1;
	}
	return allocated;
	}

	public static int getMaxElement(double[] numbers){
	  double maxValue = numbers[0];
 	  int maxElement = 0;
	  for(int i=1;i < numbers.length;i++){
	    if(numbers[i] > maxValue){
		  maxValue = numbers[i];
		  maxElement = i;
		}
	  }
	  return maxElement;
	}



	/* Draw a Pie Chart - needs work*/
	public void DrawPie(double[] value, String[] partyname, Color[] partycolor, String heading, boolean displaypc) {

		String	s;
		thePie.title = heading;
//		thePie.percentage = displaypc;
		thePie.partynumbers = value;
		thePie.partynames = partyname;
		thePie.partycolours = partycolor;
		thePie.init();
		s = heading;
		// display the value in the results panel with % sign
		for(int n=0; n < lang.length; n++){
			if (displaypc) 
				s = s + "\n" + lang[n] + " = " + value[n] + "%";
			else
				s = s + "\n" + lang[n] + " = " + (int)value[n];
		//System.out.println("is " + s + " no " + n);
		} 
		this.add("thePie",thePie);
		results.setText(s);
	}

	/* "DrawBarPlot" Draws a Bar graph for the double array value
	 * Bars are labled by partyname and colored by party color
	 * the title  will be heading and displaypc will display it as % or Units
	 */
	public void DrawBarPlot(double[] value, String[] partyname, Color[] partycolor, String heading, boolean displaypc) {
		String		s;

		try {
//			System.out.println("length value = " + value.length + "\n");
//			System.out.println("length parties = " + partyname.length + "\n");
//			System.out.println("length colors = " + partycolor.length + "\n");
			thePlot.title = heading;
			thePlot.percentage = displaypc;
			thePlot.value = value;
			thePlot.languages = partyname;
			thePlot.partycolours = partycolor;

			thePlot.paint(thePlot.getGraphics());
//			s = thePlot.ReturnZedMatrix() +
//				contourValuesTitle + EOL +
//				thePlot.GetContourValuesString();
				s = heading;

			for(int n=0; n < lang.length; n++){
				if (displaypc) 
					s = s + "\n" + lang[n] + " = " + value[n] + "%"  ;
				else
					s = s + "\n" + lang[n] + " = " + (int)value[n];
			//System.out.println("is " + s + " no " + n);
			} 

			results.setText(s);
		}
		catch(Exception e) {
			thePlot.repaint();
			results.setText(e.getMessage());
		}
		finally {
			System.out.println("Exiting DrawBarPlot");
		}
	}
}

