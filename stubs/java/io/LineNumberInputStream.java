/*
 * Copyright (c) 1995, 2012, Oracle and/or its affiliates. All rights reserved.
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
 * This class is an input stream filter that provides the added
 * functionality of keeping track of the current line number.
 * <p>
 * A line is a sequence of bytes ending with a carriage return
 * character ({@code '\u005Cr'}), a newline character
 * ({@code '\u005Cn'}), or a carriage return character followed
 * immediately by a linefeed character. In all three cases, the line
 * terminating character(s) are returned as a single newline character.
 * <p>
 * The line number begins at {@code 0}, and is incremented by
 * {@code 1} when a {@code read} returns a newline character.
 *
 * @author     Arthur van Hoff
 * @see        java.io.LineNumberReader
 * @since      JDK1.0
 * @deprecated This class incorrectly assumes that bytes adequately represent
 *             characters.  As of JDK&nbsp;1.1, the preferred way to operate on
 *             character streams is via the new character-stream classes, which
 *             include a class for counting line numbers.
 * @apiSince 1
 * @deprecatedSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public class LineNumberInputStream extends java.io.FilterInputStream {

/**
 * Constructs a newline number input stream that reads its input
 * from the specified input stream.
 *
 * @param      in   the underlying input stream.
 * @apiSince 1
 */

@Deprecated
public LineNumberInputStream(java.io.InputStream in) { super(null); throw new RuntimeException("Stub!"); }

/**
 * Reads the next byte of data from this input stream. The value
 * byte is returned as an {@code int} in the range
 * {@code 0} to {@code 255}. If no byte is available
 * because the end of the stream has been reached, the value
 * {@code -1} is returned. This method blocks until input data
 * is available, the end of the stream is detected, or an exception
 * is thrown.
 * <p>
 * The {@code read} method of
 * {@code LineNumberInputStream} calls the {@code read}
 * method of the underlying input stream. It checks for carriage
 * returns and newline characters in the input, and modifies the
 * current line number as appropriate. A carriage-return character or
 * a carriage return followed by a newline character are both
 * converted into a single newline character.
 *
 * @return     the next byte of data, or {@code -1} if the end of this
 *             stream is reached.
 * @exception  java.io.IOException  if an I/O error occurs.
 * @see        java.io.FilterInputStream#in
 * @see        java.io.LineNumberInputStream#getLineNumber()
 * @apiSince 1
 * @deprecatedSince 1
 */

@Deprecated
public int read() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Reads up to {@code len} bytes of data from this input stream
 * into an array of bytes. This method blocks until some input is available.
 * <p>
 * The {@code read} method of
 * {@code LineNumberInputStream} repeatedly calls the
 * {@code read} method of zero arguments to fill in the byte array.
 *
 * @param      b     the buffer into which the data is read.
 * @param      off   the start offset of the data.
 * @param      len   the maximum number of bytes read.
 * @return     the total number of bytes read into the buffer, or
 *             {@code -1} if there is no more data because the end of
 *             this stream has been reached.
 * @exception  java.io.IOException  if an I/O error occurs.
 * @see        java.io.LineNumberInputStream#read()
 * @apiSince 1
 * @deprecatedSince 1
 */

@Deprecated
public int read(byte[] b, int off, int len) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Skips over and discards {@code n} bytes of data from this
 * input stream. The {@code skip} method may, for a variety of
 * reasons, end up skipping over some smaller number of bytes,
 * possibly {@code 0}. The actual number of bytes skipped is
 * returned.  If {@code n} is negative, no bytes are skipped.
 * <p>
 * The {@code skip} method of {@code LineNumberInputStream} creates
 * a byte array and then repeatedly reads into it until
 * {@code n} bytes have been read or the end of the stream has
 * been reached.
 *
 * @param      n   the number of bytes to be skipped.
 * @return     the actual number of bytes skipped.
 * @exception  java.io.IOException  if an I/O error occurs.
 * @see        java.io.FilterInputStream#in
 * @apiSince 1
 * @deprecatedSince 1
 */

@Deprecated
public long skip(long n) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Sets the line number to the specified argument.
 *
 * @param      lineNumber   the new line number.
 * @see #getLineNumber
 * @apiSince 1
 * @deprecatedSince 1
 */

@Deprecated
public void setLineNumber(int lineNumber) { throw new RuntimeException("Stub!"); }

/**
 * Returns the current line number.
 *
 * @return     the current line number.
 * @see #setLineNumber
 * @apiSince 1
 * @deprecatedSince 1
 */

@Deprecated
public int getLineNumber() { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of bytes that can be read from this input
 * stream without blocking.
 * <p>
 * Note that if the underlying input stream is able to supply
 * <i>k</i> input characters without blocking, the
 * {@code LineNumberInputStream} can guarantee only to provide
 * <i>k</i>/2 characters without blocking, because the
 * <i>k</i> characters from the underlying input stream might
 * consist of <i>k</i>/2 pairs of {@code '\u005Cr'} and
 * {@code '\u005Cn'}, which are converted to just
 * <i>k</i>/2 {@code '\u005Cn'} characters.
 *
 * @return     the number of bytes that can be read from this input stream
 *             without blocking.
 * @exception  java.io.IOException  if an I/O error occurs.
 * @see        java.io.FilterInputStream#in
 * @apiSince 1
 * @deprecatedSince 1
 */

@Deprecated
public int available() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Marks the current position in this input stream. A subsequent
 * call to the {@code reset} method repositions this stream at
 * the last marked position so that subsequent reads re-read the same bytes.
 * <p>
 * The {@code mark} method of
 * {@code LineNumberInputStream} remembers the current line
 * number in a private variable, and then calls the {@code mark}
 * method of the underlying input stream.
 *
 * @param   readlimit   the maximum limit of bytes that can be read before
 *                      the mark position becomes invalid.
 * @see     java.io.FilterInputStream#in
 * @see     java.io.LineNumberInputStream#reset()
 * @apiSince 1
 * @deprecatedSince 1
 */

@Deprecated
public void mark(int readlimit) { throw new RuntimeException("Stub!"); }

/**
 * Repositions this stream to the position at the time the
 * {@code mark} method was last called on this input stream.
 * <p>
 * The {@code reset} method of
 * {@code LineNumberInputStream} resets the line number to be
 * the line number at the time the {@code mark} method was
 * called, and then calls the {@code reset} method of the
 * underlying input stream.
 * <p>
 * Stream marks are intended to be used in
 * situations where you need to read ahead a little to see what's in
 * the stream. Often this is most easily done by invoking some
 * general parser. If the stream is of the type handled by the
 * parser, it just chugs along happily. If the stream is not of
 * that type, the parser should toss an exception when it fails,
 * which, if it happens within readlimit bytes, allows the outer
 * code to reset the stream and try another parser.
 *
 * @exception  java.io.IOException  if an I/O error occurs.
 * @see        java.io.FilterInputStream#in
 * @see        java.io.LineNumberInputStream#mark(int)
 * @apiSince 1
 * @deprecatedSince 1
 */

@Deprecated
public void reset() throws java.io.IOException { throw new RuntimeException("Stub!"); }
}

