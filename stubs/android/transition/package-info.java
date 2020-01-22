/**
 * <p>The classes in this package enable "scenes & transitions" functionality for
 * view hiearchies.</p>
 *
 * <p>A <b>Scene</b> is an encapsulation of the state of a view hierarchy,
 * including the views in that hierarchy and the various values (layout-related
 * and otherwise) that those views have. A scene can be defined by a layout hierarchy
 * directly or by code which sets up the scene dynamically as it is entered.</p>
 *
 * <p>A <b>Transition</b> is a mechanism to automatically animate changes that occur
 * when a new scene is entered. Some transition capabilities are automatic. That
 * is, entering a scene may cause animations to run which fade out views that
 * go away, changeBounds and resize existing views that change, and fade in views that
 * become visible. There are additional transitions that can animate other
 * attributes, such as color changes, and which can optionally be specified
 * to take place during particular scene changes. Finally, developers can
 * define their own Transition subclasses which monitor particular property
 * changes and which run custom animations when those properties change values.</p>
 *
 * <p><b>TransitionManager</b> is used to specify custom transitions for particular
 * scene changes, and to cause scene changes with specific transitions to
 * take place.</p>
 @apiSince 19
 */

package android.transition;
