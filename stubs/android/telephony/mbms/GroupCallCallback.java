/*
 * Copyright (C) 2018 The Android Open Source Project
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


package android.telephony.mbms;


/**
 * A callback class for use when the application is in a group call. The middleware
 * will provide updates on the status of the call via this callback.
 * @apiSince 29
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public interface GroupCallCallback {

/**
 * Called by the middleware when it has detected an error condition in this group call. The
 * possible error codes are listed in {@link android.telephony.mbms.MbmsErrors MbmsErrors}.
 * @param errorCode The error code.
 * Value is {@link android.telephony.mbms.MbmsErrors#ERROR_NO_UNIQUE_MIDDLEWARE}, {@link android.telephony.mbms.MbmsErrors#ERROR_MIDDLEWARE_LOST}, {@link android.telephony.mbms.MbmsErrors#ERROR_MIDDLEWARE_NOT_BOUND}, {@link android.telephony.mbms.MbmsErrors.GeneralErrors#ERROR_MIDDLEWARE_NOT_YET_READY}, {@link android.telephony.mbms.MbmsErrors.GeneralErrors#ERROR_OUT_OF_MEMORY}, {@link android.telephony.mbms.MbmsErrors.GeneralErrors#ERROR_MIDDLEWARE_TEMPORARILY_UNAVAILABLE}, {@link android.telephony.mbms.MbmsErrors.GeneralErrors#ERROR_IN_E911}, {@link android.telephony.mbms.MbmsErrors.GeneralErrors#ERROR_NOT_CONNECTED_TO_HOME_CARRIER_LTE}, {@link android.telephony.mbms.MbmsErrors.GeneralErrors#ERROR_UNABLE_TO_READ_SIM}, or {@link android.telephony.mbms.MbmsErrors.GeneralErrors#ERROR_CARRIER_CHANGE_NOT_ALLOWED}
 * @param message A human-readable message generated by the middleware for debugging purposes.
 
 * This value may be {@code null}.
 * @apiSince 29
 */

public default void onError(int errorCode, @androidx.annotation.Nullable java.lang.String message) { throw new RuntimeException("Stub!"); }

/**
 * Called to indicate this call has changed state.
 *
 * See {@link android.telephony.mbms.GroupCall#STATE_STOPPED GroupCall#STATE_STOPPED}, {@link android.telephony.mbms.GroupCall#STATE_STARTED GroupCall#STATE_STARTED}
 * and {@link android.telephony.mbms.GroupCall#STATE_STALLED GroupCall#STATE_STALLED}.
 
 * @param state Value is {@link android.telephony.mbms.GroupCall#STATE_STOPPED}, {@link android.telephony.mbms.GroupCall#STATE_STARTED}, or {@link android.telephony.mbms.GroupCall#STATE_STALLED}
 
 * @param reason Value is {@link android.telephony.mbms.GroupCall#REASON_BY_USER_REQUEST}, {@link android.telephony.mbms.GroupCall#REASON_FREQUENCY_CONFLICT}, {@link android.telephony.mbms.GroupCall#REASON_OUT_OF_MEMORY}, {@link android.telephony.mbms.GroupCall#REASON_NOT_CONNECTED_TO_HOMECARRIER_LTE}, {@link android.telephony.mbms.GroupCall#REASON_LEFT_MBMS_BROADCAST_AREA}, or {@link android.telephony.mbms.GroupCall#REASON_NONE}
 * @apiSince 29
 */

public default void onGroupCallStateChanged(int state, int reason) { throw new RuntimeException("Stub!"); }

/**
 * Broadcast Signal Strength updated.
 *
 * This signal strength is the BROADCAST signal strength which,
 * depending on technology in play and it's deployment, may be
 * stronger or weaker than the traditional UNICAST signal
 * strength.  It a simple int from 0-4 for valid levels or
 * {@link #SIGNAL_STRENGTH_UNAVAILABLE} if broadcast is not available
 * for this call due to timing, geography or popularity.
 
 * @param signalStrength Value is between -1 and 4 inclusive
 * @apiSince 29
 */

public default void onBroadcastSignalStrengthUpdated(int signalStrength) { throw new RuntimeException("Stub!"); }

/**
 * Indicates broadcast signal strength is not available for this call.
 *
 * This may be due to the call no longer being available due to geography
 * or timing (end of service)
 * @apiSince 29
 */

public static final int SIGNAL_STRENGTH_UNAVAILABLE = -1; // 0xffffffff
}

