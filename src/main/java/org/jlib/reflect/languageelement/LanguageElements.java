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
import java.util.List;

import static java.util.stream.Collectors.toList;
import lombok.experimental.UtilityClass;

@UtilityClass
public final class LanguageElements {

    public static void assertReturnTypeInstanceOf(final Executable executable, final Object returnValue,
                                                  final Collection<? extends Class<?>> expectedSuperTypes)
        throws InvalidReturnTypeException {

        final List<Class<?>> invalidSuperTypes =
            expectedSuperTypes.stream()
                              .filter(expectedSuperType -> ! expectedSuperType.isInstance(returnValue))
                              .collect(toList());

        if (! invalidSuperTypes.isEmpty())
            throw new InvalidReturnTypeException(executable, returnValue.getClass(), invalidSuperTypes);
    }

    public static void assertSubtype(final Class<?> actualType, final Collection<? extends Class<?>> expectedSuperTypes)
        throws NoSubtypeException {

        final List<Class<?>> invalidSuperTypes =
            expectedSuperTypes
                .stream()
                .filter(expectedSuperType -> ! (actualType.isPrimitive() && expectedSuperType.equals(Object.class)) &&
                                             ! expectedSuperType.isAssignableFrom(actualType))
                .collect(toList());

        if (! invalidSuperTypes.isEmpty())
            throw new NoSubtypeException(actualType, invalidSuperTypes);
    }
}
