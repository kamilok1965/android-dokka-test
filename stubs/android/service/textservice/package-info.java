/**
 * <p>Provides classes that allow you to create spell checkers in a manner similar to the
 * input method framework (for IMEs).</p>
 *
 * <p>To create a new spell checker, you must implement a service that extends {@link
 * android.service.textservice.SpellCheckerService} and extend the {@link
 * android.service.textservice.SpellCheckerService.Session} class to provide spelling suggestions based
 * on text provided by the interface's callback methods. In the {@link
 * android.service.textservice.SpellCheckerService.Session} callback methods, you must return the
 * spelling suggestions as {@link android.view.textservice.SuggestionsInfo} objects. </p>
 *
 * <p>Applications with a spell checker service must declare the {@link
 * android.Manifest.permission#BIND_TEXT_SERVICE} permission as required by the service. The service
 * must also declare an intent filter with {@code <action
 * android:name="android.service.textservice.SpellCheckerService" />} as the intent’s action and should
 * include a {@code <meta-data>} element that declares configuration information for the spell
 * checker. For example:</p>
 *
 * <pre>
 * &lt;service
 *     android:label="&#064;string/app_name"
 *     android:name=".SampleSpellCheckerService"
 *     android:permission="android.permission.BIND_TEXT_SERVICE" >
 *     &lt;intent-filter >
 *         &lt;action android:name="android.service.textservice.SpellCheckerService" />
 *     &lt;/intent-filter>
 *     &lt;meta-data
 *         android:name="android.view.textservice.scs"
 *         android:resource="&#064;xml/spellchecker" />
 * &lt;/service>
 * </pre>
 *
 * <p>For example code, see the sample <a
 * href="{@docRoot}resources/samples/SpellChecker/SampleSpellCheckerService/index.html">Spell
 * Checker service</a> app, and the sample <a
 * href="{@docRoot}resources/samples/SpellChecker/HelloSpellChecker/index.html">Spell
 * Checker client</a> app.</p>
 @apiSince 14
 */

package android.service.textservice;
