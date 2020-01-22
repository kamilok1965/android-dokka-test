/*
 * Copyright (C) 2018 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package android.net;

import java.net.InetAddress;

/**
 * Utility methods for {@link java.net.InetAddress InetAddress} implementations.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class InetAddresses {

private InetAddresses() { throw new RuntimeException("Stub!"); }

/**
 * Checks to see if the {@code address} is a numeric address (such as {@code "192.0.2.1"} or
 * {@code "2001:db8::1:2"}).
 *
 * <p>A numeric address is either an IPv4 address containing exactly 4 decimal numbers or an
 * IPv6 numeric address. IPv4 addresses that consist of either hexadecimal or octal digits or
 * do not have exactly 4 numbers are not treated as numeric.
 *
 * <p>This method will never do a DNS lookup.
 *
 * @param address the address to parse.
 * This value must never be {@code null}.
 * @return true if the supplied address is numeric, false otherwise.
 * @apiSince 29
 */

public static boolean isNumericAddress(@androidx.annotation.NonNull java.lang.String address) { throw new RuntimeException("Stub!"); }

/**
 * Returns an InetAddress corresponding to the given numeric address (such
 * as {@code "192.168.0.1"} or {@code "2001:4860:800d::68"}).
 *
 * <p>See {@link #isNumericAddress(java.lang.String)} (String)} for a definition as to what constitutes a
 * numeric address.
 *
 * <p>This method will never do a DNS lookup.
 *
 * @param address the address to parse, must be numeric.
 * This value must never be {@code null}.
 * @return an {@link java.net.InetAddress InetAddress} instance corresponding to the address.
 * This value will never be {@code null}.
 * @throws java.lang.IllegalArgumentException if {@code address} is not a numeric address.
 * @apiSince 29
 */

@androidx.annotation.NonNull
public static java.net.InetAddress parseNumericAddress(@androidx.annotation.NonNull java.lang.String address) { throw new RuntimeException("Stub!"); }
}

