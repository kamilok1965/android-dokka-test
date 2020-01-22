/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
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
import java.util.function.IntConsumer;
import java.util.function.DoubleConsumer;
import java.util.function.LongConsumer;

/**
 * An object for traversing and partitioning elements of a source.  The source
 * of elements covered by a Spliterator could be, for example, an array, a
 * {@link java.util.Collection Collection}, an IO channel, or a generator function.
 *
 * <p>A Spliterator may traverse elements individually ({@link
 * #tryAdvance tryAdvance()}) or sequentially in bulk
 * ({@link #forEachRemaining forEachRemaining()}).
 *
 * <p>A Spliterator may also partition off some of its elements (using
 * {@link #trySplit}) as another Spliterator, to be used in
 * possibly-parallel operations.  Operations using a Spliterator that
 * cannot split, or does so in a highly imbalanced or inefficient
 * manner, are unlikely to benefit from parallelism.  Traversal
 * and splitting exhaust elements; each Spliterator is useful for only a single
 * bulk computation.
 *
 * <p>A Spliterator also reports a set of {@link #characteristics()} of its
 * structure, source, and elements from among {@link #ORDERED},
 * {@link #DISTINCT}, {@link #SORTED}, {@link #SIZED}, {@link #NONNULL},
 * {@link #IMMUTABLE}, {@link #CONCURRENT}, and {@link #SUBSIZED}. These may
 * be employed by Spliterator clients to control, specialize or simplify
 * computation.  For example, a Spliterator for a {@link java.util.Collection Collection} would
 * report {@code SIZED}, a Spliterator for a {@link java.util.Set Set} would report
 * {@code DISTINCT}, and a Spliterator for a {@link java.util.SortedSet SortedSet} would also
 * report {@code SORTED}.  Characteristics are reported as a simple unioned bit
 * set.
 *
 * Some characteristics additionally constrain method behavior; for example if
 * {@code ORDERED}, traversal methods must conform to their documented ordering.
 * New characteristics may be defined in the future, so implementors should not
 * assign meanings to unlisted values.
 *
 * <p><a name="binding">A Spliterator that does not report {@code IMMUTABLE} or
 * {@code CONCURRENT} is expected to have a documented policy concerning:
 * when the spliterator <em>binds</em> to the element source; and detection of
 * structural interference of the element source detected after binding.</a>  A
 * <em>late-binding</em> Spliterator binds to the source of elements at the
 * point of first traversal, first split, or first query for estimated size,
 * rather than at the time the Spliterator is created.  A Spliterator that is
 * not <em>late-binding</em> binds to the source of elements at the point of
 * construction or first invocation of any method.  Modifications made to the
 * source prior to binding are reflected when the Spliterator is traversed.
 * After binding a Spliterator should, on a best-effort basis, throw
 * {@link java.util.ConcurrentModificationException ConcurrentModificationException} if structural interference is
 * detected.  Spliterators that do this are called <em>fail-fast</em>.  The
 * bulk traversal method ({@link #forEachRemaining forEachRemaining()}) of a
 * Spliterator may optimize traversal and check for structural interference
 * after all elements have been traversed, rather than checking per-element and
 * failing immediately.
 *
 * <p>Spliterators can provide an estimate of the number of remaining elements
 * via the {@link #estimateSize} method.  Ideally, as reflected in characteristic
 * {@link #SIZED}, this value corresponds exactly to the number of elements
 * that would be encountered in a successful traversal.  However, even when not
 * exactly known, an estimated value value may still be useful to operations
 * being performed on the source, such as helping to determine whether it is
 * preferable to split further or traverse the remaining elements sequentially.
 *
 * <p>Despite their obvious utility in parallel algorithms, spliterators are not
 * expected to be thread-safe; instead, implementations of parallel algorithms
 * using spliterators should ensure that the spliterator is only used by one
 * thread at a time.  This is generally easy to attain via <em>serial
 * thread-confinement</em>, which often is a natural consequence of typical
 * parallel algorithms that work by recursive decomposition.  A thread calling
 * {@link #trySplit()} may hand over the returned Spliterator to another thread,
 * which in turn may traverse or further split that Spliterator.  The behaviour
 * of splitting and traversal is undefined if two or more threads operate
 * concurrently on the same spliterator.  If the original thread hands a
 * spliterator off to another thread for processing, it is best if that handoff
 * occurs before any elements are consumed with {@link #tryAdvance(java.util.function.Consumer)
 * tryAdvance()}, as certain guarantees (such as the accuracy of
 * {@link #estimateSize()} for {@code SIZED} spliterators) are only valid before
 * traversal has begun.
 *
 * <p>Primitive subtype specializations of {@code Spliterator} are provided for
 * {@link java.util.Spliterator.OfInt OfInt}, {@link java.util.Spliterator.OfLong OfLong}, and {@link java.util.Spliterator.OfDouble OfDouble} values.
 * The subtype default implementations of
 * {@link java.util.Spliterator#tryAdvance(java.util.function.Consumer) Spliterator#tryAdvance(java.util.function.Consumer)}
 * and {@link java.util.Spliterator#forEachRemaining(java.util.function.Consumer) Spliterator#forEachRemaining(java.util.function.Consumer)} box
 * primitive values to instances of their corresponding wrapper class.  Such
 * boxing may undermine any performance advantages gained by using the primitive
 * specializations.  To avoid boxing, the corresponding primitive-based methods
 * should be used.  For example,
 * {@link java.util.Spliterator.OfInt#tryAdvance(java.util.function.IntConsumer) Spliterator.OfInt#tryAdvance(java.util.function.IntConsumer)}
 * and {@link java.util.Spliterator.OfInt#forEachRemaining(java.util.function.IntConsumer) Spliterator.OfInt#forEachRemaining(java.util.function.IntConsumer)}
 * should be used in preference to
 * {@link java.util.Spliterator.OfInt#tryAdvance(java.util.function.Consumer) Spliterator.OfInt#tryAdvance(java.util.function.Consumer)} and
 * {@link java.util.Spliterator.OfInt#forEachRemaining(java.util.function.Consumer) Spliterator.OfInt#forEachRemaining(java.util.function.Consumer)}.
 * Traversal of primitive values using boxing-based methods
 * {@link #tryAdvance tryAdvance()} and
 * {@link #forEachRemaining(java.util.function.Consumer) forEachRemaining()}
 * does not affect the order in which the values, transformed to boxed values,
 * are encountered.
 *
 * @apiNote
 * <p>Spliterators, like {@code Iterator}s, are for traversing the elements of
 * a source.  The {@code Spliterator} API was designed to support efficient
 * parallel traversal in addition to sequential traversal, by supporting
 * decomposition as well as single-element iteration.  In addition, the
 * protocol for accessing elements via a Spliterator is designed to impose
 * smaller per-element overhead than {@code Iterator}, and to avoid the inherent
 * race involved in having separate methods for {@code hasNext()} and
 * {@code next()}.
 *
 * <p>For mutable sources, arbitrary and non-deterministic behavior may occur if
 * the source is structurally interfered with (elements added, replaced, or
 * removed) between the time that the Spliterator binds to its data source and
 * the end of traversal.  For example, such interference will produce arbitrary,
 * non-deterministic results when using the {@code java.util.stream} framework.
 *
 * <p>Structural interference of a source can be managed in the following ways
 * (in approximate order of decreasing desirability):
 * <ul>
 * <li>The source cannot be structurally interfered with.
 * <br>For example, an instance of
 * {@link java.util.concurrent.CopyOnWriteArrayList} is an immutable source.
 * A Spliterator created from the source reports a characteristic of
 * {@code IMMUTABLE}.</li>
 * <li>The source manages concurrent modifications.
 * <br>For example, a key set of a {@link java.util.concurrent.ConcurrentHashMap}
 * is a concurrent source.  A Spliterator created from the source reports a
 * characteristic of {@code CONCURRENT}.</li>
 * <li>The mutable source provides a late-binding and fail-fast Spliterator.
 * <br>Late binding narrows the window during which interference can affect
 * the calculation; fail-fast detects, on a best-effort basis, that structural
 * interference has occurred after traversal has commenced and throws
 * {@link java.util.ConcurrentModificationException ConcurrentModificationException}.  For example, {@link java.util.ArrayList ArrayList},
 * and many other non-concurrent {@code Collection} classes in the JDK, provide
 * a late-binding, fail-fast spliterator.</li>
 * <li>The mutable source provides a non-late-binding but fail-fast Spliterator.
 * <br>The source increases the likelihood of throwing
 * {@code ConcurrentModificationException} since the window of potential
 * interference is larger.</li>
 * <li>The mutable source provides a late-binding and non-fail-fast Spliterator.
 * <br>The source risks arbitrary, non-deterministic behavior after traversal
 * has commenced since interference is not detected.
 * </li>
 * <li>The mutable source provides a non-late-binding and non-fail-fast
 * Spliterator.
 * <br>The source increases the risk of arbitrary, non-deterministic behavior
 * since non-detected interference may occur after construction.
 * </li>
 * </ul>
 *
 * <p><b>Example.</b> Here is a class (not a very useful one, except
 * for illustration) that maintains an array in which the actual data
 * are held in even locations, and unrelated tag data are held in odd
 * locations. Its Spliterator ignores the tags.
 *
 * <pre> {@code
 * class TaggedArray<T> {
 *   private final Object[] elements; // immutable after construction
 *   TaggedArray(T[] data, Object[] tags) {
 *     int size = data.length;
 *     if (tags.length != size) throw new IllegalArgumentException();
 *     this.elements = new Object[2 * size];
 *     for (int i = 0, j = 0; i < size; ++i) {
 *       elements[j++] = data[i];
 *       elements[j++] = tags[i];
 *     }
 *   }
 *
 *   public Spliterator<T> spliterator() {
 *     return new TaggedArraySpliterator<>(elements, 0, elements.length);
 *   }
 *
 *   static class TaggedArraySpliterator<T> implements Spliterator<T> {
 *     private final Object[] array;
 *     private int origin; // current index, advanced on split or traversal
 *     private final int fence; // one past the greatest index
 *
 *     TaggedArraySpliterator(Object[] array, int origin, int fence) {
 *       this.array = array; this.origin = origin; this.fence = fence;
 *     }
 *
 *     public void forEachRemaining(Consumer<? super T> action) {
 *       for (; origin < fence; origin += 2)
 *         action.accept((T) array[origin]);
 *     }
 *
 *     public boolean tryAdvance(Consumer<? super T> action) {
 *       if (origin < fence) {
 *         action.accept((T) array[origin]);
 *         origin += 2;
 *         return true;
 *       }
 *       else // cannot advance
 *         return false;
 *     }
 *
 *     public Spliterator<T> trySplit() {
 *       int lo = origin; // divide range in half
 *       int mid = ((lo + fence) >>> 1) & ~1; // force midpoint to be even
 *       if (lo < mid) { // split out left half
 *         origin = mid; // reset this Spliterator's origin
 *         return new TaggedArraySpliterator<>(array, lo, mid);
 *       }
 *       else       // too small to split
 *         return null;
 *     }
 *
 *     public long estimateSize() {
 *       return (long)((fence - origin) / 2);
 *     }
 *
 *     public int characteristics() {
 *       return ORDERED | SIZED | IMMUTABLE | SUBSIZED;
 *     }
 *   }
 * }}</pre>
 *
 * <p>As an example how a parallel computation framework, such as the
 * {@code java.util.stream} package, would use Spliterator in a parallel
 * computation, here is one way to implement an associated parallel forEach,
 * that illustrates the primary usage idiom of splitting off subtasks until
 * the estimated amount of work is small enough to perform
 * sequentially. Here we assume that the order of processing across
 * subtasks doesn't matter; different (forked) tasks may further split
 * and process elements concurrently in undetermined order.  This
 * example uses a {@link java.util.concurrent.CountedCompleter};
 * similar usages apply to other parallel task constructions.
 *
 * <pre>{@code
 * static <T> void parEach(TaggedArray<T> a, Consumer<T> action) {
 *   Spliterator<T> s = a.spliterator();
 *   long targetBatchSize = s.estimateSize() / (ForkJoinPool.getCommonPoolParallelism() * 8);
 *   new ParEach(null, s, action, targetBatchSize).invoke();
 * }
 *
 * static class ParEach<T> extends CountedCompleter<Void> {
 *   final Spliterator<T> spliterator;
 *   final Consumer<T> action;
 *   final long targetBatchSize;
 *
 *   ParEach(ParEach<T> parent, Spliterator<T> spliterator,
 *           Consumer<T> action, long targetBatchSize) {
 *     super(parent);
 *     this.spliterator = spliterator; this.action = action;
 *     this.targetBatchSize = targetBatchSize;
 *   }
 *
 *   public void compute() {
 *     Spliterator<T> sub;
 *     while (spliterator.estimateSize() > targetBatchSize &&
 *            (sub = spliterator.trySplit()) != null) {
 *       addToPendingCount(1);
 *       new ParEach<>(this, sub, action, targetBatchSize).fork();
 *     }
 *     spliterator.forEachRemaining(action);
 *     propagateCompletion();
 *   }
 * }}</pre>
 *
 * @implNote
 * If the boolean system property {@code org.openjdk.java.util.stream.tripwire}
 * is set to {@code true} then diagnostic warnings are reported if boxing of
 * primitive values occur when operating on primitive subtype specializations.
 *
 * @param <T> the type of elements returned by this Spliterator
 *
 * @see java.util.Collection
 * @since 1.8
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public interface Spliterator<T> {

/**
 * If a remaining element exists, performs the given action on it,
 * returning {@code true}; else returns {@code false}.  If this
 * Spliterator is {@link #ORDERED} the action is performed on the
 * next element in encounter order.  Exceptions thrown by the
 * action are relayed to the caller.
 *
 * @param action The action
 * @return {@code false} if no remaining elements existed
 * upon entry to this method, else {@code true}.
 * @throws java.lang.NullPointerException if the specified action is null
 * @apiSince 24
 */

