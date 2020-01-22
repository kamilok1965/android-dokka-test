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

import java.util.function.Function;
import java.util.function.IntSupplier;
import java.util.function.IntConsumer;
import java.util.function.IntBinaryOperator;
import java.util.OptionalInt;
import java.util.function.Supplier;
import java.util.function.BiConsumer;
import java.util.OptionalDouble;
import java.util.IntSummaryStatistics;

/**
 * A sequence of primitive int-valued elements supporting sequential and parallel
 * aggregate operations.  This is the {@code int} primitive specialization of
 * {@link java.util.stream.Stream Stream}.
 *
 * <p>The following example illustrates an aggregate operation using
 * {@link java.util.stream.Stream Stream} and {@link java.util.stream.IntStream IntStream}, computing the sum of the weights of the
 * red widgets:
 *
 * <pre>{@code
 *     int sum = widgets.stream()
 *                      .filter(w -> w.getColor() == RED)
 *                      .mapToInt(w -> w.getWeight())
 *                      .sum();
 * }</pre>
 *
 * See the class documentation for {@link java.util.stream.Stream Stream} and the package documentation
 * for <a href="package-summary.html">java.util.stream</a> for additional
 * specification of streams, stream operations, stream pipelines, and
 * parallelism.
 *
 * @since 1.8
 * @see java.util.stream.Stream
 * @see <a href="package-summary.html">java.util.stream</a>
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public interface IntStream extends java.util.stream.BaseStream<java.lang.Integer,java.util.stream.IntStream> {

/**
 * Returns a stream consisting of the elements of this stream that match
 * the given predicate.
 *
 * <p>This is an <a href="package-summary.html#StreamOps">intermediate
 * operation</a>.
 *
 * @param predicate a <a href="package-summary.html#NonInterference">non-interfering</a>,
 *                  <a href="package-summary.html#Statelessness">stateless</a>
 *                  predicate to apply to each element to determine if it
 *                  should be included
 * @return the new stream
 * @apiSince 24
 */

public java.util.stream.IntStream filter(java.util.function.IntPredicate predicate);

/**
 * Returns a stream consisting of the results of applying the given
 * function to the elements of this stream.
 *
 * <p>This is an <a href="package-summary.html#StreamOps">intermediate
 * operation</a>.
 *
 * @param mapper a <a href="package-summary.html#NonInterference">non-interfering</a>,
 *               <a href="package-summary.html#Statelessness">stateless</a>
 *               function to apply to each element
 * @return the new stream
 * @apiSince 24
 */

public java.util.stream.IntStream map(java.util.function.IntUnaryOperator mapper);

/**
 * Returns an object-valued {@code Stream} consisting of the results of
 * applying the given function to the elements of this stream.
 *
 * <p>This is an <a href="package-summary.html#StreamOps">
 *     intermediate operation</a>.
 *
 * @param <U> the element type of the new stream
 * @param mapper a <a href="package-summary.html#NonInterference">non-interfering</a>,
 *               <a href="package-summary.html#Statelessness">stateless</a>
 *               function to apply to each element
 * @return the new stream
 * @apiSince 24
 */

public <U> java.util.stream.Stream<U> mapToObj(java.util.function.IntFunction<? extends U> mapper);

/**
 * Returns a {@code LongStream} consisting of the results of applying the
 * given function to the elements of this stream.
 *
 * <p>This is an <a href="package-summary.html#StreamOps">intermediate
 * operation</a>.
 *
 * @param mapper a <a href="package-summary.html#NonInterference">non-interfering</a>,
 *               <a href="package-summary.html#Statelessness">stateless</a>
 *               function to apply to each element
 * @return the new stream
 * @apiSince 24
 */

public java.util.stream.LongStream mapToLong(java.util.function.IntToLongFunction mapper);

