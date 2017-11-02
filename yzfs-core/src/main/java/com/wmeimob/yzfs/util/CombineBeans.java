package com.wmeimob.yzfs.util;


import java.lang.reflect.Field;

/**
 * 对象属性合并
 * @author zJun
 *
 */
public class CombineBeans {

	/**
     * 该方法是用于相同对象不同属性值的合并，如果两个相同对象中同一属性都有值，那么sourceBean中的值会覆盖tagetBean重点的值
     * @param sourceBean    被提取的对象bean
     * @param targetBean    用于合并的对象bean
     * @return targetBean,合并后的对象
     */
    public static <T> T combineSydwCore(T sourceBean, T targetBean){
        Class<? extends Object> sourceBeanClass = sourceBean.getClass();
        Class<? extends Object> targetBeanClass = targetBean.getClass();
        
        Field[] sourceFields = sourceBeanClass.getDeclaredFields();
        Field[] targetFields = targetBeanClass.getDeclaredFields();
        for(int i=0; i<sourceFields.length; i++){
            Field sourceField = sourceFields[i]; 
            Field targetField = targetFields[i];  
            sourceField.setAccessible(true);
            targetField.setAccessible(true);
            try {
                if( !(sourceField.get(sourceBean) == null) &&  !"serialVersionUID".equals(sourceField.getName().toString())){
                    targetField.set(targetBean,sourceField.get(sourceBean));
                }
            } catch (IllegalArgumentException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return targetBean;
    }
    
    /**
     * 该方法是用于不同对象同属性值的合并，如果两个对象中同一属性都有值，那么sourceBean中的值会覆盖tagetBean重点的值
     * @param sourceBean
     * @param targetBean
     * @return
     */
    public static <T> T combineSydwCore2(Object sourceBean, T targetBean){
        Class<? extends Object> sourceBeanClass = sourceBean.getClass();
        Class<? extends Object> targetBeanClass = targetBean.getClass();
        
        Field[] sourceFields = sourceBeanClass.getDeclaredFields();
        Field[] targetFields = targetBeanClass.getDeclaredFields();
        for(int i=0; i<sourceFields.length; i++){
            Field sourceField = sourceFields[i];
            
            for(int j=0; j < targetFields.length;j++){
            	Field targetField = targetFields[j];
            	sourceField.setAccessible(true);
                targetField.setAccessible(true);
            	try {
                    if( !(sourceField.get(sourceBean) == null) &&  !"serialVersionUID".equals(sourceField.getName().toString())){
                        if(sourceField.getName().equals(targetField.getName())){
                        	targetField.set(targetBean, sourceField.get(sourceBean));
                        }
                    }
                } catch (IllegalArgumentException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return targetBean;
    }
    
}
