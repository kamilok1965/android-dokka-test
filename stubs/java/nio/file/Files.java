/*
 * Copyright (c) 2007, 2013, Oracle and/or its affiliates. All rights reserved.
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



package java.nio.file;

import java.io.InputStream;
import java.io.IOException;
import java.util.Set;
import java.io.OutputStream;
import java.nio.file.attribute.FileAttribute;
import java.nio.channels.FileChannel;
import java.util.EnumSet;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.channels.SeekableByteChannel;
import java.util.Iterator;
import java.io.File;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileStoreAttributeView;
import java.nio.file.attribute.DosFileAttributes;
import java.nio.file.spi.FileTypeDetector;
import java.util.ServiceLoader;
import java.nio.file.attribute.BasicFileAttributeView;
import java.util.List;
import java.nio.file.attribute.FileAttributeView;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.PosixFileAttributeView;
import java.nio.file.attribute.FileOwnerAttributeView;
import java.nio.file.attribute.UserPrincipal;
import java.nio.file.attribute.FileTime;
import java.io.Reader;
import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
import java.nio.charset.Charset;
import java.io.BufferedWriter;
import java.io.Writer;
import java.io.UncheckedIOException;
import java.util.stream.Stream;
import java.util.function.BiPredicate;

/**
 * This class consists exclusively of static methods that operate on files,
 * directories, or other types of files.
 *
 * <p> In most cases, the methods defined here will delegate to the associated
 * file system provider to perform the file operations.
 *
 * @since 1.7
 * @apiSince 26
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class Files {

private Files() { throw new RuntimeException("Stub!"); }

/**
 * Opens a file, returning an input stream to read from the file. The stream
 * will not be buffered, and is not required to support the {@link java.io.InputStream#mark InputStream#mark} or {@link java.io.InputStream#reset InputStream#reset} methods. The
 * stream will be safe for access by multiple concurrent threads. Reading
 * commences at the beginning of the file. Whether the returned stream is
 * <i>asynchronously closeable</i> and/or <i>interruptible</i> is highly
 * file system provider specific and therefore not specified.
 *
 * <p> The {@code options} parameter determines how the file is opened.
 * If no options are present then it is equivalent to opening the file with
 * the {@link java.nio.file.StandardOpenOption#READ StandardOpenOption#READ} option. In addition to the {@code
 * READ} option, an implementation may also support additional implementation
 * specific options.
 *
 * @param   path
 *          the path to the file to open
 * @param   options
 *          options specifying how the file is opened
 *
 * @return  a new input stream
 *
 * @throws  java.lang.IllegalArgumentException
 *          if an invalid combination of options is specified
 * @throws  java.lang.UnsupportedOperationException
 *          if an unsupported option is specified
 * @throws  java.io.IOException
 *          if an I/O error occurs
 * @throws  java.lang.SecurityException
 *          In the case of the default provider, and a security manager is
 *          installed, the {@link java.lang.SecurityManager#checkRead(java.lang.String) SecurityManager#checkRead(String)}
 *          method is invoked to check read access to the file.
 * @apiSince 26
 */

