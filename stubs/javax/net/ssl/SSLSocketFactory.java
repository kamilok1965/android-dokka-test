/*
 * Copyright (C) 2014 The Android Open Source Project
 * Copyright (c) 1997, 2012, Oracle and/or its affiliates. All rights reserved.
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




package javax.net.ssl;

import java.net.*;
import java.security.*;
import javax.net.SocketFactory;
import java.io.IOException;

/**
 * <code>SSLSocketFactory</code>s create <code>SSLSocket</code>s.
 *
 * @since 1.4
 * @see javax.net.ssl.SSLSocket
 * @author David Brownell
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class SSLSocketFactory extends javax.net.SocketFactory {

/**
 * Constructor is used only by subclasses.
 * @apiSince 1
 */

public SSLSocketFactory() { throw new RuntimeException("Stub!"); }

/**
 * Returns the default SSL socket factory.
 *
 * <p>The first time this method is called, the security property
 * "ssl.SocketFactory.provider" is examined. If it is non-null, a class by
 * that name is loaded and instantiated. If that is successful and the
 * object is an instance of SSLSocketFactory, it is made the default SSL
 * socket factory.
 *
 * <p>Otherwise, this method returns
 * <code>SSLContext.getDefault().getSocketFactory()</code>. If that
 * call fails, an inoperative factory is returned.
 *
 * @return the default <code>SocketFactory</code>
 * @see javax.net.ssl.SSLContext#getDefault
 * @apiSince 1
 */

public static synchronized javax.net.SocketFactory getDefault() { throw new RuntimeException("Stub!"); }

/**
 * Returns the list of cipher suites which are enabled by default.
 * Unless a different list is enabled, handshaking on an SSL connection
 * will use one of these cipher suites.  The minimum quality of service
 * for these defaults requires confidentiality protection and server
 * authentication (that is, no anonymous cipher suites).
 *
 * @see #getSupportedCipherSuites()
 * @return array of the cipher suites enabled by default
 * @apiSince 1
 */

public abstract java.lang.String[] getDefaultCipherSuites();

/**
 * Returns the names of the cipher suites which could be enabled for use
 * on an SSL connection.  Normally, only a subset of these will actually
 * be enabled by default, since this list may include cipher suites which
 * do not meet quality of service requirements for those defaults.  Such
 * cipher suites are useful in specialized applications.
 *
 * <p class="caution">Applications should not blindly enable all supported
 * cipher suites.  The supported cipher suites can include signaling cipher suite
 * values that can cause connection problems if enabled inappropriately.
 *
 * <p>The proper way to use this method is to either check if a specific cipher
 * suite is supported via {@code Arrays.asList(getSupportedCipherSuites()).contains(...)}
 * or to filter a desired list of cipher suites to only the supported ones via
 * {@code desiredSuiteSet.retainAll(Arrays.asList(getSupportedCipherSuites()))}.
 *
 * @see #getDefaultCipherSuites()
 * @return an array of cipher suite names
 * @apiSince 1
 */

public abstract java.lang.String[] getSupportedCipherSuites();

/**
 * Returns a socket layered over an existing socket connected to the named
 * host, at the given port.  This constructor can be used when tunneling SSL
 * through a proxy or when negotiating the use of SSL over an existing
 * socket. The host and port refer to the logical peer destination.
 * This socket is configured using the socket options established for
 * this factory.
 *
 * @param s the existing socket
 * @param host the server host
 * @param port the server port
 * @param autoClose close the underlying socket when this socket is closed
 * @return a socket connected to the specified host and port
 * @throws java.io.IOException if an I/O error occurs when creating the socket
 * @throws java.lang.NullPointerException if the parameter s is null
 * @apiSince 1
 */

public abstract java.net.Socket createSocket(java.net.Socket s, java.lang.String host, int port, boolean autoClose) throws java.io.IOException;
}

