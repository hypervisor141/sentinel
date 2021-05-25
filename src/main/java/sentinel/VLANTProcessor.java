package sentinel;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import java.util.Set;

@SupportedAnnotationTypes("vanguard.annotation.VLANTModConstructor")
public class VLANTProcessor extends AbstractProcessor{

    public VLANTProcessor(){

    }

    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment renv){
        for(Element reference : renv.getElementsAnnotatedWith(VLANTModConstructor.class)){
            processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, "This constructor is not meant to be used directly, it is meant for subclasses " +
                    "to use for copy constructors and modifications to superclass functionality.", reference);
        }

        return false;
    }
}
