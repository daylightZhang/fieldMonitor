package org.cornell.fieldmonitor.common;


/**
 * based on TreadLocal boxing tool, use it to get CURRENT user id
 * scope: current thread only
 */
public class BaseContext {
    private static ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    /**
     * set id
     * @param id
     */
    public static void setCurrentId(Long id){
        threadLocal.set(id);
    }

    /**
     * get id
     * @return
     */
    public static Long getCurrentId(){
        return threadLocal.get();
    }

}
