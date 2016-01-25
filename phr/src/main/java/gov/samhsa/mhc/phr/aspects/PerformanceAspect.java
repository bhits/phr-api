package gov.samhsa.mhc.phr.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by sadhana.chandra on 12/24/2015.
 */
public class PerformanceAspect extends CallTracker{
    Logger logger = LoggerFactory.getLogger(ExceptionLoggingAspects.class);

    public void trace(ProceedingJoinPoint proceedingJP) throws Throwable {

    }


}
