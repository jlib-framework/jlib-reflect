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

import static org.jlib.core.message.MessageUtility.message;
import org.jlib.reflect.programtarget.InvalidMethodReturnValueException;

public final class Validators {

    public static <ReturnValue>
    MethodReturnValueValidator<ReturnValue> isEqualTo(final ReturnValue expectedReturnValue) {
        return (returnValue, className, methodName) -> {
            if (! expectedReturnValue.equals(returnValue))
                throw new InvalidMethodReturnValueException(message().with("returnValue", returnValue)
                                                                     .with("expectedReturnValue", expectedReturnValue),
                                                            className, methodName);
        };
    }

    public static <ReturnValue>
    MethodReturnValueValidator<ReturnValue> instanceOf(final Class<? extends ReturnValue> expectedType) {
        return (returnValue, className, methodName) -> {
            if (returnValue == null || ! expectedType.isAssignableFrom(returnValue.getClass()))
                throw new InvalidMethodReturnValueException(message().with("returnValue", returnValue)
                                                                     .with("expectedType", expectedType),
                                                            className, methodName);
        };
    }

    private Validators() {}
}