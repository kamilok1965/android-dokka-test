/*
 * Copyright (c) 1996, 2000, Oracle and/or its affiliates. All rights reserved.
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
 * Signals that an unexpected exception has occurred in a static initializer.
 * An <code>ExceptionInInitializerError</code> is thrown to indicate that an
 * exception occurred during evaluation of a static initializer or the
 * initializer for a static variable.
 *
 * <p>As of release 1.4, this exception has been retrofitted to conform to
 * the general purpose exception-chaining mechanism.  The "saved throwable
 * object" that may be provided at construction time and accessed via
 * the {@link #getException()} method is now known as the <i>cause</i>,
 * and may be accessed via the {@link java.lang.Throwable#getCause() Throwable#getCause()} method, as well
 * as the aforementioned "legacy method."
 *
 * @author  Frank Yellin
 * @since   JDK1.1
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ExceptionInInitializerError extends java.lang.LinkageError {

/**
 * Constructs an <code>ExceptionInInitializerError</code> with
 * <code>null</code> as its detail message string and with no saved
 * throwable object.
 * A detail message is a String that describes this particular exception.
 * @apiSince 1
 */

public ExceptionInInitializerError() { throw new RuntimeException("Stub!"); }

/**
 * Constructs a new <code>ExceptionInInitializerError</code> class by
 * saving a reference to the <code>Throwable</code> object thrown for
 * later retrieval by the {@link #getException()} method. The detail
 * message string is set to <code>null</code>.
 *
 * @param thrown The exception thrown
 * @apiSince 1
 */

public ExceptionInInitializerError(java.lang.Throwable thrown) { throw new RuntimeException("Stub!"); }

/**
 * Constructs an ExceptionInInitializerError with the specified detail
 * message string.  A detail message is a String that describes this
 * particular exception. The detail message string is saved for later
 * retrieval by the {@link java.lang.Throwable#getMessage() Throwable#getMessage()} method. There is no
 * saved throwable object.
 *
 *
 * @param s the detail message
 * @apiSince 1
 */

public ExceptionInInitializerError(java.lang.String s) { throw new RuntimeException("Stub!"); }

/**
 * Returns the exception that occurred during a static initialization that
 * caused this error to be created.
 *
 * <p>This method predates the general-purpose exception chaining facility.
 * The {@link java.lang.Throwable#getCause() Throwable#getCause()} method is now the preferred means of
 * obtaining this information.
 *
 * @return the saved throwable object of this
 *         <code>ExceptionInInitializerError</code>, or <code>null</code>
 *         if this <code>ExceptionInInitializerError</code> has no saved
 *         throwable object.
 * @apiSince 1
 */

public java.lang.Throwable getException() { throw new RuntimeException("Stub!"); }

/**
 * Returns the cause of this error (the exception that occurred
 * during a static initialization that caused this error to be created).
 *
 * @return  the cause of this error or <code>null</code> if the
 *          cause is nonexistent or unknown.
 * @since   1.4
 * @apiSince 1
 */

public java.lang.Throwable getCause() { throw new RuntimeException("Stub!"); }
}
