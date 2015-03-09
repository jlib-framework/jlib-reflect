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

package org.jlib.reflect.reflectordefaults;

import org.jlib.reflect.programtarget.NoSubtypeException;
import org.jlib.reflect.reflector.TypedOverload;
import org.jlib.reflect.reflector.UntypedOverload;
import static org.jlib.reflect.reflectordefaults.DefaultReflectorFactories.typedStaticMethodOverloadFactory;

public class DefaultUntypedStaticMethodOverload<EnclosingClassObject>
extends DefaultTypedStaticMethodOverload<EnclosingClassObject, Object>
implements UntypedOverload {

    public DefaultUntypedStaticMethodOverload(final Class<EnclosingClassObject> enclosingClass,
                                              final String methodName) {
        super(enclosingClass, methodName, Object.class);
    }

    @Override
    public <ReturnValue> TypedOverload<ReturnValue> withReturnType(final Class<ReturnValue> returnValueClass)
    throws NoSubtypeException {
        return typedStaticMethodOverloadFactory().typedStaticMethodOverload(getEnclosingClass(), getMethodName(),
                                                                            returnValueClass);
    }
}
