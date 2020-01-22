/*
 * Copyright (C) 2014 The Android Open Source Project
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


package android.telephony;

import android.net.LinkProperties;

/**
 * Contains precise data connection state.
 *
 * The following data connection information is included in returned PreciseDataConnectionState:
 *
 * <ul>
 *   <li>Data connection state.
 *   <li>Network type of the connection.
 *   <li>APN types.
 *   <li>APN.
 *   <li>The properties of the network link.
 *   <li>Data connection fail cause.
 * </ul>
 *
 * @apiSince R
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class PreciseDataConnectionState implements android.os.Parcelable {

PreciseDataConnectionState() { throw new RuntimeException("Stub!"); }

/**
 * Returns the high-level state of this data connection.
 
 * @return Value is {@link android.telephony.TelephonyManager#DATA_UNKNOWN}, {@link android.telephony.TelephonyManager#DATA_DISCONNECTED}, {@link android.telephony.TelephonyManager#DATA_CONNECTING}, {@link android.telephony.TelephonyManager#DATA_CONNECTED}, or {@link android.telephony.TelephonyManager#DATA_SUSPENDED}
 * @apiSince R
 */

public int getState() { throw new RuntimeException("Stub!"); }

/**
 * Returns the network type associated with this data connection.
 *
 * Return the current/latest (radio) bearer technology that carries this data connection.
 * For a variety of reasons, the network type can change during the life of the data
 * connection, and this information is not reliable unless the physical link is currently
 * active; (there is currently no mechanism to know whether the physical link is active at
 * any given moment). Thus, this value is generally correct but may not be relied-upon to
 * represent the status of the radio bearer at any given moment.
 
 * @return Value is {@link android.telephony.TelephonyManager#NETWORK_TYPE_UNKNOWN}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_GPRS}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_EDGE}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_UMTS}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_CDMA}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_EVDO_0}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_EVDO_A}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_1xRTT}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_HSDPA}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_HSUPA}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_HSPA}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_IDEN}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_EVDO_B}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_LTE}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_EHRPD}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_HSPAP}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_GSM}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_TD_SCDMA}, {@link android.telephony.TelephonyManager#NETWORK_TYPE_IWLAN}, or {@link android.telephony.TelephonyManager#NETWORK_TYPE_NR}
 * @apiSince R
 */

public int getNetworkType() { throw new RuntimeException("Stub!"); }

/**
 * Get the properties of the network link {@link android.net.LinkProperties LinkProperties}.
 
 * @return This value may be {@code null}.
 * @apiSince R
 */

@androidx.annotation.Nullable
public android.net.LinkProperties getLinkProperties() { throw new RuntimeException("Stub!"); }

/**
 * Returns the cause code generated by the most recent state change.
 *
 * Return the cause code for the most recent change in {@link #getState}. In the event of an
 * error, this cause code will be non-zero.
 * @apiSince R
 */

public int getLastCauseCode() { throw new RuntimeException("Stub!"); }

/** @apiSince R */

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param out This value must never be {@code null}.
 * @apiSince R
 */

public void writeToParcel(@androidx.annotation.NonNull android.os.Parcel out, int flags) { throw new RuntimeException("Stub!"); }

/** @apiSince R */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @param obj This value may be {@code null}.
 * @apiSince R
 */

public boolean equals(@androidx.annotation.Nullable java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}

 * @return This value will never be {@code null}.
 * @apiSince R
 */

@androidx.annotation.NonNull
public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @apiSince R */

@androidx.annotation.NonNull public static final android.os.Parcelable.Creator<android.telephony.PreciseDataConnectionState> CREATOR;
static { CREATOR = null; }
}

