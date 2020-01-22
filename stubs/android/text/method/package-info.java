/**
 * <p>Provides classes that monitor or modify keypad input.</p>
 * <p>You can use these classes to modify the type of keypad entry
 * for your application, or decipher the keypresses entered for your specific
 * entry method. For example:</p>
 * <pre>
 * // Set the text to password display style:
 * EditText txtView = (EditText)findViewById(R.id.text);
 * txtView.setTransformationMethod(PasswordTransformationMethod.getInstance());
 *
 * //Set the input style to numbers, rather than qwerty keyboard style.
 * txtView.setInputMethod(DigitsInputMethod.getInstance());
 *
 * // Find out whether the caps lock is on.
 * // 0 is no, 1 is yes, 2 is caps lock on.
 * int active = MultiTapInputMethod.getCapsActive(txtView.getText());
 * </pre>
 @apiSince 1
 */

package android.text.method;