/**
 * Returns a {@code DoubleStream} consisting of the results of applying the
 * given function to the elements of this stream.
 *
 * <p>This is an <a href="package-summary.html#StreamOps">intermediate
 * operation</a>.
 *
 * @param mapper a <a href="package-summary.html#NonInterference">non-interfering</a>,
 *               <a href="package-summary.html#Statelessness">stateless</a>
 *               function to apply to each element
 * @return the new stream
 * @apiSince 24
 */

public java.util.stream.DoubleStream mapToDouble(java.util.function.IntToDoubleFunction mapper);

/**
 * Returns a stream consisting of the results of replacing each element of
 * this stream with the contents of a mapped stream produced by applying
 * the provided mapping function to each element.  Each mapped stream is
 * {@link java.util.stream.BaseStream#close() closed} after its contents
 * have been placed into this stream.  (If a mapped stream is {@code null}
 * an empty stream is used, instead.)
 *
 * <p>This is an <a href="package-summary.html#StreamOps">intermediate
 * operation</a>.
 *
 * @param mapper a <a href="package-summary.html#NonInterference">non-interfering</a>,
 *               <a href="package-summary.html#Statelessness">stateless</a>
 *               function to apply to each element which produces an
 *               {@code IntStream} of new values
 * @return the new stream
 * @see java.util.stream.Stream#flatMap(Function)
 * @apiSince 24
 */

public java.util.stream.IntStream flatMap(java.util.function.IntFunction<? extends java.util.stream.IntStream> mapper);

/**
 * Returns a stream consisting of the distinct elements of this stream.
 *
 * <p>This is a <a href="package-summary.html#StreamOps">stateful
 * intermediate operation</a>.
 *
 * @return the new stream
 * @apiSince 24
 */

public java.util.stream.IntStream distinct();

/**
 * Returns a stream consisting of the elements of this stream in sorted
 * order.
 *
 * <p>This is a <a href="package-summary.html#StreamOps">stateful
 * intermediate operation</a>.
 *
 * @return the new stream
 * @apiSince 24
 */

public java.util.stream.IntStream sorted();

/**
 * Returns a stream consisting of the elements of this stream, additionally
 * performing the provided action on each element as elements are consumed
 * from the resulting stream.
 *
 * <p>This is an <a href="package-summary.html#StreamOps">intermediate
 * operation</a>.
 *
 * <p>For parallel stream pipelines, the action may be called at
 * whatever time and in whatever thread the element is made available by the
 * upstream operation.  If the action modifies shared state,
 * it is responsible for providing the required synchronization.
 *
 * @apiNote This method exists mainly to support debugging, where you want
 * to see the elements as they flow past a certain point in a pipeline:
 * <pre>{@code
 *     IntStream.of(1, 2, 3, 4)
 *         .filter(e -> e > 2)
 *         .peek(e -> System.out.println("Filtered value: " + e))
 *         .map(e -> e * e)
 *         .peek(e -> System.out.println("Mapped value: " + e))
 *         .sum();
 * }</pre>
 *
 * @param action a <a href="package-summary.html#NonInterference">
 *               non-interfering</a> action to perform on the elements as
 *               they are consumed from the stream
 * @return the new stream
 * @apiSince 24
 */

public java.util.stream.IntStream peek(java.util.function.IntConsumer action);

/**
 * Returns a stream consisting of the elements of this stream, truncated
 * to be no longer than {@code maxSize} in length.
 *
 * <p>This is a <a href="package-summary.html#StreamOps">short-circuiting
 * stateful intermediate operation</a>.
 *
 * @apiNote
 * While {@code limit()} is generally a cheap operation on sequential
 * stream pipelines, it can be quite expensive on ordered parallel pipelines,
 * especially for large values of {@code maxSize}, since {@code limit(n)}
 * is constrained to return not just any <em>n</em> elements, but the
 * <em>first n</em> elements in the encounter order.  Using an unordered
 * stream source (such as {@link #generate(java.util.function.IntSupplier)}) or removing the
 * ordering constraint with {@link #unordered()} may result in significant
 * speedups of {@code limit()} in parallel pipelines, if the semantics of
 * your situation permit.  If consistency with encounter order is required,
 * and you are experiencing poor performance or memory utilization with
 * {@code limit()} in parallel pipelines, switching to sequential execution
 * with {@link #sequential()} may improve performance.
 *
 * @param maxSize the number of elements the stream should be limited to
 * @return the new stream
 * @throws java.lang.IllegalArgumentException if {@code maxSize} is negative
 * @apiSince 24
 */

