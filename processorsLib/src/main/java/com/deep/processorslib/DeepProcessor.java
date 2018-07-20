package com.deep.processorslib;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;



public class DeepProcessor extends AbstractProcessor{
    @Override
    public synchronized void init(ProcessingEnvironment processingEnvironment) {
        super.init(processingEnvironment);
        System.out.print("----------------@init-----------\n");
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        Set<String> annotataions = new LinkedHashSet<String>();
        System.out.print("----------------@getSupportedAnnotationTypes------"+DeepProcessor.class.getCanonicalName()+"-----\n");
        annotataions.add(DeepAnnotation.class.getCanonicalName());
        annotataions.add(DeepLog.class.getCanonicalName());
        return annotataions;

    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        System.out.print("----------------@getSupportedSourceVersion------"+SourceVersion.latestSupported()+"-----\n");

        return SourceVersion.RELEASE_7;
    }

    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        for (Element element : roundEnvironment.getElementsAnnotatedWith(DeepAnnotation.class)) {
            System.out.print("---------------DeepAnnotation---------------\n");
            // 判断元素的类型为Class
            if (element.getKind() == ElementKind.CLASS) {
                // 显示转换元素类型
                TypeElement typeElement = (TypeElement) element;
                // 输出元素名称
                System.out.println(typeElement.getSimpleName()+"\n");
                System.out.println(typeElement.getSimpleName()+"\n");
                // 输出注解属性值
                System.out.println(typeElement.getAnnotation(DeepAnnotation.class).value()+"\n");
            }

            System.out.print("------------------------------\n");
        }
        for (Element element : roundEnvironment.getElementsAnnotatedWith(DeepLog.class)) {
            System.out.print("---------------DeepLog---------------\n");
            // 判断元素的类型为Class
            if (element.getKind() == ElementKind.FIELD) {
                VariableElement variableElement = (VariableElement) element;
                TypeElement typeElement = (TypeElement) variableElement.getEnclosingElement();
                System.out.print("----------------"+element.getSimpleName().toString()+"--------------\n");
                System.out.print("----------------"+element.getClass().getName()+"--------------\n");
                System.out.print("----------------"+typeElement.getQualifiedName().toString()+"--------------\n");
                DeepLog deepLog = variableElement.getAnnotation(DeepLog.class);
                System.out.print("----------------"+deepLog.toString()+"--------------\n");
                System.out.print("----------------"+ processingEnv.getElementUtils().getPackageOf(typeElement).getQualifiedName().toString()+"--------------\n");
                
                // 显示转换元素类型
                //TypeElement typeElement = (TypeElement) element;
                //// 输出元素名称
                //System.out.println(typeElement.getSimpleName()+"\n");
                //System.out.println(typeElement.getSimpleName()+"\n");
                //// 输出注解属性值
                //System.out.println(typeElement.getAnnotation(DeepAnnotation.class).value()+"\n");
            }

            System.out.print("------------------------------\n");
        }
        return false;
    }
}