public boolean tryAdvance(java.util.function.Consumer<? super T> action);

/**
 * Performs the given action for each remaining element, sequentially in
 * the current thread, until all elements have been processed or the action
 * throws an exception.  If this Spliterator is {@link #ORDERED}, actions
 * are performed in encounter order.  Exceptions thrown by the action
 * are relayed to the caller.
 *
 * @implSpec
 * The default implementation repeatedly invokes {@link #tryAdvance} until
 * it returns {@code false}.  It should be overridden whenever possible.
 *
 * @param action The action
 * @throws java.lang.NullPointerException if the specified action is null
 * @apiSince 24
 */

public default void forEachRemaining(java.util.function.Consumer<? super T> action) { throw new RuntimeException("Stub!"); }

/**
 * If this spliterator can be partitioned, returns a Spliterator
 * covering elements, that will, upon return from this method, not
 * be covered by this Spliterator.
 *
 * <p>If this Spliterator is {@link #ORDERED}, the returned Spliterator
 * must cover a strict prefix of the elements.
 *
 * <p>Unless this Spliterator covers an infinite number of elements,
 * repeated calls to {@code trySplit()} must eventually return {@code null}.
 * Upon non-null return:
 * <ul>
 * <li>the value reported for {@code estimateSize()} before splitting,
 * must, after splitting, be greater than or equal to {@code estimateSize()}
 * for this and the returned Spliterator; and</li>
 * <li>if this Spliterator is {@code SUBSIZED}, then {@code estimateSize()}
 * for this spliterator before splitting must be equal to the sum of
 * {@code estimateSize()} for this and the returned Spliterator after
 * splitting.</li>
 * </ul>
 *
 * <p>This method may return {@code null} for any reason,
 * including emptiness, inability to split after traversal has
 * commenced, data structure constraints, and efficiency
 * considerations.
 *
 * @apiNote
 * An ideal {@code trySplit} method efficiently (without
 * traversal) divides its elements exactly in half, allowing
 * balanced parallel computation.  Many departures from this ideal
 * remain highly effective; for example, only approximately
 * splitting an approximately balanced tree, or for a tree in
 * which leaf nodes may contain either one or two elements,
 * failing to further split these nodes.  However, large
 * deviations in balance and/or overly inefficient {@code
 * trySplit} mechanics typically result in poor parallel
 * performance.
 *
 * @return a {@code Spliterator} covering some portion of the
 * elements, or {@code null} if this spliterator cannot be split
 * @apiSince 24
 */

