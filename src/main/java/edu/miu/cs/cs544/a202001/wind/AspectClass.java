package edu.miu.cs.cs544.a202001.wind;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
@Configuration
@Aspect
public class AspectClass {

    private static final Logger LOGGER= LoggerFactory.getLogger(AspectClass.class);

//    @Before("execution(* edu.miu.cs.cs544.a202001.wind.controller.*.*(..))")
//    public void logForAllMethodsBefore(JoinPoint joinPoint){
////        LOGGER.error("=============================================>>>>>>>>>> Before logger from "+ joinPoint.getSignature().getName());
//     //   System.out.println("=============================================>>>>>>>>>> Before logger from "+ joinPoint.getSignature().getName());
//    }

//    @After(value = "execution(* edu.miu.cs.cs544.a202001.wind.controller.*.*(..))")
//    public void logForAllMethodsAfter(JoinPoint joinPoint){
////        LOGGER.info("=============================================>>>>>>>>>> After logger from "+ joinPoint.getSignature().getName());
//      //  System.out.println("=============================================>>>>>>>>>> After logger from "+ joinPoint.getSignature().getName());
//    }
}
