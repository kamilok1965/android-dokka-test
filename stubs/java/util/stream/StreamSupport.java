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


package java.util.stream;

import java.util.function.Supplier;
import java.util.Spliterator;

/**
 * Low-level utility methods for creating and manipulating streams.
 *
 * <p>This class is mostly for library writers presenting stream views
 * of data structures; most static stream methods intended for end users are in
 * the various {@code Stream} classes.
 *
 * @since 1.8
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class StreamSupport {

private StreamSupport() { throw new RuntimeException("Stub!"); }

/**
 * Creates a new sequential or parallel {@code Stream} from a
 * {@code Spliterator}.
 *
 * <p>The spliterator is only traversed, split, or queried for estimated
 * size after the terminal operation of the stream pipeline commences.
 *
 * <p>It is strongly recommended the spliterator report a characteristic of
 * {@code IMMUTABLE} or {@code CONCURRENT}, or be
 * <a href="../Spliterator.html#binding">late-binding</a>.  Otherwise,
 * {@link #stream(java.util.function.Supplier,int,boolean)} should be used
 * to reduce the scope of potential interference with the source.  See
 * <a href="package-summary.html#NonInterference">Non-Interference</a> for
 * more details.
 *
 * @param <T> the type of stream elements
 * @param spliterator a {@code Spliterator} describing the stream elements
 * @param parallel if {@code true} then the returned stream is a parallel
 *        stream; if {@code false} the returned stream is a sequential
 *        stream.
 * @return a new sequential or parallel {@code Stream}
 * @apiSince 24
 */

public static <T> java.util.stream.Stream<T> stream(java.util.Spliterator<T> spliterator, boolean parallel) { throw new RuntimeException("Stub!"); }

/**
 * Creates a new sequential or parallel {@code Stream} from a
 * {@code Supplier} of {@code Spliterator}.
 *
 * <p>The {@link java.util.function.Supplier#get() Supplier#get()} method will be invoked on the supplier no
 * more than once, and only after the terminal operation of the stream pipeline
 * commences.
 *
 * <p>For spliterators that report a characteristic of {@code IMMUTABLE}
 * or {@code CONCURRENT}, or that are
 * <a href="../Spliterator.html#binding">late-binding</a>, it is likely
 * more efficient to use {@link #stream(java.util.Spliterator,boolean)}
 * instead.
 * <p>The use of a {@code Supplier} in this form provides a level of
 * indirection that reduces the scope of potential interference with the
 * source.  Since the supplier is only invoked after the terminal operation
 * commences, any modifications to the source up to the start of the
 * terminal operation are reflected in the stream result.  See
 * <a href="package-summary.html#NonInterference">Non-Interference</a> for
 * more details.
 *
 * @param <T> the type of stream elements
 * @param supplier a {@code Supplier} of a {@code Spliterator}
 * @param characteristics Spliterator characteristics of the supplied
 *        {@code Spliterator}.  The characteristics must be equal to
 *        {@code supplier.get().characteristics()}, otherwise undefined
 *        behavior may occur when terminal operation commences.
 * @param parallel if {@code true} then the returned stream is a parallel
 *        stream; if {@code false} the returned stream is a sequential
 *        stream.
 * @return a new sequential or parallel {@code Stream}
 * @see #stream(java.util.Spliterator, boolean)
 * @apiSince 24
 */

public static <T> java.util.stream.Stream<T> stream(java.util.function.Supplier<? extends java.util.Spliterator<T>> supplier, int characteristics, boolean parallel) { throw new RuntimeException("Stub!"); }

/**
 * Creates a new sequential or parallel {@code IntStream} from a
 * {@code Spliterator.OfInt}.
 *
 * <p>The spliterator is only traversed, split, or queried for estimated size
 * after the terminal operation of the stream pipeline commences.
 *
 * <p>It is strongly recommended the spliterator report a characteristic of
 * {@code IMMUTABLE} or {@code CONCURRENT}, or be
 * <a href="../Spliterator.html#binding">late-binding</a>.  Otherwise,
 * {@link #intStream(java.util.function.Supplier,int,boolean)} should be
 * used to reduce the scope of potential interference with the source.  See
 * <a href="package-summary.html#NonInterference">Non-Interference</a> for
 * more details.
 *
 * @param spliterator a {@code Spliterator.OfInt} describing the stream elements
 * @param parallel if {@code true} then the returned stream is a parallel
 *        stream; if {@code false} the returned stream is a sequential
 *        stream.
 * @return a new sequential or parallel {@code IntStream}
 * @apiSince 24
 */

