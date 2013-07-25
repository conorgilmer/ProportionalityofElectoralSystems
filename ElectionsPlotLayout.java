import java.awt.*;
//import java.io.*;

//----------------------------------------------------------
// ElectionsPlotLayout implements the interface LayoutManager
// & is used by ContourPlotApplet to lay out its components.
//----------------------------------------------------------
public class ElectionsPlotLayout
	extends		java.lang.Object
	implements	java.awt.LayoutManager {

	// Below, constant data members:
	private static final int COUNT = ElectionApplet.NUMBER_COMPONENTS;
	private static final int
		MARGIN		=   5,
		MIN_PLOT_DIMEN	= 300,
		LEFT_WIDTH	= 250,
		CBOX_WIDTH	= 130,
		BUTTON_H_POS	= MARGIN + CBOX_WIDTH + MARGIN,
		BUTTON_WIDTH	= LEFT_WIDTH - CBOX_WIDTH - MARGIN,
		LINE_HEIGHT	= 25,
		DATA_HEIGHT	= 25,
		MIN_RES_HEIGHT	=  50,
		DATA_V_POS	= MARGIN + MARGIN + LINE_HEIGHT,
		BUTTON_V_POS	= DATA_V_POS + MARGIN + DATA_HEIGHT,
		RESULTS_V_POS	= BUTTON_V_POS + MARGIN + LINE_HEIGHT + LINE_HEIGHT + LINE_HEIGHT ;
		//RESULTS_V_POS	= BUTTON_V_POS + MARGIN + LINE_HEIGHT + LINE_HEIGHT + LINE_HEIGHT + LINE_HEIGHT + LINE_HEIGHT;

	// Below, data members: the array of components, the
	// dimensions of the contour plot component and the
	// height of the results area.
	Component k[]		= new Component[COUNT];
	Dimension d		= new Dimension(MIN_PLOT_DIMEN, MIN_PLOT_DIMEN);
	int results_height	= MIN_RES_HEIGHT;

	//-------------------------------------------------------
	// "addLayoutComponent" is necessary to override the
	// corresponding abstract method in "LayoutManager".
	//-------------------------------------------------------
	public void addLayoutComponent(String name, Component c)
	{
		if (name.equals("thePlot")) {
			c.reshape(2*MARGIN+LEFT_WIDTH, MARGIN, d.width, d.height);
			addComponentNumber(0,c);
		}
		else if (name.equals("thePie")) {
			c.reshape(2*MARGIN+LEFT_WIDTH, MARGIN, d.width, d.height);
			addComponentNumber(0,c);
		}
		else if (name.equals("selectLabel")) {
			c.reshape(MARGIN, MARGIN, LEFT_WIDTH, LINE_HEIGHT);
			addComponentNumber(1,c);
		}
		else if (name.equals("Years")) {
			c.reshape(MARGIN, BUTTON_V_POS, CBOX_WIDTH, LINE_HEIGHT);
			addComponentNumber(2,c);
		}
		//else if (name.equals("zField")) {
		//	c.reshape(MARGIN, DATA_V_POS, LEFT_WIDTH, DATA_HEIGHT);
		//	addComponentNumber(2,c);
		//}
//		else if (name.equals("interBox")) {
//			c.reshape(MARGIN, BUTTON_V_POS, CBOX_WIDTH, LINE_HEIGHT);
//			addComponentNumber(3,c);
//		}
	else if (name.equals("seatsBtn")) {
			c.reshape(BUTTON_H_POS, BUTTON_V_POS, BUTTON_WIDTH, LINE_HEIGHT);
			addComponentNumber(3,c);
		}

		else if (name.equals("bonusBtn")) {
			c.reshape(BUTTON_H_POS, BUTTON_V_POS, BUTTON_WIDTH, LINE_HEIGHT);
			addComponentNumber(4,c);
		}
		else if (name.equals("prBtn")) {
			c.reshape(BUTTON_H_POS, BUTTON_V_POS, BUTTON_WIDTH, LINE_HEIGHT);
			addComponentNumber(5,c);
		}
		else if (name.equals("pcBtn")) {
			c.reshape(BUTTON_H_POS, BUTTON_V_POS, BUTTON_WIDTH, LINE_HEIGHT);
			addComponentNumber(6,c);
		}
		else if (name.equals("prcompBtn")) {
			c.reshape(BUTTON_H_POS, BUTTON_V_POS, BUTTON_WIDTH, LINE_HEIGHT);
			addComponentNumber(7,c);
		}
		else if (name.equals("dhsBtn")) {
			c.reshape(BUTTON_H_POS, BUTTON_V_POS, BUTTON_WIDTH, LINE_HEIGHT);
			addComponentNumber(8,c);
		}
		else if (name.equals("dhpBtn")) {
			c.reshape(BUTTON_H_POS, BUTTON_V_POS, BUTTON_WIDTH, LINE_HEIGHT);
			addComponentNumber(9,c);
		}
		else if (name.equals("cabseatsLabel")) {
			c.reshape(BUTTON_H_POS, BUTTON_V_POS, BUTTON_WIDTH, LINE_HEIGHT);
			addComponentNumber(10,c);
		}
		else if (name.equals("cabSeats")) {
			c.reshape(BUTTON_H_POS, BUTTON_V_POS, BUTTON_WIDTH, LINE_HEIGHT);
			addComponentNumber(11,c);
		}
		else if (name.equals("results")) {
			c.reshape(MARGIN, RESULTS_V_POS, LEFT_WIDTH, results_height);
			addComponentNumber(12,c);
		}
//	throw new SomeKindOfException("Attempt to add an invalid component");
	}

	//-------------------------------------------------------
	// "GetDimensions" computes the data members "d" and
	// "results_height" which are the only dimensions in the
	// layout which are not fixed.
	//-------------------------------------------------------
	public void GetDimensions(Container  parent) {
		d = parent.size();
		d.width = d.width - LEFT_WIDTH - 3*MARGIN;
		d.height = d.height - 2*MARGIN;
		if (d.width < MIN_PLOT_DIMEN) d.width = MIN_PLOT_DIMEN;
		if (d.height < MIN_PLOT_DIMEN) d.height = MIN_PLOT_DIMEN;
		if (d.width > d.height) d.width = d.height;
		else if (d.height > d.width) d.height = d.width;
		results_height = d.height + MARGIN - RESULTS_V_POS - 125;
		if (results_height < MIN_RES_HEIGHT) results_height = MIN_RES_HEIGHT;
	}

	//-------------------------------------------------------
	// "addComponentNumber" adds a component given its index
	// and is a utility routine used by "addLayoutComponent".
	//-------------------------------------------------------
	public void addComponentNumber(int i, Component c) {
		if ((i < 0) || (i >= COUNT)) {
			throw new ArrayIndexOutOfBoundsException();
		}
		else if (k[i] != null) {
//		throw new SomeKindOfException(
//			"Attempt to add a component already added");
		}
		else k[i] = c;
	}

	//-------------------------------------------------------
	// "layoutContainer" is necessary to override the
	// corresponding abstract method in "LayoutManager".
	//-------------------------------------------------------
	public void layoutContainer(Container	parent) {
		GetDimensions(parent);
		if (k[0] != null) k[0].reshape
			(2*MARGIN+LEFT_WIDTH,MARGIN,d.width,d.height);
		if (k[1] != null) k[1].reshape
			(MARGIN, MARGIN,LEFT_WIDTH,LINE_HEIGHT);
		if (k[2] != null) k[2].reshape
			(MARGIN, DATA_V_POS,LEFT_WIDTH,DATA_HEIGHT);
		if (k[3] !=null) k[3].reshape
			(MARGIN,BUTTON_V_POS,CBOX_WIDTH,LINE_HEIGHT);
		if (k[4] != null) k[4].reshape
			(BUTTON_H_POS,BUTTON_V_POS, BUTTON_WIDTH,LINE_HEIGHT);
		if (k[5] != null) k[5].reshape
			(MARGIN, BUTTON_V_POS + LINE_HEIGHT, CBOX_WIDTH,LINE_HEIGHT);
		if (k[6] != null) k[6].reshape
			(BUTTON_H_POS,BUTTON_V_POS + LINE_HEIGHT, BUTTON_WIDTH,LINE_HEIGHT);
		if (k[7] != null) k[7].reshape
			(MARGIN, BUTTON_V_POS + LINE_HEIGHT + LINE_HEIGHT, CBOX_WIDTH + MARGIN + BUTTON_WIDTH,LINE_HEIGHT);
		if (k[8] != null) k[8].reshape
			(BUTTON_H_POS,BUTTON_V_POS + LINE_HEIGHT + LINE_HEIGHT + LINE_HEIGHT + LINE_HEIGHT + RESULTS_V_POS + 50, BUTTON_WIDTH, LINE_HEIGHT);
		if (k[9] != null) k[9].reshape
			(MARGIN, BUTTON_V_POS + LINE_HEIGHT + LINE_HEIGHT + LINE_HEIGHT + LINE_HEIGHT + RESULTS_V_POS + 50, CBOX_WIDTH, LINE_HEIGHT);
		if (k[10] != null) k[10].reshape
			(MARGIN, BUTTON_V_POS + LINE_HEIGHT + LINE_HEIGHT + LINE_HEIGHT + RESULTS_V_POS + 50, CBOX_WIDTH, LINE_HEIGHT);
		if (k[11] != null) k[11].reshape
			(BUTTON_H_POS, BUTTON_V_POS + LINE_HEIGHT + LINE_HEIGHT + LINE_HEIGHT + RESULTS_V_POS + 50, BUTTON_WIDTH, LINE_HEIGHT);
		if (k[12] != null) k[12].reshape
			(MARGIN,RESULTS_V_POS,LEFT_WIDTH,results_height);
	}

	//-------------------------------------------------------
	// "minimumLayoutSize" is necessary to override the
	// corresponding abstract method in "LayoutManager".
	//-------------------------------------------------------
	public Dimension minimumLayoutSize(Container  parent) {
		return new Dimension(
			3*MARGIN + LEFT_WIDTH + MIN_PLOT_DIMEN,
			2*MARGIN + MIN_PLOT_DIMEN);
	}

	//-------------------------------------------------------
	// "preferredLayoutSize" is necessary to override the
	// corresponding abstract method in "LayoutManager".
	//-------------------------------------------------------
	public Dimension preferredLayoutSize(Container	parent) {
		GetDimensions(parent);
		return new Dimension(3*MARGIN + d.width + LEFT_WIDTH,
			2*MARGIN + d.height);
	}

	//-------------------------------------------------------
	// "removeLayoutComponent" is necessary to override the
	// corresponding abstract method in "LayoutManager".
	//-------------------------------------------------------
	public void removeLayoutComponent(Component	c) {
		for (int i = 0; i < COUNT; i++) if (c == k[i]) k[i] = null;
	}
}

