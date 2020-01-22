/*
 * Copyright (c) 2012, 2013, Oracle and/or its affiliates. All rights reserved.
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

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * A container object which may or may not contain a non-null value.
 * If a value is present, {@code isPresent()} will return {@code true} and
 * {@code get()} will return the value.
 *
 * <p>Additional methods that depend on the presence or absence of a contained
 * value are provided, such as {@link #orElse(java.lang.Object) orElse()}
 * (return a default value if value not present) and
 * {@link #ifPresent(java.util.function.Consumer) ifPresent()} (execute a block
 * of code if the value is present).
 *
 * @since 1.8
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class Optional<T> {

private Optional() { throw new RuntimeException("Stub!"); }

/**
 * Returns an empty {@code Optional} instance.  No value is present for this
 * Optional.
 *
 * @apiNote Though it may be tempting to do so, avoid testing if an object
 * is empty by comparing with {@code ==} against instances returned by
 * {@code Option.empty()}. There is no guarantee that it is a singleton.
 * Instead, use {@link #isPresent()}.
 *
 * @param <T> Type of the non-existent value
 * @return an empty {@code Optional}
 * @apiSince 24
 */

public static <T> java.util.Optional<T> empty() { throw new RuntimeException("Stub!"); }

/**
 * Returns an {@code Optional} with the specified present non-null value.
 *
 * @param <T> the class of the value
 * @param value the value to be present, which must be non-null
 * @return an {@code Optional} with the value present
 * @throws java.lang.NullPointerException if value is null
 * @apiSince 24
 */

public static <T> java.util.Optional<T> of(T value) { throw new RuntimeException("Stub!"); }

/**
 * Returns an {@code Optional} describing the specified value, if non-null,
 * otherwise returns an empty {@code Optional}.
 *
 * @param <T> the class of the value
 * @param value the possibly-null value to describe
 * @return an {@code Optional} with a present value if the specified value
 * is non-null, otherwise an empty {@code Optional}
 * @apiSince 24
 */

public static <T> java.util.Optional<T> ofNullable(T value) { throw new RuntimeException("Stub!"); }

/**
 * If a value is present in this {@code Optional}, returns the value,
 * otherwise throws {@code NoSuchElementException}.
 *
 * @return the non-null value held by this {@code Optional}
 * @throws java.util.NoSuchElementException if there is no value present
 *
 * @see java.util.Optional#isPresent()
 * @apiSince 24
 */

public T get() { throw new RuntimeException("Stub!"); }

/**
 * Return {@code true} if there is a value present, otherwise {@code false}.
 *
 * @return {@code true} if there is a value present, otherwise {@code false}
 * @apiSince 24
 */

public boolean isPresent() { throw new RuntimeException("Stub!"); }

/**
 * If a value is present, invoke the specified consumer with the value,
 * otherwise do nothing.
 *
 * @param consumer block to be executed if a value is present
 * @throws java.lang.NullPointerException if value is present and {@code consumer} is
 * null
 * @apiSince 24
 */

public void ifPresent(java.util.function.Consumer<? super T> consumer) { throw new RuntimeException("Stub!"); }

/**
 * If a value is present, and the value matches the given predicate,
 * return an {@code Optional} describing the value, otherwise return an
 * empty {@code Optional}.
 *
 * @param predicate a predicate to apply to the value, if present
 * @return an {@code Optional} describing the value of this {@code Optional}
 * if a value is present and the value matches the given predicate,
 * otherwise an empty {@code Optional}
 * @throws java.lang.NullPointerException if the predicate is null
 * @apiSince 24
 */

public java.util.Optional<T> filter(java.util.function.Predicate<? super T> predicate) { throw new RuntimeException("Stub!"); }

