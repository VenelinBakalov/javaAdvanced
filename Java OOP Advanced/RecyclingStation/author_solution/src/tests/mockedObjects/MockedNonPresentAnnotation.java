package tests.mockedObjects;

import main.wasteDisposal.annotations.Disposable;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Disposable
@Retention(RetentionPolicy.RUNTIME)
public @interface MockedNonPresentAnnotation {
}
