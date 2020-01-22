/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */



package java.lang;


/**
 * Thrown when an application tries to create an instance of a class
 * using the {@code newInstance} method in class
 * {@code Class}, but the specified class object cannot be
 * instantiated.  The instantiation can fail for a variety of
 * reasons including but not limited to:
 *
 * <ul>
 * <li> the class object represents an abstract class, an interface,
 *      an array class, a primitive type, or {@code void}
 * <li> the class has no nullary constructor
 *</ul>
 *
 * @author  unascribed
 * @see     java.lang.Class#newInstance()
 * @since   JDK1.0
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class InstantiationException extends java.lang.ReflectiveOperationException {

/**
 * Constructs an {@code InstantiationException} with no detail message.
 * @apiSince 1
 */

public InstantiationException() { throw new RuntimeException("Stub!"); }

/**
 * Constructs an {@code InstantiationException} with the
 * specified detail message.
 *
 * @param   s   the detail message.
 * @apiSince 1
 */

public InstantiationException(java.lang.String s) { throw new RuntimeException("Stub!"); }
}

