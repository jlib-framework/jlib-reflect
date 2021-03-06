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

package org.jlib.reflect.languageelement.corereflection;

@SuppressWarnings({ "EmptyMethod", "SameReturnValue" })
class ReflectionTestMethods {

    public static void staticVoidEmpty() {}

    public static void staticVoidString(final String s) {}

    public static int staticIntEmpty() { return 42; }

    public static String staticStringInt(final int i) { return String.valueOf(i); }

    public static String staticStringString(final String s) { return s.toUpperCase(); }

    public static String staticStringString(final String s1, final String s2) { return s1 + s2; }

    public void voidEmpty() {}

    public void voidString(final String s) {}

    public int intEmpty() { return 42; }

    public String stringInt(final int i) { return String.valueOf(i); }

    public String stringString(final String s) { return s.toUpperCase(); }

    public String stringString(final String s1, final String s2) { return s1 + s2; }
}
