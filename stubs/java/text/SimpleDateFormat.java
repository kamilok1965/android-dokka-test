/*
 * Copyright (C) 2014 The Android Open Source Project
 * Copyright (c) 1996, 2013, Oracle and/or its affiliates. All rights reserved.
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

/*
 * (C) Copyright Taligent, Inc. 1996 - All Rights Reserved
 * (C) Copyright IBM Corp. 1996-1998 - All Rights Reserved
 *
 *   The original version of this source code and documentation is copyrighted
 * and owned by Taligent, Inc., a wholly-owned subsidiary of IBM. These
 * materials are provided under terms of a License Agreement between Taligent
 * and Sun. This technology is protected by multiple US and International
 * patents. This notice and attribution to Taligent may not be removed.
 *   Taligent is a registered trademark of Taligent, Inc.
 *
 */



package java.text;

import java.util.TimeZone;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;
import java.util.Locale;

/**
 * <code>SimpleDateFormat</code> is a concrete class for formatting and
 * parsing dates in a locale-sensitive manner. It allows for formatting
 * (date &rarr; text), parsing (text &rarr; date), and normalization.
 *
 * <p>
 * <code>SimpleDateFormat</code> allows you to start by choosing
 * any user-defined patterns for date-time formatting. However, you
 * are encouraged to create a date-time formatter with either
 * <code>getTimeInstance</code>, <code>getDateInstance</code>, or
 * <code>getDateTimeInstance</code> in <code>DateFormat</code>. Each
 * of these class methods can return a date/time formatter initialized
 * with a default format pattern. You may modify the format pattern
 * using the <code>applyPattern</code> methods as desired.
 * For more information on using these methods, see
 * {@link java.text.DateFormat DateFormat}.
 *
 * <h3>Date and Time Patterns</h3>
 * <p>
 * Date and time formats are specified by <em>date and time pattern</em>
 * strings.
 * Within date and time pattern strings, unquoted letters from
 * <code>'A'</code> to <code>'Z'</code> and from <code>'a'</code> to
 * <code>'z'</code> are interpreted as pattern letters representing the
 * components of a date or time string.
 * Text can be quoted using single quotes (<code>'</code>) to avoid
 * interpretation.
 * <code>"''"</code> represents a single quote.
 * All other characters are not interpreted; they're simply copied into the
 * output string during formatting or matched against the input string
 * during parsing.
 * <p>
 * The following pattern letters are defined (all other characters from
 * <code>'A'</code> to <code>'Z'</code> and from <code>'a'</code> to
 * <code>'z'</code> are reserved):
 * <blockquote>
 * <table border=0 cellspacing=3 cellpadding=0 summary="Chart shows pattern letters, date/time component, presentation, and examples.">
 *     <tr style="background-color: rgb(204, 204, 255);">
 *         <th align=left>Letter
 *         <th align=left>Date or Time Component
 *         <th align=left>Presentation
 *         <th align=left>Examples
 *         <th align=left>Supported (API Levels)
 *     <tr>
 *         <td><code>G</code>
 *         <td>Era designator
 *         <td><a href="#text">Text</a>
 *         <td><code>AD</code>
 *         <td>1+</td>
 *     <tr style="background-color: rgb(238, 238, 255);">
 *         <td><code>y</code>
 *         <td>Year
 *         <td><a href="#year">Year</a>
 *         <td><code>1996</code>; <code>96</code>
 *         <td>1+</td>
 *     <tr>
 *         <td><code>Y</code>
 *         <td>Week year
 *         <td><a href="#year">Year</a>
 *         <td><code>2009</code>; <code>09</code>
 *         <td>24+</td>
 *     <tr style="background-color: rgb(238, 238, 255);">
 *         <td><code>M</code>
 *         <td>Month in year (context sensitive)
 *         <td><a href="#month">Month</a>
 *         <td><code>July</code>; <code>Jul</code>; <code>07</code>
 *         <td>1+</td>
 *     <tr>
 *         <td><code>L</code>
 *         <td>Month in year (standalone form)
 *         <td><a href="#month">Month</a>
 *         <td><code>July</code>; <code>Jul</code>; <code>07</code>
 *         <td>TBD</td>
 *     <tr style="background-color: rgb(238, 238, 255);">
 *         <td><code>w</code>
 *         <td>Week in year
 *         <td><a href="#number">Number</a>
 *         <td><code>27</code>
 *         <td>1+</td>
 *     <tr>
 *         <td><code>W</code>
 *         <td>Week in month
 *         <td><a href="#number">Number</a>
 *         <td><code>2</code>
 *         <td>1+</td>
 *     <tr style="background-color: rgb(238, 238, 255);">
 *         <td><code>D</code>
 *         <td>Day in year
 *         <td><a href="#number">Number</a>
 *         <td><code>189</code>
 *         <td>1+</td>
 *     <tr>
 *         <td><code>d</code>
 *         <td>Day in month
 *         <td><a href="#number">Number</a>
 *         <td><code>10</code>
 *         <td>1+</td>
 *     <tr style="background-color: rgb(238, 238, 255);">
 *         <td><code>F</code>
 *         <td>Day of week in month
 *         <td><a href="#number">Number</a>
 *         <td><code>2</code>
 *         <td>1+</td>
 *     <tr>
 *         <td><code>E</code>
 *         <td>Day name in week
 *         <td><a href="#text">Text</a>
 *         <td><code>Tuesday</code>; <code>Tue</code>
 *         <td>1+</td>
 *     <tr style="background-color: rgb(238, 238, 255);">
 *         <td><code>u</code>
 *         <td>Day number of week (1 = Monday, ..., 7 = Sunday)
 *         <td><a href="#number">Number</a>
 *         <td><code>1</code>
 *         <td>24+</td>
 *     <tr>
 *         <td><code>a</code>
 *         <td>Am/pm marker
 *         <td><a href="#text">Text</a>
 *         <td><code>PM</code>
 *         <td>1+</td>
 *     <tr style="background-color: rgb(238, 238, 255);">
 *         <td><code>H</code>
 *         <td>Hour in day (0-23)
 *         <td><a href="#number">Number</a>
 *         <td><code>0</code>
 *         <td>1+</td>
 *     <tr>
 *         <td><code>k</code>
 *         <td>Hour in day (1-24)
 *         <td><a href="#number">Number</a>
 *         <td><code>24</code>
 *         <td>1+</td>
 *     <tr style="background-color: rgb(238, 238, 255);">
 *         <td><code>K</code>
 *         <td>Hour in am/pm (0-11)
 *         <td><a href="#number">Number</a>
 *         <td><code>0</code>
 *         <td>1+</td>
 *     <tr>
 *         <td><code>h</code>
 *         <td>Hour in am/pm (1-12)
 *         <td><a href="#number">Number</a>
 *         <td><code>12</code>
 *         <td>1+</td>
 *     <tr style="background-color: rgb(238, 238, 255);">
 *         <td><code>m</code>
 *         <td>Minute in hour
 *         <td><a href="#number">Number</a>
 *         <td><code>30</code>
 *         <td>1+</td>
 *     <tr>
 *         <td><code>s</code>
 *         <td>Second in minute
 *         <td><a href="#number">Number</a>
 *         <td><code>55</code>
 *         <td>1+</td>
 *     <tr style="background-color: rgb(238, 238, 255);">
 *         <td><code>S</code>
 *         <td>Millisecond
 *         <td><a href="#number">Number</a>
 *         <td><code>978</code>
 *         <td>1+</td>
 *     <tr>
 *         <td><code>z</code>
 *         <td>Time zone
 *         <td><a href="#timezone">General time zone</a>
 *         <td><code>Pacific Standard Time</code>; <code>PST</code>; <code>GMT-08:00</code>
 *         <td>1+</td>
 *     <tr style="background-color: rgb(238, 238, 255);">
 *         <td><code>Z</code>
 *         <td>Time zone
 *         <td><a href="#rfc822timezone">RFC 822 time zone</a>
 *         <td><code>-0800</code>
 *         <td>1+</td>
 *     <tr>
 *         <td><code>X</code>
 *         <td>Time zone
 *         <td><a href="#iso8601timezone">ISO 8601 time zone</a>
 *         <td><code>-08</code>; <code>-0800</code>;  <code>-08:00</code>
 *         <td>24+</td>
 * </table>
 * </blockquote>
 * Pattern letters are usually repeated, as their number determines the
 * exact presentation:
 * <ul>
 * <li><strong><a name="text">Text:</a></strong>
 *     For formatting, if the number of pattern letters is 4 or more,
 *     the full form is used; otherwise a short or abbreviated form
 *     is used if available.
 *     For parsing, both forms are accepted, independent of the number
 *     of pattern letters.</li>
 * <li><strong><a name="number">Number:</a></strong>
 *     For formatting, the number of pattern letters is the minimum
 *     number of digits, and shorter numbers are zero-padded to this amount.
 *     For parsing, the number of pattern letters is ignored unless
 *     it's needed to separate two adjacent fields.</li>
 * <li><strong><a name="year">Year:</a></strong>
 *     If the formatter's {@link #getCalendar() Calendar} is the Gregorian
 *     calendar, the following rules are applied.
 *     <ul>
 *     <li>For formatting, if the number of pattern letters is 2, the year
 *         is truncated to 2 digits; otherwise it is interpreted as a
 *         <a href="#number">number</a>.
 *     <li>For parsing, if the number of pattern letters is more than 2,
 *         the year is interpreted literally, regardless of the number of
 *         digits. So using the pattern "MM/dd/yyyy", "01/11/12" parses to
 *         Jan 11, 12 A.D.
 *     <li>For parsing with the abbreviated year pattern ("y" or "yy"),
 *         <code>SimpleDateFormat</code> must interpret the abbreviated year
 *         relative to some century.  It does this by adjusting dates to be
 *         within 80 years before and 20 years after the time the <code>SimpleDateFormat</code>
 *         instance is created. For example, using a pattern of "MM/dd/yy" and a
 *         <code>SimpleDateFormat</code> instance created on Jan 1, 1997,  the string
 *         "01/11/12" would be interpreted as Jan 11, 2012 while the string "05/04/64"
 *         would be interpreted as May 4, 1964.
 *         During parsing, only strings consisting of exactly two digits, as defined by
 *         {@link java.lang.Character#isDigit(char) Character#isDigit(char)}, will be parsed into the default century.
 *         Any other numeric string, such as a one digit string, a three or more digit
 *         string, or a two digit string that isn't all digits (for example, "-1"), is
 *         interpreted literally.  So "01/02/3" or "01/02/003" are parsed, using the
 *         same pattern, as Jan 2, 3 AD.  Likewise, "01/02/-3" is parsed as Jan 2, 4 BC.
 *     </ul>
 *     Otherwise, calendar system specific forms are applied.
 *     For both formatting and parsing, if the number of pattern
 *     letters is 4 or more, a calendar specific {@linkplain java.util.Calendar#LONG Calendar#LONG} is used. Otherwise, a calendar
 *     specific {@linkplain java.util.Calendar#SHORT Calendar#SHORT}
 *     is used.
 *     <br>
 *     If week year {@code 'Y'} is specified and the {@linkplain
 *     #getCalendar() calendar} doesn't support any <a
 *     href="../util/GregorianCalendar.html#week_year"> week
 *     years</a>, the calendar year ({@code 'y'}) is used instead. The
 *     support of week years can be tested with a call to {@link java.text.DateFormat#getCalendar() DateFormat#getCalendar()}.{@link
 *     java.util.Calendar#isWeekDateSupported()
 *     isWeekDateSupported()}.</li>
 * <li><strong><a name="month">Month:</a></strong>
 *     If the number of pattern letters is 3 or more, the month is
 *     interpreted as <a href="#text">text</a>; otherwise,
 *     it is interpreted as a <a href="#number">number</a>.
 *     <ul>
 *     <li>Letter <em>M</em> produces context-sensitive month names, such as the
 *         embedded form of names. If a {@code DateFormatSymbols} has been set
 *         explicitly with constructor {@link #SimpleDateFormat(java.lang.String,java.text.DateFormatSymbols)} or method {@link
 *         #setDateFormatSymbols(java.text.DateFormatSymbols)}, the month names given by
 *         the {@code DateFormatSymbols} are used.</li>
 *     <li>Letter <em>L</em> produces the standalone form of month names.</li>
 *     </ul>
 *     <br></li>
 * <li><strong><a name="timezone">General time zone:</a></strong>
 *     Time zones are interpreted as <a href="#text">text</a> if they have
 *     names. For time zones representing a GMT offset value, the
 *     following syntax is used:
 *     <pre>
 *     <a name="GMTOffsetTimeZone"><i>GMTOffsetTimeZone:</i></a>
 *             <code>GMT</code> <i>Sign</i> <i>Hours</i> <code>:</code> <i>Minutes</i>
 *     <i>Sign:</i> one of
 *             <code>+ -</code>
 *     <i>Hours:</i>
 *             <i>Digit</i>
 *             <i>Digit</i> <i>Digit</i>
 *     <i>Minutes:</i>
 *             <i>Digit</i> <i>Digit</i>
 *     <i>Digit:</i> one of
 *             <code>0 1 2 3 4 5 6 7 8 9</code></pre>
 *     <i>Hours</i> must be between 0 and 23, and <i>Minutes</i> must be between
 *     00 and 59. The format is locale independent and digits must be taken
 *     from the Basic Latin block of the Unicode standard.
 *     <p>For parsing, <a href="#rfc822timezone">RFC 822 time zones</a> are also
 *     accepted.</li>
 * <li><strong><a name="rfc822timezone">RFC 822 time zone:</a></strong>
 *     For formatting, the RFC 822 4-digit time zone format is used:
 *
 *     <pre>
 *     <i>RFC822TimeZone:</i>
 *             <i>Sign</i> <i>TwoDigitHours</i> <i>Minutes</i>
 *     <i>TwoDigitHours:</i>
 *             <i>Digit Digit</i></pre>
 *     <i>TwoDigitHours</i> must be between 00 and 23. Other definitions
 *     are as for <a href="#timezone">general time zones</a>.
 *
 *     <p>For parsing, <a href="#timezone">general time zones</a> are also
 *     accepted.
 * <li><strong><a name="iso8601timezone">ISO 8601 Time zone:</a></strong>
 *     The number of pattern letters designates the format for both formatting
 *     and parsing as follows:
 *     <pre>
 *     <i>ISO8601TimeZone:</i>
 *             <i>OneLetterISO8601TimeZone</i>
 *             <i>TwoLetterISO8601TimeZone</i>
 *             <i>ThreeLetterISO8601TimeZone</i>
 *     <i>OneLetterISO8601TimeZone:</i>
 *             <i>Sign</i> <i>TwoDigitHours</i>
 *             {@code Z}
 *     <i>TwoLetterISO8601TimeZone:</i>
 *             <i>Sign</i> <i>TwoDigitHours</i> <i>Minutes</i>
 *             {@code Z}
 *     <i>ThreeLetterISO8601TimeZone:</i>
 *             <i>Sign</i> <i>TwoDigitHours</i> {@code :} <i>Minutes</i>
 *             {@code Z}</pre>
 *     Other definitions are as for <a href="#timezone">general time zones</a> or
 *     <a href="#rfc822timezone">RFC 822 time zones</a>.
 *
 *     <p>For formatting, if the offset value from GMT is 0, {@code "Z"} is
 *     produced. If the number of pattern letters is 1, any fraction of an hour
 *     is ignored. For example, if the pattern is {@code "X"} and the time zone is
 *     {@code "GMT+05:30"}, {@code "+05"} is produced.
 *
 *     <p>For parsing, the letter {@code "Z"} is parsed as the UTC time zone designator (therefore
 *     {@code "09:30Z"} is parsed as {@code "09:30 UTC"}.
 *     <a href="#timezone">General time zones</a> are <em>not</em> accepted.
 *     <p>If the number of {@code "X"} pattern letters is 4 or more (e.g. {@code XXXX}), {@link java.lang.IllegalArgumentException IllegalArgumentException} is thrown when constructing a {@code
 *     SimpleDateFormat} or {@linkplain #applyPattern(java.lang.String) applying a
 *     pattern}.
 * </ul>
 * <code>SimpleDateFormat</code> also supports <em>localized date and time
 * pattern</em> strings. In these strings, the pattern letters described above
 * may be replaced with other, locale dependent, pattern letters.
 * <code>SimpleDateFormat</code> does not deal with the localization of text
 * other than the pattern letters; that's up to the client of the class.
 *
 * <h4>Examples</h4>
 *
 * The following examples show how date and time patterns are interpreted in
 * the U.S. locale. The given date and time are 2001-07-04 12:08:56 local time
 * in the U.S. Pacific Time time zone.
 * <blockquote>
 * <table border=0 cellspacing=3 cellpadding=0 summary="Examples of date and time patterns interpreted in the U.S. locale">
 *     <tr style="background-color: rgb(204, 204, 255);">
 *         <th align=left>Date and Time Pattern
 *         <th align=left>Result
 *     <tr>
 *         <td><code>"yyyy.MM.dd G 'at' HH:mm:ss z"</code>
 *         <td><code>2001.07.04 AD at 12:08:56 PDT</code>
 *     <tr style="background-color: rgb(238, 238, 255);">
 *         <td><code>"EEE, MMM d, ''yy"</code>
 *         <td><code>Wed, Jul 4, '01</code>
 *     <tr>
 *         <td><code>"h:mm a"</code>
 *         <td><code>12:08 PM</code>
 *     <tr style="background-color: rgb(238, 238, 255);">
 *         <td><code>"hh 'o''clock' a, zzzz"</code>
 *         <td><code>12 o'clock PM, Pacific Daylight Time</code>
 *     <tr>
 *         <td><code>"K:mm a, z"</code>
 *         <td><code>0:08 PM, PDT</code>
 *     <tr style="background-color: rgb(238, 238, 255);">
 *         <td><code>"yyyyy.MMMMM.dd GGG hh:mm aaa"</code>
 *         <td><code>02001.July.04 AD 12:08 PM</code>
 *     <tr>
 *         <td><code>"EEE, d MMM yyyy HH:mm:ss Z"</code>
 *         <td><code>Wed, 4 Jul 2001 12:08:56 -0700</code>
 *     <tr style="background-color: rgb(238, 238, 255);">
 *         <td><code>"yyMMddHHmmssZ"</code>
 *         <td><code>010704120856-0700</code>
 *     <tr>
 *         <td><code>"yyyy-MM-dd'T'HH:mm:ss.SSSZ"</code>
 *         <td><code>2001-07-04T12:08:56.235-0700</code>
 *     <tr style="background-color: rgb(238, 238, 255);">
 *         <td><code>"yyyy-MM-dd'T'HH:mm:ss.SSSXXX"</code>
 *         <td><code>2001-07-04T12:08:56.235-07:00</code>
 *     <tr>
 *         <td><code>"YYYY-'W'ww-u"</code>
 *         <td><code>2001-W27-3</code>
 * </table>
 * </blockquote>
 *
 * <h4><a name="synchronization">Synchronization</a></h4>
 *
 * <p>
 * Date formats are not synchronized.
 * It is recommended to create separate format instances for each thread.
 * If multiple threads access a format concurrently, it must be synchronized
 * externally.
 *
 * @see          <a href="https://docs.oracle.com/javase/tutorial/i18n/format/simpleDateFormat.html">Java Tutorial</a>
 * @see          java.util.Calendar
 * @see          java.util.TimeZone
 * @see          java.text.DateFormat
 * @see          java.text.DateFormatSymbols
 * @author       Mark Davis, Chen-Lieh Huang, Alan Liu
 * @apiSince 1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class SimpleDateFormat extends java.text.DateFormat {

/**
 * Constructs a <code>SimpleDateFormat</code> using the default pattern and
 * date format symbols for the default
 * {@link java.util.Locale.Category#FORMAT FORMAT} locale.
 * <b>Note:</b> This constructor may not support all locales.
 * For full coverage, use the factory methods in the {@link java.text.DateFormat DateFormat}
 * class.
 * @apiSince 1
 */

