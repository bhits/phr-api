package gov.samhsa.c2s.phr.aspect;


import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ExceptionLoggingAspects extends CallTracker {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @AfterThrowing(pointcut = "gov.samhsa.c2s.phr.aspect.PhrAspectsArchitecture.Repository() || gov.samhsa.c2s.phr.aspect.PhrAspectsArchitecture.Service()", throwing = "ex")
    public void logException(Exception ex) {
        trackCall();
        logger.error("Exception", ex);
    }
}
