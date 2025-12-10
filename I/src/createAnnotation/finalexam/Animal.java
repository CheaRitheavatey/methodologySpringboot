package createAnnotation.finalexam;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.aspectj.lang.annotation.*;


// exercise 1: write code for animal type
public class Animal {
    // can also have additional method and data field

    // move
    public void move(String direction) {
        System.out.println("parent class");
    }
}

// exercise 2: class level annoation called example
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Example {}

//exercise 3: create point cut target all method
// hu.pte.example > class * > method *
@Pointcut("execution(* hu.pte.example.*.*.*(..))")
public void applyHere(int parameter){
    System.out.println("function do sth here");
}


// exercise 4: by extending the JpaRepository and using the right naming convention for the method
// exercise 5: for java 9 there are 11 target that can apply to: Annotation  Type,  Constructor,  Field,  Local  Variable,  Method,  Module,
//          Package, Parameter, Type, Type Parameter, Type Use
// exercise 6: finer, finest
// exercise 7: The key unit of modularity in AOP is the aspect
// exercise 8: model is the layer thats responsible for the abstraction of the data source
// exercise 9: tagged interface is an interface which has no member is known as a marker or tagged interface.
// exercise 10: HTTP authentication, API keys, OAuth
// exercise 11: .setFormatter(new SimpleFormatter()), setFormatter(new XMLFormatter())
// exercise 12: yes use interface
// exercise 13: encapsulating the advice and point and use AOP (aspect oriented programming)
// exercise 14: controller, service, model , view
// exercise 15: observer pattern
// exercise 16: yes an interface can extend other interfaces
// exercise 17: false