public java.util.Spliterator<T> trySplit();

/**
 * Returns an estimate of the number of elements that would be
 * encountered by a {@link #forEachRemaining} traversal, or returns {@link java.lang.Long#MAX_VALUE Long#MAX_VALUE} if infinite, unknown, or too expensive to compute.
 *
 * <p>If this Spliterator is {@link #SIZED} and has not yet been partially
 * traversed or split, or this Spliterator is {@link #SUBSIZED} and has
 * not yet been partially traversed, this estimate must be an accurate
 * count of elements that would be encountered by a complete traversal.
 * Otherwise, this estimate may be arbitrarily inaccurate, but must decrease
 * as specified across invocations of {@link #trySplit}.
 *
 * @apiNote
 * Even an inexact estimate is often useful and inexpensive to compute.
 * For example, a sub-spliterator of an approximately balanced binary tree
 * may return a value that estimates the number of elements to be half of
 * that of its parent; if the root Spliterator does not maintain an
 * accurate count, it could estimate size to be the power of two
 * corresponding to its maximum depth.
 *
 * @return the estimated size, or {@code Long.MAX_VALUE} if infinite,
 *         unknown, or too expensive to compute.
 * @apiSince 24
 */

public long estimateSize();

/**
 * Convenience method that returns {@link #estimateSize()} if this
 * Spliterator is {@link #SIZED}, else {@code -1}.
 * @implSpec
 * The default implementation returns the result of {@code estimateSize()}
 * if the Spliterator reports a characteristic of {@code SIZED}, and
 * {@code -1} otherwise.
 *
 * @return the exact size, if known, else {@code -1}.
 * @apiSince 24
 */

