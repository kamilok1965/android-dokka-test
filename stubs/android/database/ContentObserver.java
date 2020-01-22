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


package android.database;

import android.net.Uri;
import android.os.Handler;

/**
 * Receives call backs for changes to content.
 * Must be implemented by objects which are added to a {@link android.database.ContentObservable ContentObservable}.
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class ContentObserver {

/**
 * Creates a content observer.
 *
 * @param handler The handler to run {@link #onChange} on, or null if none.
 * @apiSince 1
 */

public ContentObserver(android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Returns true if this observer is interested receiving self-change notifications.
 *
 * Subclasses should override this method to indicate whether the observer
 * is interested in receiving notifications for changes that it made to the
 * content itself.
 *
 * @return True if self-change notifications should be delivered to the observer.
 * @apiSince 1
 */

public boolean deliverSelfNotifications() { throw new RuntimeException("Stub!"); }

/**
 * This method is called when a content change occurs.
 * <p>
 * Subclasses should override this method to handle content changes.
 * </p>
 *
 * @param selfChange True if this is a self-change notification.
 * @apiSince 1
 */

public void onChange(boolean selfChange) { throw new RuntimeException("Stub!"); }

/**
 * This method is called when a content change occurs.
 * Includes the changed content Uri when available.
 * <p>
 * Subclasses should override this method to handle content changes.
 * To ensure correct operation on older versions of the framework that
 * did not provide a Uri argument, applications should also implement
 * the {@link #onChange(boolean)} overload of this method whenever they
 * implement the {@link #onChange(boolean,android.net.Uri)} overload.
 * </p><p>
 * Example implementation:
 * <pre><code>
 * // Implement the onChange(boolean) method to delegate the change notification to
 * // the onChange(boolean, Uri) method to ensure correct operation on older versions
 * // of the framework that did not have the onChange(boolean, Uri) method.
 * {@literal @Override}
 * public void onChange(boolean selfChange) {
 *     onChange(selfChange, null);
 * }
 *
 * // Implement the onChange(boolean, Uri) method to take advantage of the new Uri argument.
 * {@literal @Override}
 * public void onChange(boolean selfChange, Uri uri) {
 *     // Handle change.
 * }
 * </code></pre>
 * </p>
 *
 * @param selfChange True if this is a self-change notification.
 * @param uri The Uri of the changed content, or null if unknown.
 * @apiSince 16
 */

public void onChange(boolean selfChange, android.net.Uri uri) { throw new RuntimeException("Stub!"); }

/**
 * Dispatches a change notification to the observer.
 * <p>
 * If a {@link android.os.Handler Handler} was supplied to the {@link android.database.ContentObserver ContentObserver} constructor,
 * then a call to the {@link #onChange} method is posted to the handler's message queue.
 * Otherwise, the {@link #onChange} method is invoked immediately on this thread.
 * </p>
 *
 * @param selfChange True if this is a self-change notification.
 *
 * @deprecated Use {@link #dispatchChange(boolean,android.net.Uri)} instead.
 * @apiSince 1
 * @deprecatedSince 16
 */

@Deprecated
public final void dispatchChange(boolean selfChange) { throw new RuntimeException("Stub!"); }

/**
 * Dispatches a change notification to the observer.
 * Includes the changed content Uri when available.
 * <p>
 * If a {@link android.os.Handler Handler} was supplied to the {@link android.database.ContentObserver ContentObserver} constructor,
 * then a call to the {@link #onChange} method is posted to the handler's message queue.
 * Otherwise, the {@link #onChange} method is invoked immediately on this thread.
 * </p>
 *
 * @param selfChange True if this is a self-change notification.
 * @param uri The Uri of the changed content, or null if unknown.
 * @apiSince 16
 */

public final void dispatchChange(boolean selfChange, android.net.Uri uri) { throw new RuntimeException("Stub!"); }
}

