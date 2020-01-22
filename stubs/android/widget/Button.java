/*
 * Copyright (C) 2006 The Android Open Source Project
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


package android.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;

/**
 * A user interface element the user can tap or click to perform an action.
 *
 * <p>To display a button in an activity, add a button to the activity's layout XML file:</p>
 *
 * <pre>
 * &lt;Button
 *     android:id="@+id/button_id"
 *     android:layout_height="wrap_content"
 *     android:layout_width="wrap_content"
 *     android:text="@string/self_destruct" /&gt;</pre>
 *
 * <p>To specify an action when the button is pressed, set a click
 * listener on the button object in the corresponding activity code:</p>
 *
 * <pre>
 * public class MyActivity extends Activity {
 *     protected void onCreate(Bundle savedInstanceState) {
 *         super.onCreate(savedInstanceState);
 *
 *         setContentView(R.layout.content_layout_id);
 *
 *         final Button button = findViewById(R.id.button_id);
 *         button.setOnClickListener(new View.OnClickListener() {
 *             public void onClick(View v) {
 *                 // Code here executes on main thread after user presses button
 *             }
 *         });
 *     }
 * }</pre>
 *
 * <p>The above snippet creates an instance of {@link android.view.View.OnClickListener} and wires
 * the listener to the button using
 * {@link #setOnClickListener setOnClickListener(View.OnClickListener)}.
 * As a result, the system executes the code you write in {@code onClick(View)} after the
 * user presses the button.</p>
 *
 * <p class="note">The system executes the code in {@code onClick} on the
 * <a href="{@docRoot}guide/components/processes-and-threads.html#Threads">main thread</a>.
 * This means your onClick code must execute quickly to avoid delaying your app's response
 * to further user actions.  See
 * <a href="{@docRoot}training/articles/perf-anr.html">Keeping Your App Responsive</a>
 * for more details.</p>
 *
 * <p>Every button is styled using the system's default button background, which is often
 * different from one version of the platform to another. If you are not satisfied with the
 * default button style, you can customize it. For more details and code samples, see the
 * <a href="{@docRoot}guide/topics/ui/controls/button.html#Style">Styling Your Button</a>
 * guide.</p>
 *
 * <p>For all XML style attributes available on Button see
 * {@link android.R.styleable#Button Button Attributes},
 * {@link android.R.styleable#TextView TextView Attributes},
 * {@link android.R.styleable#View View Attributes}.  See the
 * <a href="{@docRoot}guide/topics/ui/themes.html#ApplyingStyles">Styles and Themes</a>
 * guide to learn how to implement and organize overrides to style-related attributes.</p>
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@android.widget.RemoteViews.RemoteView
public class Button extends android.widget.TextView {

/**
 * Simple constructor to use when creating a button from code.
 *
 * @param context The Context the Button is running in, through which it can
 *        access the current theme, resources, etc.
 *
 * @see #Button(Context, AttributeSet)
 * @apiSince 1
 */

public Button(android.content.Context context) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * {@link android.view.LayoutInflater LayoutInflater} calls this constructor when inflating a Button from XML.
 * The attributes defined by the current theme's
 * {@link android.R.attr#buttonStyle android:buttonStyle}
 * override base view attributes.
 *
 * You typically do not call this constructor to create your own button instance in code.
 * However, you must override this constructor when
 * <a href="{@docRoot}training/custom-views/index.html">creating custom views</a>.
 *
 * @param context The Context the view is running in, through which it can
 *        access the current theme, resources, etc.
 * @param attrs The attributes of the XML Button tag being used to inflate the view.
 *
 * @see #Button(Context, AttributeSet, int)
 * @see android.view.View#View(Context, AttributeSet)
 * @apiSince 1
 */

public Button(android.content.Context context, android.util.AttributeSet attrs) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * This constructor allows a Button subclass to use its own class-specific base style from a
 * theme attribute when inflating. The attributes defined by the current theme's
 * {@code defStyleAttr} override base view attributes.
 *
 * <p>For Button's base view attributes see
 * {@link android.R.styleable#Button Button Attributes},
 * {@link android.R.styleable#TextView TextView Attributes},
 * {@link android.R.styleable#View View Attributes}.
 *
 * @param context The Context the Button is running in, through which it can
 *        access the current theme, resources, etc.
 * @param attrs The attributes of the XML Button tag that is inflating the view.
 * @param defStyleAttr The resource identifier of an attribute in the current theme
 *        whose value is the the resource id of a style. The specified style’s
 *        attribute values serve as default values for the button. Set this parameter
 *        to 0 to avoid use of default values.
 * @see #Button(Context, AttributeSet, int, int)
 * @see android.view.View#View(Context, AttributeSet, int)
 * @apiSince 1
 */

public Button(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * This constructor allows a Button subclass to use its own class-specific base style from
 * either a theme attribute or style resource when inflating. To see how the final value of a
 * particular attribute is resolved based on your inputs to this constructor, see
 * {@link android.view.View#View(Context, AttributeSet, int, int)}.
 *
 * @param context The Context the Button is running in, through which it can
 *        access the current theme, resources, etc.
 * @param attrs The attributes of the XML Button tag that is inflating the view.
 * @param defStyleAttr The resource identifier of an attribute in the current theme
 *        whose value is the the resource id of a style. The specified style’s
 *        attribute values serve as default values for the button. Set this parameter
 *        to 0 to avoid use of default values.
 * @param defStyleRes The identifier of a style resource that
 *        supplies default values for the button, used only if
 *        defStyleAttr is 0 or cannot be found in the theme.
 *        Set this parameter to 0 to avoid use of default values.
 *
 * @see #Button(Context, AttributeSet, int)
 * @see android.view.View#View(Context, AttributeSet, int, int)
 * @apiSince 21
 */

public Button(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr, int defStyleRes) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/** @apiSince 23 */

public java.lang.CharSequence getAccessibilityClassName() { throw new RuntimeException("Stub!"); }

/** @apiSince 24 */

public android.view.PointerIcon onResolvePointerIcon(android.view.MotionEvent event, int pointerIndex) { throw new RuntimeException("Stub!"); }
}

