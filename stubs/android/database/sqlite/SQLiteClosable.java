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


package android.database.sqlite;


/**
 * An object created from a SQLiteDatabase that can be closed.
 *
 * This class implements a primitive reference counting scheme for database objects.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class SQLiteClosable implements java.io.Closeable {

public SQLiteClosable() { throw new RuntimeException("Stub!"); }

/**
 * Called when the last reference to the object was released by
 * a call to {@link #releaseReference()} or {@link #close()}.
 * @apiSince 1
 */

protected abstract void onAllReferencesReleased();

/**
 * Called when the last reference to the object was released by
 * a call to {@link #releaseReferenceFromContainer()}.
 *
 * @deprecated Do not use.
 * @apiSince 1
 * @deprecatedSince 16
 */

@Deprecated
protected void onAllReferencesReleasedFromContainer() { throw new RuntimeException("Stub!"); }

/**
 * Acquires a reference to the object.
 *
 * @throws java.lang.IllegalStateException if the last reference to the object has already
 * been released.
 * @apiSince 1
 */

public void acquireReference() { throw new RuntimeException("Stub!"); }

/**
 * Releases a reference to the object, closing the object if the last reference
 * was released.
 *
 * @see #onAllReferencesReleased()
 * @apiSince 1
 */

public void releaseReference() { throw new RuntimeException("Stub!"); }

/**
 * Releases a reference to the object that was owned by the container of the object,
 * closing the object if the last reference was released.
 *
 * @see #onAllReferencesReleasedFromContainer()
 * @deprecated Do not use.
 * @apiSince 1
 * @deprecatedSince 16
 */

@Deprecated
public void releaseReferenceFromContainer() { throw new RuntimeException("Stub!"); }

/**
 * Releases a reference to the object, closing the object if the last reference
 * was released.
 *
 * Calling this method is equivalent to calling {@link #releaseReference}.
 *
 * @see #releaseReference()
 * @see #onAllReferencesReleased()
 * @apiSince 16
 */

public void close() { throw new RuntimeException("Stub!"); }
}

