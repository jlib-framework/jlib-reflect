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
import org.jlib.reflect.reflector_old.ValidatingMethodReturnValue;
import org.jlib.reflect.reflectorfactory.InstanceMethodOverloadFactory;
import org.jlib.reflect.reflectorfactory.MethodReturnValueFactory;
import org.jlib.reflect.reflectorfactory.StaticMethodOverloadFactory;
import org.jlib.reflect.reflectorfactory.TypedClassFactory;
import org.jlib.reflect.reflectorfactory.UntypedClassFactory;

public final class DefaultReflectorFactories {

    public static UntypedClassFactory untypedClassFactory() {
        return DefaultUntypedClass::new;
    }

    public static TypedClassFactory typedClassFactory()
    throws NoSubtypeException {
        return DefaultTypedClass::new;
    }

    public static StaticMethodOverloadFactory staticMethodOverloadFactory() {
        return DefaultStaticMethodOverload::new;
    }

    public static InstanceMethodOverloadFactory instanceMethodFactory() {
        return DefaultInstanceMethodOverload::new;
    }

    public static MethodReturnValueFactory methodReturnValueFactory() {
        return ValidatingMethodReturnValue::new;
    }

    private DefaultReflectorFactories() {}
}