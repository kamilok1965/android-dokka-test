/**
 * <p>Provides classes that manage Bluetooth functionality, such as scanning for
 * devices, connecting with devices, and managing data transfer between devices.
 * The Bluetooth API supports both "Classic Bluetooth" and Bluetooth Low Energy.</p>
 *
 * <p>For more information about Classic Bluetooth, see the
 * <a href="{@docRoot}guide/topics/connectivity/bluetooth.html">Bluetooth</a> guide.
 * For more information about Bluetooth Low Energy, see the
 * <a href="{@docRoot}guide/topics/connectivity/bluetooth-le.html">
 * Bluetooth Low Energy</a> (BLE) guide.</p>
 * {@more}
 *
 * <p>The Bluetooth APIs let applications:</p>
 * <ul>
 *   <li>Scan for other Bluetooth devices (including BLE devices).</li>
 *   <li>Query the local Bluetooth adapter for paired Bluetooth devices.</li>
 *   <li>Establish RFCOMM channels/sockets.</li>
 *   <li>Connect to specified sockets on other devices.</li>
 *   <li>Transfer data to and from other devices.</li>
 *   <li>Communicate with BLE devices, such as proximity sensors, heart rate
 *     monitors, fitness devices, and so on.</li>
 *   <li>Act as a GATT client or a GATT server (BLE).</li>
 * </ul>
 *
 * <p>
 * To perform Bluetooth communication using these APIs, an application must
 * declare the {@link android.Manifest.permission#BLUETOOTH} permission. Some
 * additional functionality, such as requesting device discovery,
 * also requires the {@link android.Manifest.permission#BLUETOOTH_ADMIN}
 * permission.
 * </p>
 *
 * <p class="note"><strong>Note:</strong>
 * Not all Android-powered devices provide Bluetooth functionality.</p>
 @apiSince 5
 */

package android.bluetooth;
