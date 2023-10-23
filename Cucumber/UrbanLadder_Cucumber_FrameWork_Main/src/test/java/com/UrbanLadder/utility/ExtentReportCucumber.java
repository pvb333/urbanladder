package com.UrbanLadder.utility;
import java.io.IOException;
import java.util.*;

import com.UrbanLadder.utility.*;

public class ExtentReportCucumber {
	public String getReportConfigPath() throws IOException{
		
		String reportConfigPath = Datadriven.datadriver("extentpath");
		if(reportConfigPath!= null) return reportConfigPath;
		else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");		
	}

}