public java.util.stream.IntStream limit(long maxSize);

/**
 * Returns a stream consisting of the remaining elements of this stream
 * after discarding the first {@code n} elements of the stream.
 * If this stream contains fewer than {@code n} elements then an
 * empty stream will be returned.
 *
 * <p>This is a <a href="package-summary.html#StreamOps">stateful
 * intermediate operation</a>.
 *
 * @apiNote
 * While {@code skip()} is generally a cheap operation on sequential
 * stream pipelines, it can be quite expensive on ordered parallel pipelines,
 * especially for large values of {@code n}, since {@code skip(n)}
 * is constrained to skip not just any <em>n</em> elements, but the
 * <em>first n</em> elements in the encounter order.  Using an unordered
 * stream source (such as {@link #generate(java.util.function.IntSupplier)}) or removing the
 * ordering constraint with {@link #unordered()} may result in significant
 * speedups of {@code skip()} in parallel pipelines, if the semantics of
 * your situation permit.  If consistency with encounter order is required,
 * and you are experiencing poor performance or memory utilization with
 * {@code skip()} in parallel pipelines, switching to sequential execution
 * with {@link #sequential()} may improve performance.
 *
 * @param n the number of leading elements to skip
 * @return the new stream
 * @throws java.lang.IllegalArgumentException if {@code n} is negative
 * @apiSince 24
 */

public java.util.stream.IntStream skip(long n);

/**
 * Performs an action for each element of this stream.
 *
 * <p>This is a <a href="package-summary.html#StreamOps">terminal
 * operation</a>.
 *
 * <p>For parallel stream pipelines, this operation does <em>not</em>
 * guarantee to respect the encounter order of the stream, as doing so
 * would sacrifice the benefit of parallelism.  For any given element, the
 * action may be performed at whatever time and in whatever thread the
 * library chooses.  If the action accesses shared state, it is
 * responsible for providing the required synchronization.
 *
 * @param action a <a href="package-summary.html#NonInterference">
 *               non-interfering</a> action to perform on the elements
 * @apiSince 24
 */

public void forEach(java.util.function.IntConsumer action);

/**
 * Performs an action for each element of this stream, guaranteeing that
 * each element is processed in encounter order for streams that have a
 * defined encounter order.
 *
 * <p>This is a <a href="package-summary.html#StreamOps">terminal
 * operation</a>.
 *
 * @param action a <a href="package-summary.html#NonInterference">
 *               non-interfering</a> action to perform on the elements
 * @see #forEach(IntConsumer)
 * @apiSince 24
 */

public void forEachOrdered(java.util.function.IntConsumer action);

/**
 * Returns an array containing the elements of this stream.
 *
 * <p>This is a <a href="package-summary.html#StreamOps">terminal
 * operation</a>.
 *
 * @return an array containing the elements of this stream
 * @apiSince 24
 */

public int[] toArray();

