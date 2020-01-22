/*
 * Copyright (C) 2009 The Android Open Source Project
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


package android.accessibilityservice;

import android.view.accessibility.AccessibilityEvent;
import android.content.pm.ResolveInfo;
import android.content.pm.PackageManager;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.os.Parcelable;

/**
 * This class describes an {@link android.accessibilityservice.AccessibilityService AccessibilityService}. The system notifies an
 * {@link android.accessibilityservice.AccessibilityService AccessibilityService} for {@link android.view.accessibility.AccessibilityEvent}s
 * according to the information encapsulated in this class.
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For more information about creating AccessibilityServices, read the
 * <a href="{@docRoot}guide/topics/ui/accessibility/index.html">Accessibility</a>
 * developer guide.</p>
 * </div>
 *
 * @attr ref android.R.styleable#AccessibilityService_accessibilityEventTypes
 * @attr ref android.R.styleable#AccessibilityService_accessibilityFeedbackType
 * @attr ref android.R.styleable#AccessibilityService_accessibilityFlags
 * @attr ref android.R.styleable#AccessibilityService_canRequestEnhancedWebAccessibility
 * @attr ref android.R.styleable#AccessibilityService_canRequestFilterKeyEvents
 * @attr ref android.R.styleable#AccessibilityService_canRequestTouchExplorationMode
 * @attr ref android.R.styleable#AccessibilityService_canRetrieveWindowContent
 * @attr ref android.R.styleable#AccessibilityService_description
 * @attr ref android.R.styleable#AccessibilityService_summary
 * @attr ref android.R.styleable#AccessibilityService_notificationTimeout
 * @attr ref android.R.styleable#AccessibilityService_packageNames
 * @attr ref android.R.styleable#AccessibilityService_settingsActivity
 * @attr ref android.R.styleable#AccessibilityService_nonInteractiveUiTimeout
 * @attr ref android.R.styleable#AccessibilityService_interactiveUiTimeout
 * @see android.accessibilityservice.AccessibilityService
 * @see android.view.accessibility.AccessibilityEvent
 * @see android.view.accessibility.AccessibilityManager
 * @apiSince 4
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class AccessibilityServiceInfo implements android.os.Parcelable {

/**
 * Creates a new instance.
 * @apiSince 4
 */

public AccessibilityServiceInfo() { throw new RuntimeException("Stub!"); }

/**
 * The accessibility service id.
 * <p>
 *   <strong>Generated by the system.</strong>
 * </p>
 * @return The id.
 * @apiSince 14
 */

public java.lang.String getId() { throw new RuntimeException("Stub!"); }

/**
 * The service {@link android.content.pm.ResolveInfo ResolveInfo}.
 * <p>
 *   <strong>Generated by the system.</strong>
 * </p>
 * @return The info.
 * @apiSince 14
 */

public android.content.pm.ResolveInfo getResolveInfo() { throw new RuntimeException("Stub!"); }

/**
 * The settings activity name.
 * <p>
 *    <strong>Statically set from
 *    {@link android.accessibilityservice.AccessibilityService#SERVICE_META_DATA AccessibilityService#SERVICE_META_DATA}.</strong>
 * </p>
 * @return The settings activity name.
 * @apiSince 14
 */

public java.lang.String getSettingsActivityName() { throw new RuntimeException("Stub!"); }

/**
 * Whether this service can retrieve the current window's content.
 * <p>
 *    <strong>Statically set from
 *    {@link android.accessibilityservice.AccessibilityService#SERVICE_META_DATA AccessibilityService#SERVICE_META_DATA}.</strong>
 * </p>
 * @return True if window content can be retrieved.
 *
 * @deprecated Use {@link #getCapabilities()}.
 * @apiSince 14
 * @deprecatedSince 18
 */

@Deprecated
public boolean getCanRetrieveWindowContent() { throw new RuntimeException("Stub!"); }

