package ru.ibs.spring.exception;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;

public class FuelException {

    @Pointcut("@annotation(ru.ibs.spring.exception.FuelExceptionHandle)")
    public void callAtBusinessMethods() {}

    @Around("callAtBusinessMethods")
    public String fuelExceptionThrower(ProceedingJoinPoint pjp) throws Throwable {

        try {
            pjp.proceed();
        } catch (Exception e) {
            return "error";
        }
        return null;
    }
}
