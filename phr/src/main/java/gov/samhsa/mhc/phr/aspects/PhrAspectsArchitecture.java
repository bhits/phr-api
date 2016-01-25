package gov.samhsa.mhc.phr.aspects;

import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by sadhana.chandra on 12/24/2015.
 */
public class PhrAspectsArchitecture {

    @Pointcut("execution(* (@org.springframework.stereotype.Repository *).*(..))")
    public void Repository(){

    }

    @Pointcut("execution(* (@org.springframework.stereotype.Service *).*(..))")
    public void Service(){

    }
}
