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

import org.jlib.reflect.programtarget.ClassInstantiationException;

public class ReflectionNamedClassReflector
implements UntypedClassReflector {

    private final String className;

    public ReflectionNamedClassReflector(final String className) {
        this.className = className;
    }

    @Override
    public Class<?> get()
    throws ClassInstantiationException {
        try {
            return Class.forName(className);
        }
        catch (final ClassNotFoundException exception) {
            throw new ClassInstantiationException(className, exception);
        }
    }

    protected String getClassName() {
        return className;
    }

    @Override
    public <Value> TypedClassReflector<Value> withType(final Class<Value> staticType) {
        return new DefaultTypedClassReflector<>(staticType, this);
    }
}