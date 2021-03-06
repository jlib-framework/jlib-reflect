/*
 * jlib - Open Source Java Library
 *
 *     www.jlib.org
 *
 *
 *     Copyright 2005-2018 Igor Akkerman
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */

package org.jlib.reflect.reflector.defaults.overload;

import java.lang.reflect.Constructor;

import org.jlib.reflect.languageelement.InvalidMethodParameterTypesException;
import org.jlib.reflect.languageelement.LanguageElementHandler;
import org.jlib.reflect.languageelement.NoSubtypeException;
import org.jlib.reflect.reflector.ConstructorOverload;
import org.jlib.reflect.reflector.TypedMethod0;
import org.jlib.reflect.reflector.TypedMethod1;
import org.jlib.reflect.reflector.TypedMethod2;
import org.jlib.reflect.reflector.TypedMethod3;
import org.jlib.reflect.reflector.TypedMethodUnchecked;
import org.jlib.reflect.reflector.defaults.invoke.ConstructorInvokeStrategy;
import org.jlib.reflect.reflector.defaults.method.DefaultTypedMethod0;
import org.jlib.reflect.reflector.defaults.method.DefaultTypedMethod1;
import org.jlib.reflect.reflector.defaults.method.DefaultTypedMethod2;
import org.jlib.reflect.reflector.defaults.method.DefaultTypedMethod3;
import org.jlib.reflect.reflector.defaults.method.DefaultTypedMethodUnchecked;

public class DefaultConstructorOverload<EnclosingClassObject>
    extends AbstractOverload<Constructor<EnclosingClassObject>, EnclosingClassObject>
    implements ConstructorOverload<EnclosingClassObject> {

    private static final Class<?>[] NO_PARAMETER_TYPES = {};

    public DefaultConstructorOverload(final LanguageElementHandler languageElementHandler,
                                      final Class<EnclosingClassObject> enclosingClass) {
        super(languageElementHandler, enclosingClass);
    }

    @Override
    public TypedMethod0<Constructor<EnclosingClassObject>, EnclosingClassObject> withoutParameters()
        throws InvalidMethodParameterTypesException, NoSubtypeException {

        final Constructor<EnclosingClassObject> constructor =
            getLanguageElementHandler().lookupConstructor(getReturnValueType(), NO_PARAMETER_TYPES);

        return new DefaultTypedMethod0<>(getLanguageElementHandler(), strategy(constructor));
    }

    @Override
    public <Parameter1>
    TypedMethod1<Constructor<EnclosingClassObject>, EnclosingClassObject, Parameter1> withParameterTypes(
        final Class<Parameter1> parameter1Type)
        throws InvalidMethodParameterTypesException, NoSubtypeException {

        final Constructor<EnclosingClassObject> constructor =
            getLanguageElementHandler().lookupConstructor(getReturnValueType(), parameter1Type);

        return new DefaultTypedMethod1<>(getLanguageElementHandler(), strategy(constructor));
    }

    @Override
    public <Parameter1, Parameter2>
    TypedMethod2<Constructor<EnclosingClassObject>, EnclosingClassObject, Parameter1, Parameter2> withParameterTypes(
        final Class<Parameter1> parameter1Type, final Class<Parameter2> parameter2Type)
        throws InvalidMethodParameterTypesException, NoSubtypeException {

        final Constructor<EnclosingClassObject> constructor =
            getLanguageElementHandler().lookupConstructor(getReturnValueType(), parameter1Type, parameter2Type);

        return new DefaultTypedMethod2<>(getLanguageElementHandler(), strategy(constructor));
    }

    @Override
    public <Parameter1, Parameter2, Parameter3>
    TypedMethod3<Constructor<EnclosingClassObject>, EnclosingClassObject, Parameter1, Parameter2, Parameter3>
    withParameterTypes(
        final Class<Parameter1> parameter1Type, final Class<Parameter2> parameter2Type,
        final Class<Parameter3> parameter3Type)
        throws InvalidMethodParameterTypesException, NoSubtypeException {

        final Constructor<EnclosingClassObject> constructor =
            getLanguageElementHandler().lookupConstructor(getReturnValueType(), parameter1Type, parameter2Type,
                                                          parameter3Type);

        return new DefaultTypedMethod3<>(getLanguageElementHandler(), strategy(constructor));
    }

    @Override
    public TypedMethodUnchecked<Constructor<EnclosingClassObject>, EnclosingClassObject>
    withUncheckedParameterTypes(final Class<?>... parameterTypes)
        throws InvalidMethodParameterTypesException, NoSubtypeException {

        final Constructor<EnclosingClassObject> constructor =
            getLanguageElementHandler().lookupConstructor(getReturnValueType(), parameterTypes);

        return new DefaultTypedMethodUnchecked<>
            (getLanguageElementHandler(), strategy(constructor));
    }

    private ConstructorInvokeStrategy<EnclosingClassObject> strategy(
        final Constructor<EnclosingClassObject> constructor) {

        return new ConstructorInvokeStrategy<>(getLanguageElementHandler(), constructor);
    }
}