public SimpleDateFormat() { throw new RuntimeException("Stub!"); }

/**
 * Constructs a <code>SimpleDateFormat</code> using the given pattern and
 * the default date format symbols for the default
 * {@link java.util.Locale.Category#FORMAT FORMAT} locale.
 * <b>Note:</b> This constructor may not support all locales.
 * For full coverage, use the factory methods in the {@link java.text.DateFormat DateFormat}
 * class.
 * <p>This is equivalent to calling
 * {@link #SimpleDateFormat(java.lang.String,java.util.Locale)
 *     SimpleDateFormat(pattern, Locale.getDefault(Locale.Category.FORMAT))}.
 *
 * @see java.util.Locale#getDefault(java.util.Locale.Category)
 * @see java.util.Locale.Category#FORMAT
 * @param pattern the pattern describing the date and time format
 * @exception java.lang.NullPointerException if the given pattern is null
 * @exception java.lang.IllegalArgumentException if the given pattern is invalid
 * @apiSince 1
 */

public SimpleDateFormat(java.lang.String pattern) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a <code>SimpleDateFormat</code> using the given pattern and
 * the default date format symbols for the given locale.
 * <b>Note:</b> This constructor may not support all locales.
 * For full coverage, use the factory methods in the {@link java.text.DateFormat DateFormat}
 * class.
 *
 * @param pattern the pattern describing the date and time format
 * @param locale the locale whose date format symbols should be used
 * @exception java.lang.NullPointerException if the given pattern or locale is null
 * @exception java.lang.IllegalArgumentException if the given pattern is invalid
 * @apiSince 1
 */

