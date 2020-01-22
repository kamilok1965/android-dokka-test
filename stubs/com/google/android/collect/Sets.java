/*
 * Copyright (C) 2007 The Android Open Source Project
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


package com.google.android.collect;

import java.util.EnumSet;
import java.util.Collections;
import java.util.HashSet;
import java.util.SortedSet;
import android.util.ArraySet;

/**
 * Provides static methods for creating mutable {@code Set} instances easily and
 * other static methods for working with Sets.
 *
 * @apiSince R
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Sets {

public Sets() { throw new RuntimeException("Stub!"); }

/**
 * Creates an empty {@code HashSet} instance.
 *
 * <p><b>Note:</b> if {@code E} is an {@link java.lang.Enum Enum} type, use {@link java.util.EnumSet#noneOf EnumSet#noneOf} instead.
 *
 * <p><b>Note:</b> if you only need an <i>immutable</i> empty Set,
 * use {@link java.util.Collections#emptySet Collections#emptySet} instead.
 *
 * @return a newly-created, initially-empty {@code HashSet}
 * @apiSince R
 */

public static <K> java.util.HashSet<K> newHashSet() { throw new RuntimeException("Stub!"); }

/**
 * Creates a {@code HashSet} instance containing the given elements.
 *
 * <p><b>Note:</b> due to a bug in javac 1.5.0_06, we cannot support the
 * following:
 *
 * <p>{@code Set<Base> set = Sets.newHashSet(sub1, sub2);}
 *
 * <p>where {@code sub1} and {@code sub2} are references to subtypes of {@code
 * Base}, not of {@code Base} itself. To get around this, you must use:
 *
 * <p>{@code Set<Base> set = Sets.<Base>newHashSet(sub1, sub2);}
 *
 * @param elements the elements that the set should contain
 * @return a newly-created {@code HashSet} containing those elements (minus
 *     duplicates)
 * @apiSince R
 */

public static <E> java.util.HashSet<E> newHashSet(E... elements) { throw new RuntimeException("Stub!"); }

/**
 * Creates an empty {@code SortedSet} instance.
 *
 * @return a newly-created, initially-empty {@code SortedSet}.
 * @apiSince R
 */

public static <E> java.util.SortedSet<E> newSortedSet() { throw new RuntimeException("Stub!"); }

/**
 * Creates a {@code SortedSet} instance containing the given elements.
 *
 * @param elements the elements that the set should contain
 * @return a newly-created {@code SortedSet} containing those elements (minus
 *     duplicates)
 * @apiSince R
 */

public static <E> java.util.SortedSet<E> newSortedSet(E... elements) { throw new RuntimeException("Stub!"); }

/**
 * Creates a {@code ArraySet} instance.
 * @apiSince R
 */

public static <E> android.util.ArraySet<E> newArraySet() { throw new RuntimeException("Stub!"); }

/**
 * Creates a {@code ArraySet} instance containing the given elements.
 * @apiSince R
 */

public static <E> android.util.ArraySet<E> newArraySet(E... elements) { throw new RuntimeException("Stub!"); }
}

