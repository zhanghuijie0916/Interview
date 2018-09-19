package myInterview;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface ILog{
    void record(String[] args);
}

class Log implements ILog{
    @Override
    public void record(String[] args) {
        for (String arg : args){
            System.out.println(arg);
        }
    }
}

class Transaction{
    public void transBefore(){
        System.out.println("事物开启");
    }

    public void transAfter(){
        System.out.println("事物结束");
    }
}

class MyInvokationHandler implements InvocationHandler{
    private Object target;

    public void setTarget(Object target){
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Transaction t = new Transaction();
        t.transBefore();
        method.invoke(target,args);
        t.transAfter();
        return null;
    }
}

public class AopTest {
    public static Object proxyInstance(Object target){
        MyInvokationHandler invokationHandler = new MyInvokationHandler();
        invokationHandler.setTarget(target);
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),invokationHandler);
    }

    public static void main(String[] args){
        ILog target = new Log();
        ILog log = (ILog)proxyInstance(target);
        log.record(new String[]{"A","B","C"});

        String s = "012345";
        char[] array = s.toCharArray();
        for (char c : array){
            System.out.println((int)(c-'0'));
        }
    }
}
