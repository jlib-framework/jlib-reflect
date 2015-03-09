/*
 * jlib - Open Source Java Library
 *
 *     www.jlib.org
 *
 *
 *     Copyright 2005-2015 Igor Akkerman
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

package org.jlib.reflect.programtarget.reflectordefaults;

import org.jlib.reflect.programtarget.InvalidMethodSignatureException;
import static org.jlib.reflect.programtarget.barereflection.ReflectionFactories.methodLookupFactory;
import org.jlib.reflect.programtarget.reflector.Method0;
import org.jlib.reflect.programtarget.reflector.Method1;
import org.jlib.reflect.programtarget.reflector.Method2;
import org.jlib.reflect.programtarget.reflector.Method3;
import org.jlib.reflect.programtarget.reflector.Overload;
import org.jlib.reflect.reflector_old.UncheckedMethodX;

public class StaticMethodOverload<EnclosingClassObject, ReturnValue>
implements Overload<ReturnValue> {

    private final Class<EnclosingClassObject> enclosingClass;
    private final String methodName;
    private final Class<ReturnValue> returnValueClass;

    public StaticMethodOverload(final Class<EnclosingClassObject> enclosingClass, final String methodName,
                                final Class<ReturnValue> returnValueClass) {
        this.enclosingClass = enclosingClass;
        this.methodName = methodName;
        this.returnValueClass = returnValueClass;
    }

    @Override
    public Method0<ReturnValue> withoutParameters()
    throws InvalidMethodSignatureException {
        return methodFactory().method0(methodLookupFactory().methodLookup(enclosingClass, methodName));
    }

    @Override
    public <Argument1>
    Method1<ReturnValue, Argument1> withParameterTypes(final Class<Argument1> parameter1Type) {
        return methodFactory().method1(methodLookupFactory().methodLookup(enclosingClass, methodName,
                                                                   parameter1Type));
    }

    @Override
    public <Argument1, Argument2>
    Method2<ReturnValue, Argument1, Argument2> withParameterTypes(final Class<Argument1> parameter1Type,
                                                                           final Class<Argument2> parameter2Type) {
        return methodFactory().method2(methodLookupFactory().methodLookup(enclosingClass, methodName,
                                                                   parameter1Type,
                                                                   parameter2Type));
    }

    @Override
    public <Argument1, Argument2, Argument3>
    Method3<ReturnValue, Argument1, Argument2, Argument3>
                                                     /**/ withParameterTypes(final Class<Argument1> parameter1Type,
                                                                             final Class<Argument2> parameter2Type,
                                                                             final Class<Argument3> parameter3Type) {
        return methodFactory().method3(methodLookupFactory().methodLookup(enclosingClass, methodName,
                                                                   parameter1Type,
                                                                   parameter2Type,
                                                                   parameter3Type));
    }

    @Override
    public UncheckedMethodX<ReturnValue> withUncheckedParameterTypes(final Class<?>... parameterTypes) {
        return methodFactory().methodUncheckedParameterTypes(methodLookupFactory().methodLookup(enclosingClass, methodName,
                                                                                         parameterTypes));
    }
}