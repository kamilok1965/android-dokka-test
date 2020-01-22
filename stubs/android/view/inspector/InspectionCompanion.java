/*
 * Copyright 2018 The Android Open Source Project
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


package android.view.inspector;


/**
 * An interface for companion objects used to inspect views.
 *
 * Inspection companions only need to handle the properties and node name of the specific class
 * they are defined for, not anything from a parent class. At runtime, the inspector instantiates
 * one instance of each inspection companion, and handles visiting them in the correct inheritance
 * order for each type it inspects.
 *
 * Properties are read from the top of the type tree to the bottom, so that classes that override
 * a property in their parent class can overwrite it in the reader. In general, properties will
 * cleanly inherit through their getters, and the inspector runtime will read the properties of a
 * parent class via the parent's inspection companion, and the child companion will only read
 * properties added or changed since the parent was defined.
 *
 * @param <T> The type of inspectable this is the companion to
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public interface InspectionCompanion<T> {

/**
 * Map the string names of the properties this companion knows about to integer IDs.
 *
 * Each companion is responsible for storing the integer IDs of all its properties. This is the
 * only method that is allowed to modify the stored IDs.
 *
 * Calling {@link #readProperties(T,android.view.inspector.PropertyReader)} before calling this results in
 * undefined behavior.
 *
 * @param propertyMapper A {@link android.view.inspector.PropertyMapper PropertyMapper} maps string names to IDs.
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public void mapProperties(@androidx.annotation.NonNull android.view.inspector.PropertyMapper propertyMapper);

/**
 * Read the values of an instance of this companion's type into a {@link android.view.inspector.PropertyReader PropertyReader}.
 *
 * This method needs to return the property IDs stored by
 * {@link #mapProperties(android.view.inspector.PropertyMapper)}. Implementations should track if their properties
 * have been mapped and throw a {@link android.view.inspector.InspectionCompanion.UninitializedPropertyMapException UninitializedPropertyMapException} if this method is
 * called before {mapProperties}.
 *
 * @param inspectable A object of type {T} to read the properties of.
 * This value must never be {@code null}.
 * @param propertyReader An object which receives the property IDs and values.
 
 * This value must never be {@code null}.
 * @apiSince 29
 */

public void readProperties(@androidx.annotation.NonNull T inspectable, @androidx.annotation.NonNull android.view.inspector.PropertyReader propertyReader);
/**
 * Thrown by {@link #readProperties(java.lang.Object,android.view.inspector.PropertyReader)} if called before
 * {@link #mapProperties(android.view.inspector.PropertyMapper)}.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class UninitializedPropertyMapException extends java.lang.RuntimeException {

/** @apiSince 29 */

public UninitializedPropertyMapException() { throw new RuntimeException("Stub!"); }
}

}

