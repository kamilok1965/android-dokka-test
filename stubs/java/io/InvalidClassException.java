/*
 * Copyright (c) 1996, 2006, Oracle and/or its affiliates. All rights reserved.
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



package java.io;


/**
 * Thrown when the Serialization runtime detects one of the following
 * problems with a Class.
 * <UL>
 * <LI> The serial version of the class does not match that of the class
 *      descriptor read from the stream
 * <LI> The class contains unknown datatypes
 * <LI> The class does not have an accessible no-arg constructor
 * </UL>
 *
 * @author  unascribed
 * @since   JDK1.1
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class InvalidClassException extends java.io.ObjectStreamException {

/**
 * Report an InvalidClassException for the reason specified.
 *
 * @param reason  String describing the reason for the exception.
 * @apiSince 1
 */

public InvalidClassException(java.lang.String reason) { throw new RuntimeException("Stub!"); }

/**
 * Constructs an InvalidClassException object.
 *
 * @param cname   a String naming the invalid class.
 * @param reason  a String describing the reason for the exception.
 * @apiSince 1
 */

public InvalidClassException(java.lang.String cname, java.lang.String reason) { throw new RuntimeException("Stub!"); }

/**
 * Produce the message and include the classname, if present.
 * @apiSince 1
 */

public java.lang.String getMessage() { throw new RuntimeException("Stub!"); }

/**
 * Name of the invalid class.
 *
 * @serial Name of the invalid class.
 * @apiSince 1
 */

public java.lang.String classname;
}

