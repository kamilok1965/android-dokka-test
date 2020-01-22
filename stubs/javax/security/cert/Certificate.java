/*
 * Copyright (c) 1997, 2013, Oracle and/or its affiliates. All rights reserved.
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




package javax.security.cert;

import java.security.PublicKey;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.security.NoSuchProviderException;
import java.security.InvalidKeyException;

/**
 * <p>Abstract class for managing a variety of identity certificates.
 * An identity certificate is a guarantee by a principal that
 * a public key is that of another principal.  (A principal represents
 * an entity such as an individual user, a group, or a corporation.)
 *<p>
 * This class is an abstraction for certificates that have different
 * formats but important common uses.  For example, different types of
 * certificates, such as X.509 and PGP, share general certificate
 * functionality (like encoding and verifying) and
 * some types of information (like a public key).
 * <p>
 * X.509, PGP, and SDSI certificates can all be implemented by
 * subclassing the Certificate class, even though they contain different
 * sets of information, and they store and retrieve the information in
 * different ways.
 *
 * <p><em>Note: The classes in the package {@code javax.security.cert}
 * exist for compatibility with earlier versions of the
 * Java Secure Sockets Extension (JSSE). New applications should instead
 * use the standard Java SE certificate classes located in
 * {@code java.security.cert}.</em></p>
 *
 * @since 1.4
 * @see javax.security.cert.X509Certificate
 *
 * @author Hemma Prafullchandra
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class Certificate {

/** @apiSince 1 */

public Certificate() { throw new RuntimeException("Stub!"); }

/**
 * Compares this certificate for equality with the specified
 * object. If the {@code other} object is an
 * {@code instanceof} {@code Certificate}, then
 * its encoded form is retrieved and compared with the
 * encoded form of this certificate.
 *
 * @param other the object to test for equality with this certificate.
 * @return true if the encoded forms of the two certificates
 *         match, false otherwise.
 * @apiSince 1
 */

public boolean equals(java.lang.Object other) { throw new RuntimeException("Stub!"); }

/**
 * Returns a hashcode value for this certificate from its
 * encoded form.
 *
 * @return the hashcode value.
 * @apiSince 1
 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * Returns the encoded form of this certificate. It is
 * assumed that each certificate type would have only a single
 * form of encoding; for example, X.509 certificates would
 * be encoded as ASN.1 DER.
 *
 * @return encoded form of this certificate
 * @exception javax.security.cert.CertificateEncodingException on internal certificate
 *            encoding failure
 * @apiSince 1
 */

public abstract byte[] getEncoded() throws javax.security.cert.CertificateEncodingException;

/**
 * Verifies that this certificate was signed using the
 * private key that corresponds to the specified public key.
 *
 * @param key the PublicKey used to carry out the verification.
 *
 * @exception java.security.NoSuchAlgorithmException on unsupported signature
 * algorithms.
 * @exception java.security.InvalidKeyException on incorrect key.
 * @exception java.security.NoSuchProviderException if there's no default provider.
 * @exception java.security.SignatureException on signature errors.
 * @exception javax.security.cert.CertificateException on encoding errors.
 * @apiSince 1
 */

public abstract void verify(java.security.PublicKey key) throws javax.security.cert.CertificateException, java.security.InvalidKeyException, java.security.NoSuchAlgorithmException, java.security.NoSuchProviderException, java.security.SignatureException;

/**
 * Verifies that this certificate was signed using the
 * private key that corresponds to the specified public key.
 * This method uses the signature verification engine
 * supplied by the specified provider.
 *
 * @param key the PublicKey used to carry out the verification.
 * @param sigProvider the name of the signature provider.
 * @exception java.security.NoSuchAlgorithmException on unsupported signature algorithms.
 * @exception java.security.InvalidKeyException on incorrect key.
 * @exception java.security.NoSuchProviderException on incorrect provider.
 * @exception java.security.SignatureException on signature errors.
 * @exception javax.security.cert.CertificateException on encoding errors.
 * @apiSince 1
 */

public abstract void verify(java.security.PublicKey key, java.lang.String sigProvider) throws javax.security.cert.CertificateException, java.security.InvalidKeyException, java.security.NoSuchAlgorithmException, java.security.NoSuchProviderException, java.security.SignatureException;

/**
 * Returns a string representation of this certificate.
 *
 * @return a string representation of this certificate.
 * @apiSince 1
 */

public abstract java.lang.String toString();

/**
 * Gets the public key from this certificate.
 *
 * @return the public key.
 * @apiSince 1
 */

public abstract java.security.PublicKey getPublicKey();
}