public static java.util.stream.IntStream intStream(java.util.Spliterator.OfInt spliterator, boolean parallel) { throw new RuntimeException("Stub!"); }

/**
 * Creates a new sequential or parallel {@code IntStream} from a
 * {@code Supplier} of {@code Spliterator.OfInt}.
 *
 * <p>The {@link java.util.function.Supplier#get() Supplier#get()} method will be invoked on the supplier no
 * more than once, and only after the terminal operation of the stream pipeline
 * commences.
 *
 * <p>For spliterators that report a characteristic of {@code IMMUTABLE}
 * or {@code CONCURRENT}, or that are
 * <a href="../Spliterator.html#binding">late-binding</a>, it is likely
 * more efficient to use {@link #intStream(java.util.Spliterator.OfInt,boolean)}
 * instead.
 * <p>The use of a {@code Supplier} in this form provides a level of
 * indirection that reduces the scope of potential interference with the
 * source.  Since the supplier is only invoked after the terminal operation
 * commences, any modifications to the source up to the start of the
 * terminal operation are reflected in the stream result.  See
 * <a href="package-summary.html#NonInterference">Non-Interference</a> for
 * more details.
 *
 * @param supplier a {@code Supplier} of a {@code Spliterator.OfInt}
 * @param characteristics Spliterator characteristics of the supplied
 *        {@code Spliterator.OfInt}.  The characteristics must be equal to
 *        {@code supplier.get().characteristics()}, otherwise undefined
 *        behavior may occur when terminal operation commences.
 * @param parallel if {@code true} then the returned stream is a parallel
 *        stream; if {@code false} the returned stream is a sequential
 *        stream.
 * @return a new sequential or parallel {@code IntStream}
 * @see #intStream(java.util.Spliterator.OfInt, boolean)
 * @apiSince 24
 */

public static java.util.stream.IntStream intStream(java.util.function.Supplier<? extends java.util.Spliterator.OfInt> supplier, int characteristics, boolean parallel) { throw new RuntimeException("Stub!"); }

/**
 * Creates a new sequential or parallel {@code LongStream} from a
 * {@code Spliterator.OfLong}.
 *
 * <p>The spliterator is only traversed, split, or queried for estimated
 * size after the terminal operation of the stream pipeline commences.
 *
 * <p>It is strongly recommended the spliterator report a characteristic of
 * {@code IMMUTABLE} or {@code CONCURRENT}, or be
 * <a href="../Spliterator.html#binding">late-binding</a>.  Otherwise,
 * {@link #longStream(java.util.function.Supplier,int,boolean)} should be
 * used to reduce the scope of potential interference with the source.  See
 * <a href="package-summary.html#NonInterference">Non-Interference</a> for
 * more details.
 *
 * @param spliterator a {@code Spliterator.OfLong} describing the stream elements
 * @param parallel if {@code true} then the returned stream is a parallel
 *        stream; if {@code false} the returned stream is a sequential
 *        stream.
 * @return a new sequential or parallel {@code LongStream}
 * @apiSince 24
 */

public static java.util.stream.LongStream longStream(java.util.Spliterator.OfLong spliterator, boolean parallel) { throw new RuntimeException("Stub!"); }