/**
 * Performs a <a href="package-summary.html#Reduction">reduction</a> on the
 * elements of this stream, using the provided identity value and an
 * <a href="package-summary.html#Associativity">associative</a>
 * accumulation function, and returns the reduced value.  This is equivalent
 * to:
 * <pre>{@code
 *     int result = identity;
 *     for (int element : this stream)
 *         result = accumulator.applyAsInt(result, element)
 *     return result;
 * }</pre>
 *
 * but is not constrained to execute sequentially.
 *
 * <p>The {@code identity} value must be an identity for the accumulator
 * function. This means that for all {@code x},
 * {@code accumulator.apply(identity, x)} is equal to {@code x}.
 * The {@code accumulator} function must be an
 * <a href="package-summary.html#Associativity">associative</a> function.
 *
 * <p>This is a <a href="package-summary.html#StreamOps">terminal
 * operation</a>.
 *
 * @apiNote Sum, min, max, and average are all special cases of reduction.
 * Summing a stream of numbers can be expressed as:
 *
 * <pre>{@code
 *     int sum = integers.reduce(0, (a, b) -> a+b);
 * }</pre>
 *
 * or more compactly:
 *
 * <pre>{@code
 *     int sum = integers.reduce(0, Integer::sum);
 * }</pre>
 *
 * <p>While this may seem a more roundabout way to perform an aggregation
 * compared to simply mutating a running total in a loop, reduction
 * operations parallelize more gracefully, without needing additional
 * synchronization and with greatly reduced risk of data races.
 *
 * @param identity the identity value for the accumulating function
 * @param op an <a href="package-summary.html#Associativity">associative</a>,
 *           <a href="package-summary.html#NonInterference">non-interfering</a>,
 *           <a href="package-summary.html#Statelessness">stateless</a>
 *           function for combining two values
 * @return the result of the reduction
 * @see #sum()
 * @see #min()
 * @see #max()
 * @see #average()
 * @apiSince 24
 */

public int reduce(int identity, java.util.function.IntBinaryOperator op);

/**
 * Performs a <a href="package-summary.html#Reduction">reduction</a> on the
 * elements of this stream, using an
 * <a href="package-summary.html#Associativity">associative</a> accumulation
 * function, and returns an {@code OptionalInt} describing the reduced value,
 * if any. This is equivalent to:
 * <pre>{@code
 *     boolean foundAny = false;
 *     int result = null;
 *     for (int element : this stream) {
 *         if (!foundAny) {
 *             foundAny = true;
 *             result = element;
 *         }
 *         else
 *             result = accumulator.applyAsInt(result, element);
 *     }
 *     return foundAny ? OptionalInt.of(result) : OptionalInt.empty();
 * }</pre>
 *
 * but is not constrained to execute sequentially.
 *
 * <p>The {@code accumulator} function must be an
 * <a href="package-summary.html#Associativity">associative</a> function.
 *
 * <p>This is a <a href="package-summary.html#StreamOps">terminal
 * operation</a>.
 *
 * @param op an <a href="package-summary.html#Associativity">associative</a>,
 *           <a href="package-summary.html#NonInterference">non-interfering</a>,
 *           <a href="package-summary.html#Statelessness">stateless</a>
 *           function for combining two values
 * @return the result of the reduction
 * @see #reduce(int, IntBinaryOperator)
 * @apiSince 24
 */

public java.util.OptionalInt reduce(java.util.function.IntBinaryOperator op);

/**
 * Performs a <a href="package-summary.html#MutableReduction">mutable
 * reduction</a> operation on the elements of this stream.  A mutable
 * reduction is one in which the reduced value is a mutable result container,
 * such as an {@code ArrayList}, and elements are incorporated by updating
 * the state of the result rather than by replacing the result.  This
 * produces a result equivalent to:
 * <pre>{@code
 *     R result = supplier.get();
 *     for (int element : this stream)
 *         accumulator.accept(result, element);
 *     return result;
 * }</pre>
 *
 * <p>Like {@link #reduce(int,java.util.function.IntBinaryOperator)}, {@code collect} operations
 * can be parallelized without requiring additional synchronization.
 *
 * <p>This is a <a href="package-summary.html#StreamOps">terminal
 * operation</a>.
 *
 * @param <R> type of the result
 * @param supplier a function that creates a new result container. For a
 *                 parallel execution, this function may be called
 *                 multiple times and must return a fresh value each time.
 * @param accumulator an <a href="package-summary.html#Associativity">associative</a>,
 *                    <a href="package-summary.html#NonInterference">non-interfering</a>,
 *                    <a href="package-summary.html#Statelessness">stateless</a>
 *                    function for incorporating an additional element into a result
 * @param combiner an <a href="package-summary.html#Associativity">associative</a>,
 *                    <a href="package-summary.html#NonInterference">non-interfering</a>,
 *                    <a href="package-summary.html#Statelessness">stateless</a>
 *                    function for combining two values, which must be
 *                    compatible with the accumulator function
 * @return the result of the reduction
 * @see java.util.stream.Stream#collect(Supplier, BiConsumer, BiConsumer)
 * @apiSince 24
 */

