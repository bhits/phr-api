package gov.samhsa.mhc.phr.aspect;


import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by sadhana.chandra on 12/24/2015.
 */
@Component
@Aspect
public class ExceptionLoggingAspects extends CallTracker{

    Logger logger = LoggerFactory.getLogger(ExceptionLoggingAspects.class);

    @AfterThrowing(pointcut = "gov.samhsa.mhc.phr.aspect.PhrAspectsArchitecture.Repository() || gov.samhsa.mhc.phr.aspect.PhrAspectsArchitecture.Service()", throwing = "ex")
    public void logException(Exception ex){
        trackCall();
        logger.error("Excecption", ex);
    }

}