/**
 * Returns the bit mask of capabilities this accessibility service has such as
 * being able to retrieve the active window content, etc.
 *
 * @return The capability bit mask.
 *
 * @see #CAPABILITY_CAN_RETRIEVE_WINDOW_CONTENT
 * @see #CAPABILITY_CAN_REQUEST_TOUCH_EXPLORATION
 * @see #CAPABILITY_CAN_REQUEST_FILTER_KEY_EVENTS
 * @see #CAPABILITY_CAN_CONTROL_MAGNIFICATION
 * @see #CAPABILITY_CAN_PERFORM_GESTURES
 * @apiSince 18
 */

public int getCapabilities() { throw new RuntimeException("Stub!"); }

/**
 * The localized summary of the accessibility service.
 * <p>
 *    <strong>Statically set from
 *    {@link android.accessibilityservice.AccessibilityService#SERVICE_META_DATA AccessibilityService#SERVICE_META_DATA}.</strong>
 * </p>
 * @return The localized summary if available, and {@code null} if a summary
 * has not been provided.
 * @apiSince 26
 */

public java.lang.CharSequence loadSummary(android.content.pm.PackageManager packageManager) { throw new RuntimeException("Stub!"); }

/**
 * Gets the non-localized description of the accessibility service.
 * <p>
 *    <strong>Statically set from
 *    {@link android.accessibilityservice.AccessibilityService#SERVICE_META_DATA AccessibilityService#SERVICE_META_DATA}.</strong>
 * </p>
 * @return The description.
 *
 * @deprecated Use {@link #loadDescription(android.content.pm.PackageManager)}.
 * @apiSince 14
 * @deprecatedSince 16
 */

@Deprecated
public java.lang.String getDescription() { throw new RuntimeException("Stub!"); }

/**
 * The localized description of the accessibility service.
 * <p>
 *    <strong>Statically set from
 *    {@link android.accessibilityservice.AccessibilityService#SERVICE_META_DATA AccessibilityService#SERVICE_META_DATA}.</strong>
 * </p>
 * @return The localized description.
 * @apiSince 16
 */

public java.lang.String loadDescription(android.content.pm.PackageManager packageManager) { throw new RuntimeException("Stub!"); }

/**
 * Set the recommended time that non-interactive controls need to remain on the screen to
 * support the user.
 * <p>
 *     <strong>This value can be dynamically set at runtime by
 *     {@link android.accessibilityservice.AccessibilityService#setServiceInfo(android.accessibilityservice.AccessibilityServiceInfo) AccessibilityService#setServiceInfo(AccessibilityServiceInfo)}.</strong>
 * </p>
 *
 * @param timeout The timeout in milliseconds.
 *
 * Value is 0 or greater
 * @see android.R.styleable#AccessibilityService_nonInteractiveUiTimeout
 * @apiSince 29
 */

public void setNonInteractiveUiTimeoutMillis(int timeout) { throw new RuntimeException("Stub!"); }

/**
 * Get the recommended timeout for non-interactive controls.
 *
 * @return The timeout in milliseconds.
 *
 * @see #setNonInteractiveUiTimeoutMillis(int)
 * @apiSince 29
 */

public int getNonInteractiveUiTimeoutMillis() { throw new RuntimeException("Stub!"); }

/**
 * Set the recommended time that interactive controls need to remain on the screen to
 * support the user.
 * <p>
 *     <strong>This value can be dynamically set at runtime by
 *     {@link android.accessibilityservice.AccessibilityService#setServiceInfo(android.accessibilityservice.AccessibilityServiceInfo) AccessibilityService#setServiceInfo(AccessibilityServiceInfo)}.</strong>
 * </p>
 *
 * @param timeout The timeout in milliseconds.
 *
 * Value is 0 or greater
 * @see android.R.styleable#AccessibilityService_interactiveUiTimeout
 * @apiSince 29
 */

public void setInteractiveUiTimeoutMillis(int timeout) { throw new RuntimeException("Stub!"); }

