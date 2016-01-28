package gov.samhsa.mhc.phr.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * Created by sadhana.chandra on 12/30/2015.
 */
@Component
@Aspect
public aspect TracingAspect extends CallTracker{

    Logger logger = LoggerFactory.getLogger(TracingAspect.class);
    //advice
    @Around("gov.samhsa.mhc.phr.aspect.PhrAspectsArchitecture.Repository() || gov.samhsa.mhc.phr.aspect.PhrAspectsArchitecture.Service()")
    public Object trace(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        trackCall();
        String methodInfo = proceedingJoinPoint.getStaticPart().getSignature().toString();
        logger.trace("entering " + methodInfo );

        try {
            return proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            logger.error("Exception in " + methodInfo, throwable);
            throw throwable;
        } finally {
            logger.trace("Exiting " + methodInfo);
        }

    }

}
