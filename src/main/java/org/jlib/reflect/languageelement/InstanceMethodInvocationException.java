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

import org.jlib.message.Message;

public class InstanceMethodInvocationException
    extends MethodInvocationException {

    private static final long serialVersionUID = - 7447459566502520725L;
    private final Object enclosingObject;

    public InstanceMethodInvocationException(final Message message, final Object enclosingObject,
                                             final String methodName) {
        super(message.with("enclosingObject", enclosingObject), enclosingObject.getClass().getName(), methodName);

        this.enclosingObject = enclosingObject;
    }

    public Object getEnclosingObject() {
        return enclosingObject;
    }
}
