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

package org.jlib.reflect.reflector.defaults.method;

import java.lang.reflect.Executable;

import org.jlib.reflect.programtarget.MethodInvoker;
import org.jlib.reflect.reflector.MethodReturn;
import org.jlib.reflect.reflector.TypedMethod;
import static org.jlib.reflect.reflector.defaults.DefaultReflectorFactories.methodReturnFactory;
import org.jlib.reflect.reflector.factory.MethodReturnFactory;

public abstract class AbstractTypedMethod<ReturnValue>
implements TypedMethod<ReturnValue> {

    private final MethodInvoker methodInvoker;
    // TODO: use DI
    private final MethodReturnFactory methodReturnFactory = methodReturnFactory();

    protected AbstractTypedMethod(final MethodInvoker methodInvoker) {
        this.methodInvoker = methodInvoker;
    }

    public MethodInvoker getMethodInvoker() {
        return methodInvoker;
    }

    @Override
    public Executable get() {
        return methodInvoker.getMethod();
    }

    public MethodReturn<ReturnValue> methodReturnValue(final ReturnValue returnValue) {
        return methodReturnFactory.methodReturnValue(returnValue, getMethodInvoker());
    }
}