/**
 * Get the recommended timeout for interactive controls.
 *
 * @return The timeout in milliseconds.
 *
 * @see #setInteractiveUiTimeoutMillis(int)
 * @apiSince 29
 */

public int getInteractiveUiTimeoutMillis() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @apiSince 4
 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public void writeToParcel(android.os.Parcel parcel, int flagz) { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/** @apiSince 4 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Returns the string representation of a feedback type. For example,
 * {@link #FEEDBACK_SPOKEN} is represented by the string FEEDBACK_SPOKEN.
 *
 * @param feedbackType The feedback type.
 * @return The string representation.
 * @apiSince 14
 */

public static java.lang.String feedbackTypeToString(int feedbackType) { throw new RuntimeException("Stub!"); }

/**
 * Returns the string representation of a flag. For example,
 * {@link #DEFAULT} is represented by the string DEFAULT.
 *
 * @param flag The flag.
 * @return The string representation.
 * @apiSince 14
 */

public static java.lang.String flagToString(int flag) { throw new RuntimeException("Stub!"); }

/**
 * Returns the string representation of a capability. For example,
 * {@link #CAPABILITY_CAN_RETRIEVE_WINDOW_CONTENT} is represented
 * by the string CAPABILITY_CAN_RETRIEVE_WINDOW_CONTENT.
 *
 * @param capability The capability.
 * @return The string representation.
 * @apiSince 18
 */

public static java.lang.String capabilityToString(int capability) { throw new RuntimeException("Stub!"); }

/**
 * Capability: This accessibility service can control display magnification.
 * @see android.R.styleable#AccessibilityService_canControlMagnification
 * @apiSince 24
 */

public static final int CAPABILITY_CAN_CONTROL_MAGNIFICATION = 16; // 0x10

/**
 * Capability: This accessibility service can perform gestures.
 * @see android.R.styleable#AccessibilityService_canPerformGestures
 * @apiSince 24
 */

public static final int CAPABILITY_CAN_PERFORM_GESTURES = 32; // 0x20

/**
 * @deprecated No longer used
 * @apiSince 18
 * @deprecatedSince 26
 */

@Deprecated public static final int CAPABILITY_CAN_REQUEST_ENHANCED_WEB_ACCESSIBILITY = 4; // 0x4

/**
 * Capability: This accessibility service can request to filter the key event stream.
 * @see android.R.styleable#AccessibilityService_canRequestFilterKeyEvents
 * @apiSince 18
 */

public static final int CAPABILITY_CAN_REQUEST_FILTER_KEY_EVENTS = 8; // 0x8

/**
 * Capability: This accessibility service can capture gestures from the fingerprint sensor
 * @see android.R.styleable#AccessibilityService_canRequestFingerprintGestures
 * @apiSince 26
 */

public static final int CAPABILITY_CAN_REQUEST_FINGERPRINT_GESTURES = 64; // 0x40

/**
 * Capability: This accessibility service can request touch exploration mode in which
 * touched items are spoken aloud and the UI can be explored via gestures.
 * @see android.R.styleable#AccessibilityService_canRequestTouchExplorationMode
 * @apiSince 18
 */

public static final int CAPABILITY_CAN_REQUEST_TOUCH_EXPLORATION = 2; // 0x2

/**
 * Capability: This accessibility service can retrieve the active window content.
 * @see android.R.styleable#AccessibilityService_canRetrieveWindowContent
 * @apiSince 18
 */

public static final int CAPABILITY_CAN_RETRIEVE_WINDOW_CONTENT = 1; // 0x1

/**
 * @see android.os.Parcelable.Creator
 * @apiSince 4
 */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.accessibilityservice.AccessibilityServiceInfo> CREATOR;
static { CREATOR = null; }

/**
 * If an {@link android.accessibilityservice.AccessibilityService AccessibilityService} is the default for a given type.
 * Default service is invoked only if no package specific one exists. In case of
 * more than one package specific service only the earlier registered is notified.
 * @apiSince 4
 */

public static final int DEFAULT = 1; // 0x1

/**
 * Mask for all feedback types.
 *
 * @see #FEEDBACK_SPOKEN
 * @see #FEEDBACK_HAPTIC
 * @see #FEEDBACK_AUDIBLE
 * @see #FEEDBACK_VISUAL
 * @see #FEEDBACK_GENERIC
 * @see #FEEDBACK_BRAILLE
 * @apiSince 14
 */

public static final int FEEDBACK_ALL_MASK = -1; // 0xffffffff

/**
 * Denotes audible (not spoken) feedback.
 * @apiSince 4
 */

public static final int FEEDBACK_AUDIBLE = 4; // 0x4

/**
 * Denotes braille feedback.
 * @apiSince 17
 */

public static final int FEEDBACK_BRAILLE = 32; // 0x20

/**
 * Denotes generic feedback.
 * @apiSince 4
 */

public static final int FEEDBACK_GENERIC = 16; // 0x10

/**
 * Denotes haptic feedback.
 * @apiSince 4
 */

public static final int FEEDBACK_HAPTIC = 2; // 0x2

/**
 * Denotes spoken feedback.
 * @apiSince 4
 */

public static final int FEEDBACK_SPOKEN = 1; // 0x1

/**
 * Denotes visual feedback.
 * @apiSince 4
 */

public static final int FEEDBACK_VISUAL = 8; // 0x8

/**
 * This flag requests that all audio tracks system-wide with
 * {@link android.media.AudioAttributes#USAGE_ASSISTANCE_ACCESSIBILITY} be controlled by the
 * {@link android.media.AudioManager#STREAM_ACCESSIBILITY} volume.
 * @apiSince 26
 */

public static final int FLAG_ENABLE_ACCESSIBILITY_VOLUME = 128; // 0x80

/**
 * If this flag is set the system will regard views that are not important
 * for accessibility in addition to the ones that are important for accessibility.
 * That is, views that are marked as not important for accessibility via
 * {@link android.view.View#IMPORTANT_FOR_ACCESSIBILITY_NO View#IMPORTANT_FOR_ACCESSIBILITY_NO} or
 * {@link android.view.View#IMPORTANT_FOR_ACCESSIBILITY_NO_HIDE_DESCENDANTS View#IMPORTANT_FOR_ACCESSIBILITY_NO_HIDE_DESCENDANTS} and views that are
 * marked as potentially important for accessibility via
 * {@link android.view.View#IMPORTANT_FOR_ACCESSIBILITY_AUTO View#IMPORTANT_FOR_ACCESSIBILITY_AUTO} for which the system has determined
 * that are not important for accessibility, are reported while querying the window
 * content and also the accessibility service will receive accessibility events from
 * them.
 * <p>
 * <strong>Note:</strong> For accessibility services targeting Android 4.1 (API level 16) or
 * higher, this flag has to be explicitly set for the system to regard views that are not
 * important for accessibility. For accessibility services targeting Android 4.0.4 (API level
 * 15) or lower, this flag is ignored and all views are regarded for accessibility purposes.
 * </p>
 * <p>
 * Usually views not important for accessibility are layout managers that do not
 * react to user actions, do not draw any content, and do not have any special
 * semantics in the context of the screen content. For example, a three by three
 * grid can be implemented as three horizontal linear layouts and one vertical,
 * or three vertical linear layouts and one horizontal, or one grid layout, etc.
 * In this context, the actual layout managers used to achieve the grid configuration
 * are not important; rather it is important that there are nine evenly distributed
 * elements.
 * </p>
 * @apiSince 16
 */

public static final int FLAG_INCLUDE_NOT_IMPORTANT_VIEWS = 2; // 0x2

/**
 * This flag requests that the {@link android.view.accessibility.AccessibilityNodeInfo AccessibilityNodeInfo}s obtained
 * by an {@link android.accessibilityservice.AccessibilityService AccessibilityService} contain the id of the source view.
 * The source view id will be a fully qualified resource name of the
 * form "package:id/name", for example "foo.bar:id/my_list", and it is
 * useful for UI test automation. This flag is not set by default.
 * @apiSince 18
 */

public static final int FLAG_REPORT_VIEW_IDS = 16; // 0x10

/**
 * This flag indicates to the system that the accessibility service requests that an
 * accessibility button be shown within the system's navigation area, if available.
 * @apiSince 26
 */

public static final int FLAG_REQUEST_ACCESSIBILITY_BUTTON = 256; // 0x100

/**
 * @deprecated No longer used
 * @apiSince 18
 * @deprecatedSince 26
 */

@Deprecated public static final int FLAG_REQUEST_ENHANCED_WEB_ACCESSIBILITY = 8; // 0x8

/**
 * This flag requests from the system to filter key events. If this flag
 * is set the accessibility service will receive the key events before
 * applications allowing it implement global shortcuts.
 * <p>
 * Services that want to set this flag have to declare this capability
 * in their meta-data by setting the attribute {@link android.R.attr
 * #canRequestFilterKeyEvents canRequestFilterKeyEvents} to true,
 * otherwise this flag will be ignored. For how to declare the meta-data
 * of a service refer to {@value android.accessibilityservice.AccessibilityService#SERVICE_META_DATA AccessibilityService#SERVICE_META_DATA}.
 * </p>
 * @see android.R.styleable#AccessibilityService_canRequestFilterKeyEvents
 * @apiSince 18
 */

public static final int FLAG_REQUEST_FILTER_KEY_EVENTS = 32; // 0x20

/**
 * This flag requests that all fingerprint gestures be sent to the accessibility service.
 * <p>
 * Services that want to set this flag have to declare the capability
 * to retrieve window content in their meta-data by setting the attribute
 * {@link android.R.attr#canRequestFingerprintGestures} to
 * true, otherwise this flag will be ignored. For how to declare the meta-data
 * of a service refer to {@value android.accessibilityservice.AccessibilityService#SERVICE_META_DATA AccessibilityService#SERVICE_META_DATA}.
 * </p>
 *
 * @see android.R.styleable#AccessibilityService_canRequestFingerprintGestures
 * @see android.accessibilityservice.AccessibilityService#getFingerprintGestureController()
 * @apiSince 26
 */

public static final int FLAG_REQUEST_FINGERPRINT_GESTURES = 512; // 0x200

/**
 * This flag requests that accessibility shortcut warning dialog has spoken feedback when
 * dialog is shown.
 * @apiSince 29
 */

public static final int FLAG_REQUEST_SHORTCUT_WARNING_DIALOG_SPOKEN_FEEDBACK = 1024; // 0x400

/**
 * This flag requests that the system gets into touch exploration mode.
 * In this mode a single finger moving on the screen behaves as a mouse
 * pointer hovering over the user interface. The system will also detect
 * certain gestures performed on the touch screen and notify this service.
 * The system will enable touch exploration mode if there is at least one
 * accessibility service that has this flag set. Hence, clearing this
 * flag does not guarantee that the device will not be in touch exploration
 * mode since there may be another enabled service that requested it.
 * <p>
 * For accessibility services targeting Android 4.3 (API level 18) or higher
 * that want to set this flag have to declare this capability in their
 * meta-data by setting the attribute
 * {@link android.R.attr#canRequestTouchExplorationMode
 * canRequestTouchExplorationMode} to true. Otherwise, this flag will
 * be ignored. For how to declare the meta-data of a service refer to
 * {@value android.accessibilityservice.AccessibilityService#SERVICE_META_DATA AccessibilityService#SERVICE_META_DATA}.
 * </p>
 * <p>
 * Services targeting Android 4.2.2 (API level 17) or lower will work
 * normally. In other words, the first time they are run, if this flag is
 * specified, a dialog is shown to the user to confirm enabling explore by
 * touch.
 * </p>
 * @see android.R.styleable#AccessibilityService_canRequestTouchExplorationMode
 * @apiSince 16
 */

public static final int FLAG_REQUEST_TOUCH_EXPLORATION_MODE = 4; // 0x4

/**
 * This flag indicates to the system that the accessibility service wants
 * to access content of all interactive windows. An interactive window is a
 * window that has input focus or can be touched by a sighted user when explore
 * by touch is not enabled. If this flag is not set your service will not receive
 * {@link android.view.accessibility.AccessibilityEvent#TYPE_WINDOWS_CHANGED}
 * events, calling AccessibilityService{@link android.accessibilityservice.AccessibilityService#getWindows() AccessibilityService#getWindows()} will return an empty list, and {@link android.view.accessibility.AccessibilityNodeInfo#getWindow() AccessibilityNodeInfo#getWindow()} will
 * return null.
 * <p>
 * Services that want to set this flag have to declare the capability
 * to retrieve window content in their meta-data by setting the attribute
 * {@link android.R.attr#canRetrieveWindowContent canRetrieveWindowContent} to
 * true, otherwise this flag will be ignored. For how to declare the meta-data
 * of a service refer to {@value android.accessibilityservice.AccessibilityService#SERVICE_META_DATA AccessibilityService#SERVICE_META_DATA}.
 * </p>
 * @see android.R.styleable#AccessibilityService_canRetrieveWindowContent
 * @apiSince 21
 */

public static final int FLAG_RETRIEVE_INTERACTIVE_WINDOWS = 64; // 0x40

/**
 * The event types an {@link android.accessibilityservice.AccessibilityService AccessibilityService} is interested in.
 * <p>
 *   <strong>Can be dynamically set at runtime.</strong>
 * </p>
 * @see android.view.accessibility.AccessibilityEvent#TYPE_VIEW_CLICKED
 * @see android.view.accessibility.AccessibilityEvent#TYPE_VIEW_LONG_CLICKED
 * @see android.view.accessibility.AccessibilityEvent#TYPE_VIEW_FOCUSED
 * @see android.view.accessibility.AccessibilityEvent#TYPE_VIEW_SELECTED
 * @see android.view.accessibility.AccessibilityEvent#TYPE_VIEW_TEXT_CHANGED
 * @see android.view.accessibility.AccessibilityEvent#TYPE_WINDOW_STATE_CHANGED
 * @see android.view.accessibility.AccessibilityEvent#TYPE_NOTIFICATION_STATE_CHANGED
 * @see android.view.accessibility.AccessibilityEvent#TYPE_TOUCH_EXPLORATION_GESTURE_START
 * @see android.view.accessibility.AccessibilityEvent#TYPE_TOUCH_EXPLORATION_GESTURE_END
 * @see android.view.accessibility.AccessibilityEvent#TYPE_VIEW_HOVER_ENTER
 * @see android.view.accessibility.AccessibilityEvent#TYPE_VIEW_HOVER_EXIT
 * @see android.view.accessibility.AccessibilityEvent#TYPE_VIEW_SCROLLED
 * @see android.view.accessibility.AccessibilityEvent#TYPE_VIEW_TEXT_SELECTION_CHANGED
 * @see android.view.accessibility.AccessibilityEvent#TYPE_WINDOW_CONTENT_CHANGED
 * @see android.view.accessibility.AccessibilityEvent#TYPE_TOUCH_INTERACTION_START
 * @see android.view.accessibility.AccessibilityEvent#TYPE_TOUCH_INTERACTION_END
 * @see android.view.accessibility.AccessibilityEvent#TYPE_ANNOUNCEMENT
 * @see android.view.accessibility.AccessibilityEvent#TYPE_GESTURE_DETECTION_START
 * @see android.view.accessibility.AccessibilityEvent#TYPE_GESTURE_DETECTION_END
 * @see android.view.accessibility.AccessibilityEvent#TYPE_VIEW_ACCESSIBILITY_FOCUSED
 * @see android.view.accessibility.AccessibilityEvent#TYPE_VIEW_ACCESSIBILITY_FOCUS_CLEARED
 * @see android.view.accessibility.AccessibilityEvent#TYPE_VIEW_TEXT_TRAVERSED_AT_MOVEMENT_GRANULARITY
 * @see android.view.accessibility.AccessibilityEvent#TYPE_WINDOWS_CHANGED
 * @apiSince 4
 */

public int eventTypes;

/**
 * The feedback type an {@link android.accessibilityservice.AccessibilityService AccessibilityService} provides.
 * <p>
 *   <strong>Can be dynamically set at runtime.</strong>
 * </p>
 * <br>
 * Value is either <code>0</code> or a combination of {@link android.accessibilityservice.AccessibilityServiceInfo#FEEDBACK_AUDIBLE}, {@link android.accessibilityservice.AccessibilityServiceInfo#FEEDBACK_GENERIC}, {@link android.accessibilityservice.AccessibilityServiceInfo#FEEDBACK_HAPTIC}, {@link android.accessibilityservice.AccessibilityServiceInfo#FEEDBACK_SPOKEN}, {@link android.accessibilityservice.AccessibilityServiceInfo#FEEDBACK_VISUAL}, and {@link android.accessibilityservice.AccessibilityServiceInfo#FEEDBACK_BRAILLE}
 * @see #FEEDBACK_AUDIBLE
 * @see #FEEDBACK_GENERIC
 * @see #FEEDBACK_HAPTIC
 * @see #FEEDBACK_SPOKEN
 * @see #FEEDBACK_VISUAL
 * @see #FEEDBACK_BRAILLE
 * @apiSince 4
 */

public int feedbackType;

/**
 * This field represents a set of flags used for configuring an
 * {@link android.accessibilityservice.AccessibilityService AccessibilityService}.
 * <p>
 *   <strong>Can be dynamically set at runtime.</strong>
 * </p>
 * @see #DEFAULT
 * @see #FLAG_INCLUDE_NOT_IMPORTANT_VIEWS
 * @see #FLAG_REQUEST_TOUCH_EXPLORATION_MODE
 * @see #FLAG_REQUEST_ENHANCED_WEB_ACCESSIBILITY
 * @see #FLAG_REQUEST_FILTER_KEY_EVENTS
 * @see #FLAG_REPORT_VIEW_IDS
 * @see #FLAG_RETRIEVE_INTERACTIVE_WINDOWS
 * @see #FLAG_ENABLE_ACCESSIBILITY_VOLUME
 * @see #FLAG_REQUEST_ACCESSIBILITY_BUTTON
 * @see #FLAG_REQUEST_SHORTCUT_WARNING_DIALOG_SPOKEN_FEEDBACK
 * @apiSince 4
 */

public int flags;

/**
 * The timeout, in milliseconds, after the most recent event of a given type before an
 * {@link android.accessibilityservice.AccessibilityService AccessibilityService} is notified.
 * <p>
 *   <strong>Can be dynamically set at runtime.</strong>
 * </p>
 * <p>
 * <strong>Note:</strong> The event notification timeout is useful to avoid propagating
 *       events to the client too frequently since this is accomplished via an expensive
 *       interprocess call. One can think of the timeout as a criteria to determine when
 *       event generation has settled down.
 * @apiSince 4
 */

public long notificationTimeout;

/**
 * The package names an {@link android.accessibilityservice.AccessibilityService AccessibilityService} is interested in. Setting
 * to <code>null</code> is equivalent to all packages.
 * <p>
 *   <strong>Can be dynamically set at runtime.</strong>
 * </p>
 * @apiSince 4
 */

public java.lang.String[] packageNames;
}