public SimpleDateFormat(java.lang.String pattern, java.util.Locale locale) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a <code>SimpleDateFormat</code> using the given pattern and
 * date format symbols.
 *
 * @param pattern the pattern describing the date and time format
 * @param formatSymbols the date format symbols to be used for formatting
 * @exception java.lang.NullPointerException if the given pattern or formatSymbols is null
 * @exception java.lang.IllegalArgumentException if the given pattern is invalid
 * @apiSince 1
 */

public SimpleDateFormat(java.lang.String pattern, java.text.DateFormatSymbols formatSymbols) { throw new RuntimeException("Stub!"); }

/**
 * Sets the 100-year period 2-digit years will be interpreted as being in
 * to begin on the date the user specifies.
 *
 * @param startDate During parsing, two digit years will be placed in the range
 * <code>startDate</code> to <code>startDate + 100 years</code>.
 * @see #get2DigitYearStart
 * @since 1.2
 * @apiSince 1
 */

public void set2DigitYearStart(java.util.Date startDate) { throw new RuntimeException("Stub!"); }

/**
 * Returns the beginning date of the 100-year period 2-digit years are interpreted
 * as being within.
 *
 * @return the start of the 100-year period into which two digit years are
 * parsed
 * @see #set2DigitYearStart
 * @since 1.2
 * @apiSince 1
 */

