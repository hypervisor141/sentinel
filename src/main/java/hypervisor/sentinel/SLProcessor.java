package hypervisor.sentinel;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import java.util.Set;

@SupportedAnnotationTypes("hypervisor.sentinel.SLRestrictedConstructor")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class SLProcessor extends AbstractProcessor{

    public SLProcessor(){

    }

    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment renv){
        for(Element reference : renv.getElementsAnnotatedWith(SLRestrictedConstructor.class)){
            processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, "This constructor is not meant to be used directly, it is meant for subclasses " +
                    "to use for copy constructors and modifications to superclass functionality.", reference);
        }

        return false;
    }
}
