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

package org.jlib.reflect.reflectordefaults.method;

import org.jlib.reflect.programtarget.MethodInvoker;
import org.jlib.reflect.programtarget.MethodLookupException;
import org.jlib.reflect.reflector.MethodReturn;
import org.jlib.reflect.reflector.TypedMethod2;

public class DefaultTypedMethod2<ReturnValue, Argument1, Argument2>
extends AbstractTypedMethod<ReturnValue>
implements TypedMethod2<ReturnValue, Argument1, Argument2> {

    public DefaultTypedMethod2(final MethodInvoker methodInvoker) {
        super(methodInvoker);
    }

    @Override
    @SuppressWarnings("unchecked")
    public MethodReturn<ReturnValue> invoke(final Argument1 argument1, final Argument2 argument2)
    throws MethodLookupException {
        final ReturnValue returnValue = (ReturnValue) getMethodInvoker().invoke(argument1, argument2);

        return methodReturnValue(returnValue);
    }

    @Override
    public <StaticReturnValue>
    TypedMethod2<StaticReturnValue, Argument1, Argument2>
    withReturnType(final Class<StaticReturnValue> staticReturnSuperType) {
        return new DefaultTypedMethod2<>(getMethodInvoker());
    }
}