public <R> R collect(java.util.function.Supplier<R> supplier, java.util.function.ObjIntConsumer<R> accumulator, java.util.function.BiConsumer<R,R> combiner);

/**
 * Returns the sum of elements in this stream.  This is a special case
 * of a <a href="package-summary.html#Reduction">reduction</a>
 * and is equivalent to:
 * <pre>{@code
 *     return reduce(0, Integer::sum);
 * }</pre>
 *
 * <p>This is a <a href="package-summary.html#StreamOps">terminal
 * operation</a>.
 *
 * @return the sum of elements in this stream
 * @apiSince 24
 */

public int sum();

/**
 * Returns an {@code OptionalInt} describing the minimum element of this
 * stream, or an empty optional if this stream is empty.  This is a special
 * case of a <a href="package-summary.html#Reduction">reduction</a>
 * and is equivalent to:
 * <pre>{@code
 *     return reduce(Integer::min);
 * }</pre>
 *
 * <p>This is a <a href="package-summary.html#StreamOps">terminal operation</a>.
 *
 * @return an {@code OptionalInt} containing the minimum element of this
 * stream, or an empty {@code OptionalInt} if the stream is empty
 * @apiSince 24
 */

public java.util.OptionalInt min();

/**
 * Returns an {@code OptionalInt} describing the maximum element of this
 * stream, or an empty optional if this stream is empty.  This is a special
 * case of a <a href="package-summary.html#Reduction">reduction</a>
 * and is equivalent to:
 * <pre>{@code
 *     return reduce(Integer::max);
 * }</pre>
 *
 * <p>This is a <a href="package-summary.html#StreamOps">terminal
 * operation</a>.
 *
 * @return an {@code OptionalInt} containing the maximum element of this
 * stream, or an empty {@code OptionalInt} if the stream is empty
 * @apiSince 24
 */

public java.util.OptionalInt max();

/**
 * Returns the count of elements in this stream.  This is a special case of
 * a <a href="package-summary.html#Reduction">reduction</a> and is
 * equivalent to:
 * <pre>{@code
 *     return mapToLong(e -> 1L).sum();
 * }</pre>
 *
 * <p>This is a <a href="package-summary.html#StreamOps">terminal operation</a>.
 *
 * @return the count of elements in this stream
 * @apiSince 24
 */

public long count();

/**
 * Returns an {@code OptionalDouble} describing the arithmetic mean of elements of
 * this stream, or an empty optional if this stream is empty.  This is a
 * special case of a
 * <a href="package-summary.html#Reduction">reduction</a>.
 *
 * <p>This is a <a href="package-summary.html#StreamOps">terminal
 * operation</a>.
 *
 * @return an {@code OptionalDouble} containing the average element of this
 * stream, or an empty optional if the stream is empty
 * @apiSince 24
 */

public java.util.OptionalDouble average();

/**
 * Returns an {@code IntSummaryStatistics} describing various
 * summary data about the elements of this stream.  This is a special
 * case of a <a href="package-summary.html#Reduction">reduction</a>.
 *
 * <p>This is a <a href="package-summary.html#StreamOps">terminal
 * operation</a>.
 *
 * @return an {@code IntSummaryStatistics} describing various summary data
 * about the elements of this stream
 * @apiSince 24
 */

public java.util.IntSummaryStatistics summaryStatistics();

