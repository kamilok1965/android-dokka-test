/*
 * Copyright (C) 2008 The Android Open Source Project
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
 * Implementors will know how to get a test suite.
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
public interface TestSuiteProvider {

/**
 * @apiSince 1
 * @deprecatedSince 24
 */

@Deprecated
public junit.framework.TestSuite getTestSuite();
}

