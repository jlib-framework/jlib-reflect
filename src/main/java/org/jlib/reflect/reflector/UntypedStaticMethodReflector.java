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

package org.jlib.reflect.reflector;

import org.jlib.reflect.programtarget.NoSubtypeException;

public class UntypedStaticMethodReflector<Enclosing>
implements UntypedMethodReflector {

    private final String staticMethodName;
    private final TypedClassReflector<Enclosing> valueDefaultTypedClassReflector;

    public UntypedStaticMethodReflector(final String staticMethodName,
                                        final TypedClassReflector<Enclosing> valueDefaultTypedClassReflector) {
        this.staticMethodName = staticMethodName;
        this.valueDefaultTypedClassReflector = valueDefaultTypedClassReflector;
    }

    @Override
    public <ReturnValue> MethodOverloadReflector<ReturnValue> withReturnType(final Class<ReturnValue> returnValueClass)
    throws NoSubtypeException {
        return new StaticMethodOverloadReflector<ReturnValue>(returnValueClass);
    }
}