/**
 * Returns whether any elements of this stream match the provided
 * predicate.  May not evaluate the predicate on all elements if not
 * necessary for determining the result.  If the stream is empty then
 * {@code false} is returned and the predicate is not evaluated.
 *
 * <p>This is a <a href="package-summary.html#StreamOps">short-circuiting
 * terminal operation</a>.
 *
 * @apiNote
 * This method evaluates the <em>existential quantification</em> of the
 * predicate over the elements of the stream (for some x P(x)).
 *
 * @param predicate a <a href="package-summary.html#NonInterference">non-interfering</a>,
 *                  <a href="package-summary.html#Statelessness">stateless</a>
 *                  predicate to apply to elements of this stream
 * @return {@code true} if any elements of the stream match the provided
 * predicate, otherwise {@code false}
 * @apiSince 24
 */

public boolean anyMatch(java.util.function.IntPredicate predicate);

/**
 * Returns whether all elements of this stream match the provided predicate.
 * May not evaluate the predicate on all elements if not necessary for
 * determining the result.  If the stream is empty then {@code true} is
 * returned and the predicate is not evaluated.
 *
 * <p>This is a <a href="package-summary.html#StreamOps">short-circuiting
 * terminal operation</a>.
 *
 * @apiNote
 * This method evaluates the <em>universal quantification</em> of the
 * predicate over the elements of the stream (for all x P(x)).  If the
 * stream is empty, the quantification is said to be <em>vacuously
 * satisfied</em> and is always {@code true} (regardless of P(x)).
 *
 * @param predicate a <a href="package-summary.html#NonInterference">non-interfering</a>,
 *                  <a href="package-summary.html#Statelessness">stateless</a>
 *                  predicate to apply to elements of this stream
 * @return {@code true} if either all elements of the stream match the
 * provided predicate or the stream is empty, otherwise {@code false}
 * @apiSince 24
 */

public boolean allMatch(java.util.function.IntPredicate predicate);

/**
 * Returns whether no elements of this stream match the provided predicate.
 * May not evaluate the predicate on all elements if not necessary for
 * determining the result.  If the stream is empty then {@code true} is
 * returned and the predicate is not evaluated.
 *
 * <p>This is a <a href="package-summary.html#StreamOps">short-circuiting
 * terminal operation</a>.
 *
 * @apiNote
 * This method evaluates the <em>universal quantification</em> of the
 * negated predicate over the elements of the stream (for all x ~P(x)).  If
 * the stream is empty, the quantification is said to be vacuously satisfied
 * and is always {@code true}, regardless of P(x).
 *
 * @param predicate a <a href="package-summary.html#NonInterference">non-interfering</a>,
 *                  <a href="package-summary.html#Statelessness">stateless</a>
 *                  predicate to apply to elements of this stream
 * @return {@code true} if either no elements of the stream match the
 * provided predicate or the stream is empty, otherwise {@code false}
 * @apiSince 24
 */

public boolean noneMatch(java.util.function.IntPredicate predicate);

/**
 * Returns an {@link java.util.OptionalInt OptionalInt} describing the first element of this
 * stream, or an empty {@code OptionalInt} if the stream is empty.  If the
 * stream has no encounter order, then any element may be returned.
 *
 * <p>This is a <a href="package-summary.html#StreamOps">short-circuiting
 * terminal operation</a>.
 *
 * @return an {@code OptionalInt} describing the first element of this stream,
 * or an empty {@code OptionalInt} if the stream is empty
 * @apiSince 24
 */

public java.util.OptionalInt findFirst();

/**
 * Returns an {@link java.util.OptionalInt OptionalInt} describing some element of the stream, or
 * an empty {@code OptionalInt} if the stream is empty.
 *
 * <p>This is a <a href="package-summary.html#StreamOps">short-circuiting
 * terminal operation</a>.
 *
 * <p>The behavior of this operation is explicitly nondeterministic; it is
 * free to select any element in the stream.  This is to allow for maximal
 * performance in parallel operations; the cost is that multiple invocations
 * on the same source may not return the same result.  (If a stable result
 * is desired, use {@link #findFirst()} instead.)
 *
 * @return an {@code OptionalInt} describing some element of this stream, or
 * an empty {@code OptionalInt} if the stream is empty
 * @see #findFirst()
 * @apiSince 24
 */