public static java.io.InputStream newInputStream(java.nio.file.Path path, java.nio.file.OpenOption... options) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Opens or creates a file, returning an output stream that may be used to
 * write bytes to the file. The resulting stream will not be buffered. The
 * stream will be safe for access by multiple concurrent threads. Whether
 * the returned stream is <i>asynchronously closeable</i> and/or
 * <i>interruptible</i> is highly file system provider specific and
 * therefore not specified.
 *
 * <p> This method opens or creates a file in exactly the manner specified
 * by the {@link #newByteChannel(java.nio.file.Path,java.util.Set,java.nio.file.attribute.FileAttribute[]) newByteChannel}
 * method with the exception that the {@link java.nio.file.StandardOpenOption#READ StandardOpenOption#READ}
 * option may not be present in the array of options. If no options are
 * present then this method works as if the {@link java.nio.file.StandardOpenOption#CREATE StandardOpenOption#CREATE}, {@link java.nio.file.StandardOpenOption#TRUNCATE_EXISTING StandardOpenOption#TRUNCATE_EXISTING},
 * and {@link java.nio.file.StandardOpenOption#WRITE StandardOpenOption#WRITE} options are present. In other
 * words, it opens the file for writing, creating the file if it doesn't
 * exist, or initially truncating an existing {@link #isRegularFile
 * regular-file} to a size of {@code 0} if it exists.
 *
 * <p> <b>Usage Examples:</b>
 * <pre>
 *     Path path = ...
 *
 *     // truncate and overwrite an existing file, or create the file if
 *     // it doesn't initially exist
 *     OutputStream out = Files.newOutputStream(path);
 *
 *     // append to an existing file, fail if the file does not exist
 *     out = Files.newOutputStream(path, APPEND);
 *
 *     // append to an existing file, create file if it doesn't initially exist
 *     out = Files.newOutputStream(path, CREATE, APPEND);
 *
 *     // always create new file, failing if it already exists
 *     out = Files.newOutputStream(path, CREATE_NEW);
 * </pre>
 *
 * @param   path
 *          the path to the file to open or create
 * @param   options
 *          options specifying how the file is opened
 *
 * @return  a new output stream
 *
 * @throws  java.lang.IllegalArgumentException
 *          if {@code options} contains an invalid combination of options
 * @throws  java.lang.UnsupportedOperationException
 *          if an unsupported option is specified
 * @throws  java.io.IOException
 *          if an I/O error occurs
 * @throws  java.lang.SecurityException
 *          In the case of the default provider, and a security manager is
 *          installed, the {@link java.lang.SecurityManager#checkWrite(java.lang.String) SecurityManager#checkWrite(String)}
 *          method is invoked to check write access to the file. The {@link java.lang.SecurityManager#checkDelete(java.lang.String) SecurityManager#checkDelete(String)} method is
 *          invoked to check delete access if the file is opened with the
 *          {@code DELETE_ON_CLOSE} option.
 * @apiSince 26
 */

public static java.io.OutputStream newOutputStream(java.nio.file.Path path, java.nio.file.OpenOption... options) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Opens or creates a file, returning a seekable byte channel to access the
 * file.
 *
 * <p> The {@code options} parameter determines how the file is opened.
 * The {@link java.nio.file.StandardOpenOption#READ StandardOpenOption#READ} and {@link java.nio.file.StandardOpenOption#WRITE StandardOpenOption#WRITE} options determine if the file should be
 * opened for reading and/or writing. If neither option (or the {@link java.nio.file.StandardOpenOption#APPEND StandardOpenOption#APPEND} option) is present then the file is
 * opened for reading. By default reading or writing commence at the
 * beginning of the file.
 *
 * <p> In the addition to {@code READ} and {@code WRITE}, the following
 * options may be present:
 *
 * <table border=1 cellpadding=5 summary="Options">
 * <tr> <th>Option</th> <th>Description</th> </tr>
 * <tr>
 *   <td> {@link java.nio.file.StandardOpenOption#APPEND StandardOpenOption#APPEND} </td>
 *   <td> If this option is present then the file is opened for writing and
 *     each invocation of the channel's {@code write} method first advances
 *     the position to the end of the file and then writes the requested
 *     data. Whether the advancement of the position and the writing of the
 *     data are done in a single atomic operation is system-dependent and
 *     therefore unspecified. This option may not be used in conjunction
 *     with the {@code READ} or {@code TRUNCATE_EXISTING} options. </td>
 * </tr>
 * <tr>
 *   <td> {@link java.nio.file.StandardOpenOption#TRUNCATE_EXISTING StandardOpenOption#TRUNCATE_EXISTING} </td>
 *   <td> If this option is present then the existing file is truncated to
 *   a size of 0 bytes. This option is ignored when the file is opened only
 *   for reading. </td>
 * </tr>
 * <tr>
 *   <td> {@link java.nio.file.StandardOpenOption#CREATE_NEW StandardOpenOption#CREATE_NEW} </td>
 *   <td> If this option is present then a new file is created, failing if
 *   the file already exists or is a symbolic link. When creating a file the
 *   check for the existence of the file and the creation of the file if it
 *   does not exist is atomic with respect to other file system operations.
 *   This option is ignored when the file is opened only for reading. </td>
 * </tr>
 * <tr>
 *   <td > {@link java.nio.file.StandardOpenOption#CREATE StandardOpenOption#CREATE} </td>
 *   <td> If this option is present then an existing file is opened if it
 *   exists, otherwise a new file is created. This option is ignored if the
 *   {@code CREATE_NEW} option is also present or the file is opened only
 *   for reading. </td>
 * </tr>
 * <tr>
 *   <td > {@link java.nio.file.StandardOpenOption#DELETE_ON_CLOSE StandardOpenOption#DELETE_ON_CLOSE} </td>
 *   <td> When this option is present then the implementation makes a
 *   <em>best effort</em> attempt to delete the file when closed by the
 *   {@link java.nio.channels.SeekableByteChannel#close SeekableByteChannel#close} method. If the {@code close}
 *   method is not invoked then a <em>best effort</em> attempt is made to
 *   delete the file when the Java virtual machine terminates. </td>
 * </tr>
 * <tr>
 *   <td>{@link java.nio.file.StandardOpenOption#SPARSE StandardOpenOption#SPARSE} </td>
 *   <td> When creating a new file this option is a <em>hint</em> that the
 *   new file will be sparse. This option is ignored when not creating
 *   a new file. </td>
 * </tr>
 * <tr>
 *   <td> {@link java.nio.file.StandardOpenOption#SYNC StandardOpenOption#SYNC} </td>
 *   <td> Requires that every update to the file's content or metadata be
 *   written synchronously to the underlying storage device. (see <a
 *   href="package-summary.html#integrity"> Synchronized I/O file
 *   integrity</a>). </td>
 * </tr>
 * <tr>
 *   <td> {@link java.nio.file.StandardOpenOption#DSYNC StandardOpenOption#DSYNC} </td>
 *   <td> Requires that every update to the file's content be written
 *   synchronously to the underlying storage device. (see <a
 *   href="package-summary.html#integrity"> Synchronized I/O file
 *   integrity</a>). </td>
 * </tr>
 * </table>
 *
 * <p> An implementation may also support additional implementation specific
 * options.
 *
 * <p> The {@code attrs} parameter is optional {@link java.nio.file.attribute.FileAttribute FileAttribute} to set atomically when a new file is created.
 *
 * <p> In the case of the default provider, the returned seekable byte channel
 * is a {@link java.nio.channels.FileChannel}.
 *
 * <p> <b>Usage Examples:</b>
 * <pre>
 *     Path path = ...
 *
 *     // open file for reading
 *     ReadableByteChannel rbc = Files.newByteChannel(path, EnumSet.of(READ)));
 *
 *     // open file for writing to the end of an existing file, creating
 *     // the file if it doesn't already exist
 *     WritableByteChannel wbc = Files.newByteChannel(path, EnumSet.of(CREATE,APPEND));
 *
 *     // create file with initial permissions, opening it for both reading and writing
 *     {@code FileAttribute<Set<PosixFilePermission>> perms = ...}
 *     SeekableByteChannel sbc = Files.newByteChannel(path, EnumSet.of(CREATE_NEW,READ,WRITE), perms);
 * </pre>
 *
 * @param   path
 *          the path to the file to open or create
 * @param   options
 *          options specifying how the file is opened
 * @param   attrs
 *          an optional list of file attributes to set atomically when
 *          creating the file
 *
 * @return  a new seekable byte channel
 *
 * @throws  java.lang.IllegalArgumentException
 *          if the set contains an invalid combination of options
 * @throws  java.lang.UnsupportedOperationException
 *          if an unsupported open option is specified or the array contains
 *          attributes that cannot be set atomically when creating the file
 * @throws  java.nio.file.FileAlreadyExistsException
 *          if a file of that name already exists and the {@link java.nio.file.StandardOpenOption#CREATE_NEW StandardOpenOption#CREATE_NEW} option is specified
 *          <i>(optional specific exception)</i>
 * @throws  java.io.IOException
 *          if an I/O error occurs
 * @throws  java.lang.SecurityException
 *          In the case of the default provider, and a security manager is
 *          installed, the {@link java.lang.SecurityManager#checkRead(java.lang.String) SecurityManager#checkRead(String)}
 *          method is invoked to check read access to the path if the file is
 *          opened for reading. The {@link java.lang.SecurityManager#checkWrite(java.lang.String) SecurityManager#checkWrite(String)} method is invoked to check write access to the path
 *          if the file is opened for writing. The {@link java.lang.SecurityManager#checkDelete(java.lang.String) SecurityManager#checkDelete(String)} method is
 *          invoked to check delete access if the file is opened with the
 *          {@code DELETE_ON_CLOSE} option.
 *
 * @see java.nio.channels.FileChannel#open(Path,Set,FileAttribute[])
 * @apiSince 26
 */

public static java.nio.channels.SeekableByteChannel newByteChannel(java.nio.file.Path path, java.util.Set<? extends java.nio.file.OpenOption> options, java.nio.file.attribute.FileAttribute<?>... attrs) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Opens or creates a file, returning a seekable byte channel to access the
 * file.
 *
 * <p> This method opens or creates a file in exactly the manner specified
 * by the {@link #newByteChannel(java.nio.file.Path,java.util.Set,java.nio.file.attribute.FileAttribute[]) newByteChannel}
 * method.
 *
 * @param   path
 *          the path to the file to open or create
 * @param   options
 *          options specifying how the file is opened
 *
 * @return  a new seekable byte channel
 *
 * @throws  java.lang.IllegalArgumentException
 *          if the set contains an invalid combination of options
 * @throws  java.lang.UnsupportedOperationException
 *          if an unsupported open option is specified
 * @throws  java.nio.file.FileAlreadyExistsException
 *          if a file of that name already exists and the {@link java.nio.file.StandardOpenOption#CREATE_NEW StandardOpenOption#CREATE_NEW} option is specified
 *          <i>(optional specific exception)</i>
 * @throws  java.io.IOException
 *          if an I/O error occurs
 * @throws  java.lang.SecurityException
 *          In the case of the default provider, and a security manager is
 *          installed, the {@link java.lang.SecurityManager#checkRead(java.lang.String) SecurityManager#checkRead(String)}
 *          method is invoked to check read access to the path if the file is
 *          opened for reading. The {@link java.lang.SecurityManager#checkWrite(java.lang.String) SecurityManager#checkWrite(String)} method is invoked to check write access to the path
 *          if the file is opened for writing. The {@link java.lang.SecurityManager#checkDelete(java.lang.String) SecurityManager#checkDelete(String)} method is
 *          invoked to check delete access if the file is opened with the
 *          {@code DELETE_ON_CLOSE} option.
 *
 * @see java.nio.channels.FileChannel#open(Path,OpenOption[])
 * @apiSince 26
 */

public static java.nio.channels.SeekableByteChannel newByteChannel(java.nio.file.Path path, java.nio.file.OpenOption... options) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Opens a directory, returning a {@link java.nio.file.DirectoryStream DirectoryStream} to iterate over
 * all entries in the directory. The elements returned by the directory
 * stream's {@link java.nio.file.DirectoryStream#iterator DirectoryStream#iterator} are of type {@code
 * Path}, each one representing an entry in the directory. The {@code Path}
 * objects are obtained as if by {@link java.nio.file.Path#resolve(java.nio.file.Path) Path#resolve(Path)} the
 * name of the directory entry against {@code dir}.
 *
 * <p> When not using the try-with-resources construct, then directory
 * stream's {@code close} method should be invoked after iteration is
 * completed so as to free any resources held for the open directory.
 *
 * <p> When an implementation supports operations on entries in the
 * directory that execute in a race-free manner then the returned directory
 * stream is a {@link java.nio.file.SecureDirectoryStream SecureDirectoryStream}.
 *
 * @param   dir
 *          the path to the directory
 *
 * @return  a new and open {@code DirectoryStream} object
 *
 * @throws  java.nio.file.NotDirectoryException
 *          if the file could not otherwise be opened because it is not
 *          a directory <i>(optional specific exception)</i>
 * @throws  java.io.IOException
 *          if an I/O error occurs
 * @throws  java.lang.SecurityException
 *          In the case of the default provider, and a security manager is
 *          installed, the {@link java.lang.SecurityManager#checkRead(java.lang.String) SecurityManager#checkRead(String)}
 *          method is invoked to check read access to the directory.
 * @apiSince 26
 */

public static java.nio.file.DirectoryStream<java.nio.file.Path> newDirectoryStream(java.nio.file.Path dir) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Opens a directory, returning a {@link java.nio.file.DirectoryStream DirectoryStream} to iterate over
 * the entries in the directory. The elements returned by the directory
 * stream's {@link java.nio.file.DirectoryStream#iterator DirectoryStream#iterator} are of type {@code
 * Path}, each one representing an entry in the directory. The {@code Path}
 * objects are obtained as if by {@link java.nio.file.Path#resolve(java.nio.file.Path) Path#resolve(Path)} the
 * name of the directory entry against {@code dir}. The entries returned by
 * the iterator are filtered by matching the {@code String} representation
 * of their file names against the given <em>globbing</em> pattern.
 *
 * <p> For example, suppose we want to iterate over the files ending with
 * ".java" in a directory:
 * <pre>
 *     Path dir = ...
 *     try (DirectoryStream&lt;Path&gt; stream = Files.newDirectoryStream(dir, "*.java")) {
 *         :
 *     }
 * </pre>
 *
 * <p> The globbing pattern is specified by the {@link java.nio.file.FileSystem#getPathMatcher FileSystem#getPathMatcher} method.
 *
 * <p> When not using the try-with-resources construct, then directory
 * stream's {@code close} method should be invoked after iteration is
 * completed so as to free any resources held for the open directory.
 *
 * <p> When an implementation supports operations on entries in the
 * directory that execute in a race-free manner then the returned directory
 * stream is a {@link java.nio.file.SecureDirectoryStream SecureDirectoryStream}.
 *
 * @param   dir
 *          the path to the directory
 * @param   glob
 *          the glob pattern
 *
 * @return  a new and open {@code DirectoryStream} object
 *
 * @throws  java.util.regex.PatternSyntaxException
 *          if the pattern is invalid
 * @throws  java.nio.file.NotDirectoryException
 *          if the file could not otherwise be opened because it is not
 *          a directory <i>(optional specific exception)</i>
 * @throws  java.io.IOException
 *          if an I/O error occurs
 * @throws  java.lang.SecurityException
 *          In the case of the default provider, and a security manager is
 *          installed, the {@link java.lang.SecurityManager#checkRead(java.lang.String) SecurityManager#checkRead(String)}
 *          method is invoked to check read access to the directory.
 * @apiSince 26
 */

public static java.nio.file.DirectoryStream<java.nio.file.Path> newDirectoryStream(java.nio.file.Path dir, java.lang.String glob) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Opens a directory, returning a {@link java.nio.file.DirectoryStream DirectoryStream} to iterate over
 * the entries in the directory. The elements returned by the directory
 * stream's {@link java.nio.file.DirectoryStream#iterator DirectoryStream#iterator} are of type {@code
 * Path}, each one representing an entry in the directory. The {@code Path}
 * objects are obtained as if by {@link java.nio.file.Path#resolve(java.nio.file.Path) Path#resolve(Path)} the
 * name of the directory entry against {@code dir}. The entries returned by
 * the iterator are filtered by the given {@link java.nio.file.DirectoryStream.Filter DirectoryStream.Filter}.
 *
 * <p> When not using the try-with-resources construct, then directory
 * stream's {@code close} method should be invoked after iteration is
 * completed so as to free any resources held for the open directory.
 *
 * <p> Where the filter terminates due to an uncaught error or runtime
 * exception then it is propagated to the {@link java.util.Iterator#hasNext() Iterator#hasNext()} or {@link java.util.Iterator#next() Iterator#next()} method. Where an {@code
 * IOException} is thrown, it results in the {@code hasNext} or {@code
 * next} method throwing a {@link java.nio.file.DirectoryIteratorException DirectoryIteratorException} with the
 * {@code IOException} as the cause.
 *
 * <p> When an implementation supports operations on entries in the
 * directory that execute in a race-free manner then the returned directory
 * stream is a {@link java.nio.file.SecureDirectoryStream SecureDirectoryStream}.
 *
 * <p> <b>Usage Example:</b>
 * Suppose we want to iterate over the files in a directory that are
 * larger than 8K.
 * <pre>
 *     DirectoryStream.Filter&lt;Path&gt; filter = new DirectoryStream.Filter&lt;Path&gt;() {
 *         public boolean accept(Path file) throws IOException {
 *             return (Files.size(file) &gt; 8192L);
 *         }
 *     };
 *     Path dir = ...
 *     try (DirectoryStream&lt;Path&gt; stream = Files.newDirectoryStream(dir, filter)) {
 *         :
 *     }
 * </pre>
 *
 * @param   dir
 *          the path to the directory
 * @param   filter
 *          the directory stream filter
 *
 * @return  a new and open {@code DirectoryStream} object
 *
 * @throws  java.nio.file.NotDirectoryException
 *          if the file could not otherwise be opened because it is not
 *          a directory <i>(optional specific exception)</i>
 * @throws  java.io.IOException
 *          if an I/O error occurs
 * @throws  java.lang.SecurityException
 *          In the case of the default provider, and a security manager is
 *          installed, the {@link java.lang.SecurityManager#checkRead(java.lang.String) SecurityManager#checkRead(String)}
 *          method is invoked to check read access to the directory.
 * @apiSince 26
 */

public static java.nio.file.DirectoryStream<java.nio.file.Path> newDirectoryStream(java.nio.file.Path dir, java.nio.file.DirectoryStream.Filter<? super java.nio.file.Path> filter) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Creates a new and empty file, failing if the file already exists. The
 * check for the existence of the file and the creation of the new file if
 * it does not exist are a single operation that is atomic with respect to
 * all other filesystem activities that might affect the directory.
 *
 * <p> The {@code attrs} parameter is optional {@link java.nio.file.attribute.FileAttribute FileAttribute} to set atomically when creating the file. Each attribute
 * is identified by its {@link java.nio.file.attribute.FileAttribute#name FileAttribute#name}. If more than one
 * attribute of the same name is included in the array then all but the last
 * occurrence is ignored.
 *
 * @param   path
 *          the path to the file to create
 * @param   attrs
 *          an optional list of file attributes to set atomically when
 *          creating the file
 *
 * @return  the file
 *
 * @throws  java.lang.UnsupportedOperationException
 *          if the array contains an attribute that cannot be set atomically
 *          when creating the file
 * @throws  java.nio.file.FileAlreadyExistsException
 *          if a file of that name already exists
 *          <i>(optional specific exception)</i>
 * @throws  java.io.IOException
 *          if an I/O error occurs or the parent directory does not exist
 * @throws  java.lang.SecurityException
 *          In the case of the default provider, and a security manager is
 *          installed, the {@link java.lang.SecurityManager#checkWrite(java.lang.String) SecurityManager#checkWrite(String)}
 *          method is invoked to check write access to the new file.
 * @apiSince 26
 */

public static java.nio.file.Path createFile(java.nio.file.Path path, java.nio.file.attribute.FileAttribute<?>... attrs) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Creates a new directory. The check for the existence of the file and the
 * creation of the directory if it does not exist are a single operation
 * that is atomic with respect to all other filesystem activities that might
 * affect the directory. The {@link #createDirectories createDirectories}
 * method should be used where it is required to create all nonexistent
 * parent directories first.
 *
 * <p> The {@code attrs} parameter is optional {@link java.nio.file.attribute.FileAttribute FileAttribute} to set atomically when creating the directory. Each
 * attribute is identified by its {@link java.nio.file.attribute.FileAttribute#name FileAttribute#name}. If more
 * than one attribute of the same name is included in the array then all but
 * the last occurrence is ignored.
 *
 * @param   dir
 *          the directory to create
 * @param   attrs
 *          an optional list of file attributes to set atomically when
 *          creating the directory
 *
 * @return  the directory
 *
 * @throws  java.lang.UnsupportedOperationException
 *          if the array contains an attribute that cannot be set atomically
 *          when creating the directory
 * @throws  java.nio.file.FileAlreadyExistsException
 *          if a directory could not otherwise be created because a file of
 *          that name already exists <i>(optional specific exception)</i>
 * @throws  java.io.IOException
 *          if an I/O error occurs or the parent directory does not exist
 * @throws  java.lang.SecurityException
 *          In the case of the default provider, and a security manager is
 *          installed, the {@link java.lang.SecurityManager#checkWrite(java.lang.String) SecurityManager#checkWrite(String)}
 *          method is invoked to check write access to the new directory.
 * @apiSince 26
 */

public static java.nio.file.Path createDirectory(java.nio.file.Path dir, java.nio.file.attribute.FileAttribute<?>... attrs) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Creates a directory by creating all nonexistent parent directories first.
 * Unlike the {@link #createDirectory createDirectory} method, an exception
 * is not thrown if the directory could not be created because it already
 * exists.
 *
 * <p> The {@code attrs} parameter is optional {@link java.nio.file.attribute.FileAttribute FileAttribute} to set atomically when creating the nonexistent
 * directories. Each file attribute is identified by its {@link java.nio.file.attribute.FileAttribute#name FileAttribute#name}. If more than one attribute of the same name is
 * included in the array then all but the last occurrence is ignored.
 *
 * <p> If this method fails, then it may do so after creating some, but not
 * all, of the parent directories.
 *
 * @param   dir
 *          the directory to create
 *
 * @param   attrs
 *          an optional list of file attributes to set atomically when
 *          creating the directory
 *
 * @return  the directory
 *
 * @throws  java.lang.UnsupportedOperationException
 *          if the array contains an attribute that cannot be set atomically
 *          when creating the directory
 * @throws  java.nio.file.FileAlreadyExistsException
 *          if {@code dir} exists but is not a directory <i>(optional specific
 *          exception)</i>
 * @throws  java.io.IOException
 *          if an I/O error occurs
 * @throws  java.lang.SecurityException
 *          in the case of the default provider, and a security manager is
 *          installed, the {@link java.lang.SecurityManager#checkWrite(java.lang.String) SecurityManager#checkWrite(String)}
 *          method is invoked prior to attempting to create a directory and
 *          its {@link java.lang.SecurityManager#checkRead(java.lang.String) SecurityManager#checkRead(String)} is
 *          invoked for each parent directory that is checked. If {@code
 *          dir} is not an absolute path then its {@link java.nio.file.Path#toAbsolutePath Path#toAbsolutePath} may need to be invoked to get its absolute path.
 *          This may invoke the security manager's {@link java.lang.SecurityManager#checkPropertyAccess(java.lang.String) SecurityManager#checkPropertyAccess(String)}
 *          method to check access to the system property {@code user.dir}
 * @apiSince 26
 */

public static java.nio.file.Path createDirectories(java.nio.file.Path dir, java.nio.file.attribute.FileAttribute<?>... attrs) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Creates a new empty file in the specified directory, using the given
 * prefix and suffix strings to generate its name. The resulting
 * {@code Path} is associated with the same {@code FileSystem} as the given
 * directory.
 *
 * <p> The details as to how the name of the file is constructed is
 * implementation dependent and therefore not specified. Where possible
 * the {@code prefix} and {@code suffix} are used to construct candidate
 * names in the same manner as the {@link
 * java.io.File#createTempFile(String,String,File)} method.
 *
 * <p> As with the {@code File.createTempFile} methods, this method is only
 * part of a temporary-file facility. Where used as a <em>work files</em>,
 * the resulting file may be opened using the {@link java.nio.file.StandardOpenOption#DELETE_ON_CLOSE StandardOpenOption#DELETE_ON_CLOSE} option so that the
 * file is deleted when the appropriate {@code close} method is invoked.
 * Alternatively, a {@link java.lang.Runtime#addShutdownHook Runtime#addShutdownHook}, or the
 * {@link java.io.File#deleteOnExit} mechanism may be used to delete the
 * file automatically.
 *
 * <p> The {@code attrs} parameter is optional {@link java.nio.file.attribute.FileAttribute FileAttribute} to set atomically when creating the file. Each attribute
 * is identified by its {@link java.nio.file.attribute.FileAttribute#name FileAttribute#name}. If more than one
 * attribute of the same name is included in the array then all but the last
 * occurrence is ignored. When no file attributes are specified, then the
 * resulting file may have more restrictive access permissions to files
 * created by the {@link java.io.File#createTempFile(String,String,File)}
 * method.
 *
 * @param   dir
 *          the path to directory in which to create the file
 * @param   prefix
 *          the prefix string to be used in generating the file's name;
 *          may be {@code null}
 * @param   suffix
 *          the suffix string to be used in generating the file's name;
 *          may be {@code null}, in which case "{@code .tmp}" is used
 * @param   attrs
 *          an optional list of file attributes to set atomically when
 *          creating the file
 *
 * @return  the path to the newly created file that did not exist before
 *          this method was invoked
 *
 * @throws  java.lang.IllegalArgumentException
 *          if the prefix or suffix parameters cannot be used to generate
 *          a candidate file name
 * @throws  java.lang.UnsupportedOperationException
 *          if the array contains an attribute that cannot be set atomically
 *          when creating the directory
 * @throws  java.io.IOException
 *          if an I/O error occurs or {@code dir} does not exist
 * @throws  java.lang.SecurityException
 *          In the case of the default provider, and a security manager is
 *          installed, the {@link java.lang.SecurityManager#checkWrite(java.lang.String) SecurityManager#checkWrite(String)}
 *          method is invoked to check write access to the file.
 * @apiSince 26
 */

public static java.nio.file.Path createTempFile(java.nio.file.Path dir, java.lang.String prefix, java.lang.String suffix, java.nio.file.attribute.FileAttribute<?>... attrs) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Creates an empty file in the default temporary-file directory, using
 * the given prefix and suffix to generate its name. The resulting {@code
 * Path} is associated with the default {@code FileSystem}.
 *
 * <p> This method works in exactly the manner specified by the
 * {@link #createTempFile(java.nio.file.Path,java.lang.String,java.lang.String,java.nio.file.attribute.FileAttribute[])} method for
 * the case that the {@code dir} parameter is the temporary-file directory.
 *
 * @param   prefix
 *          the prefix string to be used in generating the file's name;
 *          may be {@code null}
 * @param   suffix
 *          the suffix string to be used in generating the file's name;
 *          may be {@code null}, in which case "{@code .tmp}" is used
 * @param   attrs
 *          an optional list of file attributes to set atomically when
 *          creating the file
 *
 * @return  the path to the newly created file that did not exist before
 *          this method was invoked
 *
 * @throws  java.lang.IllegalArgumentException
 *          if the prefix or suffix parameters cannot be used to generate
 *          a candidate file name
 * @throws  java.lang.UnsupportedOperationException
 *          if the array contains an attribute that cannot be set atomically
 *          when creating the directory
 * @throws  java.io.IOException
 *          if an I/O error occurs or the temporary-file directory does not
 *          exist
 * @throws  java.lang.SecurityException
 *          In the case of the default provider, and a security manager is
 *          installed, the {@link java.lang.SecurityManager#checkWrite(java.lang.String) SecurityManager#checkWrite(String)}
 *          method is invoked to check write access to the file.
 * @apiSince 26
 */

public static java.nio.file.Path createTempFile(java.lang.String prefix, java.lang.String suffix, java.nio.file.attribute.FileAttribute<?>... attrs) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Creates a new directory in the specified directory, using the given
 * prefix to generate its name.  The resulting {@code Path} is associated
 * with the same {@code FileSystem} as the given directory.
 *
 * <p> The details as to how the name of the directory is constructed is
 * implementation dependent and therefore not specified. Where possible
 * the {@code prefix} is used to construct candidate names.
 *
 * <p> As with the {@code createTempFile} methods, this method is only
 * part of a temporary-file facility. A {@link java.lang.Runtime#addShutdownHook Runtime#addShutdownHook}, or the {@link java.io.File#deleteOnExit} mechanism may be
 * used to delete the directory automatically.
 *
 * <p> The {@code attrs} parameter is optional {@link java.nio.file.attribute.FileAttribute FileAttribute} to set atomically when creating the directory. Each
 * attribute is identified by its {@link java.nio.file.attribute.FileAttribute#name FileAttribute#name}. If more
 * than one attribute of the same name is included in the array then all but
 * the last occurrence is ignored.
 *
 * @param   dir
 *          the path to directory in which to create the directory
 * @param   prefix
 *          the prefix string to be used in generating the directory's name;
 *          may be {@code null}
 * @param   attrs
 *          an optional list of file attributes to set atomically when
 *          creating the directory
 *
 * @return  the path to the newly created directory that did not exist before
 *          this method was invoked
 *
 * @throws  java.lang.IllegalArgumentException
 *          if the prefix cannot be used to generate a candidate directory name
 * @throws  java.lang.UnsupportedOperationException
 *          if the array contains an attribute that cannot be set atomically
 *          when creating the directory
 * @throws  java.io.IOException
 *          if an I/O error occurs or {@code dir} does not exist
 * @throws  java.lang.SecurityException
 *          In the case of the default provider, and a security manager is
 *          installed, the {@link java.lang.SecurityManager#checkWrite(java.lang.String) SecurityManager#checkWrite(String)}
 *          method is invoked to check write access when creating the
 *          directory.
 * @apiSince 26
 */

public static java.nio.file.Path createTempDirectory(java.nio.file.Path dir, java.lang.String prefix, java.nio.file.attribute.FileAttribute<?>... attrs) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Creates a new directory in the default temporary-file directory, using
 * the given prefix to generate its name. The resulting {@code Path} is
 * associated with the default {@code FileSystem}.
 *
 * <p> This method works in exactly the manner specified by {@link
 * #createTempDirectory(java.nio.file.Path,java.lang.String,java.nio.file.attribute.FileAttribute[])} method for the case
 * that the {@code dir} parameter is the temporary-file directory.
 *
 * @param   prefix
 *          the prefix string to be used in generating the directory's name;
 *          may be {@code null}
 * @param   attrs
 *          an optional list of file attributes to set atomically when
 *          creating the directory
 *
 * @return  the path to the newly created directory that did not exist before
 *          this method was invoked
 *
 * @throws  java.lang.IllegalArgumentException
 *          if the prefix cannot be used to generate a candidate directory name
 * @throws  java.lang.UnsupportedOperationException
 *          if the array contains an attribute that cannot be set atomically
 *          when creating the directory
 * @throws  java.io.IOException
 *          if an I/O error occurs or the temporary-file directory does not
 *          exist
 * @throws  java.lang.SecurityException
 *          In the case of the default provider, and a security manager is
 *          installed, the {@link java.lang.SecurityManager#checkWrite(java.lang.String) SecurityManager#checkWrite(String)}
 *          method is invoked to check write access when creating the
 *          directory.
 * @apiSince 26
 */

public static java.nio.file.Path createTempDirectory(java.lang.String prefix, java.nio.file.attribute.FileAttribute<?>... attrs) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Creates a symbolic link to a target <i>(optional operation)</i>.
 *
 * <p> The {@code target} parameter is the target of the link. It may be an
 * {@link java.nio.file.Path#isAbsolute Path#isAbsolute} or relative path and may not exist. When
 * the target is a relative path then file system operations on the resulting
 * link are relative to the path of the link.
 *
 * <p> The {@code attrs} parameter is optional {@link java.nio.file.attribute.FileAttribute FileAttribute} to set atomically when creating the link. Each attribute is
 * identified by its {@link java.nio.file.attribute.FileAttribute#name FileAttribute#name}. If more than one attribute
 * of the same name is included in the array then all but the last occurrence
 * is ignored.
 *
 * <p> Where symbolic links are supported, but the underlying {@link java.nio.file.FileStore FileStore}
 * does not support symbolic links, then this may fail with an {@link java.io.IOException IOException}. Additionally, some operating systems may require that the
 * Java virtual machine be started with implementation specific privileges to
 * create symbolic links, in which case this method may throw {@code IOException}.
 *
 * @param   link
 *          the path of the symbolic link to create
 * @param   target
 *          the target of the symbolic link
 * @param   attrs
 *          the array of attributes to set atomically when creating the
 *          symbolic link
 *
 * @return  the path to the symbolic link
 *
 * @throws  java.lang.UnsupportedOperationException
 *          if the implementation does not support symbolic links or the
 *          array contains an attribute that cannot be set atomically when
 *          creating the symbolic link
 * @throws  java.nio.file.FileAlreadyExistsException
 *          if a file with the name already exists <i>(optional specific
 *          exception)</i>
 * @throws  java.io.IOException
 *          if an I/O error occurs
 * @throws  java.lang.SecurityException
 *          In the case of the default provider, and a security manager
 *          is installed, it denies {@link java.nio.file.LinkPermission LinkPermission}<tt>("symbolic")</tt>
 *          or its {@link java.lang.SecurityManager#checkWrite(java.lang.String) SecurityManager#checkWrite(String)}
 *          method denies write access to the path of the symbolic link.
 * @apiSince 26
 */

public static java.nio.file.Path createSymbolicLink(java.nio.file.Path link, java.nio.file.Path target, java.nio.file.attribute.FileAttribute<?>... attrs) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Creates a new link (directory entry) for an existing file <i>(optional
 * operation)</i>.
 *
 * <p> The {@code link} parameter locates the directory entry to create.
 * The {@code existing} parameter is the path to an existing file. This
 * method creates a new directory entry for the file so that it can be
 * accessed using {@code link} as the path. On some file systems this is
 * known as creating a "hard link". Whether the file attributes are
 * maintained for the file or for each directory entry is file system
 * specific and therefore not specified. Typically, a file system requires
 * that all links (directory entries) for a file be on the same file system.
 * Furthermore, on some platforms, the Java virtual machine may require to
 * be started with implementation specific privileges to create hard links
 * or to create links to directories.
 *
 * @param   link
 *          the link (directory entry) to create
 * @param   existing
 *          a path to an existing file
 *
 * @return  the path to the link (directory entry)
 *
 * @throws  java.lang.UnsupportedOperationException
 *          if the implementation does not support adding an existing file
 *          to a directory
 * @throws  java.nio.file.FileAlreadyExistsException
 *          if the entry could not otherwise be created because a file of
 *          that name already exists <i>(optional specific exception)</i>
 * @throws  java.io.IOException
 *          if an I/O error occurs
 * @throws  java.lang.SecurityException
 *          In the case of the default provider, and a security manager
 *          is installed, it denies {@link java.nio.file.LinkPermission LinkPermission}<tt>("hard")</tt>
 *          or its {@link java.lang.SecurityManager#checkWrite(java.lang.String) SecurityManager#checkWrite(String)}
 *          method denies write access to either the link or the
 *          existing file.
 * @apiSince 26
 */

public static java.nio.file.Path createLink(java.nio.file.Path link, java.nio.file.Path existing) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Deletes a file.
 *
 * <p> An implementation may require to examine the file to determine if the
 * file is a directory. Consequently this method may not be atomic with respect
 * to other file system operations.  If the file is a symbolic link then the
 * symbolic link itself, not the final target of the link, is deleted.
 *
 * <p> If the file is a directory then the directory must be empty. In some
 * implementations a directory has entries for special files or links that
 * are created when the directory is created. In such implementations a
 * directory is considered empty when only the special entries exist.
 * This method can be used with the {@link #walkFileTree walkFileTree}
 * method to delete a directory and all entries in the directory, or an
 * entire <i>file-tree</i> where required.
 *
 * <p> On some operating systems it may not be possible to remove a file when
 * it is open and in use by this Java virtual machine or other programs.
 *
 * @param   path
 *          the path to the file to delete
 *
 * @throws  java.nio.file.NoSuchFileException
 *          if the file does not exist <i>(optional specific exception)</i>
 * @throws  java.nio.file.DirectoryNotEmptyException
 *          if the file is a directory and could not otherwise be deleted
 *          because the directory is not empty <i>(optional specific
 *          exception)</i>
 * @throws  java.io.IOException
 *          if an I/O error occurs
 * @throws  java.lang.SecurityException
 *          In the case of the default provider, and a security manager is
 *          installed, the {@link java.lang.SecurityManager#checkDelete(java.lang.String) SecurityManager#checkDelete(String)} method
 *          is invoked to check delete access to the file
 * @apiSince 26
 */

public static void delete(java.nio.file.Path path) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Deletes a file if it exists.
 *
 * <p> As with the {@link #delete(java.nio.file.Path) delete(Path)} method, an
 * implementation may need to examine the file to determine if the file is a
 * directory. Consequently this method may not be atomic with respect to
 * other file system operations.  If the file is a symbolic link, then the
 * symbolic link itself, not the final target of the link, is deleted.
 *
 * <p> If the file is a directory then the directory must be empty. In some
 * implementations a directory has entries for special files or links that
 * are created when the directory is created. In such implementations a
 * directory is considered empty when only the special entries exist.
 *
 * <p> On some operating systems it may not be possible to remove a file when
 * it is open and in use by this Java virtual machine or other programs.
 *
 * @param   path
 *          the path to the file to delete
 *
 * @return  {@code true} if the file was deleted by this method; {@code
 *          false} if the file could not be deleted because it did not
 *          exist
 *
 * @throws  java.nio.file.DirectoryNotEmptyException
 *          if the file is a directory and could not otherwise be deleted
 *          because the directory is not empty <i>(optional specific
 *          exception)</i>
 * @throws  java.io.IOException
 *          if an I/O error occurs
 * @throws  java.lang.SecurityException
 *          In the case of the default provider, and a security manager is
 *          installed, the {@link java.lang.SecurityManager#checkDelete(java.lang.String) SecurityManager#checkDelete(String)} method
 *          is invoked to check delete access to the file.
 * @apiSince 26
 */

public static boolean deleteIfExists(java.nio.file.Path path) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Copy a file to a target file.
 *
 * <p> This method copies a file to the target file with the {@code
 * options} parameter specifying how the copy is performed. By default, the
 * copy fails if the target file already exists or is a symbolic link,
 * except if the source and target are the {@link #isSameFile same} file, in
 * which case the method completes without copying the file. File attributes
 * are not required to be copied to the target file. If symbolic links are
 * supported, and the file is a symbolic link, then the final target of the
 * link is copied. If the file is a directory then it creates an empty
 * directory in the target location (entries in the directory are not
 * copied). This method can be used with the {@link #walkFileTree
 * walkFileTree} method to copy a directory and all entries in the directory,
 * or an entire <i>file-tree</i> where required.
 *
 * <p> The {@code options} parameter may include any of the following:
 *
 * <table border=1 cellpadding=5 summary="">
 * <tr> <th>Option</th> <th>Description</th> </tr>
 * <tr>
 *   <td> {@link java.nio.file.StandardCopyOption#REPLACE_EXISTING StandardCopyOption#REPLACE_EXISTING} </td>
 *   <td> If the target file exists, then the target file is replaced if it
 *     is not a non-empty directory. If the target file exists and is a
 *     symbolic link, then the symbolic link itself, not the target of
 *     the link, is replaced. </td>
 * </tr>
 * <tr>
 *   <td> {@link java.nio.file.StandardCopyOption#COPY_ATTRIBUTES StandardCopyOption#COPY_ATTRIBUTES} </td>
 *   <td> Attempts to copy the file attributes associated with this file to
 *     the target file. The exact file attributes that are copied is platform
 *     and file system dependent and therefore unspecified. Minimally, the
 *     {@link java.nio.file.attribute.BasicFileAttributes#lastModifiedTime BasicFileAttributes#lastModifiedTime} is
 *     copied to the target file if supported by both the source and target
 *     file stores. Copying of file timestamps may result in precision
 *     loss. </td>
 * </tr>
 * <tr>
 *   <td> {@link java.nio.file.LinkOption#NOFOLLOW_LINKS LinkOption#NOFOLLOW_LINKS} </td>
 *   <td> Symbolic links are not followed. If the file is a symbolic link,
 *     then the symbolic link itself, not the target of the link, is copied.
 *     It is implementation specific if file attributes can be copied to the
 *     new link. In other words, the {@code COPY_ATTRIBUTES} option may be
 *     ignored when copying a symbolic link. </td>
 * </tr>
 * </table>
 *
 * <p> An implementation of this interface may support additional
 * implementation specific options.
 *
 * <p> Copying a file is not an atomic operation. If an {@link java.io.IOException IOException}
 * is thrown, then it is possible that the target file is incomplete or some
 * of its file attributes have not been copied from the source file. When
 * the {@code REPLACE_EXISTING} option is specified and the target file
 * exists, then the target file is replaced. The check for the existence of
 * the file and the creation of the new file may not be atomic with respect
 * to other file system activities.
 *
 * <p> <b>Usage Example:</b>
 * Suppose we want to copy a file into a directory, giving it the same file
 * name as the source file:
 * <pre>
 *     Path source = ...
 *     Path newdir = ...
 *     Files.copy(source, newdir.resolve(source.getFileName());
 * </pre>
 *
 * @param   source
 *          the path to the file to copy
 * @param   target
 *          the path to the target file (may be associated with a different
 *          provider to the source path)
 * @param   options
 *          options specifying how the copy should be done
 *
 * @return  the path to the target file
 *
 * @throws  java.lang.UnsupportedOperationException
 *          if the array contains a copy option that is not supported
 * @throws  java.nio.file.FileAlreadyExistsException
 *          if the target file exists but cannot be replaced because the
 *          {@code REPLACE_EXISTING} option is not specified <i>(optional
 *          specific exception)</i>
 * @throws  java.nio.file.DirectoryNotEmptyException
 *          the {@code REPLACE_EXISTING} option is specified but the file
 *          cannot be replaced because it is a non-empty directory
 *          <i>(optional specific exception)</i>
 * @throws  java.io.IOException
 *          if an I/O error occurs
 * @throws  java.lang.SecurityException
 *          In the case of the default provider, and a security manager is
 *          installed, the {@link java.lang.SecurityManager#checkRead(java.lang.String) SecurityManager#checkRead(String)}
 *          method is invoked to check read access to the source file, the
 *          {@link java.lang.SecurityManager#checkWrite(java.lang.String) SecurityManager#checkWrite(String)} is invoked
 *          to check write access to the target file. If a symbolic link is
 *          copied the security manager is invoked to check {@link java.nio.file.LinkPermission LinkPermission}{@code ("symbolic")}.
 * @apiSince 26
 */

public static java.nio.file.Path copy(java.nio.file.Path source, java.nio.file.Path target, java.nio.file.CopyOption... options) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Move or rename a file to a target file.
 *
 * <p> By default, this method attempts to move the file to the target
 * file, failing if the target file exists except if the source and
 * target are the {@link #isSameFile same} file, in which case this method
 * has no effect. If the file is a symbolic link then the symbolic link
 * itself, not the target of the link, is moved. This method may be
 * invoked to move an empty directory. In some implementations a directory
 * has entries for special files or links that are created when the
 * directory is created. In such implementations a directory is considered
 * empty when only the special entries exist. When invoked to move a
 * directory that is not empty then the directory is moved if it does not
 * require moving the entries in the directory.  For example, renaming a
 * directory on the same {@link java.nio.file.FileStore FileStore} will usually not require moving
 * the entries in the directory. When moving a directory requires that its
 * entries be moved then this method fails (by throwing an {@code
 * IOException}). To move a <i>file tree</i> may involve copying rather
 * than moving directories and this can be done using the {@link
 * #copy copy} method in conjunction with the {@link
 * #walkFileTree Files.walkFileTree} utility method.
 *
 * <p> The {@code options} parameter may include any of the following:
 *
 * <table border=1 cellpadding=5 summary="">
 * <tr> <th>Option</th> <th>Description</th> </tr>
 * <tr>
 *   <td> {@link java.nio.file.StandardCopyOption#REPLACE_EXISTING StandardCopyOption#REPLACE_EXISTING} </td>
 *   <td> If the target file exists, then the target file is replaced if it
 *     is not a non-empty directory. If the target file exists and is a
 *     symbolic link, then the symbolic link itself, not the target of
 *     the link, is replaced. </td>
 * </tr>
 * <tr>
 *   <td> {@link java.nio.file.StandardCopyOption#ATOMIC_MOVE StandardCopyOption#ATOMIC_MOVE} </td>
 *   <td> The move is performed as an atomic file system operation and all
 *     other options are ignored. If the target file exists then it is
 *     implementation specific if the existing file is replaced or this method
 *     fails by throwing an {@link java.io.IOException IOException}. If the move cannot be
 *     performed as an atomic file system operation then {@link java.nio.file.AtomicMoveNotSupportedException AtomicMoveNotSupportedException} is thrown. This can arise, for
 *     example, when the target location is on a different {@code FileStore}
 *     and would require that the file be copied, or target location is
 *     associated with a different provider to this object. </td>
 * </table>
 *
 * <p> An implementation of this interface may support additional
 * implementation specific options.
 *
 * <p> Moving a file will copy the {@link java.nio.file.attribute.BasicFileAttributes#lastModifiedTime BasicFileAttributes#lastModifiedTime} to the target
 * file if supported by both source and target file stores. Copying of file
 * timestamps may result in precision loss. An implementation may also
 * attempt to copy other file attributes but is not required to fail if the
 * file attributes cannot be copied. When the move is performed as
 * a non-atomic operation, and an {@code IOException} is thrown, then the
 * state of the files is not defined. The original file and the target file
 * may both exist, the target file may be incomplete or some of its file
 * attributes may not been copied from the original file.
 *
 * <p> <b>Usage Examples:</b>
 * Suppose we want to rename a file to "newname", keeping the file in the
 * same directory:
 * <pre>
 *     Path source = ...
 *     Files.move(source, source.resolveSibling("newname"));
 * </pre>
 * Alternatively, suppose we want to move a file to new directory, keeping
 * the same file name, and replacing any existing file of that name in the
 * directory:
 * <pre>
 *     Path source = ...
 *     Path newdir = ...
 *     Files.move(source, newdir.resolve(source.getFileName()), REPLACE_EXISTING);
 * </pre>
 *
 * @param   source
 *          the path to the file to move
 * @param   target
 *          the path to the target file (may be associated with a different
 *          provider to the source path)
 * @param   options
 *          options specifying how the move should be done
 *
 * @return  the path to the target file
 *
 * @throws  java.lang.UnsupportedOperationException
 *          if the array contains a copy option that is not supported
 * @throws  java.nio.file.FileAlreadyExistsException
 *          if the target file exists but cannot be replaced because the
 *          {@code REPLACE_EXISTING} option is not specified <i>(optional
 *          specific exception)</i>
 * @throws  java.nio.file.DirectoryNotEmptyException
 *          the {@code REPLACE_EXISTING} option is specified but the file
 *          cannot be replaced because it is a non-empty directory
 *          <i>(optional specific exception)</i>
 * @throws  java.nio.file.AtomicMoveNotSupportedException
 *          if the options array contains the {@code ATOMIC_MOVE} option but
 *          the file cannot be moved as an atomic file system operation.
 * @throws  java.io.IOException
 *          if an I/O error occurs
 * @throws  java.lang.SecurityException
 *          In the case of the default provider, and a security manager is
 *          installed, the {@link java.lang.SecurityManager#checkWrite(java.lang.String) SecurityManager#checkWrite(String)}
 *          method is invoked to check write access to both the source and
 *          target file.
 * @apiSince 26
 */

public static java.nio.file.Path move(java.nio.file.Path source, java.nio.file.Path target, java.nio.file.CopyOption... options) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Reads the target of a symbolic link <i>(optional operation)</i>.
 *
 * <p> If the file system supports <a href="package-summary.html#links">symbolic
 * links</a> then this method is used to read the target of the link, failing
 * if the file is not a symbolic link. The target of the link need not exist.
 * The returned {@code Path} object will be associated with the same file
 * system as {@code link}.
 *
 * @param   link
 *          the path to the symbolic link
 *
 * @return  a {@code Path} object representing the target of the link
 *
 * @throws  java.lang.UnsupportedOperationException
 *          if the implementation does not support symbolic links
 * @throws  java.nio.file.NotLinkException
 *          if the target could otherwise not be read because the file
 *          is not a symbolic link <i>(optional specific exception)</i>
 * @throws  java.io.IOException
 *          if an I/O error occurs
 * @throws  java.lang.SecurityException
 *          In the case of the default provider, and a security manager
 *          is installed, it checks that {@code FilePermission} has been
 *          granted with the "{@code readlink}" action to read the link.
 * @apiSince 26
 */

public static java.nio.file.Path readSymbolicLink(java.nio.file.Path link) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@link java.nio.file.FileStore FileStore} representing the file store where a file
 * is located.
 *
 * <p> Once a reference to the {@code FileStore} is obtained it is
 * implementation specific if operations on the returned {@code FileStore},
 * or {@link java.nio.file.attribute.FileStoreAttributeView FileStoreAttributeView} objects obtained from it, continue
 * to depend on the existence of the file. In particular the behavior is not
 * defined for the case that the file is deleted or moved to a different
 * file store.
 *
 * @param   path
 *          the path to the file
 *
 * @return  the file store where the file is stored
 *
 * @throws  java.io.IOException
 *          if an I/O error occurs
 * @throws  java.lang.SecurityException
 *          In the case of the default provider, and a security manager is
 *          installed, the {@link java.lang.SecurityManager#checkRead(java.lang.String) SecurityManager#checkRead(String)}
 *          method is invoked to check read access to the file, and in
 *          addition it checks {@link java.lang.RuntimePermission RuntimePermission}<tt>
 *          ("getFileStoreAttributes")</tt>
 * @apiSince 26
 */

public static java.nio.file.FileStore getFileStore(java.nio.file.Path path) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Tests if two paths locate the same file.
 *
 * <p> If both {@code Path} objects are {@link java.nio.file.Path#equals(java.lang.Object) Path#equals(Object)}
 * then this method returns {@code true} without checking if the file exists.
 * If the two {@code Path} objects are associated with different providers
 * then this method returns {@code false}. Otherwise, this method checks if
 * both {@code Path} objects locate the same file, and depending on the
 * implementation, may require to open or access both files.
 *
 * <p> If the file system and files remain static, then this method implements
 * an equivalence relation for non-null {@code Paths}.
 * <ul>
 * <li>It is <i>reflexive</i>: for {@code Path} {@code f},
 *     {@code isSameFile(f,f)} should return {@code true}.
 * <li>It is <i>symmetric</i>: for two {@code Paths} {@code f} and {@code g},
 *     {@code isSameFile(f,g)} will equal {@code isSameFile(g,f)}.
 * <li>It is <i>transitive</i>: for three {@code Paths}
 *     {@code f}, {@code g}, and {@code h}, if {@code isSameFile(f,g)} returns
 *     {@code true} and {@code isSameFile(g,h)} returns {@code true}, then
 *     {@code isSameFile(f,h)} will return return {@code true}.
 * </ul>
 *
 * @param   path
 *          one path to the file
 * @param   path2
 *          the other path
 *
 * @return  {@code true} if, and only if, the two paths locate the same file
 *
 * @throws  java.io.IOException
 *          if an I/O error occurs
 * @throws  java.lang.SecurityException
 *          In the case of the default provider, and a security manager is
 *          installed, the {@link java.lang.SecurityManager#checkRead(java.lang.String) SecurityManager#checkRead(String)}
 *          method is invoked to check read access to both files.
 *
 * @see java.nio.file.attribute.BasicFileAttributes#fileKey
 * @apiSince 26
 */

public static boolean isSameFile(java.nio.file.Path path, java.nio.file.Path path2) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Tells whether or not a file is considered <em>hidden</em>. The exact
 * definition of hidden is platform or provider dependent. On UNIX for
 * example a file is considered to be hidden if its name begins with a
 * period character ('.'). On Windows a file is considered hidden if it
 * isn't a directory and the DOS {@link java.nio.file.attribute.DosFileAttributes#isHidden DosFileAttributes#isHidden}
 * attribute is set.
 *
 * <p> Depending on the implementation this method may require to access
 * the file system to determine if the file is considered hidden.
 *
 * @param   path
 *          the path to the file to test
 *
 * @return  {@code true} if the file is considered hidden
 *
 * @throws  java.io.IOException
 *          if an I/O error occurs
 * @throws  java.lang.SecurityException
 *          In the case of the default provider, and a security manager is
 *          installed, the {@link java.lang.SecurityManager#checkRead(java.lang.String) SecurityManager#checkRead(String)}
 *          method is invoked to check read access to the file.
 * @apiSince 26
 */

public static boolean isHidden(java.nio.file.Path path) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Probes the content type of a file.
 *
 * <p> This method uses the installed {@link java.nio.file.spi.FileTypeDetector FileTypeDetector} implementations
 * to probe the given file to determine its content type. Each file type
 * detector's {@link java.nio.file.spi.FileTypeDetector#probeContentType FileTypeDetector#probeContentType} is
 * invoked, in turn, to probe the file type. If the file is recognized then
 * the content type is returned. If the file is not recognized by any of the
 * installed file type detectors then a system-default file type detector is
 * invoked to guess the content type.
 *
 * <p> A given invocation of the Java virtual machine maintains a system-wide
 * list of file type detectors. Installed file type detectors are loaded
 * using the service-provider loading facility defined by the {@link java.util.ServiceLoader ServiceLoader}
 * class. Installed file type detectors are loaded using the system class
 * loader. If the system class loader cannot be found then the extension class
 * loader is used; If the extension class loader cannot be found then the
 * bootstrap class loader is used. File type detectors are typically installed
 * by placing them in a JAR file on the application class path or in the
 * extension directory, the JAR file contains a provider-configuration file
 * named {@code java.nio.file.spi.FileTypeDetector} in the resource directory
 * {@code META-INF/services}, and the file lists one or more fully-qualified
 * names of concrete subclass of {@code FileTypeDetector } that have a zero
 * argument constructor. If the process of locating or instantiating the
 * installed file type detectors fails then an unspecified error is thrown.
 * The ordering that installed providers are located is implementation
 * specific.
 *
 * <p> The return value of this method is the string form of the value of a
 * Multipurpose Internet Mail Extension (MIME) content type as
 * defined by <a href="http://www.ietf.org/rfc/rfc2045.txt"><i>RFC&nbsp;2045:
 * Multipurpose Internet Mail Extensions (MIME) Part One: Format of Internet
 * Message Bodies</i></a>. The string is guaranteed to be parsable according
 * to the grammar in the RFC.
 *
 * @param   path
 *          the path to the file to probe
 *
 * @return  The content type of the file, or {@code null} if the content
 *          type cannot be determined
 *
 * @throws  java.io.IOException
 *          if an I/O error occurs
 * @throws  java.lang.SecurityException
 *          If a security manager is installed and it denies an unspecified
 *          permission required by a file type detector implementation.
 * @apiSince 26
 */

public static java.lang.String probeContentType(java.nio.file.Path path) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Returns a file attribute view of a given type.
 *
 * <p> A file attribute view provides a read-only or updatable view of a
 * set of file attributes. This method is intended to be used where the file
 * attribute view defines type-safe methods to read or update the file
 * attributes. The {@code type} parameter is the type of the attribute view
 * required and the method returns an instance of that type if supported.
 * The {@link java.nio.file.attribute.BasicFileAttributeView BasicFileAttributeView} type supports access to the basic
 * attributes of a file. Invoking this method to select a file attribute
 * view of that type will always return an instance of that class.
 *
 * <p> The {@code options} array may be used to indicate how symbolic links
 * are handled by the resulting file attribute view for the case that the
 * file is a symbolic link. By default, symbolic links are followed. If the
 * option {@link java.nio.file.LinkOption#NOFOLLOW_LINKS LinkOption#NOFOLLOW_LINKS} is present then
 * symbolic links are not followed. This option is ignored by implementations
 * that do not support symbolic links.
 *
 * <p> <b>Usage Example:</b>
 * Suppose we want read or set a file's ACL, if supported:
 * <pre>
 *     Path path = ...
 *     AclFileAttributeView view = Files.getFileAttributeView(path, AclFileAttributeView.class);
 *     if (view != null) {
 *         List&lt;AclEntry&gt; acl = view.getAcl();
 *         :
 *     }
 * </pre>
 *
 * @param   <V>
 *          The {@code FileAttributeView} type
 * @param   path
 *          the path to the file
 * @param   type
 *          the {@code Class} object corresponding to the file attribute view
 * @param   options
 *          options indicating how symbolic links are handled
 *
 * @return  a file attribute view of the specified type, or {@code null} if
 *          the attribute view type is not available
 * @apiSince 26
 */

public static <V extends java.nio.file.attribute.FileAttributeView> V getFileAttributeView(java.nio.file.Path path, java.lang.Class<V> type, java.nio.file.LinkOption... options) { throw new RuntimeException("Stub!"); }

/**
 * Reads a file's attributes as a bulk operation.
 *
 * <p> The {@code type} parameter is the type of the attributes required
 * and this method returns an instance of that type if supported. All
 * implementations support a basic set of file attributes and so invoking
 * this method with a  {@code type} parameter of {@code
 * BasicFileAttributes.class} will not throw {@code
 * UnsupportedOperationException}.
 *
 * <p> The {@code options} array may be used to indicate how symbolic links
 * are handled for the case that the file is a symbolic link. By default,
 * symbolic links are followed and the file attribute of the final target
 * of the link is read. If the option {@link java.nio.file.LinkOption#NOFOLLOW_LINKS LinkOption#NOFOLLOW_LINKS} is present then symbolic links are not followed.
 *
 * <p> It is implementation specific if all file attributes are read as an
 * atomic operation with respect to other file system operations.
 *
 * <p> <b>Usage Example:</b>
 * Suppose we want to read a file's attributes in bulk:
 * <pre>
 *    Path path = ...
 *    BasicFileAttributes attrs = Files.readAttributes(path, BasicFileAttributes.class);
 * </pre>
 * Alternatively, suppose we want to read file's POSIX attributes without
 * following symbolic links:
 * <pre>
 *    PosixFileAttributes attrs = Files.readAttributes(path, PosixFileAttributes.class, NOFOLLOW_LINKS);
 * </pre>
 *
 * @param   <A>
 *          The {@code BasicFileAttributes} type
 * @param   path
 *          the path to the file
 * @param   type
 *          the {@code Class} of the file attributes required
 *          to read
 * @param   options
 *          options indicating how symbolic links are handled
 *
 * @return  the file attributes
 *
 * @throws  java.lang.UnsupportedOperationException
 *          if an attributes of the given type are not supported
 * @throws  java.io.IOException
 *          if an I/O error occurs
 * @throws  java.lang.SecurityException
 *          In the case of the default provider, a security manager is
 *          installed, its {@link java.lang.SecurityManager#checkRead(java.lang.String) SecurityManager#checkRead(String)}
 *          method is invoked to check read access to the file. If this
 *          method is invoked to read security sensitive attributes then the
 *          security manager may be invoke to check for additional permissions.
 * @apiSince 26
 */

public static <A extends java.nio.file.attribute.BasicFileAttributes> A readAttributes(java.nio.file.Path path, java.lang.Class<A> type, java.nio.file.LinkOption... options) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Sets the value of a file attribute.
 *
 * <p> The {@code attribute} parameter identifies the attribute to be set
 * and takes the form:
 * <blockquote>
 * [<i>view-name</i><b>:</b>]<i>attribute-name</i>
 * </blockquote>
 * where square brackets [...] delineate an optional component and the
 * character {@code ':'} stands for itself.
 *
 * <p> <i>view-name</i> is the {@link java.nio.file.attribute.FileAttributeView#name FileAttributeView#name} of a {@link java.nio.file.attribute.FileAttributeView FileAttributeView} that identifies a set of file attributes. If not
 * specified then it defaults to {@code "basic"}, the name of the file
 * attribute view that identifies the basic set of file attributes common to
 * many file systems. <i>attribute-name</i> is the name of the attribute
 * within the set.
 *
 * <p> The {@code options} array may be used to indicate how symbolic links
 * are handled for the case that the file is a symbolic link. By default,
 * symbolic links are followed and the file attribute of the final target
 * of the link is set. If the option {@link java.nio.file.LinkOption#NOFOLLOW_LINKS LinkOption#NOFOLLOW_LINKS} is present then symbolic links are not followed.
 *
 * <p> <b>Usage Example:</b>
 * Suppose we want to set the DOS "hidden" attribute:
 * <pre>
 *    Path path = ...
 *    Files.setAttribute(path, "dos:hidden", true);
 * </pre>
 *
 * @param   path
 *          the path to the file
 * @param   attribute
 *          the attribute to set
 * @param   value
 *          the attribute value
 * @param   options
 *          options indicating how symbolic links are handled
 *
 * @return  the {@code path} parameter
 *
 * @throws  java.lang.UnsupportedOperationException
 *          if the attribute view is not available
 * @throws  java.lang.IllegalArgumentException
 *          if the attribute name is not specified, or is not recognized, or
 *          the attribute value is of the correct type but has an
 *          inappropriate value
 * @throws  java.lang.ClassCastException
 *          if the attribute value is not of the expected type or is a
 *          collection containing elements that are not of the expected
 *          type
 * @throws  java.io.IOException
 *          if an I/O error occurs
 * @throws  java.lang.SecurityException
 *          In the case of the default provider, and a security manager is
 *          installed, its {@link java.lang.SecurityManager#checkWrite(java.lang.String) SecurityManager#checkWrite(String)}
 *          method denies write access to the file. If this method is invoked
 *          to set security sensitive attributes then the security manager
 *          may be invoked to check for additional permissions.
 * @apiSince 26
 */

public static java.nio.file.Path setAttribute(java.nio.file.Path path, java.lang.String attribute, java.lang.Object value, java.nio.file.LinkOption... options) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Reads the value of a file attribute.
 *
 * <p> The {@code attribute} parameter identifies the attribute to be read
 * and takes the form:
 * <blockquote>
 * [<i>view-name</i><b>:</b>]<i>attribute-name</i>
 * </blockquote>
 * where square brackets [...] delineate an optional component and the
 * character {@code ':'} stands for itself.
 *
 * <p> <i>view-name</i> is the {@link java.nio.file.attribute.FileAttributeView#name FileAttributeView#name} of a {@link java.nio.file.attribute.FileAttributeView FileAttributeView} that identifies a set of file attributes. If not
 * specified then it defaults to {@code "basic"}, the name of the file
 * attribute view that identifies the basic set of file attributes common to
 * many file systems. <i>attribute-name</i> is the name of the attribute.
 *
 * <p> The {@code options} array may be used to indicate how symbolic links
 * are handled for the case that the file is a symbolic link. By default,
 * symbolic links are followed and the file attribute of the final target
 * of the link is read. If the option {@link java.nio.file.LinkOption#NOFOLLOW_LINKS LinkOption#NOFOLLOW_LINKS} is present then symbolic links are not followed.
 *
 * <p> <b>Usage Example:</b>
 * Suppose we require the user ID of the file owner on a system that
 * supports a "{@code unix}" view:
 * <pre>
 *    Path path = ...
 *    int uid = (Integer)Files.getAttribute(path, "unix:uid");
 * </pre>
 *
 * @param   path
 *          the path to the file
 * @param   attribute
 *          the attribute to read
 * @param   options
 *          options indicating how symbolic links are handled
 *
 * @return  the attribute value
 *
 * @throws  java.lang.UnsupportedOperationException
 *          if the attribute view is not available
 * @throws  java.lang.IllegalArgumentException
 *          if the attribute name is not specified or is not recognized
 * @throws  java.io.IOException
 *          if an I/O error occurs
 * @throws  java.lang.SecurityException
 *          In the case of the default provider, and a security manager is
 *          installed, its {@link java.lang.SecurityManager#checkRead(java.lang.String) SecurityManager#checkRead(String)}
 *          method denies read access to the file. If this method is invoked
 *          to read security sensitive attributes then the security manager
 *          may be invoked to check for additional permissions.
 * @apiSince 26
 */

public static java.lang.Object getAttribute(java.nio.file.Path path, java.lang.String attribute, java.nio.file.LinkOption... options) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Reads a set of file attributes as a bulk operation.
 *
 * <p> The {@code attributes} parameter identifies the attributes to be read
 * and takes the form:
 * <blockquote>
 * [<i>view-name</i><b>:</b>]<i>attribute-list</i>
 * </blockquote>
 * where square brackets [...] delineate an optional component and the
 * character {@code ':'} stands for itself.
 *
 * <p> <i>view-name</i> is the {@link java.nio.file.attribute.FileAttributeView#name FileAttributeView#name} of a {@link java.nio.file.attribute.FileAttributeView FileAttributeView} that identifies a set of file attributes. If not
 * specified then it defaults to {@code "basic"}, the name of the file
 * attribute view that identifies the basic set of file attributes common to
 * many file systems.
 *
 * <p> The <i>attribute-list</i> component is a comma separated list of
 * zero or more names of attributes to read. If the list contains the value
 * {@code "*"} then all attributes are read. Attributes that are not supported
 * are ignored and will not be present in the returned map. It is
 * implementation specific if all attributes are read as an atomic operation
 * with respect to other file system operations.
 *
 * <p> The following examples demonstrate possible values for the {@code
 * attributes} parameter:
 *
 * <blockquote>
 * <table border="0" summary="Possible values">
 * <tr>
 *   <td> {@code "*"} </td>
 *   <td> Read all {@link java.nio.file.attribute.BasicFileAttributes BasicFileAttributes}. </td>
 * </tr>
 * <tr>
 *   <td> {@code "size,lastModifiedTime,lastAccessTime"} </td>
 *   <td> Reads the file size, last modified time, and last access time
 *     attributes. </td>
 * </tr>
 * <tr>
 *   <td> {@code "posix:*"} </td>
 *   <td> Read all {@link java.nio.file.attribute.PosixFileAttributes PosixFileAttributes}. </td>
 * </tr>
 * <tr>
 *   <td> {@code "posix:permissions,owner,size"} </td>
 *   <td> Reads the POSX file permissions, owner, and file size. </td>
 * </tr>
 * </table>
 * </blockquote>
 *
 * <p> The {@code options} array may be used to indicate how symbolic links
 * are handled for the case that the file is a symbolic link. By default,
 * symbolic links are followed and the file attribute of the final target
 * of the link is read. If the option {@link java.nio.file.LinkOption#NOFOLLOW_LINKS LinkOption#NOFOLLOW_LINKS} is present then symbolic links are not followed.
 *
 * @param   path
 *          the path to the file
 * @param   attributes
 *          the attributes to read
 * @param   options
 *          options indicating how symbolic links are handled
 *
 * @return  a map of the attributes returned; The map's keys are the
 *          attribute names, its values are the attribute values
 *
 * @throws  java.lang.UnsupportedOperationException
 *          if the attribute view is not available
 * @throws  java.lang.IllegalArgumentException
 *          if no attributes are specified or an unrecognized attributes is
 *          specified
 * @throws  java.io.IOException
 *          if an I/O error occurs
 * @throws  java.lang.SecurityException
 *          In the case of the default provider, and a security manager is
 *          installed, its {@link java.lang.SecurityManager#checkRead(java.lang.String) SecurityManager#checkRead(String)}
 *          method denies read access to the file. If this method is invoked
 *          to read security sensitive attributes then the security manager
 *          may be invoke to check for additional permissions.
 * @apiSince 26
 */

public static java.util.Map<java.lang.String,java.lang.Object> readAttributes(java.nio.file.Path path, java.lang.String attributes, java.nio.file.LinkOption... options) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Returns a file's POSIX file permissions.
 *
 * <p> The {@code path} parameter is associated with a {@code FileSystem}
 * that supports the {@link java.nio.file.attribute.PosixFileAttributeView PosixFileAttributeView}. This attribute view
 * provides access to file attributes commonly associated with files on file
 * systems used by operating systems that implement the Portable Operating
 * System Interface (POSIX) family of standards.
 *
 * <p> The {@code options} array may be used to indicate how symbolic links
 * are handled for the case that the file is a symbolic link. By default,
 * symbolic links are followed and the file attribute of the final target
 * of the link is read. If the option {@link java.nio.file.LinkOption#NOFOLLOW_LINKS LinkOption#NOFOLLOW_LINKS} is present then symbolic links are not followed.
 *
 * @param   path
 *          the path to the file
 * @param   options
 *          options indicating how symbolic links are handled
 *
 * @return  the file permissions
 *
 * @throws  java.lang.UnsupportedOperationException
 *          if the associated file system does not support the {@code
 *          PosixFileAttributeView}
 * @throws  java.io.IOException
 *          if an I/O error occurs
 * @throws  java.lang.SecurityException
 *          In the case of the default provider, a security manager is
 *          installed, and it denies {@link java.lang.RuntimePermission RuntimePermission}<tt>("accessUserInformation")</tt>
 *          or its {@link java.lang.SecurityManager#checkRead(java.lang.String) SecurityManager#checkRead(String)} method
 *          denies read access to the file.
 * @apiSince 26
 */

public static java.util.Set<java.nio.file.attribute.PosixFilePermission> getPosixFilePermissions(java.nio.file.Path path, java.nio.file.LinkOption... options) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Sets a file's POSIX permissions.
 *
 * <p> The {@code path} parameter is associated with a {@code FileSystem}
 * that supports the {@link java.nio.file.attribute.PosixFileAttributeView PosixFileAttributeView}. This attribute view
 * provides access to file attributes commonly associated with files on file
 * systems used by operating systems that implement the Portable Operating
 * System Interface (POSIX) family of standards.
 *
 * @param   path
 *          The path to the file
 * @param   perms
 *          The new set of permissions
 *
 * @return  The path
 *
 * @throws  java.lang.UnsupportedOperationException
 *          if the associated file system does not support the {@code
 *          PosixFileAttributeView}
 * @throws  java.lang.ClassCastException
 *          if the sets contains elements that are not of type {@code
 *          PosixFilePermission}
 * @throws  java.io.IOException
 *          if an I/O error occurs
 * @throws  java.lang.SecurityException
 *          In the case of the default provider, and a security manager is
 *          installed, it denies {@link java.lang.RuntimePermission RuntimePermission}<tt>("accessUserInformation")</tt>
 *          or its {@link java.lang.SecurityManager#checkWrite(java.lang.String) SecurityManager#checkWrite(String)}
 *          method denies write access to the file.
 * @apiSince 26
 */

public static java.nio.file.Path setPosixFilePermissions(java.nio.file.Path path, java.util.Set<java.nio.file.attribute.PosixFilePermission> perms) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Returns the owner of a file.
 *
 * <p> The {@code path} parameter is associated with a file system that
 * supports {@link java.nio.file.attribute.FileOwnerAttributeView FileOwnerAttributeView}. This file attribute view provides
 * access to a file attribute that is the owner of the file.
 *
 * @param   path
 *          The path to the file
 * @param   options
 *          options indicating how symbolic links are handled
 *
 * @return  A user principal representing the owner of the file
 *
 * @throws  java.lang.UnsupportedOperationException
 *          if the associated file system does not support the {@code
 *          FileOwnerAttributeView}
 * @throws  java.io.IOException
 *          if an I/O error occurs
 * @throws  java.lang.SecurityException
 *          In the case of the default provider, and a security manager is
 *          installed, it denies {@link java.lang.RuntimePermission RuntimePermission}<tt>("accessUserInformation")</tt>
 *          or its {@link java.lang.SecurityManager#checkRead(java.lang.String) SecurityManager#checkRead(String)} method
 *          denies read access to the file.
 * @apiSince 26
 */

public static java.nio.file.attribute.UserPrincipal getOwner(java.nio.file.Path path, java.nio.file.LinkOption... options) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Updates the file owner.
 *
 * <p> The {@code path} parameter is associated with a file system that
 * supports {@link java.nio.file.attribute.FileOwnerAttributeView FileOwnerAttributeView}. This file attribute view provides
 * access to a file attribute that is the owner of the file.
 *
 * <p> <b>Usage Example:</b>
 * Suppose we want to make "joe" the owner of a file:
 * <pre>
 *     Path path = ...
 *     UserPrincipalLookupService lookupService =
 *         provider(path).getUserPrincipalLookupService();
 *     UserPrincipal joe = lookupService.lookupPrincipalByName("joe");
 *     Files.setOwner(path, joe);
 * </pre>
 *
 * @param   path
 *          The path to the file
 * @param   owner
 *          The new file owner
 *
 * @return  The path
 *
 * @throws  java.lang.UnsupportedOperationException
 *          if the associated file system does not support the {@code
 *          FileOwnerAttributeView}
 * @throws  java.io.IOException
 *          if an I/O error occurs
 * @throws  java.lang.SecurityException
 *          In the case of the default provider, and a security manager is
 *          installed, it denies {@link java.lang.RuntimePermission RuntimePermission}<tt>("accessUserInformation")</tt>
 *          or its {@link java.lang.SecurityManager#checkWrite(java.lang.String) SecurityManager#checkWrite(String)}
 *          method denies write access to the file.
 *
 * @see java.nio.file.FileSystem#getUserPrincipalLookupService
 * @see java.nio.file.attribute.UserPrincipalLookupService
 * @apiSince 26
 */

public static java.nio.file.Path setOwner(java.nio.file.Path path, java.nio.file.attribute.UserPrincipal owner) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Tests whether a file is a symbolic link.
 *
 * <p> Where it is required to distinguish an I/O exception from the case
 * that the file is not a symbolic link then the file attributes can be
 * read with the {@link #readAttributes(java.nio.file.Path,java.lang.Class,java.nio.file.LinkOption[])
 * readAttributes} method and the file type tested with the {@link java.nio.file.attribute.BasicFileAttributes#isSymbolicLink BasicFileAttributes#isSymbolicLink} method.
 *
 * @param   path  The path to the file
 *
 * @return  {@code true} if the file is a symbolic link; {@code false} if
 *          the file does not exist, is not a symbolic link, or it cannot
 *          be determined if the file is a symbolic link or not.
 *
 * @throws  java.lang.SecurityException
 *          In the case of the default provider, and a security manager is
 *          installed, its {@link java.lang.SecurityManager#checkRead(java.lang.String) SecurityManager#checkRead(String)}
 *          method denies read access to the file.
 * @apiSince 26
 */

public static boolean isSymbolicLink(java.nio.file.Path path) { throw new RuntimeException("Stub!"); }

/**
 * Tests whether a file is a directory.
 *
 * <p> The {@code options} array may be used to indicate how symbolic links
 * are handled for the case that the file is a symbolic link. By default,
 * symbolic links are followed and the file attribute of the final target
 * of the link is read. If the option {@link java.nio.file.LinkOption#NOFOLLOW_LINKS LinkOption#NOFOLLOW_LINKS} is present then symbolic links are not followed.
 *
 * <p> Where it is required to distinguish an I/O exception from the case
 * that the file is not a directory then the file attributes can be
 * read with the {@link #readAttributes(java.nio.file.Path,java.lang.Class,java.nio.file.LinkOption[])
 * readAttributes} method and the file type tested with the {@link java.nio.file.attribute.BasicFileAttributes#isDirectory BasicFileAttributes#isDirectory} method.
 *
 * @param   path
 *          the path to the file to test
 * @param   options
 *          options indicating how symbolic links are handled
 *
 * @return  {@code true} if the file is a directory; {@code false} if
 *          the file does not exist, is not a directory, or it cannot
 *          be determined if the file is a directory or not.
 *
 * @throws  java.lang.SecurityException
 *          In the case of the default provider, and a security manager is
 *          installed, its {@link java.lang.SecurityManager#checkRead(java.lang.String) SecurityManager#checkRead(String)}
 *          method denies read access to the file.
 * @apiSince 26
 */

public static boolean isDirectory(java.nio.file.Path path, java.nio.file.LinkOption... options) { throw new RuntimeException("Stub!"); }

/**
 * Tests whether a file is a regular file with opaque content.
 *
 * <p> The {@code options} array may be used to indicate how symbolic links
 * are handled for the case that the file is a symbolic link. By default,
 * symbolic links are followed and the file attribute of the final target
 * of the link is read. If the option {@link java.nio.file.LinkOption#NOFOLLOW_LINKS LinkOption#NOFOLLOW_LINKS} is present then symbolic links are not followed.
 *
 * <p> Where it is required to distinguish an I/O exception from the case
 * that the file is not a regular file then the file attributes can be
 * read with the {@link #readAttributes(java.nio.file.Path,java.lang.Class,java.nio.file.LinkOption[])
 * readAttributes} method and the file type tested with the {@link java.nio.file.attribute.BasicFileAttributes#isRegularFile BasicFileAttributes#isRegularFile} method.
 *
 * @param   path
 *          the path to the file
 * @param   options
 *          options indicating how symbolic links are handled
 *
 * @return  {@code true} if the file is a regular file; {@code false} if
 *          the file does not exist, is not a regular file, or it
 *          cannot be determined if the file is a regular file or not.
 *
 * @throws  java.lang.SecurityException
 *          In the case of the default provider, and a security manager is
 *          installed, its {@link java.lang.SecurityManager#checkRead(java.lang.String) SecurityManager#checkRead(String)}
 *          method denies read access to the file.
 * @apiSince 26
 */

public static boolean isRegularFile(java.nio.file.Path path, java.nio.file.LinkOption... options) { throw new RuntimeException("Stub!"); }

/**
 * Returns a file's last modified time.
 *
 * <p> The {@code options} array may be used to indicate how symbolic links
 * are handled for the case that the file is a symbolic link. By default,
 * symbolic links are followed and the file attribute of the final target
 * of the link is read. If the option {@link java.nio.file.LinkOption#NOFOLLOW_LINKS LinkOption#NOFOLLOW_LINKS} is present then symbolic links are not followed.
 *
 * @param   path
 *          the path to the file
 * @param   options
 *          options indicating how symbolic links are handled
 *
 * @return  a {@code FileTime} representing the time the file was last
 *          modified, or an implementation specific default when a time
 *          stamp to indicate the time of last modification is not supported
 *          by the file system
 *
 * @throws  java.io.IOException
 *          if an I/O error occurs
 * @throws  java.lang.SecurityException
 *          In the case of the default provider, and a security manager is
 *          installed, its {@link java.lang.SecurityManager#checkRead(java.lang.String) SecurityManager#checkRead(String)}
 *          method denies read access to the file.
 *
 * @see java.nio.file.attribute.BasicFileAttributes#lastModifiedTime
 * @apiSince 26
 */

public static java.nio.file.attribute.FileTime getLastModifiedTime(java.nio.file.Path path, java.nio.file.LinkOption... options) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Updates a file's last modified time attribute. The file time is converted
 * to the epoch and precision supported by the file system. Converting from
 * finer to coarser granularities result in precision loss. The behavior of
 * this method when attempting to set the last modified time when it is not
 * supported by the file system or is outside the range supported by the
 * underlying file store is not defined. It may or not fail by throwing an
 * {@code IOException}.
 *
 * <p> <b>Usage Example:</b>
 * Suppose we want to set the last modified time to the current time:
 * <pre>
 *    Path path = ...
 *    FileTime now = FileTime.fromMillis(System.currentTimeMillis());
 *    Files.setLastModifiedTime(path, now);
 * </pre>
 *
 * @param   path
 *          the path to the file
 * @param   time
 *          the new last modified time
 *
 * @return  the path
 *
 * @throws  java.io.IOException
 *          if an I/O error occurs
 * @throws  java.lang.SecurityException
 *          In the case of the default provider, the security manager's {@link java.lang.SecurityManager#checkWrite(java.lang.String) SecurityManager#checkWrite(String)} method is invoked
 *          to check write access to file
 *
 * @see java.nio.file.attribute.BasicFileAttributeView#setTimes
 * @apiSince 26
 */

public static java.nio.file.Path setLastModifiedTime(java.nio.file.Path path, java.nio.file.attribute.FileTime time) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Returns the size of a file (in bytes). The size may differ from the
 * actual size on the file system due to compression, support for sparse
 * files, or other reasons. The size of files that are not {@link
 * #isRegularFile regular} files is implementation specific and
 * therefore unspecified.
 *
 * @param   path
 *          the path to the file
 *
 * @return  the file size, in bytes
 *
 * @throws  java.io.IOException
 *          if an I/O error occurs
 * @throws  java.lang.SecurityException
 *          In the case of the default provider, and a security manager is
 *          installed, its {@link java.lang.SecurityManager#checkRead(java.lang.String) SecurityManager#checkRead(String)}
 *          method denies read access to the file.
 *
 * @see java.nio.file.attribute.BasicFileAttributes#size
 * @apiSince 26
 */

public static long size(java.nio.file.Path path) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Tests whether a file exists.
 *
 * <p> The {@code options} parameter may be used to indicate how symbolic links
 * are handled for the case that the file is a symbolic link. By default,
 * symbolic links are followed. If the option {@link java.nio.file.LinkOption#NOFOLLOW_LINKS LinkOption#NOFOLLOW_LINKS} is present then symbolic links are not followed.
 *
 * <p> Note that the result of this method is immediately outdated. If this
 * method indicates the file exists then there is no guarantee that a
 * subsequence access will succeed. Care should be taken when using this
 * method in security sensitive applications.
 *
 * @param   path
 *          the path to the file to test
 * @param   options
 *          options indicating how symbolic links are handled
 * .
 * @return  {@code true} if the file exists; {@code false} if the file does
 *          not exist or its existence cannot be determined.
 *
 * @throws  java.lang.SecurityException
 *          In the case of the default provider, the {@link java.lang.SecurityManager#checkRead(java.lang.String) SecurityManager#checkRead(String)} is invoked to check
 *          read access to the file.
 *
 * @see #notExists
 * @apiSince 26
 */

public static boolean exists(java.nio.file.Path path, java.nio.file.LinkOption... options) { throw new RuntimeException("Stub!"); }

/**
 * Tests whether the file located by this path does not exist. This method
 * is intended for cases where it is required to take action when it can be
 * confirmed that a file does not exist.
 *
 * <p> The {@code options} parameter may be used to indicate how symbolic links
 * are handled for the case that the file is a symbolic link. By default,
 * symbolic links are followed. If the option {@link java.nio.file.LinkOption#NOFOLLOW_LINKS LinkOption#NOFOLLOW_LINKS} is present then symbolic links are not followed.
 *
 * <p> Note that this method is not the complement of the {@link #exists
 * exists} method. Where it is not possible to determine if a file exists
 * or not then both methods return {@code false}. As with the {@code exists}
 * method, the result of this method is immediately outdated. If this
 * method indicates the file does exist then there is no guarantee that a
 * subsequence attempt to create the file will succeed. Care should be taken
 * when using this method in security sensitive applications.
 *
 * @param   path
 *          the path to the file to test
 * @param   options
 *          options indicating how symbolic links are handled
 *
 * @return  {@code true} if the file does not exist; {@code false} if the
 *          file exists or its existence cannot be determined
 *
 * @throws  java.lang.SecurityException
 *          In the case of the default provider, the {@link java.lang.SecurityManager#checkRead(java.lang.String) SecurityManager#checkRead(String)} is invoked to check
 *          read access to the file.
 * @apiSince 26
 */

public static boolean notExists(java.nio.file.Path path, java.nio.file.LinkOption... options) { throw new RuntimeException("Stub!"); }

/**
 * Tests whether a file is readable. This method checks that a file exists
 * and that this Java virtual machine has appropriate privileges that would
 * allow it open the file for reading. Depending on the implementation, this
 * method may require to read file permissions, access control lists, or
 * other file attributes in order to check the effective access to the file.
 * Consequently, this method may not be atomic with respect to other file
 * system operations.
 *
 * <p> Note that the result of this method is immediately outdated, there is
 * no guarantee that a subsequent attempt to open the file for reading will
 * succeed (or even that it will access the same file). Care should be taken
 * when using this method in security sensitive applications.
 *
 * @param   path
 *          the path to the file to check
 *
 * @return  {@code true} if the file exists and is readable; {@code false}
 *          if the file does not exist, read access would be denied because
 *          the Java virtual machine has insufficient privileges, or access
 *          cannot be determined
 *
 * @throws  java.lang.SecurityException
 *          In the case of the default provider, and a security manager is
 *          installed, the {@link java.lang.SecurityManager#checkRead(java.lang.String) SecurityManager#checkRead(String)}
 *          is invoked to check read access to the file.
 * @apiSince 26
 */

public static boolean isReadable(java.nio.file.Path path) { throw new RuntimeException("Stub!"); }

/**
 * Tests whether a file is writable. This method checks that a file exists
 * and that this Java virtual machine has appropriate privileges that would
 * allow it open the file for writing. Depending on the implementation, this
 * method may require to read file permissions, access control lists, or
 * other file attributes in order to check the effective access to the file.
 * Consequently, this method may not be atomic with respect to other file
 * system operations.
 *
 * <p> Note that result of this method is immediately outdated, there is no
 * guarantee that a subsequent attempt to open the file for writing will
 * succeed (or even that it will access the same file). Care should be taken
 * when using this method in security sensitive applications.
 *
 * @param   path
 *          the path to the file to check
 *
 * @return  {@code true} if the file exists and is writable; {@code false}
 *          if the file does not exist, write access would be denied because
 *          the Java virtual machine has insufficient privileges, or access
 *          cannot be determined
 *
 * @throws  java.lang.SecurityException
 *          In the case of the default provider, and a security manager is
 *          installed, the {@link java.lang.SecurityManager#checkWrite(java.lang.String) SecurityManager#checkWrite(String)}
 *          is invoked to check write access to the file.
 * @apiSince 26
 */

public static boolean isWritable(java.nio.file.Path path) { throw new RuntimeException("Stub!"); }

/**
 * Tests whether a file is executable. This method checks that a file exists
 * and that this Java virtual machine has appropriate privileges to {@link java.lang.Runtime#exec Runtime#exec} the file. The semantics may differ when checking
 * access to a directory. For example, on UNIX systems, checking for
 * execute access checks that the Java virtual machine has permission to
 * search the directory in order to access file or subdirectories.
 *
 * <p> Depending on the implementation, this method may require to read file
 * permissions, access control lists, or other file attributes in order to
 * check the effective access to the file. Consequently, this method may not
 * be atomic with respect to other file system operations.
 *
 * <p> Note that the result of this method is immediately outdated, there is
 * no guarantee that a subsequent attempt to execute the file will succeed
 * (or even that it will access the same file). Care should be taken when
 * using this method in security sensitive applications.
 *
 * @param   path
 *          the path to the file to check
 *
 * @return  {@code true} if the file exists and is executable; {@code false}
 *          if the file does not exist, execute access would be denied because
 *          the Java virtual machine has insufficient privileges, or access
 *          cannot be determined
 *
 * @throws  java.lang.SecurityException
 *          In the case of the default provider, and a security manager is
 *          installed, the {@link java.lang.SecurityManager#checkExec(java.lang.String) SecurityManager#checkExec(String)} is invoked to check execute access to the file.
 * @apiSince 26
 */

public static boolean isExecutable(java.nio.file.Path path) { throw new RuntimeException("Stub!"); }

/**
 * Walks a file tree.
 *
 * <p> This method walks a file tree rooted at a given starting file. The
 * file tree traversal is <em>depth-first</em> with the given {@link java.nio.file.FileVisitor FileVisitor} invoked for each file encountered. File tree traversal
 * completes when all accessible files in the tree have been visited, or a
 * visit method returns a result of {@link java.nio.file.FileVisitResult#TERMINATE FileVisitResult#TERMINATE}. Where a visit method terminates due an {@code IOException},
 * an uncaught error, or runtime exception, then the traversal is terminated
 * and the error or exception is propagated to the caller of this method.
 *
 * <p> For each file encountered this method attempts to read its {@link
 * java.nio.file.attribute.BasicFileAttributes}. If the file is not a
 * directory then the {@link java.nio.file.FileVisitor#visitFile FileVisitor#visitFile} method is
 * invoked with the file attributes. If the file attributes cannot be read,
 * due to an I/O exception, then the {@link java.nio.file.FileVisitor#visitFileFailed FileVisitor#visitFileFailed} method is invoked with the I/O exception.
 *
 * <p> Where the file is a directory, and the directory could not be opened,
 * then the {@code visitFileFailed} method is invoked with the I/O exception,
 * after which, the file tree walk continues, by default, at the next
 * <em>sibling</em> of the directory.
 *
 * <p> Where the directory is opened successfully, then the entries in the
 * directory, and their <em>descendants</em> are visited. When all entries
 * have been visited, or an I/O error occurs during iteration of the
 * directory, then the directory is closed and the visitor's {@link java.nio.file.FileVisitor#postVisitDirectory FileVisitor#postVisitDirectory} method is invoked.
 * The file tree walk then continues, by default, at the next <em>sibling</em>
 * of the directory.
 *
 * <p> By default, symbolic links are not automatically followed by this
 * method. If the {@code options} parameter contains the {@link java.nio.file.FileVisitOption#FOLLOW_LINKS FileVisitOption#FOLLOW_LINKS} option then symbolic links are
 * followed. When following links, and the attributes of the target cannot
 * be read, then this method attempts to get the {@code BasicFileAttributes}
 * of the link. If they can be read then the {@code visitFile} method is
 * invoked with the attributes of the link (otherwise the {@code visitFileFailed}
 * method is invoked as specified above).
 *
 * <p> If the {@code options} parameter contains the {@link java.nio.file.FileVisitOption#FOLLOW_LINKS FileVisitOption#FOLLOW_LINKS} option then this method keeps
 * track of directories visited so that cycles can be detected. A cycle
 * arises when there is an entry in a directory that is an ancestor of the
 * directory. Cycle detection is done by recording the {@link
 * java.nio.file.attribute.BasicFileAttributes#fileKey file-key} of directories,
 * or if file keys are not available, by invoking the {@link #isSameFile
 * isSameFile} method to test if a directory is the same file as an
 * ancestor. When a cycle is detected it is treated as an I/O error, and the
 * {@link java.nio.file.FileVisitor#visitFileFailed FileVisitor#visitFileFailed} method is invoked with
 * an instance of {@link java.nio.file.FileSystemLoopException FileSystemLoopException}.
 *
 * <p> The {@code maxDepth} parameter is the maximum number of levels of
 * directories to visit. A value of {@code 0} means that only the starting
 * file is visited, unless denied by the security manager. A value of
 * {@link java.lang.Integer#MAX_VALUE Integer#MAX_VALUE} may be used to indicate that all
 * levels should be visited. The {@code visitFile} method is invoked for all
 * files, including directories, encountered at {@code maxDepth}, unless the
 * basic file attributes cannot be read, in which case the {@code
 * visitFileFailed} method is invoked.
 *
 * <p> If a visitor returns a result of {@code null} then {@code
 * NullPointerException} is thrown.
 *
 * <p> When a security manager is installed and it denies access to a file
 * (or directory), then it is ignored and the visitor is not invoked for
 * that file (or directory).
 *
 * @param   start
 *          the starting file
 * @param   options
 *          options to configure the traversal
 * @param   maxDepth
 *          the maximum number of directory levels to visit
 * @param   visitor
 *          the file visitor to invoke for each file
 *
 * @return  the starting file
 *
 * @throws  java.lang.IllegalArgumentException
 *          if the {@code maxDepth} parameter is negative
 * @throws  java.lang.SecurityException
 *          If the security manager denies access to the starting file.
 *          In the case of the default provider, the {@link java.lang.SecurityManager#checkRead(java.lang.String) SecurityManager#checkRead(String)} method is invoked
 *          to check read access to the directory.
 * @throws  java.io.IOException
 *          if an I/O error is thrown by a visitor method
 * @apiSince 26
 */

public static java.nio.file.Path walkFileTree(java.nio.file.Path start, java.util.Set<java.nio.file.FileVisitOption> options, int maxDepth, java.nio.file.FileVisitor<? super java.nio.file.Path> visitor) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Walks a file tree.
 *
 * <p> This method works as if invoking it were equivalent to evaluating the
 * expression:
 * <blockquote><pre>
 * walkFileTree(start, EnumSet.noneOf(FileVisitOption.class), Integer.MAX_VALUE, visitor)
 * </pre></blockquote>
 * In other words, it does not follow symbolic links, and visits all levels
 * of the file tree.
 *
 * @param   start
 *          the starting file
 * @param   visitor
 *          the file visitor to invoke for each file
 *
 * @return  the starting file
 *
 * @throws  java.lang.SecurityException
 *          If the security manager denies access to the starting file.
 *          In the case of the default provider, the {@link java.lang.SecurityManager#checkRead(java.lang.String) SecurityManager#checkRead(String)} method is invoked
 *          to check read access to the directory.
 * @throws  java.io.IOException
 *          if an I/O error is thrown by a visitor method
 * @apiSince 26
 */

public static java.nio.file.Path walkFileTree(java.nio.file.Path start, java.nio.file.FileVisitor<? super java.nio.file.Path> visitor) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Opens a file for reading, returning a {@code BufferedReader} that may be
 * used to read text from the file in an efficient manner. Bytes from the
 * file are decoded into characters using the specified charset. Reading
 * commences at the beginning of the file.
 *
 * <p> The {@code Reader} methods that read from the file throw {@code
 * IOException} if a malformed or unmappable byte sequence is read.
 *
 * @param   path
 *          the path to the file
 * @param   cs
 *          the charset to use for decoding
 *
 * @return  a new buffered reader, with default buffer size, to read text
 *          from the file
 *
 * @throws  java.io.IOException
 *          if an I/O error occurs opening the file
 * @throws  java.lang.SecurityException
 *          In the case of the default provider, and a security manager is
 *          installed, the {@link java.lang.SecurityManager#checkRead(java.lang.String) SecurityManager#checkRead(String)}
 *          method is invoked to check read access to the file.
 *
 * @see #readAllLines
 * @apiSince 26
 */

public static java.io.BufferedReader newBufferedReader(java.nio.file.Path path, java.nio.charset.Charset cs) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Opens a file for reading, returning a {@code BufferedReader} to read text
 * from the file in an efficient manner. Bytes from the file are decoded into
 * characters using the {@link java.nio.charset.StandardCharsets#UTF_8 StandardCharsets#UTF_8} {@link java.nio.charset.Charset Charset}.
 *
 * <p> This method works as if invoking it were equivalent to evaluating the
 * expression:
 * <pre>{@code
 * Files.newBufferedReader(path, StandardCharsets.UTF_8)
 * }</pre>
 *
 * @param   path
 *          the path to the file
 *
 * @return  a new buffered reader, with default buffer size, to read text
 *          from the file
 *
 * @throws  java.io.IOException
 *          if an I/O error occurs opening the file
 * @throws  java.lang.SecurityException
 *          In the case of the default provider, and a security manager is
 *          installed, the {@link java.lang.SecurityManager#checkRead(java.lang.String) SecurityManager#checkRead(String)}
 *          method is invoked to check read access to the file.
 *
 * @since 1.8
 * @apiSince 26
 */

public static java.io.BufferedReader newBufferedReader(java.nio.file.Path path) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Opens or creates a file for writing, returning a {@code BufferedWriter}
 * that may be used to write text to the file in an efficient manner.
 * The {@code options} parameter specifies how the the file is created or
 * opened. If no options are present then this method works as if the {@link java.nio.file.StandardOpenOption#CREATE StandardOpenOption#CREATE}, {@link java.nio.file.StandardOpenOption#TRUNCATE_EXISTING StandardOpenOption#TRUNCATE_EXISTING}, and {@link java.nio.file.StandardOpenOption#WRITE StandardOpenOption#WRITE} options are present. In other words, it
 * opens the file for writing, creating the file if it doesn't exist, or
 * initially truncating an existing {@link #isRegularFile regular-file} to
 * a size of {@code 0} if it exists.
 *
 * <p> The {@code Writer} methods to write text throw {@code IOException}
 * if the text cannot be encoded using the specified charset.
 *
 * @param   path
 *          the path to the file
 * @param   cs
 *          the charset to use for encoding
 * @param   options
 *          options specifying how the file is opened
 *
 * @return  a new buffered writer, with default buffer size, to write text
 *          to the file
 *
 * @throws  java.io.IOException
 *          if an I/O error occurs opening or creating the file
 * @throws  java.lang.UnsupportedOperationException
 *          if an unsupported option is specified
 * @throws  java.lang.SecurityException
 *          In the case of the default provider, and a security manager is
 *          installed, the {@link java.lang.SecurityManager#checkWrite(java.lang.String) SecurityManager#checkWrite(String)}
 *          method is invoked to check write access to the file.
 *
 * @see #write(Path,Iterable,Charset,OpenOption[])
 * @apiSince 26
 */

public static java.io.BufferedWriter newBufferedWriter(java.nio.file.Path path, java.nio.charset.Charset cs, java.nio.file.OpenOption... options) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Opens or creates a file for writing, returning a {@code BufferedWriter}
 * to write text to the file in an efficient manner. The text is encoded
 * into bytes for writing using the {@link java.nio.charset.StandardCharsets#UTF_8 StandardCharsets#UTF_8}
 * {@link java.nio.charset.Charset Charset}.
 *
 * <p> This method works as if invoking it were equivalent to evaluating the
 * expression:
 * <pre>{@code
 * Files.newBufferedWriter(path, StandardCharsets.UTF_8, options)
 * }</pre>
 *
 * @param   path
 *          the path to the file
 * @param   options
 *          options specifying how the file is opened
 *
 * @return  a new buffered writer, with default buffer size, to write text
 *          to the file
 *
 * @throws  java.io.IOException
 *          if an I/O error occurs opening or creating the file
 * @throws  java.lang.UnsupportedOperationException
 *          if an unsupported option is specified
 * @throws  java.lang.SecurityException
 *          In the case of the default provider, and a security manager is
 *          installed, the {@link java.lang.SecurityManager#checkWrite(java.lang.String) SecurityManager#checkWrite(String)}
 *          method is invoked to check write access to the file.
 *
 * @since 1.8
 * @apiSince 26
 */

public static java.io.BufferedWriter newBufferedWriter(java.nio.file.Path path, java.nio.file.OpenOption... options) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Copies all bytes from an input stream to a file. On return, the input
 * stream will be at end of stream.
 *
 * <p> By default, the copy fails if the target file already exists or is a
 * symbolic link. If the {@link java.nio.file.StandardCopyOption#REPLACE_EXISTING StandardCopyOption#REPLACE_EXISTING} option is specified, and the target file already exists,
 * then it is replaced if it is not a non-empty directory. If the target
 * file exists and is a symbolic link, then the symbolic link is replaced.
 * In this release, the {@code REPLACE_EXISTING} option is the only option
 * required to be supported by this method. Additional options may be
 * supported in future releases.
 *
 * <p>  If an I/O error occurs reading from the input stream or writing to
 * the file, then it may do so after the target file has been created and
 * after some bytes have been read or written. Consequently the input
 * stream may not be at end of stream and may be in an inconsistent state.
 * It is strongly recommended that the input stream be promptly closed if an
 * I/O error occurs.
 *
 * <p> This method may block indefinitely reading from the input stream (or
 * writing to the file). The behavior for the case that the input stream is
 * <i>asynchronously closed</i> or the thread interrupted during the copy is
 * highly input stream and file system provider specific and therefore not
 * specified.
 *
 * <p> <b>Usage example</b>: Suppose we want to capture a web page and save
 * it to a file:
 * <pre>
 *     Path path = ...
 *     URI u = URI.create("http://java.sun.com/");
 *     try (InputStream in = u.toURL().openStream()) {
 *         Files.copy(in, path);
 *     }
 * </pre>
 *
 * @param   in
 *          the input stream to read from
 * @param   target
 *          the path to the file
 * @param   options
 *          options specifying how the copy should be done
 *
 * @return  the number of bytes read or written
 *
 * @throws  java.io.IOException
 *          if an I/O error occurs when reading or writing
 * @throws  java.nio.file.FileAlreadyExistsException
 *          if the target file exists but cannot be replaced because the
 *          {@code REPLACE_EXISTING} option is not specified <i>(optional
 *          specific exception)</i>
 * @throws  java.nio.file.DirectoryNotEmptyException
 *          the {@code REPLACE_EXISTING} option is specified but the file
 *          cannot be replaced because it is a non-empty directory
 *          <i>(optional specific exception)</i>     *
 * @throws  java.lang.UnsupportedOperationException
 *          if {@code options} contains a copy option that is not supported
 * @throws  java.lang.SecurityException
 *          In the case of the default provider, and a security manager is
 *          installed, the {@link java.lang.SecurityManager#checkWrite(java.lang.String) SecurityManager#checkWrite(String)}
 *          method is invoked to check write access to the file. Where the
 *          {@code REPLACE_EXISTING} option is specified, the security
 *          manager's {@link java.lang.SecurityManager#checkDelete(java.lang.String) SecurityManager#checkDelete(String)}
 *          method is invoked to check that an existing file can be deleted.
 * @apiSince 26
 */

public static long copy(java.io.InputStream in, java.nio.file.Path target, java.nio.file.CopyOption... options) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Copies all bytes from a file to an output stream.
 *
 * <p> If an I/O error occurs reading from the file or writing to the output
 * stream, then it may do so after some bytes have been read or written.
 * Consequently the output stream may be in an inconsistent state. It is
 * strongly recommended that the output stream be promptly closed if an I/O
 * error occurs.
 *
 * <p> This method may block indefinitely writing to the output stream (or
 * reading from the file). The behavior for the case that the output stream
 * is <i>asynchronously closed</i> or the thread interrupted during the copy
 * is highly output stream and file system provider specific and therefore
 * not specified.
 *
 * <p> Note that if the given output stream is {@link java.io.Flushable}
 * then its {@link java.io.Flushable#flush flush} method may need to invoked
 * after this method completes so as to flush any buffered output.
 *
 * @param   source
 *          the  path to the file
 * @param   out
 *          the output stream to write to
 *
 * @return  the number of bytes read or written
 *
 * @throws  java.io.IOException
 *          if an I/O error occurs when reading or writing
 * @throws  java.lang.SecurityException
 *          In the case of the default provider, and a security manager is
 *          installed, the {@link java.lang.SecurityManager#checkRead(java.lang.String) SecurityManager#checkRead(String)}
 *          method is invoked to check read access to the file.
 * @apiSince 26
 */

public static long copy(java.nio.file.Path source, java.io.OutputStream out) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Reads all the bytes from a file. The method ensures that the file is
 * closed when all bytes have been read or an I/O error, or other runtime
 * exception, is thrown.
 *
 * <p> Note that this method is intended for simple cases where it is
 * convenient to read all bytes into a byte array. It is not intended for
 * reading in large files.
 *
 * @param   path
 *          the path to the file
 *
 * @return  a byte array containing the bytes read from the file
 *
 * @throws  java.io.IOException
 *          if an I/O error occurs reading from the stream
 * @throws  java.lang.OutOfMemoryError
 *          if an array of the required size cannot be allocated, for
 *          example the file is larger that {@code 2GB}
 * @throws  java.lang.SecurityException
 *          In the case of the default provider, and a security manager is
 *          installed, the {@link java.lang.SecurityManager#checkRead(java.lang.String) SecurityManager#checkRead(String)}
 *          method is invoked to check read access to the file.
 * @apiSince 26
 */

public static byte[] readAllBytes(java.nio.file.Path path) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Read all lines from a file. This method ensures that the file is
 * closed when all bytes have been read or an I/O error, or other runtime
 * exception, is thrown. Bytes from the file are decoded into characters
 * using the specified charset.
 *
 * <p> This method recognizes the following as line terminators:
 * <ul>
 *   <li> <code>&#92;u000D</code> followed by <code>&#92;u000A</code>,
 *     CARRIAGE RETURN followed by LINE FEED </li>
 *   <li> <code>&#92;u000A</code>, LINE FEED </li>
 *   <li> <code>&#92;u000D</code>, CARRIAGE RETURN </li>
 * </ul>
 * <p> Additional Unicode line terminators may be recognized in future
 * releases.
 *
 * <p> Note that this method is intended for simple cases where it is
 * convenient to read all lines in a single operation. It is not intended
 * for reading in large files.
 *
 * @param   path
 *          the path to the file
 * @param   cs
 *          the charset to use for decoding
 *
 * @return  the lines from the file as a {@code List}; whether the {@code
 *          List} is modifiable or not is implementation dependent and
 *          therefore not specified
 *
 * @throws  java.io.IOException
 *          if an I/O error occurs reading from the file or a malformed or
 *          unmappable byte sequence is read
 * @throws  java.lang.SecurityException
 *          In the case of the default provider, and a security manager is
 *          installed, the {@link java.lang.SecurityManager#checkRead(java.lang.String) SecurityManager#checkRead(String)}
 *          method is invoked to check read access to the file.
 *
 * @see #newBufferedReader
 * @apiSince 26
 */

public static java.util.List<java.lang.String> readAllLines(java.nio.file.Path path, java.nio.charset.Charset cs) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Read all lines from a file. Bytes from the file are decoded into characters
 * using the {@link java.nio.charset.StandardCharsets#UTF_8 StandardCharsets#UTF_8} {@link java.nio.charset.Charset Charset}.
 *
 * <p> This method works as if invoking it were equivalent to evaluating the
 * expression:
 * <pre>{@code
 * Files.readAllLines(path, StandardCharsets.UTF_8)
 * }</pre>
 *
 * @param   path
 *          the path to the file
 *
 * @return  the lines from the file as a {@code List}; whether the {@code
 *          List} is modifiable or not is implementation dependent and
 *          therefore not specified
 *
 * @throws  java.io.IOException
 *          if an I/O error occurs reading from the file or a malformed or
 *          unmappable byte sequence is read
 * @throws  java.lang.SecurityException
 *          In the case of the default provider, and a security manager is
 *          installed, the {@link java.lang.SecurityManager#checkRead(java.lang.String) SecurityManager#checkRead(String)}
 *          method is invoked to check read access to the file.
 *
 * @since 1.8
 * @apiSince 26
 */

public static java.util.List<java.lang.String> readAllLines(java.nio.file.Path path) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Writes bytes to a file. The {@code options} parameter specifies how the
 * the file is created or opened. If no options are present then this method
 * works as if the {@link java.nio.file.StandardOpenOption#CREATE StandardOpenOption#CREATE}, {@link java.nio.file.StandardOpenOption#TRUNCATE_EXISTING StandardOpenOption#TRUNCATE_EXISTING}, and {@link java.nio.file.StandardOpenOption#WRITE StandardOpenOption#WRITE} options are present. In other words, it
 * opens the file for writing, creating the file if it doesn't exist, or
 * initially truncating an existing {@link #isRegularFile regular-file} to
 * a size of {@code 0}. All bytes in the byte array are written to the file.
 * The method ensures that the file is closed when all bytes have been
 * written (or an I/O error or other runtime exception is thrown). If an I/O
 * error occurs then it may do so after the file has created or truncated,
 * or after some bytes have been written to the file.
 *
 * <p> <b>Usage example</b>: By default the method creates a new file or
 * overwrites an existing file. Suppose you instead want to append bytes
 * to an existing file:
 * <pre>
 *     Path path = ...
 *     byte[] bytes = ...
 *     Files.write(path, bytes, StandardOpenOption.APPEND);
 * </pre>
 *
 * @param   path
 *          the path to the file
 * @param   bytes
 *          the byte array with the bytes to write
 * @param   options
 *          options specifying how the file is opened
 *
 * @return  the path
 *
 * @throws  java.io.IOException
 *          if an I/O error occurs writing to or creating the file
 * @throws  java.lang.UnsupportedOperationException
 *          if an unsupported option is specified
 * @throws  java.lang.SecurityException
 *          In the case of the default provider, and a security manager is
 *          installed, the {@link java.lang.SecurityManager#checkWrite(java.lang.String) SecurityManager#checkWrite(String)}
 *          method is invoked to check write access to the file.
 * @apiSince 26
 */

public static java.nio.file.Path write(java.nio.file.Path path, byte[] bytes, java.nio.file.OpenOption... options) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Write lines of text to a file. Each line is a char sequence and is
 * written to the file in sequence with each line terminated by the
 * platform's line separator, as defined by the system property {@code
 * line.separator}. Characters are encoded into bytes using the specified
 * charset.
 *
 * <p> The {@code options} parameter specifies how the the file is created
 * or opened. If no options are present then this method works as if the
 * {@link java.nio.file.StandardOpenOption#CREATE StandardOpenOption#CREATE}, {@link java.nio.file.StandardOpenOption#TRUNCATE_EXISTING StandardOpenOption#TRUNCATE_EXISTING}, and {@link java.nio.file.StandardOpenOption#WRITE StandardOpenOption#WRITE} options are present. In other words, it
 * opens the file for writing, creating the file if it doesn't exist, or
 * initially truncating an existing {@link #isRegularFile regular-file} to
 * a size of {@code 0}. The method ensures that the file is closed when all
 * lines have been written (or an I/O error or other runtime exception is
 * thrown). If an I/O error occurs then it may do so after the file has
 * created or truncated, or after some bytes have been written to the file.
 *
 * @param   path
 *          the path to the file
 * @param   lines
 *          an object to iterate over the char sequences
 * @param   cs
 *          the charset to use for encoding
 * @param   options
 *          options specifying how the file is opened
 *
 * @return  the path
 *
 * @throws  java.io.IOException
 *          if an I/O error occurs writing to or creating the file, or the
 *          text cannot be encoded using the specified charset
 * @throws  java.lang.UnsupportedOperationException
 *          if an unsupported option is specified
 * @throws  java.lang.SecurityException
 *          In the case of the default provider, and a security manager is
 *          installed, the {@link java.lang.SecurityManager#checkWrite(java.lang.String) SecurityManager#checkWrite(String)}
 *          method is invoked to check write access to the file.
 * @apiSince 26
 */

public static java.nio.file.Path write(java.nio.file.Path path, java.lang.Iterable<? extends java.lang.CharSequence> lines, java.nio.charset.Charset cs, java.nio.file.OpenOption... options) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Write lines of text to a file. Characters are encoded into bytes using
 * the {@link java.nio.charset.StandardCharsets#UTF_8 StandardCharsets#UTF_8} {@link java.nio.charset.Charset Charset}.
 *
 * <p> This method works as if invoking it were equivalent to evaluating the
 * expression:
 * <pre>{@code
 * Files.write(path, lines, StandardCharsets.UTF_8, options);
 * }</pre>
 *
 * @param   path
 *          the path to the file
 * @param   lines
 *          an object to iterate over the char sequences
 * @param   options
 *          options specifying how the file is opened
 *
 * @return  the path
 *
 * @throws  java.io.IOException
 *          if an I/O error occurs writing to or creating the file, or the
 *          text cannot be encoded as {@code UTF-8}
 * @throws  java.lang.UnsupportedOperationException
 *          if an unsupported option is specified
 * @throws  java.lang.SecurityException
 *          In the case of the default provider, and a security manager is
 *          installed, the {@link java.lang.SecurityManager#checkWrite(java.lang.String) SecurityManager#checkWrite(String)}
 *          method is invoked to check write access to the file.
 *
 * @since 1.8
 * @apiSince 26
 */

public static java.nio.file.Path write(java.nio.file.Path path, java.lang.Iterable<? extends java.lang.CharSequence> lines, java.nio.file.OpenOption... options) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Return a lazily populated {@code Stream}, the elements of
 * which are the entries in the directory.  The listing is not recursive.
 *
 * <p> The elements of the stream are {@link java.nio.file.Path Path} objects that are
 * obtained as if by {@link java.nio.file.Path#resolve(java.nio.file.Path) Path#resolve(Path)} the name of the
 * directory entry against {@code dir}. Some file systems maintain special
 * links to the directory itself and the directory's parent directory.
 * Entries representing these links are not included.
 *
 * <p> The stream is <i>weakly consistent</i>. It is thread safe but does
 * not freeze the directory while iterating, so it may (or may not)
 * reflect updates to the directory that occur after returning from this
 * method.
 *
 * <p> The returned stream encapsulates a {@link java.nio.file.DirectoryStream DirectoryStream}.
 * If timely disposal of file system resources is required, the
 * {@code try}-with-resources construct should be used to ensure that the
 * stream's {@link java.util.stream.Stream#close Stream#close} method is invoked after the stream
 * operations are completed.
 *
 * <p> Operating on a closed stream behaves as if the end of stream
 * has been reached. Due to read-ahead, one or more elements may be
 * returned after the stream has been closed.
 *
 * <p> If an {@link java.io.IOException IOException} is thrown when accessing the directory
 * after this method has returned, it is wrapped in an {@link java.io.UncheckedIOException UncheckedIOException} which will be thrown from the method that caused
 * the access to take place.
 *
 * @param   dir  The path to the directory
 *
 * @return  The {@code Stream} describing the content of the
 *          directory
 *
 * @throws  java.nio.file.NotDirectoryException
 *          if the file could not otherwise be opened because it is not
 *          a directory <i>(optional specific exception)</i>
 * @throws  java.io.IOException
 *          if an I/O error occurs when opening the directory
 * @throws  java.lang.SecurityException
 *          In the case of the default provider, and a security manager is
 *          installed, the {@link java.lang.SecurityManager#checkRead(java.lang.String) SecurityManager#checkRead(String)}
 *          method is invoked to check read access to the directory.
 *
 * @see     #newDirectoryStream(Path)
 * @since   1.8
 * @apiSince 26
 */

public static java.util.stream.Stream<java.nio.file.Path> list(java.nio.file.Path dir) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Return a {@code Stream} that is lazily populated with {@code
 * Path} by walking the file tree rooted at a given starting file.  The
 * file tree is traversed <em>depth-first</em>, the elements in the stream
 * are {@link java.nio.file.Path Path} objects that are obtained as if by {@link java.nio.file.Path#resolve(java.nio.file.Path) Path#resolve(Path)} the relative path against {@code start}.
 *
 * <p> The {@code stream} walks the file tree as elements are consumed.
 * The {@code Stream} returned is guaranteed to have at least one
 * element, the starting file itself. For each file visited, the stream
 * attempts to read its {@link java.nio.file.attribute.BasicFileAttributes BasicFileAttributes}. If the file is a
 * directory and can be opened successfully, entries in the directory, and
 * their <em>descendants</em> will follow the directory in the stream as
 * they are encountered. When all entries have been visited, then the
 * directory is closed. The file tree walk then continues at the next
 * <em>sibling</em> of the directory.
 *
 * <p> The stream is <i>weakly consistent</i>. It does not freeze the
 * file tree while iterating, so it may (or may not) reflect updates to
 * the file tree that occur after returned from this method.
 *
 * <p> By default, symbolic links are not automatically followed by this
 * method. If the {@code options} parameter contains the {@link java.nio.file.FileVisitOption#FOLLOW_LINKS FileVisitOption#FOLLOW_LINKS} option then symbolic links are
 * followed. When following links, and the attributes of the target cannot
 * be read, then this method attempts to get the {@code BasicFileAttributes}
 * of the link.
 *
 * <p> If the {@code options} parameter contains the {@link java.nio.file.FileVisitOption#FOLLOW_LINKS FileVisitOption#FOLLOW_LINKS} option then the stream keeps
 * track of directories visited so that cycles can be detected. A cycle
 * arises when there is an entry in a directory that is an ancestor of the
 * directory. Cycle detection is done by recording the {@link
 * java.nio.file.attribute.BasicFileAttributes#fileKey file-key} of directories,
 * or if file keys are not available, by invoking the {@link #isSameFile
 * isSameFile} method to test if a directory is the same file as an
 * ancestor. When a cycle is detected it is treated as an I/O error with
 * an instance of {@link java.nio.file.FileSystemLoopException FileSystemLoopException}.
 *
 * <p> The {@code maxDepth} parameter is the maximum number of levels of
 * directories to visit. A value of {@code 0} means that only the starting
 * file is visited, unless denied by the security manager. A value of
 * {@link java.lang.Integer#MAX_VALUE Integer#MAX_VALUE} may be used to indicate that all
 * levels should be visited.
 *
 * <p> When a security manager is installed and it denies access to a file
 * (or directory), then it is ignored and not included in the stream.
 *
 * <p> The returned stream encapsulates one or more {@link java.nio.file.DirectoryStream DirectoryStream}s.
 * If timely disposal of file system resources is required, the
 * {@code try}-with-resources construct should be used to ensure that the
 * stream's {@link java.util.stream.Stream#close Stream#close} method is invoked after the stream
 * operations are completed.  Operating on a closed stream will result in an
 * {@link java.lang.IllegalStateException}.
 *
 * <p> If an {@link java.io.IOException IOException} is thrown when accessing the directory
 * after this method has returned, it is wrapped in an {@link java.io.UncheckedIOException UncheckedIOException} which will be thrown from the method that caused
 * the access to take place.
 *
 * @param   start
 *          the starting file
 * @param   maxDepth
 *          the maximum number of directory levels to visit
 * @param   options
 *          options to configure the traversal
 *
 * @return  the {@link java.util.stream.Stream Stream} of {@link java.nio.file.Path Path}
 *
 * @throws  java.lang.IllegalArgumentException
 *          if the {@code maxDepth} parameter is negative
 * @throws  java.lang.SecurityException
 *          If the security manager denies access to the starting file.
 *          In the case of the default provider, the {@link java.lang.SecurityManager#checkRead(java.lang.String) SecurityManager#checkRead(String)} method is invoked
 *          to check read access to the directory.
 * @throws  java.io.IOException
 *          if an I/O error is thrown when accessing the starting file.
 * @since   1.8
 * @apiSince 26
 */

public static java.util.stream.Stream<java.nio.file.Path> walk(java.nio.file.Path start, int maxDepth, java.nio.file.FileVisitOption... options) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Return a {@code Stream} that is lazily populated with {@code
 * Path} by walking the file tree rooted at a given starting file.  The
 * file tree is traversed <em>depth-first</em>, the elements in the stream
 * are {@link java.nio.file.Path Path} objects that are obtained as if by {@link java.nio.file.Path#resolve(java.nio.file.Path) Path#resolve(Path)} the relative path against {@code start}.
 *
 * <p> This method works as if invoking it were equivalent to evaluating the
 * expression:
 * <blockquote><pre>
 * walk(start, Integer.MAX_VALUE, options)
 * </pre></blockquote>
 * In other words, it visits all levels of the file tree.
 *
 * <p> The returned stream encapsulates one or more {@link java.nio.file.DirectoryStream DirectoryStream}s.
 * If timely disposal of file system resources is required, the
 * {@code try}-with-resources construct should be used to ensure that the
 * stream's {@link java.util.stream.Stream#close Stream#close} method is invoked after the stream
 * operations are completed.  Operating on a closed stream will result in an
 * {@link java.lang.IllegalStateException}.
 *
 * @param   start
 *          the starting file
 * @param   options
 *          options to configure the traversal
 *
 * @return  the {@link java.util.stream.Stream Stream} of {@link java.nio.file.Path Path}
 *
 * @throws  java.lang.SecurityException
 *          If the security manager denies access to the starting file.
 *          In the case of the default provider, the {@link java.lang.SecurityManager#checkRead(java.lang.String) SecurityManager#checkRead(String)} method is invoked
 *          to check read access to the directory.
 * @throws  java.io.IOException
 *          if an I/O error is thrown when accessing the starting file.
 *
 * @see     #walk(Path, int, FileVisitOption...)
 * @since   1.8
 * @apiSince 26
 */

public static java.util.stream.Stream<java.nio.file.Path> walk(java.nio.file.Path start, java.nio.file.FileVisitOption... options) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Return a {@code Stream} that is lazily populated with {@code
 * Path} by searching for files in a file tree rooted at a given starting
 * file.
 *
 * <p> This method walks the file tree in exactly the manner specified by
 * the {@link #walk walk} method. For each file encountered, the given
 * {@link java.util.function.BiPredicate BiPredicate} is invoked with its {@link java.nio.file.Path Path} and {@link java.nio.file.attribute.BasicFileAttributes BasicFileAttributes}. The {@code Path} object is obtained as if by
 * {@link java.nio.file.Path#resolve(java.nio.file.Path) Path#resolve(Path)} the relative path against {@code
 * start} and is only included in the returned {@link java.util.stream.Stream Stream} if
 * the {@code BiPredicate} returns true. Compare to calling {@link
 * java.util.stream.Stream#filter filter} on the {@code Stream}
 * returned by {@code walk} method, this method may be more efficient by
 * avoiding redundant retrieval of the {@code BasicFileAttributes}.
 *
 * <p> The returned stream encapsulates one or more {@link java.nio.file.DirectoryStream DirectoryStream}s.
 * If timely disposal of file system resources is required, the
 * {@code try}-with-resources construct should be used to ensure that the
 * stream's {@link java.util.stream.Stream#close Stream#close} method is invoked after the stream
 * operations are completed.  Operating on a closed stream will result in an
 * {@link java.lang.IllegalStateException}.
 *
 * <p> If an {@link java.io.IOException IOException} is thrown when accessing the directory
 * after returned from this method, it is wrapped in an {@link java.io.UncheckedIOException UncheckedIOException} which will be thrown from the method that caused
 * the access to take place.
 *
 * @param   start
 *          the starting file
 * @param   maxDepth
 *          the maximum number of directory levels to search
 * @param   matcher
 *          the function used to decide whether a file should be included
 *          in the returned stream
 * @param   options
 *          options to configure the traversal
 *
 * @return  the {@link java.util.stream.Stream Stream} of {@link java.nio.file.Path Path}
 *
 * @throws  java.lang.IllegalArgumentException
 *          if the {@code maxDepth} parameter is negative
 * @throws  java.lang.SecurityException
 *          If the security manager denies access to the starting file.
 *          In the case of the default provider, the {@link java.lang.SecurityManager#checkRead(java.lang.String) SecurityManager#checkRead(String)} method is invoked
 *          to check read access to the directory.
 * @throws  java.io.IOException
 *          if an I/O error is thrown when accessing the starting file.
 *
 * @see     #walk(Path, int, FileVisitOption...)
 * @since   1.8
 * @apiSince 26
 */

public static java.util.stream.Stream<java.nio.file.Path> find(java.nio.file.Path start, int maxDepth, java.util.function.BiPredicate<java.nio.file.Path,java.nio.file.attribute.BasicFileAttributes> matcher, java.nio.file.FileVisitOption... options) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Read all lines from a file as a {@code Stream}. Unlike {@link
 * #readAllLines(java.nio.file.Path,java.nio.charset.Charset) readAllLines}, this method does not read
 * all lines into a {@code List}, but instead populates lazily as the stream
 * is consumed.
 *
 * <p> Bytes from the file are decoded into characters using the specified
 * charset and the same line terminators as specified by {@code
 * readAllLines} are supported.
 *
 * <p> After this method returns, then any subsequent I/O exception that
 * occurs while reading from the file or when a malformed or unmappable byte
 * sequence is read, is wrapped in an {@link java.io.UncheckedIOException UncheckedIOException} that will
 * be thrown from the
 * {@link java.util.stream.Stream} method that caused the read to take
 * place. In case an {@code IOException} is thrown when closing the file,
 * it is also wrapped as an {@code UncheckedIOException}.
 *
 * <p> The returned stream encapsulates a {@link java.io.Reader Reader}.  If timely
 * disposal of file system resources is required, the try-with-resources
 * construct should be used to ensure that the stream's
 * {@link java.util.stream.Stream#close Stream#close} method is invoked after the stream operations
 * are completed.
 *
 *
 * @param   path
 *          the path to the file
 * @param   cs
 *          the charset to use for decoding
 *
 * @return  the lines from the file as a {@code Stream}
 *
 * @throws  java.io.IOException
 *          if an I/O error occurs opening the file
 * @throws  java.lang.SecurityException
 *          In the case of the default provider, and a security manager is
 *          installed, the {@link java.lang.SecurityManager#checkRead(java.lang.String) SecurityManager#checkRead(String)}
 *          method is invoked to check read access to the file.
 *
 * @see     #readAllLines(Path, Charset)
 * @see     #newBufferedReader(Path, Charset)
 * @see     java.io.BufferedReader#lines()
 * @since   1.8
 * @apiSince 26
 */

public static java.util.stream.Stream<java.lang.String> lines(java.nio.file.Path path, java.nio.charset.Charset cs) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Read all lines from a file as a {@code Stream}. Bytes from the file are
 * decoded into characters using the {@link java.nio.charset.StandardCharsets#UTF_8 StandardCharsets#UTF_8}
 * {@link java.nio.charset.Charset Charset}.
 *
 * <p> This method works as if invoking it were equivalent to evaluating the
 * expression:
 * <pre>{@code
 * Files.lines(path, StandardCharsets.UTF_8)
 * }</pre>
 *
 * @param   path
 *          the path to the file
 *
 * @return  the lines from the file as a {@code Stream}
 *
 * @throws  java.io.IOException
 *          if an I/O error occurs opening the file
 * @throws  java.lang.SecurityException
 *          In the case of the default provider, and a security manager is
 *          installed, the {@link java.lang.SecurityManager#checkRead(java.lang.String) SecurityManager#checkRead(String)}
 *          method is invoked to check read access to the file.
 *
 * @since 1.8
 * @apiSince 26
 */

public static java.util.stream.Stream<java.lang.String> lines(java.nio.file.Path path) throws java.io.IOException { throw new RuntimeException("Stub!"); }
}
