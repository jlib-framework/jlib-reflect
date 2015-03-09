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

package org.jlib.reflect.reflector_old;

import java.util.function.Supplier;

import org.jlib.reflect.programtarget.reflectorfactory.ReflectorFactory;
import org.jlib.reflect.programtarget.reflectordefaults.DefaultTypedClass;
import org.jlib.reflect.programtarget.reflector.TypedClass;
import org.jlib.reflect.programtarget.reflector.UntypedClass;
import org.jlib.reflect.programtarget.barereflection.ReflectionReflectorFactory;

public final class Reflectors {

    private Reflectors() {}

    public static UntypedClass useClass(final String className) {
        return untypedClasFactory().untypedClassReflector(factory().classLookup(className));
    }

    public static UntypedClass useClass(final Supplier<String> classNameSupplier) {
        return useClass(classNameSupplier.get());
    }

    public static <Value> TypedClass<Value> useClass(final Class<Value> concreteClass) {
        return new DefaultTypedClass<Value>(concreteClass);
    }
}
