/**
 * <p>Contains classes for accessing and publishing data on a device.  It includes three main
 * categories of APIs:</p>
 *
 * <ul>
 *   <dt>Content sharing ({@link android.content})</dt>
 *   <dd>For sharing content between application components. The most important classes are:
 *     <ul>
 *       <li>{@link android.content.ContentProvider} and {@link android.content.ContentResolver}
 *   for managing and publishing persistent data associated with an application.</li>
 *       <li>{@link android.content.Intent} and {@link android.content.IntentFilter}, for delivering
 *   structured messages between different application components&mdash;allowing components to initiate
 *   other components and return results.</li>
 *     </ul>
 *   </dd>
 *
 *   <dt>Package management ({@link android.content.pm})</dt>
 *   <dd>For accessing information about an Android package (an {@code .apk}), including information
 * about its activities, permissions, services, signatures, and providers. The most important class for
 * accessing this information is {@link android.content.pm.PackageManager}.</dd>
 *
 *   <dt>Resource management ({@link android.content.res})</dt>
 *   <dd>For retrieving resource data associated with an application, such as strings, drawables,
 * media, and device configuration details. The most important class for accessing this data is {@link
 * android.content.res.Resources}.</dd>
 * </ul>
 @apiSince 1
 */

package android.content;