public java.util.OptionalInt findAny();

/**
 * Returns a {@code LongStream} consisting of the elements of this stream,
 * converted to {@code long}.
 *
 * <p>This is an <a href="package-summary.html#StreamOps">intermediate
 * operation</a>.
 *
 * @return a {@code LongStream} consisting of the elements of this stream,
 * converted to {@code long}
 * @apiSince 24
 */

public java.util.stream.LongStream asLongStream();

/**
 * Returns a {@code DoubleStream} consisting of the elements of this stream,
 * converted to {@code double}.
 *
 * <p>This is an <a href="package-summary.html#StreamOps">intermediate
 * operation</a>.
 *
 * @return a {@code DoubleStream} consisting of the elements of this stream,
 * converted to {@code double}
 * @apiSince 24
 */

public java.util.stream.DoubleStream asDoubleStream();

/**
 * Returns a {@code Stream} consisting of the elements of this stream,
 * each boxed to an {@code Integer}.
 *
 * <p>This is an <a href="package-summary.html#StreamOps">intermediate
 * operation</a>.
 *
 * @return a {@code Stream} consistent of the elements of this stream,
 * each boxed to an {@code Integer}
 * @apiSince 24
 */

public java.util.stream.Stream<java.lang.Integer> boxed();

/** @apiSince 24 */

public java.util.stream.IntStream sequential();

/** @apiSince 24 */

public java.util.stream.IntStream parallel();

/** @apiSince 24 */

public java.util.PrimitiveIterator.OfInt iterator();

/** @apiSince 24 */

public java.util.Spliterator.OfInt spliterator();

/**
 * Returns a builder for an {@code IntStream}.
 *
 * @return a stream builder
 * @apiSince 24
 */

public static java.util.stream.IntStream.Builder builder() { throw new RuntimeException("Stub!"); }

/**
 * Returns an empty sequential {@code IntStream}.
 *
 * @return an empty sequential stream
 * @apiSince 24
 */

public static java.util.stream.IntStream empty() { throw new RuntimeException("Stub!"); }

/**
 * Returns a sequential {@code IntStream} containing a single element.
 *
 * @param t the single element
 * @return a singleton sequential stream
 * @apiSince 24
 */

public static java.util.stream.IntStream of(int t) { throw new RuntimeException("Stub!"); }

/**
 * Returns a sequential ordered stream whose elements are the specified values.
 *
 * @param values the elements of the new stream
 * @return the new stream
 * @apiSince 24
 */

public static java.util.stream.IntStream of(int... values) { throw new RuntimeException("Stub!"); }

/**
 * Returns an infinite sequential ordered {@code IntStream} produced by iterative
 * application of a function {@code f} to an initial element {@code seed},
 * producing a {@code Stream} consisting of {@code seed}, {@code f(seed)},
 * {@code f(f(seed))}, etc.
 *
 * <p>The first element (position {@code 0}) in the {@code IntStream} will be
 * the provided {@code seed}.  For {@code n > 0}, the element at position
 * {@code n}, will be the result of applying the function {@code f} to the
 * element at position {@code n - 1}.
 *
 * @param seed the initial element
 * @param f a function to be applied to to the previous element to produce
 *          a new element
 * @return A new sequential {@code IntStream}
 * @apiSince 24
 */

public static java.util.stream.IntStream iterate(int seed, java.util.function.IntUnaryOperator f) { throw new RuntimeException("Stub!"); }

/**
 * Returns an infinite sequential unordered stream where each element is
 * generated by the provided {@code IntSupplier}.  This is suitable for
 * generating constant streams, streams of random elements, etc.
 *
 * @param s the {@code IntSupplier} for generated elements
 * @return a new infinite sequential unordered {@code IntStream}
 * @apiSince 24
 */

public static java.util.stream.IntStream generate(java.util.function.IntSupplier s) { throw new RuntimeException("Stub!"); }

