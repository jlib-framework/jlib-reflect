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

public abstract class ClassException
    extends ProgramElementException {

    private static final long serialVersionUID = - 8652252161776673093L;

    private final String className;

    public ClassException(final Message message, final String className) {
        super(message.with("class", className));

        this.className = className;
    }

    public ClassException(final Message message, final String className, final Throwable cause) {
        this(message, className);

        initCause(cause);
    }

    public String getClassName() {
        return className;
    }
}