public java.util.Date get2DigitYearStart() { throw new RuntimeException("Stub!"); }

/**
 * Formats the given <code>Date</code> into a date/time string and appends
 * the result to the given <code>StringBuffer</code>.
 *
 * @param date the date-time value to be formatted into a date-time string.
 * @param toAppendTo where the new date-time text is to be appended.
 * @param pos the formatting position. On input: an alignment field,
 * if desired. On output: the offsets of the alignment field.
 * @return the formatted date-time string.
 * @exception java.lang.NullPointerException if the given {@code date} is {@code null}.
 * @apiSince 1
 */

public java.lang.StringBuffer format(java.util.Date date, java.lang.StringBuffer toAppendTo, java.text.FieldPosition pos) { throw new RuntimeException("Stub!"); }

/**
 * Formats an Object producing an <code>AttributedCharacterIterator</code>.
 * You can use the returned <code>AttributedCharacterIterator</code>
 * to build the resulting String, as well as to determine information
 * about the resulting String.
 * <p>
 * Each attribute key of the AttributedCharacterIterator will be of type
 * <code>DateFormat.Field</code>, with the corresponding attribute value
 * being the same as the attribute key.
 *
 * @exception java.lang.NullPointerException if obj is null.
 * @exception java.lang.IllegalArgumentException if the Format cannot format the
 *            given object, or if the Format's pattern string is invalid.
 * @param obj The object to format
 * @return AttributedCharacterIterator describing the formatted value.
 * @since 1.4
 * @apiSince 1
 */

