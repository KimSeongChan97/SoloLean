package sample01;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

// 공통 코드
// 이 클래스는 공통 관심 사항을 정의하며, AOP를 사용하여 특정 메서드 실행 전후 또는 실행 중간에 추가 로직을 삽입합니다.
@Aspect
@Component
public class LoggingAdvice {

    // @Before: 타겟 메서드가 실행되기 전에 실행될 로직을 정의합니다.
    // 이 메서드는 MessageBeanImpl 클래스에서 'Before'로 끝나는 public 메서드가 호출되기 전에 실행됩니다.
    @Before("execution(public void sample01.MessageBeanImpl.*Before(..))")
    public void beforeTrace() {
        System.out.println("before trace");
        // AOP가 적용된 메서드가 실행되기 전에 로그를 출력하는 기능을 수행합니다.
    }

    // @After: 타겟 메서드가 실행된 후에 실행될 로직을 정의합니다.
    // 이 메서드는 'After'로 끝나는 메서드가 실행된 후에 실행됩니다.
    @After("execution(public * *.*.*After(..))")
    public void afterTrace() {
        System.out.println("after trace");
        // 메서드가 종료된 후에 "after trace" 메시지를 출력하는 기능을 수행합니다.
    }

    // @Around: 타겟 메서드 실행 전후 또는 실행 중에 추가 로직을 삽입하는 Advice입니다.
    // 이 메서드는 'Print'로 끝나는 메서드의 실행 전후에 실행됩니다.
    @Around("execution(public * *.MessageBeanImpl.*Print(..))")
    public void trace(ProceedingJoinPoint joinPoint) throws Throwable {
        // joinPoint.getSignature().toShortString(): 실행 중인 메서드의 이름과 시그니처를 가져옵니다.
        String methodName = joinPoint.getSignature().toShortString();
        System.out.println("메소드 이름 = " + methodName);

        // StopWatch: 메서드 실행 시간을 측정하기 위한 객체입니다.
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        // joinPoint.proceed(): 타겟 메서드를 실제로 실행하는 부분입니다.
        Object ob = joinPoint.proceed();
        System.out.println("반환값 = " + ob); // 타겟 메서드의 반환값을 출력합니다.

        stopWatch.stop();
        // getTotalTimeMillis(): 메서드 실행에 소요된 시간을 밀리초 단위로 반환합니다.
        System.out.println("처리시간 = " + stopWatch.getTotalTimeMillis() / 1000 + " 초 경과 ");
        // 처리 시간을 초 단위로 변환하여 출력합니다.
    }
}
