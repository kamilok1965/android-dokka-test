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


package android.test;


/**
 * More complex interface performance for test cases.
 *
 * If you want your test to be used as a performance test, you must
 * implement this interface.
 *
 * @deprecated Use
 * <a href="{@docRoot}reference/android/support/test/runner/AndroidJUnitRunner.html">
 * AndroidJUnitRunner</a> instead. New tests should be written using the
 * <a href="{@docRoot}tools/testing-support-library/index.html">Android Testing Support Library</a>.
 * @apiSince 1
 * @deprecatedSince 24
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public interface PerformanceTestCase {

/**
 * Set up to begin performance tests. The 'intermediates' is a
 * communication channel to send back intermediate performance numbers --
 * if you use it, you will probably want to ensure your test is only
 * executed once by returning 1.  Otherwise, return 0 to allow the test
 * harness to decide the number of iterations.
 *
 * <p>If you return a non-zero iteration count, you should call
 * {@link android.test.PerformanceTestCase.Intermediates#startTiming Intermediates#startTiming} and
 * {@link android.test.PerformanceTestCase.Intermediates#finishTiming Intermediates#finishTiming} to report the
 * duration of the test whose performance should actually be measured.
 *
 * @param intermediates Callback for sending intermediate results.
 *
 * @return int Maximum number of iterations to run, or 0 to let the caller
 * decide.
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public int startPerformance(android.test.PerformanceTestCase.Intermediates intermediates);

/**
 * This method is used to determine what modes this test case can run in.
 *
 * @return true if this test case can only be run in performance mode.
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public boolean isPerformanceOnly();
/**
 * Callbacks for {@link android.test.PerformanceTestCase PerformanceTestCase}.
 * @apiSince 1
 * @deprecatedSince R
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated
public static interface Intermediates {

/**
 * @apiSince 1
 * @deprecatedSince R
 */

@Deprecated
public void setInternalIterations(int count);

/**
 * @apiSince 1
 * @deprecatedSince R
 */

@Deprecated
public void startTiming(boolean realTime);

/**
 * @apiSince 1
 * @deprecatedSince R
 */

@Deprecated
public void addIntermediate(java.lang.String name);

/**
 * @apiSince 1
 * @deprecatedSince R
 */

@Deprecated
public void addIntermediate(java.lang.String name, long timeInNS);

/**
 * @apiSince 1
 * @deprecatedSince R
 */

@Deprecated
public void finishTiming(boolean realTime);
}

}