public java.text.AttributedCharacterIterator formatToCharacterIterator(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/**
 * Parses text from a string to produce a <code>Date</code>.
 * <p>
 * The method attempts to parse text starting at the index given by
 * <code>pos</code>.
 * If parsing succeeds, then the index of <code>pos</code> is updated
 * to the index after the last character used (parsing does not necessarily
 * use all characters up to the end of the string), and the parsed
 * date is returned. The updated <code>pos</code> can be used to
 * indicate the starting point for the next call to this method.
 * If an error occurs, then the index of <code>pos</code> is not
 * changed, the error index of <code>pos</code> is set to the index of
 * the character where the error occurred, and null is returned.
 *
 * <p>This parsing operation uses the {@link java.text.DateFormat#calendar DateFormat#calendar} to produce a {@code Date}. All of the {@code
 * calendar}'s date-time fields are {@linkplain java.util.Calendar#clear() Calendar#clear()} before parsing, and the {@code calendar}'s default
 * values of the date-time fields are used for any missing
 * date-time information. For example, the year value of the
 * parsed {@code Date} is 1970 with {@link java.util.GregorianCalendar GregorianCalendar} if
 * no year value is given from the parsing operation.  The {@code
 * TimeZone} value may be overwritten, depending on the given
 * pattern and the time zone value in {@code text}. Any {@code
 * TimeZone} value that has previously been set by a call to
 * {@link #setTimeZone(java.util.TimeZone) setTimeZone} may need
 * to be restored for further operations.
 *
 * @param text  A <code>String</code>, part of which should be parsed.
 * @param pos   A <code>ParsePosition</code> object with index and error
 *              index information as described above.
 * @return A <code>Date</code> parsed from the string. In case of
 *         error, returns null.
 * @exception java.lang.NullPointerException if <code>text</code> or <code>pos</code> is null.
 * @apiSince 1
 */

public java.util.Date parse(java.lang.String text, java.text.ParsePosition pos) { throw new RuntimeException("Stub!"); }

/**
 * Returns a pattern string describing this date format.
 *
 * @return a pattern string describing this date format.
 * @apiSince 1
 */

public java.lang.String toPattern() { throw new RuntimeException("Stub!"); }

/**
 * Returns a localized pattern string describing this date format.
 *
 * @return a localized pattern string describing this date format.
 * @apiSince 1
 */

public java.lang.String toLocalizedPattern() { throw new RuntimeException("Stub!"); }

/**
 * Applies the given pattern string to this date format.
 *
 * @param pattern the new date and time pattern for this date format
 * @exception java.lang.NullPointerException if the given pattern is null
 * @exception java.lang.IllegalArgumentException if the given pattern is invalid
 * @apiSince 1
 */

public void applyPattern(java.lang.String pattern) { throw new RuntimeException("Stub!"); }

/**
 * Applies the given localized pattern string to this date format.
 *
 * @param pattern a String to be mapped to the new date and time format
 *        pattern for this format
 * @exception java.lang.NullPointerException if the given pattern is null
 * @exception java.lang.IllegalArgumentException if the given pattern is invalid
 * @apiSince 1
 */

public void applyLocalizedPattern(java.lang.String pattern) { throw new RuntimeException("Stub!"); }

/**
 * Gets a copy of the date and time format symbols of this date format.
 *
 * @return the date and time format symbols of this date format
 * @see #setDateFormatSymbols
 * @apiSince 1
 */

public java.text.DateFormatSymbols getDateFormatSymbols() { throw new RuntimeException("Stub!"); }

/**
 * Sets the date and time format symbols of this date format.
 *
 * @param newFormatSymbols the new date and time format symbols
 * @exception java.lang.NullPointerException if the given newFormatSymbols is null
 * @see #getDateFormatSymbols
 * @apiSince 1
 */

public void setDateFormatSymbols(java.text.DateFormatSymbols newFormatSymbols) { throw new RuntimeException("Stub!"); }

/**
 * Creates a copy of this <code>SimpleDateFormat</code>. This also
 * clones the format's date format symbols.
 *
 * @return a clone of this <code>SimpleDateFormat</code>
 * @apiSince 1
 */

public java.lang.Object clone() { throw new RuntimeException("Stub!"); }

/**
 * Returns the hash code value for this <code>SimpleDateFormat</code> object.
 *
 * @return the hash code value for this <code>SimpleDateFormat</code> object.
 * @apiSince 1
 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * Compares the given object with this <code>SimpleDateFormat</code> for
 * equality.
 *
 * @return true if the given object is equal to this
 * <code>SimpleDateFormat</code>
 * @apiSince 1
 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }
}