/**
 * If a value is present, apply the provided mapping function to it,
 * and if the result is non-null, return an {@code Optional} describing the
 * result.  Otherwise return an empty {@code Optional}.
 *
 * @apiNote This method supports post-processing on optional values, without
 * the need to explicitly check for a return status.  For example, the
 * following code traverses a stream of file names, selects one that has
 * not yet been processed, and then opens that file, returning an
 * {@code Optional<FileInputStream>}:
 *
 * <pre>{@code
 *     Optional<FileInputStream> fis =
 *         names.stream().filter(name -> !isProcessedYet(name))
 *                       .findFirst()
 *                       .map(name -> new FileInputStream(name));
 * }</pre>
 *
 * Here, {@code findFirst} returns an {@code Optional<String>}, and then
 * {@code map} returns an {@code Optional<FileInputStream>} for the desired
 * file if one exists.
 *
 * @param <U> The type of the result of the mapping function
 * @param mapper a mapping function to apply to the value, if present
 * @return an {@code Optional} describing the result of applying a mapping
 * function to the value of this {@code Optional}, if a value is present,
 * otherwise an empty {@code Optional}
 * @throws java.lang.NullPointerException if the mapping function is null
 * @apiSince 24
 */

public <U> java.util.Optional<U> map(java.util.function.Function<? super T,? extends U> mapper) { throw new RuntimeException("Stub!"); }

/**
 * If a value is present, apply the provided {@code Optional}-bearing
 * mapping function to it, return that result, otherwise return an empty
 * {@code Optional}.  This method is similar to {@link #map(java.util.function.Function)},
 * but the provided mapper is one whose result is already an {@code Optional},
 * and if invoked, {@code flatMap} does not wrap it with an additional
 * {@code Optional}.
 *
 * @param <U> The type parameter to the {@code Optional} returned by
 * @param mapper a mapping function to apply to the value, if present
 *           the mapping function
 * @return the result of applying an {@code Optional}-bearing mapping
 * function to the value of this {@code Optional}, if a value is present,
 * otherwise an empty {@code Optional}
 * @throws java.lang.NullPointerException if the mapping function is null or returns
 * a null result
 * @apiSince 24
 */

public <U> java.util.Optional<U> flatMap(java.util.function.Function<? super T,java.util.Optional<U>> mapper) { throw new RuntimeException("Stub!"); }

/**
 * Return the value if present, otherwise return {@code other}.
 *
 * @param other the value to be returned if there is no value present, may
 * be null
 * @return the value, if present, otherwise {@code other}
 * @apiSince 24
 */

public T orElse(T other) { throw new RuntimeException("Stub!"); }

/**
 * Return the value if present, otherwise invoke {@code other} and return
 * the result of that invocation.
 *
 * @param other a {@code Supplier} whose result is returned if no value
 * is present
 * @return the value if present otherwise the result of {@code other.get()}
 * @throws java.lang.NullPointerException if value is not present and {@code other} is
 * null
 * @apiSince 24
 */

public T orElseGet(java.util.function.Supplier<? extends T> other) { throw new RuntimeException("Stub!"); }

/**
 * Return the contained value, if present, otherwise throw an exception
 * to be created by the provided supplier.
 *
 * @apiNote A method reference to the exception constructor with an empty
 * argument list can be used as the supplier. For example,
 * {@code IllegalStateException::new}
 *
 * @param <X> Type of the exception to be thrown
 * @param exceptionSupplier The supplier which will return the exception to
 * be thrown
 * @return the present value
 * @throws X if there is no value present
 * @throws java.lang.NullPointerException if no value is present and
 * {@code exceptionSupplier} is null
 * @apiSince 24
 */

public <X extends java.lang.Throwable> T orElseThrow(java.util.function.Supplier<? extends X> exceptionSupplier) throws X { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether some other object is "equal to" this Optional. The
 * other object is considered equal if:
 * <ul>
 * <li>it is also an {@code Optional} and;
 * <li>both instances have no value present or;
 * <li>the present values are "equal to" each other via {@code equals()}.
 * </ul>
 *
 * @param obj an object to be tested for equality
 * @return {code true} if the other object is "equal to" this object
 * otherwise {@code false}
 * @apiSince 24
 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/**
 * Returns the hash code value of the present value, if any, or 0 (zero) if
 * no value is present.
 *
 * @return hash code value of the present value or 0 if no value is present
 * @apiSince 24
 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * Returns a non-empty string representation of this Optional suitable for
 * debugging. The exact presentation format is unspecified and may vary
 * between implementations and versions.
 *
 * @implSpec If a value is present the result must include its string
 * representation in the result. Empty and present Optionals must be
 * unambiguously differentiable.
 *
 * @return the string representation of this instance
 * @apiSince 24
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }
}

