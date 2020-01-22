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


package android.provider;

import android.database.Cursor;

/** @apiSince 1 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public interface BaseColumns {

/**
 * The count of rows in a directory.
 * @apiSince 1
 */

public static final java.lang.String _COUNT = "_count";

/**
 * The unique ID for a row.
 
 * <br>
 * This constant represents a column name that can be used with a {@link android.content.ContentProvider} through a {@link android.content.ContentValues} or {@link android.database.Cursor} object. The values stored in this column are {@link android.database.Cursor#FIELD_TYPE_INTEGER Cursor#FIELD_TYPE_INTEGER} .
 * @apiSince 1
 */

public static final java.lang.String _ID = "_id";
}

