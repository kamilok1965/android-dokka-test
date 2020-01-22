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


package android.graphics;

import android.os.Parcelable;

/**
 * Point holds two integer coordinates
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Point implements android.os.Parcelable {

/** @apiSince 1 */

public Point() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public Point(int x, int y) { throw new RuntimeException("Stub!"); }

/**
 * @param src This value must never be {@code null}.
 * @apiSince 1
 */

public Point(@androidx.annotation.NonNull android.graphics.Point src) { throw new RuntimeException("Stub!"); }

/**
 * Set the point's x and y coordinates
 * @apiSince 1
 */

public void set(int x, int y) { throw new RuntimeException("Stub!"); }

/**
 * Negate the point's coordinates
 * @apiSince 1
 */

public final void negate() { throw new RuntimeException("Stub!"); }

/**
 * Offset the point's coordinates by dx, dy
 * @apiSince 1
 */

public final void offset(int dx, int dy) { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the point's coordinates equal (x,y)
 * @apiSince 1
 */

public final boolean equals(int x, int y) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 1 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Parcelable interface methods
 * @apiSince 13
 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * Write this point to the specified parcel. To restore a point from
 * a parcel, use readFromParcel()
 * @param out The parcel to write the point's coordinates into
 * @apiSince 13
 */

public void writeToParcel(android.os.Parcel out, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Set the point's coordinates from the data stored in the specified
 * parcel. To write a point to a parcel, call writeToParcel().
 *
 * @param in The parcel to read the point's coordinates from
 
 * This value must never be {@code null}.
 * @apiSince 13
 */

public void readFromParcel(@androidx.annotation.NonNull android.os.Parcel in) { throw new RuntimeException("Stub!"); }

/** @apiSince 13 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.graphics.Point> CREATOR;
static { CREATOR = null; }

/** @apiSince 1 */

public int x;

/** @apiSince 1 */

public int y;
}