/**
 * Creates a new sequential or parallel {@code LongStream} from a
 * {@code Supplier} of {@code Spliterator.OfLong}.
 *
 * <p>The {@link java.util.function.Supplier#get() Supplier#get()} method will be invoked on the supplier no
 * more than once, and only after the terminal operation of the stream pipeline
 * commences.
 *
 * <p>For spliterators that report a characteristic of {@code IMMUTABLE}
 * or {@code CONCURRENT}, or that are
 * <a href="../Spliterator.html#binding">late-binding</a>, it is likely
 * more efficient to use {@link #longStream(java.util.Spliterator.OfLong,boolean)}
 * instead.
 * <p>The use of a {@code Supplier} in this form provides a level of
 * indirection that reduces the scope of potential interference with the
 * source.  Since the supplier is only invoked after the terminal operation
 * commences, any modifications to the source up to the start of the
 * terminal operation are reflected in the stream result.  See
 * <a href="package-summary.html#NonInterference">Non-Interference</a> for
 * more details.
 *
 * @param supplier a {@code Supplier} of a {@code Spliterator.OfLong}
 * @param characteristics Spliterator characteristics of the supplied
 *        {@code Spliterator.OfLong}.  The characteristics must be equal to
 *        {@code supplier.get().characteristics()}, otherwise undefined
 *        behavior may occur when terminal operation commences.
 * @param parallel if {@code true} then the returned stream is a parallel
 *        stream; if {@code false} the returned stream is a sequential
 *        stream.
 * @return a new sequential or parallel {@code LongStream}
 * @see #longStream(java.util.Spliterator.OfLong, boolean)
 * @apiSince 24
 */

public static java.util.stream.LongStream longStream(java.util.function.Supplier<? extends java.util.Spliterator.OfLong> supplier, int characteristics, boolean parallel) { throw new RuntimeException("Stub!"); }

/**
 * Creates a new sequential or parallel {@code DoubleStream} from a
 * {@code Spliterator.OfDouble}.
 *
 * <p>The spliterator is only traversed, split, or queried for estimated size
 * after the terminal operation of the stream pipeline commences.
 *
 * <p>It is strongly recommended the spliterator report a characteristic of
 * {@code IMMUTABLE} or {@code CONCURRENT}, or be
 * <a href="../Spliterator.html#binding">late-binding</a>.  Otherwise,
 * {@link #doubleStream(java.util.function.Supplier,int,boolean)} should
 * be used to reduce the scope of potential interference with the source.  See
 * <a href="package-summary.html#NonInterference">Non-Interference</a> for
 * more details.
 *
 * @param spliterator A {@code Spliterator.OfDouble} describing the stream elements
 * @param parallel if {@code true} then the returned stream is a parallel
 *        stream; if {@code false} the returned stream is a sequential
 *        stream.
 * @return a new sequential or parallel {@code DoubleStream}
 * @apiSince 24
 */

public static java.util.stream.DoubleStream doubleStream(java.util.Spliterator.OfDouble spliterator, boolean parallel) { throw new RuntimeException("Stub!"); }

/**
 * Creates a new sequential or parallel {@code DoubleStream} from a
 * {@code Supplier} of {@code Spliterator.OfDouble}.
 *
 * <p>The {@link java.util.function.Supplier#get() Supplier#get()} method will be invoked on the supplier no
 * more than once, and only after the terminal operation of the stream pipeline
 * commences.
 *
 * <p>For spliterators that report a characteristic of {@code IMMUTABLE}
 * or {@code CONCURRENT}, or that are
 * <a href="../Spliterator.html#binding">late-binding</a>, it is likely
 * more efficient to use {@link #doubleStream(java.util.Spliterator.OfDouble,boolean)}
 * instead.
 * <p>The use of a {@code Supplier} in this form provides a level of
 * indirection that reduces the scope of potential interference with the
 * source.  Since the supplier is only invoked after the terminal operation
 * commences, any modifications to the source up to the start of the
 * terminal operation are reflected in the stream result.  See
 * <a href="package-summary.html#NonInterference">Non-Interference</a> for
 * more details.
 *
 * @param supplier A {@code Supplier} of a {@code Spliterator.OfDouble}
 * @param characteristics Spliterator characteristics of the supplied
 *        {@code Spliterator.OfDouble}.  The characteristics must be equal to
 *        {@code supplier.get().characteristics()}, otherwise undefined
 *        behavior may occur when terminal operation commences.
 * @param parallel if {@code true} then the returned stream is a parallel
 *        stream; if {@code false} the returned stream is a sequential
 *        stream.
 * @return a new sequential or parallel {@code DoubleStream}
 * @see #doubleStream(java.util.Spliterator.OfDouble, boolean)
 * @apiSince 24
 */

public static java.util.stream.DoubleStream doubleStream(java.util.function.Supplier<? extends java.util.Spliterator.OfDouble> supplier, int characteristics, boolean parallel) { throw new RuntimeException("Stub!"); }
}