public default long getExactSizeIfKnown() { throw new RuntimeException("Stub!"); }

/**
 * Returns a set of characteristics of this Spliterator and its
 * elements. The result is represented as ORed values from {@link
 * #ORDERED}, {@link #DISTINCT}, {@link #SORTED}, {@link #SIZED},
 * {@link #NONNULL}, {@link #IMMUTABLE}, {@link #CONCURRENT},
 * {@link #SUBSIZED}.  Repeated calls to {@code characteristics()} on
 * a given spliterator, prior to or in-between calls to {@code trySplit},
 * should always return the same result.
 *
 * <p>If a Spliterator reports an inconsistent set of
 * characteristics (either those returned from a single invocation
 * or across multiple invocations), no guarantees can be made
 * about any computation using this Spliterator.
 *
 * @apiNote The characteristics of a given spliterator before splitting
 * may differ from the characteristics after splitting.  For specific
 * examples see the characteristic values {@link #SIZED}, {@link #SUBSIZED}
 * and {@link #CONCURRENT}.
 *
 * @return a representation of characteristics
 * @apiSince 24
 */

public int characteristics();

/**
 * Returns {@code true} if this Spliterator's {@link
 * #characteristics} contain all of the given characteristics.
 *
 * @implSpec
 * The default implementation returns true if the corresponding bits
 * of the given characteristics are set.
 *
 * @param characteristics the characteristics to check for
 * @return {@code true} if all the specified characteristics are present,
 * else {@code false}
 * @apiSince 24
 */

