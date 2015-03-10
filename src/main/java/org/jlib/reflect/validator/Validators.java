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

package org.jlib.reflect.validator;

import java.util.Collection;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.jlib.core.message.MessageUtility.message;
import org.jlib.reflect.programtarget.InvalidMethodReturnValueException;
import org.jlib.reflect.programtarget.NoSubtypeException;

public final class Validators {

    public static <ReturnValue>
    MethodReturnValueValidator<ReturnValue> isEqualTo(final ReturnValue expectedReturnValue) {
        return (returnValue, method) -> {
            if (! expectedReturnValue.equals(returnValue))
                throw new InvalidMethodReturnValueException(message().with("returnValue", returnValue)
                                                                     .with("expectedReturnValue", expectedReturnValue),
                                                            method);
        };
    }

    public static <ReturnValue>
    MethodReturnValueValidator<ReturnValue> isInstanceOf(final Class<? extends ReturnValue> expectedType) {
        return (returnValue, method) -> {
            if (returnValue == null || ! expectedType.isAssignableFrom(returnValue.getClass()))
                throw new InvalidMethodReturnValueException(message().with("returnValue", returnValue)
                                                                     .with("expectedType", expectedType),
                                                            method);
        };
    }

    public static MethodReturnValueValidator<Integer> isLessThan(final Integer upperBound) {
        return (returnValue, method) -> {
            if (returnValue >= upperBound)
                throw new InvalidMethodReturnValueException(message().with("returnValue", returnValue)
                                                                     .with("upperBound", upperBound),
                                                            method);
        };
    }

    public static MethodReturnValueValidator<Integer> isGreaterThan(final Integer lowerBound) {
        return (returnValue, method) -> {
            if (returnValue <= lowerBound)
                throw new InvalidMethodReturnValueException(message().with("returnValue", returnValue)
                                                                     .with("lowerBound", lowerBound),
                                                            method);
        };
    }

    public static <ExpectedStaticType>
    TypeValidator hasSupertypes(final Collection<Class<?>> expectedSuperTypes)
    throws NoSubtypeException {
        return actualClass -> {
            final List<Class<?>> invalidSuperTypes =
            expectedSuperTypes.stream()
                              .filter(superType -> ! superType.isAssignableFrom(actualClass))
                              .collect(toList());

            if (! invalidSuperTypes.isEmpty())
                throw new NoSubtypeException(actualClass, invalidSuperTypes);
        };
    }

    private Validators() {}
}
