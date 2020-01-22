/*
 * Copyright (c) 2003, Oracle and/or its affiliates. All rights reserved.
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



package java.util;


/**
 * Unchecked exception thrown when a conversion and flag are incompatible.
 *
 * <p> Unless otherwise specified, passing a <tt>null</tt> argument to any
 * method or constructor in this class will cause a {@link java.lang.NullPointerException NullPointerException} to be thrown.
 *
 * @since 1.5
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class FormatFlagsConversionMismatchException extends java.util.IllegalFormatException {

/**
 * Constructs an instance of this class with the specified flag
 * and conversion.
 *
 * @param  f
 *         The flag
 *
 * @param  c
 *         The conversion
 * @apiSince 1
 */

public FormatFlagsConversionMismatchException(java.lang.String f, char c) { throw new RuntimeException("Stub!"); }

/**
 * Returns the incompatible flag.
 *
 * @return  The flag
 * @apiSince 1
 */

public java.lang.String getFlags() { throw new RuntimeException("Stub!"); }

/**
 * Returns the incompatible conversion.
 *
 * @return  The conversion
 * @apiSince 1
 */

public char getConversion() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.lang.String getMessage() { throw new RuntimeException("Stub!"); }
}

