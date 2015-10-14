package gov.samhsa.phr.controller;

import gov.samhsa.phr.data.ccda.CCDADocumentResponse;
import gov.samhsa.phr.service.IExHubDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sadhana.chandra on 10/14/2015.
 */

@RestController
public class PatientHealthDataController {
    /** The logger. */
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    IExHubDataService iExHubDataService;

    @RequestMapping(value = "/patientHealthData/{userId}", method = RequestMethod.GET)
    CCDADocumentResponse get(@PathVariable Integer userId){
      //  IExHubData iexHub = new IExHubData();
        return iExHubDataService.GetJson();
    }

    @RequestMapping(value = "/check", method = RequestMethod.GET)
    public String getCheck(){

    String loggerLevel;

    if (logger.isDebugEnabled()) {
        loggerLevel = "Debug";
    } else if (logger.isInfoEnabled()) {
        loggerLevel = "Info";
    } else if (logger.isWarnEnabled()) {
        loggerLevel = "Warn";
    } else {
        loggerLevel = "Error";
    }
        //  IExHubData iexHub = new IExHubData();
    return "<p>This page is used for logging test. And if logback is the logging library, you can request this page serveral times to activate logback configuration changes.</p><hr/>"
				+"<h3>Logger named ["+logger.getName()+ "]</h3>\r\n"+ "<h3>Logger Level is ["+ loggerLevel+ "]</h3>";
//    return "Check!";
    }

}
