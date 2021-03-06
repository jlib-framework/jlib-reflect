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

package org.jlib.reflect.languageelement;

import java.lang.reflect.Executable;

import java.util.Collection;

import static org.jlib.message.Messages.message;

public class InvalidReturnTypeException
    extends MethodInvocationException {

    private static final long serialVersionUID = 6610464823967521411L;

    private final Class<?> returnType;
    private final Collection<? extends Class<?>> expectedReturnValueSuperTypes;

    public InvalidReturnTypeException(final Executable executable, final Class<?> returnType,
                                      final Collection<? extends Class<?>> expectedReturnValueSuperTypes) {
        super(message().with("returnType", returnType)
                       .with("expectedTypes", expectedReturnValueSuperTypes),
              executable.getDeclaringClass().getName(), executable.getName());

        this.returnType = returnType;
        this.expectedReturnValueSuperTypes = expectedReturnValueSuperTypes;
    }

    public InvalidReturnTypeException(final Executable method, final Class<?> returnType,
                                      final Collection<? extends Class<?>> expectedReturnValueSuperTypes,
                                      final Exception cause) {
        this(method, returnType, expectedReturnValueSuperTypes);

        initCause(cause);
    }

    public Class<?> getReturnType() {
        return returnType;
    }

    public Collection<? extends Class<?>> getExpectedReturnValueSuperTypes() {
        return expectedReturnValueSuperTypes;
    }
}