public default boolean hasCharacteristics(int characteristics) { throw new RuntimeException("Stub!"); }

/**
 * If this Spliterator's source is {@link #SORTED} by a {@link java.util.Comparator Comparator},
 * returns that {@code Comparator}. If the source is {@code SORTED} in
 * {@linkplain java.lang.Comparable Comparable}, returns {@code null}.  Otherwise,
 * if the source is not {@code SORTED}, throws {@link java.lang.IllegalStateException IllegalStateException}.
 *
 * @implSpec
 * The default implementation always throws {@link java.lang.IllegalStateException IllegalStateException}.
 *
 * @return a Comparator, or {@code null} if the elements are sorted in the
 * natural order.
 * @throws java.lang.IllegalStateException if the spliterator does not report
 *         a characteristic of {@code SORTED}.
 * @apiSince 24
 */

public default java.util.Comparator<? super T> getComparator() { throw new RuntimeException("Stub!"); }

/**
 * Characteristic value signifying that the element source may be safely
 * concurrently modified (allowing additions, replacements, and/or removals)
 * by multiple threads without external synchronization. If so, the
 * Spliterator is expected to have a documented policy concerning the impact
 * of modifications during traversal.
 *
 * <p>A top-level Spliterator should not report both {@code CONCURRENT} and
 * {@code SIZED}, since the finite size, if known, may change if the source
 * is concurrently modified during traversal. Such a Spliterator is
 * inconsistent and no guarantees can be made about any computation using
 * that Spliterator. Sub-spliterators may report {@code SIZED} if the
 * sub-split size is known and additions or removals to the source are not
 * reflected when traversing.
 *
 * @apiNote Most concurrent collections maintain a consistency policy
 * guaranteeing accuracy with respect to elements present at the point of
 * Spliterator construction, but possibly not reflecting subsequent
 * additions or removals.
 * @apiSince 24
 */

