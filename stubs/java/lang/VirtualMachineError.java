/*
 * Copyright (c) 1995, 2011, Oracle and/or its affiliates. All rights reserved.
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
 * Thrown to indicate that the Java Virtual Machine is broken or has
 * run out of resources necessary for it to continue operating.
 *
 *
 * @author  Frank Yellin
 * @since   JDK1.0
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class VirtualMachineError extends java.lang.Error {

/**
 * Constructs a <code>VirtualMachineError</code> with no detail message.
 * @apiSince 1
 */

public VirtualMachineError() { throw new RuntimeException("Stub!"); }

/**
 * Constructs a <code>VirtualMachineError</code> with the specified
 * detail message.
 *
 * @param   message   the detail message.
 * @apiSince 1
 */

public VirtualMachineError(java.lang.String message) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a {@code VirtualMachineError} with the specified
 * detail message and cause.  <p>Note that the detail message
 * associated with {@code cause} is <i>not</i> automatically
 * incorporated in this error's detail message.
 *
 * @param  message the detail message (which is saved for later retrieval
 *         by the {@link #getMessage()} method).
 * @param  cause the cause (which is saved for later retrieval by the
 *         {@link #getCause()} method).  (A {@code null} value is
 *         permitted, and indicates that the cause is nonexistent or
 *         unknown.)
 * @since  1.8
 * @apiSince 24
 */

public VirtualMachineError(java.lang.String message, java.lang.Throwable cause) { throw new RuntimeException("Stub!"); }

/**
 * Constructs an a {@code VirtualMachineError} with the specified
 * cause and a detail message of {@code (cause==null ? null :
 * cause.toString())} (which typically contains the class and
 * detail message of {@code cause}).
 *
 * @param  cause the cause (which is saved for later retrieval by the
 *         {@link #getCause()} method).  (A {@code null} value is
 *         permitted, and indicates that the cause is nonexistent or
 *         unknown.)
 * @since  1.8
 * @apiSince 24
 */

public VirtualMachineError(java.lang.Throwable cause) { throw new RuntimeException("Stub!"); }
}

