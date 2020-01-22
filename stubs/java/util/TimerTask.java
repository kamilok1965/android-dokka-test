/*
 * Copyright (c) 1999, 2013, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */



package java.util;


/**
 * A task that can be scheduled for one-time or repeated execution by a Timer.
 *
 * @author  Josh Bloch
 * @see     java.util.Timer
 * @since   1.3
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class TimerTask implements java.lang.Runnable {

/**
 * Creates a new timer task.
 * @apiSince 1
 */

protected TimerTask() { throw new RuntimeException("Stub!"); }

/**
 * The action to be performed by this timer task.
 * @apiSince 1
 */

public abstract void run();

/**
 * Cancels this timer task.  If the task has been scheduled for one-time
 * execution and has not yet run, or has not yet been scheduled, it will
 * never run.  If the task has been scheduled for repeated execution, it
 * will never run again.  (If the task is running when this call occurs,
 * the task will run to completion, but will never run again.)
 *
 * <p>Note that calling this method from within the <tt>run</tt> method of
 * a repeating timer task absolutely guarantees that the timer task will
 * not run again.
 *
 * <p>This method may be called repeatedly; the second and subsequent
 * calls have no effect.
 *
 * @return true if this task is scheduled for one-time execution and has
 *         not yet run, or this task is scheduled for repeated execution.
 *         Returns false if the task was scheduled for one-time execution
 *         and has already run, or if the task was never scheduled, or if
 *         the task was already cancelled.  (Loosely speaking, this method
 *         returns <tt>true</tt> if it prevents one or more scheduled
 *         executions from taking place.)
 * @apiSince 1
 */

public boolean cancel() { throw new RuntimeException("Stub!"); }

/**
 * Returns the <i>scheduled</i> execution time of the most recent
 * <i>actual</i> execution of this task.  (If this method is invoked
 * while task execution is in progress, the return value is the scheduled
 * execution time of the ongoing task execution.)
 *
 * <p>This method is typically invoked from within a task's run method, to
 * determine whether the current execution of the task is sufficiently
 * timely to warrant performing the scheduled activity:
 * <pre>{@code
 *   public void run() {
 *       if (System.currentTimeMillis() - scheduledExecutionTime() >=
 *           MAX_TARDINESS)
 *               return;  // Too late; skip this execution.
 *       // Perform the task
 *   }
 * }</pre>
 * This method is typically <i>not</i> used in conjunction with
 * <i>fixed-delay execution</i> repeating tasks, as their scheduled
 * execution times are allowed to drift over time, and so are not terribly
 * significant.
 *
 * @return the time at which the most recent execution of this task was
 *         scheduled to occur, in the format returned by Date.getTime().
 *         The return value is undefined if the task has yet to commence
 *         its first execution.
 * @see java.util.Date#getTime()
 * @apiSince 1
 */

public long scheduledExecutionTime() { throw new RuntimeException("Stub!"); }
}

