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

package org.jlib.reflect.programtarget.reflectordefaults;

import org.jlib.reflect.programtarget.NoSubtypeException;
import org.jlib.reflect.programtarget.reflector.Overload;
import org.jlib.reflect.programtarget.reflector.UntypedMethod;

public class NonstaticMethod<EnclosingObject>
implements UntypedMethod {

    private final EnclosingObject enclosingObject;
    private final String methodName;

    public NonstaticMethod(final EnclosingObject enclosingObject, final String methodName) {
        this.enclosingObject = enclosingObject;
        this.methodName = methodName;
    }

    @Override
    public <ReturnValue> Overload<ReturnValue> withReturnType(final Class<ReturnValue> returnValueClass)
    throws NoSubtypeException {
        // FIXME: implement
        return null;
    }
}