public static final int CONCURRENT = 4096; // 0x1000

/**
 * Characteristic value signifying that, for each pair of
 * encountered elements {@code x, y}, {@code !x.equals(y)}. This
 * applies for example, to a Spliterator based on a {@link java.util.Set Set}.
 * @apiSince 24
 */

public static final int DISTINCT = 1; // 0x1

/**
 * Characteristic value signifying that the element source cannot be
 * structurally modified; that is, elements cannot be added, replaced, or
 * removed, so such changes cannot occur during traversal. A Spliterator
 * that does not report {@code IMMUTABLE} or {@code CONCURRENT} is expected
 * to have a documented policy (for example throwing
 * {@link java.util.ConcurrentModificationException ConcurrentModificationException}) concerning structural
 * interference detected during traversal.
 * @apiSince 24
 */

public static final int IMMUTABLE = 1024; // 0x400

/**
 * Characteristic value signifying that the source guarantees that
 * encountered elements will not be {@code null}. (This applies,
 * for example, to most concurrent collections, queues, and maps.)
 * @apiSince 24
 */

public static final int NONNULL = 256; // 0x100

/**
 * Characteristic value signifying that an encounter order is defined for
 * elements. If so, this Spliterator guarantees that method
 * {@link #trySplit} splits a strict prefix of elements, that method
 * {@link #tryAdvance} steps by one element in prefix order, and that
 * {@link #forEachRemaining} performs actions in encounter order.
 *
 * <p>A {@link java.util.Collection Collection} has an encounter order if the corresponding
 * {@link java.util.Collection#iterator Collection#iterator} documents an order. If so, the encounter
 * order is the same as the documented order. Otherwise, a collection does
 * not have an encounter order.
 *
 * @apiNote Encounter order is guaranteed to be ascending index order for
 * any {@link java.util.List List}. But no order is guaranteed for hash-based collections
 * such as {@link java.util.HashSet HashSet}. Clients of a Spliterator that reports
 * {@code ORDERED} are expected to preserve ordering constraints in
 * non-commutative parallel computations.
 * @apiSince 24
 */

public static final int ORDERED = 16; // 0x10

/**
 * Characteristic value signifying that the value returned from
 * {@code estimateSize()} prior to traversal or splitting represents a
 * finite size that, in the absence of structural source modification,
 * represents an exact count of the number of elements that would be
 * encountered by a complete traversal.
 *
 * @apiNote Most Spliterators for Collections, that cover all elements of a
 * {@code Collection} report this characteristic. Sub-spliterators, such as
 * those for {@link java.util.HashSet HashSet}, that cover a sub-set of elements and
 * approximate their reported size do not.
 * @apiSince 24
 */

public static final int SIZED = 64; // 0x40

/**
 * Characteristic value signifying that encounter order follows a defined
 * sort order. If so, method {@link #getComparator()} returns the associated
 * Comparator, or {@code null} if all elements are {@link java.lang.Comparable Comparable} and
 * are sorted by their natural ordering.
 *
 * <p>A Spliterator that reports {@code SORTED} must also report
 * {@code ORDERED}.
 *
 * @apiNote The spliterators for {@code Collection} classes in the JDK that
 * implement {@link java.util.NavigableSet NavigableSet} or {@link java.util.SortedSet SortedSet} report {@code SORTED}.
 * @apiSince 24
 */

