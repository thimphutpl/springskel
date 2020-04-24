/**
 * Created by jigme.dorji on 23/04/2020.
 */
package dhi.ca.ttpl.web.aop;
import org.aspectj.lang.ProceedingJoinPoint;

public class LoggingAspect {


    public Object logAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String className = proceedingJoinPoint.getTarget().getClass().getName();
        String methodName = proceedingJoinPoint.getSignature().getName();

        //  System.out.println("=============start *****");
        //log.info("********************************************* start" + methodName);
        long startTime = System.currentTimeMillis();
        Object object = proceedingJoinPoint.proceed();
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        //log.info("********************************************* End" + methodName);

        //log.info(className + ":" + methodName + " " + "Time taken to execute: " + executionTime + " ms");
        //   System.out.println("=============end *****");

        long maximumExecutionTIme = 20000;  // 20 milliseconds
        if (maximumExecutionTIme < executionTime) {
            //log.info(className + ":" + methodName + " " + "Time taken to more than 20 milliSeconds: " + executionTime + " ms");

        }

        return object;
    }

  /*  Workable and tested code.Don't Delete*/
    /*public void logBefore(JoinPoint joinPoint){
        System.out.println("Before............Start......."+joinPoint.getSignature().getName());
    }

    public void logAfter(JoinPoint joinPoint){
        System.out.println("After...............End...."+joinPoint.getSignature().getName());
    }


    public void logAfterReturning(JoinPoint joinPoint){
        System.out.println("return result......."+joinPoint.getSignature().getName());
    }

    public void addCustomerThrowException(JoinPoint joinPoint,Throwable error){
        System.out.println("===========================THis is error==================================");
        System.out.println("Exception : " + error.getCause());
        System.out.println("===========================THis is error==================================" + error.getMessage());
        System.out.println("Test-----------------------------------start");
         error.printStackTrace();
        System.out.println("Test-----------------------------------end");
    }*/

     /* End  Workable and tested code.Don't Delete*/
}
