package gov.samhsa.mhc.phr.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * Created by sadhana.chandra on 12/24/2015.
 */
@Component
@Aspect
public class PerformanceAspect extends CallTracker{
    Logger logger = LoggerFactory.getLogger(PerformanceAspect.class);

    @Around("gov.samhsa.mhc.phr.aspects.PhrAspectsArchitecture.Repository() ")
    public void trace(ProceedingJoinPoint proceedingJP) throws Throwable {
        String methodInformation = proceedingJP.getStaticPart().getSignature().toString();
        StopWatch stopWatch = new StopWatch(methodInformation);
        stopWatch.start();
        trackCall();
        try {
            proceedingJP.proceed();
        } finally {
            stopWatch.stop();
            logger.trace(stopWatch.shortSummary());
        }
    }


}
