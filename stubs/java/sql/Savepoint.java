/*
 * Copyright (c) 2000, 2005, Oracle and/or its affiliates. All rights reserved.
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



package java.sql;


/**
 * The representation of a savepoint, which is a point within
 * the current transaction that can be referenced from the
 * <code>Connection.rollback</code> method. When a transaction
 * is rolled back to a savepoint all changes made after that
 * savepoint are undone.
 * <p>
 * Savepoints can be either named or unnamed. Unnamed savepoints
 * are identified by an ID generated by the underlying data source.
 *
 * @since 1.4
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public interface Savepoint {

/**
 * Retrieves the generated ID for the savepoint that this
 * <code>Savepoint</code> object represents.
 * @return the numeric ID of this savepoint
 * @exception java.sql.SQLException if this is a named savepoint
 * @since 1.4
 * @apiSince 1
 */

public int getSavepointId() throws java.sql.SQLException;

/**
 * Retrieves the name of the savepoint that this <code>Savepoint</code>
 * object represents.
 * @return the name of this savepoint
 * @exception java.sql.SQLException if this is an un-named savepoint
 * @since 1.4
 * @apiSince 1
 */

public java.lang.String getSavepointName() throws java.sql.SQLException;
}