public static final int SORTED = 4; // 0x4

/**
 * Characteristic value signifying that all Spliterators resulting from
 * {@code trySplit()} will be both {@link #SIZED} and {@link #SUBSIZED}.
 * (This means that all child Spliterators, whether direct or indirect, will
 * be {@code SIZED}.)
 *
 * <p>A Spliterator that does not report {@code SIZED} as required by
 * {@code SUBSIZED} is inconsistent and no guarantees can be made about any
 * computation using that Spliterator.
 *
 * @apiNote Some spliterators, such as the top-level spliterator for an
 * approximately balanced binary tree, will report {@code SIZED} but not
 * {@code SUBSIZED}, since it is common to know the size of the entire tree
 * but not the exact sizes of subtrees.
 * @apiSince 24
 */

public static final int SUBSIZED = 16384; // 0x4000
/**
 * A Spliterator specialized for {@code double} values.
 * @since 1.8
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OfDouble extends java.util.Spliterator.OfPrimitive<java.lang.Double,java.util.function.DoubleConsumer,java.util.Spliterator.OfDouble> {

/** @apiSince 24 */

public java.util.Spliterator.OfDouble trySplit();

/** @apiSince 24 */

public boolean tryAdvance(java.util.function.DoubleConsumer action);

/** @apiSince 24 */

