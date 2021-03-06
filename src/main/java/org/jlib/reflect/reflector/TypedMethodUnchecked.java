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

package org.jlib.reflect.reflector;

import java.lang.reflect.Executable;

import org.jlib.reflect.languageelement.MethodLookupException;

public interface TypedMethodUnchecked<Exe extends Executable, ReturnType>
    extends TypedMethod<Exe, ReturnType> {

    MethodReturn<ReturnType> invoke(Object... arguments)
        throws MethodLookupException;

    <StaticReturnValue>
    TypedMethodUnchecked<Exe, StaticReturnValue> withReturnType(Class<StaticReturnValue> clazz);
}
