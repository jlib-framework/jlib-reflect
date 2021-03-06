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

import org.jlib.reflect.languageelement.InvalidMethodParameterTypesException;
import org.jlib.reflect.languageelement.NoSubtypeException;

public interface Overload<Exe extends Executable, ReturnValue> {

    TypedMethod0<Exe, ReturnValue> withoutParameters()
        throws InvalidMethodParameterTypesException, NoSubtypeException;

    <Parameter1>
    TypedMethod1<Exe, ReturnValue, Parameter1> withParameterTypes(Class<Parameter1> parameter1Type)
        throws InvalidMethodParameterTypesException, NoSubtypeException;

    <Parameter1, Parameter2>
    TypedMethod2<Exe, ReturnValue, Parameter1, Parameter2> withParameterTypes(Class<Parameter1> parameter1Type,
                                                                              Class<Parameter2> parameter2Type)
        throws InvalidMethodParameterTypesException, NoSubtypeException;

    <Parameter1, Parameter2, Parameter3>
    TypedMethod3<Exe, ReturnValue, Parameter1, Parameter2, Parameter3>
    withParameterTypes(Class<Parameter1> parameter1Type,
                       Class<Parameter2> parameter2Type,
                       Class<Parameter3> parameter3Type)
        throws InvalidMethodParameterTypesException, NoSubtypeException;

    TypedMethodUnchecked<Exe, ReturnValue> withUncheckedParameterTypes(final Class<?>... parameterTypes)
        throws InvalidMethodParameterTypesException, NoSubtypeException;
}