public default void forEachRemaining(java.util.function.DoubleConsumer action) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @implSpec
 * If the action is an instance of {@code DoubleConsumer} then it is
 * cast to {@code DoubleConsumer} and passed to
 * {@link #tryAdvance(java.util.function.DoubleConsumer)}; otherwise
 * the action is adapted to an instance of {@code DoubleConsumer}, by
 * boxing the argument of {@code DoubleConsumer}, and then passed to
 * {@link #tryAdvance(java.util.function.DoubleConsumer)}.
 * @apiSince 24
 */

public default boolean tryAdvance(java.util.function.Consumer<? super java.lang.Double> action) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @implSpec
 * If the action is an instance of {@code DoubleConsumer} then it is
 * cast to {@code DoubleConsumer} and passed to
 * {@link #forEachRemaining(java.util.function.DoubleConsumer)};
 * otherwise the action is adapted to an instance of
 * {@code DoubleConsumer}, by boxing the argument of
 * {@code DoubleConsumer}, and then passed to
 * {@link #forEachRemaining(java.util.function.DoubleConsumer)}.
 * @apiSince 24
 */

public default void forEachRemaining(java.util.function.Consumer<? super java.lang.Double> action) { throw new RuntimeException("Stub!"); }
}

/**
 * A Spliterator specialized for {@code int} values.
 * @since 1.8
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OfInt extends java.util.Spliterator.OfPrimitive<java.lang.Integer,java.util.function.IntConsumer,java.util.Spliterator.OfInt> {

/** @apiSince 24 */

public java.util.Spliterator.OfInt trySplit();

/** @apiSince 24 */

public boolean tryAdvance(java.util.function.IntConsumer action);

/** @apiSince 24 */

public default void forEachRemaining(java.util.function.IntConsumer action) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @implSpec
 * If the action is an instance of {@code IntConsumer} then it is cast
 * to {@code IntConsumer} and passed to
 * {@link #tryAdvance(java.util.function.IntConsumer)}; otherwise
 * the action is adapted to an instance of {@code IntConsumer}, by
 * boxing the argument of {@code IntConsumer}, and then passed to
 * {@link #tryAdvance(java.util.function.IntConsumer)}.
 * @apiSince 24
 */

public default boolean tryAdvance(java.util.function.Consumer<? super java.lang.Integer> action) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @implSpec
 * If the action is an instance of {@code IntConsumer} then it is cast
 * to {@code IntConsumer} and passed to
 * {@link #forEachRemaining(java.util.function.IntConsumer)}; otherwise
 * the action is adapted to an instance of {@code IntConsumer}, by
 * boxing the argument of {@code IntConsumer}, and then passed to
 * {@link #forEachRemaining(java.util.function.IntConsumer)}.
 * @apiSince 24
 */

public default void forEachRemaining(java.util.function.Consumer<? super java.lang.Integer> action) { throw new RuntimeException("Stub!"); }
}

/**
 * A Spliterator specialized for {@code long} values.
 * @since 1.8
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OfLong extends java.util.Spliterator.OfPrimitive<java.lang.Long,java.util.function.LongConsumer,java.util.Spliterator.OfLong> {

/** @apiSince 24 */

public java.util.Spliterator.OfLong trySplit();

/** @apiSince 24 */

public boolean tryAdvance(java.util.function.LongConsumer action);

/** @apiSince 24 */

public default void forEachRemaining(java.util.function.LongConsumer action) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @implSpec
 * If the action is an instance of {@code LongConsumer} then it is cast
 * to {@code LongConsumer} and passed to
 * {@link #tryAdvance(java.util.function.LongConsumer)}; otherwise
 * the action is adapted to an instance of {@code LongConsumer}, by
 * boxing the argument of {@code LongConsumer}, and then passed to
 * {@link #tryAdvance(java.util.function.LongConsumer)}.
 * @apiSince 24
 */

public default boolean tryAdvance(java.util.function.Consumer<? super java.lang.Long> action) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @implSpec
 * If the action is an instance of {@code LongConsumer} then it is cast
 * to {@code LongConsumer} and passed to
 * {@link #forEachRemaining(java.util.function.LongConsumer)}; otherwise
 * the action is adapted to an instance of {@code LongConsumer}, by
 * boxing the argument of {@code LongConsumer}, and then passed to
 * {@link #forEachRemaining(java.util.function.LongConsumer)}.
 * @apiSince 24
 */

public default void forEachRemaining(java.util.function.Consumer<? super java.lang.Long> action) { throw new RuntimeException("Stub!"); }
}

/**
 * A Spliterator specialized for primitive values.
 *
 * @param <T> the type of elements returned by this Spliterator.  The
 * type must be a wrapper type for a primitive type, such as {@code Integer}
 * for the primitive {@code int} type.
 * @param <T_CONS> the type of primitive consumer.  The type must be a
 * primitive specialization of {@link java.util.function.Consumer} for
 * {@code T}, such as {@link java.util.function.IntConsumer} for
 * {@code Integer}.
 * @param <T_SPLITR> the type of primitive Spliterator.  The type must be
 * a primitive specialization of Spliterator for {@code T}, such as
 * {@link java.util.Spliterator.OfInt Spliterator.OfInt} for {@code Integer}.
 *
 * @see java.util.Spliterator.OfInt
 * @see java.util.Spliterator.OfLong
 * @see java.util.Spliterator.OfDouble
 * @since 1.8
 * @apiSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OfPrimitive<T, T_CONS, T_SPLITR extends java.util.Spliterator.OfPrimitive<T, T_CONS, T_SPLITR>> extends java.util.Spliterator<T> {

/** @apiSince 24 */

public T_SPLITR trySplit();

/**
 * If a remaining element exists, performs the given action on it,
 * returning {@code true}; else returns {@code false}.  If this
 * Spliterator is {@link #ORDERED} the action is performed on the
 * next element in encounter order.  Exceptions thrown by the
 * action are relayed to the caller.
 *
 * @param action The action
 * @return {@code false} if no remaining elements existed
 * upon entry to this method, else {@code true}.
 * @throws java.lang.NullPointerException if the specified action is null
 * @apiSince 24
 */

public boolean tryAdvance(T_CONS action);

/**
 * Performs the given action for each remaining element, sequentially in
 * the current thread, until all elements have been processed or the
 * action throws an exception.  If this Spliterator is {@link #ORDERED},
 * actions are performed in encounter order.  Exceptions thrown by the
 * action are relayed to the caller.
 *
 * @implSpec
 * The default implementation repeatedly invokes {@link #tryAdvance}
 * until it returns {@code false}.  It should be overridden whenever
 * possible.
 *
 * @param action The action
 * @throws java.lang.NullPointerException if the specified action is null
 * @apiSince 24
 */

public default void forEachRemaining(T_CONS action) { throw new RuntimeException("Stub!"); }
}

}

