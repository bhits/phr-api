package gov.samhsa.c2s.phr.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class PhrAspectsArchitecture {

    @Pointcut("execution(* (@org.springframework.stereotype.Repository *).*(..))")
    public void Repository() {

    }

    @Pointcut("execution(* (@org.springframework.stereotype.Service *).*(..))")
    public void Service() {

    }
}