/**
 * Returns a sequential ordered {@code IntStream} from {@code startInclusive}
 * (inclusive) to {@code endExclusive} (exclusive) by an incremental step of
 * {@code 1}.
 *
 * @apiNote
 * <p>An equivalent sequence of increasing values can be produced
 * sequentially using a {@code for} loop as follows:
 * <pre>{@code
 *     for (int i = startInclusive; i < endExclusive ; i++) { ... }
 * }</pre>
 *
 * @param startInclusive the (inclusive) initial value
 * @param endExclusive the exclusive upper bound
 * @return a sequential {@code IntStream} for the range of {@code int}
 *         elements
 * @apiSince 24
 */

public static java.util.stream.IntStream range(int startInclusive, int endExclusive) { throw new RuntimeException("Stub!"); }

/**
 * Returns a sequential ordered {@code IntStream} from {@code startInclusive}
 * (inclusive) to {@code endInclusive} (inclusive) by an incremental step of
 * {@code 1}.
 *
 * @apiNote
 * <p>An equivalent sequence of increasing values can be produced
 * sequentially using a {@code for} loop as follows:
 * <pre>{@code
 *     for (int i = startInclusive; i <= endInclusive ; i++) { ... }
 * }</pre>
 *
 * @param startInclusive the (inclusive) initial value
 * @param endInclusive the inclusive upper bound
 * @return a sequential {@code IntStream} for the range of {@code int}
 *         elements
 * @apiSince 24
 */

public static java.util.stream.IntStream rangeClosed(int startInclusive, int endInclusive) { throw new RuntimeException("Stub!"); }

/**
 * Creates a lazily concatenated stream whose elements are all the
 * elements of the first stream followed by all the elements of the
 * second stream.  The resulting stream is ordered if both
 * of the input streams are ordered, and parallel if either of the input
 * streams is parallel.  When the resulting stream is closed, the close
 * handlers for both input streams are invoked.
 *
 * @implNote
 * Use caution when constructing streams from repeated concatenation.
 * Accessing an element of a deeply concatenated stream can result in deep
 * call chains, or even {@code StackOverflowException}.
 *
 * @param a the first stream
 * @param b the second stream
 * @return the concatenation of the two input streams
 * @apiSince 24
 */

public static java.util.stream.IntStream concat(java.util.stream.IntStream a, java.util.stream.IntStream b) { throw new RuntimeException("Stub!"); }
/**
 * A mutable builder for an {@code IntStream}.
 *
 * <p>A stream builder has a lifecycle, which starts in a building
 * phase, during which elements can be added, and then transitions to a built
 * phase, after which elements may not be added.  The built phase
 * begins when the {@link #build()} method is called, which creates an
 * ordered stream whose elements are the elements that were added to the
 * stream builder, in the order they were added.
 *
 * @see java.util.stream.IntStream#builder()
 * @since 1.8
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface Builder extends java.util.function.IntConsumer {

/**
 * Adds an element to the stream being built.
 *
 * @throws java.lang.IllegalStateException if the builder has already transitioned
 * to the built state
 * @apiSince 24
 */

public void accept(int t);

/**
 * Adds an element to the stream being built.
 *
 * @implSpec
 * The default implementation behaves as if:
 * <pre>{@code
 *     accept(t)
 *     return this;
 * }</pre>
 *
 * @param t the element to add
 * @return {@code this} builder
 * @throws java.lang.IllegalStateException if the builder has already transitioned
 * to the built state
 * @apiSince 24
 */

public default java.util.stream.IntStream.Builder add(int t) { throw new RuntimeException("Stub!"); }

/**
 * Builds the stream, transitioning this builder to the built state.
 * An {@code IllegalStateException} is thrown if there are further
 * attempts to operate on the builder after it has entered the built
 * state.
 *
 * @return the built stream
 * @throws java.lang.IllegalStateException if the builder has already transitioned to
 * the built state
 * @apiSince 24
 */

public java.util.stream.IntStream build();
}

}
