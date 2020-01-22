/**
 * <p>Contains the backup and restore functionality available to
 * applications. If a user wipes the data on their device or upgrades to a new Android-powered
 * device, all applications that have enabled backup can restore the user's previous data when the
 * application is reinstalled.</p>
 *
 * <p>For more information, see the <a
 * href="{@docRoot}guide/topics/data/backup.html">Data Backup</a> guide.</p>
 * {@more}
 *
 * <p>All backup and restore operations are controlled by the {@link
 * android.app.backup.BackupManager}. Each application that would
 * like to enable backup and preserve its data on remote storage must implement a
 * backup agent. A backup agent can be built by extending either {@link android.app.backup.BackupAgent}
 * or {@link android.app.backup.BackupAgentHelper}. The {@link
 * android.app.backup.BackupAgentHelper} class provides a wrapper around {@link
 * android.app.backup.BackupAgent} that simplifies the procedures to implement a backup agent by
 * employing backup helpers such as {@link android.app.backup.SharedPreferencesBackupHelper} and
 * {@link android.app.backup.FileBackupHelper}.</p>
 *
 * <p>The backup APIs let applications:</p>
 * <ul>
 *   <li>Perform backup of arbitrary data to remote storage</li>
 *   <li>Easily perform backup of {@link android.content.SharedPreferences} and files</li>
 *   <li>Restore the data saved to remote storage</li>
 * </ul>
 @apiSince 8
 */

package android.app.backup;
