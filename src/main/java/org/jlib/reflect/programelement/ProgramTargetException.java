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

package org.jlib.reflect.programelement;

import org.jlib.core.exception.ApplicationException;
import org.jlib.core.message.Message;

public abstract class ProgramTargetException
extends ApplicationException {

    private static final long serialVersionUID = 2276530860062232111L;

    protected ProgramTargetException() {}

    protected ProgramTargetException(final Message message) {
        super(message);
    }

    protected ProgramTargetException(final Exception cause) {
        super(cause);
    }

    protected ProgramTargetException(final Message message, final Exception cause) {
        super(message, cause);
    }
}
