package com.manuboo.pruebaTecnica;



import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TiempoEjecucionAspecto {

	@Around("@annotation(tiempoEjecucion)")
    public Object medirTiempoEjecucion(ProceedingJoinPoint joinPoint, TiempoEjecucion tiempoEjecucion) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        
        long tiempoTotal = endTime - startTime;
        
        System.out.println("Método '" + joinPoint.getSignature().getName() + "' ejecutado en " + tiempoTotal + " ms.");
        
        return result;
    }
}
